<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>健康優生網</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="../css/styles.css" rel="stylesheet" />
<script type="text/javascript" src="../js/function.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<script src="../js/jquery-3.6.0.js"></script>
</head>

<body class="sb-nav-fixed">

		<div id="layoutSidenav_content">
			<main>
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-table me-1"></i> 會員系統
						</div>
						<div class="row">
							
							<div class="col-md-6">
								<h2 style="margin: 8px 150px">會員註冊</h2>
								<div class="card-body">
										<table class="table  table-hover">
									<form:form id="form1" method="POST" action="/HealthProject/displayInsertMember" modelAttribute="member" enctype="multipart/form-data">
											<tr>
												<td><form:label path="membername">被看護人姓名:</form:label></td>
												<td>
													<form:input path="membername" size="10" placeholder="例如:王衍申" autofocus="autofocus"/>
													<span id="nameCheck"></span>
												</td>
											</tr>
											<tr>
												<td><form:label path="membergender">性別:</form:label></td>
												<td>
													<form:radiobutton path="membergender" value="男" label="男" />
            										<form:radiobutton path="membergender" value="女" label="女" />
            										<form:radiobutton path="membergender" value="其他" label="其他" />
            										<span id="genderCheck"></span>
            									</td>
											</tr>
											<tr>
												<td><form:label path="memberyear">生日日期:</form:label></td>
												<td>
												民國 
													<form:input path="memberyear" maxlength="3" size="3" placeholder="70" />
												 年
													<form:input path="membermonth" maxlength="2" size="2" placeholder="7" />
												 月
													<form:input path="memberday" maxlength="2" size="2" placeholder="7" />
												 日
													<span id="birthCheck"></span>
												</td>
											</tr>
											<tr>
												<td><form:label path="memberaccount">帳號:</form:label></td>
												<td>
													<form:input path="memberaccount" maxlength="15" size="15" />
													<span id="accountCheck"></span>
												</td>
											</tr>
											<tr>
												<td><form:label path="memberpwd">密碼:</form:label></td>
												<td>
													<form:password path="memberpwd" maxlength="15" size="15" />
													<span id="pwd1Check"></span><br>
													<input type="checkbox" id="showPwd" />顯示密碼
												</td>
											</tr>
											<tr>
												<td><label id="pwd2">確認密碼:</label></td>
												<td>
													<input type="password" id="pwd2" maxlength="15" size="15" />
													<span id="pwd2Check"></span>
												</td>
											</tr>
											<tr>
												<td><form:label path="memberemail">E-mail:</form:label></td>
												<td>
													<form:input path="memberemail" size="15" placeholder="aaa@gmail.com" />
													<span id="emailCheck"></span>
												</td>
											</tr>
											<tr>
												<td><form:label path="memberphone">手機:</form:label></td>
												<td>
													<form:input path="memberphone" maxlength="10" size="10" />
													<span id="phoneCheck"></span>
												</td>
											</tr>
											<tr>
												<td><form:label path="membercity">居住縣市:</form:label></td>
												<td><form:select path="membercity"></form:select> 
												<span id="idsp4"></span></td>
											</tr>
											<tr>
												<td><form:label path="membertown">鄉鎮市區:</form:label></td>
												<td><form:select path="membertown">
													<option value=0>請選擇</option>
													</form:select> <span id="idsp5"></span></td>
											</tr>
											<tr>
												<td><form:label path="memberaddress">居住地址:</form:label></td>
												<td><form:input path="memberaddress" /> 
												<span id="idsp6"></span></td>
											</tr>
											<tr>
												<td><form:label path="handbook">身心障礙手冊/證明:</form:label></td>
												<td>
													<form:select path="handbook">
														<form:option value="-1" label="--請選擇--" />
														<form:options items="${handbookOption}" />
													</form:select>
													<span id="idsp2"></span>
												</td>
											</tr>
											<tr>
												<td><form:label path="dementia">失智症確診:</form:label></td>
												<td>
													<form:radiobutton path="dementia" value="有" label="有" />
            										<form:radiobutton path="dementia" value="無" label="無" />
            									</td>
											</tr>
											<tr>
												<td>大頭照預覽:</td>
												<td>
													<img id="sourceImage"  width="200px" height="200px">
												</td>
											</tr>
											<tr>
												<td>新增大頭照</td>
												<td>
													<input type="file" name="memberphoto" accept="image/*" id="inputImageFile" />
													<form:hidden path="memberphoto" />
												</td>
											</tr>
											<tr>
												<td><span style="color: red;" id="subBtnCheck"></span></td>
											</tr>
											<tr>
												<td style="text-align: center">
													<input type="submit" class="btn" id="btn" value="送出" />
												</td>
										</form:form>
												<td>
													<form action="/HealthProject" method="post">
														<input type="submit" class="btn" value="取消">
													</form>
												</td>
											</tr>
									</table>
								</div>
								<div class="col-md-6"></div>
							</div>
						</div>
					</div>
			</main>
		</div>

