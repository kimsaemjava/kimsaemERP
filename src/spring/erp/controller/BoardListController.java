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
public class BoardListController {
	@Autowired
	@Qualifier("boardservice")
	BoardService service;
	
	@RequestMapping(value="/board/list.do")
	public ModelAndView showList(String boardctg){
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> boardlist = null;
		if(boardctg==null){
			boardlist = service.readlist();
		}else{
			boardlist = service.readctglist(boardctg);
		}
		mav.addObject("boardlist",boardlist);
		mav.addObject("menupath", "/WEB-INF/menu/board_menu.jsp");
		mav.addObject("viewpath", "/WEB-INF/board/boardlist.jsp");
		mav.setViewName("template/mainLayout");
		return mav;
	}
}
