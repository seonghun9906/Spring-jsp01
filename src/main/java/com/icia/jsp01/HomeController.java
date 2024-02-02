package com.icia.jsp01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.jsp01.dto.DataDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		log.info("home()");
		// front-end로 데이터를 보낼 때 사용하는 객체 - Model
		// DispatcherServlet이 생성하여 보내는 객체
		model.addAttribute("data", "서버에서 보내는 문자열");
		// data = 식별자 / "서버에서 보내는 문자열" = value
		model.addAttribute("num", 100);

		DataDto dataDto = new DataDto();
		dataDto.setCode(1);
		dataDto.setStrData("홍길동");
		dataDto.setNumData(23);
		dataDto.setDateData("2000-01-05");
		model.addAttribute("person1", dataDto);

		return "home";
	}
	
	@GetMapping("mavCase")
	public ModelAndView mavCase() {
		log.info("mavCase()");
		
		ModelAndView mv = new ModelAndView();
		//데이터를 담아준다.
		mv.addObject("sec_data", "두번째 페이지");
		//뷰를 지정한다.
		mv.setViewName("modelAndView");
		
		DataDto dataDto = new DataDto();
		dataDto.setCode(2);
		dataDto.setStrData("아무개");
		dataDto.setNumData(30);
		dataDto.setDateData("1995-05-02");
	
		mv.addObject("person2",dataDto);
		
		return mv;
	}
	
	@GetMapping("send")
		public String sendData(String id, int num1, int num2) {
		log.info("sendData()");
		
		log.info("id : " + id);
		log.info("num1 : " + num1);
		log.info("num2 : " + num2);
		
		return "redirect:/";
	}
	
	
}// class end