package com.luuzun.dgit.domain;

public class PageMaker {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private Criteria cri;
	
	@Override
	public String toString() {
		return String.format("PageMaker [totalCount=%s, startPage=%s, endPage=%s, prev=%s, next=%s]",
				totalCount, startPage, endPage, prev, next);
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}


	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	public void calcData(){
		endPage = (int) (Math.ceil(cri.getPage() / (double)cri.getPerPageNum()) * cri.getPerPageNum());
		startPage = (endPage - cri.getPerPageNum()) + 1;
		
		int tempEndPage = (int) Math.ceil(totalCount / (double) cri.getPerPageNum());
		
		if(endPage > tempEndPage)
			endPage = tempEndPage;
		
		if(startPage == 1){
			prev = false;
		} else {
			prev = true;
		}
		
		if(endPage * cri.getPerPageNum() >= totalCount){
			next = false;
		} else {
			next = true;
		}
	}
	
/*	public String makeSearch(int page){
		UriComponents uri = UriComponentsBuilder.newInstance()
								.queryParam("page", page)
								.queryParam("perPageNum", cri.getPerPageNum())
								.queryParam("searchType", ((SearchCriteria)cri).getSearchType())
								.queryParam("keyword", ((SearchCriteria)cri).getKeyword()).build();
		//?page=1&perPageNum=10&searchType=""&keyword=""
		return uri.toUriString();
	}*/
}
