<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/layout/header.jsp" /> 

<script type="text/javascript">

    function checkValue()
    {
        inputForm = eval("document.loginInfo");
    
        if(!inputForm.useremail.value)
        {
        	$("#checkMessage").html("이메일을 입력하세요.");
			$("#checkType").attr("class", "modal-content panel-warning");
			$("#checkModal").modal("show");  
            inputForm.useremail.focus();
            return false;
        }
        if(!inputForm.userpw1.value)
        {
        	$("#checkMessage").html("비밀번호를 입력하세요.");
			$("#checkType").attr("class", "modal-content panel-warning");
			$("#checkModal").modal("show");
			inputForm.userpw1.focus();
            return false;
        }
        if(!inputForm.userpw2.value)
        {
        	$("#checkMessage").html("비밀번호를 입력하세요.");
			$("#checkType").attr("class", "modal-content panel-warning");
			$("#checkModal").modal("show");  
            inputForm.userpw2.focus();
            return false;
        }
        if(!inputForm.username.value)
        {
        	$("#checkMessage").html("이름을 입력하세요.");
			$("#checkType").attr("class", "modal-content panel-warning");
			$("#checkModal").modal("show");
			inputForm.username.focus();
			return false;
        }
        if(!inputForm.usernick.value)
        {
        	$("#checkMessage").html("닉네임을 입력하세요.");
			$("#checkType").attr("class", "modal-content panel-warning");
			$("#checkModal").modal("show");
			inputForm.usernick.focus();
            return false;
        }
        if(!inputForm.userbirth_year.value)
        {
        	$("#checkMessage").html("태어난 년도를 입력하세요.");
			$("#checkType").attr("class", "modal-content panel-warning");
			$("#checkModal").modal("show");
			inputForm.userbirth_year.focus();
            return false;
        }
        if(!inputForm.userbirth_mon.value)
        {
        	$("#checkMessage").html("태어난 월을 입력하세요.");
			$("#checkType").attr("class", "modal-content panel-warning");
			$("#checkModal").modal("show");
			inputForm.userbirth_mon.focus();
            return false;
        }
        if(!inputForm.userbirth_day.value)
        {
        	$("#checkMessage").html("태어난 일을 입력하세요.");
			$("#checkType").attr("class", "modal-content panel-warning");
			$("#checkModal").modal("show");
			inputForm.userbirth_day.focus();
            return false;
        }
        if(!inputForm.userphone.value)
        {
        	$("#checkMessage").html("전화번호를 입력하세요.");
			$("#checkType").attr("class", "modal-content panel-warning");
			$("#checkModal").modal("show");
			inputForm.userphone.focus();
            return false;
        }
        if(!inputForm.usergender.value)
        {
        	$("#checkMessage").html("성별을 체크 하세요.");
			$("#checkType").attr("class", "modal-content panel-warning");
			$("#checkModal").modal("show");
			inputForm.usergender.focus();
            return false;
        }
        
    } 

    function emailCheckFunction() {
    	var useremail = $("#useremail").val();
    	$.ajax({
    		type: "GET",
    		url: "/emailcheck",
    		data: {useremail: useremail},
    		success: function(result) {
    			
    			console.log(result)
    			
    			if(result == 1) {
    				$("#checkMessage").html("사용할 수 있는 email입니다.");
    				$("#checkType").attr("class", "modal-content panel-success");
    			}
    			else {
    				$("#checkMessage").html("사용할 수 없는 email입니다.");
    				$("#checkType").attr("class", "modal-content panel-warning");
    			}
    			$("#checkModal").modal("show");
    		}
    	})
    }
    
    function nickCheckFunction() {
    	var usernick = $("#usernick").val();
    	$.ajax({
    		type: "GET",
    		url: "/nickcheck",
    		data: {usernick: usernick},
    		success: function(result) {
    			
    			console.log(result)
    			
    			if(result == 1) {
    				$("#checkMessage").html("사용할 수 있는 닉네임입니다.");
    				$("#checkType").attr("class", "modal-content panel-success");
    			}
    			else {
    				$("#checkMessage").html("사용할 수 없는 닉네임입니다.");
    				$("#checkType").attr("class", "modal-content panel-warning");
    			}
    			$("#checkModal").modal("show");
    		}
    	})
    }
    
    function pwCheckFunction() {
    	var userpw1 = $("#userpw1").val();
    	var userpw2 = $("#userpw2").val();
    	if(userpw1 != userpw2) {
    		$("#pwCheckMessage").html("비밀번호가 일치하지 않습니다");
    	} else {
    		$("#pwCheckMessage").html("");
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
	<div class="col-lg-3"></div>
	<div class="col-lg-6">
		<div class="jumbotron padding" >
			<form name="loginInfo" method="post" action="/join" onsubmit="return checkValue()">
				<h3 class="center">회원가입</h3>
				<div class="form-group">
					<div class="form-inline" >
						<input type="email" class="form-control" style="width: 330px;" placeholder="아이디(이메일)" name="useremail" id="useremail" maxlength="100"/>
						<button class="btn tn-primary input" onclick="emailCheckFunction();" type="button">중복체크</button>
					</div>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="비밀번호" onkeyup="pwCheckFunction();" name="userpw1" id="userpw1" maxlength="50"/>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="비밀번호" onkeyup="pwCheckFunction();" name="userpw2" id="userpw2" maxlength="50"/>
				<h5 style="color: red;" id="pwCheckMessage"></h5> 
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="이름" name="username" id="username" maxlength="50"/>
				</div>
				<div class="form-group">
					<div class="form-inline" >
						<input type="text" class="form-control" style="width: 330px;" placeholder="닉네임" name="usernick" id="usernick" maxlength="50"/>
						<button class="btn tn-primary input" onclick="nickCheckFunction();" type="button">중복체크</button>
					</div>
				</div>
				<div class="form-group">
					<div class="form-inline" >
						<div class="form-group">
							<input name="userbirth_year" type="text"  placeholder="년(4자)" class="form-control width" maxlength="4"/>
						</div>
						<div class="form-group">
							<label class="sr-only" for="userbirth_mon"></label>
							<select name="userbirth_mon" id="userbirth_mon" class="form-control width"  >
								<option value=""></option>
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
							<input name="userbirth_day" type="text"  placeholder="일"  class="form-control width" maxlength="2"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="전화번호 입력" name="userphone" id="userphone" maxlength="50"/>
				</div>
				<div class="form-group center" >
					<div class="btn-group " data-toggle="buttons">
						<label class="btn input" >
							<input type="radio" name="usergender" autocomplete="off" value="남자" checked />남자
						</label>
						<label class="btn input" >
							<input type="radio" name="usergender" autocomplete="off" value="여자" checked />여자
						</label>
						<label class="btn input" >
							<input type="radio" name="usergender" autocomplete="off" value="중성" checked />중성
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

<% 
	String messageContent = null;
	if(session.getAttribute("messageContent") != null) {
		messageContent = (String) session.getAttribute("messageContent");
	}
	String messageType = null;
	if(session.getAttribute("messageType") != null) {
		messageType = (String) session.getAttribute("messageType");
	}
	if(messageContent != null) {
		
	
%>
<div class="modal fade" id="checkModal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="vertical-alignment-helper">
		<div class="modal-dialog vertical-align-center">
			<div class="modal-content" <% if(messageType.equals("오류메세지")) out.println("panel-warning"); else out.println("panel-success"); %>>
				<div class="modal-header panel-heading">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span>
						<span class="sr-only">close</span>
					</button>
					<h4 class="modal-title">
						<%= messageType %>
					</h4>
				</div>
				<div class="modal-body">
					<%= messageContent %>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$("#messageModal").modal("show");
</script>
<%
	session.removeAttribute("messageContent");
	session.removeAttribute("messageType");	
	}
%>


<div class="modal fade" id="checkModal" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="vertical-alignment-helper">
		<div class="modal-dialog vertical-align-center">
			<div id="checkType" class="modal-content panel-info">
				<div class="modal-header panel-heading">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span>
						<span class="sr-only">close</span>
					</button>
					<h4 class="modal-title">
						확인 메세지
					</h4>
				</div>
				<div class="modal-body" id="checkMessage">
				</div>
				
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/layout/footer.jsp" />

