<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 



<style type="text/css">

#carousel-example-generic {
	width: 700px;
	height: 500px;
	border: 1px solid #ccc;
	text-align: center;
	
 	overflow: hidden; /* div영역을 벗어난 부분을 안보이게 처리 */  
/*   overflow: visible;  div영역을 전부 보이게 처리   */
	margin: 0 auto; /* div영역을 중앙으로 정렬(외부 정렬) */
}

#carousel-example-generic img {
	width: 700px;
	height: 500px;
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

<div class="container ">
	<div class="marginauto">
  		<a href="/main"><img class="ziozio" src='/resources/img/ZIOZIO.png' ></a>
  	</div>
</div>



<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner" role="listbox">
  
		<div class="carousel-inner" role="listbox">
			<c:forEach items="${allList}" var="cloth">
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
</div>


<c:if test="${!empty account }">
<div class="text-center font-dohyeon center"><br>
	<a class="btn input" href="/weather/cloth" role="button">날씨/기온에 맞는 옷</a>&nbsp;&nbsp;
	<!-- <a class="btn input" href="/temperature/cloth" role="button">기온별 옷 보기</a>&nbsp;&nbsp; -->
	<a class="btn input" href="/gender/cloth" role="button">성별 옷 보기</a>
</div>

</c:if>

<c:if test="${empty account }">
	<div class="text-center font-dohyeon"><br>
		<a class="btn input"  href="/account/restoresession" role="button">로그인</a>&nbsp;&nbsp;
		<a class="btn input"  href="/account/join" role="button">회원가입</a>
	</div>
</c:if>




<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
