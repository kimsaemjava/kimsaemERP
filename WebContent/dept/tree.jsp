<%@page import="erp.dto.LoginDTO"%>
<%@page import="erp.dto.DeptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>jQuery treeview</title>

<link rel="stylesheet" href="/kimsaemERP/common/css/jquery.treeview.css" />
<!-- <link rel="stylesheet" href="/kimsaemERP/common/css/screen.css" /> -->

<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script> -->
<script src="/kimsaemERP/common/js/jquery.cookie.js"></script>
<script src="/kimsaemERP/common/js/jquery.treeview.js"
	type="text/javascript"></script>
<script src="/kimsaemERP/common/js/demo.js" type="text/javascript"></script>

<script type="text/javascript">
	function runAjax(mydeptno) {
		//¸Å¹ø ºÎ¼­¸íÀ» Å¬¸¯ÇÒ¶§¸¶´Ù runAjax°¡ È£ÃâµÇ°í mydeptno·Î Å¬¸¯ÇÑ ºÎ¼­ÀÇ ºÎ¼­¹øÈ£°¡ Àü´ÞµÈ´Ù.
		deptno = mydeptno;	//µÚ¿¡¼­¸íÀ¸·Î »ç¿ëÇÒ °ª
		//alert(deptno);
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = readyCallback;
		xhr.open("GET", "/kimsaemERP/emptree.do?deptno="+deptno, true);
		xhr.send();
	}
	function readyCallback(){
		if (xhr.readyState == 4 && xhr.status == 200) {
			//alert(xhr.responseText);
			//html, txt, json ÀÎ °æ¿ì
			//¼­¹ö·ÎºÎÅÍ Àü´ÞµÈ json Çü½ÄÀÇ ¹®ÀÚ¿­À» ÆÄ½ÌÇØ¼­ ÀÚ¹Ù½ºÅ©¸³Æ®¿¡¼­ Á¦¾îÇÒ ¼ö ÀÖ´Â 
			// JSON °´Ã¼·Î º¯È¯
			var myjsonObj = JSON.parse(xhr.responseText);
			//alert(myjsonObj.emplist[0].name);
			//ÀÛ¾÷ÁßÀÎ°´Ã¼±¸ÇÏ±â - ÀÛ¾÷ÁßÀÎ °´Ã¼ÀÇ ÇÏÀ§·Î Á¢±Ù
/* 			deptnode = document.getElementById(mydeptno);
			deptchilds = deptnode.childNodes;
			alert(deptchilds.length);
			//myjsonObj.emplist ¿¡¼­ ÇÏ³ª¾¿ °´Ã¼¸¦ ²¨³»¼­ i¿¡ Àü´ÞÇÏ°í
			//myjsonObj.emplist ¾È+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++¿¡ ÀúÀåµÈ objectÀÇ °¹¼ö¸¸Å­ for¹®ÀÌ ½ÇÇà
			for(i in myjsonObj.emplist){
				
			} */
			//ÇØ´ç ul³ëµå¿¡ json °´Ã¼¿¡¼­ ÃßÃâÇÑ name À» Ãß°¡ÇÏ±â - innerHTML
			var deptnode = document.getElementById(deptno);
			//alert(myjsonObj.emplist.length)
			//myjsonObj.emplist¿¡ ÀúÀåµÈ JSONObject¸¦ ÇÏ³ª¾¿ ²¨³»¼­ i ¿¡ ÇÒ´ç
			mydata="";
			for (i in myjsonObj.emplist) {
				var id = myjsonObj.emplist[i].id;
					mydata = mydata+
					"<li><span class='file' onclick=empInfo('"+id+"')>"+
					myjsonObj.emplist[i].name+"</span></li></a>";
			}
			deptnode.innerHTML = mydata;
		}
		
	}
	
	
	//empÁ¤º¸¸¦ ajax·Î ¿äÃ»
	function empInfo(empid){
		id = empid
		alert("test:"+id);
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = readyCallback1;
		xhr.open("GET", "/kimsaemERP/getEmpInfo.do?id="+id, true);
		xhr.send();
	}
	
	function readyCallback1(){
		if (xhr.readyState == 4 && xhr.status == 200) {
			alert(xhr.responseText);
			var rootjson = JSON.parse(xhr.responseText);
			var deptnode = document.getElementById("deptno");
				deptnode.innerHTML = "<div>"+rootjson.empjson.deptno+"</div>";
			 	document.getElementById("name").innerHTML = "<div>"+rootjson.empjson.name+"</div>";
			 	document.getElementById("id").innerHTML = "<div>"+rootjson.empjson.id+"</div>";
			 	document.getElementById("position").innerHTML = "<div>"+rootjson.empjson.position+"</div>";
			 	document.getElementById("duty").innerHTML = "<div>"+rootjson.empjson.duty+"</div>";
		
		
		}
		
	}
	
	</script>
