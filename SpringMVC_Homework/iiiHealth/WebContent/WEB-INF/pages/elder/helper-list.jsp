<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	rel="stylesheet" />
<!-- <script type="text/javascript" -->
<!-- 	src="https://gc.kis.v2.scr.kaspersky-labs.com/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/main.js?attr=CJuop6gIt_2wDZluUZr6TU8GAI5W_DvE3Q8RjyThL62GmmPY9qzmRyo2I1sAwTqQo49wsRPe6-Wdov66JPvKlTBYruiRWeZv8PpKKeLcX9BDPvuBxVqv90oFHCjkWARuSoa25ABLECOY0YJ0bfuFbv6Jx4WRUXgOlDzHgQYc8XT2c0Pv0Xn4XoZO4w5eHC5CYLZAIxoOsn2YdBwEA2CAbnBZIPKrsIT9tuIeBI_6iemgBTppaa3vpDgp1CN9vBsR1lpamT3aajoUES0WrKOk7B-EP3jOCBHxdFGa5j7i7xjX_m9L23i219CYCLK4WwAvBo7eTGEWKw6E6ZZuFEF87eVdab-aYMpY70iHmqDl6AiFND22a_dgxAuF6E1wwCGXYC4tgPVQVc6JfDrqpYUr91GwpWLpiVWLvaLaneUW1C9-OhLSy2UKXPeUTjnxfIyXjdyslHei6-NS83wwlXQ75g" -->
<!-- 	charset="UTF-8"></script> -->
<!-- <link rel="stylesheet" crossorigin="anonymous" -->
<!-- 	href="https://gc.kis.v2.scr.kaspersky-labs.com/E3E8934C-235A-4B0E-825A-35A08381A191/abn/main.css?attr=aHR0cHM6Ly9kb2MtMGstNmMtZG9jcy5nb29nbGV1c2VyY29udGVudC5jb20vZG9jcy9zZWN1cmVzYy9nNGQ0ZWNydjZvOTlwZTFtbXNjaGxyMTBnMXQ4M2J2YS9zZnRnbWhsYzcxa2lnZDhvOHNzdGhmMnJvMjZwczhudS8xNjI3NjI3MDUwMDAwLzAxODM4MzU4OTI3NzEwMDYzNzQ3LzA3ODI5MjYyMDA1ODM5NzM2MDAxLzFSSnZ0Y0l3c08tSURUZm5fbjRPVFB1TGhEUXFfTEpTMz9lPWRvd25sb2FkJmF1dGh1c2VyPTAmbm9uY2U9Z2VobTI3aWw1anAxbyZ1c2VyPTA3ODI5MjYyMDA1ODM5NzM2MDAxJmhhc2g9NGQ0OTdpZTg5c3Vmc3A2ZmN2N2UwbXV2Ym5xdXBkb2w" /> -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
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
				<div class="container-fluid px-4">
					<h1 class="mt-4">看護管理系統</h1>


					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> 看護資料
						</div>
						<div class="card-body">

							<div>
								<input type="button" value="新增一筆資料"
									onclick="window.location.href='showFormForAdd'" />
							</div>
							<br />

							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>姓名</th>
										<th>電話</th>
										<th>信箱</th>
										<th>服務地區</th>
										<th>時薪</th>
										<th>日薪</th>
										<th>更新</th>
										<th>刪除</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="helper" items="${list}">
										<tr>
											<td>${helper.name}</td>
											<td>${helper.phone}</td>
											<td>${helper.mail}</td>
											<td>${helper.location}</td>
											<td>${helper.hourPrice}</td>
											<td>${helper.dayPrice}</td>
											<td>
												<form action="showUpdate" method="post">
													<input type="hidden" name="id" value="${helper.id}" /> 
													<input type="image" src="${pageContext.request.contextPath}/resources/images/update.png" />
												</form>
											</td>
											<td>
												<form action="delete" method="post">
													<input type="hidden" name="id" value="${helper.id}" /> 
													<input type="image" src="${pageContext.request.contextPath}/resources/images/delete.png"  onclick="if(!(confirm('是否確定刪除這筆資料?'))) return false" />
												</form>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
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
	<script
		src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/chart-area-demo.js"></script>
	<script src="assets/demo/chart-bar-demo.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/datatables-simple-demo.js"></script>

	<!--  sweet alert -->
	<script
		src="${pageContext.request.contextPath}/resources/js/sweetalert2.all.min.js"></script>




<script>
	
	

/*		
			event.preventDefault();
				
			let id = id;
			
			Swal.fire({
			  title: 'Are you sure?',
			  text: "You won't be able to revert this!",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Yes, delete it!'
			}).then((result) => {
				  if (result.isConfirmed) {
					    Swal.fire(
					      'Deleted!',
					      'Your file has been deleted.',
					      'success'
					    )
					 
				} 
			})    

	}	
		
*/

	
		
		
</script>
</body>
</html>
