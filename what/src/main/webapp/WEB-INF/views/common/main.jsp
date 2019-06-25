<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<!-- js, 부트스트랩 등등 include -->
	<%@ include file="/WEB-INF/views/common/comm.jsp" %>
	<script type="text/javascript">
		$(document).ready(function(){
			var now = new Date();
			var year = now.getFullYear();
			var mon = (now.getMonth()+1) < 10 ? "0"+(now.getMonth()+1) : (now.getMonth()+1) ; //0이 1월이라서 +1함
			var day = now.getDate() < 10 ? "0"+ now.getDate() : now.getDate() ;
			var curdate = year+"."+mon+"."+day;
			document.getElementById("curdate").innerHTML = curdate;
			
		});
	</script>
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/top.jsp" %>
		<!-- 전체 div -->
		<div class="container" style="width: 1100px" > 
			<div class="row">
				<div class="col-md-3" style="height: 300px; padding: 10px 10px 10px 10px; border: 2px dotted gray"> 
					<a class="mainlink" onclick="fn_loginchkMovePage(true,'/user/userInfo.do?user_id=${uservo.user_id }')" href="#">INFO</a>
					<div>
						<div id="myinfo">
							<c:choose> 
								<c:when test="${uservo ne null}">
									<p>
										<br>
										${uservo.user_name}님 환영합니다.
										<br>
									</p>
									<div style="padding-left: 20px ; border-top: 1px solid lightgray" >
										<br>
										<h5 id="curdate"></h5>
										<table class="table">
										<c:choose>
											<c:when test="${fn:length(scheList)>0 }">
											<c:forEach items="${scheList}" var="srow" begin="0" end="4">
												<tr>
													<td>${srow.SCH_TIME}</td>
													<td>${srow.PROG_TYPE_NAME}</td> 
													<td>${srow.PROG_TRAINER_NAME}</td> 
												</tr>
											</c:forEach>
											</c:when>
											<c:otherwise>
												오늘의 일정이 없습니다.
											</c:otherwise>
										</c:choose>
										</table>
									</div>
								</c:when>
								<c:otherwise>
									<br>
									<p>로그인 하시면 정보를 확인할 수 있습니다.</p>
									<br> 
									 
									<button type="button" class="btn btn-primary btn-lg btn-block" onclick="fn_loginPage()">로 그 인</button> 
									<div style="text-align: right;"><a href="/user/signin.do" class="normallink">회원가입</a></div> 
								</c:otherwise> 
							</c:choose>
						</div>
					</div>
				</div> 
				<div class="col-md-8" style="background-color: white; padding: 10px 10px 10px 50px"> 
					<img src="../../../image/notice.png"> &nbsp; <a class="mainlink" href="/board/boardList.do">NOTICE</a>
					<br>
					<table class="table"> 
					<c:forEach var="row" items="${list}" begin="0" end="4" >
					<tr>
						<td><a class="boardlink" style="font-weight: bold;" href="/board/boardInfo.do?board_id=${row.BOARD_ID}">${row.BOARD_TITLE }</a></td>
						<td width="20%"><font style="font-size: 12px">${row.BOARD_WRT_DATE}</font></td> 
					</tr>
					</c:forEach>
							
					</table>
				</div>
			</div>
			
			
			
			<div class="row" style="padding-top: 50px">
				<div class="col-md-4">
					<img alt="" src="../../../image/mainimg1.jpg" class="img-thumbnail">
				</div>
				<div class="col-md-4">
					<img alt="" src="../../../image/mainimg2.jpg" class="img-thumbnail">
				</div>
				<div class="col-md-4">
					<img alt="" src="../../../image/mainimg3.jpg" class="img-thumbnail">
				</div>
			</div>
			
			
			
			
			
		</div>
	</div>
</body>
</html>