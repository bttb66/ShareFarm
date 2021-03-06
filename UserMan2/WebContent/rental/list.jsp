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
	List<Machine> list = (List<Machine>) request.getAttribute("machineList");
%>

<!-- 농기구 리스트 rental_sub01.html -->
<div id="container">
	<div id="sub_con">
		<div class="title_con rental_title_con">
			<img src="/UserMan2/images/rental/rental_title.png" alt="쉐어팜임대" />
		</div>

		<div id="nav">
			<div class="nav">
				<ul>
					<li><a href="<c:url value='/machine/list' />" class="on">
							농기구임대 </a></li>
					<li><a href="<c:url value='/machine/register' />" class="">
							등록하기 </a></li>
				</ul>
			</div>
		</div>

		<div class="contents_con">

			<div class="rental_sub01_list_con">
				<ul>
					<%
						if (list != null) {
							Iterator<Machine> machineIter = list.iterator();

							//사용자 리스트를 클라이언트에게 보여주기 위하여 출력.
							while (machineIter.hasNext()) {
								Machine machine = (Machine) machineIter.next();
					%>


					<li><a
						href="<c:url value='/machine/detail'>
								<c:param name='machineId' value='<%=String.valueOf(machine.getMachineId())%>'/>
							   </c:url>">
							<%--     <a href="/UserMan2/farm/detail?machineId=<%=machine.getMachineId() %>"> --%>

							<div class="list_div">
								<div class="img_con">
									<img src="/UserMan2/images/rental/rental_sub01_list_img01.png"
										alt="썸네일 이미지" width="351" height="203" />
								</div>

								<div class="text_con">
									<div class="title_con">
										<span> <%=machine.getMachineName()%>
										</span>
									</div>

									<div class="price_con">
										<span> <b>대여요금</b>(하루기준) : ￦<%=machine.getPrice()%>
										</span>
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
