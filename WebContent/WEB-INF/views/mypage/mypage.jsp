<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 

<style type="text/css">





</style>

<div class="marginauto">
    <img src='/resources/img/ZIOZIO.png' >
</div>
	
<div class="wrapper">
<div class="container center">
<div class="jumbotron padding" >
<h2>My Page</h2><br><br>
<div class="row">
<div class="col-lg-12">
	<div class="form-inline">
		<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
			<div class="thumbnail">
				<a href="/account/join"><img src="/resources/img/test1.jpg" style="height: 160px;" alt="..."></a>
			<div class="caption ">
				<h3><a href="/account/modify">회원정보 변경</a></h3>
			</div>
			</div>
		</div>
		<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
			<div class="thumbnail">
				<a href="/account/join"><img src="/resources/img/test2.jpg" style="height: 160px;" alt="..."></a>
			<div class="caption">
				<h3><a href="/account/join">빈공간</a></h3>
			</div>
			</div>
		</div>
		<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
			<div class="thumbnail">
				<a href="/account/join"><img src="/resources/img/test3.jpg" style="height: 160px;" alt="..."></a>
			<div class="caption">
				<h3><a href="/account/join">내가 쓴 글</a></h3>
			</div>
			</div>
		</div>
		<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
			<div class="thumbnail">
				<a href="/account/join"><img src="/resources/img/test4.jpg" style="height: 160px;" alt="..."></a>
			<div class="caption">
				<h3><a href="/account/library">내 옷장</a></h3>
			</div>
			</div>
		</div>
	</div>	
			
	<div class="form-inline">
		<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
			<div class="thumbnail">
				<a href="/account/join"><img src="/resources/img/test5.jpg" style="height: 160px;" alt="..."></a>
			<div class="caption">
				<h3><a href="/account/join">선호하는 패션</a></h3>
			</div>
			</div>
		</div>
		<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
			<div class="thumbnail">
				<a href="/account/join"><img src="/resources/img/test6.png" style="height: 160px;" alt="..."></a>
			<div class="caption">
				<h3><a href="/account/join">옷 커스텀</a></h3>
			</div>
			</div>
		</div>
		<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
			<div class="thumbnail">
				<a href="/account/join"><img src="/resources/img/test7.jpg" style="height: 160px;" alt="..."></a>
			<div class="caption">
				<h3><a href="/account/join">빈 공간</a></h3>
			</div>
			</div>
		</div>
		<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
			<div class="thumbnail">
				<a href="/withdrawal"><img src="/resources/img/test8.jpg" style="height: 160px;" alt="..."></a>
			<div class="caption">
				<h3><a href="/withdrawal">회원 탈퇴</a></h3>
			</div>
			</div>
		</div>
	</div>
</div>
</div>
</div>
</div>
</div>
<jsp:include page="/WEB-INF/views/layout/footer.jsp" />

