<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 

<script type="text/javascript">
$(document).ready(function() {
	//목록버튼 동작
	$("#btnList").click(function() {
		$(location).attr("href", "/board/list");
	});
	
	//수정버튼 동작
	$("#btnUpdate").click(function() {
		$(location).attr("href", "/board/update?boardno=${viewBoard.boardno }");
	});

	//삭제버튼 동작
	$("#btnDelete").click(function() {
		$(location).attr("href", "/board/delete?boardno=${viewBoard.boardno }");
	});
	
});
</script>




<script type="text/javascript">
$(document).ready(function() {
	// 댓글 입력
	$("#btnCommInsert").click(function() {
		// 게시글 번호.... ${viewBoard.boardno }
	//		console.log($("#commentWriter").val());
// 			console.log($("#commentContent").val());
		
		$form = $("<form>").attr({
			action: "/comment/insert",
			method: "post"
		}).append(
			$("<input>").attr({
				type:"hidden",
				name:"boardNo",
				value:"${viewBoard.boardno }"
			})
		).append(
			$("<input>").attr({
				type:"hidden",
				name:"userid",
				value:"${sessionScope.account.account_nick }"
			})
		).append(
			$("<textarea>")
				.attr(	"name", "content")
				.css("display", "none")
				.text($("#commentContent").val())
		);
		$(document.body).append($form);
		$form.submit();
		
	});
	
});

//댓글 삭제
function deleteComment(commentNo) {
	$.ajax({
		type: "post"
		, url: "/comment/delete"
		, dataType: "json"
		, data: {
			commentNo: commentNo
		}
		, success: function(data){
			if(data.success) {
				
				$("[data-commentno='"+commentNo+"']").remove();
				
			} else {
				alert("댓글 삭제 실패");
			}
		}
		, error: function() {
			console.log("error");
		}
	});
}
</script>
	

<div class="container">

<h2 class="pull-left container font-dohyeon">공지사항     <small>게시판</small></h2>



<c:if test="${login }">
<button id="btnRecommend" class="btn pull-right" style="margin-top: 30px;"></button>
</c:if>

<div class="clearfix"></div>

<hr>

<table class="table table-bordered">
<tr>
<td class="info font-gothic" 
style="background-color: #FFF2EC">글번호</td><td colspan="3">${viewBoard.boardno }</td>
</tr>

<tr>
<td class="info font-gothic"
style="background-color: #FFF2EC">제목</td><td colspan="3">${viewBoard.title }</td>
</tr>

<tr>
<td class="info font-gothic"
style="background-color: #FFF2EC">아이디</td><td>${viewBoard.id }</td>
<td class="info font-gothic"
style="background-color: #FFF2EC">닉네임</td><td>${account.account_nick }</td>
</tr>

<tr>
<td class="info font-gothic"
style="background-color: #FFF2EC">조회수</td><td>${viewBoard.hit }</td>
<td class="info font-gothic"
style="background-color: #FFF2EC">작성일</td><td colspan="3">${viewBoard.writtendate }</td>
</tr>

<tr><td class="info font-gothic" colspan="4"
style="background-color: #FFF2EC">공지내용</td></tr>


<tr><td colspan="4">${viewBoard.content }</td></tr>

</table>

<div>
<a href="/file/download?fileno=${boardFile.fileno }">${boardFile.originName }</a>
</div>

<div class="text-center">	
	<button id="btnList" class="btn" style="background-color: #FFD2BD">목록</button>
	<c:if test="${sessionScope.account.account_nick eq viewBoard.id }">
	<button id="btnUpdate" class="btn" style="background-color: #7286FF">수정</button>
	<button id="btnDelete" class="btn" style="background-color: #FF6060">삭제</button>
	</c:if>
</div>

<hr>
<!-- 댓글 작성 -->
<div class="form-inline text-center">
	<input type="text" size="10" class="form-control" id="commentWriter" 
	value="${account.account_nick }" readonly="readonly" style="background-color: #FFF2EC"/>
	<input type="text" class="form-control" style="width:600px;" id="commentContent" name="commentContent" placeholder="댓글입력">
	<button id="btnCommInsert" class="btn font-gothic" style="background-color: #FFD2BD">입력</button>
</div>

<!-- 댓글 처리 -->
<div>

<hr>

<!-- 댓글 리스트 -->
<table class="table table-striped table-hover table-condensed">
<thead>
<tr>
	<th style="width: 5%;" class="font-gothic">번호</th>
	<th style="width: 10%;" class="font-gothic">작성자</th>
	<th style="width: 50%;" class="font-gothic">댓글</th>
	<th style="width: 20%;" class="font-gothic">작성일</th>
	<th style="width: 5%;" class="font-gothic"></th>
</tr>
</thead>
<tbody id="commentBody">
<c:forEach items="${commentList }" var="comment">
<tr data-commentno="${comment.commentNo }">
	<td class="font-gothic" style="background-color: #FFF">${comment.rnum }</td>
	<td class="font-gothic" style="background-color: #FFF">${comment.userid }</td><!-- 닉네임으로 해도 좋음 -->
	<td class="font-gothic" style="background-color: #FFF">${comment.content }</td>
	<td class="font-gothic" style="background-color: #FFF"><fmt:formatDate value="${comment.writtenDate }" pattern="yy-MM-dd" /></td>
	<td class="font-gothic" style="background-color: #FFF">
		<c:if test="${sessionScope.account.account_nick eq comment.userid }">
		<button class="btn btn-xs" style="background-color: #FFD2BD"
			onclick="deleteComment(${comment.commentNo });">삭제</button>
		</c:if>
	</td>
	
</tr>
</c:forEach>
</tbody>
</table>	<!-- 댓글 리스트 end -->

</div>	<!-- 댓글 처리 end -->




</div><!-- .container -->

<c:import url="/WEB-INF/views/layout/footer.jsp" />
