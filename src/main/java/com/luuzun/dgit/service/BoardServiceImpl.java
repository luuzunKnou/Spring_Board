package com.luuzun.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luuzun.dgit.domain.BoardVO;
import com.luuzun.dgit.domain.Criteria;
import com.luuzun.dgit.domain.SearchCriteria;
import com.luuzun.dgit.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService  {
	@Autowired
	private BoardDAO dao;
	
	@Override	public BoardVO 		 read(Integer bno) 				throws Exception { return dao.read(bno); }
	@Override	public int 			 articleCnt() 					throws Exception { return dao.articleCnt(); }
	@Override	public int 			 searchCount(SearchCriteria cri)throws Exception { return dao.searchCount(cri); }
	@Override	public void 		 regist(BoardVO board)			throws Exception { dao.create(board); }
	@Override	public void 		 updateViewCnt(int bno)			throws Exception { dao.updateViewCnt(bno); }
	@Override	public void 		 modify(BoardVO board)			throws Exception { dao.update(board); }
	@Override	public void 		 remove(Integer bno) 			throws Exception { dao.delete(bno); }
	@Override	public List<BoardVO> listAll() 						throws Exception { return dao.listAll(); }
	@Override	public List<BoardVO> listCriteria(Criteria cri) 	throws Exception { return dao.listCriteriaPage(cri); }
	@Override	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception { return dao.listSearch(cri); }
}