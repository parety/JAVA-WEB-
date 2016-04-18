<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>JSP for PersonForm form</title>
	</head>
	<body>

		${ pageContext.request.requestURI }

		<c:forEach var="person" items="${ personList }">
			${ person.account }, ${ person.name }, ${ person.sex }, <BR />
		</c:forEach>

	</body>
</html>

