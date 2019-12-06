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

		<div id="carousel-example-generic" class="carousel slide">
			<!-- 	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel"> -->
			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<!-- 		<div class="carousel-inner"> -->
				<c:forEach items="${locweatherList}" var="weatherinfo">
					<div class="item">
						<%-- 			<fmt:formatDate value="${weatherinfo.weahter_info_date}" pattern="yyyy-MM-dd HH" /><br> --%>
						<%-- 				<c:out value="${weatherinfo.weahter_info_date}"></c:out><br> --%>
						<c:out value="${weatherinfo.weahter_info_date_str }시"></c:out>
						<br>
						<c:out value="${weatherinfo.location_name}"></c:out>
						<br>
						<c:out value="날씨 ${weatherinfo.weather_name}"></c:out>
						<br>
						<%-- 				<c:out value="${weatherinfo.temperature_grade_code}"></c:out><br> --%>
						<c:out value="온도 ${weatherinfo.weather_info_temperature}"></c:out>
						<br>
						<c:out value="미세먼지 ${weatherinfo.weather_info_finedust}"></c:out>
						<br>
					</div>			
				</c:forEach>
<%-- 				<c:forEach items="${locweatherList}" var="weatherinfo"> --%>
<!-- 				<select> -->
<%-- 					<option><c:out value="날씨 ${weatherinfo.weather_name}"><br></c:out></option> --%>
<!-- 					</select> -->
<%-- 				</c:forEach> --%>
			</div>
			
			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic"
				role="button" data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				role="button" data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>

		</div>
<form action="">
<h4>날씨</h4>
<select name="sel">
	<option value="0" selected="selected">선택안함</option>
	<option>맑음</option>
	<option>흐림</option>
	<option>비</option>
	<option>눈</option>
</select>
<h4>온도</h4>
<select name="sel">
	<option value="0" selected="selected">선택안함</option>
	<option>1</option>
	<option>2</option>
	<option>3</option>
	<option>4</option>
	<option>5</option>
	<option>6</option>
	<option>7</option>
	<option>8</option>
</select>

</form>
</div>






<jsp:include page="/WEB-INF/views/layout/footer.jsp" />