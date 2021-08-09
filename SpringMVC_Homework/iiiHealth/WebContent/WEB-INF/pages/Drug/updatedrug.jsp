<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page session="false"%>

<h2 style="text-align: center">更新藥品資料</h2>
<form:form method="POST" action="add"
	modelAttribute="Drug">
	<table class="table  table-hover">
		<tr>
			<td><form:label path="id">編號:</form:label></td>
			<td><form:input path="id" readonly="true" /></td>
			<td><form:hidden path="id" /></td>
       </tr>
		<tr>
			<td><form:label path="cnumber">申請名稱:</form:label></td>
			<td><form:input path="cnumber" /></td>
		</tr>
		<tr>
			<td><form:label path="chinesename">中文藥名:</form:label></td>
			<td><form:input path="chinesename" /></td>
		</tr>
		<tr>
			<td><form:label path="englishname">英文藥名:</form:label></td>
			<td><form:input path="englishname" /></td>
		</tr>
		<tr>
			<td><form:label path="applicant">申請商:</form:label></td>
			<td><form:input path="applicant" /></td>
		</tr>
		<tr>
			<td><form:label path="shape">形狀:</form:label></td>
			<td><form:input path="shape" /></td>
		</tr>
		<tr>
			<td><form:label path="color">顏色:</form:label></td>
			<td><form:input path="color" /></td>
		</tr>
		<tr>
			<td><form:label path="appearance">外觀:</form:label></td>
			<td><form:input path="appearance" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="送出" /></td>
			<td><input type="button" class="btn" onclick="history.back()"
				value="取消新增"></td>
		</tr>
	</table>
</form:form>