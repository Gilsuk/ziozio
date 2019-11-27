<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<jsp:include page="/layout/header.jsp" /> 




<div class="container ">
	<div class="marginauto ">
  		<img src='/resources/img/ZIOZIO.png' >
  	</div>
</div>

<c:if test="${not empty account }">
	<div class="text-center"><h1>${account.account_nick } 님 로그인되었습니다.</h1></div>
</c:if>


<c:if test="${empty account }">
	<div class="text-center"><br>
		<a class="btn btn-default input" href="/login" role="button">로그인</a>
		<a class="btn btn-default input" href="/join" role="button">회원가입</a>
	</div>
</c:if>



<jsp:include page="/layout/footer.jsp" />
