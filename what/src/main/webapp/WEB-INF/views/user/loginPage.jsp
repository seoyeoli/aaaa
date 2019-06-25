<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<!-- js, 부트스트랩 등등 include -->
	<%@ include file="/WEB-INF/views/common/comm.jsp" %>
	<!-- Custom styles for this template --> 
</head>
<body>
	
	<div id="wrap">
		<div class="container" style="width:300px">
			<div class="text-center mb-4">
			<br><br>
			<a href="/common/main.do"><img src="../../../image/mjgym.jpeg" width="280" height="280" ></a>
			<br><br>
			</div>
			<form action="/user/login.do" id="loginForm" name="loginForm" method="post" class="form-signin">
			<div class="form-label-group">
				<input type="text" id="user_id" name="user_id" maxlength="15" placeholder="아이디" class="form-control" required autofocus>
				<label for="user_id">아이디</label>
			</div>
			
			<div class="form-label-group">
				<input type="password" id="user_pw" name="user_pw" maxlength="15" placeholder="비밀번호" class="form-control" required>
				<label for="user_pw">비밀번호</label>
			</div>
			<input class="btn btn-lg btn-primary btn-block" type="submit" value="로그인" >
			<a href="/user/signin.do" class="normallink">아이디가 없나요? 회원가입</a>
			<a href="/user/signin.do" class="normallink">아이디</a> ·
			<a href="/user/signin.do" class="normallink">비밀번호 찾기 </a>
			<input type="hidden" id="loc" name="loc" value="/user/loginPage.do"> 
			<input type="hidden" id="url" name="url" value="${url}"> 
			</form>
		</div>
	</div>
	
</body>
</html>
