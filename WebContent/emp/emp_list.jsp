<%@page import="erp.dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<%
	ArrayList<MemberDTO> userlist =(ArrayList<MemberDTO>) request.getAttribute("userlist");
	int size  = userlist.size();
	System.out.println("jsp"+userlist);
%>
<title>Bootstrap Example</title>
<meta charset="euc-kr">

</head>
<body>

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
				<%for(int i=0;i<size;i++){ 
					MemberDTO user = userlist.get(i);%>
				<tr>
					<td><%=user.getId() %></td>
					<td><%=user.getName() %></td>
					<td><%=user.getDeptname() %></td>
					<td><%=user.getDuty()%></td>
					<td><a href="#">직원보기</a></td>
					<td><a href="#"><%=user.getPhoneco()%></a></td>
				</tr>
				<%} %>
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
