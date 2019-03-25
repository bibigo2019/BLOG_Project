<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
	$(function () {
		var modalConfirm = function(callback){
		  $("#delete").on("click", function(){
		    $("#myModal").modal('show');
		  });

		  $("#btn-ok").on("click", function(){
		    callback(true);
		    $("#myModal").modal('hide');
		  });
		  
		  $("#btn-no").on("click", function(){
		    callback(false);
		    $("#myModal").modal('hide');
		  });
		};

		modalConfirm(function(confirm){
		  if(confirm){
			  $.ajax({ 
				url : `${contextPath}/${blogId}/delete/${postId}`, 
				type : 'delete',
				dataType : 'json', 
				cache : false, 
				success : function(data) {
					if(data.result == 'success') { 
						alert("글이 삭제 되었습니다.");
						location = '/blogs'; 
					} else {
						alert(data.result); 
					} 
				}, 
				error : function(xhr, statusText, errorThrown) { 
					console.log(`\${statusText} - \${xhr.status} , \$errorThrown`); 
				}
			}); 
		  }
		});
	});
</script>


<style>
	.menu {
		float:right;
	}
</style>

<div class="container">
	<div class="row mt-5">
		<div class="col-md-12">
			<div class="col-md-12">
				<article class="post format-standard hentry">
					<header class="entry-header">
						<div class="heading-title">
							<h1 class="entry-title">${ post.title }</h1>
						</div>
						<div class="entry-meta">
							<span class="posted-on"><i class="fa fa-calendar-alt"></i> ${ post.updateDate }</span> 
							<span class="author vcard"> <i class="fa fa-pencil-alt"></i> by <a class="url fn n" href="#">${ post.memberId }</a></span>
							<span class="meta-viewer"><i class="fa fa-eye"></i> ${ post.readCnt } Views</span> 
							<span class="menu">
								<a class="url fn n" href="${contextPath}/${blogId}/edit/${postId}">수정</a>&nbsp;|
								<a class="url fn n" id="delete" href="#">삭제</a>
							</span>

						</div>
						<!-- .entry-meta -->

					</header>
					<!-- .entry-header -->

					<div class="entry-content">
						<p>${ post.content }</p>
					</div>
					<!-- .entry-content -->
				</article>
				<!-- .post -->
			</div>
		</div>
	</div>
</div>

<<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">포스팅 삭제</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">정말로 삭제하시겠습니까?</div>
      <div class="modal-footer">
        <button type="button" id="btn-no" class="btn btn-secondary" data-dismiss="modal">취소</button>
        <button type="button" id="btn-ok" class="btn btn-primary">삭제</button>
      </div>
    </div>
  </div>
</div>

