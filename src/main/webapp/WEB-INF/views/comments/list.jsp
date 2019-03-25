<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/util" prefix="iot"%>

<script>
//삭제 버튼
$(function(){
	$('.delete').click(function(){
		var url = $(this).data("delete-url");
		deleteComments(temp);
	});
	
	function deleteComments(boardId) { 
		$.ajax({ 
			url : `../delete/\${boardId}?password=\${password}`, 
			type : 'delete', 
			dataType : 'json', // 서버가 리턴해야하는 데이터 타입 
			cache : false, 
			success : function(data) { 
				if(data.result == 'success'){ 
					location.reload();
				} 
				else { 
					alert(data.result); 
				} 
			}, 
			error : function(xhr, statusText, errorThrown) { 
				console.log(`\${statusText} - \${xhr.status} , \${errorThrown}`); 
			} 
		}); 
	}
});
</script>

<h2 class="my-5">
	<i class="fas fa-list"></i> 댓글 목록
</h2>

<table class="table table-striped table-hover">
	<tr>
		<th>작성자</th>
		<th>내용</th>
		<th>등록일</th>
		<th>
			<div class="text-right">
				<button class="btn btn-warning">
					<i class="fas fa-pen">댓글쓰기</i>
				</button>
			</div>
		</th>
	</tr>

	<c:forEach var="comments" items="${ci.list}">
		<tr>
			<td>${comments.memberId}</td>
			<td>${comments.content}</td>
			<td><fmt:formatDate value="${comments.regDate}"
					pattern="yyyy-MM-dd" /></td>
			<td>
				<div class="text-right">
					<button class="btn btn-outline-primary update">
						<i class="fas fa-edit"></i> 수정
					</button>
					<button class="btn btn-outline-danger delete"
						data-delete-url = "${contextPath }/${blogId}/comments/${postId}/delete/${cmtId}/">
						<i class="fas fa-trash"></i> 삭제
					</button>
				</div>
			</td>
		</tr>
	</c:forEach>

</table>
