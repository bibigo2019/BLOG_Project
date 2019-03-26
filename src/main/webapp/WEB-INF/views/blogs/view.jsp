<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="iot"%>
<style>
.jumbotron {
	background-image: url(${contextPath}/image/${blogsVO.blogId});
	background-size: 100% 100%;
	min-height: 300px;
}
#blogTitle{
	font-size: xx-large;
}
#rec{
	background-color: white;
}
</style>

<div class="container">
	<div style="margin-top:5rem;">
	</div>	
	<div class="jumbotron text-white rounded bg-dark ">
		<div class="col-md-6 px-0">
			<h1 id="blogTitle" class="font-italic">${blogsVO.title}</h1>
		</div>
	</div>

	<!-- thumbnail-->
	<div class="row mb-2">
		<c:forEach var="data" items="${recommend}">
			<div class="col-md-6">
				<div
					class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
					<div id="rec" class="col p-4 d-flex flex-column position-static">
						<strong class="d-inline-block mb-2 text-primary">Today's
							Post</strong> <a href="../${data.blogId}/view/${data.postId}">
							<h1 class="mb-0">${data.title}</h1><br/>
							<medium class="text-muted"> 조회수 : ${data.readCnt}</medium>
						</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

	<hr />

	<div>
		<h2 class="font-weight-bold">
			<i class="fas fa-utensils"></i> 포스트 목록
		</h2>
	</div>

	<div class="text-right">
		<c:if test="${ sessionScope.USER.blogId == blogsVO.blogId }">
		<a href="write?page=${pi.page}"><i class="fas fa-edit"></i> 포스트 쓰기</a>
		</c:if>
		(총 : ${pi.totalCount} 건)
	</div>
	</br>

	<!-- list -->
	<div class="list-group">
		<ul class="list-group list-group-flush">
			<c:forEach var="postVO" items="${pi.list}">
				<a href="../${postVO.blogId}/view/${postVO.postId}"
					class="list-group-item list-group-item-action flex-column align-items-start">
					<div class="d-flex w-100 justify-content-between">
						<h4 class="mb-1 font-weight-bold">${postVO.title}</h4>
						<small class="text-muted"> 등록일 : <fmt:formatDate
								value="${postVO.regDate}" pattern="yyyy-MM-dd" />
						</small>
					</div>
					<p class="mb-4"></p>
				</a>
			</c:forEach>
		</ul>
	</div>
	<br />
</div>

<!-- pagenation -->
<iot:pagination pageInfo="${pi}" />