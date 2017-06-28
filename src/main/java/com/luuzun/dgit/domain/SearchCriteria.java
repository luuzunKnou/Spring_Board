package com.luuzun.dgit.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class SearchCriteria extends Criteria{
	private String searchType;
	private String keyword;
	
	@Override
	public String toString() {
		return String.format(super.toString()+"\nSearchCriteria [searchType=%s, keyword=%s]", searchType, keyword);
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String makeSearch(){
		UriComponents uri = UriComponentsBuilder.newInstance()
								.queryParam("page", getPage())
								.queryParam("perPageNum", getPerPageNum())
								.queryParam("searchType", getSearchType())
								.queryParam("keyword", getKeyword()).build();
		//?page=1&perPageNum=10&searchType=""&keyword=""
		return uri.toUriString();
	}
}
