<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script src="${contextPath}/resources/bower_components/axios/dist/axios.min.js"></script>

<div class="row">
	<div class="col-sm-6 mx-auto">
		<h2 class="my-5 text-success" style="font-weight: bold;">
			<i class="fas fa-user"></i> 사용자 정보
		</h2>
		<div class="my-1">사용자 ID : 
			<img src="${contextPath}/avata/${memberVO.memberId}"
				class="rounded-circle avata-sm">
			${memberVO.memberId}</div>
		<div class="my-1">이름 : ${memberVO.name}</div>
		<div class="my-1">이메일 : ${memberVO.email}</div>
		<div class="my-1">전화번호 : ${memberVO.phone}</div>
		<div class="my-1">주소 : ${memberVO.address}</div>
		<div class="my-1">
			가입일 :
			<fmt:formatDate value="${memberVO.regDate}" pattern="yyyy-MM-dd" />
		</div>
		<div class="my-1">
			수정일 :
			<fmt:formatDate value="${memberVO.updateDate}" pattern="yyyy-MM-dd" />
		</div>
	</div>
</div>

<hr />

<div class="text-center">
	<a href="${contextPath}/edit?page=${param.page}"
		class="btn btn-success text-white"><i class="fas fa-edit"></i> 수정</a>
</div>