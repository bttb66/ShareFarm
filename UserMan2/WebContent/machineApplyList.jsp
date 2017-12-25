<%@include file="../include/header_success.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%
   @SuppressWarnings("unchecked") 
   List<Apply> appliedList = (List<Apply>)request.getAttribute("appliedList");//신청들어온거
   List<Apply> myApplyList = (List<Apply>)request.getAttribute("myApplyList");//내가 신청한거
   List<Apply> completeList = (List<Apply>)request.getAttribute("completeList");//완료된거

%>
<html>
<head>
<title>신청 현황</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link rel=stylesheet href="<c:url value='/css/user.css' />" type="text/css">
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0 font-size=80px>

<b>나의 신청현황</b>
<table border="1" font-size=80px]>
<tr>
   <th>상품 명</th>
   <th>시작일</th>
   <th>종료일</th>
   <th>승인여부</th>
</tr>
<c:forEach items="${myApplyList }" var="item">
<tr>
	<td>${item.name }</td>
	<td>${item.startDate }</td>
	<td>${item.endDate }</td>
	<td><c:choose>
		<c:when test="${item.accept eq '1' }">승인</c:when>
		<c:when test="${item.accept eq '-1' }">거절</c:when>
		<c:otherwise>대기중</c:otherwise>
	</c:choose></td>
</tr>
</c:forEach>
</table>
<br><br><br><br><br>
<b>들어온 신청</b>
<table border="1" font-size=80px]>
<tr>
   <th>기계 이름</th>
   <th>시작일</th>
   <th>종료일</th>
</tr>
<c:forEach items="${appliedList }" var="apply">
<tr>
   <td><a href="/UserMan2/machine/detail?machineId=${apply.machineId }">
   ${apply.name }</a></td>
   <td>${apply.startDate }</td>
   <td>${apply.endDate }</td>
   <td><a href="<c:url value='/apply/machineOk'>
		   	<c:param name='applyId' value='${apply.applyId }'/>
		   	<c:param name='kind' value='machine'/>
  		 </c:url>">
  		 <button id="ok">승인</button>
  		</a></td>
   
   <td><a href="<c:url value='/apply/machineCancel'>
   	<c:param name='applyId' value='${apply.applyId }'/>
   	<c:param name='kind' value='machine'/>
   </c:url>"><button id="cancel">거절</button></a></td>
   
</tr>
</c:forEach>
</table border="1"> 
<br><br><br><br>
<b>완료된 신청</b>
<table>
<tr>
   <th>기계 이름</th>
   <th>시작일</th>
   <th>종료일</th>
   <th>승인여부</th>
</tr>
<%
   if (completeList != null) {   
     Iterator<Apply> completeIter = completeList.iterator();
   
     //사용자 리스트를 클라이언트에게 보여주기 위하여 출력.
     while ( completeIter.hasNext() ) {
      Apply completeApply = (Apply)completeIter.next();
%> 
<tr>
   <td><%=completeApply.getName() %></td>
   <td><%=completeApply.getStartDate() %></td>
   <td><%=completeApply.getEndDate() %></td>
   <td><%if(completeApply.getAccept() == 1) {%>승인
   <%}else {%>거절
   <%}%></td>
   
</tr>
<%
     }
   }
%>
</table> 
<%@include file="../include/footer.jsp" %>