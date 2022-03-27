package com.sist.web;

import com.sist.dao.StudentDAO;

public class MainClass {

		public static void main(String[] args) {
			StudentDAO dao=new StudentDAO();
			//dao.studentInsert();
			dao.txInsert();
			System.out.println("successsss");
		}
}
