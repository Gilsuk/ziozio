<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 

<div class="marginauto">
    <img class="ziozio" src='/resources/img/ZIOZIO.png' >
</div>


<div class="wrapper">
<div class="container center">
<div class="jumbotron padding" >
<h2>My Room</h2><br><br>
<div class="row">
<div class="col-lg-12">
	<h3>TOP</h3>
	<div class="form-inline">
	<c:forEach items="${clothListTop }" var="cloth">
		<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
			<img src="${cloth.cloth_img }" alt="${cloth.cloth_name }" class="img-thumbnail">
		</div>
	</c:forEach>
	</div>

    	
	<h3>BOTTOM</h3>
	<div class="form-inline">
	<c:forEach items="${clothListBottom }" var="cloth">
		<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
			<img src="${cloth.cloth_img }" alt="${cloth.cloth_name }" class="img-thumbnail">
		</div>
	</c:forEach>
	</div>

	
	<h3>OUTER</h3>
	<div class="form-inline">
	<c:forEach items="${clothListOuter }" var="cloth">
		<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
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