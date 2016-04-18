<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles"
	prefix="tiles"%>

<tiles:insertTemplate template="/template.jsp" flush="true">
	<tiles:putAttribute name="content">

		<h4>当前类别：
		<a
			href="<struts:url action="category" includeParams="none" />?parent.id=<struts:property value="categoryEO.id" />"><struts:property
				value="categoryEO.name" />
		</a>
		</h4>
	
		<struts:form action="pet">
			<struts:hidden name="action" value="buy"></struts:hidden>
			<struts:hidden name="petEO.id"></struts:hidden>
			<struts:textfield name="petEO.name" label="宠物名称" readonly="true"></struts:textfield>
			<struts:textfield name="petEO.price" label="宠物价格" readonly="true"></struts:textfield>
			<struts:textfield name="count" label="购买数量"></struts:textfield>
			<struts:submit value="提交" cssClass="button"></struts:submit>
		</struts:form>

	</tiles:putAttribute>
</tiles:insertTemplate>
