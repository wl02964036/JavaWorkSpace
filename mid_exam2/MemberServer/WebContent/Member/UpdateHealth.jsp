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
            <legend>查詢要修改的員工資料</legend>
            <div class="divItem">
            <!--empno-->
            <label for="empno" class="itemTitle">員工編號:</label>
            <input type="text" id="empno" name="empno" size="15" placeholder="例如:11111111" autocomplete="off">
            <span id="empnoCheck"></span>
        </div>
        </fieldset>

        <fieldset>
            <legend>修改單筆員工資料</legend>
            <div class="divItem">
                <!--ename1-->
                <label for="ename1" class="itemTitle">員工姓名:</label>
                <input type="text" id="ename1" name="ename" size="10" placeholder="例如:王衍申" autocomplete="off">
                <span id="enameCheck"></span>
                <!--enameCheck-->
            </div>
            <!--sex-->
            <div class="divItem">
                <label for="" class="itemTitle">性別:</label>
                <label>
                    <input type="radio" name="gender" id="sex1" value="male">男
                </label>
                <label>
                    <input type="radio" name="gender" id="sex2" value="female">女
                </label>
                <label>
                    <input type="radio" name="gender" id="sex3" value="other">其他
                </label>
                <span id="sexCheck"></span>
                <!--sexCheck-->
            </div>
            <div class="divItem">
                <!--rocid1-->
                <label for="rocid1" class="itemTitle">身分證字號:</label>
                <input type="text" name="rocid1" id="rocid1" maxlength="10" size="15" placeholder="例如:M140051653">
                <span id="rocidCheck"></span>
                <!--rocidCheck-->
            </div>
            <div class="divItem">
                <!--year1-->
                <!--month1-->
                <!--day1-->
                <label for="year1" class="itemTitle">生日:</label>
                <label for="year1" class="in_label">民國</label>
                <input class="in" type="text" name="year1" id="year1" maxlength="3" size="3">
                <label for="year1" class="in_label">年</label>
                <input class="in" type="text" name="month1" id="month1" maxlength="2" size="2">
                <label for="month1" class="in_label">月</label>
                <input class="in" type="text" name="day1" id="day1" maxlength="2" size="2">
                <label for="day1" class="in_label">日</label>
                <span id="birthCheck"></span>
                <!--birthCheck-->
            </div>
            <div class="divItem">
                <!--cname1-->
                <label for="cname1" class="itemTitle">公司名稱:</label>
                <input type="text" id="cname1" name="cname1" size="25" placeholder="例如:楊泰企業股份有限公司">
                <span id="cnameCheck"></span>
                <!--cnameCheck-->
            </div>
            <div class="divItem">
                <!--account1-->
                <label for="account1" class="itemTitle">帳號:</label>
                <input type="text" id="account1" name="account1" size="15">
                <span id="acntCheck"></span>
                <!--acntCheck-->
            </div>
            <div class="divItem">
                <!--pwd1-->
                <label for="pwd1" class="itemTitle">密碼:</label>
                <input type="password" id="pwd1" name="pwd1" maxlength="15" size="15">
                <span id="pwd1Check"></span><br>
                <input type="checkbox" id="showPwd">顯示密碼
                <!--psw1Check-->
            </div>
            <div class="divItem">
                <!--pwd2-->
                <label for="pwd2" class="itemTitle">確認密碼:</label>
                <input type="password" id="pwd2" name="pwd2" maxlength="15" size="15">
                <span id="pwd2Check"></span>
                <!--psw2Check-->
            </div>
            <div class="divItem">
                <!--email1-->
                <label for="email1" class="itemTitle">E-mail:</label>
                <input type="text" name="email1" id="email1" size="15" placeholder="aaa@gmail.com">
                <span id="emailCheck"></span>
                <!--emailCheck-->
            </div>
            <div class="divItem">
                <!--phone1-->
                <!--phone2-->
                <label for="phone1" class="itemTitle">電話:</label>
                <label for="phone1">(</label>
                <input class="addr" type="text" name="phone1" id="phone1" maxlength="4" size="4" placeholder="02">
                <label for="phone1">)</label>
                <input type="text" name="phone2" id="phone2" maxlength="8" size="10" placeholder="66316666">
                <span id="phoneCheck"></span>
                <!--phoneCheck-->
            </div>
            <div class="divItem">
                <!--add1-->
                <lable class="itemTitle">公司縣市:</lable>
                <select name="addr1" id="addr1">
                    <option value="" style="color: lightgray;">--未選擇--</option>
                                        <optgroup label="北部">
                        <option name="KLU"value="基隆市">基隆市</option>
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
                </select><span id="addr1Check"></span>
                <!--addr1Check-->
                <br><br>
                <!--addr2-->
                <label for="addr2" class="itemTitle">郵遞區號:</label>
                <label for="addr2">(</label>
                <input class="addr" type="text" name="addr2" id="addr2" size="5" placeholder="106">
                <label for="addr2">)</label>
                <span id="addr2Check"></span>
                <!--addr2Check-->
                <br><br>
                <!--addr3-->
                <label for="addr3" class="itemTitle">公司地址:</label>
                <input type="text" name="addr3" id="addr3" size="20" placeholder="台北市大安區復興南路一段390號2樓">
                <span id="addr3Check"></span>
                <!--addr3Check-->
            </div>
        </fieldset>
        <div class="sub">
            <span style="color: red;" id="subBtnCheck"></span><br><br>
            <input type="submit" class="btn" id="subBtn" name="updateHealth" value="送出">
            <!-- &ensp; -->
            <input type="reset" class="btn" value="清除">
            <a href="../Member/Total.jsp">回到管理者介面</a>
        </div>
    </form>

    <script src="../js/UpdateHealth.js"></script>

</body>

</html>