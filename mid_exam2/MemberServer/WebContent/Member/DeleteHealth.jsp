<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control", "no-cache"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", -1); // Prevents caching at the proxy server
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
<link rel="stylesheet" href="../css/MemberStyle.css">
 <style>
        img[src='../images/correct.jpg'] {
            width: 15px;
            height: 15px;
        }
        
        img[src='../images/error.jpg'] {
            width: 15px;
            height: 15px;
        }
        
        #showPwd {
            margin-left: 80px;
        }
        
        form {
        margin: 20px auto;
        padding: 0;
        min-width: 500px;
        max-width: 600px;
        width: 560px;
        position:absolute; height:280px;
        top:0; bottom:0; left:0; right:0;
        
        }
        </style>
</head>
<body class="bd">

	<form action="RegisterServlet" method="post" id="form1" onsubmit="return checkSubBtn();">
		<fieldset>
			<legend>刪除單筆員工資料</legend>
			<div class="divItem">
				<!--account1-->
				<label for="ename1" class="itemTitle">員工編號:</label>
				<input type="text" id="empno" name="empno" size="15" autocomplete="off">
				<span id="empnoCheck"></span>
			</div>
		</fieldset>
		<div class="sub">
			<span style="color: red;" id="subBtnCheck"></span><br> <br>
			<input type="submit" class="btn" id="subBtn" name="deleteHealth"
				value="送出">
			<!-- &ensp; -->
			<input type="reset" class="btn" value="清除">
			<a href="../Member/Total.jsp">回到管理者介面</a>
		</div>
	</form>

<script>
        let empnoCheck = document.getElementById("empnoCheck");
        document.getElementById("subBtn").onclick = checkSubBtn;
        let flagSubmit1 = true;
    //empno
    function checkempno() {
            flagSubmit1 = true;
            let empnoObj = document.getElementById("empno");
            let empnoValue = empnoObj.value;
            let empnoLen = empnoValue.length;

            if (empnoValue == "") {
                empnoCheck.innerHTML = "<img src ='../images/incorrect.png'>員工編號不可為空";
                flagSubmit1 = false;
            } else {
                empnoCheck.innerHTML = "<img src ='../images/correct.jpg'>";
            }

        }

        //checkSubBtn
        function checkSubBtn() {
            checkempno();

            if (flagSubmit1 == false) {
                subBtnCheck.innerHTML = "**資料不完整，請重新檢查**";
                return false;
            } else {
                return true;
            }

        }
</script>
</body>

</html>