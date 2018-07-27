<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="erp.dto.DeptDTO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<link rel="stylesheet" 
		href="/kimsaemERP/common/css/jquery.treeview.css" />
	<!-- <link rel="stylesheet" 
			href="/kimsaemERP/common/css/screen.css" /> -->

	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script> -->
	<script src="/kimsaemERP/common/js/jquery.cookie.js"></script>
	<script src="/kimsaemERP/common/js/jquery.treeview.js"></script>

	<script type="text/javascript" 
		src="/kimsaemERP/common/js/demo.js"></script>
	<%
	 ArrayList<DeptDTO> deptnamelist =
	 	(ArrayList<DeptDTO>) request.getAttribute("deptnamelist");
	 int size  = deptnamelist.size();
	 System.out.println("jsp"+deptnamelist);
 %>
 
	<script type="text/javascript">
		$(document).ready(function(){
			$(".folder").on("click",function(){
				deptname = $(this).text().trim();//공백제거
				ulnode = $(this).next();
				deptno = $(ulnode).attr("id");
				$.get("/kimsaemERP/ajaxtreedata",
						{"deptno":deptno},getData,"json");
			});
	
			$(document).on("click",".file",function(){
				id = $(this).attr("id");
				alert("test:"+id)
			})
		})
		//jquery를 이용하면 json이 파싱되어 객체상태로 리턴된다.
		function getData(data){
			//alert(data.emplist[0].name)
			myli = "";
			for(i in data.emplist){
				myli = myli+ "<li><span class='file' id='"+ 
				data.emplist[i].id +"'>"
				+ data.emplist[i].name + "</span></li>";
			}
			$(ulnode).html(myli);
		}
	</script>
</head>
<body>
<h2>kimsaemJavaNara조직도 - 계층구조표현(jquery)</h2>
	<div  style="margin: 20px" class="col-sm-6">
		<ul id="browser" class="filetree">
			<%for(int i=0;i<size;i++){
				DeptDTO dept = deptnamelist.get(i);	%>
				<li class="closed">
					<span class="folder">
						<%= dept.getDeptname() %></span>
					<ul id="<%=dept.getDeptno()%>">
	
					</ul>
				</li>
			<%} %>
		</ul>
	</div>
</body>
</html>