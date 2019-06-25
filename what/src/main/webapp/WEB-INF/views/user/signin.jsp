<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<!-- js, 부트스트랩 등등 include -->
	<%@ include file="/WEB-INF/views/common/comm.jsp" %>

    <script type="text/javascript">
    	$(document).ready(function(){
    		
    	});
	</script>
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/top.jsp" %>
		<!-- 전체 div -->
		<div class="container" style="width: 1100px" >
			
			<div style="border: solid lightgray; padding: 50px 50px 50px 50px;">
			<h1 align="center"><b>회 원 가 입</b></h1>
			<br><br>
			<form id="signForm">
				<div class="form-group">
					<label for="user_id">ID</label>
					<input type="text" class="form-control" id="user_id" name="user_id" placeholder="ID" autocomplete="off">
				</div>
				<div class="form-group">
					<label>이름</label>
					<input type="text" class="form-control" id="user_name" name="user_name" placeholder="이름" autocomplete="off">
				</div>
				<div class="form-group">
					<label for="user_no">회원번호 <small>(회원번호는 헬스장에서 받으실 수 있습니다.)</small></label>
					<input type="text" class="form-control" id="user_num" name="user_num" placeholder="회원번호" autocomplete="off">
				</div>
				<div class="form-group">
					<label>비밀번호</label>
					<input type="password" class="form-control" id="user_pw" name="user_pw" placeholder="비밀번호" autocomplete="off">
				</div>
				<div class="form-group">
					<label>비밀번호 확인</label>
					<input type="password" class="form-control" id="user_pw2" placeholder="비밀번호 확인" autocomplete="off">
				</div>
				<div class="form-group">
					<label>생년월일</label> 
					<input type="text" class="form-control" id="user_birthday" name="user_birthday" placeholder="예) 19910101" autocomplete="off">
				</div>
				<div class="form-group">
					<label>핸드폰번호</label>
					<input type="text" class="form-control" id="user_phone" name="user_phone" placeholder="예) 010-1234-5678" autocomplete="off">
				</div>
				<button type="button" class="btn btn-primary">회원가입</button>
			</form>
			</div>
			<br><br><br>
			
		</div>
	</div>
</body>
	
</html>