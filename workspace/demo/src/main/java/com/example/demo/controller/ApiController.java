package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.dto.ResultDTO;
import com.example.demo.service.ArticleService;
import lombok.extern.slf4j.Slf4j;


@CrossOrigin(origins = "http://localhost:8800" )
@RestController
@Slf4j // 이걸 해야 log.info(..) 가 가능, 디버깅 용도
public class ApiController {
    
	private ResultDTO rDto;
	
	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/ApiCall")	
	public Map<String, Object> ApiCall(@RequestParam Map<String, Object> params) {	
		
	
		//String url = "http://localhost:8014/itf/sap/orderList" ;		
		//String url = "https://catfact.ninja/fact?max_length=140" ;
		
		//String url = "http://localhost:8071/findAll" ;
		
       // Map<String, Object> params = new HashMap<>();
		
		//params.put("max_length","140");		
		//params.put("audatHigh","2024-06-18");
		
		rDto = new ResultDTO();	
				
		
		if(params.isEmpty() || params.get("url") == null)
		{
			rDto.setMessage("url 확인") ;
			rDto.setResult(null);
			rDto.setState(false);
			
			return (Map<String, Object>) rDto ; 
		}
		else
		{
			String url = params.get("url").toString() ;
						
			WebClient.Builder builder = WebClient.builder() ; 			
			
			Map<String, Object> result = builder.build()
					.get()
					.uri(url)
					.retrieve()
					.bodyToMono(new ParameterizedTypeReference<Map<String,Object>>(){})
					.block();		
			
			return result ; 
		}
		
		 
		/*
		  rDto = new ResultDTO();		    
		    
	    if(resultList != null){
	        rDto.setMessage("success");
	    	rDto.setState(true);
	        rDto.setResult(resultList);
	    } else {
	    	rDto.setMessage("fail");
	        rDto.setState(false);
	        rDto.setResult("");
	    }
	    
		return rDto;  */		
	}
	
}
