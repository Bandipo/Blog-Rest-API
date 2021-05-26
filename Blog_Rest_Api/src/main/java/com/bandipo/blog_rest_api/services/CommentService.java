package com.bandipo.blog_rest_api.services;

import com.bandipo.blog_rest_api.model.Comment;

import java.util.Optional;

public interface CommentService {
    void addComment(Comment comment);

    Optional<Comment> getCommentById(Long commentId);

    void deleteComment(Comment comment1);
}
