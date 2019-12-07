<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 

<style type="text/css">


.carousel-inner {
	font-size: 20px;
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

<!-- 이미지 -->
<div class="marginauto">
    <img class="ziozio" src='/resources/img/ZIOZIO.png' >
</div>


<div id="wrap">
<div class="container center">
	<div class="col-lg-3"></div>
	<div class="col-lg-6">
		<div class="jumbotron padding"  >
<h2 class="">WEATHER INFO</h2><br><br>

		<div id="carousel-example-generic" class="carousel slide">
			<!-- 	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel"> -->
			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<!-- 		<div class="carousel-inner"> -->
				<c:forEach items="${weatherList}" var="weatherinfo">
				<c:if test="${weatherinfo.weather_name == '흐림'}"></c:if>
					<div class="item">
						<%-- 			<fmt:formatDate value="${weatherinfo.weahter_info_date}" pattern="yyyy-MM-dd HH" /><br> --%>
						<%-- 				<c:out value="${weatherinfo.weahter_info_date}"></c:out><br> --%>
						<c:out value="${weatherinfo.weahter_info_date_str }시"></c:out>
						<br><br>
						<c:out value="${weatherinfo.location_name}"></c:out>
						<br><br>
						<c:out value="날씨 ${weatherinfo.weather_name}"></c:out>
						<br><br>
						<%-- 				<c:out value="${weatherinfo.temperature_grade_code}"></c:out><br> --%>
						<c:out value="온도 ${weatherinfo.weather_info_temperature}"></c:out>
						<br><br>
						<c:out value="미세먼지 ${weatherinfo.weather_info_finedust}"></c:out>
						<br><br>

					</div>
				</c:forEach>
				
				
				<h3>날씨</h3>
				
				
			</div>
			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic"
				role="button" data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left"></span>
				
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				role="button" data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" ></span>
				
			</a>

		</div>
</div>
</div>
<div class="col-lg-3"></div>
</div>
</div>




<jsp:include page="/WEB-INF/views/layout/footer.jsp" />