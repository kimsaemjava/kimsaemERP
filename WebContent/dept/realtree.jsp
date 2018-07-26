<%@page import="erp.dto.DeptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<link rel="stylesheet" href="/kimsaemERP/common/css/jquery.treeview.css" />
<!-- <link rel="stylesheet" href="/kimsaemERP/common/css/screen.css" /> -->
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script> -->
<script src="/kimsaemERP/common/js/jquery.treeview.js"
	type="text/javascript"></script>
<script src="/kimsaemERP/common/js/query.cookie.js"></script>
<script type="text/javascript" src="/kimsaemERP/common/js/demo.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".folder").on("click", function() {
			deptname = $(this).text().trim();
			//this의 다음노드로 접근
			ulnode = $(this).next();
			//ul노드의 id속성 값을 구하기
			deptno = $(ulnode).attr("id");
			//alert(deptno);
			$.get("/kimsaemERP/ajaxtreedata", {"deptno":deptno},getData,"json");
		});
		//동적으로 생성된 노드(ajax실행결과로 추가된 태그)에 이벤트를 연결하는 방법		
		//1번매개변수 - 이벤트시점, 2번매개변수 - 어떤 태그에 이벤트를 연결할 것 인지 정의
		//3번매개변수 - 이벤트가 발생할 때 실행할 함수
		$(document).on("click",".file",function(){
			alert("test");
		})
	})
	//jquery를 이용하면 json이 파싱되어 객체상태로 리턴된다.
	function getData(data){
		//alert(data.emplist[0].name);
		myli = "";
		for(i in data.emplist){
			myli = myli + "<li><span class='file' id='"+ data.emplist[i].id +"'>"
					+ data.emplist[i].name +"</span></li>";
		}
		$(ulnode).html(myli);
	}
</script>
</head>
<body>
<% 
	ArrayList<DeptDTO> deptList = (ArrayList<DeptDTO>)request.getAttribute("deptList");
	int size = deptList.size();
%>
	<h1>KimsaemJavaNara 조직도 - 계층구조표현(jquery)</h1>
	<div id="result"></div>
	<ul id="browser" class="filetree" >
		<%for(int i=0; i<size; i++){ 
			DeptDTO dept = deptList.get(i);%>
			<li class="closed">
				<span class="folder">
				<%=dept.getDeptname() %></span>
				<ul id="<%=dept.getDeptno()%>">
					<!-- <li><span class="file">장동건</span></li> -->
				</ul>
			</li>
		<%} %>
	</ul>
</body>
</html>