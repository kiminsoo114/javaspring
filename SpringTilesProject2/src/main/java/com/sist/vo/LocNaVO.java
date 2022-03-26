package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
NO	NUMBER	No		1	
NAME	VARCHAR2(100 BYTE)	No		2	
SCORE	NUMBER(2,1)	Yes		3	
ADDRESS	VARCHAR2(300 BYTE)	No		4	
POSTER	VARCHAR2(4000 BYTE)	No		5	
IMAGES	VARCHAR2(4000 BYTE)	Yes		6	
*/
@Setter
@Getter
public class LocNaVO {
	private int no;
	private double score;
	private String name,address,poster,images;
}
