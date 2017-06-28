package com.luuzun.dgit.service;

import java.util.List;

import com.luuzun.dgit.domain.BoardVO;
import com.luuzun.dgit.domain.Criteria;
import com.luuzun.dgit.domain.SearchCriteria;

public interface BoardService {
	public int 			 searchCount(SearchCriteria cri)throws Exception;
	public int 			 articleCnt()					throws Exception;
	public BoardVO 		 read(Integer bno)  			throws Exception;
	public void 		 regist(BoardVO board)  		throws Exception;
	public void 		 modify(BoardVO board)  		throws Exception;
	public void 		 remove(Integer bno)    		throws Exception;
	public void 		 updateViewCnt(int bno) 		throws Exception;
	public List<BoardVO> listAll() 	  					throws Exception;
	public List<BoardVO> listCriteria(Criteria cri)		throws Exception;
	public List<BoardVO> listSearch(SearchCriteria cri)	throws Exception;
}
