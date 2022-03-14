package com.sist.mapper;
//메모리 할당이 안됨! => 구현만 요청

import org.apache.ibatis.annotations.Select;

import com.sist.vo.LocationVO;

import java.util.*;
public interface LocationMapper {
	@Select("SELECT title,address,msg FROM seoul_location")
	public List<LocationVO> locationListData();//구현 완료 
}