</head>
<%	ArrayList<DeptDTO> list = (ArrayList<DeptDTO>) request.getAttribute("list");
		 LoginDTO user = (LoginDTO)session.getAttribute("loginUser");
	%>
<body>

	<h1 id="banner">ERP Á¶Á÷µµ</h1>
	<div id="deptlist" class="col-sm-6" style="margin: 20px">
		<ul id="browser" class="filetree">
			<%	for (int i = 0; i < list.size(); i++) {	%>
			<li class="closed" id=""><span class="folder"
				onclick="runAjax('<%=list.get(i).getDeptno()%>')"><%=list.get(i).getDeptname()%></span>
				<ul id="<%=list.get(i).getDeptno()%>">
					<!-- 		<li><span id="result" class="file"></span></li> -->
				</ul> <%
					}
				%></li>
		</ul>
	</div>
	
	<div style="margin-top: 20px; height: 400px;"" class=col-sm-5">
		<form role="form" class="form-horizontal"
			action="/kimsaemERP/getEmpInfo.do" method="get" name="myform">
			<fieldset>
				<div id="legend">
					<legend>¼±ÅÃÇÑ »ç¿øÀÇ ±âº» Á¤º¸ÀÔ´Ï´Ù.</legend>
				</div>
				<div class="form-group">
					<p class="col-sm-4">
<%-- 						<img src="/kimsaemERP/images/<%=user.getProfile_photo() %>"
							id="userImage" style="width: 100px"> --%>
					</p>
					<div class="col-sm-7" style="color: blue;">Á÷¿ø Á¤º¸°¡ º¸¿©Áö´Â °÷À¸·Î
						¼öÁ¤À» ¿øÇÏ½Ã¸é ºÎ¼­º°ÀÎ»çÁ¶È¸¸¦ ¼±ÅÃÇÏ°í ÀÛ¾÷ÇÏ¼¼¿ä.</div>

				</div>
				<div class="form-group">
					<!-- ºÎ¼­ÄÚµå -->
					<label class="control-label col-sm-4" for="orgcode">ºÎ¼­ÄÚµå</label>
					<div class="control-label col-sm-3" id="deptno">
						<!-- ¿©±â¿¡ ºÎ¼­ÄÚµå¸¦ Ãâ·ÂÇÏ¼¼¿ä  -->
					</div>
				</div>
				
				<%-- 					<div class="form-group">
						<!-- ºÎ¼­ÄÚµå -->
						<label class="control-label col-sm-4" for="orgcode">ºÎ¼­¸í</label>
						<div class="control-label col-sm-3">
							<!-- ¿©±â¿¡ ºÎ¼­ÄÚµå¸¦ Ãâ·ÂÇÏ¼¼¿ä  -->
							<%= user.getDeptname() %>
						</div>
					</div> --%>

				<div class="form-group">
					<!-- ¼º¸í-->
					<label class="control-label col-sm-4" for="name">¼º¸í</label>
					<div class="control-label col-sm-3" id="name">
					</div>
				</div>
				<div class="form-group">
					<!-- »ç¹ø-->
					<label class="control-label col-sm-4" for="id">»ç¹ø</label>
					<div class="control-label col-sm-3" id="id">
						<!-- ¿©±â¿¡ »ç¹øÀ» Ãâ·ÂÇÏ¼¼¿ä  -->
					</div>
					<span id="checkVal"></span>
				</div>


				<div class="form-group">
					<!-- Á÷À§-->
					<label class="control-label col-sm-4" for="birthday">Á÷À§</label>
					<div class="control-label col-sm-3" id="position">
						<!-- ¿©±â¿¡ Á÷À§ Ãâ·ÂÇÏ¼¼¿ä  -->
					</div>
				</div>
				<div class="form-group">
					<!-- Á÷Ã¥-->
					<label class="control-label col-sm-4" for="birthday">Á÷Ã¥</label>
					<div class="control-label col-sm-3" id="duty">
						<!-- ¿©±â¿¡ Á÷Ã¥ Ãâ·ÂÇÏ¼¼¿ä  -->
					</div>
				</div>



			</fieldset>
		</form>
	</div>
	
	
</body>
</html>