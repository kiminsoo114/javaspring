package com.sist.web;
import java.util.*;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;
import com.sist.vo.*;
import com.sist.service.*;
@RestController
public class FoodReplyRestController {
	//문제 => Singleton에 대한 설명 => 스프링에서 사용하고 있는 패턴을 아는대로 대라
	//싱글턴, 팩토리 패턴(클래스를 모아서 내가 요구한대로 생성해주는 것),
	//어뎁터패턴(클래스가 여러개인데 형변환통일할때 사용) => HandlerAdapter
	//프록시패턴(대리자) : 위빙, 옵저버(이벤트 발생시 서버에 알려주는 역할) ...
	@Autowired
	private FoodReplyDAO dao;
	@Autowired
	private FoodService service; //FoodController에도 존재 (같은 객체)
	//싱글턴 => 싱글턴 패턴(static)
	//결과값만 보내는 상태 => Rest , 객체(JSON)
	//Spring-Boot => 자동으로 JSON처리 (jackson-bind) => react/redux => 웹스톰(nodejs)
	//스프링 => 자바(jdk)
	@PostMapping("food/login_ok.do")
	public String food_login_ok(String id, String pwd,HttpSession session)
	{
		//1.정보받기
		String result=dao.isLogin(id, pwd);
		if(!(result.equals("NOID")&&result.equals("NOPWD")))
		{
			// 로그인이  된 상태
			session.setAttribute("id", id);
			session.setAttribute("name", result);
		}
		return result;
	}
	//axios.get , axios.post => find/vue/1/강남 => PathValiable
	@GetMapping(value="food/find_vue.do",produces = "text/plain;charset=utf-8")
	public String find_vue(int page, String ss)
	{
		int curpage=page;
		Map map=new HashMap();
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1); //rownum = 1번부터 (오라클)
		//MySql => rownum 0번부터 시작
		int end=(rowSize*curpage);
		map.put("start", start);
		map.put("end", end);
		map.put("address", ss);
		List<FoodVO>list=service.foodFindData(map);
		int totalpage=service.foodFindTotalpge(ss);
		//LIST를 보낼수없으니 (자바스크립트에게) JSON을 만들어서 전송한다
		//JSON => Spring-Boot => return list => 자동으로 JSON변경
		JSONArray arr=new JSONArray(); //[]
		int i=0;
		for(FoodVO vo:list)
		{
			JSONObject obj=new JSONObject();
			obj.put("no", vo.getNo()); //link => 상세보기
			obj.put("name",vo.getName());
			String poster=vo.getPoster();
			poster=poster.substring(0,poster.indexOf("^"));
			obj.put("poster",poster);
			if(i==0)
			{
				obj.put("curpage", curpage);
				obj.put("totalpage", totalpage);
			}
			arr.add(obj);//배열에 추가[{},{},{}...]
			i++;

		}
		return arr.toJSONString();
	}
	//상세보기 정보 전송
	@GetMapping(value="food/detail_vue.do",produces = "text/plain;charset=utf-8")
	public String food_detail(int no)
	{
		//오라클에서 읽기 => JSON변경 => 자바와 자바스크립트 매칭
		Map map=new HashMap();
		map.put("no", no);
		map.put("table_name", "food_location");
		FoodVO vo=service.foodDetailData(map);
		JSONObject obj=new JSONObject();
		obj.put("no",vo.getNo());//obj("no",1); {no:1,name:''...}
		obj.put("poster",vo.getPoster());
		obj.put("name",vo.getName());
		obj.put("tel",vo.getTel());
		obj.put("type",vo.getType());
		obj.put("address",vo.getAddress());
		obj.put("score",vo.getScore());
		obj.put("time",vo.getTime());
		obj.put("parking",vo.getParking());
		obj.put("menu",vo.getMenu());
		return obj.toJSONString();
	}
}
