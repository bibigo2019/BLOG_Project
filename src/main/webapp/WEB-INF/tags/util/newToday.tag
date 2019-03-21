<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ attribute name="test" required="true" type="java.util.Date" %>

<fmt:formatDate var="today" pattern="yyyy-MM-dd" value="<%=new java.util.Date()%>"/>
<fmt:formatDate var="testDay" pattern="yyyy-MM-dd" value="${test}"/>

<c:if test="${today==testDay}">
	<span class="badge badge-pill badge-danger">
		<i class="fas fa-tag"></i> New
	</span>
</c:if>