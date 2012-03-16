<%@page import="net.smartworks.service.ISmartWorks"%>
<%@ page contentType="text/html; charset=utf-8"%>

<%
	session.setAttribute("cid", ISmartWorks.CONTEXT_HOME);
	session.removeAttribute("wid");
%>
<div class="my_comment_section">
	<div class="my_photo"> <img src="../../../sera/images/photo_larg118.jpg"/> </div>
	<!-- My Comment -->
	<div class="my_comment">
		<div class="header"> 닉네임은 일곱자님 </div>
		<div class="comment_txt">
			<textarea name="" cols="" rows="5">전공 공부만큼 영어를 좋아했는데 입사하고 나니 영어에는 손을 뚝 끊어버리게 되네요~ 전공 공부만큼 영어를 좋아했는데 입사하고 나니 영어에는 손을 뚝 끊어버리게 되네요~전공 공부만큼 영어를 좋아했는데 입사하고 나니 영어에는 손을 뚝 끊어버리게 되네요~전공 공부만큼 영어를 좋아했는데 입사하고 나니 영어에는 손을 뚝 끊어버리게 되네요~전공 공부만큼 영어를
			</textarea>
		</div>
		<!-- 좌측 영역 -->
		<div class="option">
			<!-- 버튼 -->
			<div class="btn_wstyle_l">
				<div class="btn_wstyle_r"> 텍스트 </div>
			</div>
			<!-- 버튼 //-->
			<!-- select -->
			<select name="" class=" mt5 ml5 fl">
				<option>전체공개</option>
				<option>친구공개</option>
			</select>
			<!-- select //-->
			<!-- 태그넣기 -->
			<div class=""> 태그넣기 </div>
			<!-- 태그넣기//-->
		</div>
		<!-- 좌측 영역//-->
		<!-- 우측 버튼 영역 -->
		<div class="attach_file">
			<ul>
				<li class="t_s11"> <span class="t_red">0</span>/1000kbyte</li>
				<li class="icon_video ml10"><a href=""> </a></li>
				<li class="icon_photo"><a href=""> </a></li>
				<li class="icon_link"><a href=""> </a></li>
				<!-- Btn 등록-->
				<li class="btn_default_l ml10">
					<div class="btn_default_r"> 등록 </div>
				</li>
				<!-- Btn 등록//-->
			</ul>
		</div>
		<!-- 우측 버튼 영역 //-->
	</div>
	<!-- My Comment //-->
