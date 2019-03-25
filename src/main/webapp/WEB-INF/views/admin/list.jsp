<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="iot"%>
<script src="${contextPath}/resources/bower_components/axios/dist/axios.min.js"></script>
<script>
$(function(){
	$('#delete-panel').deletePanel({
		triger : '.delete',
		url : 'delete/{member-id}',
		multiple : '[name=check-item]:checked',
		moveUrl : 'list?page=${param.page}'
	});
	
	$('#check-all').change(function(){
		$('[name=check-item]').prop('checked', this.checked);
	});
	
	$('[name=check-item]').change(function(){
		if(!this.checked){
			$('#check-all').prop('checked', false);
		}
	});
})
</script>
<h2 class="my-5">
	<i class="fas fa-address-book"></i> 회원 목록
</h2>
<div class="float-left">
	<input type="checkbox" id="check-all"/> <label>전체</label>
	<button class="btn btn-danger btn-sm check-delete delete"
			data-mode="multiple">
		<i class="fas fa-user-times"></i> 선택 삭제
	</button>
</div>
<div class="text-right">
	<a href="create"><i class="fas fa-user-plus"></i> 회원추가</a>
	(총 : ${pi.totalCount} 명)
</div>
<table class="table table-striped table-hover">
	<tr>
	<!-- NO / ID / 이름 / 이메일 / 전화번호 / 등록일-->
		<th>No</th>
		<th>ID</th>
		<th>BLOG ID</th>
		<th>이름</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>등록일</th>
		<th></th>
		<th></th>
	</tr>
	<c:forEach var="memberVO" items="${pi.list}" varStatus="status">
		<tr>
			<td>
				<input type="checkbox" name="check-item" value="${memberVO.memberId}"/>
				${pi.totalCount -((pi.page-1)*10) - status.index}
			</td>
			<td><a href="view/${memberVO.memberId}?page=${pi.page}">
					${memberVO.memberId}
					<iot:newToday test="${memberVO.regDate}"/>
				</a>
			</td>
			<td>${memberVO.blogId}</td>
			<td>${memberVO.name}</td>					
			<td>${memberVO.email}</td>
			<td>${memberVO.phone}</td>
			<td>
				<fmt:formatDate value="${memberVO.regDate}"
					pattern="yyyy-MM-dd" />
			</td>
			<td class="text-right">
				<a href="edit/${memberVO.memberId}?page=${param.page}"
					class="btn btn-primary btn-sm mr-2" title="수정">
					<i class="fas fa-user-cog"></i></a>
				<button class="btn btn-danger btn-sm delete"
					data-member-id="${memberVO.memberId}"
					title="삭제"><i class="fas fa-user-times"></i>
				</button> 
			</td>
		</tr>
	</c:forEach>
</table>
<div id="delete-panel" class="text-center" style="display: none"></div>
<!-- 페이지네이션 -->
<iot:pagination pageInfo="${pi}"/>