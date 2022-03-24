package com.sist.web;

import org.springframework.stereotype.Controller;
//JSP를 찾아서 보내주는용
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SeoulController {
	@GetMapping("vuejs/vue3.do")
	public String vuejs_vue3()
	{
		return "vuejs/vue3";
	}
}
