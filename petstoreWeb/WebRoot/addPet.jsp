<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
	
<tiles:insertTemplate template="/template.jsp" flush="true">
	<tiles:putAttribute name="content">

		<h4>
		当前类别：
		<a href="<struts:url action="category" includeParams="none" />?parent.id=<struts:property value="categoryEO.id" />"><struts:property value="categoryEO.name" /></a>
		</h4>
		
		<div style="color: red; ">
			<struts:property value="message" />
		</div>
	
		<struts:form action="pet">
			<struts:hidden name="action" value="add"></struts:hidden>
			<struts:hidden name="categoryEO.id"></struts:hidden>
			<struts:label name="categoryEO.name" label="类别" disabled="true"></struts:label>
			<struts:textfield name="petEO.name" label="宠物名称"></struts:textfield>
			<struts:textfield name="petEO.price" label="宠物价格"></struts:textfield>
			<struts:submit value="提交" cssClass="button"></struts:submit>
		</struts:form>
					
	</tiles:putAttribute>
</tiles:insertTemplate>