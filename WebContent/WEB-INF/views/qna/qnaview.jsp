<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 

<script type="text/javascript">
$(document).ready(function() {
	//목록버튼 동작
	$("#btnList").click(function() {
		$(location).attr("href", "/qnalist");
	});
	
	//수정버튼 동작
	$("#btnUpdate").click(function() {
		$(location).attr("href", "/qnaupdate?qna_no=${viewQna.qna_no }");
	});

	//삭제버튼 동작
	$("#btnDelete").click(function() {
		$(location).attr("href", "/qnadelete?qna_no=${viewQna.qna_no }");
	});
	
});
</script>



<div class="container">

<h3 class="pull-left">문의사항</h3>



<c:if test="${login }">
<button id="btnRecommend" class="btn pull-right" style="margin-top: 30px;"></button>
</c:if>

<div class="clearfix"></div>

<hr>

<table class="table table-bordered ">
<tr>
<td class="font-gothic input2">글번호</td><td colspan="3">${viewQna.qna_no }</td>
</tr>

<tr>
<td class="font-gothic input2">제목</td><td colspan="3">${viewQna.qna_title }</td>
</tr>

<tr>

<td class="font-gothic input2">닉네임</td><td colspan="3">${viewQna.account_nick }</td>
</tr>

<tr>
<td class="font-gothic input2">작성일</td><td colspan="3">${viewQna.qna_writtendate }</td>
</tr>

<tr><td class="font-gothic input2"  colspan="4">문의내용</td></tr>


<tr><td class="font-gothic" colspan="4">${viewQna.qna_content }</td></tr>

</table>

<div>
<a href="/file/download?fileno=${qnaFile.qna_no }">${qnaFile.originName }</a>
</div>

<div class="text-center">	
	<button id="btnList" class="btn input">목록</button>
	<button id="btnUpdate" class="btn input">수정</button>
	<button id="btnDelete" class="btn input">삭제</button>
	
</div>

<hr>


</div><!-- .container -->

<c:import url="/WEB-INF/views/layout/footer.jsp" />
