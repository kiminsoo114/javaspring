package com.sist.web;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.SeoulHotelDAO;
import com.sist.dao.SeoulHotelVO;

@RestController
public class SeoulRestController {
	@Autowired
	private SeoulHotelDAO dao;

	@GetMapping(value = "hotel/list.do", produces = "text/plain;charset=utf-8")
	public String hotel_list(int page, Model model) {

		Map map = new HashedMap();
		int rowSize = 9;
		int start = (rowSize * page) - (rowSize - 1);
		int end = rowSize * page;
		map.put("start", start);
		map.put("end", end);

		List<SeoulHotelVO> list = dao.hotelListData(map);
		int totalpage = dao.hotelTotalPage();

		JSONArray arr = new JSONArray(); // list
		int i = 0;
		for (SeoulHotelVO vo : list) {
			JSONObject obj = new JSONObject(); // vo
			obj.put("no", vo.getNo());
			obj.put("poster", vo.getPoster());
			obj.put("name", vo.getName());
			if (i == 0) {
				obj.put("curpage", page);
				obj.put("totalpage", totalpage);
			}
			arr.add(obj);
			i++;
		}

		System.out.println(arr.toJSONString());
		return arr.toJSONString();
	}
	//List ==> JSONArray
	//VO => JSONObject
	@GetMapping(value = "hotel/detail.do",produces = "text/plain;charset=utf-8")
	public String hotel_detail(int no)
	{
		SeoulHotelVO vo=dao.hotelDetailData(no);
		JSONObject obj=new JSONObject();
		obj.put("no",vo.getNo());
		obj.put("name",vo.getName());
		obj.put("score",vo.getScore());
		obj.put("address",vo.getAddress());
		obj.put("poster",vo.getPoster());
		obj.put("images",vo.getImages());
		return obj.toJSONString();
	}
}