package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StdDAO {
	@Autowired
	private StdMapper mapper;
	
	public List<StdVO> stdListData()
	{
		return mapper.stdListData();
	}
	
	public void stdInsert(StdVO vo)
	{
		mapper.stdInsert(vo);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	//Propagation.REQUIRED (처음에는 생성) - 다시 실행시에는 생성없이 Transaction
	//Propagation.REQUIRED_NEW (수행마다 트랜잭션을 새로 생성)
	//AOP => 새로운 클래스를 만들어서 대신 호출(Proxy)
	//Target => 클래스를 읽어와서 => 다른 클래스 대신 후 호출
	public void txInsert()
	{
		StdVO vo=new StdVO();
		vo.setNo(4);
		vo.setName("을지문덕");
		vo.setKor(80);
		vo.setEng(90);
		vo.setMath(78);
		stdInsert(vo);
		
		vo=new StdVO();
		vo.setNo(5);
		vo.setName("강감찬");
		vo.setKor(80);
		vo.setEng(90);
		vo.setMath(78);
		stdInsert(vo);
		
		vo=new StdVO();
		vo.setNo(6);
		vo.setName("이순신");
		vo.setKor(80);
		vo.setEng(90);
		vo.setMath(78);
		stdInsert(vo);
	}
}
