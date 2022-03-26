package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.LocNaVO;

/*NO
NAME
SCORE
ADDRESS
POSTER
IMAGES
*/
public interface LocationMapper {
	@Select("SELECT no,name,poster,num "
			+ "FROM(SELECT no,name,poster,rownum as num "
			+ "FROM(SELECT /*+ INDEX ASC(seoul_location sl_no_pk)*/ no,name,poster "
			+ "FROM seoul_location "
			+ "WHERE address LIKE '%'||#{address}}||'%')) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<LocNaVO> locationFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0 FROM seoul_location "
			+ "WHERE address LIKE '%'||#{address}||'%'")
	public int loationFindTotalPage(String address);
	
	@Select("SELECT no,name,score,address,poster,images "
			+ "FROM seoul_location "
			+ "WHERE no=#{no}")
	public LocNaVO locationDetailData(int no);
}
