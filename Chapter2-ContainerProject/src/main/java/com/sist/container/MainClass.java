package com.sist.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
	스프링
	1. 관리 대상 클래스를 XML에 등록
	   ------------ 
	   	~VO를 제외한 모든 클래스는 스프링에서 관리(기능)
	   	--- 기능이 아니라 데이터형(프로그래머가 관리)
	2. 스프링에서 사용자가 등록한 클래스를 어떤 클래스에서 관리하는지 여부 
			   -----------------  ----------------------- (컨테이너)
			   	 스프링에서 지원하는 컨테이너 클래스
			   	 	BeanFactory
			   	 		|
			   	 --------------------
			   	 |					|
			ApplicationContext     AnnotationConfigApplicationContext
				(core => 클래스 등록, DI)+AOP			
				(4~5 => XML)								|	
				(4~5 => Annotation)
			
				|
			WebApplicationContext(MVC)
			=> 컨테이너에 등록하는 방식 두가지
				1) XML (4)
				2) 자바로 등록(5) ==> Spring -Boot
				
*/
public class MainClass {
	public static void main(String[] args) {
		
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		// => 파싱(XML을 읽어서 등록된 클래스의 메모리 할당이 완료)
		// 2. 프로그램에 필요한 객체를 얻어서 사용
		Sawon s=(Sawon)app.getBean("sa"); //객체 생성, 소멸 담당
		// 변수에 대한 초기값 담당(DI)
		s.setName("홍길동");
		s.setDept("개발부");
		s.setJob("사원");
		
		System.out.println("이름 : "+s.getName());
		System.out.println("부서 : "+s.getDept());
		System.out.println("직위 : "+s.getJob());
		
		// Singleton(싱글턴) => 메모리를 한개만 생성 => 재사용해서 사용
		// 3. 객체를 얻어 온다
		// 4. 객체 요청시 마다 따라 메모리를 저장할 때 : scope="prototype"
		Sawon s1=(Sawon)app.getBean("sa"); //필요시마다 스프링에 등록된 클래스를 얻어와서 쓴다
		s1.setName("심청이");
		s1.setDept("기획부");
		s1.setJob("대리");
		System.out.println("s="+s);
		System.out.println("s1="+s1);
		System.out.println("이름 : "+s1.getName());
		System.out.println("부서 : "+s1.getDept());
		System.out.println("직위 : "+s1.getJob());
				
		System.out.println("이름 : "+s.getName());
		System.out.println("부서 : "+s.getDept());
		System.out.println("직위 : "+s.getJob());
		
	}
}