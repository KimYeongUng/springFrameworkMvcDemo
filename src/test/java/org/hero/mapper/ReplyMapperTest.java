package org.hero.mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.hero.domain.ReplyVO;
import org.hero.mapper.ReplyMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.IntStream;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml")
public class ReplyMapperTest {

    @Setter(onMethod_ = {@Autowired})
    private ReplyMapper mapper;

    private Long[] bnoArr = {9L,8L,7L,6L,5L};

    @Test
    public void testMapper(){
        log.info(mapper);
    }

    @Test
    public void testCreate(){
        IntStream.rangeClosed(1,10).forEach(i->{
            ReplyVO vo = new ReplyVO();

            vo.setBno(bnoArr[i%5]);
            vo.setReply("reply Test "+i);
            vo.setReplyer("replyer Test "+i);

            mapper.insert(vo);
        });
    }

    @Test
    public void testRead(){
        Long targetRno = 5L;
        ReplyVO vo = mapper.read(targetRno);
        log.info(vo);
    }

    @Test
    public void testDelete(){
        Integer targetRno = 1;

        mapper.delete(targetRno);
    }

    @Test
    public void testUpdate(){
        Long targetRno  = 10L;
        ReplyVO vo = mapper.read(targetRno);

        vo.setReply("update reply");

        int count = mapper.update(vo);

        log.info("Update Count: "+count);
    }

}
