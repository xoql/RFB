<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../include/header.jsp"%>
<%@include file="../include/session_check.jsp"%>
<script>
	$(document).ready(function() {
		$("#btnList").click(function() {
			location.href = "${path}/shop/product/list.do";
		});

		$("#btnDelete").click(function() {
			if (confirm("삭제 하시겠습니까?")) {
				location.href = "${path}/shop/cart/deleteAll.do";
			}
		});
		
		$("#btnOrder").click(function() {
			location.href="${path}/shop/order/order_cart.do";
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../include/menu.jsp"%>
	<div class="container">
		<div class="row">
		<hr>
		<h2>장바구니</h2>
		<hr>
		<span style="color: red">*30,000원 이상 구매시 배송비 무료</span><br>
		
			<c:choose>
				<c:when test="${map.count ==0 }">
			장바구니가 비었습니다.
		</c:when>

				<c:otherwise>
					<form id="form1" name="form1" method="post"
						action="${path }/shop/cart/update.do">
						<table border="1" style="width: 50%; height: auto;">
							<tr>
								<th width="30%">상품명</th>
								<th width="15%">가격</th>
								<th width="15%">수량</th>
								<th width="20%">금액</th>
								<th width="20%">삭제</th>
							</tr>
							<c:forEach var="row" items="${map.list }">
								<tr>
									<td>${row.product_name }</td>
									<td>${row.price }</td>
									<td><input type="number" style="width: 100%" min="0"
										max="100" name="amount" value="${row.amount }"> <input
										type="hidden" name="product_id" value="${row.product_id }">
									</td>

									<td>${row.money }</td>
									<td><a
										href="${path }/shop/cart/delete.do?cart_id=${row.cart_id}">삭제</a></td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="5" align="right">장바구니 금액 합계 : ${map.sumMoney }<br>
									배송료 : ${map.free }<br> 총 합계 : ${map.sum }
									<button id="btnUpdate">수정</button>
						</table>
					</form>
				</c:otherwise>
			</c:choose>
			<button type="button" id="btnDelete">장바구니 비우기</button>
			<button type="button" id="btnList">상품 목록</button>
			<button type="button" id="btnOrder">상품 주문</button>
	 
		</div>
	</div>
</body>
</html>