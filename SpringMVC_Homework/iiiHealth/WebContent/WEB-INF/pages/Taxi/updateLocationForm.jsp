<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="index.html">控制中心</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search-->
		<form
			class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<div class="input-group">
				<input class="form-control" type="text" placeholder="Search for..."
					aria-label="Search for..." aria-describedby="btnNavbarSearch" />
				<button class="btn btn-primary" id="btnNavbarSearch" type="button">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</form>
		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
					class="fas fa-user fa-fw"></i></a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">
					<li><a class="dropdown-item" href="#!">Settings</a></li>
					<li><a class="dropdown-item" href="#!">Activity Log</a></li>
					<li><hr class="dropdown-divider" /></li>
					<li><a class="dropdown-item" href="../Member/PostLoginAP">登出</a></li>
				</ul></li>
		</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						 <div class="sb-sidenav-menu-heading">會員中心</div>
                            <a class="nav-link" href="../Member/searchAllHealthAction.controller">  >
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                會員系統
                            </a>
						<div class="sb-sidenav-menu-heading">長照服務</div>
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseLayouts1" aria-expanded="false"
							aria-controls="collapseLayouts1">
							<div class="sb-nav-link-icon">
								<i class="fas fa-chart-area"></i>
							</div> 叫車系統
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseLayouts1"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="../Taxi/taxisystemEntry.controller">計程車資訊</a>
								<a class="nav-link" href="../Taxi/locsystemEntry.controller">店家資訊</a>
							</nav>
						</div>
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseLayouts" aria-expanded="false"
							aria-controls="collapseLayouts">
							<div class="sb-nav-link-icon">
								<i class="fas fa-columns"></i>
							</div> 長照系統
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseLayouts"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="${pageContext.request.contextPath}/helper/list">看護系統</a>
									<a class="nav-link" href="${pageContext.request.contextPath}/equip/list">輔具系統</a> 
									<a class="nav-link" href="${pageContext.request.contextPath}/order/list">輔具訂單系統</a>
                                </nav>
						</div>



						<div class="sb-sidenav-menu-heading">營養與藥品管理</div>
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseLayouts3" aria-expanded="false"
							aria-controls="collapseLayouts3">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> 營養管理系統
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseLayouts3"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link"  href="../meals/mealView.controller">營養餐管理</a> 
								<a class="nav-link"  href="../diet/dietView.controller">食品資料管理</a>

							</nav>
						</div>
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseLayouts4" aria-expanded="false"
							aria-controls="collapseLayouts4">
							<div class="sb-nav-link-icon">
								<i class="fas fa-book-open"></i>
							</div> 用藥查詢系統
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<div class="collapse" id="collapseLayouts4"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="../Drugs/Drugs">藥品辨識系統</a> 
									<a class="nav-link" href="../Drugs/DrugsProduct">藥品包裝變更</a>
                          
                                </nav>
						</div>

					</div>
				</div>
				<div class="sb-sidenav-footer">
					<div class="small">Logged in as:</div>
					Start Bootstrap
				</div>
			</nav>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-table me-1"></i> 店家資訊
						</div>
						<div class="row">

							<div class="col-md-6">
								<h2 style="text-align: center">請更新註冊資料</h2>
								<div class="card-body">
									<form:form method="POST"
										action="updateLocationCheck.controller"
										modelAttribute="updatelocation">
										<table class="table  table-hover">
											<tr>
												<td><form:label path="id">編號:</form:label></td>
												<td><form:input path="id" readonly="true" /></td>
												<td><form:hidden path="id" /></td>

											</tr>
											<tr>
												<td><form:label path="lName">店家名稱:</form:label></td>
												<td><form:input path="lName" /></td>
												<td><span id="idsp1"></span></td>
											</tr>
											<tr>
												<td><form:label path="type">類別:</form:label></td>
												<td><form:select path="type">
														<form:option value="-1" label="--請選擇--" />
														<form:options items="${typeItems}" />
													</form:select></td>
												<td><span id="idsp2"></span></td>
											</tr>
											<tr>
												<td><form:label path="healthInsurance">是否為健保特約店家:</form:label></td>
												<td><form:radiobutton path="healthInsurance"
														value="Yes" label="是" /> <form:radiobutton
														path="healthInsurance" value="No" label="否" /></td>
											</tr>
											<tr>
												<td><form:label path="phoneNum">電話:</form:label></td>
												<td><form:input path="phoneNum" /></td>
											</tr>
											<tr>
												<td><form:label path="time">營業時間:</form:label></td>
												<td><form:input path="time" /></td>
											</tr>
											<tr>
												<td><form:label path="closeDay">店休日:</form:label></td>
												<td><form:input path="closeDay" /></td>
											</tr>
											<tr>
												<td><form:label path="city">縣市:</form:label></td>
												<td><form:select path="city">
														<form:option value="-1" label="--請選擇--" />
														<form:options items="${typeItems}" />
													</form:select></td>
											</tr>
											<tr>
												<td><form:label path="town">鄉鎮市區:</form:label></td>
												<td><form:select path="town">
														<form:option value="-1" label="--請選擇--" />
														<form:options items="${typeItems}" />
													</form:select></td>
											</tr>
											<tr>
												<td><form:label path="address">地址:</form:label></td>
												<td><form:input path="address" /></td>
											</tr>
											<tr>
												<td><form:label path="brief">簡介:</form:label></td>
												<td><form:input path="brief" /></td>
											</tr>
											<tr>
												<td><form:label path="siting">網址:</form:label></td>
												<td><form:input path="siting" /></td>
											</tr>
											<tr>
												<td><input type="submit" value="送出" /></td>
												<td><input type="button" class="btn"
													onclick="history.back()" value="取消"></td>
											</tr>
										</table>
									</form:form>
								</div>
								<div class="col-md-6"></div>
							</div>
						</div>
					</div>
			</main>
		</div>
		<!-- 		<div class="divItem"> -->
		<!-- 			<label for="store" class="itemTitle">店家名稱:</label>  -->
		<!-- 			<input type="text" id="sName" name="sName" onblur="Onblur(this,sp1)" autofocus> -->
		<!-- 			<span id="idsp1"></span> -->
		<!-- 		</div> -->
		<!-- 		<div class="divItem"> -->
		<!-- 			<lable class="itemTitle">類別:</lable> -->
		<!--                 <select name="type"> -->
		<!--                 	<option value="0" selected>請選擇</option> -->
		<!--                     <option value="hosp">醫院</option> -->
		<!--                     <option value="med" >藥局</option> -->
		<!--                     <option value="care">長照</option> -->
		<!--                     <option value="meal">餐廳</option> -->
		<!--                 </select> -->
		<!--                 <span id="idsp2"></span> -->
		<!-- 		</div> -->
		<!-- 		<div class="divItem"> -->
		<!-- 			<label for="phoneNum" class="itemTitle">電話:</label> <input -->
		<!-- 				type="text" id="phoneNum" name="phoneNum" onblur="Onblur(this,sp3)"> -->
		<!-- 				<span id="idsp3"></span> -->
		<!-- 		</div> -->
		<!-- 		<div class="divItem"> -->
		<!-- 			<label class="itemTitle">縣市:</label> -->
		<!-- 			<select name='city'> -->
		<!-- 			<option value="0">請選擇 -->
		<%-- 			<%					 --%>
		<!-- // 				for (int i = 0; i < testCityDB.size(); ++i) { -->
		<!-- // 					out.println("<option value='" + testCityDB.getCityName(i) + "'>"); -->
		<!-- // 					out.println(testCityDB.getCityName(i)); -->
		<!-- // 					out.println("</option>");} -->
		<%-- 			%> --%>
		<!-- 			</select> -->
		<!-- 			<span id="idsp4"></span>		 -->
		<!-- 		</div> -->
		<!-- 		<div class="divItem"> -->
		<!-- 			<label class="itemTitle">鄉鎮市區:</label> -->

		<!-- 			<select name="town"> -->
		<!-- 			<option value="0">請選擇 -->
		<!-- 			</option> -->
		<!-- 			</select> -->
		<!-- 			<span id="idsp5"></span>	 -->
		<!-- 		</div> -->

		<!-- 		<div class="divItem"> -->
		<!-- 			<label for="address" class="itemTitle">地址:</label>  -->
		<!-- 			<input type="text" id="address" name="address" onblur="Onblur(this,sp6)"> -->
		<!-- 			<span id="idsp6"></span> -->
		<!-- 		</div> -->
		<!-- 		<div class="divItem"> -->
		<!-- 			<label for="brief" class="itemTitle">簡介:</label> -->
		<!--             <textarea name="brief" id="brief" cols="40" rows="5"></textarea>  -->

		<!-- 		</div> -->
		<!-- 		<div class="divItem"> -->
		<!-- 			<label for="siting" class="itemTitle">網站:</label> -->
		<!--             <input type="text" id="siting" name="siting">	 -->
		<!-- 		</div> -->

		<!-- 		<div class="sub"> -->
		<!-- 		<input type="button" class="btn" onclick="CheckandSub()" value="送出">	 -->
		<!-- 		<input type="button" class="btn" onclick="history.back()" value="取消"> -->
		<!-- 		</div> -->

		<%-- 		</form> --%>



		<script>
