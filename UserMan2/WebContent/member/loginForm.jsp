<%@include file="../include/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<style>
		#sub_con > .contents_con {width:100%; padding:0;}
</style>
<script>
function login() {
	if (form.userId.value == "") {
		alert("사용자 ID를 입력하십시오.");
		form.userId.focus();
		return false;
	} 
	if (form.passwd.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.passwd.focus();
		return false;
	}		
	form.submit();
}
</script>

	<div id="container">
		<div id="sub_con">
			<div class="contents_con">
				
				<div id="login_con">
					<div class="login_con">
						<div class="contents_con">
							<div class="title_con">
								<img src="/UserMan2/images/member/login_title.png" alt="로그인 타이틀" />
							</div>

							<div class="input_con">
								<form name="form" method="POST" action="<c:url value='/user/login' />">
									<table cellpadding="0" cellspacing="0">
										<tbody>
											<tr>
												<td align="left">
													<input type="text" name="userId" placeholder="아이디" class="input id_input" />
												</td>
											</tr>
											<tr>
												<td height="14"></td>
											</tr>
											<tr>
												<td align="left">
													<input type="password" name="passwd" placeholder="비밀번호" class="input pw_input" />
												</td>
											</tr>
											<tr>
												<td height="27"></td>
											</tr>
											<tr>
												<td align="left">
													<input type="button" value="로그인" class="input_btn" onClick="login()">
											<!--	<input type="submit" value="로그인" class="input_btn" />
												</td>
											</tr>
											<tr>
												<td height="15"></td>
											</tr>
										  	<tr>
												<td align="left">
													<label>
														<input type="checkbox" name="" />
														<span>
															로그인 상태 유지
														</span>
													</label>
												</td>
											</tr>-->
										</tbody>
									</table>
								</form>
							</div>

							<!--<div class="member_con">
							 	<a href="#">
									아이디 찾기
								</a>
								<span class="bar">│</span>
								<a href="#">
									비밀번호찾기
								</a>
								<span class="bar">│</span>
								
			<input type="button" value="회원가입" style="text-align:center; font-size:30px; color:black; vertical-align:middle;"; onClick="userCreate('<c:url value='/user/register/form' />')">
							  	<a href="/member/registerForm.jsp">
									회원가입
								</a>
							</div>-->
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
<%@include file="../include/footer.jsp" %>