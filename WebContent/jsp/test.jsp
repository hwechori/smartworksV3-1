<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="js/homeForm.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/FormWork.js"></script>
<script type="text/javascript" src="js/FormRuntime.js"></script>
<script type="text/javascript" src="js/FormEnv.js"></script>
<script type="text/javascript" src="js/prototype-1.6.0.2.js"></script>
<script type="text/javascript">
function callForm() {
	createRecord('','','');
}
</script>
</head>
<body>
<form name="name">
<a href="javascript:callForm();">회의록 Form 열기</a>
</form>
</body>
</html>