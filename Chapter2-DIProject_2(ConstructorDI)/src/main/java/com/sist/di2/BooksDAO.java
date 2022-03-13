package com.sist.di2;

import java.util.*;
import org.mybatis.spring.support.SqlSessionDaoSupport;
public class BooksDAO extends SqlSessionDaoSupport {
	/*
		SqlSession session=null;
		session=ssf.openSession() 	== getSqlsession()
	*/
	public List<BooksVO> booksListData()
	{	
		
		return getSqlSession().selectList("booksListData");
	}
	
}
