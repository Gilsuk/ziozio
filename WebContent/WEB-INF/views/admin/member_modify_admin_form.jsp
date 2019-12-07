<%@page import="member.MemberDto"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<%	request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="membermanager" class="member.MemberManager"/>



<%

	String id = request.getParameter("id");

	MemberDto dto =  membermanager.getData(id);

%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

<script src="../js/script.js?ver=2"></script>

<script type="text/javascript">

window.onload = function(){

	//직업 가저오기

	var job = document.getElementsByName("job")[0];

	for(var i = 0;i<job.length;i++){

		if(job[i].value ==="<%=dto.getJob()%>"){

			job[i].selected = true;

		}

	}

	document.getElementById("btnModify").onclick = admin_modify_member_action;

	document.getElementById("btnModifyCancel").onclick = admin_modify_member_cancel;

	document.getElementById("btnDelete").onclick = function(){

		admin_modify_member_delete("<%=dto.getId()%>");

	}

}

</script>

</head>

<body>

<br>

<table class="table">

<tr>

	<td align="center" valign="middle" style="background-color: #FFFFCC">

		<form name="modifyFormAdmin" method="post" action=member_modify_admin_action.jsp>

			<table border="1">

				<tr align="center" style="background-color: #8899aa">

					<td colspan="2"><b style="color: #FFFFFF"><%=dto.getName() %>님의 정보를 수정(관리자)</b></td>

				</tr>

				<tr>

					<td width="16%">아이디</td>

					<td width="57%">

						<%=dto.getId()%>

						<input type="hidden" name="id" value="<%=dto.getId() %>" />

					</td>

				</tr>

				<tr>

					<td>패스워드</td>

					<td><input type="password" name="pass" size="15" value="<%=dto.getPass() %>"></td>

				</tr>

				<tr>

					<td>이름</td>

					<td><input type="text" name="name" size="15" value="<%=dto.getName() %>"></td>

				</tr>

				<tr>

					<td>이메일</td>

					<td><input type="text" name="mail" size="27" value="<%=dto.getMail() %>"></td>

				</tr>

				<tr>

					<td>전화번호</td>

					<td><input type="text" name="phone" size="20" value="<%=dto.getPhone() %>"></td>

				</tr>

				<tr>

					<td>우편번호</td>

					<td>

						<input type="text" name="zipcode" size="7" value="<%=dto.getZipcode()%>"> 

					</td>

				</tr>

				



				<tr>

					<td colspan="2" align="center">

						<input type="button" value="수정완료" id="btnModify" />
						&nbsp;&nbsp;
						<input type="button" value="수정취소" id="btnModifyCancel" />
						<input type="button" value="회원삭제" id="btnDelete" />

					</td>

				</tr>

			</table>

		</form>

	</td>

</tr>

</table>


<jsp:include page="/WEB-INF/views/layout/footer.jsp">
