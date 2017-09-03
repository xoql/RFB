<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../include/header.jsp"%>
<script src="${path }/ckeditor/ckeditor.js"></script>
<script>

function product_update() {
	var product_name = document.form1.product_name.value;
	var price = document.form1.price.value;
	var description = document.form1.description.value;
	if(product_name ==""){
		alert("상품명을 입력해주세요");
		document.form1.product_name.focus();
		return;
	}
	if(price==""){
		alert("가격을 입력해주세요");
		document.form1.price.focus();
		return;
	}
	document.form1.action ="${path}/shop/product/update.do";
	document.form1.submit();

}

function product_list() {
	location.href="${path}/shop/product/list.do"
}

function product_delete() {
	location.href="${path}/shop/product/delete.do/${dto.product_id}"
}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../include/menu.jsp"%>
	<div class="container">
	<hr>
	<h2>상품 수정</h2>
	<hr>
	<form id="form1" name="form1" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>상품 종류</td>
				<td><select name="product_type">
						<option value="상품1"
							<c:out
	value="${dto.product_type=='상품1'?'selected':''}"/>>상품1</option>
						<option value="상품2"
							<c:out
	value="${dto.product_type=='상품2'?'selected':''}"/>>상품2</option>
				</select>
			<tr>
				<td>상품명</td>
				<td><input name="product_name" value="${dto.product_name }"></td>
			</tr>

			<tr>
				<td>가격</td>
				<td><input name="price" value="${dto.price }"></td>
			</tr>


			<tr>
				<td>상품설명</td>
				<td><textarea rows="5" cols="60" name="description"
						id="description">${dto.description }</textarea>
				<script>
					CKEDITOR.replace("description",{
						filebrowserUploadUrl :"${path}/imageUpload.do"
					});
				</script>		
						</td>
			</tr>

			<tr>
				<td>상품 이미지</td>
				<td><input type="file" name="file1"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="등록"
					onclick="product_update()"> <input type="button" value="목록"
					onclick="product_list()">
				<input type="button" value="삭제" onclick="product_delete()">
					</td>
			</tr>
		</table>
		<input type="hidden" name="product_id" value="${dto.product_id }">
	</form>
	</div>
</body>
</html>