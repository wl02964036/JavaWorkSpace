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
							<i class="fas fa-table me-1"></i> 新增員工資料
						</div>
						<div class="card-body">

							<div class="row">
								<div class="col-md-6">
									<form action="displayInsertHealth" method="post" id="form1"
										onsubmit="return checkSubBtn();">
										<table class="table  table-hover">
											<tr>
												<td>員工姓名:</td>
												<td><input type="text" id="ename1" name="ename"
													size="10" placeholder="例如:王衍申" autocomplete="off">
													<span id="enameCheck"></span></td>
											</tr>
											<tr>
												<td>性別:</td>
												<td><input type="radio" name="gender" id="sex1"
													value="male">男 <input type="radio" name="gender"
													id="sex2" value="female">女 <input type="radio"
													name="gender" id="sex3" value="other">其他 <span
													id="sexCheck"></span></td>
											</tr>
											<tr>
												<td>身分證字號:</td>
												<td><input type="text" name="rocid1" id="rocid1"
													maxlength="10" size="15" placeholder="例如:M140051653">
													<span id="rocidCheck"></span></td>
											</tr>
											<tr>
												<td>生日日期:</td>
												<td>民國 <input class="in" type="text" name="year1"
													id="year1" maxlength="3" size="3"> 年 <input
													class="in" type="text" name="month1" id="month1"
													maxlength="2" size="2"> 月 <input class="in"
													type="text" name="day1" id="day1" maxlength="2" size="2">
													日 <span id="birthCheck"></span></td>
											</tr>
											<tr>
												<td>公司名稱:</td>
												<td><input type="text" id="cname1" name="cname1"
													size="25" placeholder="例如:楊泰企業股份有限公司"> <span
													id="cnameCheck"></span></td>
											</tr>
											<tr>
												<td>帳號:</td>
												<td><input type="text" id="account1" name="account1"
													size="15"> <span id="acntCheck"></span></td>
											</tr>
											<tr>
												<td>密碼:</td>
												<td><input type="password" id="pwd1" name="pwd1"
													maxlength="15" size="15"> <span id="pwd1Check"></span><br>
													<input type="checkbox" id="showPwd">顯示密碼</td>
											</tr>
											<tr>
												<td>確認密碼:</td>
												<td><input type="password" id="pwd2" name="pwd2"
													maxlength="15" size="15"> <span id="pwd2Check"></span></td>
											</tr>
											<tr>
												<td>信箱:</td>
												<td><input type="text" name="email1" id="email1"
													size="15" placeholder="aaa@gmail.com"> <span
													id="emailCheck"></span></td>
											</tr>
											<tr>
												<td>電話:</td>
												<td>( <input class="addr" type="text" name="phone1"
													id="phone1" maxlength="4" size="4" placeholder="02">
													) <input type="text" name="phone2" id="phone2"
													maxlength="8" size="10" placeholder="66316666"> <span
													id="phoneCheck"></span></td>
											</tr>
											<tr>
												<td>公司縣市:</td>
												<td><select name="addr1" id="addr1">
														<option value="" style="color: lightgray;">--未選擇--</option>
														<optgroup label="北部">
															<option name="KLU" value="基隆市">基隆市</option>
															<option name="TPH" value="新北市">新北市</option>
															<option name="TPE" value="台北市">台北市</option>
															<option name="TYU" value="桃園市">桃園市</option>
															<option name="HSH" value="新竹縣">新竹縣</option>
															<option name="HSC" value="新竹市">新竹市</option>
															<option name="ILN" value="宜蘭縣">宜蘭縣</option>
														</optgroup>
														<optgroup label="中部">
															<option name="MAC" value="苗栗市">苗栗市</option>
															<option name="TXG" value="臺中市">臺中市</option>
															<option name="CWH" value="彰化縣">彰化縣</option>
															<option name="CWS" value="彰化市">彰化市</option>
															<option name="NTC" value="南投市">南投市</option>
															<option name="NTO" value="南投縣">南投縣</option>
															<option name="YLH" value="雲林縣">雲林縣</option>
														</optgroup>
														<optgroup label="南部">
															<option name="CHY" value="嘉義縣">嘉義縣</option>
															<option name="CYI" value="嘉義市">嘉義市</option>
															<option name="TNN" value="臺南市">臺南市</option>
															<option name="KHH" value="高雄市">高雄市</option>
															<option name="IUH" value="屏東縣">屏東縣</option>
															<option name="PTS" value="屏東市">屏東市</option>
														</optgroup>
														<optgroup label="東部">
															<option name="HWA" value="花蓮縣">花蓮縣</option>
															<option name="HWC" value="花蓮市">花蓮市</option>
															<option name="TTC" value="臺東市">臺東市</option>
															<option name="TTT" value="臺東縣">臺東縣</option>
														</optgroup>
														<optgroup label="離島">
															<option name="PEH" value="澎湖縣">澎湖縣</option>
															<option name="KYD" value="綠島">綠島</option>
															<option name="TTC" value="蘭嶼">蘭嶼</option>
															<option name="KMN" value="金門縣">金門縣</option>
															<option name="MZW" value="馬祖">馬祖</option>
															<option name="LNN" value="連江縣">連江縣</option>
														</optgroup>
												</select><span id="addr1Check"></span></td>
											</tr>
											<tr>
												<td>郵遞區號:</td>
												<td>( <input class="addr" type="text" name="addr2"
													id="addr2" size="5" placeholder="106"> )<span
													id="addr2Check"></span></td>
											</tr>
											<tr>
												<td>公司地址:</td>
												<td><input type="text" name="addr3" id="addr3"
													size="20" placeholder="台北市大安區復興南路一段390號2樓"> <span
													id="addr3Check"></span></td>
											</tr>
											<tr>
												<td><span style="color: red;" id="subBtnCheck"></span></td>
											</tr>
											<tr>
												<td><input type="submit" class="btn" id="subBtn"
													name="insertHealth" value="送出"></td>
												<td><input type="reset" class="btn" value="清除"></td>
										</table>
									</form>
								</div>
								<div class="col-md-6"></div>
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


	<script>
	
	//Check
    let enameCheck = document.getElementById("enameCheck");
    let sexCheck = document.getElementById("sexCheck");
    let rocidCheck = document.getElementById("rocidCheck");
    let birthCheck = document.getElementById("birthCheck");
    let cnameCheck = document.getElementById("cnameCheck");
    let acntCheck = document.getElementById("acntCheck");
    let pwd1Check = document.getElementById("pwd1Check");
    let pwd2Check = document.getElementById("pwd2Check");
    let emailCheck = document.getElementById("emailCheck");
    let phoneCheck = document.getElementById("phoneCheck");
    let addr1Check = document.getElementById("addr1Check");
    let addr2Check = document.getElementById("addr2Check");
    let addr3Check = document.getElementById("addr3Check");
    let subBtnCheck = document.getElementById("subBtnCheck");
    
    document.getElementById("subBtn").onclick = checkSubBtn;

    let flagSubmit1 = true;
    let flagSubmit2 = true;
    let flagSubmit3 = true;
    let flagSubmit4 = true;
    let flagSubmit5 = true;
    let flagSubmit6 = true;
    let flagSubmit7 = true;
    let flagSubmit8 = true;
    let flagSubmit9 = true;
    let flagSubmit10 = true;
    let flagSubmit11 = true;
    let flagSubmit12 = true;
    let flagSubmit13 = true;

    //ename
    function checkEname() {
        flagSubmit1 = true;
        let enameObj = document.getElementById("ename1");
        let enameValue = enameObj.value;
        let enameLen = enameValue.length;
        let flag1 = false;
        if (enameLen == "") {
            enameCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>姓名不能為空";
            flagSubmit1 = false;
        } else if (enameLen >= 2) {
            for (let i = 0; i <= enameLen - 1; i++) {
                let ch = enameValue.charAt(i).toUpperCase();
                if (ch >= "一" && ch <= "鿕") {
                    flag1 = true;
                } else {
                    enameCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>姓名必須全部中文";
                    flag1 = false;
                    flagSubmit1 = false;
                    break;
                }
            } if (flag1) {
                enameCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/correct.jpg'>";
            }
        } else if (enameLen < 2 && enameLen > 0) {
            enameCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>姓名長度最少二字"
            flagSubmit1 = false;
        }
    }


