<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String cid = request.getParameter("cid");
	if (cid == null)
		session.setAttribute("cid", ISmartWorks.CONTEXT_HOME);
	else
		session.setAttribute("cid", cid);
	String wid = request.getParameter("wid");
	if (wid == null)
		session.setAttribute("wid", SmartUtil.getCurrentUser(request, response).getId());
	else
		session.setAttribute("wid", wid);
%>
<!-- 컨텐츠 레이아웃-->
    <div class="section_portlet">
    <div class="portlet_t">
      <div class="portlet_tl"></div>
    </div>
    <div class="portlet_l" style="display: block;">
    <ul class="portlet_r" style="display: block;">
            
            <!-- 타이틀 -->
            	<div class="body_titl_pic">

                    <div class="">
                        <div class="noti_pic"><img src="images/pic_size_48.jpg" /></div>
                        <div class="noti_in_bodytitle">
                            <span class="t_name">Snagkil Ahn</span><span class="t_date"> 2011.11.15</span>
                            <div class=""><span class="ico_iworks t_date">근태/특근관리 &gt; 근태품의</span> <span class="title_picico">예비군 훈련관계로 휴가신청합니다</span></div>
                        </div>
                    </div>
                    
            <!-- 우측 버튼-->
             <div class="txt_btn">
                <div class="po_right"><a href="">주소복사</a></div>
            </div>
            
            <div class="txt_btn">
                <div class="po_right"><a href=""><img src="images/btn_print.gif" alt="프린트" /></a></div>
                <div class="po_right"><a href=""><img src="images/btn_mail.gif" alt="메일" /></a></div>
                <div class="po_right"><a href="">프로세스 다이어그램보기▼</a></div>
            </div>
            <!-- 우측 버튼 -->
                    
                	<div class="solid_line"></div>
                </div>
            <!-- 타이틀 -->
 
            
<!-- 프로세스 영역 -->
<div class="contents_space">
        <div class="proce_space">
        
        <!-- 시작 --> 
        <div class="proc_start_compl float_left padding_r10"> 시작 </div>
        <!-- 시작 //--> 
        
        <!--화살표-->
        <div class="proc_arr_next float_left padding_r10"></div>
        <!--화살표-->
        
        <!-- 태스크 --> 
        <div class="proc_task_compl float_left padding_r10">
        	<a href="">
            <span class="pstart"></span>
            <span class="pcenter">
            	<!-- task 정보 -->
            	<div class="float_left">
                <img align="bottom" src="images/pic_size_29.jpg">
                </div>
                <div class="noti_in">
                <span>근태계 기안</span>
                <div class="t_date">2011.11.15 14:00</div>
                </div>
                <!-- task 정보 //-->
            </span>
            <span class="pend"></span>
            </a>
        </div>
        <!-- 태스크 //--> 
        
        <!--화살표-->
        <div class="proc_arr_next float_left padding_r10"></div>
        <!--화살표-->
        
        <!-- 태스크 --> 
        <div class="proc_task_yet float_left padding_r10">
        	<a href="">
            <span class="pstart"></span>
            <span class="pcenter">
            	<!-- task 정보 -->
            	<div class="float_left">
                <img align="bottom" src="images/pic_size_29.jpg">
                </div>
                <div class="noti_in">
                <span>이력 기록</span>
                <div class="t_date">2011.11.15 14:00</div>
                </div>
                <!-- task 정보 //-->
            </span>
            <span class="pend"></span>
            </a>
        </div>
        <!-- 태스크 //--> 
        
        <!--화살표-->
        <div class="proc_arr_next float_left padding_r10"></div>
        <!--화살표-->
        
       <!-- 태스크 --> 
        <div class="proc_task_rturn float_left padding_r10">
        	<a href="">
            <span class="pstart"></span>
            <span class="pcenter">
            	<!-- task 정보 -->
            	<div class="float_left">
                <img align="bottom" src="images/pic_size_29.jpg">
                </div>
                <div class="noti_in">
                <span>개인별 근태현황</span>
                <div class="t_date">2011.11.15 14:00</div>
                </div>
                <!-- task 정보 //-->
            </span>
            <span class="pend"></span>
            </a>
        </div>
        <!-- 태스크 //-->
        
        <!--화살표-->
        <div class="proc_arr_next float_left padding_r10"></div>
        <!--화살표-->
        
        <!-- 태스크 --> 
        <div class="proc_task_ing float_left padding_r10">
        	<a href="">
            <span class="pstart"></span>
            <span class="pcenter">
            	<!-- task 정보 -->
            	<div class="float_left">
                <img align="bottom" src="images/pic_size_29.jpg">
                </div>
                <div class="noti_in">
                <span>승인자 결재</span>
                <div class="t_date">2011.11.15 14:00</div>
                </div>
                <!-- task 정보 //-->
            </span>
            <span class="pend"></span>
            </a>
        </div>
        <!-- 태스크 //-->
        
        <!--화살표-->
        <div class="proc_arr_next float_left padding_r10"></div>
        <!--화살표-->
        
        <!-- 태스크 --> 
        <div class="proc_task_dlay float_left padding_r10">
        	<a href="">
            <span class="pstart"></span>
            <span class="pcenter">
            	<!-- task 정보 -->
            	<div class="float_left">
                <img align="bottom" src="images/pic_size_29.jpg">
                </div>
                <div class="noti_in">
                <span>승인자 결재</span>
                <div class="t_date">2011.11.15 14:00</div>
                </div>
                <!-- task 정보 //-->
            </span>
            <span class="pend"></span>
            </a>
        </div>
        <!-- 태스크 //-->        
        
        </div>
