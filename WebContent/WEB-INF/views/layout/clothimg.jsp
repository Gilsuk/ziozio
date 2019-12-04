<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


					<img style="filter: hue-rotate(${cloth.color_hue_rotate}deg) 
								saturate(${cloth.color_saturate }%) invert(${cloth.color_invert }%) 
								brightness(${cloth.color_brightness }%);"
								 src="${cloth.cloth_img }" alt="${cloth.cloth_name }" class="img-thumbnail">
