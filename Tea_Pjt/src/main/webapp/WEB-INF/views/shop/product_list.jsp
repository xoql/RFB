<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../include/header.jsp"%>
<script>
	$(function() {

		$("#btnAdd").click(function() {
			location.href = "${path}/shop/product/write.do";
		});

		$(".product_img").click(function() {
			var product_id = $(this).find("input").val()
			location.href = "${path }/shop/product/detail/" + product_id;
		});
	});
	function product_type(type) {
		location.href = "${path}/shop/product/list.do?product_type=" + type;
	}
</script>
<style>
.product li {
	float: left;
	margin-left: 30px;
}

.product li a {
	font-size: 15px;
	color: black;
	text-decoration: none;
	cursor: pointer;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../include/menu.jsp"%>


	<div class="container">
		<hr>
		<div class="row">
			<ul class="product">
				<li><a onclick="product_type('상품1')">상품1</a></li>
				<li><a onclick="product_type('상품2')">상품2</a></li>
			</ul>
			<ul class="product" style="float:right; margin-right: 20px; list-style: none;">
				<li><a id="btnAdd">상품 등록</a>
			</ul>
		</div>
		<hr>
		<div class="row">
			<c:forEach var="row" items="${list}">
				<div class="col-sm-3 product_img" style="margin-bottom: 20px;">
					<img width="100%" ; height="150px;" alt=""
						src="${path }/images/${row.picture_url}"> <input
						type="hidden" name="product_id" value="${row.product_id}">
						<div><a href="${path }/shop/product/update/${row.product_id }">[편집]</a></div>
				</div>
			</c:forEach>
		</div>
	</div>
	<%-- <div class="product_img row">
<ul>
	<c:forEach var="row" items="${list}">	
			<li class="col-sm-3"><img alt="" src="${path }/images/${row.picture_url}"><input type="hidden" name="product_id" value="${row.product_id}">
			<div><a href="${path }/shop/product/update/${row.product_id }">[편집]</a></div> </li>
	</c:forEach>
</ul>
</div> --%>

</body>
</html>