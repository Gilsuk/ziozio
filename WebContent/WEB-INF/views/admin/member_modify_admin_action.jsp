<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="membermanger" class="member.MemberManager" />
<jsp:useBean id="bean" class="member.MemberBean" />
<jsp:setProperty property="*" name="bean" />

<!-- 회원수정 실행페이지 작성 -->
<%boolean b = membermanger.modifyData(bean);
	if(b){
%>

<script>

		alert("수정되었습니다");

		location.href="membermanager.jsp"

</script>

<%	} else { %>

<script>

		alert("수정 실패!");

		history.back();

	</script>

<%	} %>


<!-- 일단 만들었는데 우리는 이거 필요없을것같은데.. admin_form 자세히 보고 최대한 없애는 걸로.. -->