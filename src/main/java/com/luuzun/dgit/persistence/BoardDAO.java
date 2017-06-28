package com.luuzun.dgit.persistence;

import java.util.List;

import com.luuzun.dgit.domain.BoardVO;
import com.luuzun.dgit.domain.Criteria;
import com.luuzun.dgit.domain.SearchCriteria;

public interface BoardDAO {
	public void 		 create(BoardVO vo) 			throws Exception;
	public BoardVO 		 read(Integer bno) 				throws Exception;
	public void 		 update(BoardVO vo) 			throws Exception;
	public void 		 delete(Integer bno) 			throws Exception;
	public List<BoardVO> listAll() 						throws Exception;
	public void 		 updateViewCnt(Integer bno) 	throws Exception;
	public List<BoardVO> listPage(Integer pno)			throws Exception;
	public List<BoardVO> listCriteriaPage(Criteria cri)	throws Exception;
	public int 			 articleCnt()					throws Exception;
	public int 			 searchCount(SearchCriteria cri)throws Exception;
	public List<BoardVO> listSearch(SearchCriteria cri)	throws Exception;
}
