<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>    


<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 

<script type="text/javascript">

    function checkValue()
    {
        inputForm = eval("document.loginInfo"); {
    
	        if(!inputForm.account_email.value)
	        {
	        	$("#checkMessage").html("이메일을 입력하세요.");
				$("#checkType").attr("class", "modal-content panel-warning");
				$("#checkModal").modal("show");  
	            inputForm.account_email.focus();
	            return false;
	        }
	        if(!inputForm.account_pw.value)
	        {
	        	$("#checkMessage").html("비밀번호를 입력하세요.");
				$("#checkType").attr("class", "modal-content panel-warning");
				$("#checkModal").modal("show");
				inputForm.account_pw.focus();
	            return false;
	        }
	        if(!inputForm.account_pw2.value)
	        {
	        	$("#checkMessage").html("비밀번호를 입력하세요.");
				$("#checkType").attr("class", "modal-content panel-warning");
				$("#checkModal").modal("show");  
	            inputForm.account_pw2.focus();
	            return false;
	        }
	        if(!inputForm.account_nick.value)
	        {
	        	$("#checkMessage").html("닉네임을 입력하세요.");
				$("#checkType").attr("class", "modal-content panel-warning");
				$("#checkModal").modal("show");
				inputForm.account_nick.focus();
	            return false;
	        }
	        if(!inputForm.account_gender.value)
	        {
	        	$("#checkMessage").html("성별을 체크 하세요.");
				$("#checkType").attr("class", "modal-content panel-warning");
				$("#checkModal").modal("show");
				inputForm.account_gender.focus();
	            return false;
	        }
        }
    } 

    function emailCheckFunction() {
    	var account_email = $("#account_email").val();
    	$.ajax({
    		type: "GET",
    		url: "/emailcheck",
    		data: {account_email: account_email},
    		success: function(result) {
				$("#checkMessage").html(result);
				$("#checkType").attr("class", "modal-content panel-success");
				$("#checkModal").modal("show");
			}
		})
	}

	function nickCheckFunction() {
		var account_nick = $("#account_nick").val();
		$.ajax({
			type : "GET",
			url : "/nickcheck",
			data : {
				account_nick : account_nick
			},
			success : function(result) {

				console.log(result)

				if (result == 1) {
					$("#checkMessage").html("사용할 수 있는 닉네임입니다.");
					$("#checkType")
							.attr("class", "modal-content panel-success");
				} else {
					$("#checkMessage").html("사용할 수 없는 닉네임입니다.");
					$("#checkType")
							.attr("class", "modal-content panel-warning");
				}
				$("#checkModal").modal("show");
			}
		})
	}

	function pwCheckFunction() {
		var account_pw = $("#account_pw").val();
		var account_pw2 = $("#account_pw2").val();
		if (account_pw != account_pw2) {
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
			<form name="loginInfo" method="post" action="/account/join" onsubmit="Freturn checkValue()">
				<h3 class="center">회원가입</h3>
				<div class="form-group">
					<div class="form-inline" >
						<input type="email" class="form-control" style="width: 330px;" placeholder="아이디(이메일)" name="account_email" id="account_email" maxlength="100"/>
						<button class="btn tn-primary input" onclick="emailCheckFunction();" type="button">중복체크</button>
					</div>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="비밀번호" onkeyup="pwCheckFunction();" name="account_pw" id="account_pw" maxlength="50"/>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" placeholder="비밀번호" onkeyup="pwCheckFunction();" name="account_pw2" id="account_pw2" maxlength="50"/>
				<h5 style="color: red;" id="pwCheckMessage"></h5> 
				</div>
				<div class="form-group">
					<div class="form-inline" >
						<input type="text" class="form-control" style="width: 330px;" placeholder="닉네임" name="account_nick" id="account_nick" maxlength="50"/>
						<button class="btn tn-primary input" onclick="nickCheckFunction();" type="button">중복체크</button>
					</div>
				</div>
				<div class="form-group center" >
					<div class="btn-group " data-toggle="buttons">
						<label class="btn active input" >
							<input type="radio" name="account_gender"  autocomplete="off" value="남자" checked />남자
						</label>
						<label class="btn  input" >
							<input type="radio" name="account_gender"  autocomplete="off" value="여자" />여자
						</label>
						<label class="btn  input" >
							<input type="radio" name="account_gender"  autocomplete="off" value="중성"  />중성
						</label>
					</div>
				</div>
				
				<div class="form-group">
					<input type="submit" class="btn btn-primory form-control input color"  value="회원 가입하기" />
					
				</div>
			</form>
			<div class="form-group">
				<a href="/">
					<input type="submit" class="btn btn-primory form-control input color" value="가입취소" />
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

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />

