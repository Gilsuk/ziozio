<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 

<script type="text/javascript">
$(document).ready(function() {
	
	//글쓰기 버튼 누르면 이동
	$("#btnWrite").click(function() {
		location.href="/board/write";
	});
	
});
</script>

<style type="text/css">
table, th {
	text-align: center;
}

tr td:nth-child(2) {
	text-align: left;
}

tr td:not(:first-child), tr th:not(:first-child) {
	border-left: 1px solid white;
}

</style>

<div id="wrap">
<div class="container">
	
	<div class="col-lg-12">
		<div class="jumbotron padding" style="background-color: #FFF2EC">

<h1 class="font-dohyeon">공지사항     <small>게시판</small></h1>
<hr>

<table class="table table-hover table-condensed table-striped">
<tr style="background-color: #FFD2BD;" class="font-gothic">
	<th style="width: 10%">글번호</th>
	<th style="width: 50%">제목</th>
	<th style="width: 15%">아이디</th>
	<th style="width: 10%">조회수</th>
	<th style="width: 15%">작성일</th>
</tr>
<c:forEach items="${list }" var="board">
<tr>
	<td>${board.boardno }</td>
	<td><a href="/board/view?boardno=${board.boardno }">${board.title }</a></td>
	<td>${board.id }</td>
	<td>${board.hit }</td>
	<td><fmt:formatDate value="${board.writtendate }" pattern="yyyy-MM-dd"/></td>
</tr>
</c:forEach>
</table>

<jsp:include page="/WEB-INF/views/layout/paging.jsp" />

<div class="text-center">
	<form action="/board/list" method="get">
	<div class="form-group">
		<div class="form-inline">
			<select class="form-control" name="category" >
				<option value="1">제목</option>
				<option value="2">내용</option>
				<option value="3">제목  + 내용</option>
			</select>
   			<input type="text" class="form-control" style="width:300px;" name="search" placeholder="공지사항 검색">
	    	<button type="submit" class="btn" style="background-color: #FFD2BD">검색</button>
		</div>
	</div>
	</form>
</div>

<c:if test="${account.account_grade_code == 1 }">
	<div id="btnBox" class="text-right">
		<button id="btnWrite" class="btn btn-Warning input1">글쓰기</button>
	</div>
</c:if>
</div>
</div>
</div>
</div><!-- .container -->








