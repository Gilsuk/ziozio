<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image⁄x-icon" href="">
<link rel="stylesheet" href="/resources/css/style.css" />
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Gothic+A1|Nanum+Myeongjo&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<title>ZIOZIO</title>

<script
  src="https://code.jquery.com/jquery-2.2.4.min.js"
  integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
  crossorigin="anonymous"></script>
  
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">


<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- 내위치정보 -->
<script type="text/javascript">
window.onload = getLocation; 

var lat, lon;
function getLocation(){
    if(navigator.geolocation){
        navigator.geolocation.getCurrentPosition(locationSuccess, locationError);
    }else{
        console.log("지오 로케이션 없음")
    }
};
	
function locationSuccess(p){
    lat = p.coords.latitude,
    lon = p.coords.longitude;
    jQuery.ajax({
		type: "get"
		, url: "https://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lon+"&key=AIzaSyAYL95BQRM_FRYkiMhmioDwpan0gQ0YqLw"
		, data: {
			"lat": lat
			, "lon": lon
		}
		, dataType: "json" 
		, success: function(data) {
			var $btnOk = $("<button id='btnOk'>확인</button>");
			$("#btn").on( "click", function() {
				alert("");
				
				$btnOk.prependTo($("div"));
    		$.ajax({
				
				url : '/location_get',
	
				data : {lat : lat,
						lon : lon
						},																	
				
				
				type : 'GET'
	
			})
			});
			console.log("성공")

		}
		, error: function() {
			console.log("실패")
		}
	});

}

// locationSuccess
function locationError(error){
    var errorTypes = {
        0 : "무슨 에러??",
        1 : "허용 안눌렀음",
        2 : "위치가 안잡힘",
        3 : "응답시간 지남"
    };
    var errorMsg = errorTypes[error.code];
}
</script>
 </head>
 

 
<body>

 <div id="header">
<nav class="navbar navbar-default font-dohyeon">
	<div class="navbar-header">
		<a class="navbar-brand" href="/">ZIOZIO</a>
	</div>
	<div style="background-color: #FFF" class="collapse navbar-collapse font-dohyeon" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li><a href="/main">메인</a></li>
			<li><a href="/board/list">게시판</a></li>
			<li><a href="/">내위치확인</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">메뉴<span class="caret"></span></a>
				<ul class="dropdown-menu" style="width: 200px;" >
				<c:choose>
					<c:when test="${not empty account }">
					WELCOME ${account.account_nick}님<hr>
						<li><a href="/mypage">마이페이지</a></li>
						<li><a href="/board/list">게시판</a></li>
						<li><a href="/awarded">column</a></li>
						<li><a href="/qnalist">QnA</a></li>
						<li><a href="/account/logout">로그아웃</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="/account/join">회원가입</a></li>
						<li><a href="/account/restoresession">로그인</a></li>
						<li><a href="/account/find">비밀번호 찾기</a></li>
						<li><a href="/board/list">게시판</a></li>
						<li><a href="/awarded">column</a></li>
					</c:otherwise>
				</c:choose>

				</ul>
			</li>
		</ul>
	</div>
</nav>
</div>







