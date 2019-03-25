<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<a class="navbar-brand" href="${contextPath}/"> <i
		class="fas fa-globe-americas"></i> Travel.com
	</a>
	<button class="navbar-toggler" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="#"> <i
					class="fas fa-list-ul"></i> 여행목록
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${contextPath}/gallery/list"> <i 
					class="fas fa-images"></i> 갤러리
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#"> <i
					class="fas fa-hotel"></i> 숙박지
			</a></li>
			<li class="nav-item"><a class="nav-link"
				href="${contextPath}/board/list"> <i class="fas fa-calendar-alt"></i>게시판
			</a></li>
		</ul>
		<ul class="navbar-nav">
			<c:if test="${empty USER}">
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/join"> <i class="fas fa-user-plus"></i>
						회원가입
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/login"> <i class="fas fa-sign-in-alt"></i>
						로그인
				</a></li>
			</c:if>
			<c:if test="${not empty USER}">
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/member/view">
						<%-- <img src="${contextPath}/member/avata/${USER.userId}"
						class="rounded-circle avata-sm"> --%>
						${USER.userId}
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/logout"> <i class="fas fa-sign-out-alt"></i>
						로그아웃
				</a></li>
			</c:if>
		</ul>
	</div>
</nav>