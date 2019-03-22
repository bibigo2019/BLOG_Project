<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                     </div><!-- .entry-meta -->
                   </header><!-- .entry-header -->

                   <div class="entry-content">
                     <p>${ post.content }</p>
                   </div><!-- .entry-content -->
                 </article><!-- .post -->
               </div>
		</div>
	</div>
</div>

