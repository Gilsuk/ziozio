<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 

<style type="text/css">

div#sliderbox {
	width: 600px;
	height: 500px;
	border: 1px solid #ccc;
	
 	overflow: hidden; /* div영역을 벗어난 부분을 안보이게 처리 */  
/*   overflow: visible;  div영역을 전부 보이게 처리   */
	margin: 0 auto; /* div영역을 중앙으로 정렬(외부 정렬) */
}
ul#slider {
	/* ul태그의 기본 스타일 없애기 */
	padding: 0; /*내부여백 삭제*/
	margin: 0; /*외부여백 삭제*/
	list-style: none; /*리스트스타일 없음 */
	position: relative;
}
ul#slider li {
	position: absolute;
}
ul#slider li img {
	width: 600px;
	height: 500px;
}
</style>

<script type="text/javascript">
$(document).ready(function() {
	//모든 이미지 리스트
	var $slider_list = $("ul#slider li");
	
	//모든 이미지를  "left: 600px"로 보내기(숨기기)
// 	$slider_list.css("left", "600px"); //아래와 동일
 	$slider_list.css("left", $("div#sliderbox").css("width"));
 	
 	//-------------------------------------------------------
 	
 	//첫번째 이미지를 div 안쪽으로 보내기
 	//첫 이미지 보여주기
 	
 	$slider_list.eq(0).css("left",0);
 	
//  $("ul#slider li:first-child").css("left",0);
 	
 	//-------------------------------------------------------
 	// 2초 마다 이미지 변경 하기 -image slide
 	
 	var curSlide = 0; //현재 슬라이드(이미지) 인덱스
 	setInterval(function() {
// 		console.log("clicked");
 		 
 		//다음에 보여질 이미지의 인덱스
 		var nextSlide = curSlide+1;
 		nextSlide %= $slider_list.length;//보정
// 		nextSlide = nextSlide % $slider_list.length;//보정

		//보여져야 할 이미지를 오른쪽으로 보내주기
		$slider_list.eq(nextSlide).css("left","600px");

		//현재 이미지 숨기기 : curSlide
		$slider_list.eq(curSlide).animate({"left":"-=600px"});
		
		//다음 이미지 보여주기 : nextSlide
		$slider_list.eq(nextSlide).animate({"left": "-=600px"});
		
 		//순환구조 만들기
 		curSlide++;
 		curSlide %= $slider_list.length;//보정
 //		curSlide = curSlide % $slider_list.length;//보정
 	
 	},2000);
 	
});
</script>

<div class="container ">
	<div class="marginauto ">
  		<img src='/resources/img/ZIOZIO.png' >
  	</div>
</div>


<div id="sliderbox">
	<ul id="slider">
		<li><img src="/resources/img/look/A_line_skirt.png" /></li>
		<li><img src="/resources/img/look/Flitz_skirt.png" /></li>
		<li><img src="/resources/img/look/H_line_skirt.png" /></li>
		<li><img src="/resources/img/look/Knit.png" /></li>
		<li><img src="/resources/img/look/Leggings.png" /></li>
		<li><img src="/resources/img/look/Lightweight_long_padding.png" /></li>
		<li><img src="/resources/img/look/Lightweight_vest_padding.png" /></li>
		<li><img src="/resources/img/look/long_padding.png" /></li>
		<li><img src="/resources/img/look/long_skirt.png" /></li>
		<li><img src="/resources/img/look/Long_sleeve_shirts.png" /></li>
	</ul>
</div>

<br>

<c:if test="${not empty account }">
	<div class="text-center"><h2>${account.account_nick } 님 로그인되었습니다.</h2></div>
</c:if>


<c:if test="${empty account }">
	<div class="text-center"><br>
		<a class="btn btn-warning" href="/account/restoresession" role="button">로그인</a>
		<a class="btn btn-warning " href="/account/join" role="button">회원가입</a>
	</div>
</c:if>



<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
