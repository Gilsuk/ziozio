<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:include page="/layout/header.jsp" /> 

<!-- 	<br> -->

<!-- 	<table class="table"> -->

<!-- 		<tr> -->

<!-- 			<td align="center" valign="middle" style="background-color: #FFFFCC"> -->

<!-- 				<form name="regForm" method="post" action=""> -->

<!-- 					<table> -->

<!-- 						<tr align="center" style="background-color: #8899aa"> -->

<!-- 							<td colspan="2"><h3 style="color: #FFFFFF">프로필 정보 수정</h3></td> -->

<!-- 						</tr> -->

<!-- 						<tr> -->

<!-- 							<td width="16%">아이디</td> -->

<!-- 							<td width="57%"><input type="text" name="id" size="15" -->
<!-- 								style="background-color: lightgray" readonly="readonly" -->
<!-- 								value=""></td> -->

<!-- 						</tr> -->

<!-- 						<tr> -->

<!-- 							<td>패스워드</td> -->

<!-- 							<td><input type="password" name="pass" size="15" -->
<!-- 								value=""></td> -->

<!-- 						</tr> -->

<!-- 						<tr> -->

<!-- 							<td>패스워드 확인</td> -->

<!-- 							<td><input type="password" name="repass" size="15"></td> -->

<!-- 						</tr> -->

<!-- 						<tr> -->

<!-- 							<td>닉네임</td> -->

<!-- 							<td><input type="text" name="name" size="15" -->
<!-- 								value=""></td> -->

<!-- 						</tr> -->
						
<!-- 						<tr> -->

<!-- 							<td>직업</td> -->

<!-- 							<td><select name="job" onselect="기타" onshow="기타"> -->
<!-- 									<option value="0">선택 -->
<!-- 									<option value="회사원">회사원 -->
<!-- 									<option value="학생">학생 -->
<!-- 									<option value="자영업">자영업 -->
<!-- 									<option value="주부">주부 -->
<!-- 									<option value="기타">기타 -->
<!-- 							</select></td> -->

<!-- 						</tr> -->

<!-- 						<tr> -->

<!-- 							<td>전화번호</td> -->

<!-- 							<td><input type="text" name="phone" size="20" -->
<!-- 								value=""></td> -->

<!-- 						</tr> -->

<!-- 						<tr> -->

<!-- 							<td>우편번호</td> -->

<!-- 							<td><input type="text" name="zipcode" size="7" -->
<!-- 								value=""> <input type="button" -->
<!-- 								value="우편번호찾기" id="btnZip"></td> -->

<!-- 						</tr> -->

<!-- 						<tr> -->

<!-- 							<td>주소</td> -->

<!-- 							<td><input type="text" name="address" size="60" -->
<!-- 								value=""></td> -->

<!-- 						</tr> -->

						

<!-- 						<tr> -->

<!-- 							<td colspan="2" align="center"><input type="button" -->
<!-- 								value="수정완료" id="btnModify" /> &nbsp;&nbsp; <input -->
<!-- 								type="button" value="수정취소" id="btnModifyCancel" /> <input -->
<!-- 								type="button" value="회원탈되" id="btnDelete" /></td> -->

<!-- 						</tr> -->

<!-- 					</table> -->

<!-- 				</form> -->

<!-- 			</td> -->

<!-- 		</tr> -->

<!-- 	</table> -->

<!-- </body> -->

<!-- </html> -->



<div class="wrapper" id="wrapper">
	
		<section class="content content--mypage">
		<header class="content_header" ><h1 class="content_title" style="font-size: 32px;">마이페이지</h1></header>
			<div class="content__side">
				<div class="profile-card">
					<i class="profile-card__bg"> <img alt="" src="">
					</i> <a class="profile-card__link" href=""> <img class="profile-card__pic" src="">
					</a> <span class="profile-card__text">아이디</span>
				</div>
				<nav class="side-nav">
					<ul class="side-nav__list">
						<li class="side-nav__item "><a href="">프로필 수정</a></li>
						<li class="side-nav__item "><a href="">회원 정보 변경</a></li>
						<li class="side-nav__item "><a href="">내가 쓴 글</a></li>
						<li class="side-nav__item "><a href="">내 옷장</a></li>
						<li class="side-nav__item"><a href="">선호하는 패션</a></li>
						<li class="side-nav__item"><a href="">옷 커스텀 하기</a></li>
					</ul>
				</nav>
			</div>
			
			<div class="content__body">
	<h2 class="content__title">프로필  수정</h2>
	<div class="tab tab--base-a tab--shape-c tab_mypage_info">
		<nav class="tab__nav">
			<ul class="tab__nav__items">
				<li class="tab__nav__items__item is-active"><a href="https://member.onstove.com/member/info" class="tab__nav__items__item__link is-unbind">프로필 정보</a></li>
			</ul>
		</nav>
		<div class="tab__content">
			<div class="tab__pane is-active">
				<div class="form-section">
                    <h3 class="form-section__title">프로필정보 설정</h3>
					<table class="table table--base-d">

                        <tbody id="nick_modify_on" >
                        <tr>
                            <th class="table__th">닉네임</th>
                            <td class="table__td">
                                <span class="text-bold"></span>
                                <div class="input-group">
                                    <input type="text" class="form-control--base-b" id="nickname" placeholder="변경 닉네임" maxlength="20" style="width: 100%;">
                                    <small>사용하실 닉네임을 입력해 주세요.</small>
                                </div>
                                <nav>
                                    <a href="#" class="button--base-m button--shape-c" id="chagneNick">
                                        <span class="button__text">변경</span>
                                    </a>
                                    <a href="#" class="button--base-m button--shape-a" onclick="cancel($('#nick_modify_off'), $('#nick_modify_on'))">
                                        <span class="button__text">취소</span>
                                    </a>
                                </nav>
                            </td>
                        </tr>
                        </tbody>
					<input type="hidden" id="user_id" value="">
						<caption>회원정보 설정</caption>
<!-- 						
						<tbody>
							<tr>
								<th class="table__th">프로필</th>
								<td class="table__td">
									<nav style="margin-bottom: 10px;">
										<!--
										<a href="#" class="button--base-m button--shape-c" onclick="fileSearch()">
											<span class="button__text">사진변경</span>
										</a>
										
										<span class="btn-file">
											<a href="#" class="button--base-m button--shape-c">
												<span class="button__text">사진변경</span>
											</a>
											<form method="post" target="fr" name="uploadForm" id="uploadForm" enctype="multipart/form-data">
												<input type="file" id="upload_image" name="image" class="form-file" accept="image/*" />
											</form>
										</span>
										<a href="#" class="button--base-m button--shape-a" onclick="deleteProfileImg()">
											<span class="button__text">삭제</span>
										</a>
									</nav>
									<small class="text-small">GIF, JPG, PNG 이미지와 700KB 이하만 등록 가능합니다.</small>
								</td>
							</tr>
						</tbody>
						-->
                        <tbody id="info_modify_off">
							<tr>
								<th class="table__th">생년월일</th>
								<td class="table__td">
										
								</td>
							</tr>
                        </tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
		</section>
	</div>





   
<jsp:include page="/layout/footer.jsp" />