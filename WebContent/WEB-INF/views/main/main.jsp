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

<div class="container ">
	<div class="marginauto">
  		<a href="/main"><img class="ziozio" src='/resources/img/ZIOZIO.png' ></a>
  	</div>
</div>

<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
  
    <div class="item active">
      <img src="/resources/img/look/hoodie.png" alt="...">
    </div>
    
    <div class="item">
      <img src="/resources/img/look/short_padding.png" alt="...">
    </div>
    
    <div class="item">
      <img src="/resources/img/look/long_padding.png" alt="...">
    </div>
    
    <div class="item">
      <img src="/resources/img/look/night_trading" alt="...">
    </div>

    <div class="item">
      <img src="/resources/img/look/check_muffler.png" alt="...">
    </div>  
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


<c:if test="${!empty account }">
<div class="text-center font-dohyeon center"><br>
	<a class="btn input" href="/weather/cloth" role="button">날씨별 옷 보기</a>&nbsp;&nbsp;
	<a class="btn input" href="/temperature/cloth" role="button">기온별 옷 보기</a>&nbsp;&nbsp;
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
