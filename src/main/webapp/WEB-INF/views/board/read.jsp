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
	<div class="row">
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
	</div>
	
	<!-- 댓글 -->
	<div class="row">
		<div class="coll-md-12">
			<div class="box box-success">
			
				<!-- 댓글 작성 -->
				<div class="box-header">
					<h3 class="box-title">댓글 추가</h3>
				</div>
				
				<div class="box-body">
					<label for="newReplyWriter">작성자</label>
					<input type="text" placeholder="아이디" id="newReplyWriter" class="form-control">
					<br>
					<label for="newReplyText">댓글내용</label>
					<input type="text" placeholder="Reply Text" id="newReplyText" class="form-control">
				</div>
				
				<div class="box-footer">
					<button class="btn btn-primary" id="btnadd">댓글 추가</button>
				</div>
				
			</div>
			
			<!-- 댓글 리스트 -->
			<ul class="timeline">
				<li class="time-label" id="repliesList">
					<span class="bg-green" id="btnList">댓글 리스트</span>
				</li>
			</ul>
		</div>
		<!-- 댓글 리스트 출력(x-handlebars-template) -->
		<!-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script> -->
		<script src="handlebars-v4.0.10.js"></script>
		<script id="temp" type="text/x-handlebars-template">
			{{#each.}}
			<li class="replyLi" data-rno={{rno}}>
				<i class="fa fa-comments bg-blue"></i>
				<div class="timeline-item">		
					<span class="time">
						<i class="fa fa-clock-o"></i>{{tempdate regdate}}
					</span>
					<h3 class="timeline-header"><strong>{{rno}}</strong>-{{replyer}}</h3>
					<div class="timeline-body">{{replytext}}</div>
					<div class="timeline-footer">
						<a class="btn btn-primary btn-xs" data-toggle="modal" data-targer="#modifyModal">modify</a>
					</div>
				</div>
			</li>
			{{/each}}
		</script>
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

<script type="text/javascript">
	Handlebars.registerHelper("tempdate",function(time){
		var dateObj = new Date(time);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth()+1;
		var date = dateObj.getDate();
		
		return year+"/"+month+"/"+date;
	})
		var bno = ${board.bno }
		function getAllList(){
			$.ajax({//pageContext.getRequest(),getContextPath() jsp 4장에 잇음
				url:"${pageContext.request.contextPath}/replies/all/"+bno,
				type:"get",
				dateType:"json",
				success:function(data){
					console.log(data);
					var source = $("#temp").html();
					var template = Handlebars.compile(source);
					
					$(".replyLi").remove();
					$(".timeline").append(template(data));
				}
			});
		}
	//리스트 가져오기
	$("#btnList").click(function(){
		getAllList();
	});
	
	//댓글 추가
	$("#btnadd").click(function(){
		var writer = $("#newReplyWriter").val();
		var text = $("#newReplyText").val();
		var sendData = {
				bno:bno,
				replytext:text,
				replyer:writer
		};
		
		$.ajax({
			url:"${pageContext.request.contextPath}/replies/add/",
			type:"post",
			dataType:"text",
			data:JSON.stringify(sendData),
			headers:{"Content-Type":"application/json"},
			success:function(data){
				console.log(data);
			}
		});
	});
</script>
	
<%@ include file="../include/footer.jsp"%>