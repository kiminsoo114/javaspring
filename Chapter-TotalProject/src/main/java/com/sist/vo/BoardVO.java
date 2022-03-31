package com.sist.vo;
import java.util.*;
//CURD 공부과정
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardVO {
	private int no,hit;
	private String name,subject,content,pwd,dbday;
	private Date regdate;
}
