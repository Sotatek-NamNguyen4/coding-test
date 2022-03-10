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
    public PostDto findById(Long id) throws Exception {
        Post getPost = postRepository.findById(id).orElseThrow(() -> new Exception("Post detail not found"));
        PostDto postDto = new PostDto();
        return postDto.toPostDto(getPost);
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
        List<Post> postList = postRepository.findByPostcodeInOrderBySuburbName(postcodes);
        List<PostDto> postDtoList = new ArrayList<>();
        postList.stream().forEach(post -> {
            PostDto postDto = new PostDto();
            postDto = postDto.toPostDto(post);
            postDtoList.add(postDto);
        });
        return postDtoList;
    }

    @Override
    public PostDto update(Long id, PostDto req) throws Exception {
            Post getPost = postRepository.findById(id).orElseThrow(() -> new Exception("Post detail not found"));
            getPost.setSuburbName(req.getSuburbName());
            getPost.setPostcode(req.getPostcode());
            postRepository.save(getPost);
            return new PostDto().toPostDto(getPost);

    }

    @Override
    public String remove(Long id) {
        try {
            Post deletePost = postRepository.findById(id).orElseThrow(() -> new Exception("Post detail not found"));
            postRepository.delete(deletePost);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Delete successfully";
    }

}
