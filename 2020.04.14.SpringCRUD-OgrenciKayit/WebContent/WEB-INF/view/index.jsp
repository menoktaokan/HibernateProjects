<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<center>
<button onclick="window.location.href='ogrenci/list'" class="button">Öğrencileri Listele</button>
<br><br>
<button onclick="window.location.href='kurs/list'" class="button">Kursları Listele</button>
<br>
<br><br>
<button onclick="window.location.href='employee/list'" class="button">Employee List</button>
<br>
</center>
</body>
</html>