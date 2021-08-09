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
    <title>����</title>
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
    <h1>�n�J����</h1>

    <div class="container"></div>
    <div class="row">
        <div class="col-md-2">
            <a href="../Member/Total.jsp" class="list-group-item list-group-item-action" >�|���t��</a>
            <a href="../Member/loginAP.jsp" class="list-group-item list-group-item-action" >��^�n�J����</a>
        </div>

       <div class="col-md-1">
        </div>
        

        <div class="col-md-2">

            <table>
                <tr>
                    <th>�s���t��</th>
                </tr>
                <tr>
                    <td><a href="javascript:;">�p�{����T</a></td>
                </tr>
                <tr>
                    <td><a href="javascript:;">���a��T</a></td>
                </tr>
            </table>
        </div>

        <div class="col-md-2">
            <table>
                <tr>
                    <th>���Өt��</th>
                </tr>
                <tr>
                    <td><a href="HelperServlet">���@�t��</a></td>
                </tr>
                <tr>
                    <td><a href="EquipmentServlet">����t��</a></td>
                </tr>
                <tr>
                    <td><a href="OrderServlet">����q��t��</a></td>
                </tr>
            </table>
        </div>

        <div class="col-md-2">

            <table>
                <tr>
                    <th>��i�޲z�t��</th>
                </tr>
                <tr>
                    <td><a href="javascript:;">��i�\�޲z</a></td>

                </tr>
                <tr>
                    <td><a href="javascript:;">���~��ƺ޲z</a></td>
                </tr>
            </table>
        </div>
        <div class="col-md-2">

            <table>
                <tr>
                    <th>���Ĭd��</th>
                </tr>
                <tr>
                    <td><a href="javascript:;">�ī~���Ѩt��</a></td>

                </tr>
                <tr>
                    <td><a href="javascript:;">�ī~�]���ܧ�</a></td>
                </tr>
            </table>
        </div>
        <div class="col-md-1">
        </div>

    </div>





</body>

</html>