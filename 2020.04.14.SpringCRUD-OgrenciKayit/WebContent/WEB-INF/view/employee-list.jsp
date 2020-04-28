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
<title>Employee</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<style>
.ekle, #kaydet, .ekle, .vazgec, .ana-sayfa, .delete-button,
	.update-button {
	cursor: pointer;
}

body:active, .ekle:active, #kaydet:active, .ekle:active, .vazgec:active, .ana-sayfa:active,
	.delete-button:active, .update-button:active {
	cursor: -webkit-grabbing;
	cursor: grabbing;
}

body {
	cursor: cursor: -webkit-grab;
	cursor: grab;
}
#myBtn{
	float: right;
}
</style>
<script>
	//Get the button
	var mybutton = document.getElementById("myBtn");

	// When the user scrolls down 20px from the top of the document, show the button
	window.onscroll = function() {
		scrollFunction()
	};

	function scrollFunction() {
		if (document.body.scrollTop > 20
				|| document.documentElement.scrollTop > 20) {
			mybutton.style.display = "block";
		} else {
			mybutton.style.display = "none";
		}
	}

	// When the user clicks on the button, scroll to the top of the document
	function topFunction() {
		document.body.scrollTop = 10000;
		document.documentElement.scrollTop= 10000;
	}
</script>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Employee List</h2>
		</div>
		<button onclick="window.location.href='employee-ekle'" class="ekle">Employee
			Add</button>
			<button onclick="topFunction()" id="myBtn" class="vazgec" title="Go to top">Bottom</button>
		<br> <br>
		<table>
			<thead>
				<tr>
					<th>Employee ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>E-Mail</th>
					<th>Phone Number</th>
					<th>Hire Date</th>
					<th>Job</th>
					<th>Salary</th>
					<th>Manager</th>
					<th>Department</th>
					<th>Operation</th>

				</tr>
			</thead>
			<tbody>
			<frm:form action="employee-ara" modelAttribute="employeeSearch"
			method="POST">

				<tr>
					<td><frm:input path="id" style="width: 30px"/></td>
					<td><frm:input path="name" style="width: 90px"/></td>
					<td><frm:input path="lastname" style="width: 90px"/></td>
					<td><frm:input path="email"  style="width: 90px"/> </td>
					<td><frm:input path="phoneNumber" placeholder="650.507.9876"
							pattern="^[0-9+-]+(\\.+)*(.[0-9]+)$"
							title="Rakam veya nokta içerebilir" style="width: 100px"/></td>
							<td></td>
<%-- 					<td><frm:input type="date" path="hireDate" --%>
<%-- 							placeholder="2020-04-23"  style="width: 90px" /></td> --%>
					<td><frm:select path="job.jobId" style="width: 90px">
					<frm:option value="">*Any*</frm:option>
							<frm:options items="${jobs}" />
						</frm:select></td>
					<td><frm:input type="number" path="salary" style="width: 57px"/></td>

					<td><frm:select path="manager.id" style="width: 90px">
					<frm:option value="">*Any*</frm:option>
							<frm:options items="${manager}" />
						</frm:select></td>
					<td><frm:select path="department.departmentid" style="width: 90px">
					<frm:option value="">*Any*</frm:option>
							<frm:options items="${departments}" />
						</frm:select></td>
					<td><frm:button value="save" name="save" id="kaydet" style="width: 100px">Search</frm:button></td>
				</tr>
		</frm:form>
				<c:forEach items="${employeeList}" var="employee">
					<c:url var="updateLink" value="/employee/employee-update">
						<c:param name="employeId" value="${employee.id}" />
					</c:url>
					<c:url var="deleteLink" value="/employee/employee-delete">
						<c:param name="employeId" value="${employee.id}" />
					</c:url>

					<tr>
						<td>${employee.id}</td>
						<td>${employee.name}</td>
						<td>${employee.lastname}</td>
						<td>${employee.email}</td>
						<td>${employee.phoneNumber}</td>
						<td>${employee.hireDate}</td>
						<td>${employee.job.jobTitle}</td>
						<td>${employee.salary}</td>
						<td>${employee.manager.name}</td>
						<td>${employee.department}</td>

						<td>
							<%-- 							<a href="${updateLink}">Update</a> --%>
							<button onclick="window.location.href='${updateLink}'"
								class="update-button">Update</button>
							<button
								onclick="if (confirm('Deleting, are you sure?'))window.location.href='${deleteLink}'"
								class="delete-button">Delete</button>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<hr>
		<button onclick="window.location.href='employee-ekle'" class="ekle">Employee
			Add</button>
		<button onclick="window.location.href='../index'" class="ana-sayfa">Ana
			Sayfa</button>
		
	</div>

</body>
</html>