package org.hero.mapper;

import org.hero.domain.BoardVO;
import org.hero.domain.Criteria;

import java.util.List;

public interface BoardMapper {
    public List<BoardVO> getList();
    public void insert(BoardVO board);
    public void insertSelectKey(BoardVO board);
    public BoardVO read(long bno);
    public Integer delete(long bno);
    public Integer update(BoardVO board);
    public List<BoardVO> getListWithPaging(Criteria cri);
    public int getTotalCount(Criteria cri);
    public int getSearchedCount(Criteria cri);

}
