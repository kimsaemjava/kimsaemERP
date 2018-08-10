<%@page import="erp.dto.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link href="/kimsaemERP/common/css/font-awesome.css" rel="stylesheet" />
<!-- Custom styles for this template -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		LoginDTO loginUser = (LoginDTO)session.getAttribute("loginUser");
	%>
	<h4>
		<i class="fa fa-angle-right"></i> �Խñ� �ۼ��ϱ�
	</h4>
	<hr>
	<div class="row mt">
		<div class="col-lg-12">
			<div class="form-panel">
				<form class="form-horizontal style-form" action="" method="post">
					<div class="form-group" style="border: 1px solid #eff2f7;">
						<label class="col-sm-2 col-sm-2 control-label">�ۼ���</label>
						<div class="col-sm-10">
							<p class="form-control-static"><%=loginUser.getId() %></p>
						</div>	
						<input type="hidden" name="id" value="<%=loginUser.getId() %>"/>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">�Խñ� ����</label>
	
							<div class="col-sm-5">
								<select name="boardctg" class="form-control">
									<option value="������">������</option>
									<option value="�系�ҽ�">�系�ҽ�</option>
									<option value="�Խ���">�Խ���</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">����</label>
							<div class="col-sm-8">
								<input type="text" class="form-control"
										 name="boardtitle">
								<span class="help-block">�Խñ� ������ �´� �������� �ۼ� ��Ź�帳�ϴ�. </span>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label">����</label>
							<div class="col-sm-8">
								<textarea id="boardtxt"
									style="width: 100%; border: 1; overflow: visible; text-overflow: ellipsis;"
									rows=15 name="boardtxt">���ۼ�</textarea>

							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-4 text-center"></div>
							<div class="col-lg-2 text-center">
								<button type="submit" class="btn btn-success"
									style="width: 100px; background-color: #0ea006">���</button>
							</div>
							<div class="col-lg-2 text-center">
								<button type="reset" class="btn btn-default"
									style="width: 100px; background-color: #9a9a9a">���</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>