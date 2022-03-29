package com.sist.service;

import java.util.List;
import java.util.Map;
import com.sist.vo.*;
import com.sist.mapper.*;

//관련된 DAO를 모아서 처리
public interface FoodService {

	public List<FoodVO> categoryFoodListData(int cno);
	public FoodVO foodDetailData(Map map);
	public List<FoodVO> foodFindData(Map map);
	public List<CategoryVO> categoryListData();
	public CategoryVO categoryInfoData(int cno);
	public int foodFindTotalpge(String address);
	public List<RecipeVO> recipeTypeData(String type);
}
