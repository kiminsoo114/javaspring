package com.sist.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
//공통 모듈 => OOP VS AOP(OOP에서 할수없는 기능 보완)
//중복 코딩을 제거
// 스프링이란, 컨테이너란..
//VUE VS React의 차이점
//Spring Framework VS Spring Boot
/*
	1. JoinPoint : 호출 시점 
		@Before
		@After
		@After-Returning
		@After-Throwing
		@Around
		=>1) 중복의 제거 (OOP에서는 불가능) => Callback을 만들 수 없다
									  =========
								   	시스템에 의해서 자동호출되는 것
			OOP는 무조건 공통으로 사용하는 기능을 메소드로 모아 놓고
			메소드 호출이 되어야 사용이 가능(자동 호출(X))
			
		  2) 소스를 간결하게 만들면서 핵심 기능만 코딩이 가능하게 만든다
			
		
		public String display() => ponitCut
		{
			@Before => getConnection()
			try
			{
				@Around	=> setAutoCommit(false)
				---------
				핵심 코딩
				---------
				@Around => commit
				
			}catch(Exception ex)
			{
				ex.printStackTrace() : @AfterThrowing
								=> rollback()
				=> 1. 트랜잭션 , 2. 보안 (인증  , 인지)
				=> 보통 (빅데이터 분석, AI)
						1. @Before => 크롤링
						2. After => 크롤링 종료
						3. AfterReturning => 시각화
				=> alert를 출력한다
			}
			finally
			{
				@After => disConnection()
				disConnection();
				
			}
			return ""; => @AfterReturning
		}
	2. PointCut : 타켓 ( 어떤 메소드 )
	------------ +
	3. Advice       joinpoint,pointcut을 합친것이 Advice
	------------
	4. Aspect		Advice여러개를 합친것이 Aspect
	5. 위빙 : 메소드를 통합하는 기능
*/
@Aspect
@Component
public class FoodAspect {
	//Controller에 있는 모든 메소드에서 적용을 하겠다는 의미
  @Around("execution(* com.sist.web.*Controller.*(..))")
  public Object around(ProceedingJoinPoint jp)
  {
	  Object obj=null;
	  // 트랜잭션, 로그 (시간)
	  try
	  {
		  long start = System.currentTimeMillis();
		  System.out.println("메소드 실행시작전:"+jp.getSignature());
		  obj=jp.proceed(); //메소드 호출
		  System.out.println("메소드 수행 종료");
		  long end = System.currentTimeMillis();
		  System.out.println("메소드 수행 시간:"+(end-start));
	  }catch(Throwable ex)
	  {
		  
	  }
	  return obj;
  }
}
