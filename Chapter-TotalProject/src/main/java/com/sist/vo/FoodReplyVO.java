package com.sist.vo;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FoodReplyVO {
	private int no,fno,group_id,group_step,group_tab,root,depth;
	private String id,name,msg,dbday;
	private Date regdate;
}
