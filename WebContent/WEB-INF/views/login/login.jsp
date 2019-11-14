<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/layout/header.jsp" />    

<title>로그인 화면</title>

<script type="text/javascript">

    function checkValue()
    {
        inputForm = eval("document.loginInfo");
        if(!inputForm.userID.value)
        {
            alert("아이디를 입력하세요");    
            inputForm.userID.focus();
            return false;
        }
        if(!inputForm.userPassword.value)
        {
            alert("비밀번호를 입력하세요");    
            inputForm.userPassword.focus();
            return false;
        }
    }
  
</script>

<!-- 이미지 -->
<div class="a">
    <img src='/resources/img/ZIOZIO.png'  >
</div>

<div id="wrap">
<div class="container ">
	<div class="col-lg-12 "></div>
	<div class="col-lg-12 ">
		<div class="jumbotron a1" >
			<form name="loginInfo" method="post" action="/login" onsubmit="return checkValue()">
				<h3 class="a2">로그인 화면</h3>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="아이디" name="userID" maxlength="20"/>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20"/>
				</div>
				<div class="form-group" >
				<input  type="submit" class="btn btn-primory form-control abc" value="로그인">
				</div>
		
			</form>
			<a href="/join">
				<input  type="submit" class="btn btn-primory form-control abc" value="회원가입">
			</a>
			<br><br>
			<a href="/findpw">
				<input  type="submit" class="btn btn-primory form-control abc" value="비밀번호 찾기">
			</a>
		</div>	
	</div>
	<div class="col-lg-12"></div>
</div>
</div>



<div>
<% 
	String msg=request.getParameter("msg");
	
	if(msg!=null && msg.equals("0")) 
	{
	    out.println("<br>");
	    out.println("<font color='red' size='5'>비밀번호를 확인해 주세요.</font>");
	}
	else if(msg!=null && msg.equals("-1"))
	{    
	    out.println("<br>");
	    out.println("<font color='red' size='5'>아이디를 확인해 주세요.</font>");
	}
%>    
</div>    

<jsp:include page="/layout/footer.jsp" />
