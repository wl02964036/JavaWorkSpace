<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, tw.iiihealth.MyMember.Model.HealthBean"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html lang="en">
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
<link href="${pageContext.request.contextPath}/css/styles.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
</head>
<body class="sb-nav-fixed">

	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="#">控制中心</a>
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
							<div class="sb-nav-link-icon">
								<i class="fas fa-table"></i>
							</div> 會員系統
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
								<a class="nav-link"
									href="${pageContext.request.contextPath}/helper/list">看護系統</a>
								<a class="nav-link"
									href="${pageContext.request.contextPath}/equip/list">輔具系統</a> <a
									class="nav-link"
									href="${pageContext.request.contextPath}/order/list">輔具訂單系統</a>
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
								<a class="nav-link" href="../Drugs/Drugs">藥品辨識系統</a> <a
									class="nav-link" href="../Drugs/DrugsProduct">藥品包裝變更</a>

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
				<div class="container-fluid px-4">
					<h1 class="mt-4">會員系統</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">管理者介面</li>
					</ol>

					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> 刪除員工資料如下請確認
						</div>
						<div class="card-body">

							<div class="row">
								<div class="col-md-3"></div>
								<div class="col-md-6">
									<table class="table  table-hover">
										<tr>
											<td>員工編號:</td>
											<td>${empno}</td>
										</tr>
										<tr>
											<td>員工姓名:</td>
											<td>${ename}</td>
										</tr>
										<tr>
											<td>性別:</td>
											<td>${gender}</td>
										</tr>
										<tr>
											<td>身分證字號:</td>
											<td>${rocid1}</td>
										</tr>
										<tr>
											<td>生日:</td>
											<td>民國 ${year1} 年 ${month1} 月 ${day1} 日</td>
										</tr>
										<tr>
											<td width="150">公司名稱:</td>
											<td>${cname1}</td>
										</tr>
										<tr>
											<td>帳號:</td>
											<td>${account1}</td>
										</tr>
										<tr>
											<td>密碼:</td>
											<td>${pwd1}</td>
										</tr>
										<tr>
											<td>確認密碼:</td>
											<td>${pwd2}</td>
										</tr>
										<tr>
											<td>E-mail:</td>
											<td>${email1}</td>
										</tr>
										<tr>
											<td>電話:</td>
											<td>( ${phone1} ) ${phone2}</td>
										</tr>
										<tr>
											<td>公司縣市:</td>
											<td>${addr1}</td>
										</tr>
										<tr>
											<td>公司地址:</td>
											<td>( ${addr2} ) ${addr3}</td>
										</tr>
										<tr>
											<td>
												<form action="deleteHealthAction.controller" method="post">
													<input type="hidden" name="empno" value="${empno}">
													<input type="submit" name="insertToSQL" value="確認">
												</form>
											</td>
											<td>
												<form action="searchAllHealthAction.controller"
													method="post">
													<input type="submit" name="insertToSQL" value="返回上一頁">
												</form>
											</td>
										</tr>
									</table>
								</div>
								<div class="col-md-3"></div>
							</div>

						</div>
					</div>
				</div>
			</main>
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4">
					<div
						class="d-flex align-items-center justify-content-between small">
						<div class="text-muted">Copyright &copy; Your Website 2021</div>
						<div>
							<a href="#">Privacy Policy</a> &middot; <a href="#">Terms
								&amp; Conditions</a>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script
		src="${pageContext.request.contextPath}/assets/demo/chart-area-demo.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/demo/chart-bar-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script
		src="${pageContext.request.contextPath}/js/datatables-simple-demo.js"></script>
</body>
</html>