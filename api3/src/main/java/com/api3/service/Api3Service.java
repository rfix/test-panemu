package com.api3.service;

import com.api3.dto.PostDto;
import com.api3.dto.PostResponse;
import com.api3.entity.Post;
import com.api3.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Api3Service {

    @Autowired
    private PostRepository postRepository;

    public void savePost(List<PostDto> postDtoList) {
        postDtoList.forEach(postDto -> postRepository.save(
                Post.builder()
                        .id(postDto.getId())
                        .userId(postDto.getUserId())
                        .title(postDto.getTitle())
                        .body(postDto.getBody())
                        .build()
        ));
    }
    public List<PostDto> getPostByUserId(Long userId) {
        List<Post> posts = postRepository.findByUserId(userId);
        return posts.stream().map(this::toPostDto).toList();
    }
    private PostDto toPostDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .userId(post.getUserId())
                .title(post.getTitle())
                .body(post.getBody())
                .build();
    }

}
