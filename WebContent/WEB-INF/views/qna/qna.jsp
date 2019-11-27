<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 

 

<div class="marginauto">
    <img src='/resources/img/ZIOZIO.png' >
</div>





<div class="container bootstrap snippet">
	<div class="row">
		<div class="col-lg-1"></div>
		<div class="col-lg-10">
			<div class="jumbotron padding" >
			<div class="portlet portlet-default">
				<div class="portlet-heading">
					<div class="portlet-title center">
						<h3>Questions & Answers</h3>
					</div>
					<div class="clearfix"></div>
				</div>
				<div id="chat" class="panel-collapse collapse in">
					<div id="chatlist" class="porlet-body chat-widget" style="overflow-y: auto; width: auto; height: 600px;">
					</div>
					<div class="portlet-footer">
						
						<div class="row" style="height: 90px;">
							<div class="form-group col-xs-10">
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
		<div class="col-lg-1"></div>
	</div>
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