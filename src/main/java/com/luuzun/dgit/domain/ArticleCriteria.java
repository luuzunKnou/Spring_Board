package com.luuzun.dgit.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class ArticleCriteria extends SearchCriteria{
	private int bno;

	@Override
	public String toString() {
		return String.format(super.toString()+"\narticleCriteria [bno=%s]", bno);
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}
	
	public String makeSearch() {
		UriComponents uri = UriComponentsBuilder.newInstance()
				.queryParam("page", getPage())
				.queryParam("perPageNum", getPerPageNum())
				.queryParam("searchType", getSearchType())
				.queryParam("keyword", getKeyword())
				.queryParam("bno", getBno())
				.build();
		//?page=""&perPageNum=""&searchType=""&keyword=""&bno=""
		System.out.println("MakeURI:" + uri.toUriString());
		return uri.toUriString();
	}
	
	public String makeSearch(int bno) {
		UriComponents uri = UriComponentsBuilder.newInstance()
				.queryParam("page", getPage())
				.queryParam("perPageNum", getPerPageNum())
				.queryParam("searchType", getSearchType())
				.queryParam("keyword", getKeyword())
				.queryParam("bno", bno)
				.build();
		//?page=""&perPageNum=""&searchType=""&keyword=""&bno=""
		System.out.println("MakeURI:" + uri.toUriString());
		return uri.toUriString();
	}
}
