package com.luuzun.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luuzun.dgit.domain.Criteria;
import com.luuzun.dgit.domain.ReplyVO;
import com.luuzun.dgit.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	private ReplyDAO dao;
	@Override	public void 			addReply(ReplyVO vo) 			throws Exception { dao.create(vo); }
	@Override	public void 			modifyReply(ReplyVO vo) 		throws Exception { dao.update(vo); }
	@Override	public void 			removeReply(Integer rno) 		throws Exception { dao.delete(rno); }
	@Override	public int 				count(int bno) 					throws Exception { return dao.count(bno); }
	@Override	public List<ReplyVO> 	listpage(int bno, Criteria cri) throws Exception { return dao.listPage(bno, cri); }
	@Override	public List<ReplyVO> 	listReply(Integer bno) 			throws Exception { return dao.list(bno); }
}