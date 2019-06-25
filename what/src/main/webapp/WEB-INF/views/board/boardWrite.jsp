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
			<form class="form-horizontal" action="/board/boardSave.do" method="post">
			<input type="hidden" id="user_id" name="user_id" value="${uservo.user_id}">
			<input type="hidden" id="board_old_id" name="board_old_id" value="${board_old_id==null? '' : board_old_id}">
			<div class="form-group">
				<label for="board_title"></label>
				<input type="text" class="form-control" id="board_title" name="board_title" placeholder="제목을 입력해주세요" autocomplete="off" required autofocus>
			</div>
			<div class="form-group">
				<label for="board_body"></label>
				<textarea rows="10" cols="" class="form-control" id="board_body" name="board_body" placeholder="내용을 입력해주세요" required></textarea>
			</div>
			<button class="btn btn-primary" type="submit">저장</button>
			<button class="btn btn-default" type="button" onclick="location.href='/board/boardList.do' ">취소</button>
			</form>
		</div>
	</div>
	
</body>
</html>
