<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>creation page~!!</title>
</head>
<body>
<script type="text/javascript">

function setGroup() {

	var f = document.form;
	f.action = "../group_creation.sw";
	f.submit();
}

</script>
<form name="form" method="post">
그룹이름 : <input type="text" id="groupName" name="groupName"><br>
그룹설명 : <input type="text" id="groupDesc" name="groupDesc"><br>
그룹리더 : <input type="text" id="groupLeader" name="groupLeader"><br>
그룹오너 : <input type="text" id="groupOwner" name="groupOwner"><br>
그룹맴버 : <select name="groupMembers" multiple="multiple">
			<option value="ysjung@maninsoft.co.kr">정윤식</option>
			<option value="jskim@maninsoft.co.kr">김지숙</option>
			<option value="kmyu@maninsoft.co.kr">유광민</option>
			<option value="hsshin@maninsoft.co.kr">신현성</option>
			</select>
공개여부 : 공개<input type="radio" id="isPublic" name="isPublic" value="public"> 비공개<input type="radio" id="isPublic" name="isPublic" value="private">
<input type="submit" value="그룹생성" onclick="setGroup()"><br>
</form>
</body>
</html>