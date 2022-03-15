package com.sist.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
	������
	1. ���� ��� Ŭ������ XML�� ���
	   ------------ 
	   	~VO�� ������ ��� Ŭ������ ���������� ����(���)
	   	--- ����� �ƴ϶� ��������(���α׷��Ӱ� ����)
	2. ���������� ����ڰ� ����� Ŭ������ � Ŭ�������� �����ϴ��� ���� 
			   -----------------  ----------------------- (�����̳�)
			   	 ���������� �����ϴ� �����̳� Ŭ����
			   	 	BeanFactory
			   	 		|
			   	 --------------------
			   	 |					|
			ApplicationContext     AnnotationConfigApplicationContext
				(core => Ŭ���� ���, DI)+AOP			
				(4~5 => XML)								|	
				(4~5 => Annotation)
			
				|
			WebApplicationContext(MVC)
			=> �����̳ʿ� ����ϴ� ��� �ΰ���
				1) XML (4)
				2) �ڹٷ� ���(5) ==> Spring -Boot
				
*/
public class MainClass {
	public static void main(String[] args) {
		
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		// => �Ľ�(XML�� �о ��ϵ� Ŭ������ �޸� �Ҵ��� �Ϸ�)
		// 2. ���α׷��� �ʿ��� ��ü�� �� ���
		Sawon s=(Sawon)app.getBean("sa"); //��ü ����, �Ҹ� ���
		// ������ ���� �ʱⰪ ���(DI)
		s.setName("ȫ�浿");
		s.setDept("���ߺ�");
		s.setJob("���");
		
		System.out.println("�̸� : "+s.getName());
		System.out.println("�μ� : "+s.getDept());
		System.out.println("���� : "+s.getJob());
		
		// Singleton(�̱���) => �޸𸮸� �Ѱ��� ���� => �����ؼ� ���
		// 3. ��ü�� ��� �´�
		// 4. ��ü ��û�� ���� ���� �޸𸮸� ������ �� : scope="prototype"
		Sawon s1=(Sawon)app.getBean("sa"); //�ʿ�ø��� �������� ��ϵ� Ŭ������ ���ͼ� ����
		s1.setName("��û��");
		s1.setDept("��ȹ��");
		s1.setJob("�븮");
		System.out.println("s="+s);
		System.out.println("s1="+s1);
		System.out.println("�̸� : "+s1.getName());
		System.out.println("�μ� : "+s1.getDept());
		System.out.println("���� : "+s1.getJob());
				
		System.out.println("�̸� : "+s.getName());
		System.out.println("�μ� : "+s.getDept());
		System.out.println("���� : "+s.getJob());
		
	}
}