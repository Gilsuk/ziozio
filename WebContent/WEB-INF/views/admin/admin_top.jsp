<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String admin_id = (String)session.getAttribute("adminOk");

	if(admin_id == null) {
%>
	<script>
		alert("관리자 로그아웃 되었습니다.");
		location.href = "../guest/guest_index.jsp";
	</script>
<%
		return;
	}
%>

<table style="width: 80%">

	<tr style="background-color: #ccbbcc; text-align: center;">

		<td><a href="admin_login_out.jsp">로그아웃</a></td>

		<td><a href="admin_member.jsp">회원관리</a></td>

		<td><a href="admin_board.jsp">게시물 관리</a></td>
		
		<td><a href="admin_qna.jsp">QnA 관리</a></td>

	</tr>

</table>

<!-- bottom은 그냥 footer.jsp쓸것이다. -->
<!-- <jsp:include page="/WEB-INF/views/layout/footer.jsp" /> -->
