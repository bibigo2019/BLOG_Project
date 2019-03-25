<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
	.center { 
  height: 200px;
  position: relative;
  background:grey;
  color:white;
  font-size:15pt;
}

.center p {
  margin: 0;
  position: absolute;
  top: 50%;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}

</style>

<div class="container">
	<div class="row">
		<img height="200" style="width:100%" src="${ contextPath }/resources/images/blog.jpg"/>
	</div>
</div>