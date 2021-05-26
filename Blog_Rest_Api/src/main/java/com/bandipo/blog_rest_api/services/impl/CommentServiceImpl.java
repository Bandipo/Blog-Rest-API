package com.bandipo.blog_rest_api.services.impl;

import com.bandipo.blog_rest_api.model.Comment;
import com.bandipo.blog_rest_api.repositories.CommentRepostory;
import com.bandipo.blog_rest_api.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepostory commentRepostory;

    @Override
    public void addComment(Comment comment) {
        commentRepostory.save(comment);
    }

    @Override
    public Optional<Comment> getCommentById(Long commentId) {
        return commentRepostory.findById(commentId);
    }

    @Override
    public void deleteComment(Comment comment1) {
        commentRepostory.delete(comment1);
    }
}
