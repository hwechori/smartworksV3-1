<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.service.ISmartWorks"%>
<%@ page contentType="text/html; charset=utf-8"%>

<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 그리고 현재사용자 정보도 가져온다.	
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	String cid = request.getParameter("cid");
	if (SmartUtil.isBlankObject(cid))
		cid = ISmartWorks.CONTEXT_PREFIX_HOME + cUser.getId();
	String wid = request.getParameter("wid");
	if (SmartUtil.isBlankObject(wid))
		wid = cUser.getId();
%>
<!-- Course Define -->
<div class="course_df_section">
	<div class="course_df_block">
		<div class="course_df_img">
			<img src="sera/images/cus_df_img.jpg" />
		</div>
		<div class="course_df">
			<h1>자화상 그리기</h1>
			<ul class="mt10">
				<li>
					<div class="icon_cs_mentorname">
						<span>멘토명</span>
					</div> <span class="t_s14">홍길동</span></li>
				<li>
					<div class="icon_cs_openday">
						<span>개설일</span>
					</div> <span>2012.02.22</span></li>
				<li>
					<div class="icon_cs_menteenum">
						<span>멘티수</span>
					</div> <span class="t_s14">24</span></li>
			</ul>
		</div>
		<div class="course_info">
			<dl>
				<dt>코스알림</dt>
				<dd>- [알림] 3월 14일 번개팅합니다</dd>
				<dd>- 미션6이 등록되었습니다</dd>
				<dd>- [이벤트] 미션2 선착순 3명!...</dd>
				<dd>- [이벤트] 미션2 선착순 3명!...</dd>
			</dl>
		</div>
	</div>
	<div class="course_menu">
		<div class="btn_mid_l mt8 fl">
			<div class="btn_mid_r">
				<span class="icon_blu_down mr5"></span>친구초대
			</div>
		</div>
		<ul class="fl">
			<li class="pt6">홈</li>
			<li class="pt6">미션</li>
			<li class="pt6">코스알림</li>
			<li>코스설정</li>
		</ul>
		<div class="icon_twitter fr ml5mt7">
			<a href="">트위터</a>
		</div>
		<div class="icon_facebook fr ml5mt7">
			<a href="">페이스북</a>
		</div>
		<div class="fr" style="margin: 4px 30px 0 0">
			<div class="btn_default_l">
				<div class="btn_default_r">팀구성하기</div>
			</div>
		</div>
	</div>
