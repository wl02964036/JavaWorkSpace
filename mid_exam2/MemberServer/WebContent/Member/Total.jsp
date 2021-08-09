<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>

<%
response.setContentType("text/html;charset=UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增刪改查頁面</title>
<link rel="stylesheet" href="../css/MemberStyle.css">
<style>
        header {
            background: #333;
            color: rgb(132, 243, 243);
            padding: 20px;
            text-align: center;
            margin-bottom: 10px;
        }

        form {
            margin: 150px auto;
            padding: 20px;
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

        table {
            width: 500px;
            height: 500px;
            border: 3px solid #0072E3;
            border-collapse: collapse;
            margin-left:auto; 
            margin-right:auto;

        }

        tbody{
            background-color: #ffffff;
            text-align: center;
        }

        td,th {
            font-size: larger;
            border: 1px solid #0072E3;
            
        }
    </style>
</head>

<body>
    <header>
        <h1>管理者介面</h1>
    </header>
    <form action="RegisterServlet" method="post">
        <table>
            <tbody>
                <tr>
                    <td>新增單筆資料</td>
                    <td><input type="submit" name="totalToInsert" value="新增"><br></td>
                </tr>
                <tr>
                    <td>查詢單筆資料</td>
                    <td><input type="submit" name="totalToSearchOne" value="查詢"><br></td>
                </tr>
                <tr>
                    <td>刪除單筆資料</td>
                    <td><input type="submit" name="totalToDeleteOne" value="刪除"><br></td>
                </tr>
                <tr>
                    <td>修改單筆資料</td>
                    <td><input type="submit" name="totalToUpdateOne" value="修改"><br></td>
                </tr>
                <tr>
                    <td>查詢所有資料</td>
                    <td><input type="submit" name="searchAllHealth" value="總覽"><br></td>
                </tr>
                 <tr>
                    <td colspan="2" style="text-align: center;"><a href="../Member/login.jsp">返回首頁</a></td>
                </tr>
            </tbody>
        </table>
    </form>
</body>

</html>