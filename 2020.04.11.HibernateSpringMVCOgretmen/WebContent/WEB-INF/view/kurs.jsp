<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kurs</title>
</head>
<body>
	<h1>KURS</h1>

	<f:form action="kursGuncelle" method="GET" modelAttribute="kurs">
		<table>

			<tr>
				<td>Kurs ID:</td>
				<td><f:input path="id" /> <f:errors path="id" cssClass="hata" /></td>
			</tr>
			<tr>
				<td>Adı:</td>
				<td><f:input path="ad" /> <f:errors path="ad" cssClass="hata" /></td>
			</tr>
			<tr>
				<td>Saat:</td>
				<td><f:input path="saat" /> <f:errors path="saat"
						cssClass="hata" /></td>

			</tr>
			<tr>
				<td>Öğretmeni:</td>
				<td><f:input path="ogretmen.ad" /> <f:errors path="" cssClass="hata" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Kurs Güncelle"></td>
			</tr>
		</table>

	</f:form>
	<br>
	<br>
	<br>
	<f:form action="anasayfa">
		<input type="submit" value="Ana Sayfa">
	</f:form>
	<br>
	<br>
</body>
</html>