package edu.bit.ex.service;

/*
 * import static org.junit.Assert.*;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.test.context.ContextConfiguration; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import edu.bit.ex.board.service.BoardService; 
 * import edu.bit.ex.mapper.BoardMapperTest; 			// 이 부분이 빠졌었음. 
 * import lombok.extern.log4j.Log4j;
 * 
 * 
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
 * 
 * @Log4j public class BoardServiceTest {
 * 
 * // 에러나는데 아직 수정 못함
 * 
 * @Autowired BoardService boardService;
 * 
 * @Test public void testBoardService() { assertNotNull(boardService); }
 * 
 * }
 */

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.bit.ex.board.service.BoardService;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class BoardServiceTest {
   @Autowired
   BoardService boardService;

   @Test
   public void testBoardService() {
      assertNotNull(boardService);
   }
}
