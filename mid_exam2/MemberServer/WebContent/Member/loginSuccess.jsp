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
        fieldset {
            margin: 20px auto;
        }
        a{
        margin-left:10px;
        margin-right:10px;
        }
    </style>
</head>

<body>
    <fieldset>
        <legend>管理者登入</legend>
        <div class="divItem">
            <h4 style="font-size: larger;text-align: center;">登入成功</h4>

        </div>
        <div class="divItem">
            <div style="text-align: center;">
                <a href="../Member/loginAP.jsp">返回登入介面</a> <a href="../Member/login.jsp">登入首頁</a>
            </div>
        </div>
    </fieldset>
</body>

</html>