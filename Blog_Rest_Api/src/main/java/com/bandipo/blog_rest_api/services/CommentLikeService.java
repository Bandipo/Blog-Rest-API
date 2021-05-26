package com.bandipo.blog_rest_api.services;

import com.bandipo.blog_rest_api.model.Comment;
import com.bandipo.blog_rest_api.model.CommentLike;
import com.bandipo.blog_rest_api.model.User;

import java.util.Collection;
import java.util.List;

public interface CommentLikeService {
    CommentLike getByCommentAndUser(Comment comment, User user);

    void addCommentLike(CommentLike commentLike);

    void deleteCommentLike(CommentLike like);


    List<CommentLike> getAllCommentLikesByComment(Comment comment);
}
