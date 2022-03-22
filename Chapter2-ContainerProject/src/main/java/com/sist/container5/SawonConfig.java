package com.sist.container5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
// 스프링 5 => 클래스 등록시에 XML을 사용하는 것이 아니라 순수하게 자바로만 사용
// 보안 => XML(노출가능) => 자바는 컴파일된 파일만 제공(소스노출이 안됨)
// => 교재 스프링 5 
// 실무(유지보수 => 4버전) , 차세대 개발(5버전)
@Configuration
// 스프링 5 => 클래스를 등록하는 파일 
public class SawonConfig {
	/*
	 * 		<bean id="sa" class="com.sist.container.Sawon" scope="prototype"></bean>
	*/
	@Bean("sa") // id 
	@Scope("prototype")	//여러개 사용이 가능(메모리 주소값은 항상 동일) , 결국엔 한개만 사용
	// XML과 마찬가지로 생략하면 singleton이 default이다
	public Sawon sawon(){
		return new Sawon(); //class
	}
}