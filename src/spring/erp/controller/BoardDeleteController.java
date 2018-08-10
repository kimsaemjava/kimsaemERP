package spring.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.erp.dto.BoardDTO;
import spring.erp.service.BoardService;

@Controller
public class BoardDeleteController {
	@Autowired
	@Qualifier("boardservice")
	BoardService service;
	
	@RequestMapping(value="/board/delete.do")
	public String showList(String boardno){
		int result = service.delete(boardno);
		return "redirect:/board/list.do";
	}
}
