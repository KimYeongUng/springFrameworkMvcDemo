package org.hero.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.hero.domain.BoardVO;
import org.hero.domain.Criteria;
import org.hero.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
    private BoardMapper mapper;

    @Override
    public void register(BoardVO board) {
        log.info("register.....:"+board);
        mapper.insertSelectKey(board);
    }

    @Override
    public BoardVO get(long bno) {
        log.info("get....... "+bno);
        return mapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO board) {
        log.info("modify......"+board);
        return mapper.update(board) == 1;
    }

    @Override
    public List<BoardVO> getList(Criteria cri) {
        log.info("return lists......");
        return mapper.getListWithPaging(cri);
    }

    @Override
    public boolean remove(long bno) {
        log.info("remove.....");
        return mapper.delete(bno) == 1;
    }

    @Override
    public int getTotal(Criteria cri){
        return mapper.getTotalCount(cri);
    }
}
