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
<link rel="stylesheet" type="text/css"
	href="<c:url value="/style/style.css"/>">

<script type="text/javascript">

	$(document).ready(function() {
		$('.delete-link').click(function(event) {
			// submit delete form
			event.preventDefault();
			if (confirm('Czy chcesz usunąć gościa?')) {
				$(event.target).closest('form').submit();
			}
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
		<h1>Goście</h1>

		<div class="actions">
			<a href="<c:url value="/goscie/add"/>">Dodaj</a>
		</div>
		<table>
			<thead>
				<tr>
					<th>PESEL</th>
					<th>Imię</th>
					<th>Nazwisko</th>
					<th>Data urodzenia</th>
					<!-- Action column -->
					<th></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${goscie}" var="gosc">
					<tr>
						<td>${gosc.pesel}</td>
						<td>${gosc.imie}</td>
						<td>${gosc.nazwisko}</td>
						<td><fmt:formatDate value="${gosc.data}" pattern="dd-MM-yyyy" /></td>
						<td class="actions">
							<!-- Edit link --> <a
							href="<c:url value="/goscie/edit?pesel=${gosc.pesel}"/>">Edytuj</a>
							| <!-- Delete link -->
							<form action="<c:url value="/goscie/delete"/>" method="post"
								class="inline">
								<input type="hidden" name="pesel"
									value="${fn:escapeXml(gosc.pesel)}"> <a href=""
									class="delete-link">Usuń</a>
							</form>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

</body>
</html>