<%@include file="../include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<script type="text/javascript" language="javascript">
		// 이메일
		function email_address_select(val){
			$("#email_address_input").val(val);
			$("#email_address_input").focus();
		}

		// 업체명 숨기기
		/*function company_tab_hide(){
			$("#join_con > .join_con > .contents_con .input_con > table > tbody > tr > .info_td .company_tab").hide();
			$("#join_con > .join_con > .contents_con .input_con > table > tbody > tr > .info_td .company_tab > tbody > tr > .info_td .input").val("");
		}

		// 업체명 보이기
		function company_tab_show(){
			$("#join_con > .join_con > .contents_con .input_con > table > tbody > tr > .info_td .company_tab").show();
			$("#join_con > .join_con > .contents_con .input_con > table > tbody > tr > .info_td .company_tab > tbody > tr > .info_td .input").val("");
		}*/
		
		function userCreate() {
			if (form.userId.value == "") {
				alert("사용자 ID를 입력하십시오.");
				form.userId.focus();
				return false;
			} 
			if (form.password.value == "") {
				alert("비밀번호를 입력하십시오.");
				form.password.focus();
				return false;
			}
			if (form.password.value != form.password2.value) {
				alert("비밀번호가 일치하지 않습니다.");
				form.name.focus();
				return false;
			}
			if (form.name.value == "") {
				alert("이름을 입력하십시오.");
				form.name.focus();
				return false;
			}
			
			form.submit();
		}

		function userList(targetUri) {
			form.action = targetUri;
			form.submit();
		}
