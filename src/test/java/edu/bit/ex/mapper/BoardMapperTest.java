package edu.bit.ex.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.bit.ex.board.mapper.BoardMapper;
import edu.bit.ex.board.vo.BoardVO;
import edu.bit.ex.connection.ConnectionTest;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {

	// 2. Mapper Å×½ºÆ®
	// 
	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	
	@Test
	public void testBoardMapper() {
		assertNotNull(boardMapper);
	}

	@Test
	public void testList() {
		List<BoardVO> list = boardMapper.list();
		
		log.info(list);
		
		for(BoardVO boardVO : list) {
			log.info(boardVO.getiContent());
		}
	}
	
//	@Test
//	public void testDelete() {
//		//public void delete(BoardVO boardVO);
//		
//		
//		log.info(delete());
//		
//		for(BoardVO boardVO : list) {
//			log.info(boardVO.getiContent());
//		}
//	}
	
	
	@Test
	public void testDelete() {
		BoardVO boardVO = new BoardVO();
		boardMapper.delete(boardVO);
		log.info(boardVO);
	}
	
}
