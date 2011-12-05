<%@page import="net.smartworks.server.engine.infowork.form.model.SwfFormFieldDef"%>
<%@page import="java.util.List"%>
<%@page import="net.smartworks.server.engine.infowork.form.model.SwfForm"%>
<%@page import="net.smartworks.server.engine.infowork.form.model.SwfFormCond"%>
<%@page import="net.smartworks.server.engine.factory.SwManagerFactory"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%

	String key = request.getParameter("key");
	
	String packageId = "pkg_7078af4990b84cc284850186c3ed807a";

	SwfFormCond cond = new SwfFormCond();
	cond.setPackageId(packageId);
	
	
	SwfForm[] froms = SwManagerFactory.getInstance().getSwfManager().getForms("kmyu@maninsoft.co.kr", cond, "all");

		
	
	out.print("####################################");
	out.print(froms[0].getObjString());
	out.print("####################################");
	
	
	
%>
<!-- 폼- 업무 입력 후 -->
<table>
	<colgroup>
		<col class="item">
		<col class="field">
		<col class="item">
		<col class="field">
	</colgroup>
	<tbody>
		<tr>
			<td>제 목</td>
			<td colspan="3" class=""><div class="fieldline essen">
					<input id="" type="text" title="" value="">
				</div></td>
		</tr>
		<tr>
			<td>과제명</td>
			<td>
				<div class="ico_space">
					<div class="fieldline">
						<input id="" type="text" title="" value="">
					</div>
					<div class="ico_posi">
						<img src="images/btn_s_search.jpg" />
					</div>
				</div>
			</td>
			<td class="padding_l20">진행단계</td>
			<td>
				<div>
					<form name="form" id="form">
						<select name="jumpMenu" id="jumpMenu"
							onchange="MM_jumpMenu('parent',this,0)" style="width: 100%;">
							<option>계획</option>
							<option>item2</option>
							<option>item3</option>
							<option>item4</option>
						</select>
					</form>
				</div>
			</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>
				<div class="ico_space">
					<div class="fieldline essen">
						<input id="" type="text" title="" value="">
					</div>
					<div class="ico_posi">
						<img src="images/btn_s_person.png" />
					</div>
				</div>
			</td>
			<td class="padding_l20">작성일자</td>
			<td>
				<div class="ico_space">
					<div class="fieldline essen">
						<input id="" type="text" title="" value="">
					</div>
					<div class="ico_posi">
						<img src="images/btn_s_calendar.png" />
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<td>내 용</td>
			<td colspan="3" class="">
				<div class="textarea_size">
					<textarea class="up_textarea essen" name="내용" cols="" rows="5"
						value="내용"></textarea>
				</div>
			</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td colspan="3" class="">
				<div class="btn_space">
					<div class="fieldline">
						<input id="" type="text" title="" value="">
					</div>

					<div class="btn_wh btn_posi">
						<a href=""> <span class="Btn01Start"></span> <span
							class="Btn01Center">첨부파일</span> <span class="Btn01End"></span> </a>
					</div>
				</div>
			</td>
		</tr>
	</tbody>
</table>
