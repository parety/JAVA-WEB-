<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ taglib uri="http://www.helloweenvsfei.com/tags" prefix="taglib"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
<link href="style/style.css" rel="stylesheet" type="text/css" />
<style>
.resizeDivClass {
	position: relative;
	width: 2px;
	z-index: 1;
	left: expression(this . parentElement . offsetWidth-1);
	cursor: e-resize;
	float: left;
}
</style>

<script language=javascript>
function MouseDownToResize(obj){
	obj.mouseDownX=event.clientX;
	obj.pareneTdW=obj.parentElement.offsetWidth;
	obj.pareneTableW=theObjTable.offsetWidth;
	obj.setCapture();
}
function MouseMoveToResize(obj){
    if(!obj.mouseDownX) return false;
    var newWidth=obj.pareneTdW*1+event.clientX*1-obj.mouseDownX;
    if(newWidth>0)
    {
	obj.parentElement.style.width = newWidth;
	theObjTable.style.width=obj.pareneTableW*1+event.clientX*1-obj.mouseDownX;
	}
}
function MouseUpToResize(obj){
	obj.releaseCapture();
	obj.mouseDownX=0;
	var objId = obj.parentElement.id;
	document.cookie = objId + '_width=' + obj.parentElement.style.width;
	document.cookie = theObjTable.id + '_width=' + theObjTable.style.width;
}
function readCookie(name){
	var start1 = document.cookie.indexOf(name + "=");
	if (start1 == -1)
		return null;
	else
	{
		start = document.cookie.indexOf("=" ,start1) + 1; 
		var end = document.cookie.indexOf(";", start);
		if (end == -1)
		{
			end = document.cookie.length;
		}
		var value = unescape(document.cookie.substring(start, end));
		return value;
	}
}
</script>
</head>
<body>

<taglib:table items="${ personList }" url="test.jsp">
	<taglib:column property="id" label="���" />
	<taglib:column property="name" label="����" />
	<taglib:column property="age" label="����" />
	<taglib:column property="sex" label="�Ա�" />
	<taglib:column property="address" label="��ַ" />
	<taglib:column property="telephone" label="�绰" />
	<taglib:column property="mobile" label="�ֻ�" />
	<taglib:column property="city" label="����" />
	<taglib:column property="deleted" label="�Ƿ�ɾ��" />
</taglib:table>

<script type="text/javascript">
columns[columns.length] = 'theObjTable';
for(var i=0; i<columns.length; i++){
	var width = readCookie(columns[i] + '_width');
	if(width){
		document.getElementById(columns[i]).style.width = width;
	}
}
</script>

</body>
</html>