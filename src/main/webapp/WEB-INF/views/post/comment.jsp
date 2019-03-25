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

<div class="container">
	<div class="row">
		<div class="col-md-12 mb-2">
			<form id="commentForm" method="post">
				<label for="comment">comment <i class="fa fa-comments"></i></label>
				<textarea id="comment" style="width:100%" name="comment" rows="2" cols=""></textarea>
				<div style="float:right;">
				<button type="submit">write</button>
				</div>
			</form>	
		</div>
	</div>
	
	<div class="card">
	    <div class="card-body">
	        <div class="row">
        	    <div class="col-md-1">
        	        <img width="70" src="https://image.ibb.co/jw55Ex/def_face.jpg" class="img img-rounded img-fluid">
        	    </div>
        	    <div class="col-md-11">
        	        <p>
        	            <a class="float-left" href="https://maniruzzaman-akash.blogspot.com/p/contact.html"><strong>Maniruzzaman Akash</strong></a>
        	       </p>
        	       <div class="clearfix"></div>
        	        <p>oijfeowifjewoif</p>
        	    </div>
	        </div>
	        
        	<div class="card card-inner">
           	    <div class="card-body">
           	        <div class="row">
                   	    <div class="col-md-1">
                   	        <img width="70" src="https://image.ibb.co/jw55Ex/def_face.jpg" class="img img-rounded img-fluid">
                   	    </div>
                   	    <div class="col-md-11">
                   	        <p><a href="https://maniruzzaman-akash.blogspot.com/p/contact.html"><strong>Maniruzzaman Akash</strong></a></p>
                   	        <p>테스트댓글글글</p>
                   	    </div>
           	        </div>
           	    </div>
            </div>
	    </div>
	</div>
</div>