package org.hero.service;

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

import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml")
@Log4j
public class BoardServiceTest {
    @Setter(onMethod_ = {@Autowired})
    private BoardService service;

    @Test
    public void getListPage(){
        Criteria cri = new Criteria();
        cri.setPageNum(3);
        cri.setAmount(10);

        List<BoardVO> vos = service.getList(cri);
        for(BoardVO vo:vos){
            log.info(vo.getBno()+" : "+vo.getTitle());
        }
    }

    @Test
    public void testExists(){
        log.info(service);
        assertNotNull(service);
    }

    @Test
    public void testRegister(){
        BoardVO vo = new BoardVO();
        vo.setTitle("new Title2");
        vo.setContent("new Content2");
        vo.setWriter("newbie2");

        service.register(vo);
        log.info("bno of new Content: "+vo.getBno());
    }

    @Test
    public void insert()throws Exception{
        for(int i=0;i<=1000;i++){
            BoardVO vo = new BoardVO();
            vo.setTitle("Test Title No."+i);
            vo.setContent("Test Content No."+i);
            vo.setWriter("Test Writer No."+i);

            service.register(vo);
        }
    }

    @Test
    public void testGetList(){

        service.getList(new Criteria(2,10)).forEach(board->log.info(board));
    }

    @Test
    public void testGet(){
        log.info(service.get(1L));
    }

    @Test
    public void testDelete(){
        log.info("DELETE: "+service.remove(2L));
    }

    @Test
    public void testModify(){
        BoardVO vo = service.get(1);

        if(vo == null)
            return;

        vo.setTitle("Modify Title");
        log.info("MODIFY RESULT: "+service.modify(vo));
    }
}
