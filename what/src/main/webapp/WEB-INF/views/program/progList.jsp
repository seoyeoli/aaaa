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
	<div class="row">
		<div class="col-md-2"> <%@ include file="/WEB-INF/views/program/progNavi.jsp" %> </div>
		
		<div>
		<c:choose>
		<c:when test="${fn:length(progList)>0}">
			<c:forEach items="list" var="row">
			<div class="" style="margin: 10px 15px 10px 15px">
				<div></div>
				<div></div>
			</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
		
		</c:otherwise>
		</c:choose>
		</div>
	
	
	
	</div>
	</div>
	</div>
	
</body>
</html>
