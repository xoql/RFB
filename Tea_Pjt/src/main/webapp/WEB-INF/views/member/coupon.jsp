<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../include/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>내 쿠폰함</title>
<style>
	.thS{
		font-size: 15px;
	}
	.tdS{
		font-size: 13px;
	}
	table
</style>
</head>
<body>
<%@include file="../include/menu.jsp"%>
	<form action="">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
			<table class="table">
				<tr>
					<th>
						<span class="thS">
							쿠폰명
						</span>
					</th>
					<th>
						<span class="thS">
							할인
						</span>
					</th>
					<th>
						<span class="thS">
							설명
						</span>
					</th>
					<th>
						<span class="thS">
							발급일자
						</span>
					</th>
				</tr>
				<c:set value="${cCount }" var="cCount"/>
				<c:if test="${cCount != null}">
					<c:forEach items="${cDto}" var="cDto">
						<tr>
							<td>
								<span class="tdS">
									${cDto.getcName() }
								</span>
							</td>
							<td>
								<span class="tdS">
									${cDto.getcSale() }
								</span>
							</td>
							<td>
								<span class="tdS">
									${cDto.getcEx() }
								</span>
							</td>
							<td>
								<span class="tdS">
									${cDto.getcDate() }
								</span>
							</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${cCount == null }">
					<tr>
						<td colspan="4">발급받은 쿠폰이 없습니다.</td>
					</tr>
				</c:if>
			</table>
			</div>
			<div class="col-md-3"></div>
		</div>
	</form>
</body>
</html>