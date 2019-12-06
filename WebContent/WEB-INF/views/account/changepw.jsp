<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<script type="text/javascript">

    function checkValue()
    {
        inputForm = eval("document.loginInfo"); {
    

	        if(!inputForm.pw.value)
	        {
	        	$("#checkMessage").html("비밀번호를 입력하세요.");
				$("#checkType").attr("class", "modal-content panel-warning");
				$("#checkModal").modal("show");
				inputForm.account_pw.focus();
	            return false;
	        }
	        if(!inputForm.pw1.value)
	        {
	        	$("#checkMessage").html("비밀번호를 입력하세요.");
				$("#checkType").attr("class", "modal-content panel-warning");
				$("#checkModal").modal("show");  
	            inputForm.account_pw2.focus();
	            return false;
	        }
        }
    } 

	function pwCheckFunction() {
		var pw = $("#pw").val();
		var pw1 = $("#pw1").val();
		
        var check1 = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,15}$/.test(pw);   //영문,숫자
        var check2 = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{8,15}$/.test(pw);  //영문,특수문자
        var check3 = /^(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{8,15}$/.test(pw);  //특수문자, 숫자
       
        if(!(check1||check2||check3)){
           warningModal("비밀번호는 숫자, 대/소문자, 특수문자 중 2가지 이상을 조합한 8~15 자리가 가능합니다");

           $('#pw').focus();
           return false;
		}
		
		if (pw != pw1) {
			$("#pwCheckMessage").html("비밀번호가 일치하지 않습니다");
		} else {
			$("#pwCheckMessage").html("");
		}
	}
</script>

<!-- 이미지 -->
<div class="marginauto">
    <img class="ziozio" src='/resources/img/ZIOZIO.png' >
</div>


<div id="wrap">
<div class="container">
	<div class="col-lg-3"></div>
	<div class="col-lg-6">
		<div class="jumbotron padding"  >
			<form name="loginInfo" method="post" action="/account/changepw" onsubmit="Freturn checkValue()">
				<h2 class="center font-dohyeon">비밀번호 변경</h2><br>
				
				<div class="form-group">
					<input type="password" class="form-control font-gothic" placeholder="새로운 비밀번호" onkeyup="pwCheckFunction();" name="pw" id="pw" maxlength="50"/>
				</div>
				<div class="form-group">
					<input type="password" class="form-control font-gothic" placeholder="새로운 비밀번호확인" onkeyup="pwCheckFunction();" name="pw1" id="pw1" maxlength="50"/>
					<input type="text" name="account_no" hidden="hidden" value="<%=request.getParameter("a") %>" />
					<input type="text" name="verification_code" hidden="hidden" value="<%=request.getParameter("c") %>" />
				<h5 style="color: red;" id="pwCheckMessage"></h5> 
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-primory form-control input color font-gothic"  value="변경 완료" />
				</div>
			</form>
			
			<div class="form-group">
				<a href="/">
					<input type="submit" class="btn btn-primory form-control input color font-gothic" value="수정 취소" />
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
			<div class="modal-content " <% if(messageType.equals("오류메세지")) out.println("panel-warning"); else out.println("panel-success"); %>>
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