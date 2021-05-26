package com.bandipo.blog_rest_api.services;

import com.bandipo.blog_rest_api.model.Post;

import java.util.Optional;

public interface PostService {

    void addPost(Post post);

    Optional<Post> getPostById(Long id);

    void deletePost(Post post1);
}
