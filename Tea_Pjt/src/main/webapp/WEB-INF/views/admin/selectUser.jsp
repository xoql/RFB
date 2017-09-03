<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../include/header.jsp"%>
<script>
function modifyUser(index) {
	alert(index);
	var user_id = $("#user_id"+index).text();
	var user_flag =$("#user_flag"+index).val();
	var user_level=$("#user_level"+index).val();
	
	var param ="user_id="+user_id+"&user_flag="+user_flag+"&user_level="+user_level;
	location.href="${path}/admin/modifyUser.do?"+param;

}
	
	
</script>
<%-- <fmt:formatDate value="${dto.date }" pattern="yy/mm/dd"/> --%>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.userInfo li {
	float: left;
	margin-left: 30px;
}

.userInfo li a {
	font-size: 15px;
	color: black;
	text-decoration: none;
	cursor: pointer;
}
</style>
<script>
	function selectInfo(option) {
		location.href = "${path }/admin/selectUser.do?option=" + option;
	}
</script>
</head>
<body>
	<%@include file="../include/menu.jsp"%>
	<div class="container-fluid">
		<div class="row content">
			<%@include file="../include/sideMenu.jsp"%>

			<div class="col-sm-10">
				<hr>
				<h2>회원 관리</h2>
				<hr>
				<div>
					<ul class="userInfo">
						<li><a onclick="selectInfo('user')">회원 관리</a></li>
						<li><a onclick="selectInfo('manager')">매니저 관리</a></li>
						<li><a onclick="selectInfo('N')">탈퇴한 회원</a></li>
					</ul>
				</div>
				<br> <br>
				<div>
					<c:choose>
						<c:when test="${selectUser.size() ==0 }">
							<h2>일치하는 회원이 없습니다.</h2>
						</c:when>
						<c:otherwise>

							<div class="table-responsive" style="margin-right: 100px;">
								<table class="table">
									<thead>
										<tr>
											<th>회원아이디</th>
											<th>이름</th>
											<th>전화번호</th>
											<th>이메일</th>
											<th>주소</th>
											<th>회원 등급</th>
											<th>회원 여부</th>
											<th>&nbsp;</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="row" items="${selectUser }" varStatus="status">
											<tr>
												<td id="user_id${status.index }">${row.user_id }</td>
												<td>${row.user_name }</td>
												<td>${row.tel1}-${row.tel2 }</td>
												<td>${row.email1 }</td>
												<td>${row.address1}${row.address2}${row.address3 }</td>
												<td><select name="user_level" id="user_level${status.index}">
														<option value="0"
															<c:out value="${row.user_level==0 ? 'selected':''}"/>>일반 회원</option>
														<option value="1"
															<c:out value="${row.user_level==1 ? 'selected':''}"/>>매니저</option>
														<option value="2"
															<c:out value="${row.user_level==2 ? 'selected':''}"/>>관리자</option>
												</select>
												<td><select name="user_flag" id="user_flag${status.index}">
														<option
															<c:out value="${row.user_flag=='Y' ? 'selected':''}"/>>Y</option>
														<option
															<c:out value="${row.user_flag=='N' ? 'selected':''}"/>>N</option>
												</select>
												<td>
													<button type="button" value="변경" id="updateBtn${status.index}" onclick="modifyUser('${status.index}')">변경</button>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>

</body>
</html>