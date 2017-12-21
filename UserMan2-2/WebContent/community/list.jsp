<%@include file="../include/header_success.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%
   List<Community> list = (List<Community>)request.getAttribute("userList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	 <a href="<c:url value='/community/write' />" class="">
                        	등록하기
     </a>
	<table>
	<%
               if (list != null) {   
                 Iterator<Community> CommIter = list.iterator();
               
                 //사용자 리스트를 클라이언트에게 보여주기 위하여 출력.
                 while ( CommIter.hasNext() ) {
                  Community comm = (Community)CommIter.next();
     %>   
		<tr>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		<tr>
		<!-- Community comm = new Community(		// User �뜝�룞�삕泥닷뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�떦�슱�삕 �뜝�떩�궪�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕
							rs.getInt("postId"),
							rs.getString("content"),
							rs.getString("title"),
							rs.getString("userId"),
							rs.getInt("veiwNum"),
							rs.getDate("regDate")); -->
			<td><%=comm.getTitle() %></td>
			<td><%=comm.getTitle() %></td>
			<td><%=comm.getTitle() %></td>
			<td><%=comm.getTitle() %></td>
			<td><%=comm.getTitle() %></td>
		</tr>
		<%
                       }
                     }
                  %>
	</table>
	<%@include file="../include/footer.jsp" %>
</body>
</html>