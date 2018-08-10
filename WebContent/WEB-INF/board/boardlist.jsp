<%@page import="erp.dto.LoginDTO"%>
<%@page import="spring.erp.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="euc-kr">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<% 
	LoginDTO loginUser = (LoginDTO)session.getAttribute("loginUser");
	List<BoardDTO> boardlist = (List<BoardDTO>)request.getAttribute("boardlist");
	int size = boardlist.size();
	BoardDTO board = null;
%>
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<%for(int i=0; i<size; i++){ 
					board = boardlist.get(i);%>
					<tr>
						<td><%=board.getBoardno() %></td>
						<td><a href="/kimsaemERP/board/read.do?boardno=<%=board.getBoardno()%>">[<%=board.getBoardctg() %>]<%=board.getBoardtitle() %></a></td>
						<td><%=board.getId() %></td>
						<td><%=board.getBoarddate() %></td>
					</tr>
				<%} %>
			</tbody>
		</table>
		<div class="right">
		<a href="/kimsaemERP/board/write.do" class="btn btn-primary">
		<i class="glyphicon glyphicon-edit">글쓰기</i></a>
		</div>

</body>
</html>