</div>
<!--프로세스 영역//-->

<!-- 업무- 근태계 기안 -->
<div class="contents_space">
    <div class="up_point posit_first"></div>
        <div class="form_wrap up up_padding">
        
        	<!-- 컨텐츠-->
        	<div class="area">
            
			<div class="list_title_space">
            	<div class="title">근태계 기안</div>
            </div>
            
            <div class="list_contents">
            	<table>
                    <tbody>
                        <tr>
                        <th style=" text-align:right">작성자</th>
                        <td class="r_line">선임 신현성</td>
                        <th>회의일자</th>
                        <td class="r_line">2011.11.15</td>
                        <th>회의시간</th>
                        <td class="r_line">13:00</td>
                        <th>회의장소</th>
                        <td>회의실</td>
                        </tr>
                        <tr>
                        <th style=" text-align:right">참석자</th>
                        <td colspan="7">정보관리업무 제목 목록입니다</td>
                        </tr>
                        <tr>
                        <th style=" text-align:right">회의안건</th>
                        <td colspan="7">정보관리업무 제목 목록입니다</td>
                        </tr>
                        <tr>
                        <th style=" text-align:right">회의내용</th>
                        <td colspan="7">정보관리업무 제목 목록입니다</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            </div>
            <!-- 컨텐츠 //-->
        </div>
</div>
<!-- 업무- 근태계 기안 //-->

<!-- 버튼 영역 -->
<div class="glo_btn_space">

    
<!-- 수정, 삭제버튼 -->
    <div class="float_right">
        <span class="btn_gray">
            <span class="Btn01Start"></span>
            <span class="Btn01Center">업무완료</span>
            <span class="Btn01End"></span>
            </span>

         <span class="btn_gray space_l5">
            <span class="Btn01Start"></span>
            <span class="Btn01Center">반 려</span>
            <span class="Btn01End"></span></span>
            
            <span class="btn_gray space_l5">
            <span class="Btn01Start"></span>
            <span class="Btn01Center">위 임</span>
            <span class="Btn01End"></span></span>
            
            <span class="btn_gray space_l5">
            <span class="Btn01Start"></span>
            <span class="Btn01Center">저 장</span>
            <span class="Btn01End"></span></span>
     </div>
<!-- 수정, 삭제버튼 //-->    
  
</div>
<!-- 버튼 영역 //-->     

</ul>
</div>
<div class="portlet_b" style="display: block;"></div>
</div> 
<!-- 컨텐츠 레이아웃//-->







