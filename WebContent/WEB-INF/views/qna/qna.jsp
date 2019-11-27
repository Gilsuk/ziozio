<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="/layout/header.jsp" />


<div class="marginauto">
    <img src='/resources/img/ZIOZIO.png' >
</div>




<div id="wrap">
<div class="container ">
	<div class="col-lg-1 "></div>
	<div class="col-lg-10 ">
		<div class="jumbotron padding" >
			<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="center">Questions & Answers</h3>
			</div>
			<div id="chat" class="panel-collapse collapse in">
			<div id="chatlist" class="panel-body chat-widget">
			Panel content<br>
			문의하고<br>
			답변하고<br>
			아무거나<br>
			물어보셈<br>
			드루와드루와<br>
			
			
			
			
			</div>
			</div>
			</div>
			<div class="panel-footer">
			<div class="row">	
			<div class="col-lg-1"></div>
				<div class="col-lg-10">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="내용을 입력하세요">
						<span class="input-group-btn">
							<button id="go" class="btn btn-default" type="submit">전송</button>	
						</span>
					</div><!-- /input-group -->
				</div><!-- /.col-lg-6 -->
			<div class="col-lg-1"></div>
			</div><!-- /.row -->
			</div>
		</div>	<!-- jumbotron padding -->
	</div>
	<div class="col-lg-1"></div>
</div>
</div>



<jsp:include page="/layout/footer.jsp" />