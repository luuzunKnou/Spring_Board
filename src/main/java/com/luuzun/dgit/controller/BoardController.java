package com.luuzun.dgit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.luuzun.dgit.domain.ArticleCriteria;
import com.luuzun.dgit.domain.BoardVO;
import com.luuzun.dgit.domain.PageMaker;
import com.luuzun.dgit.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;
	
	//게시물 등록 화면
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGET() throws Exception{
		logger.info("Get: Board Register");
		return "board/register";
	}
	
	//게시물 등록
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BoardVO board) throws Exception{
		logger.info("Insert : "+ board);
		boardService.regist(board);
		//
		return "board/success";
	}
	
	//페이징 된 리스트 출력
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public String listPage(Model model, @ModelAttribute("articleCriteria") ArticleCriteria articleCriteria) throws Exception{
		logger.info("Show All Content by articleCriteria : " + articleCriteria);
		model.addAttribute("list",boardService.listSearch(articleCriteria));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(articleCriteria);
		pageMaker.setTotalCount(boardService.searchCount(articleCriteria));
		model.addAttribute("pageMaker", pageMaker);
	
		return "board/listPage";
	}
	
	//게시물 읽기
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(Model model, @ModelAttribute("articleCriteria") ArticleCriteria articleCriteria) throws Exception{
		logger.info("Read Item: " + articleCriteria.getBno() +":"+ boardService.read(articleCriteria.getBno()));
		model.addAttribute("content",boardService.read(articleCriteria.getBno()));
		boardService.updateViewCnt(articleCriteria.getBno());
		return "board/read";
	}
	
	//게시물 수정 화면
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(Model model, @ModelAttribute("articleCriteria") ArticleCriteria articleCriteria) throws Exception{
		logger.info("Show Modify Item");
		model.addAttribute("content", boardService.read(articleCriteria.getBno()));
		return "board/modify";
	}
	
	//게시물 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, ArticleCriteria articleCriteria, RedirectAttributes model) throws Exception{
		logger.info("Modify Item", board);
		boardService.modify(board);
		return "redirect:read"+articleCriteria.makeSearch();
	}
	
	//게시물 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletePOST(ArticleCriteria articleCriteria, RedirectAttributes model) throws Exception{
		logger.info("Remove Item: " + articleCriteria.getBno());
		boardService.remove(articleCriteria.getBno());
		return "redirect:listPage"+articleCriteria.makeSearch();
	}
	
	/*//게시물 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletePOST(ArticleCriteria articleCriteria, RedirectAttributes model) throws Exception{
		logger.info("Remove Item: " + articleCriteria.getBno());
		boardService.remove(articleCriteria.getBno());
		
		model.addAttribute("bno", articleCriteria.getBno());
		model.addAttribute("page", articleCriteria.getPage());
		model.addAttribute("perPageNum", articleCriteria.getPage());
		model.addAttribute("searchType", articleCriteria.getSearchType());
		model.addAttribute("keyword", articleCriteria.getKeyword());
		
		return "redirect:listPage";
	}*/
	
	/*//게시물 수정
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(BoardVO board, ArticleCriteria articleCriteria, RedirectAttributes model) throws Exception{
		logger.info("Modify Item", board);
		boardService.modify(board);
		model.addAttribute("bno", board.getBno());
		model.addAttribute("page", articleCriteria.getPage());
		model.addAttribute("perPageNum", articleCriteria.getPage());
		model.addAttribute("searchType", articleCriteria.getSearchType());
		model.addAttribute("keyword", articleCriteria.getKeyword());
		return "redirect:read";
	}*/
	
	//전체 리스트 출력
	/*@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public String listAll(Model model) throws Exception{
		logger.info("Show All Content");
		model.addAttribute("list",boardService.listAll());
		return "board/listAll";
	}*/
}
