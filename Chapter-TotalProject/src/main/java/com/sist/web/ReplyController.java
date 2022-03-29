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
}
