<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- views/chart_exam/chart01.jsp -->
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.statistics li {
	float: left;
	margin-left: 30px;
}

.statistics li a {
	font-size: 15px;
	color: black;
	text-decoration: none;
	cursor: pointer;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp"%>
<!-- 차트 그리기에 필요한 구글 js -->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script>
	google.load('visualization', '1', {
		'packages' : [ 'corechart' ]
	});
	google.setOnLoadCallback(drawChart);
	google.setOnLoadCallback(drawChart2);
	function drawChart() {
		var param = $("#form1").serialize();
		var jsonData = $.ajax({
			url : "${path}/chart/chart_orders_count.do",
			dataType : "json",
			async : false,
			data : param,
			success : function(data) {
				var myJSON = JSON.stringify(data);

				var data = new google.visualization.DataTable(myJSON);
				//차트를 출력할 div
				// LineChart, ColumnChart, PieChart
				var chart = new google.visualization.PieChart(document
						.getElementById('chart_div'));

				chart.draw(data, {
					title : "판매 수량",
					width : 600,
					height : 440
				});
			}
		});
	}

	function drawChart2() {
		var param = $("#form2").serialize();
		var jsonData = $.ajax({
			url : "${path}/chart/chart_orders_money.do",
			dataType : "json",
			async : false,
			data : param,
			success : function(data) {
				var myJSON = JSON.stringify(data);

				var data = new google.visualization.DataTable(myJSON);
				//차트를 출력할 div
				// LineChart, ColumnChart, PieChart
				var chart = new google.visualization.LineChart(document
						.getElementById('chart_div2'));

				chart.draw(data, {
					title : "판매 가격",
					width : 600,
					height : 440
				});
			}
		});
	}
	//데이터 테이블 생성

	//		var chart 
	//= new google.visualization.LineChart(
	//		document.getElementById('chart_div'));
	//		var chart 
	//= new google.visualization.ColumnChart(document
	//				.getElementById('chart_div'));
	// 차트객체.draw( 데이터테이블, 옵션 )
	// curveType : "function", 곡선 처리

	/* function drawChart2() {
		var jsonData = $.ajax({
			url : "${path}/chart/chart_orders_money.do",
			dataType : "json",
			async : false
		}).responseText;
		console.log(jsonData);
		//데이터 테이블 생성
		var data = new google.visualization.DataTable(jsonData);
		//차트를 출력할 div
		// LineChart, ColumnChart, PieChart
		//		var chart = new google.visualization.PieChart(
		//				document.getElementById('chart_div2'));
		var chart = new google.visualization.LineChart(document
				.getElementById('chart_div2'));
		//		var chart 
		//= new google.visualization.ColumnChart(document
		//				.getElementById('chart_div'));
		// 차트객체.draw( 데이터테이블, 옵션 )
		// curveType : "function", 곡선 처리
		chart.draw(data, {
			title : "주문 가격 표",
			width : 600,
			height : 440
		});
	} */
</script>
</head>
<body>

	<%@include file="../include/menu.jsp"%>
	<div class="container-fluid">
		<div class="row content">
			<%@include file="../include/sideMenu.jsp"%>

			<div class="col-sm-10">

				<hr>
				<h2>통계</h2>
				<hr>
				<div class="row">
					<ul class="statistics">
						<li><a onclick="selectInfo('user')">상품 통계</a></li>
						<li><a onclick="selectInfo('manager')">회원 통계</a></li>
					</ul>
				</div>
				<div class="col-sm-5">
					<!-- 차트 출력 영역 -->
					<div id="chart_div"></div>
					<form id="form1" name="form1" method="get">
						<div style="display: inline-block;">
							<select name="option">
								<option value="up">상위</option>
								<option value="down">하위</option>
							</select>
						</div>

						<div style="display: inline-block;">
							<input type="number" name="number">개
						</div>
						<button onclick="drawChart()" type="button">검색</button>
					</form>
				</div>
				<div class="col-sm-5">
					<div id="chart_div2"></div>
					<form id="form2" name="form2" method="get">
						<div style="display: inline-block;">
							<select name="option">
								<option value="up">상위</option>
								<option value="down">하위</option>
							</select>
						</div>

						<div style="display: inline-block;">
							<input type="number" name="number">개
						</div>
						<button onclick="drawChart2()" type="button">검색</button>
					</form>
				</div>

			</div>
		</div>
	</div>





</body>
</html>