package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.mapper.LocationMapper;
import com.sist.vo.LocationVO;

import java.util.*;
//DAO VS Service(차이점)
//OOP VS AOP (차이점)
//DI가 뭐냐
//JDBC VS ORM 차이점이 뭐냐
//스프링을 정석으로 구현
@Service
public class LocationServiceImpl implements LocationService {

		@Autowired
		private LocationMapper mapper;
		@Override
		public List<LocationVO>locationListData(){
			return mapper.locationListData();
		}
}
