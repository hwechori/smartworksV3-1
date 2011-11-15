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
		session.setAttribute("wid", SmartUtil.getCurrentUser().getId());
	else
		session.setAttribute("wid", wid);
%>

<!-- 컨텐츠 레이아웃-->
<div class="up_wrap">
    	<div class="form_wrap up up_padding">
            
            <!-- 타이틀 -->
            	<div class="body_title">
                	<div class="body_titi_iworks title_noico">신제품 기획 TFT > TFT 회의록 </div> 
                    
                    <!-- 우측 버튼-->
            <div class="txt_btn">
                <div class="po_right"><a href="">2011.11.14 16:00</a></div>
                <div class="po_right"><a href="">최종수정: jisook kim</a></div>
                <div class="po_right"><a href="">공개</a></div>
                <div class="po_right"><a href="">전체등록 가능</a></div>
                <div class="po_right"><a href="">위키형</a></div>
            </div>
            <!-- 우측 버튼 -->
            
                	<div class="solid_line"></div>
                </div>
            <!-- 타이틀 -->
            
            
            
            
<!-- 컨텐츠 -->
<div class="contents_space">
            	
            <!-- 업무 정의 영역 -->
            <div class="">
            이 회의록은 신제품기획 TFT 회의록입니다
            </div>
            
            <!-- 업무 정의 영역 //-->
            
        <!-- 버튼 영역--> 
  <div class="txt_btn posi_ab">
                <div class="po_left"><a href="">업무설명보기▼</a></div>
            </div>
            
            <div class="txt_btn">
                
            <div class="float_right padding_l10">
       		<span class="btn_gray">
            <span class="Btn01Start"></span>
            <span class="Btn01Center">수정하기</span>
            <span class="Btn01End"></span>
            </span>
            </div>
            
            <div class="float_right">사용설명서 : <a href="">동영상 보기</a> <a href="">웹설명서 보기</a></div>
            
            </div>
			<!-- 라인 -->
			<div class="solid_line_s"> </div>
          <!-- 버튼 영역 //-->

</div>

<div class="contents_space">
			<!-- 업무설명 영역 -->
            <div class="det_contents">      
                        <table>
                            <colgroup>
                                <col class="item">
                                <col class="field">
                            </colgroup>
                        <tbody>
                            <tr>
                                <td><img src="images/im_iworkscreen.gif" width="349" height="289" /></td>
                              <td>1. 업무설명이 들어갑니다<br />
                              1. 업무설명이 들어갑니다<br />
                              2. 업무설명이 들어갑니다<br />
                              3. 업무설명이 들어갑니다<br />
                              4. 업무설명이 들어갑니다<br />
                              5. 업무설명이 들어갑니다
                              </td>
                            </tr>
                        </tbody>
                        </table> 
              </div>
			
            <!-- 라인 -->
			<div class="solid_line_s"> </div>
            <!-- 업무 설명 영역 //-->
           
           <!-- 댓글 -->
    <div class="replay">
        <ul>
        <li>
                <div class="noti_pic"><img src="images/pic_size_29.jpg" alt="신민아" align="bottom"/></div>
                <div class="noti_in">
                    <span class="t_name">Minashin</span><span class="arr">▶</span><span class="ico_division_s">마케팅/디자인팀</span><span class="t_date"> 2011.10.13</span>
                    <div>회의록 내용 중 빠진 부분이나 수정할 사항이 있으시면 참석자 누구든 수정해주시기 바랍니다^^</div>
            </div>
        </li>
        <li>
                <div class="noti_pic"><img src="images/pic_size_29.jpg" alt="신민아" align="bottom"/></div>
                <div class="noti_in">
                    <span class="t_name">Minashin</span><span class="arr">▶</span><span class="ico_division_s">마케팅/디자인팀</span><span class="t_date"> 2011.10.13</span>
                    <div>회의록 내용 중 빠진 부분이나 수정할 사항이 있으시면 참석자 누구든 수정해주시기 바랍니다^^</div>
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
    <!-- 댓글 //-->
    
    <!-- 라인 -->
    <div class="solid_line_s"> </div>             
            
</div>


