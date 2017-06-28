<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
.write, .modify, .delete, .showList {
	float: right;
	margin-right: 30px;
}
</style>

<%@ include file="../include/header.jsp"%>
<section class="content">
	<div class="col-md-12">
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">READ</h3>
			</div>

			<div class="box-body">
			
				<!-- Hidden Form -->
				<form role="form" method="post" id="f1">
					<input type="hidden" name="bno" value="${articleCriteria.bno}">
					<input type="hidden" name="page" value="${articleCriteria.page }">
					<input type="hidden" name="searchType" value="${articleCriteria.searchType }">
					<input type="hidden" name="keyword" value="${articleCriteria.keyword }">
					<input type="hidden" name="perPageNum" value="${articleCriteria.perPageNum }">
				</form>
				
				<div class="form-group"> <!-- 제목 -->
					<label>Title</label> <input readonly="readonly" type="text"
						name="title" class="form-control" value="${content.title }">
				</div>
				<div class="form-group"> <!-- 본문 -->
					<label>Content</label>
					<textarea rows="20" cols="" class="form-control" name="content"
						readonly="readonly">${content.content}</textarea>
				</div>
				<div class="form-group"> <!-- 작성자 -->
					<label>writer</label> <input readonly="readonly" type="text"
						name="writer" class="form-control" value="${content.writer }">
				</div>


				<div class="box-footer"> <!-- 버튼(글쓰기, 수정, 삭제, 리스트) -->
					<button class="btn btn-primary write" 
						onclick="location.href='register'">Write</button>
					<button class="btn btn-warning modify">Modify</button>
					<button class="btn btn-danger delete" data-toggle="modal" data-target="#myModal">Delete</button>
					<button class="btn btn-primary showList">Show List</button>

					<!-- 삭제 확인 Modal -->
					<div id="myModal" class="modal fade" role="dialog">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Delete Article</h4>
								</div>
								<div class="modal-body">
									<p>Are you sure?</p>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default deleteModal"
										data-dismiss="modal">Delete</button>
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Cancel</button>
								</div>
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</section>
<script>
	<!-- 버튼 이벤트 -->
	$(function() {
		$(".modify").click(function() {
			$("#f1").attr("action", "modify");
			$("#f1").attr("method", "get");
			$("#f1").submit();
		});

		$(".deleteModal").click(function() {
			$("#f1").attr("action", "delete");
			$("#f1").submit();
		});

		$(".showList").click(function() {
			//location.href = "listPage?page=${cri.page}";
			$("#f1").attr("action","listPage");
			$("#f1").attr("method","get");
			$("#f1").submit();
		});
	});
</script>

<%@ include file="../include/footer.jsp"%>