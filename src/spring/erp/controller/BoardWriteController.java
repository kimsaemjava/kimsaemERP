package spring.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.erp.dto.BoardDTO;
import spring.erp.service.BoardService;

@Controller
public class BoardWriteController {
	@Autowired
	@Qualifier("boardservice")
	BoardService service;
	
	@RequestMapping(value="/board/write.do", method=RequestMethod.GET)
	public ModelAndView showView(String boardno){
		ModelAndView mav = new ModelAndView();
		BoardDTO board = service.read(boardno);
		mav.addObject("board",board);
		mav.addObject("menupath", "/WEB-INF/menu/board_menu.jsp");
		mav.addObject("viewpath", "/WEB-INF/board/board_write.jsp");
		mav.setViewName("template/mainLayout");
		return mav;
	}
	
	@RequestMapping(value="/board/write.do", method=RequestMethod.POST)
	public String write(BoardDTO board){
		int result = service.write(board);
		return "redirect:/board/list.do";
	}
}
