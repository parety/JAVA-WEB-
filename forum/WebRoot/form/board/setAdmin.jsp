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
					<strong class="fl w">设置版主</strong> &nbsp;
					<span style="color: red; font-weight: bold; ">${
						exception.message }</span>
				</th>
			</tr>
		</table>
	</div>


	<html:form action="/board">
		<html:hidden property="action" value="setAdmin" />
		<html:hidden property="board.id" value="${ board.id }" />

		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout:fixed;border-top:0">
				<tr class="tr3">
					<td style="width: 120px; ">
						版面名称:
					</td>
					<td>
						${ board.name } &nbsp;
					</td>
				</tr>
				<tr class="tr3">
					<td style="width: 120px; ">
						版面描述:
					</td>
					<td>
						${ board.description } &nbsp;
					</td>
				</tr>
				<tr class="tr3">
					<td style="width: 120px; ">
						版主:
					</td>
					<td>
						<c:forEach items="${ personList }" var="person">
							<html:multibox property="adminId" value="${ person.id }" />${ person.account }
						</c:forEach>
					</td>
				</tr>

				<tr class="tr3">
					<td colspan="2">
						<html:submit styleClass="btn" value="保存" />
					</td>
				</tr>

			</table>
		</div>
	</html:form>
</div>

<jsp:include flush="true" page="../footer.jsp" />
