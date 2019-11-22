<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<jsp:include page="/layout/header.jsp" /> 


	
	<div class="wrapper" id="wrapper">
	
		<section class="content content--mypage">
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
					</ul>
				</nav>
			</div>
		</section>
	</div>



<jsp:include page="/layout/footer.jsp" />

