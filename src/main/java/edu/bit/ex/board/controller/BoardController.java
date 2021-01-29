package edu.bit.ex.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.ex.board.service.BoardService;
import edu.bit.ex.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class BoardController {
	private BoardService boardService;
	
	@RequestMapping("/board/home")
	public String home() throws Exception {
		
		return "home";	
	}
	
	@RequestMapping("/board/list")
	public String list(Model model) throws Exception {
		model.addAttribute("list", boardService.getList());
		return "list";	
	}
	
	@RequestMapping("/board/content_view")
	public String content_view(BoardVO boardVO, Model model) throws Exception {
		model.addAttribute("content_view", boardService.contentView(boardVO.getiId()));
		return "content_view";	
	}
	
	@RequestMapping("/board/write_view")
	public String write_view() throws Exception {
		
		return "write_view";	
	}
	
	@RequestMapping("/board/write")
	public String write(BoardVO boardVO) throws Exception {
		boardService.write(boardVO);
		return "redirect:/board/list";							// �̷��� ��θ� �����ص� �۵���.
																// Q. redirect ��������� ��� �ϴ� �ǰ�?
	}
	
	@RequestMapping("/board/delete")
	public String delete(BoardVO boardVO) throws Exception {
		boardService.delete(boardVO);
		return "redirect:list";
	}
	
	@RequestMapping("/board/reply_view")
	public String reply_view(BoardVO boardVO, Model model) throws Exception {
		model.addAttribute("reply_view", boardService.reply_view(boardVO.getiId()));			// �� id�� ������ DB ���ٿ;� �ϴ� ���� : content_view������ ��� ������ �ʵ� ������ ���� ������, DB�� ���� ��ü ������ �����;� ��
		return "reply_view";
	}
	
	@RequestMapping("/board/reply")
	public String reply(BoardVO boardVO) throws Exception {
		boardService.reply(boardVO);
		return "redirect:list";
	}
	
	@RequestMapping("/board/modify")
	public String modify(BoardVO boardVO) throws Exception {
		boardService.modify(boardVO);
		return "redirect:list";
	}
	
	@RequestMapping("/board/shop")
	public String shop() throws Exception {
		return "shop";
	}
	
}
