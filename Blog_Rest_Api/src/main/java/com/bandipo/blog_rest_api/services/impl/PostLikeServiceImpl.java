package com.bandipo.blog_rest_api.services.impl;

import com.bandipo.blog_rest_api.model.Post;
import com.bandipo.blog_rest_api.model.PostLike;
import com.bandipo.blog_rest_api.model.User;
import com.bandipo.blog_rest_api.repositories.PostLikeRepository;
import com.bandipo.blog_rest_api.services.PostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostLikeServiceImpl implements PostLikeService {

    @Autowired
    PostLikeRepository postLikeRepository;

    @Override
    public PostLike getByPostAndUser(Post post, User user) {
        return postLikeRepository.getPostLikeByPostAndUser(post,user);
    }

    @Override
    public void addPostLike(PostLike postLike) {
        postLikeRepository.save(postLike);
    }

    @Override
    public void deletePostLike(PostLike like) {
        postLikeRepository.delete(like);
    }

    @Override
    public List<PostLike> getAllPostLikeByPost(Post post) {
        return postLikeRepository.getPostLikeByPost(post);
    }


}
