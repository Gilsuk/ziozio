<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<div>
<div class="row">
<div class="col-lg-12">
	<c:forEach items="${clothset}" var="set">
		<div class="clothset-con" >
		
			<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
			<c:if test="${not empty set.top }">
				<img style="filter: hue-rotate(${set.top.color_hue_rotate}deg) 
							saturate(${set.top.color_saturate }%) invert(${set.top.color_invert }%) 
							brightness(${set.top.color_brightness }%);"
							 src="${set.top.cloth_img }" alt="${set.top.cloth_name }" class="img-thumbnail">
			</c:if>
			</div>
			
			<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
			<c:if test="${not empty set.bottom }">
				<img style="filter: hue-rotate(${set.bottom.color_hue_rotate}deg) 
							saturate(${set.bottom.color_saturate }%) invert(${set.bottom.color_invert }%) 
							brightness(${set.bottom.color_brightness }%);"
							 src="${set.bottom.cloth_img }" alt="${set.bottom.cloth_name }" class="img-thumbnail">
			</c:if>
			</div>
			
			<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
			<c:if test="${not empty set.outer }">
				<img style="filter: hue-rotate(${set.outer.color_hue_rotate}deg) 
							saturate(${set.outer.color_saturate }%) invert(${set.outer.color_invert }%) 
							brightness(${set.outer.color_brightness }%);"
							 src="${set.outer.cloth_img }" alt="${set.outer.cloth_name }" class="img-thumbnail">
			</c:if>
			</div>
		</div>
	</c:forEach>
</div>
</div>
</div>