<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
    
<jsp:include page="/WEB-INF/views/layout/header.jsp" />    

<title>로그인 화면</title>

<script type="text/javascript">

/*     function checkValue()
    {
        inputForm = eval("document.loginInfo");
        if(!inputForm.useremail.value)
        {
            alert("아이디를 입력하세요");    
            inputForm.useremail.focus();
            return false;
        }
        if(!inputForm.userpw.value)
        {
            alert("비밀번호를 입력하세요");    
            inputForm.userpw.focus();
            return false;
        }
    } */
    

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
        }
    }
</script>


<body>

<!-- 이미지 -->
<div class="marginauto">
    <img class="ziozio" src='/resources/img/ZIOZIO.png'  >
</div>

<div id="wrap">
<div class="container ">
	<div class="col-lg-3 "></div>
	<div class="col-lg-6 ">
		<div class="jumbotron padding" style="background-color: #FFF2EC">
			<form name="loginInfo" method="post" action="/account/login" onsubmit="return checkValue()">
				<h2 class="center font-dohyeon">로그인</h2><br>
				<div class="form-group">
					<input type="text" class="form-control font-gothic" placeholder="아이디(email)" name="account_email" id="account_email"maxlength="100"/>
				</div>
				<div class="form-group">
					<input type="password" class="form-control font-gothic" placeholder="비밀번호" name="account_pw" id="account_pw"maxlength="20"/>
				</div>
				 <div class="checkbox">
    				<label>
     					 <input type="checkbox" name="keep_login" value="true"> Remember
   					 </label>
   				 </div>

              <%--	<c:if test="${!empty result && !result}"> 
 					<h5 style="color: red;">비밀번호를 확인 해주세요</h5> 
				</c:if>  --%>
				
				<div class="form-group" >
					<input  type="submit" class="btn btn-primory form-control input color font-dohyeon" value="로그인" />
				</div>
			
			</form>
			
			<a href="/account/join">
				<input  type="submit" class="btn btn-primory form-control input color font-gothic" value="회원가입" />
			</a>
			<br><br>
			<a href="/account/find">
				<input  type="submit" class="btn btn-primory form-control input color font-gothic" value="비밀번호 찾기" />
			</a>
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
