<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

    
<jsp:include page="/WEB-INF/views/layout/header.jsp" />  

 
<title>비밀번호 찾기</title>

<body>


<!-- 이미지 -->
<div class="marginauto">
    <img class="ziozio" src='/resources/img/ZIOZIO.png'  >
</div>

<div id="wrap">
<div class="container" >
	<div class="col-lg-3 "></div>
	<div class="col-lg-6 ">
		<div class="jumbotron padding" style="background-color: #FFF2EC">
			<form name="loginInfo" method="post" action="/account/find" onsubmit="return checkValue()">
				<h3 class="center font-dohyeon">비밀번호 찾기</h3><br>
				<div class="form-group">
					<input type="email" class="form-control" placeholder="가입한 이메일을 입력하세요" class="font-gothic" name="account_email" maxlength="50"/>
				</div>
				
			</form>
			<div class="form-group">	
				<a href="/account/find">

					<input type="submit" class="btn btn-primory form-control input color font-dohyeon" value="다음">

				</a>
			</div>	
			
			
			
		</div>	
	</div>
	<div class="col-lg-3"></div>
</div>
</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
