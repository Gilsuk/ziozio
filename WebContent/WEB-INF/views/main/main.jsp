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
</style>





<div class="container ">
	<div class="marginauto">
  		<a href="/main"><img class="ziozio" src='/resources/img/ZIOZIO.png' ></a>
  	</div>
</div>


<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
  
    <div class="item active">
      <img src="/resources/img/look/hoodie.png" alt="...">
      <div class="carousel-caption">
      
      </div>
    </div>
    
    <div class="item">
      <img src="/resources/img/look/short_padding.png" alt="...">
      <div class="carousel-caption">
      
      </div>
    </div>
    
    <div class="item">
      <img src="/resources/img/look/long_padding.png" alt="...">
      <div class="carousel-caption">
      
      </div>
    </div>
    
    <div class="item">
      <img src="/resources/img/look/night_trading" alt="...">
      <div class="carousel-caption">
      
      </div>
    </div>

    <div class="item">
      <img src="/resources/img/look/check_muffler.png" alt="...">
      <div class="carousel-caption">
      
      </div>
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

<br>

<c:if test="${not empty account }">
	<div class="text-center font-dohyeon"><h2>${account.account_nick } 님 로그인되었습니다.</h2></div>
</c:if>


<c:if test="${empty account }">
	<div class="text-center font-dohyeon"><br>
		<a class="btn" style="background-color: #FFD2BD" href="/account/restoresession" role="button">로그인</a>
		<a class="btn" style="background-color: #FFD2BD" href="/account/join" role="button">회원가입</a>
	</div>
</c:if>



<jsp:include page="/WEB-INF/views/layout/footer.jsp" />
