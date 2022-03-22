package com.sist.main;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.dao.LocationDAO;
import com.sist.vo.HotelVO;
import com.sist.vo.LocationVO;

@Controller
public class LocationController {
	@Autowired
	private LocationDAO dao;
	
	
	  @GetMapping("seoul/location/list.do")
	  public String seoul_location_list(HttpServletRequest request,String page,Model model)
	  {
		  if(page==null)
			  	page="1";
		  int curpage=Integer.parseInt(page);
		  int rowSize=20;
		  int start=(rowSize*curpage)-(rowSize-1);
		  int end=rowSize*curpage;
		  Map map=new HashMap();
		  map.put("start",start);
		  map.put("end",end);
		  
		  List<LocationVO> list=dao.locationListData(map);
		  for(LocationVO vo:list)
		  {
			  String name=vo.getTitle();
			  if(name.length()>10)
			  {
				  name=name.substring(0,10)+"...";
			  }
			  vo.setTitle(name);
		  }
		  
		  int totalpage=dao.locationTotalPage();
		  
		  final int BLOCK=5;
		  int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		  int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		  
		  if(endPage>totalpage)
		  {
			  endPage=totalpage;
		  }
		  
		  model.addAttribute("list",list);
		  model.addAttribute("curpage",curpage);
		  model.addAttribute("totalpage",totalpage);
		  model.addAttribute("startPage",startPage);
		  model.addAttribute("endPage",endPage);
		  model.addAttribute("main_jsp", "../seoul/location/list.jsp");
		  
		  Cookie[] cookies=request.getCookies();
		  List<LocationVO> lList=new ArrayList<LocationVO>();
		  if(cookies!=null)
		  {
			  for(int i=cookies.length-1;i>=0;i--)
			  {
				  if(cookies[i].getName().startsWith("l"))
				  {
					  String no=cookies[i].getValue();
					  LocationVO vo=dao.locationDetailData(Integer.parseInt(no));
					  lList.add(vo);
				  }
			  }
			  model.addAttribute("lList",lList);
		  }		  
		  return "main/main";
	  }
	  @GetMapping("seoul/location/detail_before.do")
	  public String seoul_location_detail_before(int no,RedirectAttributes ra,
			  HttpServletResponse response)
	  {
		  Cookie cookie=new Cookie("l"+no, String.valueOf(no));
		  cookie.setPath("/");
		  cookie.setMaxAge(60*60*24);
		  response.addCookie(cookie);
		  ra.addAttribute("no",no);
		  return "redirect:http://localhost:8080/main/seoul/location/detail.do";
	  }
	  @GetMapping("seoul/location/detail.do")
	  public String seoul_location_detail(int no,Model model)
	  {
		  // 오라클로부터 데이터 읽기 
		  LocationVO vo=dao.locationDetailData(no);
		  model.addAttribute("vo", vo);
		  model.addAttribute("main_jsp", "../seoul/location/detail.jsp");
		  return "main/main";
	  }
}


















