package com.springbootsunilblog.springbootsunilblog.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springbootsunilblog.springbootsunilblog.DTO.CommentDTO;
import com.springbootsunilblog.springbootsunilblog.exception.ResourceNotFoundException;
import com.springbootsunilblog.springbootsunilblog.model.Comment;
import com.springbootsunilblog.springbootsunilblog.model.Post;
import com.springbootsunilblog.springbootsunilblog.repository.CommentRepository;
import com.springbootsunilblog.springbootsunilblog.repository.postRepository;
@Service
public class CommentService {
	
	
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CommentRepository commentrepo;
	@Autowired
	private postRepository postrepo;
	
	public CommentDTO addcomment(long postid ,CommentDTO commentdto)throws ResourceNotFoundException {
		Post post =postrepo.findById(postid).orElseThrow(()-> new ResourceNotFoundException("post not found for this id  " + postid));
		
		Comment comment=modelMapper.map(commentdto, Comment.class);
		
		comment.setPost(post);
		
		Comment addcomment =commentrepo.save(comment);
		
		
		return modelMapper.map(addcomment, CommentDTO.class);

	}
	
	
	 public List<CommentDTO>  getallcomment(int pageno ,int psgesize, String sortby,String sortdrc){
	    	Sort sort =sortdrc.equalsIgnoreCase(Sort.Direction.ASC.name())?
	    			Sort.by(sortby).ascending():Sort.by(sortby).descending();
	    	
	    	Pageable pag = PageRequest.of(pageno, psgesize, sort);
	  
	    	Page<Comment>allcommentlist =this.commentrepo.findAll(pag);
	    	List<CommentDTO>allpostdtolist = allcommentlist.stream()
	    			.map((Comment)-> modelMapper
	    			.map(Comment, CommentDTO.class)).collect(Collectors.toList());
	    		
			return allpostdtolist;
	    	
	    }
		
	

	 
	
	

}
