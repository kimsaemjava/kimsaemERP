<%@page import="erp.dto.DeptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jQuery treeview</title>

<link rel="stylesheet" href="/kimsaemERP/common/css/jquery.treeview.css" />
<!-- <link rel="stylesheet" href="/kimsaemERP/common/css/screen.css" /> -->
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script> -->
<script src="/kimsaemERP/common/js/jquery.treeview.js"
	type="text/javascript"></script>
<script src="/kimsaemERP/common/js/query.cookie.js"></script>
<script type="text/javascript" src="/kimsaemERP/common/js/demo.js"></script>
<script type="text/javascript">
	var xhr
	var deptno
	function runAjax(deptno) {
		//alert("test");
		//alert(deptno);
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
		 	 if(xhr.readyState==4 && xhr.status==200){	
			}  
		}
		xhr.open("GET", "/kimsaemERP/ajaxtreedata?deptno="+deptno, true);
		xhr.send();
	}
</script>
</head>
<body>
<% 
	ArrayList<DeptDTO> deptList = (ArrayList<DeptDTO>)request.getAttribute("deptList");
	int size = deptList.size();
%>
	<h1>KimsaemJavaNara - 조직도</h1>
	<div id="result"></div>
	<ul id="browser" class="filetree" >
		<%for(int i=0; i<size; i++){ 
			DeptDTO dept = deptList.get(i);%>
			<li class="closed">
				<span class="folder" onclick="runAjax('<%=dept.getDeptno()%>')">
				<%=dept.getDeptname() %></span>
				<ul>
					<!-- <li><span class="file">장동건</span></li> -->
				</ul>
			</li>
		<%} %>
		<!-- <li><span class="folder">Folder 2</span>
			<ul>
				<li><span class="folder">Subfolder 2.1</span>
					<ul id="folder21">
						<li><span class="file">File 2.1.1</span></li>
						<li><span class="file">File 2.1.2</span></li>
					</ul>
				</li>
				<li><span class="file">File 2.2</span></li>
			</ul>
		</li>
		<li class="closed"><span class="folder">Folder 3 (closed at start)</span>
			<ul>
				<li><span class="file">File 3.1</span></li>
			</ul>
		</li>
		<li><span class="file">File 4</span></li> -->
	</ul>
</body>
</html>