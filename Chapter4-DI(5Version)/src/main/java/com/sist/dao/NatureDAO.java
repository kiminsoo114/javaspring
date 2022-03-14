package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.NatureMapper;
import com.sist.vo.NatureVO;
import java.util.*;
//Mapper => DAO => MainClass
/*
	���������� ��Ű�� ������ Ŭ���� ���
	=> �޸� �Ҵ� ��û�ϴ� ��
	Ŭ���� ���� Annotation�� �÷��� ������ ������Ѵ�
	1) Component : �Ϲ� Ŭ���� (MainClass, �� ũ�Ѹ�, XML�Ľ�, ������ �м�)
				   ������ �м� : AI , data.go.kr (������ ����)
	2) Repository : ����� (DAO = �����ͺ��̽� ����)
	3) Service : BI (DAO �������� �����ؼ� ���)
	-------------------------------------------------������ ���
	4) Controller : Model (��û�� �޾Ƽ� ��ûó�� �Ŀ� ������� ����)
					=> ȭ�� �̵�(���ϸ��� ����)
	5) RestController : Model (��û�� �޾Ƽ� ��ûó�� �Ŀ� ������� ����)
					=> ������ ����(Ajax ,VueJS, ReactJS) => JSON
	6) ControllerAdvice : ���� ����ó��
	---------------------
	=> �޸� �Ҵ��� ���� ��
*/
@Repository
public class NatureDAO {
@Autowired
private NatureMapper mapper; //�ڵ����� MyBatis���� �����ȴ�

public List<NatureVO> natureListData()
{
	return mapper.natureListData();
}
}
