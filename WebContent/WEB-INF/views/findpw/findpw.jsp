<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/layout/header.jsp" />   

<title>비밀번호 찾기</title>

<body>


<!-- 이미지 -->
<div class="a">
    <img src='/resources/img/ZIOZIO.png'  >
</div>

<div id="wrap">
<div class="container">
	<div class="col-lg-12 "></div>
	<div class="col-lg-12 ">
		<div class="jumbotron a1" >
			<form name="loginInfo" method="post" action="/findPw" onsubmit="return checkValue()">
				<h3 class="a2">비밀번호 찾기</h3>
				<div class="form-group">
					<input type="email" class="form-control" placeholder="가입한 이메일을 입력하세요" name="userEmail" maxlength="50"/>
				</div>
				
			</form>
			<div class="form-group">	
				<a href="/findpw">
					<input type="submit" class="btn btn-primory form-control abc" value="다음">
				</a>
			</div>	
			
			
			
		</div>	
	</div>
	<div class="col-lg-12"></div>
</div>
</div>

<jsp:include page="/layout/footer.jsp" />
