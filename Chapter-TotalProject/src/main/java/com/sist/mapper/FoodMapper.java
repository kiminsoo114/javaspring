package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;
import org.apache.ibatis.annotations.Select;
/*
	오라클
	SQL
		=DML
			SELECT: 데이터 검색
			 => 내장 함수 (SUBSTR, RPAD,NVL,CEIL)
			 => 연산자 (LIKE, IS NULL, IS NOT NULL, NOT,
			 		  BETWEEN, IN)
			 => JOIN / SubQuery
			 => View(인라인 뷰)
			INSERT
			UPDATE
			DELETE
		=DDL : table (제약조건) , view , sequence
		=DCL : DBA들이 쓴다
		=TCL : COMMIT/ ROLLBACK
		
		웹프로그래머들이 주로 쓰는 것은 DML / TCL 
		= 대신 간단한 테이블 정도는 만들줄 알아야한다
		
		JSP : 지시자(page,taglib) , 내장객체(request,response,session,cookie)
		JSTL / EL / MVC동작과정
		Spring : DI, AOP , MVC , ORM (mybatis/jpa)
		
		Front : Jquery, Ajax, VueJS, ReactJS
		
		AWS : 클라우드(배포) => 운영체제를 빌려서 사용 (웹 호스팅)

*/
public interface FoodMapper {

	@Select("SELECT no,cno,poster,name,tel,type,address,score "
			+ "FROM food_house "
			+ "WHERE cno=#{cno}")
	public List<FoodVO> categoryFoodListData(int cno);
	//food_house , food_location
	/*	name=#{name} => 홍길동 => '홍길동'
	 *  name=${name} => 홍길동 => 홍길동 ==> 일반 데이터값이 아니라 테이블명이나 컬럼명
	
	*	FROM 'food_location' 이렇게 한적없음 따라서 $를 써줘야하는거임
	*/
	@Select("SELECT no,poster,name,tel,type,address,score,"
			+ "time,parking,menu "
			+ "FROM ${table_name} "
			+ "WHERE no=#{no}")
	public FoodVO foodDetailData(Map map);
	//sql문장에 두개이상의 ?가 들어가있는 경우에는 Map으로 값을 준다(mapper에서)
	/*
		ORDER BY no DESC => INDEX_DESC() 274page에서 나온다
		ORDER BY no ASC  => INDEX_ASC()
		UNIQUE / PK => 자동으로 인덱스가 생성된다 
	*/
	@Select("SELECT no,poster,name,num "
			+ "FROM(SELECT no,poster,name,rownum as num "
			+ "FROM(SELECT /*+ INDEX_ASC(food_location fl_no_pk)*/no,poster,name "
			+ "FROM food_location "
			+ "WHERE address LIKE'%'||#{address}||'%')) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	 public List<FoodVO> foodFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM food_location "
			+ "WHERE address LIKE '%'||#{address}||'%'")
	public int foodFindTotalpage(String address);
	
	@Select("SELECT no,poster,title,rownum "
			+ "FROM recipe "
			+ "WHERE REGEXP_LIKE(title,#{type}) "
			+ "AND rownum <=7")
	public List<RecipeVO> recipeTypeData(String type);
}