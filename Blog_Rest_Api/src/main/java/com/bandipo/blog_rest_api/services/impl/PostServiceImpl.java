package com.bandipo.blog_rest_api.services.impl;

import com.bandipo.blog_rest_api.model.Post;
import com.bandipo.blog_rest_api.repositories.PostRepository;
import com.bandipo.blog_rest_api.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void deletePost(Post post1) {
          postRepository.delete(post1);
    }
}
