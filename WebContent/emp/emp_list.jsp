<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.ArrayList, erp.dto.LoginDTO"%>
<!DOCTYPE html>
<html>
<head>
<%
	String str = "test";
%>
<title>Bootstrap Example</title>
<meta charset="euc-kr">

</head>
<body>
	<%
		ArrayList<LoginDTO> empList = (ArrayList<LoginDTO>) request.getAttribute("empList");
	%>
	<div>
		<br />
		<br />
		<p>인사목록</p>
		<table class="table">
			<thead>
				<tr>
					<th>아이디</th>
					<th>성명</th>
					<th>부서명</th>
					<th>직책</th>
					<th>직원보기</th>
					<th>사내번호</th>
				</tr>
			</thead>
			<tbody>
			<%
			int size = empList.size();
			for (int i = 0; i < size; i++) {
				LoginDTO emp = empList.get(i);
			%>
				<tr>
					<td><a href="#"><%=emp.getId()%></a></td>
					<td><%=emp.getName()%></td>
					<td><%=emp.getDeptname() %></td>
					<td><%=emp.getDuty() %></td>
					<td><a href="#">직원보기</a></td>
					<td><%=emp.getPhoneco() %></td>
				</tr>
<% } %> 	
			</tbody>
		</table>
		<ul class="pagination" style="">
			<li><a href="#" aria-label='Previous'>&laquo;</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li class="disabled"><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#" aria-label='Next'>&raquo;</a></li>
		</ul>
	</div>

</body>
</html>
