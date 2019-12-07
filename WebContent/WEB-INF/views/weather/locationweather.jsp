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

.carousel-inner {
	font-size: 20px;
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
	<br>
	<br>
	<br>
	<h2>WEATHER INFO</h2>
	<br>
<c:if test="name"></c:if>
		<div id="carousel-example-generic" class="carousel slide">
			<!-- 	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel"> -->
			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<!-- 		<div class="carousel-inner"> -->
<%-- 				<c:forEach items="${locweatherList}" var="weatherinfo" varStatus="status"> --%>
<!-- 					<div class="item">						 -->
<%-- 						<c:out value="${weatherinfo.weahter_info_date_str }시"></c:out> --%>
<!-- 						<br> -->
<%-- 						<c:out value="${weatherinfo.location_name}"></c:out> --%>
<!-- 						<br> -->
<%-- 						<c:out value="날씨 ${weatherinfo.weather_name}"></c:out> --%>
<!-- 						<br> -->
<%-- 						<c:out value="온도 ${weatherinfo.weather_info_temperature}"></c:out> --%>
<!-- 						<br> -->
<%-- 						<c:out value="미세먼지 ${weatherinfo.weather_info_finedust}"></c:out> --%>
<!-- 						<br> -->
<!-- 					</div>			 -->
<%-- 				</c:forEach> --%>
					
					<c:choose>
<%-- 					<c:when test="${param.sel eq 0 }"> --%>
					<c:when test="">
						<c:out value="${locweatherList[0].weahter_info_date_str }시"></c:out>
						<br>
						<c:out value="${locweatherList[0].location_name}"></c:out>
						<br>
						<c:out value="날씨 ${locweatherList[0].weather_name}"></c:out>
						<br>
						<c:out value="온도 ${locweatherList[0].weather_info_temperature}"></c:out>
						<br>
						<c:out value="미세먼지 ${locweatherList[0].weather_info_finedust}"></c:out>
						<br>
					</c:when>
					<c:when test="${param.sel eq 1 }">
					
						<c:out value="${locweatherList[1].weahter_info_date_str }시"></c:out>
						<br>
						<c:out value="${locweatherList[1].location_name}"></c:out>
						<br>
						<c:out value="날씨 ${locweatherList[1].weather_name}"></c:out>
						<br>
						<c:out value="온도 ${locweatherList[1].weather_info_temperature}"></c:out>
						<br>
						<c:out value="미세먼지 ${locweatherList[1].weather_info_finedust}"></c:out>
						<br>
					</c:when>
					
						<c:when test="${param.sel eq 2 }">
					
						<c:out value="${locweatherList[2].weahter_info_date_str }시"></c:out>
						<br>
						<c:out value="${locweatherList[2].location_name}"></c:out>
						<br>
						<c:out value="날씨 ${locweatherList[2].weather_name}"></c:out>
						<br>
						<c:out value="온도 ${locweatherList[2].weather_info_temperature}"></c:out>
						<br>
						<c:out value="미세먼지 ${locweatherList[2].weather_info_finedust}"></c:out>
						<br>
					</c:when>
					
					<c:when test="${param.sel eq 3 }">
					
						<c:out value="${locweatherList[3].weahter_info_date_str }시"></c:out>
						<br>
						<c:out value="${locweatherList[3].location_name}"></c:out>
						<br>
						<c:out value="날씨 ${locweatherList[3].weather_name}"></c:out>
						<br>
						<c:out value="온도 ${locweatherList[3].weather_info_temperature}"></c:out>
						<br>
						<c:out value="미세먼지 ${locweatherList[3].weather_info_finedust}"></c:out>
						<br>
					</c:when>
					
					<c:when test="${param.sel eq 4 }">
					
						<c:out value="${locweatherList[4].weahter_info_date_str }시"></c:out>
						<br>
						<c:out value="${locweatherList[4].location_name}"></c:out>
						<br>
						<c:out value="날씨 ${locweatherList[4].weather_name}"></c:out>
						<br>
						<c:out value="온도 ${locweatherList[4].weather_info_temperature}"></c:out>
						<br>
						<c:out value="미세먼지 ${locweatherList[4].weather_info_finedust}"></c:out>
						<br>
					</c:when>
					
					<c:when test="${param.sel eq 5 }">
					
						<c:out value="${locweatherList[4].weahter_info_date_str }시"></c:out>
						<br>
						<c:out value="${locweatherList[4].location_name}"></c:out>
						<br>
						<c:out value="날씨 ${locweatherList[4].weather_name}"></c:out>
						<br>
						<c:out value="온도 ${locweatherList[4].weather_info_temperature}"></c:out>
						<br>
						<c:out value="미세먼지 ${locweatherList[4].weather_info_finedust}"></c:out>
						<br>
					</c:when>

						</c:choose>

<%-- 				<c:forEach items="${locweatherList}" var="weatherinfo"> --%>
<!-- 				<select> -->
<%-- 					<option><c:out value="날씨 ${weatherinfo.weather_name}"><br></c:out></option> --%>
<!-- 					</select> -->
<%-- 				</c:forEach> --%>
			</div>
			
			<!-- Controls -->
<!-- 			<a class="left carousel-control" href="#carousel-example-generic" -->
<!-- 				role="button" data-slide="prev"> <span -->
<!-- 				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> -->
<!-- 				<span class="sr-only">Previous</span> -->
<!-- 			</a> <a class="right carousel-control" href="#carousel-example-generic" -->
<!-- 				role="button" data-slide="next"> <span -->
<!-- 				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> -->
<!-- 				<span class="sr-only">Next</span> -->
<!-- 			</a> -->

		</div>

<!-- <h4>날씨</h4> -->
<!-- <select name="weather_name"> -->
<!-- 	<option value="0" selected="selected">선택안함</option> -->
<!-- 	<option>맑음</option> -->
<!-- 	<option>흐림</option> -->
<!-- 	<option>비</option> -->
<!-- 	<option>눈</option> -->
<!-- </select> -->
<!-- <button>설정</button> -->
<!-- <h4>온도</h4> -->
<!-- <select name="temperature"> -->
<!-- 	<option value="0" selected="selected">선택안함</option> -->
<!-- 	<option>1 (27~100)</option> -->
<!-- 	<option>2 (23~26.99)</option> -->
<!-- 	<option>3 (20~22.99)</option> -->
<!-- 	<option>4 (17~19.99)</option> -->
<!-- 	<option>5 (12~16.99)</option> -->
<!-- 	<option>6 (10~11.99)</option> -->
<!-- 	<option>7 (6~ 9.99)</option> -->
<!-- 	<option>8 (-100~5.99)</option> -->
<!-- </select> -->
<!-- <button>설정</button> -->

<form action="/weather" method="get">
<h3>시간대별 날씨</h3>
<select name="sel" >
	<option value="0" selected="selected">현재 시간</option>
	<option value="1">1시간 이후</option>
	<option value="2">2시간 이후</option>
	<option value="3">3시간 이후</option>
	<option value="4">4시간 이후</option>
</select>
<button>설정</button>
</form>


	
</div>






<jsp:include page="/WEB-INF/views/layout/footer.jsp" />