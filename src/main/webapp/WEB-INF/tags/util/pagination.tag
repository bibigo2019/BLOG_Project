<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="pageInfo" required="true"
type="edu.autocar.cmmn.domain.PageInfo" %>
	
<ul class="pagination pagination-md justify-content-center">
		<c:forEach var="p" begin="1" end="${pageInfo.totalPage}" varStatus="status">
			<c:choose>
				<c:when test="${pageInfo.page == p}">
					<li class="page-item active"><a class="page-link" href="#">${p}</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="?page=${p}">${p}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
</ul>