<%@page import="erp.dto.DeptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/kimsaemERP/common/css/jquery.treeview.css" />
	<!-- <link rel="stylesheet" href="/kimsaemERP/common/css/screen.css" /> -->

	<!-- 메인에 js가 있으므로 버전 충돌이 일어남으로 주석 -->
	<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>-->
	<script src="/kimsaemERP/common/js/jquery.cookie.js"></script>
	<script src="/kimsaemERP/common/js/jquery.treeview.js"></script>

	<script type="text/javascript" src="/kimsaemERP/common/js/demo.js"></script>
	<%
		ArrayList<DeptDTO> deptnamelist = (ArrayList<DeptDTO>) request.getAttribute("deptnamelist");
		int size = deptnamelist.size();
		// System.out.println("jsp" + deptnamelist);
	%>
	<script type="text/javascript">
 		function runAjax(dept){
 			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){
			}
			xhr.open("GET", "/kimsaemERP/gettree.do?dept="+dept,true);
			xhr.send();	
		
 		}
 		
 		
		
	</script>
</head>
<body>

	<h1>kimsaemJavaNara조직도 - 계층구조표현</h1>
	
	<ul id="browser" class="filetree">
	<%
		for(int i=0;i<size;i++){
			DeptDTO dept = deptnamelist.get(i);
	%>
		<li class="closed">
			<span class="folder" onclick="runAjax('<%=dept.getDeptno()%>')"><%=dept.getDeptname() %></span>
			<ul>
				<!-- <li><span class="file">장동건</span></li> -->
			</ul>
		</li>
	<%} %>
		<!-- jquery plugin으로 tree -->
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