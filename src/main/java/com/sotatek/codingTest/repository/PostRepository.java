package com.sotatek.codingTest.repository;

import com.sotatek.codingTest.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByPostcodeInOrderBySuburbNameAsc(List<Long> postcodes);

}
