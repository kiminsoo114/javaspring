package com.sist.di2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;


public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		BooksDAO dao=(BooksDAO)app.getBean("dao2");
		List<BooksVO> list=dao.booksListData();
		for(BooksVO vo:list)
		{
			System.out.println(vo.getTitle()+" "
					+vo.getAuthor()+" "
					+vo.getPrice());
		}
		
	}
}