</div>
<!-- Comment Pannel-->
<div class="panel_section">
	<div class="header">
		<div class="icon_mytext"><a href="">내글보기</a></div>
		<div> | <a href="" class="current">뉴스피드</a></div>
	</div>
	<!-- Panel1 -->
	<div>
		<ul class="panel_area">
			<!-- photo-->
			<li class="">
				<div class="photo_bg"> <img src="../../../sera/images/photo_default72.jpg" />
					<div class="rgt_name">사랑사랑</div>
				</div>
				<div class="grade">
					<div class="icon_mentor current">왕관</div>
					<div class="icon_star">별</div>
					<div class="icon_heart">하트</div>
				</div>
			</li>
			<!-- photo//-->
			<!-- comment -->
			<li class="fr">
				<div class="point"></div>
				<div class="panel_block fr">
					<dl class="content">
						<dt class="name">몽슈니 <span class="t_redb">[미션1. 자화상 그리기]</span> <span class="icon_open fr"><a href="">펼침</a></span></dt>
						<dd>
							<div class="text"> 시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~ </div>
							<!-- Thum Image-->
							<div class="thum_image"> <img src="../../../sera/images/thum_image.jpg"/> </div>
							<!-- Thum Image//-->
						</dd>
						<!-- Util -->
						<dd class="util"> <span class="icon_reply"><a href="">댓글달기</a> | </span> <span class="icon_like"><a href="">공감취소</a> | </span> <span class="date">2012 년 03 월 09 일</span> </dd>
						<!-- Util //-->
					</dl>
					<div class="stat_notice"> 7개의 덧글이 있습니다 <span class="t_blueb">더보기</span> </div>
					<!-- Reply-->
					<div class="reply_section">
						<div class="photo"> <img src="../../../sera/images/photo_mid48.jpg" /> </div>
						<div class="reply_text"> <span class="name">닉네임은 일곱자 : </span> 점점 시간이 지날수록 얼굴이 찐빵으로 그려지네요~~점점 시간이 지날수록 얼굴이 찐빵으로 그려지네요~~점점 시간이 지날수록 얼굴이 찐빵으로 그려지네요~~점점 시간이 지날수록 얼굴이 찐빵으로 그려지네요~~점점 시간이 지날수록 얼굴이 찐빵으로 그려지네요~~점점 시간이 지날수록 얼굴이 찐빵으로 그려지네요~~
							<div class="icon_date">3월 5일</div>
						</div>
					</div>
					<!-- Reply//-->
					<!-- Reply-->
					<div class="reply_section">
						<div class="photo"> <img src="../../../sera/images/photo_mid48.jpg" /> </div>
						<div class="reply_text"> <span class="name">닉네임은 일곱자 : </span> 점점 시간이 지날수록 얼굴이 찐빵으로 그려지네요~~점점 시간이 지날수록 얼굴이 찐빵으로 그려지네요~~점점 시간이 지날수록 얼굴이 찐빵으로 그려지네요~~점점 시간이 지날수록 얼굴이 찐빵으로 그려지네요~~점점 시간이 지날수록 얼굴이 찐빵으로 그려지네요~~점점 시간이 지날수록 얼굴이 찐빵으로 그려지네요~~
							<div class="icon_date">3월 5일</div>
						</div>
					</div>
					<!-- Reply//-->
					<!-- Reply-->
					<div class="reply_section end">
						<textarea name="" cols="" rows="" class="fl" style="width:472px" placeholder="댓글을 남겨주세요!"></textarea>
						<div class="btn_default_l ml10">
							<div class="btn_default_r"> 등록 </div>
						</div>
					</div>
					<!-- Reply//-->
				</div>
			</li>
			<!-- comment //-->
		</ul>
	</div>
	<!-- Panel1 //-->
	<!-- Panel2 -->
	<div>
		<ul class="panel_area">
			<!-- photo-->
			<li class="">
				<div class="photo_bg"> <img src="../../../sera/images/photo_default72_2.jpg"/>
					<div class="rgt_name">사랑사랑</div>
				</div>
				<div class="grade">
					<div class="icon_mentor">왕관</div>
					<div class="icon_star current">별</div>
					<div class="icon_heart">하트</div>
				</div>
			</li>
			<!-- photo//-->
			<!-- comment -->
			<li class="fr">
				<div class="point"></div>
				<div class="panel_block fr">
					<dl class="content">
						<dt class="icon_sm_message">쪽지 <span class="icon_open fr"><a href="">펼침</a></span></dt>
						<dd>
							<div class="message"> 시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~ </div>
						</dd>
						<!-- Util -->
						<dd class="util"> <span class="icon_reply"><a href="">댓글달기</a></span> <span class="icon_like"> | <a href="">공감취소</a></span> <span> | <span class="date">2012 년 03 월 09 일</span></span> </dd>
						<!-- Util //-->
					</dl>
				</div>
			</li>
			<!-- comment //-->
		</ul>
	</div>
	<!-- Panel2 //-->
	<!-- Panel3 -->
	<div>
		<ul class="panel_area">
			<!-- photo-->
			<li class="">
				<div class="photo_bg"> <img src="../../../sera/images/photo_default72_2.jpg"/>
					<div class="rgt_name">사랑사랑</div>
				</div>
				<div class="grade">
					<div class="icon_mentor">왕관</div>
					<div class="icon_star current">별</div>
					<div class="icon_heart">하트</div>
				</div>
			</li>
			<!-- photo//-->
			<!-- comment -->
			<li class="fr">
				<div class="point"></div>
				<div class="panel_block fr">
					<dl class="content">
						<dt class="icon_sm_message">쪽지 <span class="icon_open fr"><a href="">펼침</a></span></dt>
						<dd>
							<div class="message"> 시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~ </div>
						</dd>
						<!-- Util -->
						<dd class="util"> <span class="icon_reply"><a href="">댓글달기</a></span> <span class="icon_like"> | <a href="">공감취소</a></span> <span> | <span class="date">2012 년 03 월 09 일</span></span> </dd>
						<!-- Util //-->
					</dl>
				</div>
			</li>
			<!-- comment //-->
		</ul>
	</div>
	<!-- Panel3 //-->
	<!-- 더보기 -->
	<div class="more">
	  <div class="icon_more">더보기</div>
	</div>
	<!-- 더보기 //-->
</div>
<!-- Comment Pannel-->
