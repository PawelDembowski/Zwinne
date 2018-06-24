<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hotel Manager</title>
<script src="<c:url value="/js/jquery.min.js"/>"></script>
<script src="<c:url value="/js/jquery-ui.min.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/style/style.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/style/jquery-ui.min.css"/>">

<script type="text/javascript">
	$(document).ready(function() {
		$(".datepicker").datepicker({
			dateFormat : "dd-mm-yy"
		});
	});
</script>
</head>
<body>
	<ul id="menu">
	    <li><a href="<c:url value="/"/>">Strona domowa</a> |</li>
		<li><a href="<c:url value="/goscie"/>">Goscie</a></li>
	</ul>
	
	<div id="page">
		<h1>Dodaj Gościa</h1>
	
		<form action="<c:url value="/goscie/save"/>" method="post">
			<div class="row">
				<label for="pesel">PESEL</label> <input type="text" id="pesel"
					name="pesel" value="${fn:escapeXml(gosc.pesel)}"
					<c:if test="${action == 'edit'}">readonly="readonly"</c:if>>
			</div>
			<div class="row">
				<label for="imie">Imię</label> <input type="text" id="imie"
					name="imie" value="${fn:escapeXml(gosc.imie)}">
			</div>
			<div class="row">
				<label for="nazwisko">Nazwisko</label> <input type="text"
					id="nazwisko" name="nazwisko"
					value="${fn:escapeXml(gosc.nazwisko)}">
			</div>
			<div class="row">
				<label for="data">Data urodzenia</label> <input type="text"
					id="data" name="data" class="datepicker" autocomplete="off"
					value="<fmt:formatDate value="${gosc.data}" pattern="dd-MM-yyyy" />">
			</div>

			<div class="button-container">
				<a href="<c:url value="/goscie"/>"><button type="button">Wróć</button></a>
				<button type="submit">Zapisz</button>
			</div>
		</form>
	</div>

</body>
</html>