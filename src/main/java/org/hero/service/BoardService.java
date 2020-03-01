package org.hero.service;

import org.hero.domain.BoardVO;
import org.hero.domain.Criteria;

import java.util.List;

public interface BoardService {
    public void register(BoardVO board);
    public BoardVO get(long bno);
    public boolean modify(BoardVO board);
    public List<BoardVO> getList(Criteria cri);
    public boolean remove(long bno);
    public int getTotal(Criteria cri);
}
