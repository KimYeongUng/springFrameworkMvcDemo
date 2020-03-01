package org.hero.mapper;

import org.apache.ibatis.annotations.Param;
import org.hero.domain.Criteria;
import org.hero.domain.ReplyVO;

import java.util.List;

public interface ReplyMapper {
    public int insert(ReplyVO bo);
    public ReplyVO read(Long bno);
    public int delete(int rno);
    public int update(ReplyVO vo);
    public List<ReplyVO> getListWithPaging(@Param("cri")Criteria cri,@Param("bno") Long bno);
}
