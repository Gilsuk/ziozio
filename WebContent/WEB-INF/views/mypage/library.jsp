<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 

<div class="marginauto">
   <a href="/main"><img class="ziozio" src='/resources/img/ZIOZIO.png' ></a>
</div>


<div class="wrapper font-dohyeon">
<div class="con center font-dohyeon">
<div class="jumbotron padding" >
<h2 class="">My Room</h2><br><br>
<div class="row">

	<div class="col-lg-12">
	<div class="col-lg-1"></div>
		<div class="col-lg-10">
			<h3 class="text left">OUTER</h3>
			<div class="row">
			<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
				<c:forEach items="${outerList }" var="cloth">
				<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
					<img style="filter: hue-rotate(${cloth.color_hue_rotate}deg) 
								saturate(${cloth.color_saturate }%) invert(${cloth.color_invert }%) 
								brightness(${cloth.color_brightness }%);"
								 src="${cloth.cloth_img }" alt="${cloth.cloth_name }" class="img-thumbnail"> 
				</div>
				</c:forEach>
			<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
			</div>
		</div>
	<div class="col-lg-1"></div>
	</div>

	<div class="col-lg-12">
	<div class="col-lg-1"></div>
		<div class="col-lg-10">

			<h3 class="text left font-dohyeon">TOP</h3>

			<div class="row">
			<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
				<c:forEach items="${topList }" var="cloth">
				<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
					<img src="${cloth.cloth_img }" alt="${cloth.cloth_name }" class="img-thumbnail">
				</div>
				</c:forEach>
			<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
			</div>
		</div>
	<div class="col-lg-1"></div>
	</div>
	
	
	<div class="col-lg-12">
	<div class="col-lg-1"></div>
		<div class="col-lg-10">

			<h3 class="text left font-dohyeon">BOTTOM</h3>

			<div class="row">
			<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
				<c:forEach items="${bottomList }" var="cloth">
				<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
					<img src="${cloth.cloth_img }" alt="${cloth.cloth_name }" class="img-thumbnail">
				</div>
				</c:forEach>
			<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
			</div>
		</div>
	<div class="col-lg-1"></div>
	</div>
<a href="/mypage">
	<input type="submit" class="btn btn-primory form-control input width1 color font-gothic font-gothic" value="���ư���" /></a>	

<jsp:include page="/WEB-INF/views/layout/paging_library.jsp" />	
</div>
</div>	
</div>
</div>


<jsp:include page="/WEB-INF/views/layout/footer.jsp" />