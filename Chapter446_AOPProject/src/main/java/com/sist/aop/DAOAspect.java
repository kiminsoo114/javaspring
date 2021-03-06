package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect//공통 모듈이라는 뜻 => 메모리 할당이 안되는 어노테이션
@Component//메모리 할당
//클래스위에 어노테이션있다고 무조건 다 메모리할당되는 것은 아니다.
//Callback => 시스템의 자동호출이 가능 (AOP) => struts (인터셉트)
public class DAOAspect {
	@Before("execution(* com.sist.main.MyDAO.*(..))")
	//				  ---
	//				return형 (리턴형은 어떤것이든 상관없다)
	//				*(..) => * 은 메소드명 (모든 메소드란 의미)
	//				(int,String....)
	//				(..) => 매개변수(X) , 매개변수의 데이터형, 갯수 상관없이 사용...
	//				모든 메소드
	public void before()
	{
		System.out.println("오라클 연결");
	}
	@After("execution(* com.sist.main.MyDAO.*(..))")
	public void after()
	{
		System.out.println("오라클 해제");
	}
}
