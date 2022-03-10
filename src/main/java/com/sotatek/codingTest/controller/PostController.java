package com.sotatek.codingTest.controller;

import com.sotatek.codingTest.model.dto.PostDto;
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
    public ResponseEntity<PostDto> addNewPost (@RequestBody PostDto req) {
        PostDto res = postService.save(req);
        return new ResponseEntity<PostDto>(res, HttpStatus.OK);
    }

    @GetMapping(path = "/post-detail")
    public ResponseEntity<PostDto> getPost (@RequestBody Long id) throws Exception {
        PostDto res = postService.findById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping(path = "/post")
    public ResponseEntity<List<PostDto>> getAllPost (@RequestBody(required = false) List<Long> postcodes) {
        List<PostDto> res;
        if (postcodes != null && postcodes.size() != 0) {
            res = postService.findAllByPostcode(postcodes);
        } else {
            res = postService.findAll();
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping(path = "/post")
    public ResponseEntity<PostDto> updatePost (@RequestBody Long id, @RequestBody PostDto req) throws Exception {
        PostDto res = postService.update(id, req);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @DeleteMapping(path = "/post")
    public ResponseEntity<?> deletePost (@RequestBody Long id) {
        String res = postService.remove(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
