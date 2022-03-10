package com.sotatek.codingTest.model.dto;

import com.sotatek.codingTest.model.entity.Post;
import lombok.Data;

@Data
public class PostDto {
    private Long id;
    private String suburbName;
    private Long postcode;

    public PostDto toPostDto (Post post) {
        this.id = post.getId();
        this.suburbName = post.getSuburbName();
        this.postcode = post.getPostcode();
        return this;
    }
}
