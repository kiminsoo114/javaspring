package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	public List<FoodVO> categoryFoodListData(int cno)
	{
		return mapper.categoryFoodListData(cno);
	}
	public FoodVO foodDetailData(Map map)
	{
		return mapper.foodDetailData(map);
	}
	public List<FoodVO> foodFindData(Map map)
	{
		return mapper.foodFindData(map);
	}
	public int foodFindTotalpge(String address)
	{
		return mapper.foodFindTotalpage(address);
	}
	public List<RecipeVO> recipeTypeData(String type)
	{
		return mapper.recipeTypeData(type);
	}
	
}
