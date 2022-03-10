package com.sotatek.codingTest.service;

import com.sotatek.codingTest.model.dto.PostDto;

import java.util.List;

public interface PostService {
    PostDto save(PostDto req);

    PostDto findById (Long postcode) throws Exception;

    List<PostDto> findAll();

    String remove(Long id);

    PostDto update(Long id, PostDto req) throws Exception;

    List<PostDto> findAllByPostcode(List<Long> postcodes);
}
