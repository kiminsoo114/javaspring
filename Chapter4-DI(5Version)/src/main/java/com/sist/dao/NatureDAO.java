package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.NatureMapper;
import com.sist.vo.NatureVO;
import java.util.*;
//Mapper => DAO => MainClass
/*
	스프링에서 패키지 단위로 클래스 등록
	=> 메모리 할당 요청하는 것
	클래스 위에 Annotation을 올려서 구분을 해줘야한다
	1) Component : 일반 클래스 (MainClass, 웹 크롤링, XML파싱, 데이터 분석)
				   데이터 분석 : AI , data.go.kr (데이터 수집)
	2) Repository : 저장소 (DAO = 데이터베이스 관련)
	3) Service : BI (DAO 여러개를 통합해서 사용)
	-------------------------------------------------웹에서 사용
	4) Controller : Model (요청을 받아서 요청처리 후에 결과값을 전송)
					=> 화면 이동(파일명을 전송)
	5) RestController : Model (요청을 받아서 요청처리 후에 결과값을 전송)
					=> 데이터 전송(Ajax ,VueJS, ReactJS) => JSON
	6) ControllerAdvice : 통합 예외처리
	---------------------
	=> 메모리 할당이 없는 것
*/
@Repository
public class NatureDAO {
@Autowired
private NatureMapper mapper; //자동으로 MyBatis에서 구현된다

public List<NatureVO> natureListData()
{
	return mapper.natureListData();
}
}
