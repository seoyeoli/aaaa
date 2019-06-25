<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<!-- js, 부트스트랩 등등 include -->
	<%@ include file="/WEB-INF/views/common/comm.jsp" %>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/top.jsp" %>
	
	<div class="wrap">
		<div class="container">
			<input type="hidden" id="user_id" name="user_id" value="${user_id}">
			<input type="hidden" id="board_old_id" name="board_old_id" value="${board_old_id==null? '' : board_old_id}">
			
			<div align="right">
			<c:choose>
			<c:when test="${uservo.user_id eq boardvo.user_id}">
				<button class="btn btn-default" type="button">수정</button>
				<button class="btn btn-default" type="button">삭제</button>
			</c:when>
			</c:choose>
			<button class="btn btn-default" type="button" onclick="location.href='/board/boardList.do' ">목록</button>
			</div>
			
			<table class="table">
				<tr>
					<td colspan="2"><h2>${boardvo.board_title}</h2></td>
				</tr>
				<tr> 
					<td>작성자 : ${boardvo.user_name} </td>
					<td align="right">${boardvo.board_wrt_date}</td>
				</tr>
				<tr>
					<td colspan="2"><p style="white-space:pre-wrap;"> ${boardvo.board_body} </p></td>
				</tr>
			</table>
			
		</div>
	</div>
	
</body>
</html>
