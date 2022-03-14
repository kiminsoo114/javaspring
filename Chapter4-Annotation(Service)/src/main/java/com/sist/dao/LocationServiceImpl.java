package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.mapper.LocationMapper;
import com.sist.vo.LocationVO;

import java.util.*;
//DAO VS Service(������)
//OOP VS AOP (������)
//DI�� ����
//JDBC VS ORM �������� ����
//�������� �������� ����
@Service
public class LocationServiceImpl implements LocationService {

		@Autowired
		private LocationMapper mapper;
		@Override
		public List<LocationVO>locationListData(){
			return mapper.locationListData();
		}
}
