<%@include file="../include/header_success.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%
  /*  List<Community> list = (List<Community>)request.getAttribute("list"); */
%>	
<script>
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

							<div id="notice_list_con">
								<div class="search_con">
									<table cellpadding="0" cellspacing="0">
										<tbody>
											<tr>
												<td align="left">
													<input type="text" name="" placeholder="해당 검색어 검색" class="input" />
												</td>
												<td align="center" width="18">
													<input type="image" src="<c:url value='/images/sub/notice_search_btn.png'/>" alt="게시판 검색 버튼" />
												</td>
											</tr>
										</tbody>
									</table>
								</div>

								<div class="normal_notice_con">
									<table cellpadding="0" cellspacing="0">
										<thead>
											<tr>
												<td align="center" width="123">
													<span>
														No
													</span>
												</td>
												<td align="center">
													<span>
														제목
													</span>
												</td>
												<td align="center" width="176">
													<span>
														작성자
													</span>
												</td>
												<td align="center" width="106">
													<span>
														조회수
													</span>
												</td>
												<td align="center" width="172">
													<span>
														등록일
													</span>
												</td>
											</tr>
										</thead>
										<tbody>
										<c:forEach var="item" items="${list}" varStatus="status">
											<tr>
												<td align="center">
													<span>
														${status.count}
													</span>
												</td>
												<td align="left" class="info_td">
													<a href="<c:url value='/community/detail'>
														<c:param name='postId' value='${item.postId}'/>
														<c:param name='currentPage' value='${currentPage}'/>
													</c:url>">
														<span class="notice_text">
															${item.title}
														</span>
													</a>
												</td>
												<td align="center">
													<span>
														${item.userId}
													</span>
												</td>
												<td align="center">
													<span>
														${item.viewNum}
													</span>
												</td>
												<td align="center">
													<span>
														${item.regdate}
													</span>
												</td>
											</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								
								<ul class="pagination">
									<c:if test="${currentPage ne '1'}">
										<li><a
											href="<c:url value='/community/list'>
												<c:param name='currentPage' value='${currentPage-1}'/>
											</c:url>">&laquo;</a></li>
									</c:if>
		
									<c:forEach begin="1"
										end="${totalPage+1}" var="idx">
										<li
											<c:out value="${currentPage == idx?'class =active':''}"/>>
											<a href="<c:url value='/community/list'>
												<c:param name='currentPage' value='${idx}'/>
											</c:url>">${idx}</a>
										</li>
									</c:forEach>
		
									<c:if test="${currentPage ne totalPage}">
										<li><a
											href="<c:url value='/community/list'>
												<c:param name='currentPage' value='${currentPage+1}'/>
											</c:url>">&raquo;</a></li>
									</c:if>
								</ul>
								
								<div class="btn_con">
									<a href="<c:url value='/community/write'/>">
										<img src="<c:url value='/images/sub/notice_write_btn.png'>
											<c:param name='currentPage' value='${currentPage}'/>
										</c:url>" alt="글쓰기"/>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<%@include file="../include/footer.jsp"%>