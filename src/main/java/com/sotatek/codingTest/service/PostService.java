package com.sotatek.codingTest.service;

import com.sotatek.codingTest.model.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto save(PostDto req);

    List<PostDto> findAll();

    List<PostDto> findAllByPostcode(List<Long> postcodes);
}
