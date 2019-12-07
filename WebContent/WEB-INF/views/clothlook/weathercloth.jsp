<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 

<div class="wrap center font-dohyeon">

<br>
<h2>Weather</h2>
<br>

<jsp:include page="/WEB-INF/views/layout/clothimg.jsp" /> 


<a href="/weather/cloth">
	<input type="submit" class="btn btn-primory form-control input width color font-gothic" value="새로고침" /></a>&nbsp;
<a href="/main">
	<input type="submit" class="btn btn-primory form-control input width color font-gothic" value="돌아가기" /></a>
</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />