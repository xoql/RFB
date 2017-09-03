<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../include/header.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../include/menu.jsp" %>
<div class="container">
	<hr>
	<h2>주문 내역</h2>
	<hr>
	<c:if test="${dto ==null }">
		주문 내역이 없습니다.
	</c:if>
	<table>
	<tr>
		<td>주문일</td><td>상품명</td><td>수량</td><td>가격</td><td>합계</td>
	</tr>
	<c:forEach var="row" items="${dto }">
	<tr>
		<td><fmt:formatDate value="${row.order_date }" pattern="YY/MM/dd"/> </td><td>${row.product_id}</td><td>${row.amount }</td>
		<td>${row.price }</td><td>${row.order_total }</td>
	 </tr>
	</c:forEach>
	</table>
</div>
</body>
</html>