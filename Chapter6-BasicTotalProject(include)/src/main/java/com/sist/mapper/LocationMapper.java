package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.HotelVO;
import com.sist.vo.LocationVO;

public interface LocationMapper {

	
	@Select("SELECT no,title,poster,msg,address,num "
			+ "FROM (SELECT no,title,poster,msg,address,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(seoul_location sl_no_pk) */ no,title,poster,msg,address "
			+ "FROM seoul_location))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<LocationVO> locationListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM seoul_location")
	public int locationTotalPage();
	
	@Select("SELECT no,title,poster,msg,address "
			+ "FROM seoul_location "
			+ "WHERE no=#{no}")
	public LocationVO locationDetailData(int no);
}
