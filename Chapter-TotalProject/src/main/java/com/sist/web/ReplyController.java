package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.dao.*;
import com.sist.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.dao.FoodReplyDAO;

@Controller
public class ReplyController {
	@Autowired
	private FoodReplyDAO dao;
	
	@GetMapping("food/login.do")
	public String food_login()
	{
		return "food/login";
	}
	@GetMapping("food/logout.do")
	public String food_logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:login.do";
	}
	@PostMapping("food/reply_insert.do")
	public String food_reply_insert(int fno,String msg,RedirectAttributes ra,HttpSession session)
	{
		/* 전송객체는 두개가 있다
		 * 	 RedirectAttributes => redirect: a.do => a.do에 전송시에 사용
		 * 							======= 데이터만 전송
		 * 	 Model => return이 "food/main" 이럴 때 사용 
		 * 	 (forward => request를 전송)
		*/	
		String id=(String)session.getAttribute("id");
		String name=(String)session.getAttribute("name");
		FoodReplyVO vo=new FoodReplyVO();
		vo.setFno(fno);
		vo.setId(id);
		vo.setName(name);
		vo.setMsg(msg);
		dao.replyInsert(vo);
		ra.addAttribute("no",fno);
		return "redirect:detail.do";
	}
	@PostMapping("food/reply_update.do")
	public String food_reply_update(FoodReplyVO vo,String msg
			,RedirectAttributes ra)
	{	
		//DAO만 연결
		dao.replyUpdate(vo);
		ra.addAttribute("no",vo.getFno());
		return "redirect:detail.do";
	}

	/*	
	 *  1.GET / POST => (@PostMapping) => 보내야하는 데이터가 많은 경우(<form>)
	 *   ====	
	 *    @GetMapping (화면 이동, 단순한 데이터 => page,no = <a>)
	 *  2. 메소드명은 어떤 이름이든 상관없다(식별자기준만 지킨다)
	 *  3. 매개변수
	 *     일반변수
	 *     ?no=1 => 매개변수는 (int no)
	 *     ?title=aaa => 매개변수는 (String title)
	 *     =>하나하나 쓰지말고 vo단위로 값을 차라리 준다 (~VO vo) => 커맨드 객체
	 *     스프링에서 제공하는 내장객체
	 *     RedirectAttributes : redirect => 사용시에 전송하는 방식
	 *     Model : foreward => request에 값을 담아서 JSP로 전송
	 *     HttpServletRequest => Cookie값을 읽는 경우
	 *      Cookie[] cook =request.getCookies()
	 *     HttpServletResponse => Cookie를 클라이언트 전송
	 *     						 파일 업로드시
	 *     	Cookie cookie=new Cooke("key","value")
	 *     response.addCookie(cookie)
	 *     HttpSession : id, name...
	 *     ==========================
	 *      매개변수로 설정 => DispatcherServlet에 의해 매개변수값이 채워진다
	 *      매개변수는 순서가 없다
	*/
	@PostMapping("food/reply_reply_insert")
	public String food_reply_reply_insert(int pno,FoodReplyVO vo,
			RedirectAttributes ra,HttpSession session)//모든 필요한 데이터는
	//DispatcherServlet에서 받아온다
	{
		String id=(String)session.getAttribute("id");
		String name=(String)session.getAttribute("name");
		vo.setId(id);
		vo.setName(name);
		dao.replyReplyInsert(pno, vo);
		ra.addAttribute("no",vo.getFno());
		return "redirect:detail.do";
	}
	@GetMapping("food/reply_delete.do")
	public String food_reply_delete(int no,int fno,
			RedirectAttributes ra)
	{
		// 웹 => 접속자 전체 같은 데이터를 보고 있어야 된다
		// 데이터베이스(공유된 데이터) => 데이터베이스 80~90% 
		// 따라서 취직시에 스프링가능자, 데이터베이스 가능자는 필수적으로 나온다
		// 삭제처리
		dao.replyDelete(no);
		//이동
		ra.addAttribute("no",fno);//fno => 맛집 번호
		return "redirect:detail.do";
	}
	
}
