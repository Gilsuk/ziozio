<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

    

<% session.removeAttribute("adminOk"); %>

<script>

	if(window.opener == null){

		alert("관리자 로그아웃 되었습니다.");

		location.href = "../guest/guest_index.jsp";

	} else {

		alert("관리자 로그아웃 되었습니다.");

		window.opener.location.reload();

		window.close();

	}

</script>

