package com.springbootsunilblog.junittest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springbootsunilblog.springbootsunilblog.model.Post;
import com.springbootsunilblog.springbootsunilblog.repository.postRepository;

@SpringBootTest
public class junittesting {
	@Autowired
	private postRepository postRepository;
	
	
	    @Test
	    public void givenPostObject_whenSave_thenReturnSavedpost(){

	        //given - precondition or setup
	        Post pos =new  Post();
	        		pos.setTitle("sunil post");
	        		pos .setDescription("hiii wellcom");
	        		pos.setContent("hi this is sunil wellcoming all");
	        		
	        // when - action or the behaviour that we are going test
	        		Post savedpost = postRepository.save(pos);

	        // then - verify the output
	        assertThat(savedpost).isNotNull();
	        assertThat(savedpost.getId()).isGreaterThan(0);
	    }
	 
	 
	   // @Test
	    public void givenEmployeeObject_whenDelete_thenRemoveEmployee(){
	        // given - precondition or setup
	    	Post pos =new  Post();
    		pos.setTitle("sunil post");
    		pos .setDescription("hiii wellcom");
    		pos.setContent("hi this is sunil wellcoming all");
    		Post savedpost = postRepository.save(pos);

	        // when -  action or the behaviour that we are going test
    		postRepository.deleteById(pos.getId());
	        Optional<Post> postlist = postRepository.findById(pos.getId());

	        // then - verify the output
	        assertThat(postlist).isEmpty();
	    }
	

}
