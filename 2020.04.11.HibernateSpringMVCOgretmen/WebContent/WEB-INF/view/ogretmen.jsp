<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Öğretmen</title>
</head>
<body>
	<h1>ÖĞRETMEN</h1>


	<f:form action="ogretmenGunelle" modelAttribute="ogr">
	<f:hidden path="id"/>
		<table>

			<tr>
				<td>Öğretmen ID:</td>
				<td><f:input path="id"  disabled="true"/> <f:errors path="id" cssClass="hata" /></td>
			</tr>
			<tr>
				<td>Öğretmen Ad:</td>
				<td><f:input path="ad" /> <f:errors path="ad" cssClass="hata" /></td>
			</tr>
			<tr>
				<td>Öğretmen Soyad:</td>
				<td><f:input path="soyad" /> <f:errors path="soyad"
						cssClass="hata" /></td>
				
			</tr>
			<tr>
				<td>Öğretmen Eposta:</td>
				<td><f:input path="eposta" /> <f:errors path="eposta"
						cssClass="hata" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Öğretmen Güncelle"></td>
			</tr>
		</table>

	</f:form>
	<br>
	<br>
	<br>

<!-- 
	<f:form action="ogretmenDtyGunelle" modelAttribute="ogrDty">
	<f:hidden path="id"/>
		<table>
			<tr>
				<td>Öğretmen Detay ID:</td>
				<td> <f:input path="id"/> <f:errors
						path="id" cssClass="hata" /></td>
			</tr>
			<tr>
				<td>Uzmanlık: </td>
				<td><f:input path="uzmanlik" /> <f:errors
						path="uzmanlik" cssClass="hata" /></td>
			</tr>
			<tr>
				<td>Hobi:</td>
				<td> <f:input path="hobiler" /> <f:errors path="hobiler"
						cssClass="hata" /></td>
			</tr>
			<tr>
				<td>WEB Site:</td>
				<td> <f:input path="webSite" /> <f:errors
						path="webSite" cssClass="hata" /></td>
			</tr>
			<tr>
				<td>FaceBook Sayfası: </td>
				<td><f:input path="fbSayfasi" /> <f:errors
						path="fbSayfasi" cssClass="hata" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Detay Güncelle"></td>
			</tr>
		</table>

	</f:form>
	<br>
	<br>
 -->
	<f:form action="anasayfa">
		<input type="submit" value="Ana Sayfa">
	</f:form>
	<br>
	<br>



</body>
</html>