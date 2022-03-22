package com.sist.container5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
	AnnotationConfingApplicationContext : 자바로 등록된 경우
	ApplicationContext : XML로 클래스 등록시에
*/
public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext app=
					new AnnotationConfigApplicationContext(SawonConfig.class);
		
		Sawon sa=(Sawon)app.getBean("sa"); //object로 불려져오기때문에 형변환을 해주어야한다.
		// Sawon sa=app.getBean("sa",Sawon.class) 도 가능
		sa.setName("박문수");
		sa.setDept("개발부");
		sa.setLoc("서울");
		
		System.out.println("이름:"+sa.getName());
		System.out.println("부서:"+sa.getDept());
		System.out.println("근무지:"+sa.getLoc());
		
		Sawon sa1=(Sawon)app.getBean("sa"); //object로 불려져오기때문에 형변환을 해주어야한다.
		// Sawon sa=app.getBean("sa",Sawon.class) 도 가능
		sa1.setName("이순신");
		sa1.setDept("총무부");
		sa1.setLoc("부산");
		System.out.println("========sa1========");
		System.out.println("이름:"+sa1.getName());
		System.out.println("부서:"+sa1.getDept());
		System.out.println("근무지:"+sa1.getLoc());
		System.out.println("========sa========");
		System.out.println("이름:"+sa.getName());
		System.out.println("부서:"+sa.getDept());
		System.out.println("근무지:"+sa.getLoc());
	}
	}