<%-- 		let CNarray=[<%  --%>
		
// 		for(int i=0; i<TownDB.size();i++){
// 			out.print("\""+TownDB.getCityName()[i]+"\","); 	
// 		};
<%-- 		%>]; --%>
		
<%-- 		let TNarray=[<%  --%>
// 		for(int j=0; j<TownDB.sizeT();j++){
// 			out.print("\""+TownDB.getTownName()[j]+"\",");			
// 		};		
<%-- 		%>]; --%>

//     	$("select[name='city']").on('change',function(){
//     		let CN=$("select[name='city']").val();
//     		let TN=$("select[name='town']")
//     		TN.empty();
//     		for(n=0; n<CNarray.length; n++ ){
//     			if(CN == CNarray[n]){
//     				TN.append($("<option></option>")
//     			             .attr("value", TNarray[n]).text(TNarray[n]));    				    				
//     			}
//     		}
//     	})
</script>
<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
			crossorigin="anonymous"></script>
		<script src="js/scripts.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
			crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
			crossorigin="anonymous"></script>
		<script src="js/datatables-simple-demo.js"></script>
		<script>
	let sp1=document.getElementById("idsp1");
	let sp3=document.getElementById("idsp3");
	let sp6=document.getElementById("idsp6");
	let type=document.getElementsByName("type")[0];
	let city=document.getElementsByName("city")[0];
	let town=document.getElementsByName("town")[0];
	
	
	function CheckandSub(){
		let flag1= Onblur(document.getElementById("sName"),sp1);
		let flag2= phoneCheck(document.getElementById("phoneNum"),sp3);
		let flag3= addressCheck(document.getElementById("address"),sp6);
		let flag4= checksel(type,idsp2);
		let flag5= checksel(city,idsp4);
		let flag6= checksel(town,idsp5);
		
		
		if (flag1 & flag2 & flag3 & flag4 & flag5 & flag6){
			document.getElementById("newLoc").submit();
		}else{
			alert("請輸入完整資訊");
		}
		
	}
	</script>
</body>
</html>