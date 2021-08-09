<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Drug Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
	
<h3>藥物清單</h3>
<form:form action="update" method="get">
<input type="submit" value="新增藥品" />
</form:form>
<c:if test="${!empty listDrugs}">
	<table class="tg">
	<tr>
		<th width="80">編號</th>
		<th width="120">註冊號碼</th>
		<th width="120">中文藥名</th>
		<th width="120">英文藥名</th>
		<th width="120">申請商</th>
		<th width="120">形狀</th>
		<th width="120">顏色</th>
		<th width="120">外型</th>
		<th width="60">修改</th>
		<th width="60">刪除</th>
	</tr>
	<c:forEach items="${listDrugs}" var="Drug">
		<tr>
			<td>${Drug.id}</td>
			<td>${Drug.cnumber}</td>
			<td>${Drug.chinesename}</td>
			<td>${Drug.englishname}</td>
			<td>${Drug.applicant}</td>
			<td>${Drug.shape}</td>
			<td>${Drug.color}</td>
			<td>${Drug.appearance}</td>
			<td><a href="<c:url value='update'/>" >Edit</a></td>
			<td><a href="<c:url value='./remove/${Drug.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>