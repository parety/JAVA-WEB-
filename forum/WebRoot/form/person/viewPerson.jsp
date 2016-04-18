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
					<strong class="fl w">查看用户资料</strong> &nbsp;
					<span style="color: red; font-weight: bold; ">${ message }</span>
				</th>
			</tr>
		</table>
	</div>

	<html:form action="/person">
		<html:hidden property="action" value="add" />
		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout:fixed;border-top:0">


				<tr class="tr3">
					<td style="width: 120px; ">
						帐号:
					</td>
					<td>
						${ person.account }
					</td>
				</tr>
				<tr class="tr3">
					<td>
						姓名:
					</td>
					<td>
						${ person.name } &nbsp;
					</td>
				</tr>
				<tr class="tr3">
					<td>
						性别:
					</td>
					<td>
						${ person.sex } &nbsp;
					</td>
				</tr>
				<tr class="tr3">
					<td>
						电子邮件:
					</td>
					<td>
						${ person.email } &nbsp;
					</td>
				</tr>
				<tr class="tr3">
					<td>
						生日:
					</td>
					<td>
						${ person.birthday } &nbsp;
					</td>
				</tr>
				<tr class="tr3">
					<td>
						注册时间:
					</td>
					<td>
						${ person.dateCreated } &nbsp;
					</td>
				</tr>
				<tr class="tr3">
					<td>
						上次登录时间:
					</td>
					<td>
						${ person.dateLastActived } &nbsp;
					</td>
				</tr>
				<tr class="tr3">
					<td>
						负责的版面:
					</td>
					<td>
						<c:forEach items="${ person.boardsAdministrated }" var="board">
							<a
								href="<html:rewrite action="/board?action=list" />&board.id=${ board.id }">${
								board.name }</a>
						</c:forEach>
						&nbsp;
					</td>
				</tr>
			</table>
		</div>
	</html:form>


	<jsp:include flush="true" page="../footer.jsp" />