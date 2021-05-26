package com.bandipo.blog_rest_api.services;

import com.bandipo.blog_rest_api.model.Post;
import com.bandipo.blog_rest_api.model.PostLike;
import com.bandipo.blog_rest_api.model.User;

import java.util.Collection;
import java.util.List;

public interface PostLikeService {
    PostLike getByPostAndUser(Post post, User user);

    void addPostLike(PostLike postLike);

    void deletePostLike(PostLike like);


    List<PostLike> getAllPostLikeByPost(Post post);
}
