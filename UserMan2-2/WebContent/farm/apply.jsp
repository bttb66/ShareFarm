<%@include file="../include/header_success.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%
   Farm farm = (Farm)request.getAttribute("farm");
   User host = (User)request.getAttribute("host");
%>   
   <script type="text/javascript" language="javascript">
      // 이메일
   function applyFarm() {
   if (form.startDate.value == "") {
      alert("시작일을 입력하십시오.");
      form.startDate.focus();
      return false;
   } 
   if (form.endDate.value == "") {
      alert("종료일을 입력하십시오.");
      form.endDate.focus();
      return false;
   }   
   
   form.submit();
}
   </script>

   <div id="container">
      <div id="sub_con">
         <div id="nav">
            <div class="nav">
               <ul>
                  <li>
                     <a href="/farm/list" class="on">
                        일일농장
                     </a>
                  </li>
                  <li>
                     <a href="/farm/register.jsp" class="">
                        등록하기
                     </a>
                  </li>
               </ul>
            </div>
         </div>

         <div class="contents_con">
            
            <form id="form" name="form" method="POST" action="/UserMan2/farm/apply?farmId=<%=String.valueOf(farm.getFarmId()) %>&farmName=<%=farm.getFarmName() %>">
               <div class="rental_sub01_write_con">
                  <div class="title_con">
                     <img src="/UserMan2/images/rental/rental_sub01_write_title.png" alt="신청하기" />
                  </div>

                  <div class="si_con">
                     <div class="intro_con">
                        <span>
                           ( <font class="dot">•</font> ) 기본정보 필수 입력사항 입니다.
                        </span>
                     </div>
                  </div>

                  <div class="write_con">
                     <div class="list_div">
                        <div class="title_con">
                           <img src="/UserMan2/images/rental/rental_sub01_write_sub_title01.png" alt="호스트 정보" />
                        </div>

                        <div class="input_con">
                           <table cellpadding="0" cellspacing="0">
                              <tbody>
                                 <tr>
                                    <td align="left" class="title_td" width="163">
                                       <span>
                                          <font class="dot_off">•</font> 신청하신 상품명
                                       </span>
                                    </td>
                                    <td align="left" class="info_td" width="368">
                                       <%=farm.getFarmName() %>
                                    </td>
                                    <td align="left" class="title_td" width="163">
                                       <span>
                                          <font class="dot_off">•</font> 호스트이름 / 업체명
                                       </span>
                                    </td>
                                    <%=host.getName() %>
                                 </tr>
                                 <tr>
                                    <td align="left" class="title_td">
                                       <span>
                                          <font class="dot_off">•</font> 업체 연락처
                                       </span>
                                    </td>
                                    <td colspan="3" align="left" class="info_td">
                                       <%=host.getPhone() %>
                                    </td>
                                 </tr>
                                 <tr>
                                    <td align="left" class="title_td">
                                       <span>
                                          <font class="dot_off">•</font> 지역
                                       </span>
                                    </td>
                                    <td colspan="3" align="left" class="info_td">
                                       <%=farm.getLocation() %>
                                    </td>
                                 </tr>
                              </tbody>
                           </table>
                        </div>
                     </div>

                     <div class="list_div">
                        <div class="title_con">
                           <img src="/UserMan2/images/rental/rental_sub01_write_sub_title02.png" alt="게스트 정보" />
                        </div>

                        <div class="input_con">
                           <table cellpadding="0" cellspacing="0">
                              <tbody>
                                 <tr>
                                    <td align="left" class="title_td">
                                       <span>
                                          <font class="dot">•</font> 시작 날짜
                                       </span>
                                    </td>
                                    <td colspan="3" align="left" class="info_td">
                                       <input type="text" id="startDate" name="startDate" class="input" style="width:336px;" />
                                       <span>
                                          (년(4자리)-월-일 형식으로 입력해주세요)
                                       </span>
                                    </td>
                                 </tr>
                                 <tr>
                                    <td align="left" class="title_td">
                                       <span>
                                          <font class="dot">•</font> 종료 날짜
                                       </span>
                                    </td>
                                    <td colspan="3" align="left" class="info_td">
                                       <input type="text" id="endDate" name="endDate" class="input" style="width:336px;" />
                                       <span>
                                          (년(4자리)-월-일 형식으로 입력해주세요)
                                       </span>
                                    </td>
                                 </tr>
                                 
                              </tbody>
                           <%--    <input type="hidden" id="farmId" value="${farm.farmId}">
                              <input type="hidden" id="farmName" value="${farm.farmName}"> --%>
                           </table>
                        </div>
                     </div>
                  </div>

                   <div class="btn_con">
                     <a href="javascript:history.go(-1);">
                        <img src="/UserMan2/images/rental/rental_sub01_write_btn01.png" alt="전단계로 이동" />
                     </a>

                     <input id="applyBtn" type="image" src="UserMan2/images/rental/rental_sub01_write_btn02.png" alt="등록하기"  onClick="applyFarm()">
                  </div>
               </div>
            </form>
            <!-- <div class="btn_con">
                     <a href="javascript:history.go(-1);">
                        <img src="/UserMan2/images/rental/rental_sub01_write_btn01.png" alt="전단계로 이동" />
                     </a>

                     <a href="javascript:alert_message();">
                        <input id="applyBtn" type="image" src="UserMan2/images/rental/rental_sub01_write_btn02.png" alt="등록하기" >
                     </a>
                  </div> -->
            <div id="alert_con">
               <div class="title_con">
                  <table cellpadding="0" cellspacing="0">
                     <tbody>
                        <tr>
                           <td align="left">
                              <span>
                                 웹 페이지 메세지
                              </span>
                           </td>
                           <td align="center" width="21">
                              <a href="javascript:alert_message();">
                                 <img src="/UserMan2/images/sub/alert_close_btn.png" alt="X" />
                              </a>
                           </td>
                        </tr>
                     </tbody>
                  </table>
               </div>

               <div class="contents_con">
                  <div class="intro_con">
                     <div class="img_con">
                        <img src="/UserMan2/images/rental/rental_sub01_write_alert_img.png" alt="얼럿창 이미지" />
                     </div>

                     <div class="text_con">
                        <span>
                           등록이 완료되었습니다. <br />
                           감사합니다.
                        </span>
                     </div>
                  </div>

                  <div class="btn_con">
                     <a href="#" class="a_btn">
                        확인
                     </a>
                  </div>
               </div>
            </div>

         </div>
      </div>
   </div>

<%@include file="../include/footer.jsp" %>