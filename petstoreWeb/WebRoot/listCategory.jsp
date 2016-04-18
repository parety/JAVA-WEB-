<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles"
	prefix="tiles"%>
	
<tiles:insertTemplate template="/template.jsp" flush="true">
	<tiles:putAttribute name="content">

		<h4>
		当前类别：
		<struts:property value="parent.name" />
		</h4>
		
		<input type=button class=button onclick="location='<struts:url action="category" includeParams="none" />?action=add&parent.id=<struts:property value="parent.id" />'" value="添加类别" />
		
		<struts:if test="parent != null">
			<input type=button class=button onclick="location='<struts:url action="pet" includeParams="none" />?action=add&categoryEO.id=<struts:property value="parent.id" />'" value="添加宠物" />
			<input type=button class=button onclick="if(!confirm('确定删除么？')) return; location='<struts:url action="category" includeParams="none" />?action=delete&parent.id=<struts:property value="parent.id" />'; " value="删除本类别" />
		</struts:if>
		<br/>
		<br/>
		
		<table class="table">
			<tr>
				<th>ID</th>
				<th>类别</th>
				<th>名称</th>
				<th>价格</th>
				<th>描述</th>
			</tr>
			<struts:iterator value="petEOList">
				<tr>
					<td><struts:property value="id"/> </td>
					<td><a href="<struts:url action="category" includeParams="none" />?parent.id=<struts:property value="category.id"/>"><struts:property value="category.name"/></a></td>
					<td><struts:property value="name"/> </td>
					<td>￥<struts:property value="price"/> </td>
					<td><a href="<struts:url action="pet?action=buy" includeParams="none" />&petEO.id=<struts:property value="id"/>">购买</a> </td>
				</tr>
			</struts:iterator>
		</table>

	</tiles:putAttribute>
</tiles:insertTemplate>