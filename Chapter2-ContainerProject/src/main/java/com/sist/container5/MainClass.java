package com.sist.container5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
	AnnotationConfingApplicationContext : �ڹٷ� ��ϵ� ���
	ApplicationContext : XML�� Ŭ���� ��Ͻÿ�

*/
public class MainClass {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext app=
					new AnnotationConfigApplicationContext(SawonConfig.class);
		
		Sawon sa=(Sawon)app.getBean("sa"); //object�� �ҷ������⶧���� ����ȯ�� ���־���Ѵ�.
		// Sawon sa=app.getBean("sa",Sawon.class) �� ����
		sa.setName("�ڹ���");
		sa.setDept("���ߺ�");
		sa.setLoc("����");
		
		System.out.println("�̸�:"+sa.getName());
		System.out.println("�μ�:"+sa.getDept());
		System.out.println("�ٹ���:"+sa.getLoc());
		
		Sawon sa1=(Sawon)app.getBean("sa"); //object�� �ҷ������⶧���� ����ȯ�� ���־���Ѵ�.
		// Sawon sa=app.getBean("sa",Sawon.class) �� ����
		sa1.setName("�̼���");
		sa1.setDept("�ѹ���");
		sa1.setLoc("�λ�");
		System.out.println("========sa1========");
		System.out.println("�̸�:"+sa1.getName());
		System.out.println("�μ�:"+sa1.getDept());
		System.out.println("�ٹ���:"+sa1.getLoc());
		System.out.println("========sa========");
		System.out.println("�̸�:"+sa.getName());
		System.out.println("�μ�:"+sa.getDept());
		System.out.println("�ٹ���:"+sa.getLoc());
	}
	}



