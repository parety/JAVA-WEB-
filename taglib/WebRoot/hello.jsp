<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.helloweenvsfei.com/tags" prefix="taglib"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<taglib:hello name="Kate" /> <br/>
<taglib:hello name="${ pageContext.request.remoteAddr }" /> <br/>
<taglib:hello name="${ cookie }" /> <br/>

</body>
</html>