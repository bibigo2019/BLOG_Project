<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="iot"%>

<style>
.carousel-inner>.carousel-item>img, .carousel-inner>.carousel-item>a>img
	{
	display: block;
	height: 400px;
	min-width: 100%;
	width: 100%;
	max-width: 100%;
	line-height: 1;
}

.carousel-caption {
	text-align: right;
	cursor: pointer;
}

div .carousel-caption:hover {
	color: #d1d2d6;
}

</style>

<script>
	$(function ()  {
		$('.carousel-item').click(function() {
			location.href=$(this).data('url');
		})
	});
</script>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ul class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ul>

	<!-- The slideshow -->
	<div class="carousel-inner">
		<c:forEach var="data" items="${ recommend }" varStatus="status">
			<div data-url="${contextPath}/${data.blogId}/view/${data.postId}" class="carousel-item <c:if test="${ status.count == 1 }">active</c:if>">
				<div class="carousel-caption">
					<h1>${ data.postTitle }</h1>
					<p>by. ${ data.blogTitle } (@${ data.memberId })</p>
				</div>
				<img src="${contextPath}/image/${ data.blogId }" alt="">
			</div>
		</c:forEach>
	</div>

	<!-- Left and right controls -->
	<a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
		<span class="carousel-control-prev-icon"></span>
	</a> <a class="carousel-control-next" href="#myCarousel" data-slide="next">
		<span class="carousel-control-next-icon"></span>
	</a>
</div>

<style>
	 #container1{
	    height: 770px;
	    overflow: hidden;
	}
	
	#container2{
	    height: 769px;
	    overflow: auto;
	    padding-right: 20px;
	}
</style>

<div class="container marketing">
	<!-- Three columns of text below the carousel -->
	<div class="mt-5">
		<h1>Members <i class="far fa-user"></i></h1>
	</div>
	
	<div class="" id="container1" >
	<div class="row mt-5 mb-5 temp" id="container2">
		<c:forEach var="data" items="${ blogs }" varStatus="status">
		<div class="col-lg-3" style="text-align:center;padding:10px;">
			<a href="${contextPath}/${ data.blogId }/list"><img src="/blogs/avata/${ data.memberId }" class="rounded-circle avata-lg"></a>
			<h2>${ data.name } (@${ data.memberId })</h2>
			<p>Blogs. ${ data.blogTitle }</p>
		</div>
		</c:forEach>
	</div>
	</div>
	<!-- /.row -->
</div>
