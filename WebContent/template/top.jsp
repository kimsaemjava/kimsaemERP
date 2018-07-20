<%@page import="erp.dto.loginDTO"%>
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
	<% loginDTO loginUser = (loginDTO) session.getAttribute("loginuser");%>
	<div style="height:90px" style="padding:10px">
		<div id="toparea"  class="navbar navbar-inverse">
			<a href="#" style="position:absolute;top:30px;font-size: 18pt; font-weight: bolder;text-decoration: none;padding-left: 10px">KimSaemERP</a>
			<ul class="nav navbar-nav navbar-right"  style="position:relative ;top:20px" >
				<!-- <li ><a href="#"><span></span><img  class="img-circle"
							src="/kimsaemERP/images/kim.jpg"  style="width: 70px;height: 70px;padding: 0px"/>
							</a></li> -->
				<% if(loginUser==null){ %>
				<li style="width: 60px;height: 60px;"><a href="/kimsaemERP/view.html?menupath=/menu/pub_menu.jsp&viewpath=/emp/login.jsp"><span class="glyphicon glyphicon-log-in">
						</span>Login</a></li>
				<%}else{ %>
				<li style="padding-bottom: 28px"><img  class="img-circle" style="width: 60px;height: 60px;"
							src="/kimsaemERP/images/<%=loginUser.getProfile_photo() %>"/></li>
				<li><a href="/kimsaemERP/logout.do"><span class="glyphicon glyphicon-log-out" ></span>
						Logout</a></li>
				<%} %>
			</ul>
			<form class="navbar-form pull-right" style="position:relative ;top:20px">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				
			</form>
			
		</div>
		
	</div>
	<nav>
	<div class="container-fluid">
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/kimsaemERP/index.jsp">Home</a></li>
					<li><a href="/kimsaemERP/forward.do">업무관리</a></li>
					<li><a href="#">자원관리</a></li>
					<li><a href="/kimsaemERP/view.html?menupath=/menu/board_menu.jsp&viewpath=/board/boardlist.jsp">커뮤니티</a></li>
					<li><a href="#">일정관리</a></li>
					<li><a href="#">휴가관리</a></li>
					<li><a href="#">결재</a></li>
				</ul>

			</div>
		</div>
	</nav>
</body>
</html>