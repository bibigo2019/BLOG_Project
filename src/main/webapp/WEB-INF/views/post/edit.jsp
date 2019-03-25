<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script src="${contextPath}/resources/bower_components/tinymce/tinymce.min.js"></script>
<script src="${contextPath}/resources/js/dropzone.js"></script>

<script>
$(function(){
	$("textarea").val(`${ post.content }`);
	tinymce.init({
		selector: 'textarea',
		language: 'ko_KR',
		plugins: "paste",
		paste_data_images: true,
		height: 500
	});
})
</script>

<div class="container">
	<div class="row mt-5">
		<div class="col-md-12">
			<div class="col-md-12">
				<form:form modelAttribute="postVO" enctype="multipart/form-data">
					<div class="form-group">
						<label for="title">제목</label>
						<form:input path="title" class="form-control" value="${ post.title }"/>
						<form:errors path="title" element="div" cssClass="error" />
					</div>
					<div class="form-group">
						<label for="content">내용</label>
						<form:textarea path="content" class="form-control" rows="10"/>
					</div>
					
					<div class="form-group">
						<label for="content">첨부파일</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="file" name="file"/>
					</div>
					
					<div class="text-center">
						<button type="submit" class="btn btn-dark ok">
							<i class="fas fa-check"></i> 수정
						</button>
						<a href="list?page=${param.page}" class="btn btn-dark back">
							<i class="fas fa-undo"></i> 취소
						</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>

