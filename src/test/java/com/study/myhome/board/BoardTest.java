package com.study.myhome.board;

import com.study.myhome.board.service.BoardService;
import com.study.myhome.board.service.BoardVO;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/egovframework/spring/com/*.xml"})
@WebAppConfiguration
@FixMethodOrder
public class BoardTest {

  @Autowired
  private BoardService boardService;

  @Test
  public void test1CRUDTest() throws Exception {
    BoardVO board = new BoardVO("테스트", "테스트", null);
    //		boardService.insertBoardArticle(board);

    board = new BoardVO();
    board.setIdx(1L);
    board = boardService.selectBoardArticle(board);

    // 게시물 확인
    Assert.assertNotNull(boardService.selectBoardArticle(board));
    // 조회수
    Assert.assertEquals(1, board.getViewCnt());

    board.setTitle("테스트2");
    //		boardService.updateBoardArticle(board);

    board.setIdx(1L);
    board = boardService.selectBoardArticle(board);

    // 수정 내역 확인
    Assert.assertEquals("테스트2", board.getTitle());

    boardService.deleteBoardArticle(board);

    board = boardService.selectBoardArticle(board);

    Assert.assertNull(board);
  }

}
