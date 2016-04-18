<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
	
<tiles:insertTemplate template="/template.jsp">

	<tiles:putAttribute name="content">
	
		<h4>登录</h4>
  
	  	<struts:form action="user">
	  		<struts:hidden name="action" value="login"></struts:hidden>
	  		<struts:textfield name="userEO.login" label="帐号"></struts:textfield>
	  		<struts:password name="userEO.password" label="密码"></struts:password>
	  		<struts:submit value="提交" cssClass="button"></struts:submit>
	  	</struts:form>
	  	
	</tiles:putAttribute>
	
</tiles:insertTemplate>
