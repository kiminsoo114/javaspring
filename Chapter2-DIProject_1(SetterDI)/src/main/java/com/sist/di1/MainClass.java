package com.sist.di1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//°ª ÁÖÀÔ ¹æ¹ý => setXxx(), »ý¼ºÀÚ()
public class MainClass {
	
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app1.xml");
		Sawon s1=(Sawon)app.getBean("s1");
		s1.display();
		System.out.println("===========");		
		s1=(Sawon)app.getBean("s2");
		s1.display();
		System.out.println("===========");		
		s1=(Sawon)app.getBean("s3");
		s1.display();
		System.out.println("===========");		
		s1=(Sawon)app.getBean("s4");
		s1.display();
		System.out.println("===========");		
	}
}