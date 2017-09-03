<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../include/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login로그인</title>
<style>
body {
	text-align: center;
}

.inputText {
	margin: 12px;
	width: 70%;
	height: 40px;
	text-align: center;
}

#button {
	width: 70%;
	height: 40px;
}
</style>
</head>
<c:if test="${msg !=null }">
	<script>
		alert('${msg}');
	</script>
	<c:set var="msg" value=""></c:set>
</c:if>
<%-- <c:when test="${msg==null }">
	<c:choose>
		
	</c:choose>
	<c:otherwise>
		<script>
			alert('${msg}');
		</script>
	</c:otherwise>
</c:when> --%>
<body>
	<%@include file="../include/menu.jsp"%>
	<form action="login.do" method="post">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h3>로그인</h3>
				<input id="user_id" class="inputText" type="text" name="user_id"
					placeholder="ID">
				<p>
					<input id="password" class="inputText" type="password"
						name="password" placeholder="PASSWORD">
				<p>
					<input id="button" type="submit" value="로그인">
			</div>
			<div class="col-md-3"></div>
		</div>
	</form>
</body>
</html>