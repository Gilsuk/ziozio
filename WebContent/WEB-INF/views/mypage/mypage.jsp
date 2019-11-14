<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
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
<link href=" //d2h5doj4xlbun0.cloudfront.net/member-0.0.1278/css/share/share.css" rel="stylesheet">
<link href="//d2h5doj4xlbun0.cloudfront.net/member-0.0.1278/css/member/member.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default">
	<div class="navbar-header">
		<a class="navbar-brand" href="main.jsp">ZIOZIO</a>
	</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li><a href="main.jsp">메인</a>
			<li><a href="main.jsp">게시판</a>
			</li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">메뉴<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li class="active"><a href="/login">로그인</a></li>
					<li><a href="/join">회원가입</a></li>
				</ul>
			</li>
		</ul>
	</div>
</nav>




	
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



</body>

