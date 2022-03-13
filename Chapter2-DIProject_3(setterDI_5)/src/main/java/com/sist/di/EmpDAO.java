package com.sist.di;

import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;
public class EmpDAO extends SqlSessionDaoSupport {
	public List<EmpVO> empListData()
	{
		return getSqlSession().selectList("empListData");
		//¿­°í / ´Ý±â
	}
}