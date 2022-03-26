package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.sist.mapper.LocationMapper;
import com.sist.vo.LocNaVO;


public class LocationDAO {
	@Autowired
	private LocationMapper mapper;
	public List<LocNaVO> locationFindData(Map map)
	{
		return mapper.locationFindData(map);
	}
	
	public int loationFindTotalPage(String address)
	{
		return mapper.loationFindTotalPage(address);
	}
	public LocNaVO locationDetailData(int no)
	{
		return mapper.locationDetailData(no);
	}
	
}
