<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>

<html>
	<head>
		<title>JSP for UploadForm form</title>
		<style type="text/css">
		body {font-size: 12px; }
		</style>
	</head>
	<body>
		<html:form action="/upload?action=upload"
			enctype="multipart/form-data">
			
			文件：<html:file property="file" style="width: 200px; "></html:file>
			<br />
			备注：<html:textarea property="text" style="width: 200px; "></html:textarea>
			<br /><br />

			<html:submit value="开始上传" />
		</html:form>
	</body>
</html>

