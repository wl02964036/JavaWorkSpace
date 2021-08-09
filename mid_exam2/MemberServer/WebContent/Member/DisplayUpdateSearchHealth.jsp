 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改資料確認</title>
</head>
<body>
    <!-- 抓RegisterServlet 的 74行 request.getSession(true).setAttribute("reg_student",reg_student); -->
    <jsp:useBean id="updateSearchHealth" class="mvcdemo.bean.HealthBean" scope="session" />
    <h2 style="text-align: center;">
    修改員工資料如下請確認
    </h2>
    <form action="RegisterServlet" method="post">
    <table  cellspacing="2" cellpadding="1" border="1" width="100%">
	<tr bgcolor="#F2F4FB">
        <td>員工編號:</td>
        <td><jsp:getProperty name="updateSearchHealth" property="empno" /></td>
    </tr>
    <tr bgcolor="#FFFFE1">
        <td>員工姓名:</td>
        <td><jsp:getProperty name="updateSearchHealth" property="ename" /></td>
    </tr>
    <tr bgcolor="#F2F4FB">
        <td>性別:</td>
        <td><jsp:getProperty name="updateSearchHealth" property="gender" /></td>
    </tr>
    <tr bgcolor="#FFFFE1">
        <td>身分證字號:</td>
        <td><jsp:getProperty name="updateSearchHealth" property="rocid1" /></td>
    </tr>
    <tr bgcolor="#F2F4FB">
        <td>生日:</td>
        <td>
        民國
        <jsp:getProperty name="updateSearchHealth" property="year1" />年
        <jsp:getProperty name="updateSearchHealth" property="month1" />月
        <jsp:getProperty name="updateSearchHealth" property="day1" />日  
        </td>
    </tr>
    <tr bgcolor="#FFFFE1">
        <td width="150">公司名稱:</td>
        <td><jsp:getProperty name="updateSearchHealth" property="cname1" /></td>
    </tr>
    <tr bgcolor="#F2F4FB">
        <td>帳號:</td>
        <td><jsp:getProperty name="updateSearchHealth" property="account1" /></td>
    </tr>
    <tr bgcolor="#FFFFE1">
        <td>密碼:</td>
        <td><jsp:getProperty name="updateSearchHealth" property="pwd1" /></td>
    </tr>
    <tr bgcolor="#F2F4FB">
        <td>確認密碼:</td>
        <td><jsp:getProperty name="updateSearchHealth" property="pwd2" /></td>
    </tr>
    <tr bgcolor="#FFFFE1">
        <td>E-mail:</td>
        <td><jsp:getProperty name="updateSearchHealth" property="email1" /></td>
    </tr>
    <tr bgcolor="#F2F4FB">
        <td>電話:</td>
        <td>
        (
        <jsp:getProperty name="updateSearchHealth" property="phone1" /> 
        )
        <jsp:getProperty name="updateSearchHealth" property="phone2" />    
        </td>
    </tr>
    <tr bgcolor="#FFFFE1">
        <td>公司縣市</td>
        <td><jsp:getProperty name="updateSearchHealth" property="addr1" /></td>
    </tr>
    <tr bgcolor="#F2F4FB">
        <td width="150">公司地址:</td>
        <td>(
            <jsp:getProperty name="updateSearchHealth" property="addr2" />
            ) 
            <jsp:getProperty name="updateSearchHealth" property="addr3" /></td>
    </tr>
    </table>
    <center>
<input type="submit" name="displayUpdateSearchHealth" value="確認" >
    </center>
    </form>
    </body>
    </html>