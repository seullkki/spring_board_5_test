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
		return "redirect:list";
	}
	
	@RequestMapping("/board/delete")
	public String delete(BoardVO boardVO) throws Exception {
		boardService.delete(boardVO);
		return "redirect:list";
	}
	
	@RequestMapping("/board/reply_view")
	public String reply_view(BoardVO boardVO, Model model) throws Exception {
		model.addAttribute("reply_view", boardService.reply_view(boardVO.getiId()));			// 꼭 id를 가지고 DB 갔다와야 하는 이유 : content_view에서는 댓글 관련한 필드 정보가 없기 때문에, DB에 가서 전체 정보를 가져와야 함
		return "reply_view";
	}
	
	@RequestMapping("/board/reply")
	public String reply(BoardVO boardVO) throws Exception {
		boardService.reply(boardVO);
		return "redirect:list";
	}
}
