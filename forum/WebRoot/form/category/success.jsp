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
					<strong class="fl w">添加成功</strong>
				</th>
			</tr>
		</table>
	</div>

	<div class="t t2">
		<table cellspacing="0" cellpadding="0" width="100%"
			style="table-layout:fixed;border-top:0">
			<tr class="tr1">
				<th style="text-align: center; line-height: 20px; ">

					<a href="<html:rewrite action="/category?action=initAdd" />">继续添加</a>
					<br />
					<a href="<html:rewrite action="/category?action=list" />">回到首页</a>


				</th>
			</tr>
		</table>
	</div>

	<jsp:include flush="true" page="../footer.jsp" />