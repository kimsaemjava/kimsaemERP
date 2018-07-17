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
	<jsp:include page="/template/top.jsp"/>
	<div style="background-color: #edeef1;padding: 20px;height: 800px" id="main">
		<div class="container" style="margin: 0px">
			<div class="row" >
			  <div class="col-sm-8">
			    <div id="myCarousel" class="carousel slide"  data-ride="carousel" style="width:600px;height: 300px ">
			      <!-- Indicators -->
			      <ol class="carousel-indicators">
			        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			        <li data-target="#myCarousel" data-slide-to="1"></li>
			        <li data-target="#myCarousel" data-slide-to="2"></li>
			        <li data-target="#myCarousel" data-slide-to="3"></li>
			      </ol>
			
			      <!-- Wrapper for slides -->
			      <div class="carousel-inner" role="listbox" >
			        <div class="item active" >
			          <img src="/kimsaemERP/images/kitri1.jpg" alt="Image" style="width: 600px;height:300px">
			         
			        </div>
			
			        <div class="item">
			          <img src="/kimsaemERP/images/kitri2.jpg" alt="Image" style="width: 800px;height: 300px">
			       
			        </div>
			        <div class="item" >
			          <img src="/kimsaemERP/images/kitri3.jpg" alt="Image" style="width: 600px;height:300px">
			         
			        </div>
			
			        <div class="item">
			          <img src="/kimsaemERP/images/kitri4.jpg" alt="Image" style="width: 800px;height: 300px">
			       
			        </div>
			      </div>
			
			      <!-- Left and right controls -->
			      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
			        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			        <span class="sr-only">Previous</span>
			      </a>
			      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
			        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			        <span class="sr-only">Next</span>
			      </a>
			    </div>
			  </div>
			    <div class="col-sm-4"> 
			      <div class="panel panel-primary" style="border-color:#edeef1;height: 300px;width: 330px ">
			        <div class="panel-footer">사내소식</div>
			        <div class="panel-body">
			        	<ul class="nav nav-tabs">
						   <li  class="active"><a href="#">최근게시판</a></li>
						   <li><a href="#">업무공지</a></li>
						   <li><a href="#">경조사</a></li>
						</ul>
						<div id="boardMain" style="padding-top: 20px;padding-left: 10px">
							<table>
								<tr>
									<td class="boardContent" style="">mini프로젝트 개최</td>
									<td class="boardDate" style="">2018.07.13</td>
								</tr>
								<tr>
									<td class="boardContent" style="">kimsaemERP ver1.0출시	</td>
									<td class="boardDate" style="">2018.07.12</td>
								</tr>
								<tr class="boardRow">
									<td class="boardContent" >사옥 이전날짜 확정</td>
									<td class="boardDate">2018.07.11</td>
								</tr>
								<tr class="boardRow">
									<td class="boardContent" >보안의 날 참석 인원 확정</td>
									<td class="boardDate">2018.07.11</td>
								</tr>
								<!-- <tr class="boardRow">
									<td class="boardContent" >2차 프로젝트 발표 날짜 확정 통보</td>
									<td class="boardDate">2018.07.10</td>
								</tr> -->
							</table>
						</div>
			        </div>
			      </div>
	   			</div> 	
			</div>
			<hr/>
			<div class="row main-row">
				<div class="col-sm-3"> 
			      <div class="panel panel-primary" style="border-color:#edeef1;height: 300px ">
			        <div class="panel-footer">News</div>
			        <div class="panel-body">
			        
			        </div>
			      </div>
	   			</div> 	
	   			<div class="col-sm-3"> 
			      <div class="panel panel-primary" style="border-color:#edeef1;height: 300px ">
			        <div class="panel-footer">회사소식</div>
			        <div class="panel-body">
			        
			        </div>
			      </div>
	   			</div> 	
	   			<div class="col-sm-3"> 
			      <div class="panel panel-primary" style="border-color:#edeef1;height: 300px ">
			        <div class="panel-footer">회사소식</div>
			        <div class="panel-body">
			        
			        </div>
			      </div>
	   			</div> 	
	   			<div class="col-sm-3"> 
			      <div class="panel panel-primary" style="border-color:#edeef1;height: 300px ">
			        <div class="panel-footer">회사소식</div>
			        <div class="panel-body">
			        
			        </div>
			      </div>
			</div>
		</div>
		</div>
	</div>
</body>
</html>