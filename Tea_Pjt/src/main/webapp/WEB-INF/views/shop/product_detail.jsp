<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../include/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function cartIn() {
		var param = $("#form1").serialize();
		$.ajax({
			type : "post",
			url : "${path}/shop/cart/insert.do",
			data : param,
			success : function(data) {
				cartlist();
			}
		});
	}

	function cartlist() {
		if (confirm("장바구니로 이동하시겠습니까?")) {
			location.href = "${path}/shop/cart/list.do";
		}
	}

	function product_list() {
		location.href = "${path}/shop/product/list.do"
	}
</script>
</head>
<body>
	<%@include file="../include/menu.jsp"%>
	<%@include file="../include/session_check.jsp"%>
	<div class="container" style="margin-bottom: 100px;">
		<div class="row">
			<hr>
			<h2>상품 정보</h2>
			<hr>
			<div class="col-sm-4"">
				<img alt="" src="${path }/images/${dto.picture_url}" width="300px"
					height="300px">
			</div>
			<div class="col-sm-6">
				<div>
					<h2>${dto.product_name }</h2>
					<div style="font-size: 20px;">
						가격 : <span style="color: red"><fmt:formatNumber
								pattern="#,###,###">${dto.price }</fmt:formatNumber>원</span>
					</div>
					<div>
						제품 정보 : <br>${dto.description }</div>
				</div>
				<div>
					<form action="${path }/shop/cart/insert.do" name="form1" id="form1"
						method="post">
						<input type="hidden" name="product_id" value="${dto.product_id }">
						<select name="amount">
							<c:forEach begin="1" end="10" var="i">
								<option value="${i }">${i }
							</c:forEach>
						</select>&nbsp;개
					</form>
				</div>
				<input type="button" onclick="cartIn()" value="장바구니에 담기"> <input
					type="button" onclick="product_list()" value="목록">
			</div>
		</div>
	</div>
	<%-- <div class="row">
	<div class="col-sm-1"></div>
	<div class="col-sm-3"><img alt="" src="${path }/images/${dto.picture_url}" width="300px" height="300px"></div>
	<div class="col-sm-8">
	<div><h2>${dto.product_name }</h2>
			<div>가격 : ${dto.price }</div>
			<div>상품 설명 : <br>${dto.description }</div>
			<div><form action="${path }/shop/cart/insert.do" name="form1" id="form1" method="post">
						<input type="hidden" name="product_id" value="${dto.product_id }">
						<select name="amount">
									<c:forEach begin="1" end="10" var="i">
										<option value="${i }">${i }
									</c:forEach>
						</select>&nbsp;개
					</form></div>
					<input type="button" onclick="cartIn()" value="장바구니에 담기">
					<input type="button" onclick="product_list()" value="목록">
					
	</div>
	</div>
</div> --%>
	<%-- <table>
	<tr>
	
		<td><img alt="" src="${path }/images/${dto.picture_url}" width="300px" height="300px"> </td>
			<td align="center">
			<table>
				<tr><td>상품명</td>
				<td>${dto.product_name }</td>
				</tr>
				
				<tr><td>가격</td>
				<td>${dto.price }</td>
				</tr>
				
				
				<tr><td>&nbsp;</td>
				<td>${dto.description }</td>
				</tr>
				
				<tr>
				<td colspan="2">
					<form action="${path }/shop/cart/insert.do" name="form1" method="post">
						<input type="hidden" name="product_id" value="${dto.product_id }">
						<select name="amount">
									<c:forEach begin="1" end="10" var="i">
										<option value="${i }">${i }
									</c:forEach>
						</select>&nbsp;개
						<input type="submit" value="장바구니에 담기">
					</form>
				</td>
				</tr>
				
			</table>
	</tr>
</table> --%>
</body>
</html>