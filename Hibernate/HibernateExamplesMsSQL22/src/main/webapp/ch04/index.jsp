<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type="text/css" />
<title>Hibernate</title>
</head>
<body BGCOLOR="white">
<jsp:include page="/commons/header.jsp" />
<h3 align="center">使用多種技術來存取資料庫－以MySQL(SQL Server)為例</h3>
<div align="center">

<table border="1">
  
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="ex01/ch0401_InputData_HBN.jsp">新增會員資料(Hibernate)</a><BR><font face="verdana" size="-2">
      <BR>webapp/ch04/ex01/*.jsp<BR>ch04.ex01.controller.*.java<BR>ch04.ex01.....*.java</font>
    </td>
    <td  width="350"><p align="left">
      <a href="ex02/queryAllMembersHBN.do">查詢會員資料(Hibernate)LazyLoading=false</a><BR>
      <font face="verdana" size="-2">webapp/ch04/ex02/showAllMembersHBN.jsp<BR>
      ch04.ex02.controller.*.java<br>ch04.ex02....*.java</font>
    </td>
  </tr>
  
  <tr height="80" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="ex03/ch0403_InputData_HBN.jsp">新增會員資料(Hibernate)LazyLoading=true</a><BR><font face="verdana" size="-2">webapp/ch04/ex01/ch04_05.jsp<BR>
      webapp/ch04/ex03/*.jsp<BR>ch04.ex03.controller.*.java<BR>ch04.ex03.....*.java</font>
    </td>
    <td  width="350"><p align="left"/>
      <a href="ex04/queryAllMembersHBNFilter.do">查詢會員資料(由Filter 來開啟Session與Transaction)</a><BR><font face="verdana" size="-2">
      webapp/ch04/ex04/*.jsp<BR>
      ch04.ex04.controller.*.java<br>ch04.ex04.....*.java</font>
    </td>       
  </tr>   
</table>
</div>
<hr>
<jsp:include page="/commons/footer.jsp" />
</body>
</html>
