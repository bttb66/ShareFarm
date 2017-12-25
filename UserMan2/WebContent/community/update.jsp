<%@include file="../include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<% Community post = (Community)request.getAttribute("post");%>
<script>
jQuery.noConflict();
jQuery(document).ready(function($){
	$('#title').val('<%=post.getTitle()%>');
	$('#content').val('<%=post.getContent()%>');
});
	function writePost(){
		if(form.title.value == ""){
			alert("제목을 입력하십시오");
			form.title.focus();
		}
		if(form.content.value == ""){
			alert("내용을 입력하십시오");
			form.content.focus();
		}
		form.submit();
	}
</script>
	
	<style>
		#sub_con > .contents_con {width:100%; padding:0;}
	</style>

	<div id="container">
		<div id="sub_con">
			<div class="contents_con">
				
				<div id="notice_con">
					<div class="notice_con">
						<div class="contents_con">
							<div class="title_con">
								<img src="<c:url value='/images/community/community_sub01_title.png'/>" alt="커뮤니티 타이틀" />
							</div>

							<form id="form" name="form" method="POST" action="<c:url value='/community/update'/>">
							<input type="hidden" name="postId" value="${post.postId}"/>
							<input type="hidden" name="currentPage" value="${currentPage}"/>
								<div id="notice_write_con">
									<div class="input_con">
										<ul>
											<li>
												<input type="text" name="title" id="title" class="input" />
											</li>
											<li>
												<textarea name="content" id="content" class="textarea"></textarea>
											</li>
										</ul>
									</div>

									<div class="btn_con">
										<a href="javascript:history.go(-1);" class="a_btn">
											<img src="<c:url value='/images/sub/notice_write_btn01.png'/>" alt="취소" />
										</a>
										<input type="image" src="<c:url value='/images/sub/notice_write_btn02.png'/>" alt="등록하기" class="input_btn" />
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

<%@include file="../include/footer.jsp" %>