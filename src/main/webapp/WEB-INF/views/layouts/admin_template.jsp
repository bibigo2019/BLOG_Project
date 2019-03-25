<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link rel="stylesheet" href="${contextPath}/resources/css/style.css">
<script src="${contextPath}/resources/js/common.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<tiles:insertAttribute name="header" />
	
	<div class="row" style="margin-top:5rem;">
		<div class="col-md-2">
			<tiles:insertAttribute name="admin-menu" />
		</div>
		<div class="col-md-10">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	
	<tiles:insertAttribute name="footer" />
</div>
</body>
</html>