<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="col-sm-2 sidenav" style="margin-top: 30px;">
	<h4>관리자 메뉴</h4>
	<ul class="nav nav-pills nav-stacked">
<%-- 		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#">회원<span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="${path }/admin/selectUser.do">회원 관리</a></li>
				<li><a href="#">매니저 관리</a></li>
				<li><a href="#">Page 1-3</a></li>
			</ul></li>
		<li class="dropdown"><a class="dropdown-toggle"
			data-toggle="dropdown" href="#">통계<span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="${path }/chart/chart3.do">회원 통계</a></li>
				<li><a href="#">주문 통계</a></li>
			</ul></li> --%>
		<li><a href="${path }/admin/selectUser.do">회원 관리</a></li>
		<li><a href="${path }/chart/chart3.do">통계</a></li>
	</ul>
	<br>
</div>