<!--댓글 영역 -->

<div class="gr_up_point posit_point"></div>
  <!-- 댓글 목록 -->
  <div class="gr_portlet">
    <div class="gr_portlet_t">
      <div class="gr_portlet_tl"></div>
    </div>
    <div class="gr_portlet_l" style="display: block;">
    <ul class="gr_portlet_r" style="display: block;">
    
    
<!-- 올리기 -->
<div class="detail_up_wrap">
    <div id="upload">
    <div class="up_works"><a class="" href="">업무</a></div>
    <div class="up_file"><a class="" href="">파일</a></div>
    <div class="up_memo"><a class="" href="">메모</a></div>
    </div>
      
    <div class="up_wrap">
    <div class="up_point posit_works"></div>
    <!-- 폼- 디폴트-->
        <div class="start_worksinput">
        <div class="input_size srch">
            <input class="js_auto_complete" type="text" href="work_name.sw"
                placeholder="<fmt:message key='common.upload.message.work'/>">
            <div class="srch_ico js_srch_x"></div>
    
        </div>
    
        <div class="btn_gray btn_right" id="all_work_btn" style="display: none">
            <a href=""> <span class="Btn01Start"></span> <span
                class="Btn01Center"><fmt:message
                        key="common.upload.button.all_works" /> </span> <span class="Btn01End"></span>
            </a>
        </div>
    
    
        <!--검색 자동완성어 리스트-->
        <div class="srch_list" id="upload_work_list" style="display: none">
        </div>
        <!--검색 자동완성어 리스트//-->
        
    </div>
    <!-- 폼- 디폴트//-->   
         
    </div>
    
</div>
<!-- 올리기 //-->

    
<!-- 목록시작 -->
<div class="replay">
    <ul>
    <li class="dash_line">
        <div class="det_title">
            <div class="noti_pic"><img src="images/pic_size_29.jpg" alt="신민아" align="bottom"/></div>
            <div class="noti_in">
                <span class="t_name">Minashin</span><span class="arr">▶</span><span class="ico_division_s">마케팅/디자인팀</span><span class="t_date"> 2011.10.13</span>
                <div>회의록 내용 중 빠진 부분이나 수정할 사항이 있으시면 참석자 누구든 수정해주시기 바랍니다^^</div>
            </div>
        </div>
    </li>
    <li>
        <div class="det_title">
            <div class="noti_pic"><img src="images/pic_size_29.jpg" alt="신민아" align="bottom"/></div>
            <div class="noti_in">
                <span class="t_name">Minashin</span><span class="arr">▶</span><span class="ico_division_s">마케팅/디자인팀</span><span class="t_date"> 2011.10.13</span>
                <div>회의록 내용 중 빠진 부분이나 수정할 사항이 있으시면 참석자 누구든 수정해주시기 바랍니다^^</div>
            </div>
        </div>
    </li>
    <li class="end">
        <div class="det_title">
            <div class="noti_pic"><img src="images/pic_size_29.jpg" alt="신민아" align="bottom"/></div>
            <div class="noti_in">
                <span class="t_name">Minashin</span><span class="arr">▶</span><span class="ico_division_s">마케팅/디자인팀</span><span class="t_date"> 2011.10.13</span>
                <div>회의록 내용 중 빠진 부분이나 수정할 사항이 있으시면 참석자 누구든 수정해주시기 바랍니다^^</div>
            </div>
        </div>
    </li>
    </ul>
</div>
<!-- 목록 끝 //-->

    </ul>
    </div>
    <div class="gr_portlet_b" style="display: block;"></div>
    </div>
  <!-- 댓글 목록 //-->
  
<!--댓글 영역//-->


<!-- 목록 버튼 -->
<div class="" style=" text-align:center">
<div class="btn_gray" >
    <a href=""> <span class="Btn01Start"></span> <span
        class="Btn01Center">목 록</span> <span class="Btn01End"></span>
    </a>
</div>
</div>
<!-- 목록 버튼//-->
