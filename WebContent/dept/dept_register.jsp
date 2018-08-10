<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
 </head>
<body>
	<div class="container-fluid">
			<form role="form" class="form-horizontal"
				action="/serverweb/emp/insert.do" method="POST" 
				name="myform">
				<fieldset>
					<div id="legend">
						<legend>�Ʒ� ����� �ۼ����ּ���.</legend>
					</div>
				
					<div class="form-group">
						<!-- �μ��ڵ� -->
						<label class="control-label col-sm-2" for="orgcode">�μ��ڵ�</label>
						<div class="col-sm-3">
							<input type="text" id="orgname" name="deptname"
								placeholder="�μ��ڵ�" class="form-control" minlength="4" required>
							
						</div>
					</div>
		
					<div class="form-group">
						<!-- �μ���-->
						<label class="control-label col-sm-2" for="deptname">�μ���</label>
						<div class="col-sm-3">
							<input type="text" id="deptname" name="deptname"
								placeholder="�μ���" class="form-control" minlength="4" required>

						</div>
					</div>
			
					<div class="form-group">
						<!-- �μ�������-->
						<label class="control-label col-sm-2" for="deptStartDay">�μ�������</label>
						<div class="col-sm-3">
							<input type="text" id="deptStartDay" name="deptStartDay"
								placeholder="�μ�������" class="form-control" 
								minlength="15" >
						</div>
					</div>
					<div class="form-group">
						<!-- �μ�������-->
						<label class="control-label col-sm-2" for="deptEndDay">�μ�������</label>
						<div class="col-sm-3">
							<input type="text" id="deptEndDay" name="deptEndDay"
								placeholder="�μ�������" class="form-control" 
								minlength="15" >
						</div>
					</div>
					<div class="form-group">
						<!-- �μ�����-->
						<label class="control-label col-sm-2" for="deptlevel">�μ�����</label>
						<div class="col-sm-3">
							<input type="text" id="deptlevel" name="deptlevel"
								placeholder="�μ�����" class="form-control" 
								minlength="15" >
						</div>
					</div>
					<div class="form-group">
						<!-- ����-->
						<label class="control-label col-sm-2" for="deptstep">����</label>
						<div class="col-sm-3">
							<input type="text" id="deptstep" name="deptstep"
								placeholder="����" class="form-control" 
								minlength="15" >
						</div>
					</div>
					<div class="form-group">
						<!-- ���������ڵ�-->
						<label class="control-label col-sm-2" for="deptuppercode">���������ڵ�</label>
						<div class="col-sm-3">
							<select name="deptuppercode" class="form-control" >
								<option value="d001">�λ���
								<option value="d002">�繫��
								<option value="d003">������
								<option value="d0031">��������
								<option value="d0032">Ajax��
								<option value="d004">��������
								<option value="d005">�ý���������
								<option value="d006">�ѹ���
								<option value="dg001">�濵��������
								<option value="dg002">��������
								<option value="dg003">IT��������
								<option value="d007">������
								<option value="d008">��ȹ��
								<option value="d009">����1��
								<option value="d010">�����������
								<option value="d011">����2��
								<option value="d012">�����ý�
							</select>
						</div>
					</div>
					<div class="form-group">
						<!-- job�ڵ�-->
						<label class="control-label col-sm-2" for="job_category">�����з�</label>
						<div class="col-sm-3">
							<select name="job_category" class="form-control" >
								<option value="j001">��������
								<option value="j002">�λ����
								<option value="j003">�������
								<option value="j004">�濵����
								<option value="j005">�繫����
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-2 control-label">������</label>
						<div class="col-sm-3">
							<select name="mgr_id" class="form-control" >
								<option value="9401023jang">�嵿��
								<option value="0111022kim">�����
								<option value="92115kim">�輭��
							
							</select>
								
						</div>
						
					</div>
					<div class="form-group">
						<!-- �μ��ּ�-->
						<label class="control-label col-sm-2" for="deptaddr">�μ��ּ�</label>
						<div class="col-sm-6">
							<input type="text" id="deptaddr" name="deptaddr" 
							placeholder="�μ��ּ�"
								class="form-control" minlength="4" required>
							
						</div>
					</div>
				
					<div class="form-group">
						<!-- ��ǥ��ȭ��ȣ-->
						<label class="control-label col-sm-2" for="depttel">��ǥ��ȭ��ȣ</label>
						<div class="col-sm-5">
							<input type="text" id="depttel" name="depttel" 
							placeholder="��ǥ��ȭ��ȣ"
								class="form-control" minlength="15" required>

						</div>
					</div>
				
					<div class="form-group">
						<!-- Button -->
						<div class="col-sm-3 col-sm-offset-2">
							<input type="submit" value="�����ϱ�" class="btn btn-success"/>
						</div>
					</div>
				</fieldset>
			</form>
	</div>
	<div><a href="/serverweb/emp/list.do">ȸ����Ϻ���</a></div>
</body>
</html>