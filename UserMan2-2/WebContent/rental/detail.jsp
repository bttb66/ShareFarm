<%@include file="../include/header_success.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<% 
   Machine machine = (Machine)request.getAttribute("machine");
   User host = (User)request.getAttribute("host");
   request.setAttribute("machine", machine);
   request.setAttribute("host", host);
   %>
	
	<script type="text/javascript" language="javascript">
		var idx_head = 0;
		var idx_tail = null;
		
		$(document).ready(function(){
			$("#slide_num1").css("display", "block");
			$("#slide_num1 .slide_mini li span .text_con").eq(0).css("display","none");
			viewport_width();
		});
		
		function viewport_width($target){
			// viewport ul �꼫鍮� �옟湲�
			$(".slide_viewport ul.sel").each(function(){
				var item_num = $(this).find("li").length;
				var item_wid = 550;
				$(this).css("width", item_num * item_wid);
			});
		}
		
		function slide_btn($this){
			var dir			= parseInt($this.attr("rel"));
			var $target		= $this.parent().parent();
			var item_width	= parseInt($target.find(".sel li").width());
			
			idx_tail = $target.find(".sel li").length - 1;
			
			idx_head += dir;
			
			if(idx_head < 0)				idx_head = idx_tail;
			else if(idx_head > idx_tail)	idx_head = 0;
			
			$target.find(".sel").stop().animate({"margin-left":-item_width * idx_head}, 500);
			
			// mini_slide
			var mini_idx	= idx_head - 3 >= 0 ? idx_head - 3 : 0;
			var mini_width	= $("#slide_num1 .slide_mini .sel li").outerWidth() + 9;

			$target.parent().find(".slide_mini .sel").stop().animate({"margin-left":-mini_width * mini_idx}, 500);
			$target.parent().find(".slide_mini .sel li span .text_con").css("display","block").eq(idx_head).css("display","none");
		}
		
		function slide_mini_btn($this, n){
			var $mini_ul	= $this.parent().parent().parent();
			var group		= parseInt($mini_ul.attr("rel"));
			
			if($this.css("margin-top") != "0"){
				$mini_ul.find("img").css("margin-top", 0);
				$this.css("margin-top", 0);
				
				idx_head = n - 1;
				slide_btn($mini_ul.parent().parent().find(".next"));
			}
		}
	</script>
	
	<style>
		.slide {width:550px; margin:auto;}
		.slide_viewport {position:relative; top:0px; left:0px; width:550px; height:378px; margin:0 auto; margin-bottom:50px; overflow:hidden;}
		.slide_viewport ul {display:none; list-style:none; padding:0px; margin:0px; *zoom:1;}
		.slide_viewport ul:after {content:""; display:block; clear:both;}
		.slide_viewport ul.sel {display:block;}
		.slide_viewport ul.sel li {float:left;}

		.slide_viewport ul.sel li {float:left; width:550px; height:378px; position:relative; top:0px; left:0px;}

		.slide .slide_btn {position:absolute; z-index:999; top:182px; width:100%; display:block;}
		.slide .slide_btn .prev {position:absolute; top:0; left:-23px; z-index:9; cursor:pointer;}
		.slide .slide_btn .next {position:absolute; top:0; right:-23px; z-index:9; cursor:pointer;}
		
		.slide [id^=slide_num] {display:none; position:relative;}
		
		.slide_mini {position:relative; overflow:hidden; width:550px; height:110px;}
		.slide_mini ul {width:2000%; display:none; list-style:none; padding:0px; margin:0px; *zoom:1;}
		.slide_mini ul:after {content:""; display:block; clear:both;}
		.slide_mini ul.sel {display:block;}
		.slide_mini li {float:left; width:170px; height:110px; margin-right:20px; cursor:pointer;}
		.slide_mini li span {display:block; width:170px; height:110px; text-align:center; position:relative; top:0px; left:0px;}
		.slide_mini li span .text_con {width:170px; height:110px; background-color:#000000; opacity:0.5; position:absolute; top:0px; left:0px; display:block;}
		.slide_mini li span .sel {display:none;}
	</style>

	<div id="container">
		<div id="sub_con">
			
			<div class="title_con rental_title_con">
					<img src="/UserMan2/images/rental/rental_title.png" alt="쉐어팜임대" />
			</div>

			<div id="nav">
				<div class="nav">
					<ul>
						<li>
							<a href="<c:url value='/machine/list' />" class="on">
							<!-- <a href="/machine/list" class="on"> -->
							농기구임대
							</a>
						</li>
						<li>
							<a href="<c:url value='/machine/register' />" class="">
							<!-- <a href="/machine/register.jsp"" class=""> -->
								등록하기
							</a>
						</li>
					</ul>
				</div>
			</div>
			
			<div class="contents_con">
				
				<div class="rental_sub01_view_con">
					<div class="left_con">
						<div class="slide">
							<div class="slide_wrap" id="slide_num1">
								<div>
									<div class="slide_viewport">
										<ul class="sel">
											<li>
												<img src="/UserMan2/images/rental/rental_sub01_view_slide01.png" alt="" width="550" height="378" />
											</li>
											<li>
												<img src="/UserMan2/images/rental/rental_sub01_view_slide02.png" alt="" width="550" height="378" />
											</li>
											<li>
												<img src="/UserMan2/images/rental/rental_sub01_view_slide03.png" alt="" width="550" height="378" />
											</li>
											<li>
												<img src="/UserMan2/images/rental/rental_sub01_view_slide01.png" alt="" width="550" height="378" />
											</li>
											<li>
												<img src="/UserMan2/images/rental/rental_sub01_view_slide02.png" alt="" width="550" height="378" />
											</li>
										</ul>
									</div>

									<span class="slide_btn">
										<img class="prev" rel="-1" onclick="slide_btn($(this))" src="/UserMan2/images/rental/rental_sub01_view_slide_prev_btn.png" alt="�씠�쟾蹂닿린">
										<img class="next" rel="+1" onclick="slide_btn($(this))" src="/UserMan2/images/rental/rental_sub01_view_slide_next_btn.png" alt="�떎�쓬蹂닿린">
									</span>
								</div>
								<div class="slide_mini">
									<ul rel="0" class="sel">
										<li onclick="slide_mini_btn($(this), 0)">
											<span>
												<img src="/UserMan2/images/rental/rental_sub01_view_slide01.png" alt="" width="170" height="110" />
												<div class="text_con"></div>
											</span>
										</li>
										<li onclick="slide_mini_btn($(this), 1)">
											<span>
												<img src="/UserMan2/images/rental/rental_sub01_view_slide02.png" alt="" width="170" height="110" />
												<div class="text_con"></div>
											</span>
										</li>
										<li onclick="slide_mini_btn($(this), 2)">
											<span>
												<img src="/UserMan2/images/rental/rental_sub01_view_slide03.png" alt="" width="170" height="110" />
												<div class="text_con"></div>
											</span>
										</li>
										<li onclick="slide_mini_btn($(this), 3)">
											<span>
												<img src="/UserMan2/images/rental/rental_sub01_view_slide01.png" alt="" width="170" height="110" />
												<div class="text_con"></div>
											</span>
										</li>
										<li onclick="slide_mini_btn($(this), 4)">
											<span>
												<img src="/UserMan2/images/rental/rental_sub01_view_slide02.png" alt="" width="170" height="110" />
												<div class="text_con"></div>
											</span>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>

					<div class="right_con">
						<div class="title_con">
							<span>
								<%=machine.getMachineName() %>
							</span>
						</div>

						<div class="btn_con">
							 <!--<a href="javascript:alert_message();">-->
							<a href="<c:url value='/machine/apply'>
								<c:param name='machineId' value='<%=String.valueOf(machine.getMachineId())%>'/>
								</c:url>">
								<img src="/UserMan2/images/rental/rental_sub01_view_btn.png" alt="신청하기" />
							</a>
						</div>

						<div class="info_con">
							<table cellpadding="0" cellspacing="0">
								<tbody>
									<tr>
										<td colspan="2" align="center" class="img_td">
											<img src="/UserMan2/images/rental/rental_sub01_view_person_img.png" alt="�벑濡앹옄 �씠誘몄�" width="272" height="160" />
											<img src="/UserMan2/images/rental/rental_sub01_view_img_end.png" alt="嫄곕옒�셿猷�" width="272" height="160" class="end_img" />
										</td>
									</tr>
									<tr>
										<td align="center" class="title_td" width="111">
											<span>
												호스트이름
											</span>
										</td>
										<td align="left" class="info_td" width="156">
											<span>
												<%=host.getName() %>
											</span>
										</td>
									</tr>
									<tr>
										<td align="center" class="title_td">
											<span>
												연락처
											</span>
										</td>
										<td align="left" class="info_td">
											<span>
												<%=host.getPhone() %>
											</span>
										</td>
									</tr>
									<tr>
										<td align="center" class="title_td">
											<span>
												지역
											</span>
										</td>
										<td align="left" class="info_td">
											<span>
												<%=machine.getLocation() %>
											</span>
										</td>
									</tr>
									<tr>
										<td align="center" class="title_td">
											<span>
												요금 (1일기준)
											</span>
										</td>
										<td align="left" class="info_td">
											<span>
												<%=machine.getPrice() %>원
											</span>
										</td>
									</tr>
									<tr>
										<td align="center" class="title_td">
											<span>
												보유대수/면적
											</span>
										</td>
										<td align="left" class="info_td">
											<span>
												<%=machine.getRentCount() %>
											</span>
										</td>
									</tr>
									<tr>
										<td align="center" class="title_td">
											<span>
												상세설명
											</span>
										</td>
										<td align="left" class="info_td">
											<span>
												<%=machine.getDetail() %>
											</span>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
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
								<img src="/UserMan2/images/rental/rental_sub01_view_alert_img.png" alt="�뼹�읉李� �씠誘몄�" />
							</div>

							<div class="text_con">
								<span>
									회원 전용 서비스 입니다.
								</span>
							</div>
						</div>

						<div class="btn_con">
							<a href="#" class="a_btn fl">
								로그인
							</a>

							<a href="#" class="a_btn fr">
								회원가입
							</a>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<%@include file="../include/footer.jsp" %>	