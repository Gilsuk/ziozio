<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

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

<title>로그인 화면</title>


<style type="text/css">


</style>

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

    // 회원가입 버튼 클릭시 회원가입 화면으로 이동
    function goJoinForm() {
        location.href=".jsp";
    }    
</script>
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
<!-- 이미지 -->
<div style="margin: 0 auto; width: fit-content; ">
    <img src='/resources/img/ZIOZIO.png'  >
</div>

<div id="wrap">
<div class="container">
	<div class="col-lg-12 "></div>
	<div class="col-lg-12 ">
		<div class="jumbotron" style="padding-top: 20px;">
			<form name="loginInfo" method="post" action="/Login" onsubmit="return checkValue()">
				<h3 style="text-align: center;">로그인 화면</h3>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="아이디" name="userID" maxlength="20"/>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20"/>
				</div>
				<div class="form-group" >
				<input style="background: #F0E378;" type="submit" class="btn btn-primory form-control" value="로그인">
				</div>
		
			</form>
			<a href="/join">
				<input style="background: #F0E378;" type="submit" class="btn btn-primory form-control" value="회원가입">
			</a>
			<br><br>
			<a href="./.jsp">
				<input style="background: #F0E378;" type="submit" class="btn btn-primory form-control" value="아이디/비밀번호 찾기">
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

</body>
</html>
