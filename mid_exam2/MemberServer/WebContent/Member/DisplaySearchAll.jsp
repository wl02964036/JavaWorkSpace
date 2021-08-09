<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, mvcdemo.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查詢所有</title>
    <style>
        header {
            background: #333;
            color: rgb(98, 219, 250);
            padding: 10px;
            margin-bottom: 10px;
        }
        table {
            height: 100px;
            border: 3px solid #0072E3;
            border-collapse: collapse;
            margin-left:auto; 
            margin-right:auto;
        }

        td,
        th {
            border: 1px solid #0072E3;
        }

        thead {
            background-color: #3d50b6;
            color: #ffffff;
            text-transform: capitalize;
        }

        tbody {
            background-color: #ffffff;
            text-align: center;
        }
    </style>
</head>
<body>

	<header>
        <h1 style="text-align: center;">查詢結果</h1>
    </header>
    <div id="container">
        <form action="RegisterServlet" method="post">
        <input type="submit"  class="btn"  name="searchAllHealth" value="表單總覽">
        <input type="submit"  class="btn"  name="gotoTotal" value="返回使用者介面">
        <table>
            <thead>
                <tr>
                    <th>員工編號</th>
                    <th>員工姓名</th>
                    <th>性別</th>
                    <th>身分證字號</th>
                    <th>民國年</th>
                    <th>月</th>
                    <th>日</th>
                    <th>公司名稱</th>
                    <th>帳號</th>
                    <th>密碼</th>
                    <th>確認密碼</th>
                    <th>E-mail </th>
                    <th>phone1</th>
                    <th>phone2</th>
                    <th>公司縣市</th>
                    <th>郵遞區號</th>
                    <th>公司地址</th>
                    <th colspan="2"></th>
                </tr>
            </thead>
            <tbody id="tbody_showform">
         <%
         // Scriptlet 1: Display all beans in table
         ArrayList<HealthBean> arrayHealth = (ArrayList<HealthBean>) session.getAttribute("arrayHealth");
         for (HealthBean item : arrayHealth) {
         %>
         <tr>
            <td><%= item.getEmpno()%></td>
            <td><%= item.getEname()%></td>
            <td><%= item.getGender()%></td>
            <td><%= item.getRocid1()%></td>
            <td><%= item.getYear1()%></td>
            <td><%= item.getMonth1()%></td>
            <td><%= item.getDay1()%></td>
            <td><%= item.getCname1()%></td>
            <td><%= item.getAccount1()%></td>
            <td><%= item.getPwd1()%></td>
            <td><%= item.getPwd2()%></td>
            <td><%= item.getEmail1()%></td>
            <td><%= item.getPhone1()%></td>
            <td><%= item.getPhone2()%></td>
            <td><%= item.getAddr1()%></td>
            <td><%= item.getAddr2()%></td>
            <td><%= item.getAddr3()%></td>
            <td>
            <form action="RegisterServlet" method="post">
            <input type="hidden" name="empno" value="<%= item.getEmpno()%>">
            <input type="hidden" name="ename" value="<%= item.getEname()%>">
            <input type="hidden" name="gender" value="<%= item.getGender()%>">
            <input type="hidden" name="rocid1" value="<%= item.getRocid1()%>">
            <input type="hidden" name="year1" value="<%= item.getYear1()%>">
            <input type="hidden" name="month1" value="<%= item.getMonth1()%>">
            <input type="hidden" name="day1" value="<%= item.getDay1()%>">
            <input type="hidden" name="cname1" value="<%= item.getCname1()%>">
            <input type="hidden" name="account1" value="<%= item.getAccount1()%>">
            <input type="hidden" name="pwd1" value="<%= item.getPwd1()%>">
            <input type="hidden" name="pwd2" value="<%= item.getPwd2()%>">
            <input type="hidden" name="email1" value="<%= item.getEmail1()%>">
            <input type="hidden" name="phone1" value="<%= item.getPhone1()%>">
            <input type="hidden" name="phone2" value="<%= item.getPhone2()%>">
            <input type="hidden" name="addr1" value="<%= item.getAddr1()%>">
            <input type="hidden" name="addr2" value="<%= item.getAddr2()%>">
            <input type="hidden" name="addr3" value="<%= item.getAddr3()%>">
            <input type="submit" name="searchAllToUpdate" value="修改">
            </form>
            </td>
            <td>
            <form action="RegisterServlet" method="post">
            <input type="hidden" name="empno" value="<%= item.getEmpno()%>">
            <input type="submit" name="deleteHealth" value="刪除">
            </form>
            </td>
         </tr>
         <%
         } // for
         //session.invalidate();
         %>
            
            </tbody>
        </table>
        </form>
    </div>
</body>
</html>