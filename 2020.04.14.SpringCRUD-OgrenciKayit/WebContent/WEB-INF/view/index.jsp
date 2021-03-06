<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/index.css">
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

  <div class="container">

<div class="wrap">	
    <button onclick="window.location.href='ogrenci/list'"  class="clicker">Öğrencileri Listele</button>
    <div class="circle angled"></div>
  </div>


  <div class="wrap">	
    <button onclick="window.location.href='kurs/list'"  class="clicker fast">Kursları Listele</button>
    <div class="circle angled second"></div>
  </div>


<div class="wrap">	
    <button onclick="window.location.href='employee/list'"  class="clicker faster">Employee List</button>
    <div class="circle angled third"></div>
  </div>
</div>
</body>
</html>