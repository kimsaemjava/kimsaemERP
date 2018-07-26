<%@page import="erp.dto.DeptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>jQuery treeview</title>

<link rel="stylesheet" href="/kimsaemERP/common/css/jquery.treeview.css" />
<!-- <link rel="stylesheet" href="/kimsaemERP/common/css/screen.css" /> -->

<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script> -->
<script src="/kimsaemERP/common/js/jquery.cookie.js"></script>
<script src="/kimsaemERP/common/js/jquery.treeview.js" type="text/javascript"></script>
<script src="/kimsaemERP/common/js/demo.js" type="text/javascript"></script>

<script type="text/javascript">

	function runAjax(deptno) {
		alert(deptno);
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				alert(xhr.responseText);
				//document.getElementById("result").innerHTML = xhr.responseXML;
			}
		}
		xhr.open("GET", "/kimsaemERP/emptree.do?deptno="+deptno, true);
		xhr.send();
	}


	</script>
</head>
	<%	ArrayList<DeptDTO> list = (ArrayList<DeptDTO>) request.getAttribute("list"); %>
<body>

	<h1 id="banner">ERP Á¶Á÷µµ - °èÃþ±¸Á¶Ç¥Çö</h1>
		<ul id="browser" class="filetree">
			<%	for (int i = 0; i < list.size(); i++) {	%>
			<li class="closed">
			<span class="folder" onclick="runAjax('<%=list.get(i).getDeptno()%>')"><%=list.get(i).getDeptname()%></span>
			<ul id = >
				<li><span id="result" class="file"></span></li>
			</ul>
			
				<%
					}
				%></li>
		</ul>

</body>
</html>