<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
			crossorigin="anonymous"></script>
		<script src="../js/scripts.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
			crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
			crossorigin="anonymous"></script>
		<script src="../js/datatables-simple-demo.js"></script>
		
		
		
<script type="text/javascript">

var cn = "${member.membercity}"
	var tn = "${member.membertown}"
		
	$(document).ready(function(){
		$.getJSON('/json/taiwan_districts.json',function(data){
			var resultText='';
			resultText="<option value=0>請選擇</option>";
			for(var i=0; i<data.length; i++){
				if(cn == (data[i].name)){
					resultText+="<option value='"+data[i].name+"' selected>"+data[i].name+"</option>"
				}else{
					resultText+="<option value='"+data[i].name+"'>"+data[i].name+"</option>"
				}
			}
			$("#membercity").html(resultText);
			let CN=$("select[name='membercity']").val();		
			for(n=0; n<data.length; n++ ){
    			if(CN == data[n].name){
    				var resultText2='';
    				for(var j=0; j<data[n].districts.length; j++){
    					if(tn == data[n].districts[j].name){
    						resultText2+="<option value='"+data[n].districts[j].name+"' selected>"+data[n].districts[j].name+"</option>"
    					}else{
    						resultText2+="<option value='"+data[n].districts[j].name+"'>"+data[n].districts[j].name+"</option>"
    					}
    				}
    			}
    		}	
			$("#membertown").html(resultText2);
		});
	$("select[name='membercity']").on('change',function(){
		$.getJSON('/json/taiwan_districts.json',function(data){	
			let CN=$("select[name='membercity']").val();		
			for(n=0; n<data.length; n++ ){
    			if(CN == data[n].name){
    				var resultText2='';
    				for(var j=0; j<data[n].districts.length; j++){
    					resultText2+="<option value='"+data[n].districts[j].name+"'>"+data[n].districts[j].name+"</option>"
    				}
    							    				
    			}
    		}	
			$("#membertown").html(resultText2);
		});		
	});
	});
	
	
	/* 更新圖片 or 上傳圖片 */
    $("#inputImageFile").change(function(e){
    	processImageFile(e.target.files[0]);
	});
    
    
    function processImageFile(imageObject) {
        //顯示分析的圖片
        var sourceImageUrl = URL.createObjectURL(imageObject);
        //document.querySelector("#sourceImage").src = sourceImageUrl;
        $("#sourceImage").attr('src', sourceImageUrl);
    }
	
</script>



		<script>
	let sp1=document.getElementById("idsp1");
	let sp3=document.getElementById("idsp3");
	let sp6=document.getElementById("idsp6");
	let type=document.getElementsByName("type")[0];
	let city=document.getElementsByName("city")[0];
	let town=document.getElementsByName("town")[0];
	
	
	function CheckandSub(){

		
		
		if (true){
			document.getElementById("newLoc").submit();
		}else{
			alert("請輸入完整資訊");
		}
		
	}
	</script>
</body>
</html>