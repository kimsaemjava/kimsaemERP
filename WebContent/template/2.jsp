<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="/kimsaemERP/common/css/main.css" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
	/* Remove the navbar's default margin-bottom and rounded borders */
	.navbar {
		margin-bottom: 0;
		border-radius: 0;	
	}
	/*  #toparea{
		padding: 30px;
	}  */
	/* body{
		background-color: #edeef1
	} */
</style>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/template/top.jsp"></jsp:include>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
			<%System.out.println("뷰정보=>"+request.getAttribute("menupath")); %>
				<jsp:include page="${menupath }"></jsp:include>
			</div>
			<div class="col-sm-10">
				<jsp:include page="${viewpath }"></jsp:include>
			</div>
		</div>	
	</div>
</body>
</html>