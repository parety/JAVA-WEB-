<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
	
<tiles:insertTemplate template="/template.jsp">

	<tiles:putAttribute name="content">
	
		<h4>注册用户</h4>
  
	  	<struts:form action="user">
	  		<struts:hidden name="action" value="register"></struts:hidden>
	  		<struts:textfield name="userEO.login" label="帐号"></struts:textfield>
	  		<struts:password name="userEO.password" label="密码"></struts:password>
	  		<struts:password name="confirmPassword" label="密码"></struts:password>
	  		<struts:submit value="注册" cssClass="button"></struts:submit>
	  	</struts:form>
	  	
	</tiles:putAttribute>
	
</tiles:insertTemplate>
