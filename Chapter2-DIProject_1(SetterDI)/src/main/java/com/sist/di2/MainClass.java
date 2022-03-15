package com.sist.di2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*	�����̳� : ��ü ���� = ���� �ʱ�ȭ = ��ü�Ҹ� (��ü�� �����ֱ�) ����
 * 			 1. ��ü ���� : <bean id="" class="">
 * 			 2. ���� �ʱ�ȭ : ������ �̿�
 * 						  <bean id="" class=""
 * 							c: ������="��" (�ƴϸ�) c:_0="��" (�̷��Ե� ���)
 * 
 * 						  setter�� ���� ���� 
 * 						  <bean id="" class=""
 * 							p:������="��">
 * 			 3. �޼ҵ� �ڵ� ȣ��:
 * 				  init-method="" ========> ��ü ���� �� ȣ��
 * 				  destroy-method="" =====> ��ü �Ҹ� �� ȣ��
 * -------------------------------------------------------------------------------
 * 		���� �������� DI (������ ����) �̶�� �Ѵ�.
 * 			= setter DI
 * 			= constructor DI
 * 		    = method DI
 * 	------------------------------------------------------------------------------
 * 		DI�� ����� ���� ��ü �ּҰ� ����, ����Ŭ ���� ����
 * 		���̺귯���� ���� ä���...
 * 		50PAGE ~ 54PAGE
 * 		
 * 
 * 		===> ������ => � Ŭ������ �����ؼ� ������� (VO�ܿ� ������ ��� Ŭ���� ���)
 * 		===> 		  ������ �ʱⰪ ����
 * 					  Ŭ������ Ŭ������ ���� ���� 
 * ------------------------------------------Ŭ������ �����ϱ� ���� �޴��� ����--------------
 * 		XML(4����) , �ڹ�(5����)
 * 
 * 		==> ��ü ����, ���̺귯�� Ŭ������ �� ����	
 * 		----------------------------------MyBatis ���
 * 			=> �ڵ� ���� (@AutoWired)
 * 			=> Ŭ���� �Ѱ��� ���<bean>
 * 			=> ��Ű�� ������ ���( <component-scan> )

*/
public class MainClass {
	public static void main(String[] args) {
		
		  ApplicationContext app= new ClassPathXmlApplicationContext("app2.xml");
		  Sawon sa=(Sawon)app.getBean("sa");
		  
		  GenericXmlApplicationContext app1=
				  new GenericXmlApplicationContext("app2.xml");
		  Sawon sa1=(Sawon)app1.getBean("sa");
		  app1.close();
	}
}