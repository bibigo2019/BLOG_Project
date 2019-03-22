<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.jumbotron {
	background-image: url(${contextPath}/resources/images/demo_1.jpg);
	background-size: cover;
	height: 100%;
}
</style>

<div class="container">
	<header class="blog-header py-3">
		<div
			class="row flex-nowrap justify-content-between align-items-center">
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
			<h1 class="display-4 font-italic">Title of a longer featured
				blog post</h1>
			<p class="lead my-3">Multiple lines of text that form the lede,
				informing new readers quickly and efficiently about what’s most
				interesting in this post’s contents.</p>
			<p class="lead mb-0">
				<a href="#" class="text-white font-weight-bold">Continue
					reading...</a>
			</p>
		</div>
	</div>



	<!-- thumbnail-->
	<div class="row mb-2">
		<div class="col-md-6">
			<div
				class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
				<div class="col p-4 d-flex flex-column position-static">
					<strong class="d-inline-block mb-2 text-primary">World</strong>
					<h3 class="mb-0">Featured post</h3>
					<div class="mb-1 text-muted">Nov 12</div>
					<p class="card-text mb-auto">This is a wider card with
						supporting text below as a natural lead-in to additional content.</p>
					<a href="#" class="stretched-link">Continue reading</a>
				</div>
				<div class="col-auto d-none d-lg-block">
					<svg class="bd-placeholder-img" width="200" height="250"
						xmlns="http://www.w3.org/2000/svg"
						preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
						aria-label="Placeholder: Thumbnail">
						<title>Placeholder</title><rect width="100%" height="100%"
							fill="#55595c"></rect>
						<text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div
				class="row no-gutters border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
				<div class="col p-4 d-flex flex-column position-static">
					<strong class="d-inline-block mb-2 text-success">Design</strong>
					<h3 class="mb-0">Post title</h3>
					<div class="mb-1 text-muted">Nov 11</div>
					<p class="mb-auto">This is a wider card with supporting text
						below as a natural lead-in to additional content.</p>
					<a href="#" class="stretched-link">Continue reading</a>
				</div>
				<div class="col-auto d-none d-lg-block">
					<svg class="bd-placeholder-img" width="200" height="250"
						xmlns="http://www.w3.org/2000/svg"
						preserveAspectRatio="xMidYMid slice" focusable="false" role="img"
						aria-label="Placeholder: Thumbnail">
						<title>Placeholder</title><rect width="100%" height="100%"
							fill="#55595c"></rect>
						<text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
				</div>
			</div>
		</div>
	</div>

	<!-- list -->
	<div class="list-group">
		<ul class="list-group list-group-flush">
			<a href="#"
				class="list-group-item list-group-item-action flex-column align-items-start ">
				<div class="d-flex w-100 justify-content-between ">
					<h4 class="mb-1 font-weight-bold">List group item heading</h4>
					<small>3 days ago</small>
				</div>
				<p class="mb-4">Donec id elit non mi porta gravida at eget
					metus. Maecenas sed diam eget risus varius blandit.</p> <small>Donec
					id elit non mi porta.</small>
			</a>
			<a href="#"
				class="list-group-item list-group-item-action flex-column align-items-start">
				<div class="d-flex w-100 justify-content-between">
					<h4 class="mb-1 font-weight-bold">List group item heading</h4>
					<small class="text-muted">3 days ago</small>
				</div>
				<p class="mb-4">Donec id elit non mi porta gravida at eget
					metus. Maecenas sed diam eget risus varius blandit.</p> <small
				class="text-muted">Donec id elit non mi porta.</small>
			</a>
			<a href="#"
				class="list-group-item list-group-item-action flex-column align-items-start">
				<div class="d-flex w-100 justify-content-between">
					<h4 class="mb-1 font-weight-bold">List group item heading</h4>
					<small class="text-muted">3 days ago</small>
				</div>
				<p class="mb-4">Donec id elit non mi porta gravida at eget
					metus. Maecenas sed diam eget risus varius blandit.</p> <small
				class="text-muted">Donec id elit non mi porta.</small>
			</a>
			<a href="#"
				class="list-group-item list-group-item-action flex-column align-items-start">
				<div class="d-flex w-100 justify-content-between">
					<h4 class="mb-1 font-weight-bold">List group item heading</h4>
					<small class="text-muted">3 days ago</small>
				</div>
				<p class="mb-4">Donec id elit non mi porta gravida at eget
					metus. Maecenas sed diam eget risus varius blandit.</p> <small
				class="text-muted">Donec id elit non mi porta.</small>
			</a>

		</ul>
	</div>

	<!-- pagenation -->
	<nav aria-label="Page navigation">
		<ul class="pagination justify-content-center p-md-4">
			<li class="page-item"><a class="page-link" href="#"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span
					class="sr-only">Previous</span>
			</a></li>
			<li class="page-item active"><a class="page-link" href="#">1</a></li>
			<li class="page-item "><a class="page-link" href="#">2</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#">4</a></li>
			<li class="page-item"><a class="page-link" href="#"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
					class="sr-only">Next</span>
			</a></li>
		</ul>
	</nav>
</div>

