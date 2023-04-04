package com.springbootsunilblog.springbootsunilblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootsunilblog.springbootsunilblog.model.Post;


@Repository
public interface postRepository extends JpaRepository<Post, Long>{

}
