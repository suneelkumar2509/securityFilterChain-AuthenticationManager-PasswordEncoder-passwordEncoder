package com.springbootsunilblog.springbootsunilblog.service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.springbootsunilblog.springbootsunilblog.DTO.CovidDTO;
import com.springbootsunilblog.springbootsunilblog.DTO.PostDTO;
import com.springbootsunilblog.springbootsunilblog.DTO.StringDTO;
import com.springbootsunilblog.springbootsunilblog.DTO.UserDTO;
import com.springbootsunilblog.springbootsunilblog.exception.Blogexeceptionhandler;
import com.springbootsunilblog.springbootsunilblog.exception.ResourceNotFoundException;
import com.springbootsunilblog.springbootsunilblog.model.Post;
import com.springbootsunilblog.springbootsunilblog.repository.postRepository;

@Service
public class postService {
	@Autowired
	private postRepository repo;
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private  RestTemplate resttemplate;
	
	

	public PostDTO addpost(PostDTO possdto) {
		Post posst = modelMapper.map(possdto, Post.class);
		PostDTO savedpostDto = null;
		Post savedpost = null;
		try {
			savedpost = repo.save(posst);

		} catch (Exception e) {
			throw new Blogexeceptionhandler("post allready existed");
		}
		savedpostDto = modelMapper.map(savedpost, PostDTO.class);
		return savedpostDto;

	}
	
	
	//
	public void deletepost(Long Id) throws ResourceNotFoundException {
		Post po = repo.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("post not found for this id  " + Id));
		repo.delete(po);
		repo.deleteById(Id);

	}

	public Post updatepost(Post poss) {
		return repo.save(poss);
	}

	public boolean existingpost(Long Id) {

		return repo.existsById(Id);
	}
	
	
    public List<PostDTO>  getallpost(){
    	List<Post>allpostlist =this.repo.findAll();
    	List<PostDTO>allpostdtolist = allpostlist.stream()
    			.map((Post)-> this.modelMapper
    			.map(Post, PostDTO.class)).collect(Collectors.toList());
    		
		return allpostdtolist;
    	
    }
	
	
    
    
    public List<PostDTO>  getallpost(int pageno ,int psgesize, String sortby,String sortdrc){
    	Sort sort =sortdrc.equalsIgnoreCase(Sort.Direction.ASC.name())?
    			Sort.by(sortby).ascending():Sort.by(sortby).descending();
    	
    	Pageable pag = PageRequest.of(pageno, psgesize, sort);
  
    	Page<Post>allpostlist =this.repo.findAll(pag);
    	List<PostDTO>allpostdtolist = allpostlist.stream()
    			.map((Post)-> modelMapper
    			.map(Post, PostDTO.class)).collect(Collectors.toList());
    		
		return allpostdtolist;
    	
    }
	
//	@Value("${api}")
//	private String api = "https://api.covidtracking.com/v1/us/daily.json";

	public CovidDTO[] getcoviddata() {
	 String api=null;
	 api = "https://api.covidtracking.com/v1/us/daily.json";

		CovidDTO[] Coviddtoo = resttemplate.getForObject(api, CovidDTO[].class);

		return Coviddtoo;

	}
	
	
	public StringDTO stringtojson() {
		
		
		
		return null;
		
	}
	
	
	 public List<PostDTO> getrestdata() {
		 String api=null;
		 
		 api = "https://api.covidtracking.com/v1/us/daily.json";
 
		 PostDTO[] Coviddtoo = resttemplate.getForObject(api, PostDTO[].class);
			DefaultHttpClient httpClient = new DefaultHttpClient();
	HttpGet getRequest = new HttpGet(api);
	getRequest.addHeader("accept", "application/json");
	HttpResponse response;
	try {
		response = httpClient.execute(getRequest);
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					
					
					
			   + response.getStatusLine().getStatusCode());
		}

		BufferedReader br = new BufferedReader(
                         new InputStreamReader((response.getEntity().getContent())));
		
		
		String output;
		StringBuffer response1 = new StringBuffer();
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			
			response1.append(output);
			
		}
		br.close();

		// print result
	//	System.out.println(response1.toString());
		
		
		 Gson g = new Gson(); 
		 Coviddtoo =g.fromJson(response1.toString(), PostDTO[].class);
		 
		 System.out.println(Coviddtoo);
		 

		httpClient.getConnectionManager().shutdown();
		
		
	} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return Arrays.asList(Coviddtoo);
}
	public UserDTO alluser(String username,String password) {

		return null;
		
	}
	 
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


