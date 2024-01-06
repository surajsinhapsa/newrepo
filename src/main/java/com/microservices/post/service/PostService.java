package com.microservices.post.service;

import com.microservices.post.entity.Post;
import com.microservices.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findPostById(String postId) {
         Post post = postRepository.findById(postId).get();
         return post;
    }

    public Post savePost(Post post){
        String postId = UUID.randomUUID().toString();
        post.setId(postId);
        Post savepost = postRepository.save(post);
        return savepost;
    }

}
