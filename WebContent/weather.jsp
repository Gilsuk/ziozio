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
                var weather = "http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=b8c85273ee67f6a0a8805a795092e25e";
                
                jQuery.ajax({
                    url: weather,
                    type: 'GET',
                       success: function(weatherResult){
                    	   
//                     	   console.log(weatherResult);                       
//                     	   console.log(weatherResult.main);                       
//                     	   console.log(weatherResult.weather[0]);
                    	   
                    	   $.ajax({
								
								url : '/weather_get',
					
								data : {temp : JSON.stringify(weatherResult.main.temp-273.15),
										humidity : JSON.stringify(weatherResult.main.humidity),
										tempMax : JSON.stringify(weatherResult.main.temp_max-273.15),
										tempMin : JSON.stringify(weatherResult.main.temp_min-273.15),
										weather : JSON.stringify(weatherResult.weather[0].description)										
										},	
										
								type : 'GET',
					
					
							});
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