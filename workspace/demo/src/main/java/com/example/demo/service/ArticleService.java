package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.demo.dto.Article;
import com.example.demo.dto.UserDTO;

public interface ArticleService {
	
	public List<ArrayList> getVue(Map<String, Object> param);
	
	public List<ArrayList> getHeader(Map<String, Object> param);
	
	public List<ArrayList> getData(Map<String, Object> param);
	
	public List<ArrayList> getList();

	public long add(Map<String, Object> param);

	public int getTotalCount();

	public Article getOne(long id);

	public void delete(long id);

	public void modify(Map<String, Object> param);

	public void hitUp(long id);

	List<ArrayList> getData();
}
