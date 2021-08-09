<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
        integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <title>首頁</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            margin-top: 20px;
            font-size: 40px;
        }



        table {
            width: 200px;
            height: auto;
            border: black 2px solid;
            border-collapse: collapse;
            text-align: center;
        }


        th {
            color: white;
            border: black 2px solid;
            background-color: rgb(30, 158, 179);
            font-size: 28px;
            height: 25px;
        }


        td {
            height: 60px;
            line-height: 30px;
            font-size: 22px;
        }

        div {
            margin: 30px auto 0 auto;

        }

        .container {
            margin-top: 100px;
        }

        .list-group-item {
            font-size: 20px;
        }

        .list-group-item:hover {
           background-color:lightblue;
        }
        
    </style>


</head>

<body>
    <h1>登入首頁</h1>

    <div class="container"></div>
    <div class="row">
        <div class="col-md-2">
            <a href="../Member/Total.jsp" class="list-group-item list-group-item-action" >會員系統</a>
            <a href="../Member/loginAP.jsp" class="list-group-item list-group-item-action" >返回登入介面</a>
        </div>

       <div class="col-md-1">
        </div>
        

        <div class="col-md-2">

            <table>
                <tr>
                    <th>叫車系統</th>
                </tr>
                <tr>
                    <td><a href="javascript:;">計程車資訊</a></td>
                </tr>
                <tr>
                    <td><a href="javascript:;">店家資訊</a></td>
                </tr>
            </table>
        </div>

        <div class="col-md-2">
            <table>
                <tr>
                    <th>長照系統</th>
                </tr>
                <tr>
                    <td><a href="HelperServlet">看護系統</a></td>
                </tr>
                <tr>
                    <td><a href="EquipmentServlet">輔具系統</a></td>
                </tr>
                <tr>
                    <td><a href="OrderServlet">輔具訂單系統</a></td>
                </tr>
            </table>
        </div>

        <div class="col-md-2">

            <table>
                <tr>
                    <th>營養管理系統</th>
                </tr>
                <tr>
                    <td><a href="javascript:;">營養餐管理</a></td>

                </tr>
                <tr>
                    <td><a href="javascript:;">食品資料管理</a></td>
                </tr>
            </table>
        </div>
        <div class="col-md-2">

            <table>
                <tr>
                    <th>用藥查詢</th>
                </tr>
                <tr>
                    <td><a href="javascript:;">藥品辨識系統</a></td>

                </tr>
                <tr>
                    <td><a href="javascript:;">藥品包裝變更</a></td>
                </tr>
            </table>
        </div>
        <div class="col-md-1">
        </div>

    </div>





</body>

</html>