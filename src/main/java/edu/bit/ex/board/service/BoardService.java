package edu.bit.ex.board.service;

import java.util.List;

import edu.bit.ex.board.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> getList();						// 데이터 타입에 주의할 것!

	public BoardVO contentView(int getiId);

	public void write(BoardVO boardVO);

	public void delete(BoardVO boardVO);

	public BoardVO reply_view(int getiId);

	public void reply(BoardVO boardVO);

}
