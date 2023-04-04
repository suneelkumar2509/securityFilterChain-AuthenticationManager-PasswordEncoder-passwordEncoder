package com.springbootsunilblog.springbootsunilblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootsunilblog.springbootsunilblog.model.Comment;


public interface CommentRepository extends JpaRepository<Comment, Long>{

}
