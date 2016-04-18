<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>

<jsp:include flush="true" page="../header.jsp"></jsp:include>


<div id="main">

	<!-- Thread Start -->
	<div class="t" style="margin-bottom:0px; border-bottom:0">
		<table cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<th class="h">
					<strong class="fl w">欢迎回来</strong>
				</th>
			</tr>
		</table>
	</div>

	<div class="t t2">
		<table cellspacing="0" cellpadding="0" width="100%"
			style="table-layout:fixed;border-top:0">
			<tr class="tr1">
				<th>
					<html:form action="/person">
						<a href="<html:rewrite action="/category?action=list" />">回论坛首页</a>
					</html:form>
				</th>
			</tr>
		</table>
	</div>


	<jsp:include flush="true" page="../footer.jsp" />