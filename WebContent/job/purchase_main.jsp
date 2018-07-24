<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<style type="text/css">
		table {
			border-collapse: collapse;
			text-align: center;
			width: 95%;
			margin-top: 20px;
		}
		tr{
			height: 30px
		}
		td{
			border: solid 1px #cecece;
			text-align: left;
			padding-left: 10px;
		}
		td.title{
			background-color: #f7f7ef;
			width: 200px;
			
			padding-left: 20px;
		}
	</style>
</head>
<body>
	<table border="1">
		<tr>
			<td class="title">일자</td>
			<td colspan="3">2018년 7월 23일 </td>
		</tr>
		<tr>
			<td class="title">담당자</td>
			<td>홍길동</td>
			<td class="title">처리일자</td>
			<td>2018년 7월 25일</td>
		</tr>
		<tr>
			<td class="title">요청부서</td>
			<td>전산개발</td>
			<td class="title">구분</td>
			<td>일반비품</td>
		</tr>
	</table>
	<div>
		<table border="1">
			<tr style="background-color: #f7f7ef">
				<td>
					<input type="checkbox" name="all" value="all">
				</td>
				<td>번호</td>
				<td>품목코드</td>
				<td>품목명</td>
				<td>규격</td>
				<td>수량</td>
				<td>단가</td>
				<td>공급가액</td>
				<td>부가세</td>
				<td>총금액</td>
				<td>거래처코드</td>
				<td>처리</td>
				<td>거래처등록</td>
			</tr>
			<tr>
				<td>
					<input type="checkbox" name="all" value="all">
				</td>
				<td>1</td>
				<td>pro_it_010</td>
				<td>A4</td>
				<td>box</td>
				<td>3</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>
					<input type="button" value="거래처조회">
				</td>
				<td>
					<input type="button" value="거래처등록">
				</td>
			</tr>
			<tr>
				<td>
					<input type="checkbox" name="all" value="all">
				</td>
				<td>2</td>
				<td>품목코드</td>
				<td>품목명</td>
				<td>규격</td>
				<td>수량</td>
				<td>단가</td>
				<td>공급가액</td>
				<td>부가세</td>
				<td>총금액</td>
				<td>거래처코드</td>
				<td>
					<input type="button" value="거래처조회">
				</td>
				<td>
					<input type="button" value="거래처등록">
				</td>
			</tr>
			<tr>
				<td>
					<input type="checkbox" name="all" value="all">
				</td>
				<td>3</td>
				<td>품목코드</td>
				<td>품목명</td>
				<td>규격</td>
				<td>수량</td>
				<td>단가</td>
				<td>공급가액</td>
				<td>부가세</td>
				<td>총금액</td>
				<td>거래처코드</td>
				<td>
					<input type="button" value="거래처조회">
				</td>
				<td>
					<input type="button" value="거래처등록">
				</td>
			</tr>
			
		</table>
	</div>
</body>
</html>