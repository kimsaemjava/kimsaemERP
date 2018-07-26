<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="erp.dto.DeptDTO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link rel="stylesheet" href="/kimsaemERP/common/css/jquery.treeview.css" />
<!-- 	<link rel="stylesheet" href="/kimsaemERP/common/css/screen.css" /> -->
<!-- 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script> -->
<script src="/kimsaemERP/common/js/jquery.cookie.js"></script>
<script src="/kimsaemERP/common/js/jquery.treeview.js"></script>
<script type="text/javascript" src="/kimsaemERP/common/js/demo.js"></script>


<script type="text/javascript">
	var xhr;
	function runAjax() {
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = readyCallback;

		alert(deptno.value);
		xhr.open("GET", "/kimsaemERP/emp/deptemplist.do?deptno=" + deptno.value, true);
		xhr.send();
	}
	function readyCallback() {
		if (xhr.readyState == 4 && xhr.status == 200) { // 정상처리
			document.getElementById("result").innerHTML = xhr.responseText;

		}
	}
</script>


</head>
<%
	ArrayList<DeptDTO> deptnamelist = (ArrayList<DeptDTO>) request.getAttribute("deptnamelist");
	int size = deptnamelist.size();
%>
<body>
	<h1>kimsaemJavaNara 조직도 - 계층구조표현</h1>
	<ul id="browser" class="filetree">
		<%
			for (int i = 0; i < size; i++) {
				DeptDTO dept = deptnamelist.get(i);
		%>
		
		<li class="closed">
		<span class="folder" onclick="runAjax()">
		<input type="hidden" name="deptno" value="<%= dept.getDeptno()%>"/>
		<%=dept.getDeptname()%></span>
			<ul>
				<li><span class="file"><div id="result"><%=request.getAttribute("msg")%></div></span></li> 
			</ul>
		</li>
			<%} %>
	</ul>
</body>
</html>