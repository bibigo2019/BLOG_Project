<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row">
	<div class="col-sm-6 mx-auto">
		<h2 class="my-5 text-primary">
			<i class="fas fa-user-cog"></i> 회원 정보 수정
		</h2>
		<form:form modelAttribute="memberVO" enctype="multipart/form-data">			
			<div class="form-group">
				<form:hidden path="memberId" />
				<label for="userId">사용자 ID </label>
				<input class="form-control" value="${memberVO.memberId}" disabled>
			</div>
			<div class="form-group">
				<label for="password">비밀번호</label>
				<form:password path="password" class="form-control" />
				<form:errors path="password" element="div" cssClass="error" />
			</div>
			<div class="form-group">
				<form:hidden path="name" class="form-control" />
				<label for="name">이름</label> 
				<input class="form-control" value="${memberVO.name}" disabled>
			</div>
			<div class="mb-3">
				<label for="avataImage">아바타 이미지</label><br>
				<img src="${contextPath}/avata/${memberVO.memberId}" width="50">
				&nbsp;&nbsp;&nbsp;<input type="file" name="avataImage"/>
			</div>
			<div class="form-group">
				<label for="email">이메일</label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" element="div" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="phone">전화번호</label>
				<form:input path="phone" class="form-control" />
			</div>
			<div class="form-group">
				<label for="address">주소</label>
				<form:input path="address" class="form-control" />
				<form:errors path="address" element="div" cssClass="error" />
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-primary ok">
					<i class="fas fa-check"></i> 완료
				</button>
				<a href="${contextPath}/view?page=${param.page}"
					class="btn btn-primary back"> <i class="fas fa-undo"></i> 돌아가기
				</a>
			</div>
		</form:form>
	</div>
</div>