package com.bandipo.blog_rest_api.repositories;

import com.bandipo.blog_rest_api.model.Comment;
import com.bandipo.blog_rest_api.model.CommentLike;
import com.bandipo.blog_rest_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentLikeRepository extends JpaRepository<CommentLike,Long> {
    CommentLike findCommentLikeByCommentAndUser(Comment comment, User user);
    List<CommentLike> findCommentLikeByComment(Comment comment);
}
