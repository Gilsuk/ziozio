<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 

<div class="marginauto">
    <a href="/main"><img class="ziozio" src='/resources/img/ZIOZIO.png' ></a>
</div>
	
<div class="wrapper font-dohyeon">
<div class="container center">
<div class="jumbotron padding" style="background-color: #FFF2EC">
<h1 class="font-dohyeon">MY PAGE</h1><br><br>
<div class="row">
<div class="col-lg-12 font-dohyeon">
	<div class="form-inline">
		<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
			<div class="thumbnail">
				<a href="/account/changepw"><img src="/resources/img/mypage_pictures/change.png" style="height: 160px;" alt="..."></a>
			<div class="caption ">
				<h3><a href="/account/changepw">비밀번호 변경</a></h3>
			</div>
			</div>
		</div>
		<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
			<div class="thumbnail">
				<a href="/account/library"><img src="/resources/img/mypage_pictures/closet.png" style="height: 160px;" alt="..."></a>
			<div class="caption">
				<h3><a href="/account/library">MY ROOM</a></h3>
			</div>
			</div>
		</div>
		<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
			<div class="thumbnail">
				<a href="/cloth/select"><img src="/resources/img/mypage_pictures/writing.png" style="height: 160px;" alt="..."></a>
			<div class="caption">
				<h3><a href="/cloth/select">옷 둘러보기</a></h3>
			</div>
			</div>
		</div>



			
	<div class="form-inline">
		<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
			<div class="thumbnail">
				<a href="/account/custom"><img src="/resources/img/mypage_pictures/custom.png" style="height: 160px;" alt="..."></a>
			<div class="caption">
				<h3><a href="/account/custom">CUSTOM</a></h3>
			</div>
			</div>
		</div>
				<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
			<div class="thumbnail">
				<a href="/stylecheck"><img src="/resources/img/mypage_pictures/preference.png" style="height: 160px;" alt="..."></a>
			<div class="caption">
				<h3><a href="/stylecheck">STYLE CHECK</a></h3>
			</div>
			</div>
		</div>
		<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
			<div class="thumbnail">
				<a href="/withdrawal"><img src="/resources/img/mypage_pictures/withdrawal.png" style="height: 160px;" alt="..."></a>
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
</div>
<jsp:include page="/WEB-INF/views/layout/footer.jsp" />

