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
			<a href="#"> <img class="mx-auto" width="250px"
				src="${contextPath}/resources/images/logo.png" />
			</a>
		</div>
		<h2 class="my-5 text-center" style="font-weight: bold;">회원 가입</h2>
		<form:form modelAttribute="memberVO" enctype="multipart/form-data">
			<div>
				<label for="title"><h6 class="font-weight-bold">블로그 제목</h6></label><br />
				<input type="text" name="title" class="form-control" />
				<hr />
			</div>
			<div class="form-group">
				<label for="memberId">
					<h6 class="font-weight-bold">사용자 ID</h6>
					<button type="button" class="btn btn-success btn-sm id-check">
						<i class="fas fa-user-check"></i> 중복 체크
					</button> <span id="message"></span>
				</label>
				<form:input path="memberId" class="form-control" />
				<form:errors path="memberId" element="div" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="password"><h6 class="font-weight-bold">비밀번호</h6></label>
				<form:password path="password" class="form-control" />
				<form:errors path="password" element="div" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="password2"><h6 class="font-weight-bold">비밀번호
						확인</h6></label> <input type="password" id="password2" class="form-control" />
			</div>
			<div class="form-group">
				<label for="name"><h6 class="font-weight-bold">이름</h6></label>
				<form:input path="name" class="form-control" />
				<form:errors path="name" element="div" cssClass="error" />
			</div>
			<div class="mb-3">
				<label for="avata"><h6 class="font-weight-bold">아바타 이미지</h6></label><br />
				<input type="file" name="avataImage" />
			</div>
			<div class="form-group">
				<label for="email"><h6 class="font-weight-bold">email</h6></label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" element="div" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="phone"><h6 class="font-weight-bold">전화번호</h6></label>
				<form:input path="phone" class="form-control" />
			</div>
			<div class="form-group">
				<label for="address"><h6 class="font-weight-bold">주소</h6></label>
				<form:input path="address" class="form-control" />
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-success" disabled>
					<i class="fas fa-check"></i> 완료
				</button>
			</div>
		</form:form>
	</div>
</div>