<div class=" contents_space">    
    <!-- 목록보기 -->
    	<!-- 목록보기 타이틀-->
        <div class="list_title_space">
              
            <div class="txt_btn posi_ab">
                <div class="po_left title">목록보기</div>
                
                <div class="po_left">
                <div class="srch">
                    <input id="" type="text" value="채팅 가능한 사람" title="채팅 가능한 사람">
                    <button onclick="" title="검색"></button>
                    </div>
                </div>
                
                <div class="po_left">
                	<form id="" class="form_space" name="form">
                    <select name="">
                    <option value="3" selected="">모든항목</option>
                    <option value="1">항목1</option>
                    </select>
                    </form>
                </div>
                <div class="po_left">상세필터</div>
            </div>
            
             <div class="txt_btn">
                <div class="po_right"><a href="">목록보기</a></div>
                <div class="po_right"><a href="">엑셀 불러오기</a></div>
            </div>
            
        </div>
        <!-- 목록보기 타이틀-->
            
           
        <!-- 목록 테이블 -->   
        <div class="up list_contents">      
                <table>
                    <colgroup>
                        <col class="item">
                        <col class="field">
                        <col class="field">
                    </colgroup>
                <tbody>
                    <tr>
                        <th>등록자</th>
                        <th>제 목</th>
                        <th>수정자/수정일</th>
                    </tr>
                    <tr>
                        <td><img src="images/pic_size_m29.jpg" /></td>
                        <td>정보관리업무 제목 목록입니다</td>
                        <td>
                        <div class="noti_pic"><img src="images/pic_size_29.jpg" alt="신민아" align="bottom"/></div>
                        <div class="noti_in">
                            <span class="t_name">Minashin</span>
                            <div class="t_date">2011.11.15 14:00</div>
                        </div>
                        </td>
                    </tr>
                    
                    <tr>
                        <td><img src="images/pic_size_m29.jpg" /></td>
                        <td>정보관리업무 제목 목록입니다</td>
                        <td>
                        <div class="noti_pic"><img src="images/pic_size_29.jpg" alt="신민아" align="bottom"/></div>
                        <div class="noti_in">
                            <span class="t_name">Minashin</span>
                            <div class="t_date">2011.11.15 14:00</div>
                        </div>
                        </td>
                    </tr>
                    
                    <tr>
                        <td><img src="images/pic_size_m29.jpg" /></td>
                        <td>정보관리업무 제목 목록입니다</td>
                        <td>
                        <div class="noti_pic"><img src="images/pic_size_29.jpg" alt="신민아" align="bottom"/></div>
                        <div class="noti_in">
                            <span class="t_name">Minashin</span>
                            <div class="t_date">2011.11.15 14:00</div>
                        </div>
                        </td>
                    </tr>
                    
                    <tr>
                        <td><img src="images/pic_size_m29.jpg" /></td>
                        <td>정보관리업무 제목 목록입니다</td>
                        <td>
                        <div class="noti_pic"><img src="images/pic_size_29.jpg" alt="신민아" align="bottom"/></div>
                        <div class="noti_in">
                            <span class="t_name">Minashin</span>
                            <div class="t_date">2011.11.15 14:00</div>
                        </div>
                        </td>
                    </tr>
                    
                    <tr>
                        <td><img src="images/pic_size_m29.jpg" /></td>
                        <td>정보관리업무 제목 목록입니다</td>
                        <td>
                        <div class="noti_pic"><img src="images/pic_size_29.jpg" alt="신민아" align="bottom"/></div>
                        <div class="noti_in">
                            <span class="t_name">Minashin</span>
                            <div class="t_date">2011.11.15 14:00</div>
                        </div>
                        </td>
                    </tr>
                    
                    <tr>
                        <td><img src="images/pic_size_m29.jpg" /></td>
                        <td>정보관리업무 제목 목록입니다</td>
                        <td>
                        <div class="noti_pic"><img src="images/pic_size_29.jpg" alt="신민아" align="bottom"/></div>
                        <div class="noti_in">
                            <span class="t_name">Minashin</span>
                            <div class="t_date">2011.11.15 14:00</div>
                        </div>
                        </td>
                    </tr>
                    
                    <tr>
                        <td><img src="images/pic_size_m29.jpg" /></td>
                        <td>정보관리업무 제목 목록입니다</td>
                        <td>
                        <div class="noti_pic"><img src="images/pic_size_29.jpg" alt="신민아" align="bottom"/></div>
                        <div class="noti_in">
                            <span class="t_name">Minashin</span>
                            <div class="t_date">2011.11.15 14:00</div>
                        </div>
                        </td>
                    </tr>
                </tbody>
                </table> 
                <div class="padding_l10"> <a href="">더보기</a></div>
        </div>
        <!-- 목록 테이블 //-->
        
            
           
	<!-- 목록보기 -->  
</div>    

    
    
</div>
</div>
<!-- 컨텐츠 레이아웃//-->
