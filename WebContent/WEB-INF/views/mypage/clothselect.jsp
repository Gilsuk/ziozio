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
				console.log("����")
				console.log(data)
				
				$("#resultLayout").html(data)
			}
			, error: function() {
				console.log("����")
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
<h2 class="">�� �ѷ�����</h2><br><br>
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
								<option value="1">��̴�</option>
								<option value="2">��ũ</option>
								<option value="3">���</option>
								<option value="4">����Ͻ�</option>
								<option value="5">ĳ���</option>
								<option value="6">���ú�����</option>
								<option value="7">����ũ</option>
								<option value="8">����Ʈ</option>
								<option value="9">���ñ۷�</option>
							</select>
						</div>
						
						<div class="form-group font-gothic" name="color" id="color">
							<label class="sr-only" for="color"></label>
							<select id="style" class="form-control width1" >
								<option value="01">����</option>
								<option value="02">��</option>
								<option value="03">����</option>
								<option value="04">īŰ</option>
								<option value="05">��Ȳ</option>
								<option value="06">���</option>
								<option value="07">����</option>
								<option value="08">�ʷ�</option>
								<option value="09">�ϴ�</option>
								<option value="10">�Ķ�</option>
								<option value="11">����</option>
								<option value="12">����</option>
								<option value="13">��ũ</option>
								<option value="14">������</option>
								<option value="15">ȸ��</option>
								<option value="16">��Ʈ</option>
								<option value="17">������</option>
								<option value="18">����</option>
								<option value="19">����</option>
								<option value="20">��</option>
								<option value="21">���̺���</option>
							</select>
						</div>
						
						<div class="form-group">
							<input  id="btncalc" type="submit" 
							class="btn btn-primory form-control input width color font-dohyeon" value="���ÿϷ�" />
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
	value="���ư���" /></a>	

<jsp:include page="/WEB-INF/views/layout/paging_library.jsp" />	
</div>
</div>	
</div>
</div>


<jsp:include page="/WEB-INF/views/layout/footer.jsp" />