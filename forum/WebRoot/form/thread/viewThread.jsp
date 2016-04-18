<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>

<jsp:include flush="true" page="../header.jsp"></jsp:include>

<div id="main">
	<div class="t3">
		<table cellspacing="0" cellpadding="0" width="100%" align="center">
			<tr>
				<td style="text-align: left;">
					<img src="images/yellow/index/home.gif" align="absbottom" />
					<b> <a
						href="<html:rewrite action="/category?action=list" />&category.id=${ board.category.id }">${
							board.category.name }</a> &raquo; <a
						href="<html:rewrite action="/board?action=list" />&board.id=${ board.id }">${
							board.name }</a> </b>
				</td>
			</tr>
		</table>
	</div>

	<div class="t3">
		<table width="100%" align="center" cellspacing="0" cellpadding="0">
			<tr>
				<td align="left">
					<div class="fl">
						<div class="pages">
							${ pagination }
						</div>
					</div>
				</td>
				<td align="right" style="padding-bottom:.2em">
					<a
						href="<html:rewrite action="/reply?action=initAdd" />&thread.id=${ thread.id }"><img
							src="images/yellow/reply.png" /> </a>
					<a
						href="<html:rewrite action="/thread?action=initAdd" />&board.id=${ board.id }"
						style="margin-left:.5em"><img src="images/yellow/post.png"
							id="td_post" /> </a>
				</td>
			</tr>
		</table>
	</div>

	<!-- Thread Start -->
	<div class="t" style="margin-bottom:0px; border-bottom:0">
		<table cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<th class="h">
					<strong class="fl w"><b>本页主题:</b> ${ thread.title }</strong>
				</th>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr class="tr2">
				<td colspan="2" class="tar">
					<br />
				</td>
			</tr>
			<tr>
				<td></td>
			</tr>
		</table>
	</div>

	<c:if test="${ pagination.pageNum == 1 }">
		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout:fixed;border-top:0">
				<tr class="tr1">
					<th style="width:20%" rowspan="2" class="r_two">
						<b>作者：${ thread.author.account }</b>
						<div class="user-pic">
							<table style="border:0">
								<tr>
									<td width="1">

										<a href="profile-htm-action-show-uid-281652.html"
											target="_blank" style="cursor:pointer;"><img class="pic"
												src="http://img1.phpwind.net/attachout/upload/281652.gif"
												width="100" height="100" border="0" /> </a>
									</td>
								</tr>
							</table>
						</div>

					</th>
					<th height="100%" class="r_one" valign="top" id="td_4900235"
						style="padding:5px 15px 0 15px; border:0;width:80%; overflow:hidden">
						<div class="tiptop">
							<span class="fr" style="margin:0 0 0 1em"><a
								style="cursor:pointer" onclick="fontsize('small','4900235')">小</a>
								<a style="cursor:pointer" onclick="fontsize('middle','4900235')">中</a>
								<a style="cursor:pointer" onclick="fontsize('big','4900235')">大</a>
							</span>
							<span class="fl" style="white-space:nowrap;"> 引用 推荐 编辑 只看
							</span>
							<div class="c"></div>
						</div>
						<h1 id="subject_4900235" class="fl">
							&nbsp;
						</h1>

						<div id="p_4900235" class="c"></div>

						<div class="tpc_content" id="read_4900235">
							${ thread.content }
						</div>
					</th>
				</tr>
				<tr class="tr1 r_one">
					<th style="vertical-align:bottom;padding-left:15px;border:0">

						<div id="w_4900235" class="c"></div>

						<div class="tipad">
							<span style="float:right"> <a
								href="javascript:scroll(0,0)" title="顶端">顶端</a> </span>
							<span class="gray">Posted: ${ thread.dateCreated } |</span>
							<span><a class="s3">原帖</a> </span>
						</div>
					</th>
				</tr>
			</table>
		</div>
	</c:if>

	<!-- Thread End -->

	<!-- Reply Start -->

	<c:forEach var="reply" items="${ replyList }">
		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout:fixed;border-top:0">
				<tr class="tr1">
					<th style="width:20%" rowspan="2" class="r_two">
						<b>作者：${ reply.author.account }</b>
						<div class="user-pic">
							<table style="border:0">
								<tr>
									<td width="1">

										<a href="profile-htm-action-show-uid-281652.html"
											target="_blank" style="cursor:pointer;"><img class="pic"
												src="http://img1.phpwind.net/attachout/upload/281652.gif"
												width="100" height="100" border="0" /> </a>
									</td>
								</tr>
							</table>
						</div>

					</th>
					<th height="100%" class="r_one" valign="top" id="td_4900235"
						style="padding:5px 15px 0 15px; border:0;width:80%; overflow:hidden">
						<div class="tiptop">
							<span class="fr" style="margin:0 0 0 1em"><a
								style="cursor:pointer" onclick="fontsize('small','4900235')">小</a>
								<a style="cursor:pointer" onclick="fontsize('middle','4900235')">中</a>
								<a style="cursor:pointer" onclick="fontsize('big','4900235')">大</a>
							</span>
							<span class="fl" style="white-space:nowrap;"> 引用 推荐 编辑 只看
							</span>
							<div class="c"></div>
						</div>
						<h1 id="subject_4900235" class="fl">
							&nbsp;
						</h1>

						<div id="p_4900235" class="c"></div>

						<div class="tpc_content" id="read_4900235">
							${ reply.content }
						</div>
					</th>
				</tr>
				<tr class="tr1 r_one">
					<th style="vertical-align:bottom;padding-left:15px;border:0">

						<div id="w_4900235" class="c"></div>

						<div class="tipad">
							<span style="float:right"> <a
								href="javascript:scroll(0,0)" title="顶端">顶端</a> </span>
							<span class="gray">Posted: ${ reply.dateCreated }|</span>
							<span><a class="s3">${ reply.floor } 楼</a> </span>
						</div>
					</th>
				</tr>
			</table>
		</div>
	</c:forEach>


	<div class="t3">
		<table width="100%" align="center" cellspacing="0" cellpadding="0">
			<tr>
				<td align="left">
					<div class="fl">
						<div class="pages">
							${ pagination }
						</div>
					</div>
				</td>
				<td align="right" style="padding-bottom:.2em">
					<a
						href="<html:rewrite action="/reply?action=initAdd" />&thread.id=${ thread.id }"><img
							src="images/yellow/reply.png" /> </a>
					<a
						href="<html:rewrite action="/thread?action=initAdd" />&board.id=${ board.id }"
						style="margin-left:.5em"><img src="images/yellow/post.png"
							id="td_post" /> </a>
				</td>
			</tr>
		</table>
	</div>
</div>
<!-- Reply End -->

<jsp:include flush="true" page="../footer.jsp" />
