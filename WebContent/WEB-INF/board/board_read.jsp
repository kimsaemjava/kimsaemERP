<%@page import="spring.erp.dto.BoardDTO"%>
<%@page import="erp.dto.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" session="true"%>
<!DOCTYPE>
<html>
<head>
<title>�λ�����ý���</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">
function cancelCheck(){
	location.href="/kimsaemERP/board/list.do";
}
function deleteBoard(boardno){
	location.href="/kimsaemERP/board/delete.do?boardno="+boardno;
}
</script>
</head>
<body>
<% 
	BoardDTO board = (BoardDTO)request.getAttribute("board"); 
	/* LoginDTO loginUser = (LoginDTO)session.getAttribute("loginUser"); */
%>
	<form class="form-horizontal" action="/kimsaemERP/board/update.do" method="GET">

		<%-- <input type="hidden" name="id" id="id" value="<%=loginUser.getId()%>"> --%>
		<input type="hidden" name="boardno" id="boardno" value="<%=board.getBoardno()%>"> 
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="id" class="control-label">��ȣ</label>
			</div>
			<div class="col-md-8"><%=board.getBoardno() %></div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="id" class="control-label">�Խñ�����</label>
			</div>
			<div class="col-md-3">
				<select name="category" class="form-control">
					<option value="������" <%if(board.getBoardctg().equals("������")){%>selected="selected" <%}%>>������</option>
					<option value="�系�ҽ�" <%if(board.getBoardctg().equals("�系�ҽ�")){%>selected="selected" <%}%>>�系�ҽ�</option>
					<option value="�Խ���" <%if(board.getBoardctg().equals("�Խ���")){%>selected="selected" <%}%>>�Խ���</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="id" class="control-label">�ۼ���</label>
			</div>
			<div class="col-md-8"><%=board.getId() %></div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="title" class="control-label">����</label>
			</div>
			<div class="col-md-8"><%=board.getBoardtitle() %></div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="title" class="control-label">�ۼ���¥</label>
			</div>
			<div class="col-md-8"><%=board.getBoarddate() %></div>
		</div>
		<div class="form-group">
			<div class="col-md-2 text-right">
				<label for="text" class="control-label">����</label>
			</div>
			<div class="col-md-8"
				style="width: 500px; height: 400px; border: solid 1px;"><%=board.getBoardtxt() %></div>
		</div>

		<div class="form-group">
			<div class="col-md-10 text-center">
				<input type="submit" class="btn btn-lg btn-primary" value="����">
				<input type="button" class="btn btn-lg btn-primary" 
					onclick="deleteBoard(<%=board.getBoardno() %>)" value="����">
				<button type="button" class="btn btn-danger btn-lg"
					onclick="javascript:cancelCheck()">
					<i class="fa fa-fw fa-close"></i> ���
				</button>
			</div>
		</div>
	</form>

</body>
</html>