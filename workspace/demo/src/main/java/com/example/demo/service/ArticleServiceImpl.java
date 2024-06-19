package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Article;
import com.example.demo.dto.ArticleDao;
import com.example.demo.dto.UserDTO;
import com.example.demo.util.CUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	ArticleDao articleDao;

	
	
	// 이제 ArticleService는 데이터 관련해서는 모두 Dao에게 위임
	
	@Override
	public List<ArrayList> getVue(Map<String, Object> param) {
		return articleDao.getVue(param) ;
	}
	
	
	@Override
	public List<ArrayList> getHeader(Map<String, Object> param) {
		return articleDao.getHeader(param) ;
	}
	
	
	@Override
	public List<ArrayList> getData(Map<String, Object> param) {
		return articleDao.getData(param) ;
	}
	

	@Override
	public List<ArrayList> getList() {
		return articleDao.getList();
	}

	@Override
	public long add(Map<String, Object> param) {
		articleDao.add(param);

		return CUtil.getAsLong(param.get("id"));
	}

	@Override
	public int getTotalCount() {
		return articleDao.getTotalCount();
	}

	@Override
	public Article getOne(long id) {
		return articleDao.getOne(id);
	}

	@Override
	public void delete(long id) {
		articleDao.delete(id);
	}

	@Override
	public void modify(Map<String, Object> param) {
		articleDao.modify(param);
	}

	@Override
	public void hitUp(long id) {
		articleDao.hitUp(id);
	}


	@Override
	public List<ArrayList> getData() {
		// TODO Auto-generated method stub
		return null;
	}
}
