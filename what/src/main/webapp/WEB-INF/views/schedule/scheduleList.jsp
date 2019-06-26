<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<!-- js, 부트스트랩 등등 include -->
	<%@ include file="/WEB-INF/views/common/comm.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			//>>>>>>>>캘린더 설정& 선택 시 날짜 세팅 START
			flatpickr("#myDatePicker", {
				"allowInput" : true,
				"inline" : true, 
				"onOpen" : function(selectedDates, dateStr, instance) {
					instance.setDate(instance.input.value, false);
				},
				"defaultDate" : "today",
				"onChange" : function(){
					//>>>>캘린더 변경 이벤트 START
					document.getElementById("selDay").innerHTML = document.getElementById("myDatePicker").value;
					var data = {"user_id":document.getElementById("topuserid").value, 
								"sch_day":document.getElementById("selDay").innerText};
					//Ajax로 날짜 선택 시 해당 일자 스케쥴 불러오기
					$.ajax({
						url:"/schedule/daySchedule.do",
						type:"POST",
						dataType:"json",
						contentType:"application/json",
						data:JSON.stringify(data),
						success:function(data){
							
							var tab = document.getElementById("scheTable");
							var inhtml = '';
							
							$.each(data,function(key,value){
								//alert(value['SCH_ID']);
								if(value['SCH_ID'] != null){
									inhtml = inhtml + "<tr> <td>"+value['SCH_TIME']+"</td><td>"+value['PROG_REMARK']+"</td></tr>" ;
								}
							});
							
							tab.innerHTML = inhtml;
						},
						error:function(){
							alert("잠시 후 다시 시도해주세요."); 
						}
					});
					//<<<<캘린더 변경 이벤트 END
				}
			});
			//<<<<<<<<< 캘린더 설정& 선택 시 날짜 세팅 END
			
			
			//>>>>문서 로딩 시 오늘 날짜에 대한 스케줄 세팅 START
			document.getElementById("selDay").innerHTML = document.getElementById("myDatePicker").value;
			var list = ${jsonData};
			if(list != null){  
				var tab = document.getElementById("scheTable");
				var inhtml = '';
				
				$.each(list,function(key, value){
					if(value['SCH_ID'] != null){
						inhtml = inhtml + "<tr> <td>"+value['SCH_TIME']+"</td><td>"+value['PROG_REMARK']+"</td></tr>" ;
					}
				});
				tab.innerHTML = inhtml;
			}
			//<<<<문서 로딩 시 오늘 날짜에 대한 스케줄 세팅END
			
			
			//>>>>>>>스케줄 등록 시 MODAL 화면에 flatfickr START
			flatpickr("#addPicker", {
				"allowInput" : true,
				"enableTime" : true,
				"dateFormat" : "Y-m-d H:i",
				"inline" : true, 
				"onOpen" : function(selectedDates, dateStr, instance) {
					instance.setDate(instance.input.value, false);
				},
				"defaultDate" : "today",
				"onChange" : function(){
					document.getElementById("modalSelDate").innerHTML = document.getElementById("addPicker").value;
				}
			});
			//<<<<<<<<<<< 스케줄 등록 시 MODAL 화면에 flatfickr END
			
			
			
			//>>>>>>>>>>> 등록 Modal 보여질때 프로그램 목록 가져옴
			$('#myModal').on('shown.bs.modal', function () {
			  var progData = {"user_id":document.getElementById("topuserid").value};
				$.ajax({
					url:"/program/registProgList.do",
					type:"POST",
					dataType:"json",
					contentType:"application/json",
					data:JSON.stringify(progData),
					success:function(data){
						
						var sel = document.getElementById("program");
						var inhtml = "<option value=''>프로그램을 선택해주세요</option>";
						
						$.each(data,function(key,value){
							if(value['PROG_ID'] != null){
								inhtml = inhtml + "<option value='"+value['PROG_ID']+"'>"+value['PROG_NAME']+"</option>"; 
							}
						});
						sel.innerHTML = inhtml;
					},
					error:function(){
						alert("잠시 후 다시 시도해주세요."); 
					}
				});
			});
			//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			
			
			
		});
		
		//>>>>>>>>>>> 저장버튼 클릭 시
		function fn_save(){
			
		}
		//<<<<<<<<<<<
		
		
	</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/top.jsp" %>
	
	<div class="wrap">
	<div class="container">
	
	<!-- 캘린더와 일정 보여주는 DIV -->
	<div class="row">
		<div class="col-md-5" align="center">
			<input type="text" class="selector" id="myDatePicker" placeholder="날짜를 선택하세요." hidden="true"/>
		</div>
		<div class="col-md-7" style="padding-left:50px;padding-top:20px ">
			<h2 id="selDay"></h2>
			<br>
			<table class="table" id="scheTable"> 
			</table>
		</div>
	</div>
	
	
	</div>
	</div>
	
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">
		등록
	</button>
	
	<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">  
				<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">등록하기</h4>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				</div>
				<div class="modal-body">
				<div class="row" style="margin:20px 20px 20px 20px">
					<div>
					<input type="text" class="selector" id="addPicker" placeholder="날짜를 선택하세요." hidden="true"/>
					</div>
					
					<div style="padding: 5px 5px 5px 10px">
					<table>
					
					<tr><td><h4 id="modalSelDate">등록 일자를 선택해주세요.</h4></td></tr>
					<tr><td>
					<select name="program" id="program">
						<option value="">프로그램을 선택해주세요</option>
					</select>
					</td></tr>
					
					</table>
					
					<form action="/schedule/scheduleSave.do" method="post">
						+
					</form>
					
					</div>
				</div>
				</div> 
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">close</button>
					<button type="button" class="btn btn-primary" onclick="fn_save()">save</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>
