package com.luuzun.dgit;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.luuzun.dgit.domain.BoardVO;
import com.luuzun.dgit.domain.Criteria;
import com.luuzun.dgit.domain.SearchCriteria;
import com.luuzun.dgit.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDaoTest {
	@Autowired
	private BoardDAO dao;

	//@Test
	public void testCreate() throws Exception{
		BoardVO board = new BoardVO();
		board.setTitle("새로운 글을 넣습니다");
		board.setContent("새로운 글을 넣습니다");
		board.setWriter("user00");
		dao.create(board);
	}

	//@Test
	public void testRead() throws Exception{
		dao.read(2);
	}

	//@Test
	public void testUpdate() throws Exception{
		BoardVO board = new BoardVO();
		board.setBno(2);
		board.setTitle("수정된글");
		board.setContent("수정 테스트");
		dao.update(board);
	}

	//@Test
	public void testdelete() throws Exception{
		dao.delete(1);
	}

	//@Test
	public void testListAll() throws Exception{
		System.out.println(dao.listAll());
	}

	//@Test
	public void testListPage() throws Exception{
		List<BoardVO> list = dao.listPage(100);
		for (BoardVO boardVO : list) {
			System.out.println(boardVO);
		}
	}
	
	//@Test
	public void testListCriteria() throws Exception{
		Criteria cri = new Criteria();
		cri.setPage(1);
		cri.setPerPageNum(20);
		
		System.out.println(cri.toString());
		
		List<BoardVO> list = dao.listCriteriaPage(cri);
		for (BoardVO boardVO : list) {
			System.out.println(boardVO);
		}
	}
	
	@Test
	public void testArticleCnt() throws Exception{
		System.out.println(dao.searchCount(new SearchCriteria()));
	}
}