//sex
function checkSex() {
flagSubmit2 = true;
var Total_Obj = document.getElementsByName('gender');
let val=false;
for (let i = 0; i < Total_Obj.length; i++) {
    if (Total_Obj[i].checked) {
        val=true;
    } 
}
if(val!=true) {
    flagSubmit2 = false;
    sexCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>請點選性別";

}else{
    flagSubmit2 = true;
    sexCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/correct.jpg'>";       
}
}

    //rocid     //pattern="[a-zA-Z]{1}[1-2]{1}\d{8}"
    function checkRocid() {
        flagSubmit3 = true;
        let rocidObj = document.getElementById("rocid1");
        let rocidValue = rocidObj.value;
        let rocidLen = rocidValue.length;
        let re1 = /^[A-Za-z]{1}[1-2]{1}\d{8}$/;
        let flag1 = false;

        if (rocidLen == "") {
            rocidCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>身分證字號不可為空";
            flagSubmit3 = false;
        } else if (rocidLen > 0) {
            for (i = 0; i <= rocidLen; i++) {
                if (re1.test(rocidValue)) {
                    flag1 = true;
                } else {
                    flagSubmit3 = false;
                    flag1 = false;
                }
            }
            if (flag1) {
                rocidCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/correct.jpg'>";
            } else {
                rocidCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>身分證字號格式有誤";
                flagSubmit3 = false;
            }

        }
    }

    //checkBirth
    function checkBirth() {
        flagSubmit4 = true;
        let year1Obj = document.getElementById("year1");
        let month1Obj = document.getElementById("month1");
        let day1Obj = document.getElementById("day1");
        let year1Value = year1Obj.value;
        let month1Value = month1Obj.value;
        let day1Value = day1Obj.value;
        let year1Len = year1Value.length;
        let month1Len = month1Value.length;
        let day1Len = day1Value.length;
        let floatYear1 = parseFloat(year1Value);
        let floatMonth1 = parseFloat(month1Value);
        let floatDay1 = parseFloat(day1Value);
        let re1 = /^\d{1,3}$/;
        let re2 = /^\d{1,2}$/;
        let re3 = /^\d{1,2}$/;
        let flag1 = false, flag2 = false, flag3 = false;

        if (year1Len == 0 || month1Len == 0 || day1Len == 0) {
            birthCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>日期不可為空";
            flagSubmit4 = false;
        } else if (year1Len > 0) {
            // for (i = 0; i <= year1Len; i++) {
            if (re1.test(year1Value)) {
                if (re2.test(month1Value)) {
                    if (re3.test(day1Value)) {

                        if (floatYear1 <= 0 || floatYear1 >= 999) {      //年份不超過上下限
                            flag1 = false;
                        } else {
                            flag1 = true;
                            if (floatYear1 % 4 == 1 && floatYear1 % 100 != 1) {       //閏年
                                if (floatMonth1 == 1 || floatMonth1 == 3 || floatMonth1 == 5 || floatMonth1 == 7 || floatMonth1 == 8 || floatMonth1 == 10 || floatMonth1 == 12) {
                                    flag2 = true;
                                    if (floatDay1 > 0 && floatDay1 <= 31) {       //大月
                                        flag3 = true;
                                    } else {
                                        flag3 = false;
                                    }
                                } else if (floatMonth1 == 4 || floatMonth1 == 6 || floatMonth1 == 9 || floatMonth1 == 11) {    //小月
                                    flag2 = true;
                                    if (floatDay1 > 0 && floatDay1 <= 30) {
                                        flag3 = true;
                                    } else {
                                        flag3 = false;
                                    }
                                } else if (floatMonth1 == 2) {     //二月
                                    flag2 = true;
                                    if (floatDay1 <= 29) {
                                        flag3 = true;
                                    } else {
                                        flag3 = false;
                                    }
                                } else {
                                    flag2 = false;
                                }
                            } else {              //平年
                                if (floatMonth1 == 1 || floatMonth1 == 3 || floatMonth1 == 5 || floatMonth1 == 7 || floatMonth1 == 8 || floatMonth1 == 10 || floatMonth1 == 12) {
                                    flag2 = true;
                                    if (floatDay1 > 0 && floatDay1 <= 31) {       //大月
                                        flag3 = true;
                                    } else {
                                        flag3 = false;
                                    }
                                } else if (floatMonth1 == 4 || floatMonth1 == 6 || floatMonth1 == 9 || floatMonth1 == 11) {    //小月
                                    flag2 = true;
                                    if (floatDay1 > 0 && floatDay1 <= 30) {
                                        flag3 = true;
                                    } else {
                                        flag3 = false;
                                    }
                                } else if (floatMonth1 == 2) {     //二月
                                    flag2 = true;
                                    if (floatDay1 <= 28) {
                                        flag3 = true;
                                    } else {
                                        flag3 = false;
                                    }
                                } else {
                                    flag2 = false;
                                }
                            }
                        }
                    } else {
                        flag1 = false;
                    }
                } else {
                    flag1 = false;
                }
            } else {
                flag1 = false;
            }
            // }
            if (flag1 && flag2 && flag3) {
                birthCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/correct.jpg'>";
            } else {
                birthCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>無此日期";
                flagSubmit4 = false;
            }

        }
    }

    //cname
    function checkCname() {
        flagSubmit5 = true;
        let cnameObj = document.getElementById("cname1");
        let cnameValue = cnameObj.value;
        let cnameLen = cnameValue.length;

        if (cnameValue == "") {
            cnameCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>公司名稱不可為空";
            flagSubmit5 = false;
        } else {
            cnameCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/correct.jpg'>";
        }

    }


    //account1
    function checkAccount() {
        flagSubmit6 = true;
        let acntObj = document.getElementById("account1");
        let acntValue = acntObj.value;
        let acntLen = acntValue.length;
        let flag1 = false, flag2 = false;

        if (acntLen == "") {
            acntCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>帳號不能為空";
            flagSubmit6 = false;
        } else if (acntLen >= 6) {
            for (let i = 0; i <= acntLen; i++) {
                let ch = acntValue.charAt(i).toUpperCase();
                if (ch >= "A" && ch <= "Z") {
                    flag1 = true;
                } else if (ch >= "0" && ch <= "9") {
                    flag2 = true;
                }
                if (flag1 && flag2) {
                    break;
                }
            } if (flag1 && flag2) {
                acntCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/correct.jpg'>";
            } else {
                acntCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>帳號必須包含英文與數字";
                flagSubmit6 = false;
            }
        } else if (acntLen < 6 && acntLen > 0) {
            acntCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>帳號字數過少";
            flagSubmit6 = false;
        }
    }

    //pwd1
    function checkPwd1() {
        flagSubmit7 = true;
        let pwd1Obj = document.getElementById("pwd1");
        let pwd1Value = pwd1Obj.value;
        let pwd1Len = pwd1Value.length;
        let flag1 = false, flag2 = false;

        if (pwd1Len == "") {
            pwd1Check.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>密碼不能為空";
            flagSubmit7 = false;
        } else if (pwd1Len >= 6) {
            for (let i = 0; i <= pwd1Len; i++) {
                let ch = pwd1Value.charAt(i).toUpperCase();
                if (ch >= "A" && ch <= "Z") {
                    flag1 = true;
                } else if (ch >= "0" && ch <= "9") {
                    flag2 = true;
                }
                if (flag1 && flag2) {
                    break;
                }
            } if (flag1 && flag2) {
                pwd1Check.innerHTML = "<img src ='${pageContext.request.contextPath}/images/correct.jpg'>";
            } else {
                pwd1Check.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>密碼必須包含英文與數字";
                flagSubmit7 = false;
            }
        } else if (pwd1Len < 6 && pwd1Len > 0) {
            pwd1Check.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>密碼字數過少";
            flagSubmit7 = false;
        }
    }

    //pwd2
    function checkPwd2() {
        flagSubmit8 = true;
        let pwd1Obj = document.getElementById("pwd1");
        let pwd1Value = pwd1Obj.value;
        let pwd2Obj = document.getElementById("pwd2");
        let pwd2Value = pwd2Obj.value;
        let pwd2Len = pwd2Value.length;
        let flag1 = false, flag2 = false;

        if (pwd2Len == "") {
            pwd2Check.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>密碼不能為空";
            flagSubmit8 = false;
        } else if (pwd2Len >= 6) {
            if (pwd2Value == pwd1Value) {
                for (let i = 0; i <= pwd2Len; i++) {
                    let ch = pwd2Value.charAt(i).toUpperCase();
                    if (ch >= "A" && ch <= "Z") {
                        flag1 = true;
                    } else if (ch >= "0" && ch <= "9") {
                        flag2 = true;
                    }
                    if (flag1 && flag2) {
                        break;
                    }
                }
                if (flag1 && flag2) {
                    pwd2Check.innerHTML = "<img src ='${pageContext.request.contextPath}/images/correct.jpg'>";
                } else {
                    pwd2Check.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>密碼必須包含英文與數字";
                    flagSubmit8 = false;
                }
            } else {
                pwd2Check.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>請確認密碼一樣";
                flagSubmit8 = false;
            }
        } else if (pwd2Len < 6 && pwd2Len > 0) {
            pwd2Check.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>密碼字數過少";
            flagSubmit8 = false;
        }
    }

    //email1
    function checkEmail() {
        flagSubmit9 = true;
        let emailObj = document.getElementById("email1");
        let emailValue = emailObj.value;
        let emailLen = emailValue.length;
        let re1 = /^\w+@\w+\.\w{2,3}$/;
        let flag1 = false;

        if (emailLen == "") {
            emailCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>E-mail不可為空";
            flagSubmit9 = false;
        } else if (emailLen > 0) {
            for (i = 0; i <= emailLen; i++) {
                if (re1.test(emailValue)) {
                    flag1 = true;
                } else {
                    flag1 = false;
                }
            }
            if (flag1) {
                emailCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/correct.jpg'>";
            } else {
                emailCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>E-mail格式有誤";
                flagSubmit9 = false;
            }

        }
    }

    //phone
    function checkPhone() {
        flagSubmit10 = true;
        let phone1Obj = document.getElementById("phone1");
        let phone2Obj = document.getElementById("phone2");
        let phone1Value = phone1Obj.value;
        let phone2Value = phone2Obj.value;
        let phone1Len = phone1Value.length;
        let phone2Len = phone2Value.length;
        let re1 = /^\d{2,4}$/;
        let re2 = /^\d{8}$/;
        let flag1 = false;

        if (phone1Len == "" || phone2Len == "") {
            phoneCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>電話不可為空";
            flagSubmit10 = false;
        } else if (phone1Len > 0 && phone2Len > 0) {
            for (i = 0; i <= phone1Len; i++) {
                if (re1.test(phone1Value)) {
                    if (phone1Value == 02 || phone1Value == 03 || phone1Value == 037 || phone1Value == 04 || phone1Value == 05 || phone1Value == 06 || phone1Value == 07 || phone1Value == 08 || phone1Value == 089 || phone1Value == 082 || phone1Value == 0826 || phone1Value == 0836 || phone1Value == "049") {
                        if (re2.test(phone2Value)) {
                            flag1 = true;
                        } else {
                            flag1 = false;
                        }
                    } else {
                        flag1 = false;
                    }
                } else {
                    flag1 = false;
                }
            }
            if (flag1) {
                phoneCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/correct.jpg'>";
            } else {
                phoneCheck.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>電話格式有誤";
                flagSubmit10 = false;
            }

        }
    }

    //addr1
    function checkAddr1() {
        flagSubmit11 = true;
        let addr1Obj = document.getElementById("addr1");
        let addr1Value = addr1Obj.value;
        let addr1Len = addr1Value.length;

        if (addr1Value == "") {
            addr1Check.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>公司縣市不可為空";
            flagSubmit11 = false;
        } else {
            addr1Check.innerHTML = "<img src ='${pageContext.request.contextPath}/images/correct.jpg'>";
        }

    }

    //addr2
    function checkAddr2() {
        flagSubmit12 = true;
        let addr2Obj = document.getElementById("addr2");
        let addr2Value = addr2Obj.value;
        let addr2Len = addr2Value.length;
        let re1 = /^\d{3}$/;
        let flag1 = false;

        if (addr2Len == "") {
            addr2Check.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>郵遞區號不可為空";
            flagSubmit12 = false;
        } else if (addr2Len > 0) {
            for (i = 0; i <= addr2Len; i++) {
                if (re1.test(addr2Value)) {
                    flag1 = true;
                } else {
                    flag1 = false;
                }
            }
            if (flag1) {
                addr2Check.innerHTML = "<img src ='${pageContext.request.contextPath}/images/correct.jpg'>";
            } else {
                addr2Check.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>郵遞區號格式有誤";
                flagSubmit12 = false;
            }

        }
    }

    //addr3
    function checkAddr3() {
        flagSubmit13 = true;
        let addr3Obj = document.getElementById("addr3");
        let addr3Value = addr3Obj.value;
        let addr3Len = addr3Value.length;

        if (addr3Value == "") {
            addr3Check.innerHTML = "<img src ='${pageContext.request.contextPath}/images/incorrect.jpg'>完整地址不可為空";
            flagSubmit13 = false;
        } else {
            addr3Check.innerHTML = "<img src ='${pageContext.request.contextPath}/images/correct.jpg'>";
        }

    }

    //顯示密碼
    document.getElementById("showPwd").onclick=showPwd;
        function showPwd(){
            let pwdType=document.getElementById("pwd1").type;
            //pwdType現在是密碼的話，就轉成文字顯示
            if(pwdType === "password"){
                document.getElementById("pwd1").type="text";
                document.getElementById("pwd2").type="text";
                //pwdType現在是文字的話，就轉回密碼來不顯示
            }else{
                document.getElementById("pwd1").type="password";
                document.getElementById("pwd2").type="password";
            }
        }
    

    //checkSubBtn
    function checkSubBtn() {
        checkEname();
        checkSex();
        checkRocid();
        checkBirth();
        checkCname();
        checkAccount();
        checkPwd1();
        checkPwd2();
        checkEmail();
        checkPhone();
        checkAddr1();
        checkAddr2();
        checkAddr3();
        if (flagSubmit1 == false || flagSubmit2 == false || flagSubmit3 == false || flagSubmit4 == false || flagSubmit5 == false || 
            flagSubmit6 == false || flagSubmit7 == false || flagSubmit8 == false || flagSubmit9 == false || flagSubmit10 == false || 
            flagSubmit11 == false || flagSubmit12 == false || flagSubmit13 == false) {
            subBtnCheck.innerHTML = "**資料不完整，請重新檢查**";
            console.log(flagSubmit2)


            return false;
        } else {
            return true;
        }

    }
    </script>


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