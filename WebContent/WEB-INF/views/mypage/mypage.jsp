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

<!-- 	<section class="content content--mypage">
	<header class="content_header" ><h1 class="content_title" style="font-size: 32px;">마이페이지</h1></header>
		<div class="content__side">
			<div class="profile-card">
				<i class="profile-card__bg"> <img alt="" src="">
				</i> <a class="profile-card__link" href=""> <img class="profile-card__pic" src="">
				</a> <span class="profile-card__text">아이디</span>
			</div>
			<nav class="side-nav">
				<ul class="side-nav__list">
					<li class="side-nav__item "><a href="">프로필 수정</a></li>
					<li class="side-nav__item "><a href="">회원 정보 변경</a></li>
					<li class="side-nav__item "><a href="">내가 쓴 글</a></li>
					<li class="side-nav__item "><a href="">내 옷장</a></li>
					<li class="side-nav__item"><a href="">선호하는 패션</a></li>
					<li class="side-nav__item"><a href="">옷 커스텀 하기</a></li>
					<li class="side-nav__item"><a href="">회원탈퇴</a></li>
				</ul>
			</nav>
		</div>
	</section> -->



<div class="container center">
	<div class="form-inline">
		<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
			<div class="thumbnail">
				<a href="/account/join"><img src="/resources/img/test1.jpg" style="height: 160px;" alt="..."></a>
			<div class="caption ">
				<h3><a href="/account/modify">프로필 수정</a></h3>
			</div>
			</div>
		</div>
		<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
			<div class="thumbnail">
				<a href="/account/join"><img src="/resources/img/test2.jpg" style="height: 160px;" alt="..."></a>
			<div class="caption">
				<h3><a href="/account/join">회원정보 변경</a></h3>
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
				<h3><a href="/account/join">내 옷장</a></h3>
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
				<a href="/account/join"><img src="/resources/img/test8.jpg" style="height: 160px;" alt="..."></a>
			<div class="caption">
				<h3><a href="/account/join">회원 탈퇴</a></h3>
			</div>
			</div>
		</div>
	</div>
</div>

</div>
<jsp:include page="/WEB-INF/views/layout/footer.jsp" />

