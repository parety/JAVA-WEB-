<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles"
	prefix="tiles"%>
	
<tiles:insertTemplate template="/template.jsp" flush="true">
	<tiles:putAttribute name="content">
	
		<h4>我的购物车</h4>
		
		<table class="table">
			<tr>
				<th>ID</th>
				<th>类别</th>
				<th>名称</th>
				<th>价格</th>
				<th>数量</th>
				<th>总价格</th>
				<th>购买时间</th>
			</tr>
			<struts:set name="petCount" value="0"></struts:set>
			<struts:set name="priceCount" value="0"></struts:set>
			<struts:iterator value="cartEO.cartItems">
				<struts:set name="petCount" value="#request.petCount + count"></struts:set>
				<struts:set name="priceCount" value="#request.priceCount + count * price"></struts:set>
				<%-- 
				--%>
				<tr>
					<td align="center"><struts:property value="id"/> </td>
					<td><struts:property value="petCategoryName"/></td>
					<td><struts:property value="petName"/> </td>
					<td align="center">￥<struts:property value="price"/> </td>
					<td align="center"><struts:property value="count"/> </td>
					<td align="center">￥<struts:property value="count * price"/> </td>
					<td align="center"><struts:property value="date"/> </td>
				</tr>
			</struts:iterator>
			<tr>
				<th>总计</th>
				<th colspan="3">&nbsp;</th>
				<th>${ petCount }</th>
				<th>￥${ priceCount }</th>
				<th>&nbsp;</th>
			</tr>
		</table>
		
		<div align=center>
			<br /><br />
			<input type=button class=button value="付款" onclick="if(!confirm('确定要付款么？'))	return; location='<struts:url action="cart" includeParams="none" />?action=pay'" />
			<input type=button class=button value="继续逛 &gt;&gt;" onclick="location='<struts:url action="category" includeParams="none" />?action=list'" />
		</div>
		
	</tiles:putAttribute>
</tiles:insertTemplate>