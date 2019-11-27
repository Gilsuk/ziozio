<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 

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

<div class="marginauto">
    <img src='/resources/img/ZIOZIO.png' >
</div>





<div class="container bootstrap snippet">
	<div class="row">
		<div class="col-lg-1"></div>
		<div class="col-lg-10">
			<div class="jumbotron padding" >
			<div class="portlet portlet-default">
				<div class="portlet-heading">
					<div class="portlet-title center">
						<h3>Questions & Answers</h3>
					</div>
					<div class="clearfix"></div>
				</div>
				<div id="chat" class="panel-collapse collapse in">
					<div id="chatlist" class="porlet-body chat-widget" style="overflow-y: auto; width: auto; height: 600px;">
					
					<table class="table table-hover table-condensed table-striped">
					<tr>
						<th style="width: 10%">글번호</th>
						<th style="width: 50%">제목</th>
						<th style="width: 20%">닉네임</th>
						<th style="width: 20%">작성일</th>
					</tr>
					<c:forEach items="${list }" var="board">
					<tr>
						<td>${board.boardno }</td>
						<td><a href="/qnaview?boardno=${board.boardno }">${board.title }</a></td>
						<td>${board.id }</td>
						<td><fmt:formatDate value="${board.writtendate }" pattern="yyyy-MM-dd"/></td>
					</tr>
					</c:forEach>
					</table>
					
				
					<div class="clearfix"></div>
					</div>
				</div>
				
				<jsp:include page="/WEB-INF/views/layout/qnapaging.jsp" />
				
				<div class="form-inline right" id="btnBox" >
					<a href="/qnaview"><button class="btn btn-Warning input1" type="submit">글쓰기</button></a>
				</div>
				<div class="clearfix"></div>
			</div>
			</div>
		</div>	
		<div class="col-lg-1"></div>
	</div>	
</div>