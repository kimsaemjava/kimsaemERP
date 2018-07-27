<%@page import="erp.dto.MemberDTO"%>
<%@page import="erp.dto.LoginDTO"%>
<%@page import="erp.dto.DeptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>jQuery treeview</title>

<link rel="stylesheet" href="/kimsaemERP/common/css/jquery.treeview.css" />
<!-- <link rel="stylesheet" href="/kimsaemERP/common/css/screen.css" /> -->
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script> -->
<script src="/kimsaemERP/common/js/jquery.treeview.js"
	type="text/javascript"></script>
<script src="/kimsaemERP/common/js/query.cookie.js"></script>
<script type="text/javascript" src="/kimsaemERP/common/js/demo.js"></script>
<script type="text/javascript">
	var xhr
	var deptno = "";
	function runAjax(mydeptno) {
		//매번 부서명을 클릭할 때마다 runAjax가 호출되고 mydeptno로 클릭한 부서의 부서번호가 전달된다.
		deptno = mydeptno; //뒤에서 id명으로 사용할 값
		//alert("test");
		//alert(mydeptno);
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				//정상처리되면 ajax요청의 결과로 서블릿에서 보내준 데이터를 가지고 들어온다.
				// alert(xhr.responseText); //html, text, json

				//서버로부터 전달된 json형식의 문자열을 파싱해서 자바스크립트에서 제어할 수 있는 JSON객체로 변환
				var myjsonObj = JSON.parse(xhr.responseText);
				//alert(myjsonObj.emplist[0].name);

				//작업중인 객체 구하기 - 작업중인 객체에 하위로 접근
				deptnode = document.getElementById(deptno);

				//myjsonObj.emplist에 저장된 JSONObject를 하나씩 꺼내서 i에 할당
				//deptchildes = deptnode.childNodes;
				mydata = "";
				for (i in myjsonObj.emplist) {
					mydata = mydata + "<li><span class='file' onclick=empInfo('"+myjsonObj.emplist[i].id+"')>"
							+ myjsonObj.emplist[i].name + "</span></li>";
					/* mydata = mydata + "<li><span class='file'>"
						+ myjsonObj.emplist[i].name + "</span></li>"; */
				}
				deptnode.innerHTML = mydata;
			}
		}
		xhr.open("GET", "/kimsaemERP/ajaxtreedata?deptno="+ mydeptno,true);
		xhr.send();
	}
	
	//emp정보를 ajax로 요청
	function empInfo(myid) {
		//alert(myid);
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				mydiv = document.getElementById("empinfo");
				mydiv.setAttribute("style", "display:block");
				
				var emp = JSON.parse(xhr.responseText);
				
				image = "/kimsaemERP/images/"+emp.profile_photo;
				document.getElementById("userImage").src = image;
				document.getElementById("deptno").innerHTML = emp.deptno;
				document.getElementById("name").innerHTML = emp.name;
				document.getElementById("id").innerHTML = emp.id;
				document.getElementById("position").innerHTML = emp.position;
				document.getElementById("duty").innerHTML = emp.duty;
			}
		}
		xhr.open("GET", "/kimsaemERP/getempinfo.do?id="+ myid,true);
		xhr.send();
	}
</script>
</head>
<body>
	<%
		ArrayList<DeptDTO> deptList = (ArrayList<DeptDTO>) request.getAttribute("deptList");
		int size = deptList.size();
	%>
	<h1>KimsaemJavaNara조직도</h1>
	<div id="deptlist" style="margin: 20px" class="col-sm-6">
		<ul id="browser" class="filetree">
			<%
				for (int i = 0; i < size; i++) {
					DeptDTO dept = deptList.get(i);
			%>
			<li class="closed"><span class="folder"
				onclick="runAjax('<%=dept.getDeptno()%>')"> <%=dept.getDeptname()%></span>
				<ul id="<%=dept.getDeptno()%>"></ul>
			</li>
			<%
				}
			%>
			<!-- <li><span class="folder">Folder 2</span>
			<ul>
				<li><span class="folder">Subfolder 2.1</span>
					<ul id="folder21">
						<li><span class="file">File 2.1.1</span></li>
						<li><span class="file">File 2.1.2</span></li>
					</ul>
				</li>
				<li><span class="file">File 2.2</span></li>
			</ul>
		</li>
		<li class="closed"><span class="folder">Folder 3 (closed at start)</span>
			<ul>
				<li><span class="file">File 3.1</span></li>
			</ul>
		</li>
		<li><span class="file">File 4</span></li> -->
		</ul>
	</div>

	<div style="margin-top: 20px; height: 400px; display:none; "
		class="col-sm-5" id="empinfo" >

		<form role="form" class="form-horizontal"
			action="/kimsaemERP/emp/update.do" method="POST" name="myform">
			<fieldset>
				<div id="legend">
					<legend>선택한 사원의 기본 정보입니다.</legend>
				</div>
				<div class="form-group">
					<p class="col-sm-4">
						<img src="" id="userImage" style="width: 90px">
					</p>
					<div class="col-sm-8" style="color: blue;">직원 정보가 보여지는 곳으로
						수정을 원하시면 부서별인사조회를 선택하고 작업하세요.</div>

				</div>
				<div class="form-group">
					<!-- 부서코드 -->
					<label class="control-label col-sm-4" for="orgcode">부서코드</label>
					<div class="control-label col-sm-4" id="deptno">
						<!-- 여기에 부서코드를 출력하세요  -->
					</div>
				</div>
				<div class="form-group">
						<!-- 부서코드 -->
						<label class="control-label col-sm-4" for="orgcode">부서명</label>
						<div class="control-label col-sm-3">
							<!-- 여기에 부서명을 출력하세요  -->
						</div>
				</div>
				<div class="form-group">
					<!-- 성명-->
					<label class="control-label col-sm-4" for="name">성명</label>
					<div class="control-label col-sm-4" id="name">
					</div>
				</div>
				<div class="form-group">
					<!-- 사번-->
					<label class="control-label col-sm-4" for="id">사번</label>
					<div class="control-label col-sm-4" id="id">
						<!-- 여기에 사번을 출력하세요  -->
					</div>
					<span id="checkVal"></span>
				</div>
				<div class="form-group">
					<!-- 직위-->
					<label class="control-label col-sm-4" for="birthday">직위</label>
					<div class="control-label col-sm-4" id="position">
						<!-- 여기에 직위 출력하세요  -->
					</div>
				</div>
				<div class="form-group">
					<!-- 직책-->
					<label class="control-label col-sm-4" for="birthday">직책</label>
					<div class="control-label col-sm-4" id="duty">
						<!-- 여기에 직책 출력하세요  -->
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>