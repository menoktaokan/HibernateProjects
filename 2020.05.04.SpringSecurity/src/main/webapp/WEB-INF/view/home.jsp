<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
</head>
<body>
<h2>Ana Sayfa</h2>

<f:form action="${pageContext.request.contextPath}/logout" method="POST">

		<input type="submit" value="Logout" />

	</f:form>
	<a href="/2020.04.28.SpringSecurity2/test" >test</a>
</body>
</html>
