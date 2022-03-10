package com.sotatek.codingTest.model.entity;

import com.sotatek.codingTest.model.dto.PostDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "suburb_name")
    private String suburbName;
    @Column(name = "postcode")
    private Long postcode;

    public Post (PostDto req) {
        this.suburbName = req.getSuburbName();
        this.postcode = req.getPostcode();
    }
}
