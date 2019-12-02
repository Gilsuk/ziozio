<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 

<div class="marginauto">
    <img src='/resources/img/ZIOZIO.png' >
</div>


<div class="wrapper">
<div class="container center">
<div class="jumbotron padding" >
<h2>My Room</h2><br><br>
<div class="row">
<div class="col-lg-12">
	<div class="form-inline">
	<c:forEach items="${clothListTop }" var="cloth">

		<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
			<img src="${cloth.cloth_img }" alt="${cloth.cloth_name }" class="img-thumbnail">
		</div>

	</c:forEach>
	</div>
    	
	<div class="form-inline">
	<c:forEach items="${clothListBottom }" var="cloth">
		<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
			<img src="${cloth.cloth_img }" alt="${cloth.cloth_name }" class="img-thumbnail">
		</div>
	</c:forEach>
	</div>
	
	<div class="form-inline">
	<c:forEach items="${clothListOuter }" var="cloth">
		<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
			<img src="${cloth.cloth_img }" alt="${cloth.cloth_name }" class="img-thumbnail">
		</div>
	</c:forEach>
	</div>	
<jsp:include page="/WEB-INF/views/layout/paging_library.jsp" />	
</div>	
</div>
</div>
</div>
</div>

<jsp:include page="/WEB-INF/views/layout/footer.jsp" />