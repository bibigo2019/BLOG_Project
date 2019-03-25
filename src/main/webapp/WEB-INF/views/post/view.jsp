<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	
<style>
	.card {
		border: none !important;
		margin-top :10px;
	}
	
	.card-inner{
	    margin-left: 4rem;
	}
</style>

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
		
		$( "#commentForm" ).submit(function( e ) {
			  e.preventDefault();
			  $.ajax({ 
					url : `${contextPath}/${blogId}/comments/${postId}`, 
					type : 'post',
					dataType : 'json',
					data : $("#commentForm").serialize(),
					cache : false, 
					success : function(data) {
						if(data.result == 'success') { 
							location.reload();
						} else {
							alert(data.result); 
						} 
					}, 
					error : function(xhr, statusText, errorThrown) { 
						console.log(`\${statusText} - \${xhr.status} , \$errorThrown`); 
					}
				}); 
			  
		});
		
		$( ".myForm" ).submit(function( e ) {
			  e.preventDefault();
			  var data = $(this).serialize();
			 $.ajax({ 
					url : `${contextPath}/${blogId}/comments/${postId}`, 
					type : 'post',
					dataType : 'json',
					data : data,
					cache : false, 
					success : function(data) {
						if(data.result == 'success') { 
							location.reload();
						} else {
							alert(data.result); 
						} 
					}, 
					error : function(xhr, statusText, errorThrown) { 
						console.log(`\${statusText} - \${xhr.status} , \$errorThrown`); 
					}
				}); 
			  
		});
		

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
						location.href = '/blogs'; 
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
	
	function reComment(id) {
		var $obj = $("#"+id);
		var isOpen = $obj.data('open');
		
		if(isOpen == true) {
			console.log($obj.hide());
			$obj.data('open',false);
		}
		else  {
			console.log($obj.show());
			$obj.data('open',true);
		}
	}
	
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
								<a class="url fn n" href="${contextPath}/${blogId}/list">목록</a>&nbsp;|
								<a class="url fn n" href="${contextPath}/${blogId}/edit/${postId}">수정</a>&nbsp;|
								<a class="url fn n" id="delete" href="#">삭제</a>
							</span>
						</div>
						<!-- .entry-meta -->
						<div style="float:right;">
							첨부파일 &nbsp;&nbsp; <a href="${contextPath}/download/${ postId }" >${ file.name }</a>
						</div>
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

	<div class="row">
		<div class="col-md-12 mb-2">
			<form id="commentForm" method="post">
				<label for="comment">comment <i class="fa fa-comments"></i></label>
				<textarea id="comment" style="width:100%" name="comment" rows="2" cols=""></textarea>
				<input type="hidden"  name="depth" value="0" />
				<input type="hidden"  name="pCmtId" value="0" /> 
				<div style="float:right;">
				<button type="submit">write</button>
				</div>
			</form>	
		</div>
	</div>
	<div style="background:white;">
	<c:forEach var="parent" items="${ ci.list }" varStatus="status1">
		<c:if test="${ parent.depth == 0 }">
			<div class="card">
	    		<div class="card-body">
	    			<div class="row">
		        	    <div class="col-md-1">
		        	        <img width="70" src="${ contextPath }/avata/${ parent.memberId }" class="img img-rounded img-fluid">
		        	    </div>
		        	    <div class="col-md-11">
		        	    	<a id="" href="javascript:reComment('RT_${ parent.cmtId }')" style="float:right;" data-open="false">
		        	    		<i class="fa fa-comment-dots"></i> 답글달기
		        	    	</a>
		        	        <p>
		        	            <p><a href="${ contextPath }/${ parent.blogId}/list"><strong>${ parent.memberId }</strong></a>
		        	            ${ parent.regDate }</p>
		        	       	</p>
		        	       <div class="clearfix"></div>
		        	        <p>${ parent.content }</p>
		        	        
		        	         <div style="display:none;" class="col-md-12"  data-parent="${ parent.cmtId }" id="RT_${ parent.cmtId }" data-open="false">
			        	    	<div>
			        	    		<form class="myForm" method="post">
										<textarea style="width:100%" name="comment" rows="2" cols=""></textarea>
										<input type="hidden"  name="depth" value="1" />
										<input type="hidden"  name="pCmtId" value="${ parent.cmtId }" /> 
										<div style="float:right;">
										<button type="submit">write</button>
										</div>
									</form>
			        	    	</div>
			        	    </div>
		        	    </div>
			        </div>
			        
			        <c:forEach var="child" items="${ ci.list }" varStatus="status2">
			        	<c:if test="${ child.paCmtId == parent.cmtId }">
			        		<div class="card card-inner">
				           	    <div class="card-body">
				           	        <div class="row">
				                   	    <div class="col-md-1">
				                   	        <img width="70" src="${ contextPath }/avata/${ child.memberId }" class="img img-rounded img-fluid">
				                   	    </div>
				                   	    <div class="col-md-11">
				                   	        <p><a href="${ contextPath }/${ child.blogId}/list"><strong>${ child.memberId }</strong></a>
				                   	         ${ child.regDate }</p>
				                   	        <p>${ child.content }</p>
				                   	    </div>
				           	        </div>
				           	    </div>
				            </div>
			        	</c:if>
			        </c:forEach>
			         </div>
					</div>
		</c:if>
	</c:forEach>
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

