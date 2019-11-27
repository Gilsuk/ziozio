<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script>

    $(function() {        
        // Geolocation API에 액세스할 수 있는지를 확인
        if (navigator.geolocation) {
            //위치 정보를 얻기
            navigator.geolocation.getCurrentPosition (function(pos) {
                
                var lat = pos.coords.latitude;
                var lon = pos.coords.longitude;
//                 var geocode = "http://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lon+"&sensor=false&key=AIzaSyAYL95BQRM_FRYkiMhmioDwpan0gQ0YqLw";
//                 var geocode = "http://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lon+"&sensor=false&key=AIzaSyAYL95BQRM_FRYkiMhmioDwpan0gQ0YqLw";
                var geocode = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lon+"&key=AIzaSyAYL95BQRM_FRYkiMhmioDwpan0gQ0YqLw";
                jQuery.ajax({
                    url: geocode,
                    type: 'GET',
                       success: function(myJSONResult){
                                if(myJSONResult.status == 'OK') {
//                                     var tag = "";
// //                                     var i;
// //                                     for (i = 0; i < myJSONResult.results.length; i++) {
// //                                       tag += "주소 : " +myJSONResult.results[0].formatted_address+" <br />";
//                                       tag += "주소 : " +myJSONResult.results[0].address_components[2].long_name+" <br />";
// //                                       tag += "위도 : " +myJSONResult.results[i].geometry.location.lat+" <br />";
// //                                       tag += "경도 : " +myJSONResult.results[i].geometry.location.lon+" <br />";
// //                                       	console.log(tag);
// 										console.log(myJSONResult.results[0].address_components[2].long_name);
										console.log(myJSONResult);
//                                     	document.getElementById("message").innerHTML = tag;
																				
										$.ajax({
											
											url : '/location_get',
								
											data : {location : JSON.stringify(myJSONResult.results[5].address_components[1].long_name),
													location1 : JSON.stringify(myJSONResult.results[5].address_components[0].long_name)
													},																	
											
											
											type : 'GET',
								
// 											success : onSuccess
								
										});

										// Hanlder
								
// 										function onSuccess(res, status, xhr) {
								
// // 											if(res.err == "Error"){
								
// // 												location.href="/test";
								
// // 												return;
								
// // 											}
								
										
								
// // 											var data = res.result;
								
// // 											var key = res.key;
											
// // 											console.log(res.result);
								
											
								
// // 											if(data != null){
								
// // 												alert(data);
								
// // 												opener.goSearch();
								
// // 												window.close();
								
// // 											}
								
// 										}                             
                                } else if(myJSONResult.status == 'ZERO_RESULTS') {
                                    alert("지오코딩이 성공했지만 반환된 결과가 없음을 나타냅니다.\n\n이는 지오코딩이 존재하지 않는 address 또는 원격 지역의 latlng을 전달받는 경우 발생할 수 있습니다.")
                                } else if(myJSONResult.status == 'OVER_QUERY_LIMIT') {
                                    alert("할당량이 초과되었습니다.");
                                } else if(myJSONResult.status == 'REQUEST_DENIED') {
                                    alert("요청이 거부되었습니다.\n\n대부분의 경우 sensor 매개변수가 없기 때문입니다.");
                                } else if(myJSONResult.status == 'INVALID_REQUEST') {
                                    alert("일반적으로 쿼리(address 또는 latlng)가 누락되었음을 나타냅니다.");
                                }
                                
//                                 
                        }
                });
                         
            });
            
        } else {
            alert("이 브라우저에서는 Geolocation이 지원되지 않습니다.")
        }
	});
    
    
</script>
</head>
<body>  


<p id="message"></p>


   
</body>
</html>