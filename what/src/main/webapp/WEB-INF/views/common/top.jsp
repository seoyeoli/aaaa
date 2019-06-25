<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div style="container-fluid; margin: 50px 50px 50px 50px;">
	<form id="topForm" method="post" action="/user/loginPage.do"><input type="hidden" value="" id="url" name="url"></form>
	<input type="hidden" id="topuserid" name="topuserid" value="${uservo.user_id}">
	<p align="right"> 
	
	<c:choose>
		<c:when test="${uservo ne null }"> 
			<a href="/user/userInfo.do?user_id=${uservo.user_id }" class="normallink" style="text-decoration: underline;">${uservo.user_name}</a><font style="font-size: 13px">님 환영합니다.</font>
			&nbsp; 
			<a href="/user/logout.do" class="normallink">로그아웃</a>
		</c:when>
		<c:otherwise>
			<a href="/user/signin.do" class="normallink">회원가입</a>
			<a href="javascript:void(0);" onclick="fn_loginPage()" class="normallink">로그인</a>
		</c:otherwise>
	</c:choose>
	</p> 
	<div class="row" style="background-color: black; align-content: center;"> 
		<div class="col-md-3" align="center" style="color: white"><a href="/common/main.do" class="topmenu"><b>MAIN</b></a></div> 
		<div class="col-md-3" align="center" style="color: white"><a href="/board/boardList.do" class="topmenu"><b>BOARD</b></a></div>
		<div class="col-md-3" align="center" style="color: white"><a href="javascript:void(0);" class="topmenu" onclick="fn_loginchkMovePage(true, '/schedule/scheduleList.do?user_id=${uservo.user_id}')"><b>SCHEDULE</b></a></div>
		<div class="col-md-3" align="center" style="color: white"><a href="javascript:void(0);" class="topmenu" onclick="fn_loginchkMovePage(true, '/program/progList.do?user_id=${uservo.user_id}')"><b>PROGRAM</b></a></div> 
	</div>
</div>