package com.bandipo.blog_rest_api.controllers;

import com.bandipo.blog_rest_api.model.Comment;
import com.bandipo.blog_rest_api.model.CommentLike;
import com.bandipo.blog_rest_api.model.Post;
import com.bandipo.blog_rest_api.model.User;
import com.bandipo.blog_rest_api.services.impl.CommentLikeServiceImpl;
import com.bandipo.blog_rest_api.services.impl.CommentServiceImpl;
import com.bandipo.blog_rest_api.services.impl.PostServiceImpl;
import com.bandipo.blog_rest_api.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
   UserServiceImpl userService;

    @Autowired
    PostServiceImpl postService;

    @Autowired
    CommentServiceImpl commentService;

    @Autowired
    CommentLikeServiceImpl commentLikeService;



    //Create new comment
    @PostMapping(path = "/{postId}/{userId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createComment(@PathVariable(name = "postId") Long postId,
                                           @PathVariable(name = "userId") Long userId,
                                           @Validated @RequestBody Comment comment) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            Optional<Post> post1 = postService.getPostById(postId);
            if (post1.isPresent()) {
                comment.setUser(user.get());
                comment.setPost(post1.get());
                commentService.addComment(comment);
                return new ResponseEntity<>("Comment is made ", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("oops Not a registered User",HttpStatus.BAD_REQUEST);
    }


    //Get a comment for a post
    @GetMapping( "/{postId}/{commentId}")
    public ResponseEntity<Comment> getComment(@PathVariable(name = "commentId") Long commentId) {
        Optional<Comment> comment = commentService.getCommentById(commentId);
        return comment.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }


    //Edit comment
    @PutMapping("/{userId}/{commentId}")
    public ResponseEntity<?> updateComment(@PathVariable(name = "userId") Long userId, @PathVariable(name = "commentId") Long commentId, @Validated @RequestBody Comment updateComment) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            Optional<Comment> comment = commentService.getCommentById(commentId);
            if (comment.isPresent()) {
                Comment comment1 = comment.get();

                if (comment1.getUser().getId() == (userId)) {
                    comment1.setText(updateComment.getText());
                    commentService.addComment(comment1);
                    return new ResponseEntity<>(HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    //Delete comment
    @DeleteMapping("/{userId}/{commentId}")
    public ResponseEntity<Post> deleteComment(@PathVariable(name = "userId") Long userId, @PathVariable(name = "commentId") Long commentId, @Validated @RequestBody Comment updateComment) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            Optional<Comment> comment = commentService.getCommentById(commentId);
            if (comment.isPresent()) {
                Comment comment1 = comment.get();
                if (comment1.getUser().getId() == (userId)) {
                    commentService.deleteComment(comment1);
                    return new ResponseEntity<>(HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }


    //Like a post
    @PostMapping(path = "/{commentId}/{userId}")
    public ResponseEntity<?> likeComment(@PathVariable(name = "commentId") Long commentId, @PathVariable(name = "userId") Long userId) {
        Optional<User> user = userService.getUserById(userId);
        Optional<Comment> comment = commentService.getCommentById(commentId);
        if (user.isPresent()) {
            if (comment.isPresent()) {
                CommentLike like = commentLikeService.getByCommentAndUser(comment.get(), user.get());
                if (like == null) {
                    CommentLike commentLike = new CommentLike();
                    commentLike.setComment(comment.get());
                    commentLike.setUser(user.get());
                    commentLikeService.addCommentLike(commentLike);
                    return new ResponseEntity<>("Comment Liked",HttpStatus.OK);
                } else {
                    commentLikeService.deleteCommentLike(like);
                    return new ResponseEntity<>("Comment Unliked",HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    // Get number of likes for a comment
    @GetMapping( "/{commentId}/likes")
    public ResponseEntity<?> getCommentLikes(@PathVariable(name = "commentId") Long id) {
        Optional<Comment> comment = commentService.getCommentById(id);
        if (comment.isPresent()) {
            int size = commentLikeService.getAllCommentLikesByComment(commentService.getCommentById(id).get()).size();
            return new ResponseEntity<>(size, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
