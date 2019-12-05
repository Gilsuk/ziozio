<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 
<title>관리자 화면</title>



<div class="panel panel-default">
	<div class="panel-heading">Hey Look! Those Buttons are circular!!
	</div>
	<!-- /.panel-heading -->
	<div class="panel-body">
		<h4>Normal Circle Buttons</h4>
		<button type="button" class="btn btn-default btn-circle">
			<i class="fa fa-check"></i>
		</button>
		<button type="button" class="btn btn-primary btn-circle">
			<i class="fa fa-list"></i>
		</button>
		<button type="button" class="btn btn-success btn-circle">
			<i class="fa fa-link"></i>
		</button>
		<button type="button" class="btn btn-info btn-circle">
			<i class="fa fa-check"></i>
		</button>
		<button type="button" class="btn btn-warning btn-circle">
			<i class="fa fa-times"></i>
		</button>
		<button type="button" class="btn btn-danger btn-circle">
			<i class="fa fa-heart"></i>
		</button>
		<br> <br>
		<h4>Large Circle Buttons</h4>
		<button type="button" class="btn btn-default btn-circle btn-lg">
			<i class="fa fa-check"></i>
		</button>
		<button type="button" class="btn btn-primary btn-circle btn-lg">
			<i class="fa fa-list"></i>
		</button>
		<button type="button" class="btn btn-success btn-circle btn-lg">
			<i class="fa fa-link"></i>
		</button>
		<button type="button" class="btn btn-info btn-circle btn-lg">
			<i class="fa fa-check"></i>
		</button>
		<button type="button" class="btn btn-warning btn-circle btn-lg">
			<i class="fa fa-times"></i>
		</button>
		<button type="button" class="btn btn-danger btn-circle btn-lg">
			<i class="fa fa-heart"></i>
		</button>
		<br> <br>
		<h4>Extra Large Circle Buttons</h4>
		<button type="button" class="btn btn-default btn-circle btn-xl">
			<i class="fa fa-check"></i>
		</button>
		<button type="button" class="btn btn-primary btn-circle btn-xl">
			<i class="fa fa-list"></i>
		</button>
		<button type="button" class="btn btn-success btn-circle btn-xl">
			<i class="fa fa-link"></i>
		</button>
		<button type="button" class="btn btn-info btn-circle btn-xl">
			<i class="fa fa-check"></i>
		</button>
		<button type="button" class="btn btn-warning btn-circle btn-xl">
			<i class="fa fa-times"></i>
		</button>
		<button type="button" class="btn btn-danger btn-circle btn-xl">
			<i class="fa fa-heart"></i>
		</button>
	</div>
	<!-- /.panel-body -->
</div>


<jsp:include page="/WEB-INF/views/layout/footer.jsp" />