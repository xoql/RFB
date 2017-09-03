<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>


	<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<%@include file="../include/header.jsp" %>
	<script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
	<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCmi_3v9r25wfIyVwkuessaP3FwjKq2KAI"></script>
	<script>
		function initialize() {

			/*
				http://openapi.map.naver.com/api/geocode.php?key=f32441ebcd3cc9de474f8081df1e54e3&encoding=euc-kr&coord=LatLng&query=서울특별시 강남구 강남대로 456
                위의 링크에서 뒤에 주소를 적으면 x,y 값을 구할수 있습니다.
			*/
			var Y_point			= 37.499585;		// Y 좌표
			var X_point			= 127.030471;		// X 좌표

			var zoomLevel		= 17;						// 지도의 확대 레벨 : 숫자가 클수록 확대정도가 큼

			var markerTitle		= "중앙 처리 정보학원";				// 현재 위치 마커에 마우스를 오버을때 나타나는 정보
			var markerMaxWidth	= 300;						// 마커를 클릭했을때 나타나는 말풍선의 최대 크기

			// 말풍선 내용
			var contentString	= '<div>' +
			'<h2>중앙 Gongcha</h2>'+
			'<p>김남호,김지혜,백광덕이 만든 GongCha 사이트</p>' +
			//'<a href="http://www.daegu.go.kr" target="_blank">http://www.daegu.go.kr</a>'+ //링크도 넣을 수 있음
			'</div>';

			var myLatlng = new google.maps.LatLng(Y_point, X_point);
			var mapOptions = {
								zoom: zoomLevel,
								center: myLatlng,
								mapTypeId: google.maps.MapTypeId.ROADMAP
			}
			var map = new google.maps.Map(document.getElementById('map_view'), mapOptions);

			var marker = new google.maps.Marker({
													position: myLatlng,
													map: map,
													title: markerTitle
			});

			var infowindow = new google.maps.InfoWindow(
														{
															content: contentString,
															maxWidth: markerMaxWidth
														}
			);

			/* google.maps.event.addListener(marker, 'click', function() {
			 */	infowindow.open(map, marker);
			/* });
			 */
		}
	</script>
</head>

<body onload="initialize()">
	<%@include file="../include/menu.jsp" %>
	<div class="container">
		<div class="row">
		<hr>
		<h2>매장 위치</h2>
		<hr>
		<div class="col-sm-5">
			<div id="map_view" style="width: 100%;height: 400px;"></div>
		</div>
		
	</div>
	</div>
</body>
</html>