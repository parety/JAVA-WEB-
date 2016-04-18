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
					<strong class="fl w">添加版面</strong> &nbsp;
					<span style="color: red; font-weight: bold; ">${
						exception.message }</span>
				</th>
			</tr>
		</table>
	</div>


	<html:form action="/board">

		<html:hidden property="action" value="add" />
		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout:fixed;border-top:0">
				<tr class="tr3">
					<td style="width: 120px; ">
						类别:
					</td>
					<td>
						<html:select property="category.id" style="width: 200px; ">
							<html:optionsCollection name="categoryList" label="name"
								value="id" />
						</html:select>
					</td>
				</tr>
				<tr class="tr3">
					<td style="width: 120px; ">
						名称:
					</td>
					<td>
						<html:text property="board.name" style="width: 200px; "></html:text>
					</td>
				</tr>
				<tr class="tr3">
					<td style="width: 120px; ">
						描述:
					</td>
					<td>
						<html:textarea property="board.description"
							style="width: 200px; height: 50px; "></html:textarea>
					</td>
				</tr>

				<tr class="tr3">
					<td colspan="2">
						<html:submit styleClass="btn" value="添加" />
					</td>
				</tr>

			</table>
		</div>
	</html:form>
</div>

<jsp:include flush="true" page="../footer.jsp" />
