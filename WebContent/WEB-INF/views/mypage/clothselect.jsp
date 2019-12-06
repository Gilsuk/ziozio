<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<jsp:include page="/WEB-INF/views/layout/header.jsp" /> 

<script type="text/javascript">
$(document).ready(function() {
	
	$("#btnCalc").on("click", function() {
		
		$.ajax({
			type: "get"
			, url: "/cloth/select/ok"
			, data: {
				"category" : $("#category").val()
				, "style" : $("#style").val()
				, "color" : $("#color").val()
			}

			, success: function(data) {
				console.log("성공")
				console.log(data)
				
				$("#resultLayout").html(data)
			}
			, error: function() {
				console.log("실패")
			}
		});
	});
});

</script>

<div class="marginauto">
   <a href="/main"><img class="ziozio" src='/resources/img/ZIOZIO.png' ></a>
</div>

<div class="wrapper font-dohyeon">
<div class="con center font-dohyeon">
<div class="jumbotron padding" >
<h2 class="">옷 둘러보기</h2><br><br>
<div class="row">

	<div class="col-lg-12">
	<div class="col-lg-1"></div>
		<div class="col-lg-10">
			<div class="row">
			<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
			
				<div class="form-group">
					<div class="form-inline">
					
						<div class="form-group font-gothic"  name="category" id="category">
							<label class="sr-only" for="category"></label>
							<select id="category" class="form-control width1"  >
								<option value="3">OUTER</option>
								<option value="1">TOP</option>
								<option value="2">BOTTOM</option>
							</select>
						</div>
						
						<div class="form-group font-gothic" name="style" id="style">
							<label class="sr-only" for="style"></label>
							<select id="style" class="form-control width1"  >
								<option value="1">페미닌</option>
								<option value="2">시크</option>
								<option value="3">댄디</option>
								<option value="4">비즈니스</option>
								<option value="5">캐쥬얼</option>
								<option value="6">심플베이직</option>
								<option value="7">유니크</option>
								<option value="8">데이트</option>
								<option value="9">섹시글램</option>
							</select>
						</div>
						
						<div class="form-group font-gothic" name="color" id="color">
							<label class="sr-only" for="color"></label>
							<select id="style" class="form-control width1" >
								<option value="01">빨강</option>
								<option value="02">흰</option>
								<option value="03">검정</option>
								<option value="04">카키</option>
								<option value="05">주황</option>
								<option value="06">노랑</option>
								<option value="07">연두</option>
								<option value="08">초록</option>
								<option value="09">하늘</option>
								<option value="10">파랑</option>
								<option value="11">남색</option>
								<option value="12">보라</option>
								<option value="13">핑크</option>
								<option value="14">연갈색</option>
								<option value="15">회색</option>
								<option value="16">민트</option>
								<option value="17">베이지</option>
								<option value="18">와인</option>
								<option value="19">갈색</option>
								<option value="20">고동</option>
								<option value="21">아이보리</option>
							</select>
						</div>
						
						<div class="form-group">
							<input  id="btncalc" type="submit" 
							class="btn btn-primory form-control input width color font-dohyeon" value="선택완료" />
						</div>
					</div>
				</div>
			<div class="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
			</div>
		</div>
	<div class="col-lg-1"></div>
	</div>


<a href="/mypage">
	<input type="submit" 
	class="btn btn-primory form-control input width1 color font-dohyeon" 
	value="돌아가기" /></a>	

<jsp:include page="/WEB-INF/views/layout/paging_library.jsp" />	
</div>
</div>	
</div>
</div>


<jsp:include page="/WEB-INF/views/layout/footer.jsp" />