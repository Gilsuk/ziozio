<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:set var="category" value="${param.category }" />
<c:set var="style" value="${param.style }" />
<c:set var="color" value="${param.color }" />


<c:forEach items="${outerList }" var="cloth">
<div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
	<img style="filter: hue-rotate(${cloth.color_hue_rotate}deg) 
				saturate(${cloth.color_saturate }%) invert(${cloth.color_invert }%) 
				brightness(${cloth.color_brightness }%);"
				 src="${cloth.cloth_img }" alt="${cloth.cloth_name }" class="img-thumbnail"> 
</div>
</c:forEach>