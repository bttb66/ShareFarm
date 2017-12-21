<%@include file="../include/header_success.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
   <!-- 기계 등록 rental_sub02.html-->
   <script>
   function machineCreate(){
	   if(form.name.value == ''){
           alert("상품명을 입력하십시오.");
           form.name.focus();
           return false;
        }
        if(form.detail.value == ''){
           alert("상세정보를 입력하십시오.");
           form.detail.focus();
           return false;
        }
        if(form.price.value == ''){
           alert("가격을 입력하십시오.");
           form.price.focus();
           return false;
        }
        if(form.location.value == ''){
           alert("주소를 입력하십시오.");
           form.location.focus();
           return false;
        }
        if(form.rentCount.value == ''){
           alert("보유대수를 입력하십시오.");
           form.rentCount.focus();
           return false;
        }
        // if(form.area.value == ''){
        //    alert("농작지 면적을 입력하십시오.");
        //    $('#area').focus();
        //    return false;
        // }
        form.submit();
   }
   
   </script>
   <div id="container">
      <div id="sub_con">
            <div class="title_con rental_title_con">
                    <img src="/UserMan2/images/rental/rental_title.png" alt="쉐어팜임대" />
                </div>
    
                <div id="nav">
                    <div class="nav">
                       <ul>
                          <li>
                             <a href="<c:url value='/machine/list' />" class="">
                                농기구임대
                             </a>
                          </li>
                          <li>
                               <a href="<c:url value='/machine/register' />" class="on">
                                   등록하기
                             </a>
                          </li>
                       </ul>
                    </div>
                 </div>

         <div class="contents_con">
            
            <form id="form" name="form" method="POST" action="<c:url value='/machine/register' />">
               <div class="rental_sub03_con">
                  <div class="title_con">
                     <img src="/UserMan2/images/rental/rental_sub03_title.png" alt="등록하기" />
                  </div>

     
                     <!--  <div class="intro_con">
                        <span>
                           ( <font class="dot">•</font> ) 기본정보 필수 입력사항 입니다.
                        </span>-->
                     </div>
                  </div>

                  <div class="input_con">
                     <table cellpadding="0" cellspacing="0">
                        <tbody>
                           <tr>
                              <td align="left" class="title_td">
                                 <span>
                                    <font class="dot">•</font> 상품명
                                 </span>
                              </td>
                              <td align="left" class="info_td" width="367">
                                 <input type="text" id="name" name="name" class="input" style="width:335px;" />
                              </td>
                           </tr>
                           <!-- <tr>
                              <td align="left" class="title_td">
                                 <span>
                                    <font class="dot">•</font> 비밀번호
                                 </span>
                              </td>
                              <td colspan="3" align="left" class="info_td">
                                 <input type="password" name="" class="input" style="width:268px; margin-right:10px;" />
                                 <span>
                                    (영문 대소문자/숫자 4자~16자)
                                 </span>
                              </td>
                           </tr> -->
                           <!-- <tr>
                              <td align="left" class="title_td">
                                 <span>
                                    <font class="dot">•</font> 연락처
                                 </span>
                              </td>
                              <td colspan="3" align="left" class="info_td">
                                 <table cellpadding="0" cellspacing="0">
                                    <tbody>
                                       <tr>
                                          <td align="left">
                                             <select name="" class="select" style="width:84px;">
                                                <option value="">선택</option>
                                                <option value="02">02</option>
                                                <option value="031">031</option>
                                                <option value="032">032</option>
                                                <option value="033">033</option>
                                                <option value="041">041</option>
                                                <option value="042">042</option>
                                                <option value="043">043</option>
                                                <option value="051">051</option>
                                                <option value="052">052</option>
                                                <option value="053">053</option>
                                                <option value="054">054</option>
                                                <option value="055">055</option>
                                                <option value="061">061</option>
                                                <option value="062">062</option>
                                                <option value="063">063</option>
                                                <option value="064">064</option>
                                                <option value="070">070</option>
                                                <option value="080">080</option>
                                                <option value="010">010</option>
                                                <option value="011">011</option>
                                                <option value="016">016</option>
                                                <option value="017">017</option>
                                                <option value="018">018</option>
                                                <option value="019">019</option>
                                             </select>
                                          </td>
                                          <td align="center" width="20">
                                             <span>
                                                -
                                             </span>
                                          </td>
                                          <td align="left">
                                             <input type="tel" name="" maxlength="4" class="input" style="width:72px;" />
                                          </td>
                                          <td align="center" width="20">
                                             <span>
                                                -
                                             </span>
                                          </td>
                                          <td align="left">
                                             <input type="tel" name="" maxlength="4" class="input" style="width:72px;" />
                                          </td>
                                       </tr>
                                    </tbody>
                                 </table>
                              </td>
                           </tr> -->
                           <!-- <tr>
                              <td align="left" class="title_td">
                                 <span>
                                    <font class="dot">•</font> 농작물
                                 </span>
                              </td>
                              <td colspan="3" align="left" class="info_td">
                                 <input type="text" id="farming" name="farming" class="input" style="width:268px; margin-right:10px;" />
                              </td>
                           </tr> -->
                           <tr>
                              <td align="left" class="title_td">
                                 <span>
                                    <font class="dot">•</font> 보유대수/보유면적
                                 </span>
                              </td>
                              <td colspan="3" align="left" class="info_td">
                                 <input type="text" id="rentCount" name="rentCount" class="input" style="width:268px; margin-right:10px;" />
                                 <span>
                                    (단위: 개수/평방미터)
                                 </span>
                              </td>
                           </tr>
                           <tr>
                              <td align="left" class="title_td">
                                 <span>
                                    <font class="dot">•</font> 요금
                                 </span>
                              </td>
                              <td colspan="3" align="left" class="info_td">
                                 <input type="text" id="price" name="price" class="input" style="width:268px; margin-right:10px;" />
                                 <span>
                                    (1일 기준)
                                 </span>
                              </td>
                           </tr>
                        <!--    <tr>
                              <td align="left" class="title_td">
                                 <span>
                                    <font class="dot">•</font> 모집정원 수
                                 </span>
                              </td>
                              <td colspan="3" align="left" class="info_td">
                                 <input type="text" name="" class="input" style="width:58px; " />
                              </td>
                           </tr> -->
                           <tr>
                              <td align="left" class="title_td">
                                 <span>
                                    <font class="dot_off">•</font> 지역
                                 </span>
                              </td>
                              <td colspan="3" align="left" class="info_td">
                                 <table cellpadding="0" cellspacing="0">
                                    <tbody>
                                       <tr>
                                          <!-- <td align="left">
                                             <select name="" class="select" style="width:84px;">
                                                <option value="">선택</option>
                                             </select>
                                          </td>
                                          <td align="center" width="8">&nbsp;</td>
                                          <td align="left">
                                             <select name="" class="select" style="width:84px;">
                                                <option value="">선택</option>
                                             </select>
                                          </td>
                                          <td align="center" width="8">&nbsp;</td> -->
                                          <td align="left">
                                             <input type="text" id="location" name="location" placeholder="(주소)" class="input" style="width:688px;" />
                                          </td>
                                       </tr>
                                    </tbody>
                                 </table>
                              </td>
                           </tr>
                           <tr>
                              <td align="left" class="title_td">
                                 <span>
                                    <font class="dot">•</font> 상세설명
                                 </span>
                              </td>
                              <td colspan="3" align="left" class="info_td">
                                 <textarea id="detail" name="detail" placeholder="(게스트에게 하고싶은 메세지를 작성해주세요.)" class="textarea"></textarea>
                              </td>
                           </tr>
                           <!-- <tr>
                              <td align="left" class="title_td">
                                 <span>
                                    <font class="dot">•</font> 사진 올리기 (*4장)
                                 </span>
                              </td>
                              <td colspan="3" align="left" class="info_td">
                                 <div class="upload_con">
                                    <ul>
                                       <li>
                                          <div class="list_div">
                                             <div class="img_con">
                                                <img src="" onerror="this.src='/UserMan2/images/rental/rental_sub03_upload_none_img.png'" id="preview_file_input01"  alt="프로필 사진" width="180" height="103">
                                                <input type="hidden" id="image_profile_view_input01" class="input" readonly="readonly" />
                                             </div>

                                             <div class="btn_con">
                                                <label for="file-input01" class="label_btn">
                                                   <input id="file-input01" name="upfile" type="file" class="file_input" accept="file_extension|image/*|media_type" onchange="image_profile_input01(this.value); fn_previewImg01(this, 'preview_file_input01');" />
                                                   <span>업로드</span>
                                                </label>

                                                <a href="javascript:delete_image_profile01();" class="a_btn">
                                                   취소
                                                </a>
                                             </div>
                                          </div>
                                       </li>
                                       <li>
                                          <div class="list_div">
                                             <div class="img_con">
                                                <img src="" onerror="this.src='/UserMan2/images/rental/rental_sub03_upload_none_img.png'" id="preview_file_input02"  alt="프로필 사진" width="180" height="103">
                                                <input type="hidden" id="image_profile_view_input02" class="input" readonly="readonly" />
                                             </div>

                                             <div class="btn_con">
                                                <label for="file-input02" class="label_btn">
                                                   <input id="file-input02" name="upfile" type="file" class="file_input" accept="file_extension|image/*|media_type" onchange="image_profile_input02(this.value); fn_previewImg02(this, 'preview_file_input02');" />
                                                   <span>업로드</span>
                                                </label>

                                                <a href="javascript:delete_image_profile02();" class="a_btn">
                                                   취소
                                                </a>
                                             </div>
                                          </div>
                                       </li>
                                       <li>
                                          <div class="list_div">
                                             <div class="img_con">
                                                <img src="" onerror="this.src='/UserMan2/images/rental/rental_sub03_upload_none_img.png'" id="preview_file_input03"  alt="프로필 사진" width="180" height="103">
                                                <input type="hidden" id="image_profile_view_input03" class="input" readonly="readonly" />
                                             </div>

                                             <div class="btn_con">
                                                <label for="file-input03" class="label_btn">
                                                   <input id="file-input03" name="upfile" type="file" class="file_input" accept="file_extension|image/*|media_type" onchange="image_profile_input03(this.value); fn_previewImg03(this, 'preview_file_input03');" />
                                                   <span>업로드</span>
                                                </label>

                                                <a href="javascript:delete_image_profile03();" class="a_btn">
                                                   취소
                                                </a>
                                             </div>
                                          </div>
                                       </li>
                                       <li>
                                          <div class="list_div">
                                             <div class="img_con">
                                                <img src="" onerror="this.src='/UserMan2/images/rental/rental_sub03_upload_none_img.png'" id="preview_file_input04"  alt="프로필 사진" width="180" height="103">
                                                <input type="hidden" id="image_profile_view_input04" class="input" readonly="readonly" />
                                             </div>

                                             <div class="btn_con">
                                                <label for="file-input04" class="label_btn">
                                                   <input id="file-input04" name="upfile" type="file" class="file_input" accept="file_extension|image/*|media_type" onchange="image_profile_input04(this.value); fn_previewImg04(this, 'preview_file_input04');" />
                                                   <span>업로드</span>
                                                </label>

                                                <a href="javascript:delete_image_profile04();" class="a_btn">
                                                   취소
                                                </a>
                                             </div>
                                          </div>
                                       </li>
                                    </ul>
                                 </div>

                              </td>
                           </tr>-->
                        </tbody>
                     </table>
                  </div>

                  <div class="btn_con">
                        <!-- <input type="image" src="/UserMan2/images/rental/rental_sub03_btn.png" alt="제출하기" 
                        onclick="farmRegist()"> -->
                     <input type="button" value="제출하기" onClick="machineCreate()" class="input_btn">
                     
                  </div>
               </div>
            </form>
                  <!--<div class="btn_con">
                      <a href="javascript:alert_message();">
                        <input id="regBtn" type="image" src="/UserMan2/images/rental/rental_sub03_btn.png" alt="제출하기" >
                     </a> -->
                  </div>
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

   <script type="text/javascript" language="javascript">
      // 사진01
      
      
      function image_profile_input01(val){
         $("#image_profile_view_input01").val(val);
         $("#image_profile_view_input01").focus();
      }
      
      // 사진01
      function fn_previewImg01(input, preImg) {
         // param : input - 파일업로드 input 객체 change 이벤트에서 this 로 받아온다
         // preImg - 미리보기 이미지를 보여줄 img 태그  ID 
         if ($(input).val()!="") {
            //확장자 확인
            var ext = $(input).val().split('.').pop().toLowerCase();
            if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
               alert('gif,png,jpg,jpeg 파일만 업로드 할수 있습니다.');
               return;
            }
                 
            if ( window.FileReader ) {
                /*IE 9 이상에서는 FileReader  이용*/
               var reader = new FileReader();
                  reader.onload = function (e) {
                     $('#'+preImg).attr('src', e.target.result); 
                  };
                  reader.readAsDataURL(input.files[0]);
                  return input.files[0].name;  // 파일명 return
            } else {
                /* IE8 전용 이미지 미리보기 */ 
               input.select();
               var src = document.selection.createRange().text;
               $('#'+preImg).attr('src', src);  
               var n = src.substring(src.lastIndexOf('\\') + 1);
               return n; // 파일명 return
            }
         }
      }

      // 사진01
      function delete_image_profile01() {
         $("#preview_file_input01").attr("src","");   
      }

      // 사진02
      function image_profile_input02(val){
         $("#image_profile_view_input02").val(val);
         $("#image_profile_view_input02").focus();
      }
      
      // 사진02
      function fn_previewImg02(input, preImg) {
         // param : input - 파일업로드 input 객체 change 이벤트에서 this 로 받아온다
         // preImg - 미리보기 이미지를 보여줄 img 태그  ID 
         if ($(input).val()!="") {
            //확장자 확인
            var ext = $(input).val().split('.').pop().toLowerCase();
            if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
               alert('gif,png,jpg,jpeg 파일만 업로드 할수 있습니다.');
               return;
            }
                 
            if ( window.FileReader ) {
                /*IE 9 이상에서는 FileReader  이용*/
               var reader = new FileReader();
                  reader.onload = function (e) {
                     $('#'+preImg).attr('src', e.target.result); 
                  };
                  reader.readAsDataURL(input.files[0]);
                  return input.files[0].name;  // 파일명 return
            } else {
                /* IE8 전용 이미지 미리보기 */ 
               input.select();
               var src = document.selection.createRange().text;
               $('#'+preImg).attr('src', src);  
               var n = src.substring(src.lastIndexOf('\\') + 1);
               return n; // 파일명 return
            }
         }
      }

      // 사진02
      function delete_image_profile02() {
         $("#preview_file_input02").attr("src","");   
      }

      // 사진03
      function image_profile_input03(val){
         $("#image_profile_view_input03").val(val);
         $("#image_profile_view_input03").focus();
      }
      
      // 사진03
      function fn_previewImg03(input, preImg) {
         // param : input - 파일업로드 input 객체 change 이벤트에서 this 로 받아온다
         // preImg - 미리보기 이미지를 보여줄 img 태그  ID 
         if ($(input).val()!="") {
            //확장자 확인
            var ext = $(input).val().split('.').pop().toLowerCase();
            if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
               alert('gif,png,jpg,jpeg 파일만 업로드 할수 있습니다.');
               return;
            }
                 
            if ( window.FileReader ) {
                /*IE 9 이상에서는 FileReader  이용*/
               var reader = new FileReader();
                  reader.onload = function (e) {
                     $('#'+preImg).attr('src', e.target.result); 
                  };
                  reader.readAsDataURL(input.files[0]);
                  return input.files[0].name;  // 파일명 return
            } else {
                /* IE8 전용 이미지 미리보기 */ 
               input.select();
               var src = document.selection.createRange().text;
               $('#'+preImg).attr('src', src);  
               var n = src.substring(src.lastIndexOf('\\') + 1);
               return n; // 파일명 return
            }
         }
      }

      // 사진03
      function delete_image_profile03() {
         $("#preview_file_input03").attr("src","");   
      }

      // 사진04
      function image_profile_input04(val){
         $("#image_profile_view_input04").val(val);
         $("#image_profile_view_input04").focus();
      }
      
      // 사진04
      function fn_previewImg04(input, preImg) {
         // param : input - 파일업로드 input 객체 change 이벤트에서 this 로 받아온다
         // preImg - 미리보기 이미지를 보여줄 img 태그  ID 
         if ($(input).val()!="") {
            //확장자 확인
            var ext = $(input).val().split('.').pop().toLowerCase();
            if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
               alert('gif,png,jpg,jpeg 파일만 업로드 할수 있습니다.');
               return;
            }
                 
            if ( window.FileReader ) {
                /*IE 9 이상에서는 FileReader  이용*/
               var reader = new FileReader();
                  reader.onload = function (e) {
                     $('#'+preImg).attr('src', e.target.result); 
                  };
                  reader.readAsDataURL(input.files[0]);
                  return input.files[0].name;  // 파일명 return
            } else {
                /* IE8 전용 이미지 미리보기 */ 
               input.select();
               var src = document.selection.createRange().text;
               $('#'+preImg).attr('src', src);  
               var n = src.substring(src.lastIndexOf('\\') + 1);
               return n; // 파일명 return
            }
         }
      }

      // 사진04
      function delete_image_profile04() {
         $("#preview_file_input04").attr("src","");   
      }
   </script>
<%@include file="../include/footer.jsp" %>