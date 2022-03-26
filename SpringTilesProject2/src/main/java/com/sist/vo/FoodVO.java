package com.sist.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodVO {
	private int no;
	private String poster,name,address,tel,type,price,parking,time,menu;
	private double score;
}
