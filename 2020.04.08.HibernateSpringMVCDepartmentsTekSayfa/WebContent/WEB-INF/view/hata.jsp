<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
<style type="text/css">
.form {
	margin: auto;
	margin-top : 50px;
	background-color: #FFCCCC;
	width: 300px;
	border: 1px solid black;
}

.form2 {
	margin: auto;
	margin-top : 50px;
	background-color: #FFFFCC;
	width: 400px;
	border: 1px solid black;
}

.div {
	text-align: center;
}

tr, td {
	padding-top: 10px;
	padding-left: 10px;
}
.hata{
color:red;
}
</style>
</head>
<body>


	<form action="search" method="GET" class="form">
		<table>
			<tr>
				

			</tr>
			<tr>
				
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>

	</form>


</body>
</html>