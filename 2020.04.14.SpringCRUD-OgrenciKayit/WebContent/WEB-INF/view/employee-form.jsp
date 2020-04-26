<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Form</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<style>
.hata {
	color: red;
}

.ekle, #kaydet, .ekle, .vazgec, .ana-sayfa, .delete-button,
	.update-button {
	cursor: pointer;
}

body:active, .ekle:active, #kaydet:active, .ekle:active, .vazgec:active, .ana-sayfa:active,
	.delete-button:active, .update-button:active {
	cursor: -webkit-grabbing;
	cursor: grabbing;
}
body{
cursor: cursor: -webkit-grab;
	cursor: grab;
}
</style>

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Employee Form</h2>
		</div>
		<frm:form action="employee-kaydet" modelAttribute="employee"
			method="POST">
			<frm:hidden path="id" />
			<frm:hidden path="status" value="1" />
			<table>
				<tr>
					<td><label>First Name</label></td>
					<td><frm:input path="name" required="true" /> <frm:errors
							path="name" cssClass="hata" /></td>
				</tr>
				<tr>
					<td><label>Last Name</label></td>
					<td><frm:input path="lastname" required="true" /> <frm:errors
							path="lastname" cssClass="hata" /></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><frm:input path="email" required="true" /> <frm:errors
							path="email" cssClass="hata" /></td>
				</tr>
				<tr>
					<td><label>Phone Number</label></td>
					<td><frm:input path="phoneNumber" placeholder="650.507.9876"
							required="true"
							pattern="^[0-9+-]+(\\.[0-9+-]+)*[0-9-]+(.[0-9]+)$"
							title="Rakam veya nokta içerebilir" /> <frm:errors
							path="phoneNumber" cssClass="hata" /></td>
				</tr>
				<tr>
					<td><label>Hire Date</label></td>
					<td><frm:input type="date" path="hireDate" required="true"
							placeholder="2020-04-23" /> <frm:errors path="hireDate"
							cssClass="hata" /></td>
				</tr>
				<tr>
					<td><label>Job Title</label></td>
					<td><frm:select path="job.jobId">
							<frm:options items="${jobs}" />
						</frm:select></td>
				</tr>
				<tr>
					<td><label> Salary </label></td>
					<td><frm:input type="number" path="salary" required="true" />
						<frm:errors path="salary" cssClass="hata" /></td>
				</tr>
				<tr>
					<td><label>Manager ID</label></td>
					<td><frm:select path="manager.id">
							<frm:options items="${manager}" />
						</frm:select></td>
				</tr>
				<tr>
					<td><label>Departments</label></td>
					<td><frm:select path="department.departmentid">
							<frm:options items="${departments}" />
						</frm:select></td>
				</tr>
				<tr>
					<td></td>
					<td><frm:button value="save" name="save" id="kaydet">Save</frm:button></td>
				</tr>
			</table>
		</frm:form>
		<br> <br>
		<button onclick="window.location.href='list'" class="vazgec">Back</button>
	</div>

	<div id="container">
		<div id="content"></div>
	</div>
</body>
</html>