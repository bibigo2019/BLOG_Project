<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="iot"%>
<style>
.jumbotron {
	background-image: url(${contextPath}/resources/images/demo_1.jpg);
	background-size: cover;
	height: 100%;
}
</style>

<div class="container">
	<div class="jumbotron p-2 p-md-5 text-white rounded bg-dark " var="blogsVO">
	<header class="blog-header py-3">
		<div class="row flex-nowrap justify-content-between align-items-center">
			<div class="col-4 pt-1">
				<a class="text-muted" href="#">Subscribe</a>
			</div>
			<div class="col-4 text-center">
				<a class="blog-header-logo text-dark" href="#">Large</a>
			</div>
			<div class="col-4 d-flex justify-content-end align-items-center">
				<a class="text-muted" href="#"> <svg
						xmlns="http://www.w3.org/2000/svg" width="20" height="20"
						fill="none" stroke="currentColor" stroke-linecap="round"
						stroke-linejoin="round" stroke-width="2" class="mx-3" role="img"
						viewBox="0 0 24 24" focusable="false">
						<title>Search</title><circle cx="10.5" cy="10.5" r="7.5"></circle>
						<path d="M21 21l-5.2-5.2"></path></svg>
				</a> <a class="btn btn-sm btn-outline-secondary" href="#">Sign up</a>
			</div>
		</div>
	</header>

	<div class="nav-scroller py-1 mb-2">
		<nav class="nav d-flex justify-content-between">
			<a class="nav-link" href="${contextPath}/board/list">Board</a>
		</nav>
	</div>


	<div class="jumbotron p-2 p-md-5 text-white rounded bg-dark ">
		<div class="col-md-6 px-0">
			<h1 class="display-4 font-italic">${blogsVO.title}</h1>
			<p class="lead mb-0">
				<a href="#" class="text-white font-weight-bold">Continue reading...</a>
			</p>
		</div>
	</div>

	<!-- thumbnail-->
	<div class="row mb-2">
		<c:forEach var="data" items="${recommend}">
			<div class="col-md-6">
				<div
					class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
					<div class="col p-4 d-flex flex-column position-static">
						<strong class="d-inline-block mb-2 text-primary">Today's Post</strong>
						<a href="../${data.blogId}/view/${data.postId}">
							<h1 class="mb-0">${data.title}</h1>
						</a>
						<p class="card-text mb-auto">${data.content}</p>
					</div>
				</div>
			</div>
		</c:forEach>
		<%-- <div class="col-md-6">
			<div
				class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
				<div class="col p-4 d-flex flex-column position-static">
					<strong class="d-inline-block mb-2 text-success">TOP 2 POST</strong>
					<h3 class="mb-0">${postVO.title}</h3>
					<div class="mb-1 text-muted">${postVO.regDate}</div>
					<p class="mb-auto">This is a wider card with supporting text
						below as a natural lead-in to additional content.</p>
					<a href="#" class="stretched-link">Continue reading</a>
				</div>
				
			</div>
		</div> --%>
	</div>

	<hr />

	<div>
		<h2 class="font-weight-bold">
			<i class="fas fa-utensils"></i> 포스트 목록
		</h2>
	</div>

	<div class="text-right">
		<a href="write?page=${pi.page}"><i class="fas fa-edit"></i> 포스트 쓰기</a>
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
					<p class="mb-4">포스트 내용이 들어갈 자리입니다.</p>
				</a>
			</c:forEach>
		</ul>
	</div>
	<br />
</div>

<!-- pagenation -->
<iot:pagination pageInfo="${pi}" />