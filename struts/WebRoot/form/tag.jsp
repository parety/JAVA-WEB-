<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
 
<html> 
	<head>
		<title>JSP for TagForm form</title>
		<style type="text/css">
		body {font-size: 12px; }
		</style>
	</head>
	<body>
		<html:form action="/tag">
			
			选择框：<html:checkbox property="checkbox" value="体育">体育</html:checkbox>
			<html:checkbox property="checkbox" value="音乐">音乐</html:checkbox>
			<html:checkbox property="checkbox" value="影视">影视</html:checkbox> <br/>
			
			文件域：<html:file property="file"></html:file> <br/>
			
			隐藏域：<html:hidden property="hidden"/> <br/>
			
			多选框：<html:multibox property="multibox" value="选项一" />选项一
			<html:multibox property="multibox" value="选项二" />选项二 <br/>
			
			密码域：<html:password property="password"></html:password> <br/>
			
			单选框：<html:radio property="radio" value="男">男</html:radio>
			<html:radio property="radio" value="女">女</html:radio> <br/>
			
			下拉框：<html:select property="select">
				<html:option value="选项一">选项一</html:option>
				<html:option value="选项二">选项二</html:option>
			</html:select> <br/>
			
			输入框：<html:text property="text"></html:text> <br/>
			
			文本域：<html:textarea property="textarea"></html:textarea> <br/>
			
		
			图片按钮：<html:image src="${ pageContext.request.contextPath }/images/submit.gif"></html:image> <br/>
		
			普通按钮：<html:button property="button" value="普通按钮"></html:button> <br/>
			
			提交按钮：<html:submit value="提交按钮"/> <br/>
			重置按钮：<html:cancel value="重置按钮"/> <br/>
			
			<logic:present name="personList"> <br/>
			使用List内容显示下拉框：<html:select property="select">
					<html:options collection="personList" property="id" labelProperty="name" />
				</html:select>
			</logic:present>
			
			
		</html:form>
	</body>
</html>

