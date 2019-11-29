<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/layout/header.jsp" />


<!-- 회원 탈퇴 페이지 -->



<meta name="viewport" content="width=device-width, initial-scale=1">

<div class="container">




	<br>

	<h2>
		탈퇴 안내 <br> <small>회원탈퇴를 신청하기 전에 <mark>안내 사항</mark>을 꼭
			확인해주세요.</small>
	</h2>


	<hr>

	
	<ur>
	<div class="jumbotron">
		<div><li>탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제됩니다.</li></div>
		<div><li>회원정보 및 메일, 블로그, 주소록 등 개인형 서비스 이용기록은 모두 삭제되며, 삭제된 데이터는 복구되지
			않습니다. 삭제되는 내용을 확인하시고 필요한 데이터는 미리 백업을 해주세요.</li></div>
		<div><li>탈퇴 후에도 게시판형 서비스에 등록한 게시물은 그대로 남아 있습니다. 삭제를 원하는 게시글이 있다면 반드시
			탈퇴 전 비공개 처리하거나 삭제하시 바랍니다. 탈퇴 후에는 회원 정보가 삭제되어 본인 여부를 확인할 수 있는 방법이 없어,
			게시글을 임의로 삭제해드릴 수 없습니다.</li></div>
		<div><li>삭제를 원하는 게시글이 있다면 반드시 탈퇴 전 비공개 처리하거나 삭제하시기 바랍니다.</li></div>

	</div>
	</ur>

	

	<!-- 경고 모달창 -->
	<div class="modal fade" id="defaultModal">
		<div class="modal-dialog">
			<div class="modal-content panel-danger">
				<div class="modal-header panel-heading">
					<h4 class="modal-title">오류 메시지</h4>
				</div>
				<div class="modal-body">
					<p class="modal-contents"></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->

	<!--// 경고 모달창 -->
	
	<hr>
	
	<input type="checkbox" name="chk_info" value="HTML"> <strong><u><em>안내
				사항을 모두 확인하였으며, 이에 동의합니다.</em></u></strong> <br>

	<div class="text-center">
		<button type="button" class="btn btn-danger">확인</button>
	</div>

</div>


