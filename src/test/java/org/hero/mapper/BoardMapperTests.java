package org.hero.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.hero.domain.BoardVO;
import org.hero.domain.Criteria;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml")
@Log4j
public class BoardMapperTests {
    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

    @Test
    public void getList(){
        mapper.getList().forEach(board->log.info(board));

    }


    @Test
    public void insert(){
        BoardVO vo  = new BoardVO();
        vo.setTitle("new Title For Test");
        vo.setContent("new Content For Test");
        vo.setWriter("new Writer Fro Test");

        mapper.insert(vo);
        log.info(vo);
    }

    @Test
    public void insertSelectKey(){
        BoardVO vo = new BoardVO();
        vo.setTitle("SK Title");
        vo.setContent("SK Cotnent");
        vo.setWriter("SK Writer");

        mapper.insertSelectKey(vo);
        log.info(vo);
    }

    @Test
    public void TestRead(){
        BoardVO vo = mapper.read(5L);
        log.info(vo);
    }

    @Test
    public void TestDelete(){

        log.info("DELETE COUNT: "+mapper.delete(3L));
    }

    @Test
    public void testUpdate(){
        BoardVO board = new BoardVO();
        board.setBno(5L);
        board.setTitle("Updated title");
        board.setContent("XML Tag id is update");
        board.setWriter("updated user!");
        Integer count = mapper.update(board);
        log.info("COUNT: "+count);
    }

    @Test
    public void testPage(){
        Criteria cri = new Criteria();
        cri.setPageNum(3);
        cri.setAmount(10);
        List<BoardVO> list = mapper.getListWithPaging(cri);
        list.forEach(board->log.info(board.getBno()));
    }

    @Test
    public void searchList(){
        Criteria cri = new Criteria();
        cri.setPageNum(1);
        cri.setKeyword("9");
        cri.setType("TCW");
        List<BoardVO> boards = mapper.getListWithPaging(cri);
        boards.forEach(board->log.info(board.getTitle()));
        log.info("searched board count: "+mapper.getSearchedCount(cri));
    }

}
