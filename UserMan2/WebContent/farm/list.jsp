<%@include file="../include/header_success.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%
	List<Farm> list = (List<Farm>) request.getAttribute("farmList");
%>
<!-- 농장 리스트farm_sub01.html -->
<div id="container">
	<div id="sub_con">
		<div class="title_con farm_title_con">
			<img src="/UserMan2/images/farm/farm_title.png" alt="농장체험" />
		</div>

		<div id="nav">
			<div class="nav">
				<ul>
					<li><a href="<c:url value='/farm/list' />" class="on">
							일일농장 </a></li>
					<li><a href="<c:url value='/farm/register' />" class="">
							등록하기 </a></li>
				</ul>
			</div>
		</div>

		<div class="contents_con">

			<div class="rental_sub01_list_con">
				<ul>
					<%
						if (list != null) {
							Iterator<Farm> farmIter = list.iterator();

							//사용자 리스트를 클라이언트에게 보여주기 위하여 출력.
							while (farmIter.hasNext()) {
								Farm farm = (Farm) farmIter.next();
					%>


					<li><a
						href="<c:url value='/farm/detail'>
                        <c:param name='farmId' value='<%=String.valueOf(farm.getFarmId())%>'/>
                       </c:url>">
							<%--     <a href="/UserMan2/farm/detail?farmId=<%=farm.getFarmId() %>"> --%>
							<div class="list_div">
								<div class="img_con">
									<!--    <img src=<%=farm.getFarmImgUrl()%> alt="썸네일 이미지" width="351" height="203" />-->

									<img src="/UserMan2/images/farm/farm_sub01_list_img01.png"
										alt="썸네일 이미지" width="351" height="203" />
								</div>

								<div class="text_con">
									<div class="title_con">
										<span> <%=farm.getFarmName()%>
										</span>
									</div>

									<div class="info_con">
										<ul>
											<li><span> <b>체험요금</b>(하루기준) : ￦<%=farm.getPrice()%>
											</span></li>
											<li><span> <b>지역</b> : <%=farm.getLocation()%>
											</span></li>
										</ul>
									</div>
								</div>
							</div>
					</a></li>
					<%
						}
						}
					%>
				</ul>
			</div>

		</div>
	</div>
</div>
<%@include file="../include/footer.jsp"%>