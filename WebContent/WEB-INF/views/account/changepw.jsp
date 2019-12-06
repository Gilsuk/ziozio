<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<form action="/account/changepw" method="post">
	<input type="password" name="pw" />
	<input type="password" name="pw" />
	<input type="text" name="account_no" hidden="hidden"
		value="<%=request.getParameter("a") %>" />
	<input type="text" name="verification_code" hidden="hidden"
		value="<%=request.getParameter("c") %>" />
	<input type="submit" value="변경">
</form>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />