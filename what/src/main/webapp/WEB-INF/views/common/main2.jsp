<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<!-- js, 부트스트랩 등등 include -->
	<%@ include file="/WEB-INF/views/common/comm.jsp" %>
	
    <script type="text/javascript">
    function fn_loginPage(){location.href='/user/loginPage.do';}
	</script>
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/top.jsp" %>
		<!-- 전체 div -->
		<div class="container" style="width: 1100px" > 
			<div class="row">
				<div class="col-md-3" style="height: 500px; padding: 10px 10px 10px 10px; border: 2px dotted gray"> 
					<a><b style="text-decoration: underline;">INFO</b></a>
					<div>
						<div id="myinfo">
							<c:choose> 
								<c:when test="${uservo ne null}">
									<p>
									${uservo.user_name}님 환영합니다.<br>
									회원권은 [${uservo.user_num}]일, PT는 [${uservo.user_id}]회 남았습니다.<br> 
									
									PT 스케줄 ▼ <br>
									
									프로그램 스케줄 ▼ <br>
									
									</p>
								</c:when>
								<c:otherwise>
									<br>
									<p><a style="text-decoration: underline;">로그인</a> 하시면 정보를 확인할 수 있습니다.</p>
									<br>
									
									<form id="loginForm" action="/user/login.do" method="post">
									<div class="form-label-group">
										<input type="text" class="form-label-group" id="user_id" name="user_id" placeholder="ID" autocomplete="off" maxlength="15" required autofocus>
										<label for="user_id">ID</label>
									</div>
									<div class="form-label-group">
										<input type="password" class="form-label-group" id="user_pw" name="user_pw" placeholder="비밀번호" autocomplete="off" maxlength="15" required>
										<label for="user_pw">비밀번호</label>
									</div>
									<input type="hidden" id="loc" name="loc" value="/common/main.do"> 
									<button type="submit" class="btn btn-primary" >로그인</button>
									&nbsp; 
									</form>
									<button type="button" class="btn btn-primary btn-lg btn-block" onclick="fn_loginPage()">로 그 인</button> 
									<a href="/user/signin.do" class="normallink">회원가입</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div> 
				<div class="col-md-8" style="background-color: white; padding: 10px 10px 10px 50px"> 
					<a><b style="text-decoration: underline;">NOTICE</b></a>
					<table class="table"> 
					<tr>
						<th>
						</th>
					</tr>
					<c:forEach var="row" items="${list}" >
					<tr>
						<td>
						</td>
					</tr>
					</c:forEach>
							
					</table>
				</div>
			</div>
			
			
		</div>
	</div>
</body>
</html>