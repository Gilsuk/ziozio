<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>::  ::</title>
	
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
window.onload = getLocation; 

var lat, lon;
function getLocation(){
    if(navigator.geolocation){
//         navigator.geolocation.getCurrentPosition(locationSuccess, locationError, geo_options);
        navigator.geolocation.getCurrentPosition(locationSuccess, locationError);
    }else{
        console.log("지오 로케이션 없음")
    }
};
// getLocation
// var latitude, longitude;


	

	
function locationSuccess(p){
    lat = p.coords.latitude,
    lon = p.coords.longitude;
    jQuery.ajax({
		type: "get"
		, url: "https://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lon+"&key=AIzaSyAYL95BQRM_FRYkiMhmioDwpan0gQ0YqLw"
		, data: {
			"lat": lat
			, "lon": lon
		}
		, dataType: "json" 
		, success: function(data) {

			$("#btnAlert").on( "click", function() {
    		$.ajax({
				
				url : '/location_get',
	
				data : {lat : lat,
						lon : lon
						},																	
				
				
				type : 'GET'
	
			})
			});
			console.log("성공")

		}
		, error: function() {
			console.log("실패")
		}
	});
//     initialize();
}

// locationSuccess
function locationError(error){
    var errorTypes = {
        0 : "무슨 에러??",
        1 : "허용 안눌렀음",
        2 : "위치가 안잡힘",
        3 : "응답시간 지남"
    };
    var errorMsg = errorTypes[error.code];
}

// locationError
 
// var geo_options = {
//   enableHighAccuracy: true,
//   maximumAge        : 30000,
//   timeout           : 27000
// };
// geo_options
// var map;
// function initialize() {
// //     var myLatLng = new google.maps.LatLng(latitude, longitude);
//     var myLatLng = {lat: latitude, lng: longitude};
//     var mapOptions = {
//         zoom: 16,
//         center: myLatLng
        
//     };
// //     var marker = new google.maps.Marker({position: myLatLng, map: map});
    
//     map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
//     var beachMarker = new google.maps.Marker({
//         position: myLatLng,
//         map: map,
// //         title : location_si+location_gu+location_dong

//     });
//     //html 문서안에 map-canvas 엘리먼트에 맵을 그리라고 하는 것임
// }


 
</script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAYL95BQRM_FRYkiMhmioDwpan0gQ0YqLw&callback=initMap"></script>
</head>
<body>
<!--     <div id="map-canvas" style="width:800px;height:400px;"></div> -->
<!--     <button id = "a"></button> -->
<div>
	<button id="btnAlert">위치 전송</button>
</div>
</body>
</html>