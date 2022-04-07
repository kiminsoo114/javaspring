package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//VO => Mapper => DAO => Controller => JSP
public class FoodVO {
	private int no,good,soso,bad;
	private double score;
	private String poster,name,address,tel,type,price,parking,time,menu;
}
