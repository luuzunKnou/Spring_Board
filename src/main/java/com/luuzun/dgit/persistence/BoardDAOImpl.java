package com.luuzun.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luuzun.dgit.domain.BoardVO;
import com.luuzun.dgit.domain.Criteria;
import com.luuzun.dgit.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSession session;

	private static String namespace = "com.luuzun.dgit.persistence.BoardDAO";
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(namespace+".create",vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(namespace+".read",bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace+".update",vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace+".delete",bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace+".listAll");
	}

	@Override
	public void updateViewCnt(Integer bno) throws Exception {
		session.update(namespace+".updateViewCnt",bno);
	}

	@Override
	public List<BoardVO> listPage(Integer pno) throws Exception {
		if(pno<=0){
			pno=1;
		}
		pno=(pno-1)*10;
		return session.selectList(namespace+".listPage", pno);
	}

	@Override
	public List<BoardVO> listCriteriaPage(Criteria cri) throws Exception {
		return session.selectList(namespace+".listCriteriaPage", cri);
	}

	@Override
	public int articleCnt() throws Exception {
		return session.selectOne(namespace+".articleCnt");
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace+".listSearch", cri);
	}

	@Override
	public int searchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace+".searchCount", cri);
	}
}