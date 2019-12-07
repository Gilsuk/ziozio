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
<%-- 				<c:forEach items="${weatherList}" var="weatherinfo"> --%>
<!-- 					<div class="item"> -->
						<%-- 			<fmt:formatDate value="${weatherinfo.weahter_info_date}" pattern="yyyy-MM-dd HH" /><br> --%>
						<%-- 				<c:out value="${weatherinfo.weahter_info_date}"></c:out><br> --%>
<%-- 						<c:out value="${weatherinfo.weahter_info_date_str }시"></c:out> --%>
<!-- 						<br><br> -->
<%-- 						<c:out value="${weatherinfo.location_name}"></c:out> --%>
<!-- 						<br><br> -->
<%-- 						<c:out value="날씨 ${weatherinfo.weather_name}"></c:out> --%>
<!-- 						<br><br> -->
						<%-- 				<c:out value="${weatherinfo.temperature_grade_code}"></c:out><br> --%>
<%-- 						<c:out value="온도 ${weatherinfo.weather_info_temperature}"></c:out> --%>
<!-- 						<br><br> -->
<%-- 						<c:out value="미세먼지 ${weatherinfo.weather_info_finedust}"></c:out> --%>
<!-- 						<br><br> -->
					<c:choose>

					<c:when test="${param.sel eq null || param.sel eq 0 }">
						<c:out value="${weatherList[0].weahter_info_date_str }시"></c:out>
						<br>
						<c:out value="${weatherList[0].location_name}"></c:out>
						<br>
						<c:out value="날씨 ${weatherList[0].weather_name}"></c:out>
						<br>
						<c:out value="온도 ${weatherList[0].weather_info_temperature}"></c:out>
						<br>
						<c:out value="미세먼지 ${weatherList[0].weather_info_finedust}"></c:out>
						<br>
					</c:when>
					
					<c:when test="${param.sel eq 1 }">
					
						<c:out value="${weatherList[1].weahter_info_date_str }시"></c:out>
						<br>
						<c:out value="${weatherList[1].location_name}"></c:out>
						<br>
						<c:out value="날씨 ${weatherList[1].weather_name}"></c:out>
						<br>
						<c:out value="온도 ${weatherList[1].weather_info_temperature}"></c:out>
						<br>
						<c:out value="미세먼지 ${weatherList[1].weather_info_finedust}"></c:out>
						<br>
					</c:when>
					
						<c:when test="${param.sel eq 2 }">
					
						<c:out value="${weatherList[2].weahter_info_date_str }시"></c:out>
						<br>
						<c:out value="${weatherList[2].location_name}"></c:out>
						<br>
						<c:out value="날씨 ${weatherList[2].weather_name}"></c:out>
						<br>
						<c:out value="온도 ${weatherList[2].weather_info_temperature}"></c:out>
						<br>
						<c:out value="미세먼지 ${weatherList[2].weather_info_finedust}"></c:out>
						<br>
					</c:when>
					
					<c:when test="${param.sel eq 3 }">
					
						<c:out value="${weatherList[3].weahter_info_date_str }시"></c:out>
						<br>
						<c:out value="${weatherList[3].location_name}"></c:out>
						<br>
						<c:out value="날씨 ${weatherList[3].weather_name}"></c:out>
						<br>
						<c:out value="온도 ${weatherList[3].weather_info_temperature}"></c:out>
						<br>
						<c:out value="미세먼지 ${weatherList[3].weather_info_finedust}"></c:out>
						<br>
					</c:when>
					
					<c:when test="${param.sel eq 4 }">
					
						<c:out value="${weatherList[4].weahter_info_date_str }시"></c:out>
						<br>
						<c:out value="${weatherList[4].location_name}"></c:out>
						<br>
						<c:out value="날씨 ${weatherList[4].weather_name}"></c:out>
						<br>
						<c:out value="온도 ${weatherList[4].weather_info_temperature}"></c:out>
						<br>
						<c:out value="미세먼지 ${weatherList[4].weather_info_finedust}"></c:out>
						<br>
					</c:when>									
						</c:choose>

					</div>
<%-- 				</c:forEach> --%>
				
				
				
			</div>
			<!-- Controls -->
<!-- 			<a class="left carousel-control" href="#carousel-example-generic" -->
<!-- 				role="button" data-slide="prev"> <span -->
<!-- 				class="glyphicon glyphicon-chevron-left"></span> -->
				
<!-- 			</a> <a class="right carousel-control" href="#carousel-example-generic" -->
<!-- 				role="button" data-slide="next"> <span -->
<!-- 				class="glyphicon glyphicon-chevron-right" ></span> -->
				
<!-- 			</a> -->

		</div>
<form action="/weather" method="get">
<h3>시간대별 날씨</h3>
<select name="sel" >
	<option value="0" selected="selected">현재 시간</option>
	<option value="1">1시간 이후</option>
	<option value="2">2시간 이후</option>
	<option value="3">3시간 이후</option>
	<option value="4">4시간 이후</option>
</select>
<button>확인</button>
</form>
</div>
</div>
<div class="col-lg-3"></div>
</div>





<jsp:include page="/WEB-INF/views/layout/footer.jsp" />