</script>

	<style>
		#sub_con > .contents_con {width:100%; padding:0;}
	</style>

	<div id="container">
		<div id="sub_con">
			<div class="contents_con">
				
				<div id="join_con">
					<div class="join_con">
						<div class="contents_con">
							<form name="form" method="POST" action="<c:url value='/user/register' />">
								<div class="title_con">
									<img src="/UserMan2/images/member/join_title.png" alt="회원가입 타이틀" />
								</div>

								<!--  <div class="si_con">
									<table cellpadding="0" cellspacing="0">
										<tbody>
											<tr>
												<td align="center" class="title_td" width="134">
													<span>
														회원구분
													</span>
												</td>
												<td align="center" class="info_td" width="272">
													<label onclick="javascript:company_tab_hide();">
														<input type="radio" name="sort_type" checked="checked" />
														<span>
															게스트
														</span>
													</label>

													<label onclick="javascript:company_tab_show();">
														<input type="radio" name="sort_type" />
														<span>
															호스트
														</span>
													</label>
												</td>
												<td align="left" class="intro_td">
													<span>
														( <font class="dot">•</font> ) 기본정보 필수 입력사항 입니다.
													</span>
												</td>
											</tr>
										</tbody>
									</table>
								</div>-->

								<div class="input_con">
									<table cellpadding="0" cellspacing="0">
										<tbody>
											<tr>
												<td align="left" class="title_td">
													<span>
														<font class="dot">•</font> 아이디
													</span>
												</td>
												<td colspan="3" align="left" class="info_td">
													<input type="text" name="userId" class="input" style="width:268px; margin-right:6px;" />
													<!--  <a href="#" class="a_btn" style="margin-right:4px;">
														아이디중복확인
													</a>-->
													<span>
														(영문 대소문자/숫자 4자~16자)
													</span>
												</td>
											</tr>
											<tr>
												<td align="left" class="title_td">
													<span>
														<font class="dot">•</font> 비밀번호
													</span>
												</td>
												<td colspan="3" align="left" class="info_td">
													<input type="password" name="password" class="input" style="width:268px; margin-right:7px;" />
													<span>
														(영문 대소문자/숫자 4자~16자)
													</span>
												</td>
											</tr>
											<tr>
												<td align="left" class="title_td">
													<span>
														<font class="dot">•</font> 비밀번호 확인
													</span>
												</td>
												<td colspan="3" align="left" class="info_td">
													<input type="password" name="password2" class="input" style="width:268px;" />
												</td>
											</tr>
											<!--  <tr>
												<td align="left" class="title_td">
													<span>
														<font class="dot">•</font> 비밀번호 확인 질문
													</span>
												</td>
												<td colspan="3" align="left" class="info_td">
													<select name="" class="select" style="width:280px;">
														<option value="">선택하세요</option>
													</select>
												</td>
											</tr>
											<tr>
												<td align="left" class="title_td">
													<span>
														<font class="dot_off">•</font> 비밀번호 확인 답변
													</span>
												</td>
												<td colspan="3" align="left" class="info_td">
													<input type="text" name="" class="input" style="width:268px;" />
												</td>
											</tr>-->
											<tr>
												<td align="left" class="title_td">
													<span>
														<font class="dot">•</font> 이름
													</span>
												</td>
												<td colspan="3" align="left" class="info_td">
													<input type="text" name="name" class="input" style="width:268px;" 
													<c:if test="${registerFailed}">value="${user.name}"</c:if>>


													<!--  <table cellpadding="0" cellspacing="0" class="company_tab">
														<tbody>
															<tr>
																<td align="left" class="title_td" width="163">
																	<span>
																		<font class="dot">•</font> 업체명
																	</span>
																</td>
																<td align="left" class="info_td" width="367">
																	<input type="text" name="" class="input" style="width:268px;" />
																</td>
															</tr>
														</tbody>
													</table>-->

												</td>
											</tr>
											<!--<tr>
												<td align="left" class="title_td">
													<span>
														<font class="dot">•</font> 주소
													</span>
												</td>
												<td colspan="3" align="left" class="info_td">
													<table cellpadding="0" cellspacing="0">
														<tbody>
															<tr>
																<td align="left">
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
																<td align="center" width="8">&nbsp;</td>
																<td align="left">
																	<input type="text" name="" placeholder="(나머지주소)" class="input" style="width:688px;" />
																</td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>-->
											<tr>
												<!--  <td align="left" class="title_td" width="163">
													<span>
														<font class="dot">•</font> 유선전화
													</span>
												</td>
												<td align="left" class="info_td" width="368">
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
												</td>-->
												<td align="left" class="title_td" width="163">
													<span>
														<font class="dot">•</font> 핸드폰 번호
													</span>
												</td>
												<td align="left" class="info_td" width="367">
													<table cellpadding="0" cellspacing="0">
														<tbody>
															<tr>
																<!--<td align="left">
																	<select name="" class="select" style="width:84px;">
																		<option value="">선택</option>
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
																</td>-->
																<td align="left">
																	<input type="text" name="phone" maxlength="11" class="input" style="width:198px;" 
																	<c:if test="${registerFailed}">value="${user.phone}"</c:if>>
																</td>
																<!--<td align="center" width="20">
																	<span>
																		-
																	</span>
																</td>
																<td align="left">
																	<input type="tel" name="" maxlength="4" class="input" style="width:72px;" />
																</td>-->
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
											<tr>
												<td align="left" class="title_td">
													<span>
														<font class="dot">•</font> 이메일 주소
													</span>
												</td>
												<td colspan="3" align="left" class="info_td">
													<table cellpadding="0" cellspacing="0">
														<tbody>
															<tr>
																<td align="left">
																	<input type="text" name="email" value="" class="input" style="width:340px;"
																		<c:if test="${registerFailed}">value="${user.email}"</c:if>>
																</td>
																<!--  <td align="center" width="30">
																	<span>@</span>
																</td>
																<td width="180">
																	<input type="text" name="email_add" id="email_address_input" value="" class="input" style="width:158px;">
																</td>
																<td align="left">
																	<select onchange="email_address_select(this.value)" class="select" style="width:180px;">
																		<option value="">선택하세요</option>
																		<option value="gmail.com">gmail.com</option>
																		<option value="naver.com">naver.com</option>
																		<option value="daum.net">daum.net</option>
																		<option value="nate.com">nate.com</option>
																		<option value="hanmail.net">hanmail.net</option>
																		<option value="hotmail.com">hotmail.com</option>
																		<option value="yahoo.co.kr">yahoo.co.kr</option>
																		<option value="lycos.co.kr">lycos.co.kr</option>
																		<option value="">직접입력</option>
																	</select>
																</td>-->
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table>
								</div>

								<div class="btn_con">
								<!--  	<input type="submit" value="신청하기" class="input_btn" /> -->
									<input type="button" value="회원 가입" onClick="userCreate()" class="input_btn">
								</div>
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
<%@include file="../include/footer.jsp" %>