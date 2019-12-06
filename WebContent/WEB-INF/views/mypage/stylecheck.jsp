<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 



<div class="marginauto">
   <a href="/main"><img class="ziozio" src='/resources/img/ZIOZIO.png' ></a>
</div>

<div class="wrapper font-dohyeon fon1">
<div class="con center">
<div class="jumbotron padding" >
<h1 class="">Style Check</h1><br><br>


<form action="/stylecheck" method="post">
	<div class="checkbox">
		<c:forEach items="${allStyles}" var="style" >
		<label>
			<input type="checkbox" name="styles[]" value="${style.style_name }">
			${style.style_name }
		</label>
		</c:forEach>
	</div>
	<br>
	<div class="form-group">
		<input type="submit" class="btn form-control input width1 color font-gothic"  value="확인" />
	</div>
</form>
<a href="/mypage">
	<input type="submit" class="btn  form-control input width1 color font-gothic" value="돌아가기" /></a>

</div>
</div>
</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />