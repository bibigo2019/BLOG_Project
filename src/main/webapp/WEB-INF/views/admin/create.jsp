<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="${contextPath}/resources/js/member.js"></script>
<script>
	$(function() {
		$('.id-check').checkUserId();
		$('#memberVO').checkPassword();
	})
</script>
<div class="row">

	<div class="col-sm-6 mx-auto">
		<div class="text-center">
			<a href="#">
				<img class="mx-auto" width="250px" src="${contextPath}/resources/images/logo.png" />
			</a>
		</div>
		<h2 class="my-5 text-center" style="font-weight: bold;">
			회원 추가
		</h2>
		<form:form modelAttribute="memberVO" enctype="multipart/form-data">
			<div>
				<label for="title">블로그 제목</label><br/>
				<input type="text" name="title" /><hr/>
			</div>
			<div class="form-group">
				<label for="memberId"> 사용자 ID
					<button type="button" class="btn btn-primary btn-sm id-check">
						<i class="fas fa-user-check"></i> 중복 체크
					</button> <span id="message"></span>
				</label>
				<form:input path="memberId" class="form-control" />
				<form:errors path="memberId" element="div" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="password">비밀번호</label>
				<form:password path="password" class="form-control" />
				<form:errors path="password" element="div" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="password2">비밀번호 확인</label> <input type="password"
					id="password2" class="form-control" />
			</div>
			<div class="form-group">
				<label for="name">이름</label>
				<form:input path="name" class="form-control" />
				<form:errors path="name" element="div" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="admin">관리자 권한 Y/N</label>
				<form:input path="admin" class="form-control" />
				<form:errors path="admin" element="div" cssClass="error" />
			</div>
			<div class="mb-3">
				<label for="avata">아바타 이미지</label><br/>
				<input type="file" name="avataImage" />
			</div>
			<div class="form-group">
				<label for="email">email</label>
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
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-primary" disabled>
					<i class="fas fa-check"></i> 완료
				</button>
			</div>
		</form:form>
	</div>
</div>