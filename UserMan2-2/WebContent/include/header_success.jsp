<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	@SuppressWarnings("unchecked") 
	List<User> userList = (List<User>)request.getAttribute("userList");
	String curUserId = (String)request.getAttribute("curUserId");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>쉐어팜</title>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<link rel="stylesheet" type="text/css" href="/UserMan2/css/style.css" />
<link rel="stylesheet" type="text/css" href="/UserMan2/css/flexslider.css" />


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="/UserMan2/js/jquery.flexslider.js"></script>

<script type="text/javascript" language="javascript">
   // 얼럿창 메세지
   function alert_message(){
      if($("#alert_con").css("display") == "none") {
         $("#alert_con").show();
      }
      else {
         $("#alert_con").hide();
      }
   }
</script>

</head>
<body>
<div id="wrap">
   
   <div id="header">
      <div class="header">
         <div class="logo">
            <a href="/">
               <img src="/UserMan2/images/main/main_logo.png" alt="메인로고" />
            </a>
         </div>

         <div class="nav">
            <div class="nav01">
               <ul>
                  <li>
                     <a href="/UserMan2/intro/intro.jsp">
                        쉐어팜소개
                     </a>
                  </li>
                  <li>
                     <a href="<c:url value='/machine/list'/>">
                        쉐어팜임대
                     </a>
                  </li>
                  <li>
                     <a href="<c:url value='/farm/list'/>">
                        농장체험
                     </a>
                  </li>
                  <li>
                     <a href="#">
                        커뮤니티
                     </a>
                  </li>
               </ul>
            </div>

            <div class="nav02">
					<ul>
						<li>
                     <a href="<c:url value='/login/success'/>">
								홈으로
							</a>
						</li>
						<li>
							<a href="<c:url value='/user/logout' />">
							로그아웃
							</a>
						</li>
						<li>
							<a href="/UserMan2/member/registerForm.jsp">
								회원가입
							</a>
						</li>
						<li>
							<a href="/UserMan2/apply/farmList">
								농장 신청현황
							</a>
						</li>
						<li>
							<a href="/UserMan2/apply/machineList">
								농기계 신청현황
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>