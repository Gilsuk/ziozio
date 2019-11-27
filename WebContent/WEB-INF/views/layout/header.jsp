<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image⁄x-icon" href="">
<link rel="stylesheet" href="/resources/css/style.css" />
<meta charset="UTF-8">
<title>ZIOZIO</title>

<script
  src="https://code.jquery.com/jquery-2.2.4.min.js"
  integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
  crossorigin="anonymous"></script>
  
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">


<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
 </head>
 

 
<body>
 <div id="header" >
<nav class="navbar navbar-default">
	<div class="navbar-header">
		<a class="navbar-brand" href="/">ZIOZIO</a>
	</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li><a href="/">메인</a></li>
			<li><a href="/">게시판</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">메뉴<span class="caret"></span></a>
				<ul class="dropdown-menu" style="width: 200px;" >
				<c:choose>
					<c:when test="${not empty account }">
					WELCOME ${account.account_nick}님<hr>
						<li><a href="/mypage">마이페이지</a></li>
						<li><a href="/board">게시판</a></li>
						<li><a href="/column">column</a></li>
						<li><a href="/qna">QnA</a></li>
						<li><a href="/account/logout">로그아웃</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/account/join">회원가입</a></li>
						<li><a href="/account/login">로그인</a></li>
						<li><a href="/account/find">비밀번호 찾기</a></li>
						<li><a href="/board">게시판</a></li>
						<li><a href="/column">column</a></li>
					</c:otherwise>
				</c:choose>

				</ul>
			</li>
		</ul>
	</div>
</nav>
</div>






