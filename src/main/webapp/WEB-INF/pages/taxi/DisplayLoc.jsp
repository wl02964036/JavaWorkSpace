<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
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
<style>
td{
	padding:10px 20px;
	border-bottom: 1px solid #D0D0D0;
	}
</style>
	

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
					<li><a class="dropdown-item" href="/logout">登出</a></li>
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
                            <a class="nav-link" href="/HealthProject/ManagerHealth/searchAllManagerAction.controller">
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
								<a class="nav-link" href="${pageContext.request.contextPath}/taxi/taximainpage.controller">計程車資訊</a>
								<a class="nav-link" href="${pageContext.request.contextPath}/taxi/locmainpage.controller">店家資訊</a>
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
									<a class="nav-link" href="${pageContext.request.contextPath}/equip/findall">輔具系統</a> 
									<a class="nav-link" href="${pageContext.request.contextPath}/order/findall">輔具訂單系統</a>
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
								<a class="nav-link"  href="${pageContext.request.contextPath}/meals/mealView.controller">營養餐管理</a> 
								<a class="nav-link"  href="${pageContext.request.contextPath}/diet/dietView.controller">食品資料管理</a>
									

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
                                    <a class="nav-link" href="${pageContext.request.contextPath}/Drug/findalldrug">藥品辨識系統</a> 
									<a class="nav-link" href="${pageContext.request.contextPath}/DrugProduct/findalldrugproduct">藥品包裝變更</a>
                          
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
								<h4 style="margin: 10px 20px; text-align: center">登記資料如下請確認</h4>
								<div class="card-body">

									<form action="addloc" method="post" id="okk">
										<table style="margin: 10px auto">
											<tr>
												<td>店家名稱</td>
												<td>${locCheck.store}</td>
												<td><input type="hidden" name="store"
													value="${locCheck.store}"></td>
											</tr>
											<tr>
												<td>類別</td>
												<td>${locCheck.type}</td>
												<td><input type="hidden" name="type"
													value="${locCheck.type}"></td>
											</tr>
											<tr>
												<td>醫療類別</td>
												<td>${locCheck.hos_type}</td>
												<td><input type="hidden" name="hos_type"
													value="${locCheck.hos_type}"></td>
											</tr>
											<tr>
												<td>電話</td>
												<td>${locCheck.phone}</td>
												<td><input type="hidden" name="phone"
													value="${locCheck.phone}"></td>
											</tr>
											<tr>
												<td>營業時間</td>
												<td>${locCheck.time}</td>
												<td><input type="hidden" name="time"
													value="${locCheck.time}"></td>
											</tr>
											<tr>
												<td>店休日</td>
												<td>${locCheck.close_day}</td>
												<td><input type="hidden" name="close_day"
													value="${locCheck.close_day}"></td>
											</tr>
											<tr>
												<td>縣市</td>
												<td>${locCheck.city}</td>
												<td><input type="hidden" name="city"
													value="${locCheck.city}"></td>
											</tr>
											<tr>
												<td>鄉鎮市區</td>
												<td>${locCheck.town}</td>
												<td><input type="hidden" name="town"
													value="${locCheck.town}"></td>
											</tr>
											<tr>
												<td>地址</td>
												<td>${locCheck.address}</td>
												<td><input type="hidden" name="address"
													value="${locCheck.address}"></td>
											</tr>
											<tr>
												<td>簡介</td>
												<td>${locCheck.brief}</td>
												<td><input type="hidden" name="brief"
													value="${locCheck.brief}"></td>
											</tr>
											<tr>
												<td>網站</td>
												<td>${locCheck.site}</td>
												<td><input type="hidden" name="site"
													value="${locCheck.site}"></td>
											</tr>
										</table>
										<div class="sub" style="text-align: center">
											<input type="button" name="confirm" value="確認" style="margin:10px 25px" onclick="okk()">
											<input type="button" onclick="document.querySelector('#back').submit()" value="回上頁" style="margin:10px 25px">
										</div>
									</form>
									<form id="back" action="addback" method="post">
										<input type="hidden" name="store" value="${locCheck.store}">
										<input type="hidden" name="type" value="${locCheck.type}">
										<input type="hidden" name="hos_type" value="${locCheck.hos_type}">
										<input type="hidden" name="phone" value="${locCheck.phone}">
										<input type="hidden" name="time" value="${locCheck.time}">
										<input type="hidden" name="close_day" value="${locCheck.close_day}">
										<input type="hidden" name="city" value="${locCheck.city}">
										<input type="hidden" name="town" value="${locCheck.town}">
										<input type="hidden" name="address" value="${locCheck.address}">
										<input type="hidden" name="brief" value="${locCheck.brief}">
										<input type="hidden" name="site" value="${locCheck.site}">
									
									</form>
								</div>
							</div>
							<div class="col-md-6"></div>
						</div>
					</div>
			</main>
		</div>
		
		<script src="../js/sweetalert2.all.min.js"></script>
		<script>
	function okk(){
		Swal.fire({
			  icon: 'success',
			  title: '新增成功',
			  showConfirmButton: false,
			  timer: 1500
			})	
			setTimeout(() => document.getElementById("okk").submit(), 1600)
	}
	</script>
</body>

</html>