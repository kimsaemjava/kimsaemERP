<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="erp.dto.DeptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="erp.dto.LoginDTO"%>
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
 <% LoginDTO user = 
				(LoginDTO) session.getAttribute("loginUser"); %>
</head>
<body>
	<h1>KimSaemJavaNara조직도</h1>
	
	<div id="deptlist" style="margin: 20px" class="col-sm-6">
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
	<div style="margin-top:20px; height: 400px;display: none;" class="col-sm-5">
	
				<form role="form" class="form-horizontal"
				action="/kimsaemERP/emp/update.do" method="POST" 
				name="myform">
				<fieldset>
					<div id="legend">
						<legend>선택한 사원의 기본 정보입니다.</legend>
					</div>
					<div class="form-group" >
						<p class="col-sm-4">
							<img src="/kimsaemERP/images/<%=user.getProfile_photo() %>" 
							 id="userImage" style="width: 100px">
						</p>
						<div class="col-sm-7" style="color: blue;">
							직원 정보가 보여지는 곳으로 수정을 원하시면 부서별인사조회를 선택하고 작업하세요.
						</div>
				
					</div>
					<div class="form-group">
						<!-- 부서코드 -->
						<label class="control-label col-sm-4" for="orgcode">부서코드</label>
						<div class="control-label col-sm-3">
							<!-- 여기에 부서코드를 출력하세요  -->
							<%= user.getDeptno() %>
						</div>
					</div>
					<div class="form-group">
						<!-- 부서코드 -->
						<label class="control-label col-sm-4" for="orgcode">부서명</label>
						<div class="control-label col-sm-3">
							<!-- 여기에 부서코드를 출력하세요  -->
							<%= user.getDeptname() %>
						</div>
					</div>
		
					<div class="form-group">
						<!-- 성명-->
						<label class="control-label col-sm-4" for="name">성명</label>
						<div class="control-label col-sm-3">
							<%= user.getName()%>
						</div>
					</div>
					<div class="form-group">
						<!-- 사번-->
						<label class="control-label col-sm-4" for="id">사번</label>
						<div class="control-label col-sm-3">
							<!-- 여기에 사번을 출력하세요  -->
							<%= user.getId() %>
						</div>
						<span id="checkVal"></span>
					</div>
				
				
					<div class="form-group">
						<!-- 직위-->
						<label class="control-label col-sm-4" for="birthday">직위</label>
						<div class="control-label col-sm-3">
							<!-- 여기에 직위 출력하세요  -->
							<%= user.getPosition()%>
						</div>
					</div>
					<div class="form-group">
						<!-- 직책-->
						<label class="control-label col-sm-4" for="birthday">직책</label>
						<div class="control-label col-sm-3">
							<!-- 여기에 직책 출력하세요  -->
							<%= user.getDuty()%>
						</div>
					</div>
				
				
				
				</fieldset>
			</form></div>
</body>
</html>