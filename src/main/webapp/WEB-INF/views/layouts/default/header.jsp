<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="${contextPath}/"><img width="100px" src="${contextPath}/resources/images/logo.png" /></a>
    
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
    	
    		<ul class="navbar-nav mr-auto">
    		<c:if test="${not empty sessionScope.USER }">
      		<c:if test="${sessionScope.USER.admin == 'Y' }">
      	         <li class="nav-item">
		         <a class="nav-link" href="${contextPath}/admin/list?page=${param.page}">Admin</a>
		       </li>
      		</c:if>
      	
        <li class="nav-item">
          <a class="nav-link" href="${contextPath}/editBlog">Blog</a>
        </li>
        	</c:if>
      </ul>
    
      
      <ul class="navbar-nav">
			<c:if test="${empty USER}">
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/join"> <i class="fas fa-user-plus"></i>
						Sign up
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/login"> <i class="fas fa-sign-in-alt"></i>
						Sign in
				</a></li>
			</c:if>
			<c:if test="${not empty USER}">
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/view?page=${param.page}">
						<img src="${contextPath}/avata/${USER.memberId}"
						class="rounded-circle avata-sm">
						${USER.memberId}
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${contextPath}/logout"> <i class="fas fa-sign-out-alt"></i>
						로그아웃
				</a></li>
			</c:if>
		</ul>
    </div>
  </nav>
</header>