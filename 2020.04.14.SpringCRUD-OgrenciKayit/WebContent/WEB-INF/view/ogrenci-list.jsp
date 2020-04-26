<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Öğrenciler</title>
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
			<h2>Öğrenci Listeleme</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>İsim</th>
						<th>Soyisim</th>
						<th>Öğrenci No</th>
						<th>İşlem</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ogrenciler}" var="ogrenci">
						<c:url var="updateLink" value="/ogrenci/ogrenci-guncelle">
							<c:param name="ogrenciId" value="${ogrenci.id}" />
						</c:url>
						<c:url var="deleteLink" value="/ogrenci/ogrenci-sil">
							<c:param name="ogrenciId" value="${ogrenci.id}" />
						</c:url>
						<tr>
							<td>${ogrenci.id}</td>
							<td>${ogrenci.ad}</td>
							<td>${ogrenci.soyad}</td>
							<td>${ogrenci.ogrenciNo}</td>
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
			<button onclick="window.location.href='ogrenci-ekle'" class="ekle">Öğrenci
				Ekle</button>
			<br> <br>
			<button onclick="window.location.href='index'" class="ana-sayfa">Ana
				Sayfa</button>
		</div>
	</div>
</body>
</html>