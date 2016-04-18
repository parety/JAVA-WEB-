<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles"
	prefix="tiles"%>

<tiles:insertTemplate template="/template.jsp" flush="true">

	<tiles:putAttribute name="content">

		<div align="center">
			<br/>
			<br/>
			
			<input type="button" class=button
				value="继续添加"
				onclick="location='<struts:url action="pet" includeParams="none"></struts:url>?action=add&categoryEO.id=<struts:property value="categoryEO.id" />'" />
			
			<input type="button" class=button
				value="查看<struts:property value="categoryEO.name" />列表"
				onclick="location='<struts:url action="category" includeParams="none"></struts:url>?parent.id=<struts:property value="categoryEO.id" />'" />

			<input type=button class="button" value="进入宠物商店 &gt;&gt;" onclick="location='<struts:url action="category" includeParams="none" />?action=list'" />
			
		</div>

	</tiles:putAttribute>
	
</tiles:insertTemplate>
