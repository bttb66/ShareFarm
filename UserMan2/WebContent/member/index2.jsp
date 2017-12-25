<%@include file="../include/header_success.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
   <script type="text/javascript" language="javascript">
   jQuery.noConflict();
      jQuery(document).ready(function($){
         // 메인 슬라이드 
         $('.main_slide').flexslider({
            animation: "fade",
            animationLoop: true,      
            slideshow: true,        
            slideshowSpeed: 4000,
            animationSpeed: 1500,   
            directionNav: false,
            controlNav: false,
            touch: false,
         });
      });
   </script>

   <div id="container">
      <div id="main_con">
         <div class="slide_con">
            <div class="flexslider main_slide">
               <div class="text_con">
                  <div class="text_con">
                     <img src="/UserMan2/images/main/main_slide_text.png" alt="" />
                  </div>

                  <div class="btn_con">
                     <a href="#">
                        <img src="/UserMan2/images/main/main_slide_btn.png" alt="" />
                     </a>
                  </div>
               </div>

               <ul class="slides">
                  <li style="background-image:url('/UserMan2/images/main/main_slide01.png');"></li>
                  <li style="background-image:url('/UserMan2/images/main/main_slide01.png');"></li>
                  <li style="background-image:url('/UserMan2/images/main/main_slide01.png');"></li>
               </ul>
               
               <div class="nav">
                  <ul>
                     <li>
                        <a href="<c:url value='/machine/list'/>">
                           <img src="/UserMan2/images/main/main_con_nav_list01.png" alt="농기계 임대 / 등록" />
                           <img src="/UserMan2/images/main/main_con_nav_list_over_off.png" alt="오버 오프 이미지" class="over off" />
                           <img src="/UserMan2/images/main/main_con_nav_list_over_on.png" alt="오버 온 이미지" class="over on" />
                        </a>
                     </li>
                     <!--<li>
                        <a href="#">
                           <img src="/UserMan2/images/main/main_con_nav_list02.png" alt="농작지 임대 / 등록" />
                           <img src="/UserMan2/images/main/main_con_nav_list_over_off.png" alt="오버 오프 이미지" class="over off" />
                           <img src="/UserMan2/images/main/main_con_nav_list_over_on.png" alt="오버 온 이미지" class="over on" />
                        </a>
                     </li>-->
                     <li>
                     <a href="<c:url value='/farm/list'/>">
                           <img src="/UserMan2/images/main/main_con_nav_list03.png" alt="일일농장신청 / 등록" />
                           <img src="/UserMan2/images/main/main_con_nav_list_over_off.png" alt="오버 오프 이미지" class="over off" />
                           <img src="/UserMan2/images/main/main_con_nav_list_over_on.png" alt="오버 온 이미지" class="over on" />
                        </a>
                     </li>
                     <li>
                        <a href="#">
                           <img src="/UserMan2/images/main/main_con_nav_list04.png" alt="커뮤니티 바로가기" />
                           <img src="/UserMan2/images/main/main_con_nav_list_over_off.png" alt="오버 오프 이미지" class="over off" />
                           <img src="/UserMan2/images/main/main_con_nav_list_over_on.png" alt="오버 온 이미지" class="over on" />
                        </a>
                     </li>
                  </ul>
               </div>
               
            </div>
         </div>
      </div>
   </div>
   
<%@include file="../include/footer.jsp" %>