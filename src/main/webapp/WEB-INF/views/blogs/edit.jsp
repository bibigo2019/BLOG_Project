<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row">
	<div class="col-sm-6 mx-auto">
		<h2 class="my-5 text-success" style="font-weight: bold;">
			<i class="fas fa-user-cog"></i> 블로그 수정
		</h2>
		<form:form modelAttribute="blogsVO" enctype="multipart/form-data">			
			<form:hidden path="blogId" />
			<div class="form-group">
				<label for="title">블로그 타이틀</label>
				<form:input path="title" class="form-control" />
				<form:errors path="title" element="div" cssClass="error" />
			</div>
			<div class="mb-3">
				<label for="blogImage">블로그 헤더 이미지</label><br>
				<input type="file" name="blogImage"/>
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-success ok">
					<i class="fas fa-check"></i> 완료
				</button>
				<a href="${contextPath}/"
					class="btn btn-success back"> <i class="fas fa-undo"></i> 돌아가기
				</a>
			</div>
		</form:form>
	</div>
</div>