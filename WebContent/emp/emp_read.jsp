<%@page import="emp.dto.EmpDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
			<form role="form" class="form-horizontal"
		action="/serverweb/action?deptno=<%= "001" %>&state=UPDATE" 
		method="get">
	<% 
		EmpDTO user = (EmpDTO)request.getAttribute("user"); 
	%>	
				<fieldset>
					<div id="legend">
						<legend>아래 양식을 작성해주세요.</legend>
					</div>
					<div class="form-group">
						<!-- 부서코드 -->
						<label class="control-label col-sm-2" for="deptcode">부서코드</label>
						<div class="col-sm-3">
							<%=user.getDeptno()%>
						</div>
					</div>
					
					<div class="form-group">
						<!-- 부서명-->
						<label class="control-label col-sm-2" for="name">성명</label>
						<div class="col-sm-3">
							<!-- 성명을 이곳에 출력하세요 -->
							<%=user.getName() %>
						</div>
					</div>

					<div class="form-group">
						<!-- 아이디-->
						<label class="control-label col-sm-2" for="id">아이디</label>
						<div class="col-sm-3">
							<!-- 아이디를 이곳에 출력하세요 -->
							<%=user.getId() %>
						</div>
					</div>
					<div class="form-group">
						<!-- 주소-->
						<label class="control-label col-sm-2" for="addr">주소</label>
						<div class="col-sm-3">
							<!-- 주소를 이곳에 출력하세요 -->
							<%=user.getAddr() %>
						
						</div>
					</div>

					<div class="form-group">
						<!-- 입사날짜-->
						<label class="control-label col-sm-2" for="hiredate">입사날짜</label>
						<div class="col-sm-3">
							<!-- 입사날짜를 이곳에 출력하세요 -->
							<%=user.getHiredate()%>
							
						</div>
					</div>
					
					<div class="form-group">
						<!-- 포인트-->
						<label class="control-label col-sm-2" for="point">포인트</label>
						<div class="col-sm-3">
							<!-- 포인트를 이곳에 출력하세요 -->
							<%=user.getPoint()%>
						</div>
					</div>
					
					<div class="form-group">
						<!-- 등급-->
						<label class="control-label col-sm-2" for="grade">등급</label>
						<div class="col-sm-3">
							<!-- 등급을 이곳에 출력하세요 -->
							<%=user.getGrade() %>
							
						</div>
					</div>
					
					<div class="form-group">
						<!-- Button -->
						<div class="col-sm-3 col-sm-offset-2">
							<input type="button" value="수정" class="btn btn-success"
							 onclick="location.href='/serverweb/emp/read.do?id=<%=user.getId()%>&action=UPDATE'"/>
						</div>
					</div>
				</fieldset>
			</form>
	</div>
</body>
</html>