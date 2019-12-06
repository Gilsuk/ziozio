<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 

<style type="text/css">
.slide {
	width: 400px;
	height: 300px;
	border: 1px solid #ccc;
	text-align: center;
	
 	overflow: hidden; /* div영역을 벗어난 부분을 안보이게 처리 */  
/*   overflow: visible;  div영역을 전부 보이게 처리   */
	margin: 0 auto; /* div영역을 중앙으로 정렬(외부 정렬) */
}

.slide img {
	width: 400px;
	height: 300px;
}
.carousel-control.right, .carousel-control.left {
 background-image: none;
}
</style>

<script type="text/javascript">
$( document ).ready(function() {
	$(".carousel-inner .item:first-child").addClass("active");
});
</script>

<div class="wrap center font-dohyeon">
<br><br><br>
<h2>CUSTOM</h2>
<br>

	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
		  <!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<c:forEach items="${outerList}" var="cloth">
			<div class="item">
				<img style="filter: hue-rotate(${cloth.color_hue_rotate}deg) 
							saturate(${cloth.color_saturate }%) invert(${cloth.color_invert }%) 
							brightness(${cloth.color_brightness }%);"
							 src="${cloth.cloth_img }" alt="${cloth.cloth_name }" class="img-thumbnail">
			</div>
			</c:forEach>
		</div>
	
		<!-- Controls -->
	  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
	    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>
	
	<br>

	<div id="carousel-example-generic1" class="carousel slide" data-ride="carousel">
	  <!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<c:forEach items="${topList}" var="cloth">
			<div class="item">
				<img style="filter: hue-rotate(${cloth.color_hue_rotate}deg) 
							saturate(${cloth.color_saturate }%) invert(${cloth.color_invert }%) 
							brightness(${cloth.color_brightness }%);"
							 src="${cloth.cloth_img }" alt="${cloth.cloth_name }" class="img-thumbnail">
			</div>
			</c:forEach>
		</div>
	
		<!-- Controls -->
	  <a class="left carousel-control" href="#carousel-example-generic1" role="button" data-slide="prev">
	    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="right carousel-control" href="#carousel-example-generic1" role="button" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>
	
	<br>
	
	<div id="carousel-example-generic2" class="carousel slide" data-ride="carousel">
	  <!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<c:forEach items="${bottomList}" var="cloth">
			<div class="item">
				<img style="filter: hue-rotate(${cloth.color_hue_rotate}deg) 
							saturate(${cloth.color_saturate }%) invert(${cloth.color_invert }%) 
							brightness(${cloth.color_brightness }%);"
							 src="${cloth.cloth_img }" alt="${cloth.cloth_name }" class="img-thumbnail">
			</div>
			</c:forEach>
		</div>
	
	  <!-- Controls -->
	  <a class="left carousel-control" href="#carousel-example-generic2" role="button" data-slide="prev">
	    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="right carousel-control" href="#carousel-example-generic2" role="button" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div><br>
<a href="/mypage">
	<input type="submit" class="btn btn-primory form-control input width1 color font-gothic" value="돌아가기" /></a>
</div>
<br>



<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
