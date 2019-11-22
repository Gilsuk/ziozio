<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/layout/header.jsp" /> 

<script type="text/javascript">

    function checkValue()
    {
        inputForm = eval("document.loginInfo");
        if(!inputForm.userId.value)
        {
            alert("아이디를 입력하세요");    
            inputForm.userId.focus();
            return false;
        }
        if(!inputForm.userPw.value)
        {
            alert("비밀번호를 입력하세요");    
            inputForm.userPw.focus();
            return false;
        }
        if(!inputForm.userName.value)
        {
            alert("이름을 입력하세요");    
            inputForm.userName.focus();
            return false;
        }
        if(!inputForm.userNick.value)
        {
            alert("닉네임을 입력하세요");    
            inputForm.userNick.focus();
            return false;
        }
        if(!inputForm.userBirth.value)
        {
            alert("생년월일을 입력하세요");    
            inputForm.userBbirth.focus();
            return false;
        }
        if(!inputForm.userPhone.value)
        {
            alert("전화번호를 입력하세요");    
            inputForm.userPhone.focus();
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


<body>

<!-- 이미지 -->
<div class="marginauto">
    <img src='/resources/img/ZIOZIO.png' >
</div>

<div id="wrap">
<div class="container">
	<div class="clo-lg-3"></div>
	<div class="clo-lg-6">
		<div class="jumbotron padding" >
			<form name="loginInfo" method="post" action="/join" onsubmit="return checkValue()">
				<h3 class="center">회원가입</h3>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="아이디" name="userId" maxlength="20"/>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="비밀번호" name="userPw" maxlength="20"/>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="이름" name="userName" maxlength="10"/>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="닉네임" name="userNick" maxlength="10"/>
				</div>
				<div class="form-group">
					<div class="form-inline" name="userBirth">
						<div class="form-group">
							<input  type="text"  placeholder="년(4자)" class="form-control width" maxlength="4"/>
						</div>
						<div class="form-group">
							<label class="sr-only" for="bir_mm"></label>
							<select id="bir_mm" class="form-control width"  >
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
							<input  type="text" id="bir_dd" placeholder="일"  class="form-control width" maxlength="2"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="전화번호 입력" name="userPhone" maxlength="20"/>
				</div>
				<div class="form-group">
					<input type="email" class="form-control" placeholder="이메일" name="userEmail" maxlength="50"/>
				</div>
				<div class="form-group center" >
					<div class="btn-group " data-toggle="buttons">
						<label class="btn input" >
							<input type="radio" name="userGender" autocomplete="off" value="남자" checked />남자
						</label>
						<label class="btn input" >
							<input type="radio" name="userGender" autocomplete="off" value="여자" checked />여자
						</label>
						<label class="btn input" >
							<input type="radio" name="userGender" autocomplete="off" value="중성" checked />중성
						</label>
					</div>
				</div>

				<div class="form-group">
					<input type="submit" class="btn btn-primory form-control input color" value="회원 가입하기">
				</div>
			</form>
			<div class="form-group">
				<a href="/main">
					<input type="submit" class="btn btn-primory form-control input color" value="가입취소">
				</a>
			</div>
		</div>	
	</div>
	<div class="col-lg-3"></div>
</div>
</div>

<jsp:include page="/layout/footer.jsp" />

