<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MVC</title>
</head>
<body>
<CENTER>
<h2>加入會員</h2>
<h3>(Hibernate+Filter版, with LazyLoading)</h3>
     呼叫ch04.ex01.model.dao.MemberDao介面的saveMember()進行新增<BR>
(實作類別為ch04.ex01.model.dao.impl.MemberDaoImpl_LazyLoadingThruFilter.java)
     
<HR>
<Form Action="register0403.do" method="POST">
    <Table>
         <TR>
             <TD align="RIGHT">帳號：</TD>
             <TD align="LEFT"><input	type="text" name="userId" value="${param.userId}" size="20">
             <font color='red' size='-1'>${ErrorMsg.userId}</font>
             </TD>
         </TR>
         <TR>
             <TD align="RIGHT">密碼：</TD>
             <TD align="LEFT" ><input	type="password" name="pswd" value="${param.pswd}" size="20">
             <font color='red' size='-1'>${ErrorMsg.pswd}</font>
             </TD>
         </TR>             
         <TR>
             <TD align="RIGHT">姓名：</TD>
             <TD align="LEFT" ><input	type="text" name="userName" value="${param.userName}"  size="30">
             <font color='red' size='-1'>${ErrorMsg.userName}</font>
             </TD>
         </TR>             
         <TR>
             <TD align="RIGHT">eMail：</TD>
             <TD align="LEFT" ><input type="text" name="eMail" value="${param.eMail}" size="40">
             <font color='red' size='-1'>${ErrorMsg.eMail}</font>
             </TD>
         </TR>             
         <TR>
             <TD align="RIGHT">電話號碼：</TD>
             <TD align="LEFT" > <input type="text" name="tel" value="${param.tel}">
             <font color='red' size='-1'>${ErrorMsg.tel}</font>
             </TD>
         </TR>             
         <TR>
             <TD align="RIGHT">使用Java經驗：</TD>
             <TD align="LEFT" > <input type="text" name="experience" value="${param.experience}" size="3"> 年
             <font color='red' size='-1'>${ErrorMsg.experience}</font>
             </TD>
         </TR>    
        <TR>
            <TD colspan="2" align="center"><input type="submit" value="提交"> </TD>
            </TR>
         </Table>
</form>
          <font color='red' size='-1'>${ErrorMsg.overallMessage}</font>
<p>
<small>&lt;&lt;<a href="../">回第四章首頁</a>&gt;&gt;</small>
</center>
</body>

</html>
