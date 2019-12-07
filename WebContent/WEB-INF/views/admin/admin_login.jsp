<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<script type="text/javascript">

	function check() {

		if(frm.id.value == "" || frm.pass.value == "") {

			alert("자료를 입력하시오");

			return;

		} else {

			frm.submit();

		}

	}

</script>

</head>

<body>

	<form action="adminboard.jsp" name="frm" method="post">

		<table style = "width:100%">

		<%

			String admin = (String)session.getAttribute("adminOk");

			if(admin !=null){
		%>
			<tr>
				<td>
					<script>
						window.opener.location.href="admin.jsp";

					</script>

					관리자 로그인 중입니다<br/>

					[<a href="admin_logout.jsp">로그아웃</a>]

					[<a href="javascript:window.close()">창닫기</a>]
				</td>				
			</tr>
		<%
			} else {
		%><!-- 이거 퍼온거라서 우리조랑 싱크 맞춰야함 -->
			<tr><td>i d : <input type="text" name="id" style="width: 80%" /></td></tr>
			<tr><td>p w : <input type="text" name="pass" style="width: 80%" /></td></tr>
			<tr>
				<td>
					[<a href="#" onclick="check()">로그인</a>]
					[<a href="javascript:window.close()">창닫기</a>]
				</td>
			</tr>
		<%
			}

		%>

		</table>

	</form>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />

<!-- 일단보류 -->