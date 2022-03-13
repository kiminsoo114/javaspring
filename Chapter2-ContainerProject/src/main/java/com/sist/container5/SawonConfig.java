package com.sist.container5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
// ������ 5 => Ŭ���� ��Ͻÿ� XML�� ����ϴ� ���� �ƴ϶� �����ϰ� �ڹٷθ� ���
// ���� => XML(���Ⱑ��) => �ڹٴ� �����ϵ� ���ϸ� ����(�ҽ������� �ȵ�)
// => ���� ������ 5 
// �ǹ�(�������� => 4����) , ������ ����(5����)
@Configuration
// ������ 5 => Ŭ������ ����ϴ� ���� 
public class SawonConfig {
	/*
	 * 		<bean id="sa" class="com.sist.container.Sawon" scope="prototype"></bean>
	*/
	@Bean("sa") // id 
	@Scope("prototype")	//������ ����� ����(�޸� �ּҰ��� �׻� ����) , �ᱹ�� �Ѱ��� ���
	// XML�� ���������� �����ϸ� singleton�� default�̴�
	public Sawon sawon(){
		return new Sawon(); //class
	}
}
