<%@include file="../include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<script>
	function writeComment(){
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
							<table>
							<tr><td>제목</td><td>${post.title}</td><td>${post.regdate}</td></tr>
							<tr><td>작성자</td><td>${post.userId }</td><td>조회수</td><td>${post.viewNum}</td></tr>
							</table>
							<br/><br/>
							<table>
							<tr><td>${post.content }</td></tr>
							<tr><td><br><br><br><br>댓글</td></tr>
							<c:forEach items="${comments }" var="item">
							<tr><td><b>${item.userId}</b></td><td>${item.regdate }</td></tr>
							<tr><td>${item.content }</td></tr>
							</c:forEach>
							<tr><td>
								<form action="<c:url value='/community/comment'><c:param name='currentPage' value='${currentPage }' /></c:url>">
									<input type="text" name="content"/>
									<input type="hidden" name="postId" value="${post.postId }"/>
									<input type="image" src="<c:url value='/images/sub/btn_reg.png'/>" alt="등록" class="input_btn" />
								</form>
							</td></tr>
							</table>
							<div class="btn_con">
										<a href="javascript:history.go(-1);" class="a_btn">
											<img src="<c:url value='/images/sub/notice_write_btn01.png'/>" alt="뒤로가기" />
										</a>
										<c:if test="${curUserId eq post.userId}">
											<a href="<c:url value='/community/update'>
												<c:param name='postId' value='${post.postId }'/>
												<c:param name='currentPage' value='${currentPage }'/>
											</c:url>">
											<img src="<c:url value='/images/sub/btn_update.png'/>" alt="수정"/>
											</a>
											<a href="<c:url value='/community/delete'>
													<c:param name='postId' value='${post.postId }'/>
													<c:param name='userId' value='${post.userId }'/>
													<c:param name='currentPage' value='${currentPage }'/>
												</c:url>">
											<img src="<c:url value='/images/sub/btn_delete.png'/>" alt="삭제"/>
											</a>
										</c:if>
							</div>
							
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

<%@include file="../include/footer.jsp" %>