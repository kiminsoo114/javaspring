package com.sist.web;
import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;
import com.sist.dao.FoodReplyDAO;
import com.sist.service.*;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// 오라클 데이터를 읽어서 => 요청 처리 => 결과값 전송 
//JSP로 전송
@Controller//HandlerMapping => 반드시
//@Controller / @RestController
//@RequsetMapping, @GetMapping, @PostMapping
//어노테이션 => 구분자(if) => 2문제
@RequestMapping("food/")
/*
	@RequestMapping은 => 로그인(유효성검사) => GET(로그인창)
								  		  
									      POST(정상)
	GET ,  POST 두가지를 처리한다
	===	   ==== 개발자에 요청에 의해 4.3버전에서 나뉘어짐
	@GetMapping , @PostMapping

*/
public class FoodController {
	@Autowired
	private FoodService service;
	@Autowired
	private FoodReplyDAO dao;
	//사용자가 요청한 주소를 확인 (사용자(브라우저) => 서버(주소))
	//브라우저가 서버에게 보낼수 있는건 주소말고 없다
	//http://localhostL8080/web/food/main.do?no=1 => uri는 ?를 포함하지 않는다
	@GetMapping("main.do")//model은 전송하는거지 받는것이 아니다
	public String food_main(Model model)
	{
		//request,response는 사용하지 않고 동작이 가능
		//사용자가 보내준 값은 : 매개변수를 이용한다
		//사용자에게 전송을 할때는 전송객체를 이용 => Model
		List<CategoryVO>list=service.categoryListData();
		model.addAttribute("list",list);//model =>request가 포함
		//model.addAttribue == request.setAttribute
		//즉 jsp에 request를 넘겨주는 역할이다 위의 두개가
		return "food/main";//jsp는 포함하면 안된다 => viewName
	}
	//중복이 있는 경우에는 제거가 가능...
	@GetMapping("list.do")
	public String food_list(int cno,Model model)
	{
		CategoryVO vo=service.categoryInfoData(cno);
		List<FoodVO> list=service.categoryFoodListData(cno);
		for(FoodVO fvo:list)
		{
			String poster=fvo.getPoster();
			poster=poster.substring(0,poster.indexOf("^"));
			fvo.setPoster(poster);
			
			String address=fvo.getAddress();
			address=address.substring(0,address.lastIndexOf("지"));
			fvo.setAddress(address);
		}
		model.addAttribute("vo",vo);
		model.addAttribute("list",list);
		return "food/list";
	}
	@GetMapping("detail_before.do")
	/*
	 * 	DispatcherServlet (Front Controller)
	 *  클라이언트(브라우저) => 요청  => DispatcherServlet => HandlerMapping 
	 *  => @Controller => ViewResolver => JSP 
	 *  
	 *  *** 중요
	 *  DispatcherServlet을 통해서 요청값을 받거나 내장객체를 받을때
	 *  => 매개변수를 이용한다
	 *  	1) 사용자 요청값 => 일반 데이터(int ,String...)
	 *  	2) 커맨드 객체  => 단위가 ~VO (INSERT,UPDATE,JOIN ...)
	 *  	3) List(파일 업로드가 여러개) , []로 받을 수 있다
	 *  	4) 내장 객체, 스프링에서 제공하는 클래스
	 *  		HttpServletRequest : Cookie값을 읽을때 사용
	 *  		HttpServletResponse : Cookie 전송할때 사용
	 *  		RedirectAttributes  : Sendredirect일때 값전송할때 사용
	 *  		HttpSession
	 *  		Model
	 *  		Errors
	*/
	public String detail_before(int no,HttpServletResponse response,RedirectAttributes ra)
	{
		//request는 Cookie생성시에 사용된다
		
		//1.Cookie 생성 => 문자열만 저장가능하다는 단점
		Cookie cookie=new Cookie("f"+no,String.valueOf(no));
		//2. path지정
		cookie.setPath("/");
		//3. 기간
		cookie.setMaxAge(60*60*24);
		//4. 클라이언트로 전송
		response.addCookie(cookie);
		
		ra.addAttribute("no",no);
		/*
			model => forward일때 전송(데이터)
			ra    => sendRedirect() 데이터 전송
			
			GetMapping => <a>,location.href="", sendRedirec():redirect
			PostMaping => <form> , ajax({type:'POST'}
							axios.post() => @PostMapping
							axios.get() => @GetMapping
							
			default : GET
		*/
		return "redirect:detail.do";
	}
	@GetMapping("detail.do")
	public String food_detail(int no,Model model)
	{
		//1. 데이터 읽기 => 오라클
		Map map=new HashedMap();
		map.put("no",no);
		map.put("table_name","food_house");
		FoodVO vo=service.foodDetailData(map);
		List<RecipeVO>list=service.recipeTypeData(vo.getType().replace("/", "|").replace(" ",""));
		List<FoodReplyVO> rList=dao.replyListData(no);
		model.addAttribute("vo",vo);
		model.addAttribute("list",list);
		model.addAttribute("rList",rList);
		
		return "food/detail";
	}
	@GetMapping("find.do")
	public String food_find()
	{
		return "food/find";
	}
}
