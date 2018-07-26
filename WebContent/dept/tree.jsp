<%@page import="erp.dto.DeptDTO"%>
<%@page import="erp.dto.LoginDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/kimsaemERP/common/css/jquery.treeview.css" />
	<!-- <link rel="stylesheet" href="/kimsaemERP/common/css/screen.css" /> -->

	<!-- 메인에 js가 있으므로 버전 충돌이 일어남으로 주석 -->
	<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>-->
	<script src="/kimsaemERP/common/js/jquery.cookie.js"></script>
	<script src="/kimsaemERP/common/js/jquery.treeview.js"></script>

	<script type="text/javascript" src="/kimsaemERP/common/js/demo.js"></script>
	
	<script type="text/javascript">
	
		deptno = "";
 		function runAjax(mydeptno){
 			// 매번 부서명을 클릭할 때마다 runAjax가 호출되고 mydeptno로 클릭한 부서의 부서번호가 전달된다.
 			deptno = mydeptno;		// 뒤에서 id명으로 사용할 값(li class="closed"의 id)
 			xhr = new XMLHttpRequest();
			xhr.onreadystatechange = readyCallback;
			xhr.open("GET", "/kimsaemERP/ajaxtreedata?deptno="+mydeptno,true);
			xhr.send();	
 		}
 		function readyCallback(){
 			if(xhr.readyState==4 && xhr.status==200){
 				// 정상처리되면 ajax요청의 결과로 서블릿에서 보내준 데이터를 가지고 돌아온다.
 				alert(xhr.responseText);	// html, text, json
 				
 				// 서버로부터 전달된 json형식의 문자열을 파싱해서 자바스크립트에서 제어할 수 있는 JSON객체로 변환
 				var myjsonObj = JSON.parse(xhr.responseText);
 				// alert(myjsonObj.emplist[0].name);
 				
 				// 작업중인 객체를 구하기 - 작업중인 객체의 하위로 접근 (시간이 오래 걸릴 수 있어서 쉽게 접근하는 방법으로 감)
 				/* 
 				deptnode = document.getElementById(deptno);
 				deptChildes = deptnode.childNodes;
 				alert(deptChildes.length); */
 				
 				// myjsonObj.emplist에서 하나씩 객체르 꺼내서 i에 전달하고 
 				// myjsonObj.emplist안에 저장된 object의 갯수만큼  for문이 실행
 				/* for(i in myjsonObj.emplist){
 				} */
 				
 				// 해당 ul노드에 json객체에서 추출한 name을 추가하기 - innerHTML
 				deptnode = document.getElementById(deptno);
 				
 				mydata = "";
 				// myjsonObj.emplist에 저장된 JSONObject를 하나씩 꺼내서 i에 할당
 				for(i in myjsonObj.emplist){
 					mydata = mydata + "<li><span class='file' onclick=empInfo('"+myjsonObj.emplist[i].id+"')>"+myjsonObj.emplist[i].name+"</span></li>";
 				}
 				deptnode.innerHTML = mydata;
 			}
 		}
 		
 		// emp정보를 ajax로 요청
 		function empInfo(empid){
 			alert(empid);
 			alert("요청성공 : "+empid);
 			alert(xhr.responseText);
 			xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4 && xhr.status==200){
	 				var myjsonObj = JSON.parse(xhr.responseText);
	 				deptno = document.getElementById("empdeptno");
	 				deptname = document.getElementById("empdeptname");
	 				empname = document.getElementById("empname");
	 				empno = document.getElementById("empno");
	 				empposition = document.getElementById("empposition");
	 				empduty = document.getElementById("empduty");
	 				
	 				image = document.getElementById("userImage");
	 				image.src = myjsonObj.profile_photo;
	 				
	 				deptno.innerHTML = myjsonObj.deptno;
	 				deptname.innerHTML = myjsonObj.deptname;
	 				empname.innerHTML = myjsonObj.name;
	 				empno.innerHTML = myjsonObj.id;
	 				empposition.innerHTML = myjsonObj.position;
	 				empduty.innerHTML = myjsonObj.duty;
				}
			}
			xhr.open("GET", "/kimsaemERP/empinfo?id="+empid,true);
			xhr.send();	 
 		}
	</script>
	<%
		ArrayList<DeptDTO> deptnamelist = (ArrayList<DeptDTO>) request.getAttribute("deptnamelist");
		int size = deptnamelist.size();
		// System.out.println("jsp" + deptnamelist);
	%>
	<%
		LoginDTO user = (LoginDTO) session.getAttribute("loginUser");
	%>
</head>
<body>
	<h1>kimsaemJavaNara조직도</h1>

	<div id="deptlist" style="margin: 20px" class="col-sm-6">
		<ul id="browser" class="filetree">
			<%
				for (int i = 0; i < size; i++) {
					DeptDTO dept = deptnamelist.get(i);
			%>
			<li class="closed"><span class="folder"
				onclick="runAjax('<%=dept.getDeptno()%>')"><%=dept.getDeptname()%></span>
				<ul id="<%=dept.getDeptno()%>">
					<!-- <li><span class="file">장동건</span></li> -->
				</ul></li>
			<%
				}
			%>
		</ul>
	</div>


	<div style="margin-top: 20px; height: 400px;"
		class="col-sm-5">

		<form role="form" class="form-horizontal"
			action="/kimsaemERP/emp/update.do" method="POST" name="myform">
			<fieldset>
				<div id="legend">
					<legend>선택한 사원의 기본 정보입니다.</legend>
				</div>
				<div class="form-group">
					<p class="col-sm-4">
						<img src="/kimsaemERP/images/<%=user.getProfile_photo() %>"
							id="userImage" style="width: 100px">
					</p>
					<div class="col-sm-7" style="color: blue;">직원 정보가 보여지는 곳으로
						수정을 원하시면 부서별인사조회를 선택하고 작업하세요.</div>

				</div>
				<div class="form-group">
					<!-- 부서코드 -->
					<label class="control-label col-sm-4" for="orgcode">부서코드</label>
					<div class="control-label col-sm-3" id="empdeptno">
						<!-- 여기에 부서코드를 출력하세요  -->
					</div>
				</div>
				<div class="form-group">
					<!-- 부서코드 -->
					<label class="control-label col-sm-4" for="orgcode">부서명</label>
					<div class="control-label col-sm-3" id="empdeptname">
						<!-- 여기에 부서코드를 출력하세요  -->
					</div>
				</div>

				<div class="form-group">
					<!-- 성명-->
					<label class="control-label col-sm-4" for="name">성명</label>
					<div class="control-label col-sm-3" id="empname">
					</div>
				</div>
				<div class="form-group">
					<!-- 사번-->
					<label class="control-label col-sm-4" for="id">사번</label>
					<div class="control-label col-sm-3" id="empno">
						<!-- 여기에 사번을 출력하세요  -->
					</div>
					<span id="checkVal"></span>
				</div>


				<div class="form-group">
					<!-- 직위-->
					<label class="control-label col-sm-4" for="birthday">직위</label>
					<div class="control-label col-sm-3" id="empposition">
						<!-- 여기에 직위 출력하세요  -->
					</div>
				</div>
				<div class="form-group">
					<!-- 직책-->
					<label class="control-label col-sm-4" for="birthday">직책</label>
					<div class="control-label col-sm-3" id="empduty">
						<!-- 여기에 직책 출력하세요  -->
					</div>
				</div>



			</fieldset>
		</form>
	</div>

</body>
</html>