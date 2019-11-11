<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>로그인 화면</title>


<style type="text/css">
img {
	width: 500px;
	height: 300px;
}
input[type="text, password" ] {
	width: 120px;
	height: 100px;
}
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
					<li class="active"><a href="login.jsp">로그인</a></li>
					<li><a href="./join.jsp">회원가입</a></li>
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
	<div class="clo-lg-4"></div>
	<div class="clo-lg-4">
		<div class="jumbotron" style="padding-top: 20px;">
			<form name="loginInfo" method="post" action="LoginAtion.jsp" onsubmit="return checkValue()">
				<h3 style="text-align: center;">로그인 화면</h3>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="아이디" name="userID" maxlength="20"/>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20"/>
				</div>
				<div class="form-group">
				<input style="background: #F0E378;" type="submit" class="btn btn-primory form-control" value="로그인">
				</div>
		
			</form>
			<a href="./join.jsp">
				<input style="background: #F0E378;" type="submit" class="btn btn-primory form-control" value="회원가입">
			</a>
			<br><br>
			<a href="./.jsp">
				<input style="background: #F0E378;" type="submit" class="btn btn-primory form-control" value="아이디/비밀번호 찾기">
			</a>
		</div>	
	</div>
	<div class="col-lg-4"></div>
</div>
</div>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>

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





<!-- <div id="wrap"> -->
<!-- 	<form> -->

<!-- 		<table> -->
<!-- 			<tr> -->
<!-- 				<td>아이디</td> -->
<!--                 <td><input type="text" name="id" maxlength="30"></td> -->
<!--             </tr> -->
<!--             <tr> -->
<!--                 <td>비밀번호</td> -->
<!--                 <td><input type="password" name="password" maxlength="30"></td> -->
<!--             </tr> -->
<!--         </table> -->
<!--         <br> -->
<!-- <input type="submit" value="로그인"/> -->
<!-- <input type="button" value="회원가입" onclick="goJoinForm()" /> -->

<!--     </form> -->