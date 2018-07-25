<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="erp.dto.DeptDTO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	var xhr;
	function runAjax() {
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = readyCallback;

		xhr.open("POST", "/kimsaemERP/emp/idcheck.do", true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send("id="+myform.id.value);
	}
	function readyCallback() {
		if (xhr.readyState == 4 && xhr.status == 200) { // 정상처리
			document.getElementById("checkVal").innerHTML = xhr.responseText;

		}
	}
</script>
 </head>
 <%
 ArrayList<DeptDTO> deptnamelist =(ArrayList<DeptDTO>) request.getAttribute("deptnamelist");
	int size  = deptnamelist.size();
	System.out.println("jsp"+deptnamelist);
 %>
<body>
	<div class="container-fluid">
			<form role="form" class="form-horizontal"
				action="/kimsaemERP/emp/insert.do" method="POST" 
				name="myform">
				<fieldset>
					<div id="legend">
						<legend>아래 양식을 작성해주세요.</legend>
					</div>
					<div class="form-group" style="padding: 40px">
						<p class="centered">
							<img src="/kimsaemERP/images/myphoto.jpg" 
							 id="userImage" style="width: 100px">
						</p>
						<div>
							<input type="file" name="userImage"
								onchange="document.getElementById('userImage').src = window.URL.createObjectURL(this.files[0])"
								accept="image/*">
						</div>
					</div>
					
					<div class="form-group">
						<!-- 부서코드 -->
						<label class="control-label col-sm-2" for="orgcode">부서코드</label>
						<div class="col-sm-3">
							<select name="deptno" class="form-control" >
							<%for(int i=0;i<size;i++){
								DeptDTO dept = deptnamelist.get(i);	%>
								<option value="<%=dept.getDeptno() %>"><%= dept.getDeptname() %>
							
							<%} %>
							</select>
						</div>
					</div>
		
					
					
					<div class="form-group">
						<!-- 성명-->
						<label class="control-label col-sm-2" for="orgname">성명</label>
						<div class="col-sm-3">
							<input type="text" id="orgname" name="name"
								placeholder="성명" class="form-control" minlength="4" required>

						</div>
					</div>
					<div class="form-group">
						<!-- 사번-->
						<label class="control-label col-sm-2" for="id">사번</label>
						<div class="col-sm-3">
							<input type="text" id="id" name="id"
								placeholder="사번" class="form-control" 
								minlength="4" required onkeyup="runAjax()">
							
						</div>
						<span id="checkVal"><%=request.getAttribute("msg")%></span>
					</div>
					<div class="form-group">
						<!-- 패스워드-->
						<label class="control-label col-sm-2" for="pass">패스워드</label>
						<div class="col-sm-3">
							<input type="text" id="pass" name="pass"
								placeholder="패스워드" class="form-control" minlength="15" >

						</div>
					</div>
					<div class="form-group">
						<!-- 주민번호-->
						<label class="control-label col-sm-2" for="ssn">주민번호</label>
						<div class="col-sm-3">
							<input type="text" id="ssn" name="ssn"
								placeholder="주민번호" class="form-control" 
								minlength="15" >

						</div>
					</div>
					<div class="form-group">
						<!-- 생일-->
						<label class="control-label col-sm-2" for="birthday">생년월일</label>
						<div class="col-sm-3">
							<input type="text" id="birthday" name="birthday"
								placeholder="생년월일" class="form-control" 
								minlength="15" >

						</div>
					</div>
					<div class="form-group">
						<!-- 결혼유무-->
						<label class="control-label col-sm-2" for="marry">결혼유무</label>
						<div class="col-sm-3">
							<input type="checkbox" id="marry" name="marry"
								placeholder="결혼유무"	minlength="15" value="1">결혼유무

						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">우편번호</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" name="zipcode"
								id="zipcode" >
						</div>
						<div class="col-sm-2">
							<button type="button"
								class="btn btn-round btn-primary form-control">우편번호</button>
						</div>
					</div>
					<div class="form-group">
						<!-- 주소-->
						<label class="control-label col-sm-2" for="addr">주소</label>
						<div class="col-sm-6">
							<input type="text" id="addr" name="addr" 
							placeholder="주소"
								class="form-control" minlength="4" required>
							
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label"></label>
						<div class="col-sm-5">
							<input type="text" class="form-control" name="detailaddr"
								id="detailaddr">
						</div>
					
					</div>
					<div class="form-group">
						<!-- 집전화-->
						<label class="control-label col-sm-2" for="phonehome">집전화</label>
						<div class="col-sm-5">
							<input type="text" id="phonehome" name="phonehome" 
							placeholder="집전화"
								class="form-control" minlength="15" required>

						</div>
					</div>
					<div class="form-group">
						<!-- 회사전화-->
						<label class="control-label col-sm-2" for="phoneco">회사전화</label>
						<div class="col-sm-5">
							<input type="text" id="phoneco" name="phoneco" 
							placeholder="회사전화"
								class="form-control" minlength="15" required>

						</div>
					</div>
					<div class="form-group">
						<!-- 집전화-->
						<label class="control-label col-sm-2" for="phonehome">핸드폰번호</label>
						<div class="col-sm-5">
							<input type="text" id="phonecell" name="phonecell" 
							placeholder="핸드폰번호"
								class="form-control" minlength="15" required>

						</div>
					</div>
					<div class="form-group">
						<!-- 등급-->
						<label class="control-label col-sm-2" for="grade">이메일</label>
						<div class="col-sm-3">
							<input type="text" id="email" name="email" 
							placeholder="이메일"
								class="form-control" minlength="4" required>

						</div>
					</div>
					<div class="form-group">
						<!-- Button -->
						<div class="col-sm-3 col-sm-offset-2">
							<input type="submit" value="가입하기" class="btn btn-success"/>
						</div>
					</div>
				</fieldset>
			</form>
	</div>
	<div><a href="/serverweb/emp/list.do">회원목록보기</a></div>
</body>
</html>