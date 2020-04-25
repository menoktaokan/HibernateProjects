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
<title>Giriş</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/login.css">

<script>
	function validLogin() {
		if (document.form.kullaniciAdi.value == "") {
			alert("Lütfen Kullanıcı Adı Girin");
			document.loginform.userName.focus();
			return false;
		}
		if (document.form.sifre.value == "") {
			alert("Lütfen Şifre Girin");
			document.userform.password.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<frm:form name="form" action="girisYap" method="POST" class="login-form"
		modelAttribute="kullanici" onsubmit="return validLogin();">
		<p class="login-text">
			<span class="fa-stack fa-lg"> <i
				class="fa fa-circle fa-stack-2x"></i> <i
				class="fa fa-lock fa-stack-1x"></i>
			</span>
		</p>
		<frm:input name="kullaniciAdi" path="kullaniciAdi" class="login-username" autofocus="true"
			required="" placeholder="Kullanıcı Adı" />
<%-- 		<frm:errors path="kullaniciAdi" style="color:white" /> --%>
		<frm:input name="sifre" path="sifre" type="password" class="login-password"
			required="" placeholder="Şifre" />
<%-- 		<frm:errors path="sifre" style="color:white" /> --%>
		<input type="submit" name="Login" value="Giris Yap"
			class="login-submit" />
	</frm:form>

	<div class="underlay-photo"></div>
	<div class="underlay-black"></div>
</body>
</html>