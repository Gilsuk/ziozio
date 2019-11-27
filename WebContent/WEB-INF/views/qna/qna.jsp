<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image⁄x-icon" href="">
<meta charset="UTF-8">
<title>ZIOZIO</title>

<script
  src="https://code.jquery.com/jquery-2.2.4.min.js"
  integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
  crossorigin="anonymous"></script>
  
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="/resources/css/style.css" />


 
 </head>
<body>
<div class="marginauto">
    <img src='/resources/img/ZIOZIO.png' >
</div>


<!-- <div class="jumbotron padding" > -->


<div class="container bootstrap snippet">
	<div class="row">
		<div class="col-lg-12">
			<div class="portlet portlet-default">
				<div class="portlet-heading">
					<div class="portlet-title">
						<h3><i class="fa fa-circle text-green"></i>Questions & Answers</h3>
					</div>
					<div class="clearfix"></div>
				</div>
				<div id="chat" class="panel-collapse collapse in">
					<div id="chatlist" class="porlet-body chat-widget" style="overflow-y: auto; width: auto; height: 600px;">
					</div>
					<div class="portlet-footer">
						<div class="row">
							<div class="form-group col-xs-4">
								<input style="height: 40px;" typw="text" id="chatneme" class="form-control" placeholder="이름" maxlength="8">
							</div>
						</div>
						<div class="row" style="height: 90px;">
							<div clas s="form-group col-xs-10">
								<textarea style="height: 80px;" id="chatcontent" class="form-control" placeholder="메시지를 입력하세요" maxlength="100"></textarea>
							</div>
							<div class="form-group col-xs-2">
								<button type="button" class="btn btn-default pull-right" onclick="submitFunction();">전송</button>
								<div class="clearfix"></div>
							</div>	
						</div>	
					</div>
				</div>
			</div>	
		</div>	
	</div>
</div>
<div class="alert alert-success" id="successMessage" style="display: none;">
	<strong>메시지 전송에 성공했습니다.</strong>
</div>		
<div class="alert alert-success" id="dangerMessage" style="display: none;">
	<strong>이름과 내용을 모두 입력해주세요.</strong>
</div>		
<div class="alert alert-success" id="warningMessage" style="display: none;">
	<strong>데이터베이스 오류가 발생했습니다.</strong>
</div>		
			
			
			
			
<!-- 			<div class="panel-footer">
			<div class="row">	
			<div class="col-lg-1"></div>
				<div class="col-lg-10">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="내용을 입력하세요">
						<span class="input-group-btn">
							<button id="go" class="btn btn-default" type="submit">전송</button>	
						</span>
					</div>/input-group
				</div>/.col-lg-6
			<div class="col-lg-1"></div>
			</div>/.row
			</div>
		</div>	jumbotron padding
	</div>
	<div class="col-lg-1"></div>
</div> -->




<jsp:include page="/WEB-INF/views/layout/footer.jsp" />