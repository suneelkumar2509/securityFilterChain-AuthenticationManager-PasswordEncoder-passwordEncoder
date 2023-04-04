package com.springbootsunilblog.springbootsunilblog.convector;

import org.springframework.stereotype.Component;

import com.springbootsunilblog.springbootsunilblog.DTO.PostDTO;
import com.springbootsunilblog.springbootsunilblog.model.Post;

@Component
public class Postconvector {

public PostDTO posttopostdtoconverter (Post poss) {
	PostDTO postdto = new PostDTO();
	postdto.setTitle(poss.getTitle());
	postdto.setDescription(poss.getDescription());
	postdto.setContent(poss.getContent());
	return postdto;
	
}
	

public Post ostdtotopostconverter (PostDTO postdto) {
	Post posst= new Post();
	posst.setTitle(postdto.getTitle());
	posst.setDescription(postdto.getDescription());
	posst.setContent(postdto.getContent());
	
return posst;

}	
	
	
	
	
	
	
	

}
