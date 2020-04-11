<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ana Sayfa</title>
</head>
<body>
	<center>
		<form action="ogretmenAra" method="GET" class="form">
			<table>
				<tr>
					<td>Öğretmen ID: <input type="text" name="id"> <f:errors
							path="id" cssClass="hata" /> <input type="submit"
						value="Öğretmen Ara"></td>
				</tr>
			</table>

		</form>

		<form action="kursAra" method="GET" class="form">
			<table>
				<tr>
					<td>Kurs ID: <input type="text" name="id"> <f:errors
							path="id" cssClass="hata" /> <input type="submit"
						value="Kurs Ara"></td>
				</tr>
			</table>

		</form>
	</center>
</body>
</html>