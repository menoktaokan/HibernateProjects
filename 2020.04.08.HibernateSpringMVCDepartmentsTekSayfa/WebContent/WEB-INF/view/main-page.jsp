<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
<style type="text/css">
.form {
	margin: auto;
	margin-top : 50px;
	background-color: #FFCCCC;
	width: 300px;
	border: 1px solid black;
}

.form2 {
	margin: auto;
	margin-top : 50px;
	background-color: #FFFFCC;
	width: 400px;
	border: 1px solid black;
}

.div {
	text-align: center;
}

tr, td {
	padding-top: 10px;
	padding-left: 10px;
}
.hata{
color:red;
}
</style>
</head>
<body>


	<form action="search" method="GET" class="form">
		<table>
			<tr>
				<td>Department Id:</td>
				<td><input type="text" name="id"><f:errors path="id" cssClass="hata"/> </td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>

	</form>

<f:form action="update" modelAttribute="dept"
		class="form2">
		<f:hidden path="id"/>
		<table width="350" cellpadding="5">
			<tr>
				<td>Department ID:</td>
				<td><f:input path="id" disabled="true"/><f:errors path="id" cssClass="hata"/> </td>
			</tr>
			<tr>
				<td>Department Name:</td>
				<td><f:input path="name"/><f:errors path="name" cssClass="hata"/></td>
			</tr>
			<tr>
				<td>Manager ID:</td>
				<td><f:input path="managerId"/><f:errors path="managerId" cssClass="hata"/></td>
			</tr>
			<tr>
				<td>Location ID:</td>
				<td><f:input path="locationId"/><f:errors path="locationId" cssClass="hata"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update" class="div"></td>
			</tr>
		</table>

	</f:form>

</body>
</html>