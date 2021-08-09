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
<title>loginAP</title>
<link rel="stylesheet" href="../css/MemberStyle.css">
    <style>
        img[src='../images/correct.jpg'] {
            width: 15px;
            height: 15px;
        }

        img[src='../images/incorrect.jpg'] {
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
            position: absolute;
            height: 280px;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;

        }
    </style>
</head>

<body class="bd">

    <form action="RegisterServlet" method="post" id="form1" onsubmit="return checkSubBtn();">
        <fieldset>
            <legend>管理者登入</legend>
            <div class="divItem">
                <!--account1-->
                <label for="ename1" class="itemTitle">帳號:</label>
                <input type="text" id="account1" name="account1" size="15" autocomplete="off">
                <span id="acntCheck"></span>
            </div>
            <div class="divItem">
                <!--account1-->
                <label for="ename1" class="itemTitle">密碼:</label>
                <input type="password" id="pwd1" name="pwd1" maxlength="15" size="15">
                <span id="pwd1Check"></span><br>
                <input type="checkbox" id="showPwd">顯示密碼
            </div>
        </fieldset>
        <div class="sub">
            <span style="color: red;" id="subBtnCheck"></span><br> <br>
            <input type="submit" class="btn" id="subBtn" name="sublogin" value="登陸">
            <!-- &ensp; -->
            <input type="reset" class="btn" value="清除">
        </div>
    </form>

    <script>
    let acntCheck = document.getElementById("acntCheck");
    let pwd1Check = document.getElementById("pwd1Check");
    document.getElementById("subBtn").onclick = checkSubBtn;

    let flagSubmit1 = true;
    let flagSubmit2 = true;
    //account1
    function checkAccount() {
        flagSubmit1 = true;
        let acntObj = document.getElementById("account1");
        let acntValue = acntObj.value;
        let acntLen = acntValue.length;
        let flag1 = false, flag2 = false;

        if (acntLen == "") {
            acntCheck.innerHTML = "<img src ='../images/incorrect.png'>帳號不能為空";
            flagSubmit1 = false;
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
                acntCheck.innerHTML = "<img src ='../images/correct.jpg'>";
            } else {
                acntCheck.innerHTML = "<img src ='../images/incorrect.png'>帳號必須包含英文與數字";
                flagSubmit1 = false;
            }
        } else if (acntLen < 6 && acntLen > 0) {
            acntCheck.innerHTML = "<img src ='../images/incorrect.png'>帳號字數過少";
            flagSubmit1 = false;
        }
    }

    //pwd1
    function checkPwd1() {
        flagSubmit2 = true
        let pwd1Obj = document.getElementById("pwd1");
        let pwd1Value = pwd1Obj.value;
        let pwd1Len = pwd1Value.length;
        let flag1 = false, flag2 = false;

        if (pwd1Len == "") {
            pwd1Check.innerHTML = "<img src ='../images/incorrect.png'>密碼不能為空";
            flagSubmit2 = false;
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
                pwd1Check.innerHTML = "<img src ='../images/correct.jpg'>";
            } else {
                pwd1Check.innerHTML = "<img src ='../images/incorrect.png'>密碼必須包含英文與數字";
                flagSubmit2 = false;
            }
        } else if (pwd1Len < 6 && pwd1Len > 0) {
            pwd1Check.innerHTML = "<img src ='../images/incorrect.png'>密碼字數過少";
            flagSubmit2 = false;
        }
    }

    //顯示密碼
    document.getElementById("showPwd").onclick = showPwd;
    function showPwd() {
        let pwdType = document.getElementById("pwd1").type;
        //pwdType現在是密碼的話，就轉成文字顯示
        if (pwdType === "password") {
            document.getElementById("pwd1").type = "text";
            //pwdType現在是文字的話，就轉回密碼來不顯示
        } else {
            document.getElementById("pwd1").type = "password";
        }
    }

    //checkSubBtn
    function checkSubBtn() {
        checkAccount();
        checkPwd1();

        if (flagSubmit1 == false || flagSubmit2 == false) {
            subBtnCheck.innerHTML = "**資料不完整，請重新檢查**";
            return false;
        } else {
            return true;
        }

    }
    </script>
</body>

</html>