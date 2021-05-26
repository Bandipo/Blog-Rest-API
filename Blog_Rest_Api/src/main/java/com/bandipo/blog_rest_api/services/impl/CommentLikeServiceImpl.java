package com.bandipo.blog_rest_api.services.impl;

import com.bandipo.blog_rest_api.model.Comment;
import com.bandipo.blog_rest_api.model.CommentLike;
import com.bandipo.blog_rest_api.model.User;
import com.bandipo.blog_rest_api.repositories.CommentLikeRepository;
import com.bandipo.blog_rest_api.services.CommentLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentLikeServiceImpl implements CommentLikeService {
    @Autowired
    CommentLikeRepository commentLikeRepository;
    @Override
    public CommentLike getByCommentAndUser(Comment comment, User user) {
        return commentLikeRepository.findCommentLikeByCommentAndUser(comment, user);
    }

    @Override
    public void addCommentLike(CommentLike commentLike) {
        commentLikeRepository.save(commentLike);
    }

    @Override
    public void deleteCommentLike(CommentLike like) {
        commentLikeRepository.delete(like);

    }

    @Override
    public List<CommentLike> getAllCommentLikesByComment(Comment comment) {
        return commentLikeRepository.findCommentLikeByComment(comment);
    }

//    @Override
//    public List<CommentLike> getAllByCommentLikesByComment(Comment comment) {
//        return commentLikeRepository.findCommentLikeByComment(comment);
//    }
}
