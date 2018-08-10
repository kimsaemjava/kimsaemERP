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
	ulnode = "";
	$(document).ready(function() {
		$(".folder").on("click", function() {
			deptname = $(this).text().trim();
			//this�� �������� ����
			ulnode = $(this).next();
			//ul����� id�Ӽ� ���� ���ϱ�
			deptno = $(ulnode).attr("id");
			//alert(deptno);
			$.get("/kimsaemERP/ajaxtreedata", {
				"deptno" : deptno
			}, getData, "json");
		});
		//�������� ������ ���(ajax�������� �߰��� �±�)�� �̺�Ʈ�� �����ϴ� ���		
		//1���Ű����� - �̺�Ʈ����, 2���Ű����� - � �±׿� �̺�Ʈ�� ������ �� ���� ����
		//3���Ű����� - �̺�Ʈ�� �߻��� �� ������ �Լ�
		$(document).on("click", ".file", function() {
			id = $(this).attr("id");
			//alert(id);
			$.get("/kimsaemERP/getempinfo.do", {
				"id" : id
			}, getEmpInfo, "json");
		})
	})
	//jquery�� �̿��ϸ� json�� �Ľ̵Ǿ� ��ü���·� ���ϵȴ�.
	function getData(data) {
		//alert(data.emplist[0].name);
		myli = "";
		for (i in data.emplist) {
			myli = myli
					+ "<li><span class='file' id='"+ data.emplist[i].id +"'>"
					+ data.emplist[i].name + "</span></li>";
		}
		$(ulnode).html(myli);
	}
	function getEmpInfo(emp) {
		//alert("test");
		$("#empinfo").css("display", "block");
		$("#userImage").attr("src", "/kimsaemERP/images/" + emp.profile_photo);
		$("#deptno").text(emp.deptno);
		$("#name").text(emp.name);
		$("#id").text(emp.id);
		$("#position").text(emp.position);
		$("#duty").text(emp.duty);

	}
</script>
</head>
<body>
	<%
		ArrayList<DeptDTO> deptList = (ArrayList<DeptDTO>) request.getAttribute("deptList");
		int size = deptList.size();
	%>
	<h1>KimsaemJavaNara ������ - ��������ǥ��(jquery)</h1>
	<div id="deptlist" style="margin: 20px" class="col-sm-6">
		<ul id="browser" class="filetree">
			<%
				for (int i = 0; i < size; i++) {
					DeptDTO dept = deptList.get(i);
			%>
			<li class="closed"><span class="folder"> <%=dept.getDeptname()%></span>
				<ul id="<%=dept.getDeptno()%>">
					<!-- <li><span class="file">�嵿��</span></li> -->
				</ul></li>
			<%
				}
			%>
		</ul>
	</div>

	<div style="margin-top: 20px; height: 400px; display: none;"
		class="col-sm-5" id="empinfo">
		<form role="form" class="form-horizontal"
			action="/kimsaemERP/emp/update.do" method="POST" name="myform">
			<fieldset>
				<div id="legend">
					<legend>������ ����� �⺻ �����Դϴ�.</legend>
				</div>
				<div class="form-group">
					<p class="col-sm-4">
						<img src="" id="userImage" style="width: 90px">
					</p>
					<div class="col-sm-8" style="color: blue;">���� ������ �������� ������
						������ ���Ͻø� �μ����λ���ȸ�� �����ϰ� �۾��ϼ���.</div>

				</div>
				<div class="form-group">
					<!-- �μ��ڵ� -->
					<label class="control-label col-sm-4" for="orgcode">�μ��ڵ�</label>
					<div class="control-label col-sm-4" id="deptno">
						<!-- ���⿡ �μ��ڵ带 ����ϼ���  -->
					</div>
				</div>
				<div class="form-group">
					<!-- �μ��ڵ� -->
					<label class="control-label col-sm-4" for="orgcode">�μ���</label>
					<div class="control-label col-sm-3">
						<!-- ���⿡ �μ����� ����ϼ���  -->
					</div>
				</div>
				<div class="form-group">
					<!-- ����-->
					<label class="control-label col-sm-4" for="name">����</label>
					<div class="control-label col-sm-4" id="name"></div>
				</div>
				<div class="form-group">
					<!-- ���-->
					<label class="control-label col-sm-4" for="id">���</label>
					<div class="control-label col-sm-4" id="id">
						<!-- ���⿡ ����� ����ϼ���  -->
					</div>
					<span id="checkVal"></span>
				</div>
				<div class="form-group">
					<!-- ����-->
					<label class="control-label col-sm-4" for="birthday">����</label>
					<div class="control-label col-sm-4" id="position">
						<!-- ���⿡ ���� ����ϼ���  -->
					</div>
				</div>
				<div class="form-group">
					<!-- ��å-->
					<label class="control-label col-sm-4" for="birthday">��å</label>
					<div class="control-label col-sm-4" id="duty">
						<!-- ���⿡ ��å ����ϼ���  -->
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>