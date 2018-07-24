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
<!--  <link rel="stylesheet" href="/kimsaemERP/common/css/screen.css" />  -->
<!-- <script src="/kimsaemERP/common/js/jquery.cookie.js"></script> -->
<script src="/kimsaemERP/common/js/jquery.treeview.js"></script>

<script type="text/javascript" src="/kimsaemERP/common/js/demo.js"></script>
<%
 ArrayList<DeptDTO> deptnamelist =(ArrayList<DeptDTO>) request.getAttribute("deptnamelist");
	int size  = deptnamelist.size();
	System.out.println("jsp"+deptnamelist);
 %>
</head>
<body>
	<h1>KimSaemJavaNara조직도</h1>
	<div id="deptlist" style="margin: 20px">
		<ul id="browser" class="filetree">
			<%for(int i=0;i<size;i++){
				DeptDTO dept = deptnamelist.get(i);
			%>
			<li class="closed"><span class="folder"><%= dept.getDeptname() %></span>
				 <ul>
				
				
				</ul> 
				<!--  <ul>
					<li><span class="file">장동건</span></li>
				</ul>  -->
			</li>
		    <%} %>
			<!-- 		<li>
		<span class="folder">Folder 2</span>
				<ul>
					<li><span class="folder">Subfolder 2.1</span>
						<ul id="folder21">
							<li><span class="file">File 2.1.1</span></li>
							<li><span class="file">File 2.1.2</span></li>
						</ul></li>
					<li><span class="file">File 2.2</span></li>
				</ul>
		</li>
		<li class="closed">
			<span class="folder">Folder 3 (closedat start)</span>
			<ul>
				<li><span class="file">File 3.1</span></li>
			</ul>
		</li>
		<li><span class="file">File 4</span></li> -->
		</ul>
	</div>
</body>
</html>