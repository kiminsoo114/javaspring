package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.LocationMapper;
import com.sist.vo.LocationVO;

@Repository
public class LocationDAO {
	@Autowired
	private LocationMapper mapper;
	/*
	@Select("SELECT no,poster,msg,address,num "
			+ "FROM(SELECT no,poster,msg,address,rownum as num "
			+ "FROM(SELECT /*+ INDEX_ASC(seoul_location sl_no_pk) no,name,poster,address "
			+ "FROM seoul_location))"
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<LocationVO> locationListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM seoul_location")
	public int locationTotalPage();
	
	@Select("SELECT no,poster,msg,address "
			+ "FROM seoul_location "
			+ "WHERE no=#{no}")
	public LocationVO locationDetailData(int no);

	*/
	
	public List<LocationVO> locationListData(Map map){
		return mapper.locationListData(map);
	}
	public int locationTotalPage() {
		return mapper.locationTotalPage();
	}
	public LocationVO locationDetailData(int no)
	{
		return mapper.locationDetailData(no);
	}
	
}
