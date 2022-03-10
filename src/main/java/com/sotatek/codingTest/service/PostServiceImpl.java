package com.sotatek.codingTest.service;

import com.sotatek.codingTest.model.dto.PostDto;
import com.sotatek.codingTest.model.entity.Post;
import com.sotatek.codingTest.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto save(PostDto postDto) {
        Post newPost = new Post(postDto);
        postDto = postDto.toPostDto(newPost);
        return postDto;
    }

    @Override
    public List<PostDto> findAll() {
        List<PostDto> postDtoList = new ArrayList<>();
        postRepository.findAll().stream().forEach(post -> {
            PostDto postDto = new PostDto();
            postDto = postDto.toPostDto(post);
            postDtoList.add(postDto);
        });
        return postDtoList;
    }

    @Override
    public List<PostDto> findAllByPostcode(List<Long> postcodes) {
        List<Post> postList = postRepository.findByPostcodeInOrderBySuburbNameAsc(postcodes);
        List<PostDto> postDtoList = new ArrayList<>();
        postList.stream().forEach(post -> {
            PostDto postDto = new PostDto();
            postDto = postDto.toPostDto(post);
            postDtoList.add(postDto);
        });
        return postDtoList;
    }

}
