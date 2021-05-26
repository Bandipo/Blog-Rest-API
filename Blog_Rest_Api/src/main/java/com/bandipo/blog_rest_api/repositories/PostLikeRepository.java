package com.bandipo.blog_rest_api.repositories;

import com.bandipo.blog_rest_api.model.Post;
import com.bandipo.blog_rest_api.model.PostLike;
import com.bandipo.blog_rest_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike,Long> {
    PostLike getPostLikeByPostAndUser(Post post, User user);

    List<PostLike> getPostLikeByPost(Post post);
}
