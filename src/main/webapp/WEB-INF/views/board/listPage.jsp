<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 
fmt:parseDate  : String > Date 변경
fmt:formatDate : Date > Other Format 변경 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
	.writeBtn{float:right; margin-right: 10px;}
</style>

<%@ include file="../include/header.jsp"%>
<section class="content">
	<div class="col-md-12">
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">BOARD LIST</h3>
			</div>
			<!-- 검색창 -->
			<div class="box-body">
				<select name="searchType">
					<option value="null"> - - - - - </option>
					<option value="title" ${searchCriteria.searchType=='title' ? 'selected':''}> 
						Title </option>
					<option value="content" ${searchCriteria.searchType=='content' ? 'selected':''}> 
						Content </option>
					<option value="writer" ${searchCriteria.searchType=='writer' ? 'selected':''}> 
						Writer </option>
					<option value="titltOrContent" ${searchCriteria.searchType=='titltOrContent' ? 'selected':''}> 
						Title OR Content </option>
					<option value="contentOrWriter" ${searchCriteria.searchType=='contentOrWriter' ? 'selected':''}> 
						Content OR Writer </option>
					<option value="allSearch" ${searchCriteria.searchType=='allSearch' ? 'selected':''}> 
						Title OR Content OR Writer </option>
				</select>
				<input type="text" value="${searchCriteria.keyword }" name="keyword">
				<button id ="searchBtn">Search</button>
			</div>
			
			<!-- 리스트 출력 -->
			<div class="box-body">
				<table class="table table-boarded">
					<tr>
						<th style="width:10px">BNO</th>
						<th>TITLE</th>
						<th style="width:100px">WRITER</th>
						<th style="width:200px">REG DATE</th>
						<th style="width:10px">CNT</th>
					</tr>
					<c:forEach var="board" items="${list}"> 
						<tr>
							<td>${board.bno} </td>
							<td style="font-weight: bolder; color: navy;"> 
								<a href="read${articleCriteria.makeSearch(board.bno)}">${board.title }</a>
							</td>
							<td>${board.writer} </td>
							<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd HH:mm"/> </td>
							<td><span class = "badge bg-red">${board.viewcnt} </span></td>
						</tr>
					</c:forEach> 
				</table>
			</div>
			
			<!-- 페이징 -->
			<div class="box-footer">
				<div class = "text-center">
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li><a href="listPage?page=${pageMaker.startPage-1 }"> &laquo; </a></li>
						</c:if>
						<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage }" var="idx">
							<li ${pageMaker.cri.page==idx? 'class=active':''} ><a href="listPage?page=${idx} "> ${idx } </a></li>
						</c:forEach>
						<c:if test="${pageMaker.next}">
							<li><a href="listPage?page=${pageMaker.endPage+1 }"> &raquo; </a></li>
						</c:if>
					</ul>
				</div>
				<button type="button" class ="btn btn-primary writeBtn" onclick="location.href='register' ">Write</button>
			</div>
			
			<!--  -->
		</div>
	</div>
</section>

<!-- 검색 버튼 동작 -->
<script>
	$(function(){
		$("#searchBtn").click(function(){
			var keyword = $("input[name='keyword']").val();
			var searchType = $("select").val();
			location.href = "listPage?keyword=" + keyword + "&searchType=" + searchType;
		});
	});
</script>

<%@ include file="../include/footer.jsp"%>