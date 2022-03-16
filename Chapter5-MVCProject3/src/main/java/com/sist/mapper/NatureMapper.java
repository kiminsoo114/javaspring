package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface NatureMapper {
  @Select("SELECT no,title,poster,num "
		 +"FROM (SELECT no,title,poster,rownum as num "
		 +"FROM (SELECT /*+ INDEX_ASC(seoul_nature sl_no_pk)*/ no,title,poster "
		 +"FROM seoul_nature)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<NatureVO> natureListData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/20.0) FROM seoul_nature")
  public int natureTotalPage();
  
  @Select("SELECT * FROM seoul_nature "
		 +"WHERE no=#{no}")
  public NatureVO natureDetailData(int no);
}