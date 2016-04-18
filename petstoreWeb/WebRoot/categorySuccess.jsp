<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles"
	prefix="tiles"%>

<tiles:insertTemplate template="/template.jsp" flush="true">
	<tiles:putAttribute name="content">


		<div align="center">
			<br />
			<br />
			<input type=button class=button
				onclick="location='<struts:url action="category" />?action=add&parent.id=<struts:property value="parent.id" />'"
				value="继续添加" />

			<input type="button" value="查看购物车" class=button
				onclick="location='<struts:url action="cart" includeParams="none"></struts:url>'" />

			<input type=button value="进入宠物商店 &gt;&gt;" class=button
				onclick="location='<struts:url action="category" includeParams="none" />?action=list'" />

		</div>

	</tiles:putAttribute>
</tiles:insertTemplate>
