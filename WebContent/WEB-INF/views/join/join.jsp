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

<title>회원가입 화면</title>


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
        if(!inputForm.userName.value)
        {
            alert("이름을 입력하세요");    
            inputForm.userName.focus();
            return false;
        }
        if(!inputForm.useBirth.value)
        {
            alert("생년월일을 입력하세요");    
            inputForm.useBbirth.focus();
            return false;
        }
        if(!inputForm.userNumber.value)
        {
            alert("전화번호를 입력하세요");    
            inputForm.userNumber.focus();
            return false;
        }
        if(!inputForm.userEmail.value)
        {
            alert("이메일을 입력하세요");    
            inputForm.userEmail.focus();
            return false;
        }
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
			<li><a href="/main.jsp">메인</a></li>
			<li><a href="/.jsp">게시판</a></li>
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
	<div class="clo-lg-12"></div>
	<div class="clo-lg-12">
		<div class="jumbotron" style="padding-top: 20px;">
			<form name="loginInfo" method="post" action="/join" onsubmit="return checkValue()">
				<h3 style="text-align: center;">회원가입 화면</h3>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="아이디" name="userID" maxlength="20"/>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20"/>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="이름" name="userName" maxlength="10"/>
				</div>
				<div class="form-group">
					<div class="form-inline" name="useBirth">
						<div class="form-group">
							<label class="sr-only" for="bir_yy"></label>
							<input style="width: 120px;" type="text" id="bir_yy" placeholder="년(4자)" class="form-control" maxlength="4"/>
						</div>
						<div class="form-group">
							<label class="sr-only" for="bir_mm"></label>
							<select id="bir_mm" class="form-control" style="width: 120px;" >
								<option value="01">01</option>
								<option value="02">02</option>
								<option value="03">03</option>
								<option value="04">04</option>
								<option value="05">05</option>
								<option value="06">06</option>
								<option value="07">07</option>
								<option value="08">08</option>
								<option value="09">09</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
							</select>
						</div>
						<div class="form-group">
							<label class="sr-only" for="bir_dd"></label>
							<input style="width: 120px;" type="text" id="bir_dd" placeholder="일"  class="form-control" maxlength="2"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="전화번호 입력" name="userNumber" maxlength="20"/>
				</div>
				<div class="form-group">
					<input type="email" class="form-control" placeholder="이메일" name="userEmail" maxlength="50"/>
				</div>
				<div class="form-group" style="text-align: center;">
					<div class="btn-group" data-toggle="buttons">
						<label class="btn btn-primary active" style="background: #F0E378; border-color: #F0E378">
							<input type="radio" name="userGender" autocomplete="off" value="남자" checked />남자
						</label>
						<label class="btn btn-primary" style="background: #F0E378; border-color: #F0E378">
							<input type="radio" name="userGender" autocomplete="off" value="여자" checked />여자
						</label>
						<label class="btn btn-primary" style="background: #F0E378; border-color: #F0E378">
							<input type="radio" name="userGender" autocomplete="off" value="중성" checked />중성
						</label>
					</div>
				</div>
				<div class="form-group">
					<input style="background: #F0E378;" type="submit" class="btn btn-primory form-control" value="회원 가입하기">
				</div>
			</form>
			<div class="form-group">
				<a href="/main">
					<input style="background: #F0E378;" type="submit" class="btn btn-primory form-control" value="가입취소">
				</a>
			</div>
		</div>	
	</div>
	<div class="col-lg-12"></div>
</div>
</div>



   

</body>
</html>

