<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.completeBtn {
	float: right;
	margin-right: 10px;
}
</style>
<%@ include file="../include/header.jsp"%>
<section class="content">
	<div class="col-md-12">
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">REGISTER BOARD</h3>
			</div>

			<!-- 수정 Form -->
			<form role="form" method="post" action="modify">
				<div class="box-body">
					<input type="hidden" name="bno" 		value="${articleCriteria.bno}">
					<input type="hidden" name="page" 		value="${articleCriteria.page }">
					<input type="hidden" name="searchType" 	value="${articleCriteria.searchType }">
					<input type="hidden" name="keyword" 	value="${articleCriteria.keyword }">
					<input type="hidden" name="perPageNum" 	value="${articleCriteria.perPageNum }">
					
					<div class="form-group">
						<label>Title</label> <input type="text" name="title"
							class="form-control" value="${content.title}">
					</div>

					<div class="form-group">
						<label>Content</label>
						<textarea rows="20" cols="" name="content" class="form-control"
							placeholder="Enter Content">${content.content}</textarea>
					</div>

					<div class="form-group">
						<label>Writer</label> <input type="text" name="writer"
							class="form-control" value="${content.writer}">
					</div>
					<div class="box-footer">
						<button type="submit" class="btn btn-primary completeBtn">Complete</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>