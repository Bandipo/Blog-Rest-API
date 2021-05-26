package com.bandipo.blog_rest_api.repositories;

import com.bandipo.blog_rest_api.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepostory extends JpaRepository<Comment, Long> {

}
