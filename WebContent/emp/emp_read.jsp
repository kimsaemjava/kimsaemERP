<%@page import="erp.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
 </head>
<body>
<% MemberDTO dto = (MemberDTO)request.getAttribute("dto");
%>
	<div class="container-fluid">
			<form role="form" class="form-horizontal"
				action="/serverweb/emp/insert.do" method="POST" 
				name="myform">
				<fieldset>
					<div id="legend">
						<legend>아래 양식을 작성해주세요.</legend>
					</div>
					<div class="form-group" style="padding: 40px">
						<p class="centered">
							<img src="/kimsaemERP/images/<%=dto.getProfile_photo() %>" 
							 id="userImage" style="width: 100px">
							 
						</p>
						<div>
							
						</div>
					</div>
					
					<div class="form-group">
						<!-- 부서코드 -->
						<label class="control-label col-sm-2" for="orgcode">부서코드</label>
						<div class="col-sm-3">
							<!-- 여기에 부서코드를 출력하세요  -->
							<%= dto.getDeptno() %>
						</div>
					</div>
		
					
					
					<div class="form-group">
						<!-- 성명-->
						<label class="control-label col-sm-2" for="orgname">성명</label>
						<div class="col-sm-3">
							<!-- 여기에 부서코드를 출력하세요  -->
							<%= dto.getName() %>
						</div>
					</div>
					<div class="form-group">
						<!-- 사번-->
						<label class="control-label col-sm-2" for="id">사번</label>
						<div class="col-sm-3">
							<!-- 여기에 사번을 출력하세요  -->
							<%= dto.getId()%>
						</div>
						<span id="checkVal"></span>
					</div>
				
					<div class="form-group">
						<!-- 주민번호-->
						<label class="control-label col-sm-2" for="ssn">주민번호</label>
						<div class="col-sm-3">
							<!-- 여기에 주민번호를 출력하세요  -->
									<%= dto.getSsn()%>
						</div>
					</div>
					<div class="form-group">
						<!-- 생일-->
						<label class="control-label col-sm-2" for="birthday">생년월일</label>
						<div class="col-sm-3">
							<!-- 여기에 생일을 출력하세요  -->
							<%= dto.getBirthday()%>

						</div>
					</div>
					<div class="form-group">
						<!-- 결혼유무-->
						<label class="control-label col-sm-2" for="marry">결혼유무</label>
						<div class="col-sm-3">
							<input type="checkbox" id="marry" name="marry"
								placeholder="결혼유무"	minlength="15" >결혼유무
								<%= dto.getMarry()%>
						</div>
					</div>
					<div class="form-group">
						<!-- 성별-->
						<label class="control-label col-sm-2" for="pass">패스워드
							<%= dto.getPass()%>
						</label>
						<%= dto.getGender()%>
						<input type="radio" id="marry" name="marry"
								placeholder="결혼유무"	minlength="15" >남자
						<input type="radio" id="marry" name="marry"
								placeholder="결혼유무"	minlength="15" >여자
					</div>
					<div class="form-group">
						<!-- 직위-->
						<label class="control-label col-sm-2" for="birthday">직위</label>
						<div class="col-sm-3">
							<!-- 여기에 직위 출력하세요  -->
							<%= dto.getPosition()%>
						</div>
					</div>
					<div class="form-group">
						<!-- 직책-->
						<label class="control-label col-sm-2" for="birthday">직책</label>
						<div class="col-sm-3">
							<!-- 여기에 직책 출력하세요  -->
							<%= dto.getDuty()%>

						</div>
					</div>
					<div class="form-group">
						<!-- 직급-->
						<label class="control-label col-sm-2" for="birthday">직급</label>
						<div class="col-sm-3">
							<!-- 여기에 직책 출력하세요  -->
							<%= dto.getClasses()%>
						</div>
					</div>
					<div class="form-group">
						<!-- 입사일자-->
						<label class="control-label col-sm-2" for="birthday">입사일자</label>
						<div class="col-sm-3">
							<!-- 여기에 입사일자을 출력하세요  -->
							<%= dto.getStartday()%>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">우편번호</label>
						<div class="col-sm-3">
							<!-- 우편번호정보를 출력하세요-->
							<%= dto.getZipcode()%>		
						</div>
						
					</div>
					<div class="form-group">
						<!-- 주소-->
						<label class="control-label col-sm-2" for="addr">주소</label>
						<div class="col-sm-6">
							<!-- 주소를 나타내세요 -->
							<%= dto.getAddr()%>	
							
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label"></label>
						<div class="col-sm-5">
							<!-- 주소를 나타내세요 -->
							<%= dto.getDetailaddr()%>	
						</div>
					
					</div>
					<div class="form-group">
						<!-- 집전화-->
						<label class="control-label col-sm-2" for="phonehome">집전화</label>
						<div class="col-sm-5">
							<!-- 집전화를 출력하세요 -->
							<%= dto.getPhonehome()%>
						</div>
					</div>
					<div class="form-group">
						<!-- 회사전화-->
						<label class="control-label col-sm-2" for="phonehome">회사전화</label>
						<div class="col-sm-5">
							<!-- 회사전화를 출력하세요 -->
							<%= dto.getPhoneco()%>
						</div>
					</div>
					<div class="form-group">
						<!-- 핸드폰번호-->
						<label class="control-label col-sm-2" for="phonehome">핸드폰번호</label>
						<div class="col-sm-5">
							<!-- 핸드폰번호를 출력하세요 -->
							<%= dto.getPhonecell()%>
						</div>
					</div>
					<div class="form-group">
						<!-- 이메일-->
						<label class="control-label col-sm-2" for="email">이메일</label>
						<div class="col-sm-3">
							<!-- 이메일을 출력하세요 -->
							<%= dto.getEmail()%>

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
	<div><a href="/kimsaemERP/emp/emplist.do">회원목록보기</a></div>
</body>
</html>