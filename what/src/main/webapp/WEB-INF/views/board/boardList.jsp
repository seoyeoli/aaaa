<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<!-- js, 부트스트랩 등등 include -->
	<%@ include file="/WEB-INF/views/common/comm.jsp" %>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/top.jsp" %>
	<script type="text/javascript">
		//공지사항 숨기기 기능
		function fn_isShow(){
			var flag = '';
			if(document.getElementById("showFlag").checked){
				flag = true;	
			}
			
			var noticeData = document.getElementsByClassName("notice");
			for (var i=0; i < noticeData.length; i++){
				noticeData[i].hidden = flag;
			}
			
		}
		
	</script>
	
	<div class="wrap">
	
		<div class="container">
			<b style="text-decoration: underline; font-size: 20px">BOARD</b>
			<div class="row">
				<div class="col-md-6" align="left">
					<button class="btn btn-default" onclick="fn_loginchkMovePage(true,'/board/boardWrite.do')" ><font style="font-size: 14px">글쓰기</font></button>
				</div> 
				<div class="col-md-6" align="right"><font style="font-size: 14px">
					공지사항 숨기기 &nbsp;</font><input type="checkbox" name="showFlag" id="showFlag" onclick="fn_isShow()">
				</div>
			</div>
			<table class="table" id="boardTable">
				<!-- 공지사항 -->
				<c:choose>
					<c:when test="${fn:length(noticeList)>0 }">
					<c:forEach items="${noticeList}" var="norow" begin="0" end="4">
						<tr id="notice" class="notice">
							<th width="10%"><img src="../../../image/notice.png"></th> 
							<th colspan="2" ><a class="boardlink" style="font-weight: bold;" href="/board/boardInfo.do?board_id=${norow.BOARD_ID}">${norow.BOARD_TITLE }</a></th>
							<th width="20%">${norow.BOARD_WRT_DATE }</th>
						</tr>
					</c:forEach>
					</c:when>
					<c:otherwise>
						<input type="hidden" id="notice" >
					</c:otherwise>
				</c:choose>
				<!-- 최신글 -->
				<c:choose>
					<c:when test="${fn:length(boardList)>0}">
						<c:forEach items="${boardList}" var="row">
							<tr>
								<td width="10%">${row.ROW_NUM }</td>
								<td><a class="boardlink" href="/board/boardInfo.do?board_id=${row.BOARD_ID}">${row.BOARD_TITLE }</a></td>
								<td width="15%">${row.USER_NAME }</td>
								<td width="20%">${row.BOARD_WRT_DATE }</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="4">등록된 글이 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>
</body>
</html>


