<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
    
<jsp:include page="/layout/header.jsp" />    

<title>로그인 화면</title>

<script type="text/javascript">

    function checkValue()
    {
        inputForm = eval("document.loginInfo");
        if(!inputForm.useremail.value)
        {
            alert("아이디를 입력하세요");    
            inputForm.useremail.focus();
            return false;
        }
        if(!inputForm.userpw1.value)
        {
            alert("비밀번호를 입력하세요");    
            inputForm.userpw1.focus();
            return false;
        }
    }
  
</script>


<body>

<!-- 이미지 -->
<div class="marginauto">
    <img src='/resources/img/ZIOZIO.png'  >
</div>

<div id="wrap">
<div class="container ">
	<div class="col-lg-3 "></div>
	<div class="col-lg-6 ">
		<div class="jumbotron padding" >
			<form name="loginInfo" method="post" action="/login" onsubmit="return checkValue()">
				<h3 class="center">로그인</h3>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="아이디(email)" name="useremail" maxlength="100"/>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="비밀번호" name="userpw1" maxlength="20"/>
				</div>

				<c:if test="${!empty result && !result}"> 
 					<h5 style="color: red;">비밀번호를 확인 해주세요</h5> 

				</c:if>
				<div class="form-group" >
				<input  type="submit" class="btn btn-primory form-control input color" value="로그인">
				</div>
			</form>
			<a href="/join">
				<input  type="submit" class="btn btn-primory form-control input color" value="회원가입">
			</a>
			<br><br>
			<a href="/findpw">
				<input  type="submit" class="btn btn-primory form-control input color" value="비밀번호 찾기">
			</a>
		</div>	
	</div>
	<div class="col-lg-3"></div>
</div>
</div>



<jsp:include page="/layout/footer.jsp" />
