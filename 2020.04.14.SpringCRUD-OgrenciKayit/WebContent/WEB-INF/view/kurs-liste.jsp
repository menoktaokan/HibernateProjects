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
<title>Kurslar</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<style>
.ekle, #kaydet, .ekle, .vazgec, .ana-sayfa, .delete-button,
	.update-button {
	cursor: pointer;
}

body:active, .ekle:active, #kaydet:active, .ekle:active, .vazgec:active,
	.ana-sayfa:active, .delete-button:active, .update-button:active {
	cursor: -webkit-grabbing;
	cursor: grabbing;
}

body {
	cursor: cursor: -webkit-grab;
	cursor: grab;
}
</style>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Kurs Listeleme</h2>
		</div>
	</div>


	<div id="content">
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>İsim</th>
					<th>Saat</th>
					<th>Öğretmen</th>
					<th>İşlem</th>
				</tr>
			</thead>
			<tbody>
				<frm:form action="kurs-ara" modelAttribute="kursAra" method="POST">
					<tr>
						<td><frm:input path="id" /></td>
						<td><frm:input path="ad" /></td>
						<td><frm:input path="saat" /></td>
						<td><frm:select path="ogretmen.id">
								<frm:option value="">*Hepsi*</frm:option>
								<frm:options items="${ogretmenler}" />
							</frm:select></td>
						<td><frm:button value="save" name="save" id="kaydet">Ara</frm:button></td>
					</tr>
				</frm:form>
				<c:forEach items="${kurs}" var="kurs">
					<c:url var="updateLink" value="/kurs/kurs-guncelle">
						<c:param name="ogrenciId" value="${kurs.id}" />
					</c:url>
					<c:url var="deleteLink" value="/kurs/kurs-sil">
						<c:param name="ogrenciId" value="${kurs.id}" />
					</c:url>
					<tr>
						<td>${kurs.id}</td>
						<td>${kurs.ad}</td>
						<td>${kurs.saat}</td>
						<td>${kurs.ogretmen}</td>
						<td><button onclick="window.location.href='${updateLink}'"
								class="update-button">Güncelle</button>
							<button
								onclick="if(confirm('Siliyoruz, Emin misin?'))window.location.href='${deleteLink}'"
								class="delete-button">Sil</button></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<br>
		<button onclick="window.location.href='kurs-ekle'" class="ekle">Kurs
			Ekle</button>
		<br> <br>
		<button onclick="window.location.href='../index'" class="ana-sayfa">Ana
			Sayfa</button>
	</div>

</body>
</html>