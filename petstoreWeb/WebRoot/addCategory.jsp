<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles"
	prefix="tiles"%>
	
<tiles:insertTemplate template="/template.jsp" flush="true">
	<tiles:putAttribute name="content">

		<h4>
			添加类别 
			父类别：
			<struts:property value="parent.name" />
		</h4>
	
		<struts:form action="category">
			<struts:hidden name="action" value="add"></struts:hidden>
			<struts:hidden name="parent.id"></struts:hidden>
			<struts:if test="%{ parent != null }">
				<struts:label name="parent.name" label="父类别"></struts:label>
			</struts:if>
			<struts:textfield name="categoryEO.name" label="类别名称"></struts:textfield>
			<struts:submit value="添加类别" cssClass="button"></struts:submit>
		</struts:form>
						
	</tiles:putAttribute>
</tiles:insertTemplate>