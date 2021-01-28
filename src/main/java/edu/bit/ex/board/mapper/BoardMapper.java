package edu.bit.ex.board.mapper;

import java.util.List;

import edu.bit.ex.board.vo.BoardVO;

public interface BoardMapper {

	public List<BoardVO> list();

	public BoardVO getContent(int iId);

	public void write(BoardVO boardVO);

	public void delete(BoardVO boardVO);

	public BoardVO replyView(int iId);

	public void reply(BoardVO boardVO);

	public void replyShape(BoardVO boardVO);

	public void addHit(int iId);

}
