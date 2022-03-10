package com.sotatek.codingTest.controller;

import com.sotatek.codingTest.ApiResponse.ApiResponse;
import com.sotatek.codingTest.model.dto.PostDto;
import com.sotatek.codingTest.model.entity.Post;
import com.sotatek.codingTest.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping(path = "/post")
    public ApiResponse<?> addNewPost (@RequestBody PostDto req) {
        PostDto res = new PostDto();
        try {
            res = postService.save(req);
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.BAD_REQUEST);
        }
        return new ApiResponse<>(HttpStatus.OK, res);
    }

    @GetMapping(path = "/post")
    public ApiResponse<List<PostDto>> getAllPost (@RequestBody(required = false) List<Long> postcodes) {
        List<PostDto> res;
        try {
            if (postcodes != null && postcodes.size() != 0) {
                res = postService.findAllByPostcode(postcodes);
            } else {
                res = postService.findAll();
            }
        } catch (Exception e) {
            return new ApiResponse<>(HttpStatus.BAD_REQUEST);
        }
        return new ApiResponse<List<PostDto>>(HttpStatus.OK, res);
    }

}
