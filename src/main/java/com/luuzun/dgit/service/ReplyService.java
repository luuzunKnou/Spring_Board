package com.luuzun.dgit.service;


import java.util.List;

import com.luuzun.dgit.domain.Criteria;
import com.luuzun.dgit.domain.ReplyVO;

public interface ReplyService {
	public List<ReplyVO> 	listReply(Integer bno) 			throws Exception;
	public List<ReplyVO> 	listpage(int bno, Criteria cri) throws Exception;
	public void 			addReply(ReplyVO vo) 			throws Exception;
	public void 			modifyReply(ReplyVO vo)		 	throws Exception;
	public void 			removeReply(Integer rno) 		throws Exception;
	public int 				count(int bno) 					throws Exception;
}