</div>
<!-- Course Define //-->
<!-- Course Section -->
<div class="course_section">
	<!-- 코스 개요 -->
	<div>
		<div class="header mt10">
			<div>코스개요</div>
		</div>
		<ul class="content_area">
			<!-- photo-->
			<li class="">
				<div class="photo_bg">
					<img src="sera/images/photo_default72.jpg" />
					<div class="rgt_name">사랑사랑</div>
				</div>
				<div class="grade">
					<div class="icon_mentor current">왕관</div>
					<div class="icon_star">별</div>
					<div class="icon_heart">하트</div>
				</div></li>
			<!-- photo//-->
			<!-- 개요내용 -->
			<li class="fr">
				<div class="panel_block fr">
					<!-- 코스 목적 -->
					<dl class="content bor">
						<dt class="name">코스목적</dt>
						<dd>
							<div class="text">시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이
								찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로
								그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이
								지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이
								찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~
							</div>
							<!-- Thum Image-->
							<div class="thum_image">
								<img src="sera/images/thum_image.jpg" />
							</div>
							<!-- Thum Image//-->
						</dd>
					</dl>
					<!-- 코스 설명 -->
					<dl class="content bor">
						<dt class="name">코스설명</dt>
						<dd>
							<div class="text w100">시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제
								얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로
								그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이
								지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이
								찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~시간이 지날수록 제 얼굴이 찐빵으로 그려지네요~
							</div>
						</dd>
					</dl>
					<!-- 코스 일정 -->
					<dl class="content bor_no">
						<dt class="name">코스일정</dt>
						<dd class="gaugeBox fl mt10">
							<div class="gaugeOutline">
								<label class="gauge" style="width: 50%;"></label>
							</div>
						</dd>
						<dd class="fr">
							<div class="btn_large_l">
								<div class="btn_large_r">
									<span class="icon_blu_down2 mr5"></span>코스 가입하기
								</div>
							</div>
						</dd>
						<div class="mission_info">8개의 미션 중 2번쨰가 진행중입니다</div>
						<div class="process">(30/60)</div>
					</dl>
				</div></li>
			<!-- 개요내용 //-->
		</ul>
	</div>
	<!-- 코스 개요 //-->
	<!-- 멘토 소개 -->
	<div>
		<div class="header mt10">
			<div>멘토 소개</div>
		</div>
		<ul class="content_area">
			<!-- 개요내용 -->
			<li class="fr">
				<div class="panel_block fr">
					<!-- 코스 목적 -->
					<div class="content">
						<div class="photo_line">
							<img src="sera/images/photo_mento_118118.jpg" width="118"
								height="118" />
						</div>
						<div class="text fr m0">
							<ul class="cb">
								<li class="tb">이외수 소설가</li>
								<li><span class="bullet_dot">출생 :</span> 1946년 8월 15일 (경상남도
									함양)</li>
								<li><span class="bullet_dot">가족 :</span> 배우자 전영자. 아들 이한얼.
									이진얼</li>
								<li><span class="bullet_dot">학력 :</span> 춘천교육대학교 (중퇴)</li>
								<li><span class="bullet_dot">데뷔 :</span> 1972년 소설 '견습 어린이들'
								</li>
								<li><span class="bullet_dot">수상 :</span> 2010년 제 6회 세상을 밝게
									만든 사람들 문화 예술 부문</li>
							</ul>
						</div>
					</div>
				</div></li>
			<!-- 개요내용 //-->
		</ul>
	</div>
	<!-- 멘토 소개//-->
	<!-- 코스 리뷰 -->
	<div>
		<div class="header mt10">
			<div>코스리뷰</div>
		</div>
		<ul class="content_area">
			<li class="fl">
				<div class="btn_large_l">
					<div class="btn_large_r">
						<span class="icon_blu_down2 mr5"></span>리뷰 남기기
					</div>
				</div></li>
			<!-- 리뷰 -->
			<li class="fr">
				<div class="panel_block fr">
					<!-- Reply-->
					<div class="reply_section">
						<div class="photo">
							<img src="sera/images/photo_mid48.jpg" />
						</div>
						<div class="reply_text w375 fl">
							<span class="name">닉네임은 일곱자 : </span> 점점 시간이 지날수록 얼굴이 찐빵으로
							그려지네요~~점점 시간이 지날수록 얼굴이...
							<div class="icon_date">3월 5일</div>
						</div>
						<div class="fr">
							<div class="btn_mid_l mt8">
								<div class="btn_mid_r">
									<span class="icon_blu_down mr5"></span>별점주기
								</div>
							</div>
							<div class="star_score cb">
								<ul>
									<li class="icon_star_score current"><a href=""> </a>
									</li>
									<li class="icon_star_score current"><a href=""> </a>
									</li>
									<li class="icon_star_score current"><a href=""> </a>
									</li>
									<li class="icon_star_score"><a href=""> </a>
									</li>
									<li class="icon_star_score"><a href=""> </a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<!-- Reply//-->
					<!-- Reply-->
					<div class="reply_section end">
						<div class="photo">
							<img src="sera/images/photo_mid48.jpg" />
						</div>
						<div class="reply_text w375 fl">
							<span class="name">닉네임은 일곱자 : </span> 점점 시간이 지날수록 얼굴이 찐빵으로
							그려지네요~~점점 시간이 지날수록 얼굴이...
							<div class="icon_date">3월 5일</div>
						</div>
						<div class="fr">
							<div class="btn_mid_l mt8">
								<div class="btn_mid_r">
									<span class="icon_blu_down mr5"></span>별점주기
								</div>
							</div>
							<div class="star_score cb">
								<ul>
									<li class="icon_star_score current"><a href=""> </a>
									</li>
									<li class="icon_star_score current"><a href=""> </a>
									</li>
									<li class="icon_star_score current"><a href=""> </a>
									</li>
									<li class="icon_star_score"><a href=""> </a>
									</li>
									<li class="icon_star_score"><a href=""> </a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<!-- Reply//-->
				</div></li>
			<!-- 리뷰//-->
		</ul>
	</div>
	<!-- 코스 리뷰 //-->
	<!-- 더보기 -->
	<div class="more cb">
		<div class="icon_more">더보기</div>
	</div>
	<!-- 더보기 //-->
</div>
<!-- Comment Pannel-->
