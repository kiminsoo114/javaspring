package com.sist.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//lombok은 getter,setter뿐만아니라 생성자도 만들어준다
@Setter
@Getter
@AllArgsConstructor
//매개변수가 있는 생성자
@NoArgsConstructor
//default생성자 
public class CategoryVO {
	private int cno;
	private String title,subject,poster,link;
}
