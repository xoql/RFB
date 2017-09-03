<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	table{
		margin: 12px;
		width: 100%;
		font-size: 16px;
	}
	#buttonDiv{
		/* text-align: center; */
	}
	.button{
		margin: 12px;
		margin-top: 30px;
		width: 30%;
		height: 30px;
	}
	td{
		height: 50px;
	}
</style>
<script>
/* 	$(function(){
		alert('${msg}');
	}); */
	function updateChk(){
		var updateChk = prompt("비밀번호를 입력하세요.", "");
		if (updateChk==null){
			alert("입력하세요");
			history.back();
		}else{
			location.href="searchPassword.do?updateChk="+updateChk;
		}
	}
	function deleteChk(){
		var deleteChk = prompt("비밀번호를 입력하세요.", "");
		if (deleteChk==null) {
			alert("입력하세요");
		}else{
			var real = confirm("정말 회원을 탈퇴하시겠습니까?");
			if(real){
				location.href="deleteUser.do";
			}else{
				alert('회원 탈퇴 취소');
			}
		}
		return true;
	}
	function deleteChk(){
		location.href="deleteGo.do";
	}
</script>
</head>
<body>
	<%@include file="../include/menu.jsp" %>
	<form action="updateGo.do" method="post">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<table>
					<tr>
						<th>아이디</th>
						<td>${user.user_id}</td>
					</tr>
					<tr>
						<th>이름</th>
						<td>${user.user_name}</td>
					</tr>
					<tr>
						<th>생년월일</th>
						<td>${user.birth}</td>
					</tr>
					<tr>
						<th>성별</th>
						<c:if test="${user.gender=='M'}">
							<td>남성</td>
						</c:if>
						<c:if test="${user.gender=='F'}">
							<td>여성</td>
						</c:if>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>0${user.tel1} - ${user.tel2} - ${user.tel3}</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>${user.email1} @ ${user.email2}</td>
					</tr>
					<tr>
						<th rowspan="2">주소</th>
						<td>(우편주소)${user.address1}</td>
					</tr>
					<tr>
						<td>${user.address2} ${user.address3}</td>
					</tr>
					<tr>
						<th>가입날짜</th>
						<td>${user.user_join_date}</td>
					</tr>
					<tr>
						<td colspan="2">
							<div id="buttonDiv">
								<input class="button" type="submit" value="수정하기"><input class="button" type="button" value="회원탈퇴" onclick="deleteChk()">
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div class="col-md-3"></div>
		</div>
	</form>
</body>
</html>