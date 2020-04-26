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
<title>Kurs Formu</title>
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
body{
cursor: cursor: -webkit-grab;
	cursor: grab;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Kurs Formu</h2>
		</div>
		<frm:form action="kurs-kaydet" modelAttribute="kurs" method="POST">
			<frm:hidden path="id" />
			<frm:hidden path="durum" value="1" />
			<table>
				<tr>
					<td><label>İsim</label></td>
					<td><frm:input path="ad" required="true" /></td>
				</tr>
				<tr>
					<td><label>Saat</label></td>
					<td><frm:input type="number" path="saat" required="true" /></td>
				</tr>
				<tr>
					<td><label>Öğretmen</label></td>
					<td><frm:select path="ogretmen.id">
							<frm:options items="${ogretmenler}" />
						</frm:select></td>
				</tr>
				<tr>
					<td></td>
					<td><frm:button value="save" name="save" id="kaydet">Kaydet</frm:button></td>
				</tr>
			</table>
		</frm:form>
		<br>
		<br>
		<button onclick="window.location.href='list'" class="vazgec">Vazgeç</button>
	</div>

	<div id="container">
		<div id="content"></div>
	</div>
</body>
</html>