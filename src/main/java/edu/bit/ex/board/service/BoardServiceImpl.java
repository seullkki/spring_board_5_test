package edu.bit.ex.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.ex.board.mapper.BoardMapper;
import edu.bit.ex.board.vo.BoardVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service								// 어노테이션 잊지 말자!!
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getList() {
		return boardMapper.list();
	}

	@Override
	public BoardVO contentView(int iId) {			// hit
		boardMapper.addHit(iId);
		return boardMapper.getContent(iId);
	}

	@Override
	public void write(BoardVO boardVO) {
		boardMapper.write(boardVO);
	}

	@Override
	public void delete(BoardVO boardVO) {
		boardMapper.delete(boardVO);
	}

	@Override
	public BoardVO reply_view(int iId) {
		return boardMapper.replyView(iId);
	}

	@Override
	public void reply(BoardVO boardVO) {			// replyShape
		boardMapper.replyShape(boardVO);
		boardMapper.reply(boardVO);
	}

	@Override
	public void modify(BoardVO boardVO) {
		boardMapper.modify(boardVO);
	}

}
