<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>

<jsp:include flush="true" page="../header.jsp"></jsp:include>

<!-- TinyMCE -->
<script type="text/javascript" src="tiny_mce/tiny_mce.js"></script>
<script type="text/javascript">
	tinyMCE.init({
		// General options
		mode : "textareas",
		theme : "advanced",
		plugins : "safari,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template",
		theme_advanced_toolbar_location : "top",
		theme_advanced_toolbar_align : "left",
		theme_advanced_statusbar_location : "bottom",
		theme_advanced_resizing : true,
		// Example content CSS (should be your site CSS)
		content_css : "css/content.css",

		// Drop lists for link/image/media/template dialogs
		template_external_list_url : "lists/template_list.js",
		external_link_list_url : "lists/link_list.js",
		external_image_list_url : "lists/image_list.js",
		media_external_list_url : "lists/media_list.js",

		// Theme options
		theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
		theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
		theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
		theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak",

		// Replace values for the template plugin
		template_replace_values : {
			username : "Some User",
			staffid : "991234"
		}
	});
</script>

<div id="main">

	<div class="t3">
		<table cellspacing="0" cellpadding="0" width="100%" align="center">
			<tr>
				<td style="padding-top: 12px;text-align: left;">
					<img src="images/yellow/index/home.gif" align="absbottom" />
					<b> <a
						href="<html:rewrite action="/category?action=list" />&category.id=${ board.category.id }">${
							board.category.name }</a> &raquo; <a
						href="<html:rewrite action="/board?action=list" />&board.id=${ board.id }">${
							board.name }</a> &raquo; 回复 <a
						href="<html:rewrite action="thread?action=list" />&thread.id=${ thread.id }">${
							thread.title }</a> </b>
				</td>
			</tr>
		</table>
		<br />
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
					<strong class="fl w"><b>回复主题:</b> ${ thread.title }</strong>
				</th>
			</tr>
		</table>
	</div>

	<html:form action="/reply">
		<html:hidden property="action" value="add" />
		<html:hidden property="thread.id" value="${ thread.id }" />
		<html:hidden property="reply.title" value="Re: ${ thread.title }" />
		<div class="t t2">
			<table cellspacing="0" cellpadding="0" width="100%"
				style="table-layout:fixed;border-top:0">
				<tr class="tr1">
					<th style="width:20%" class="r_two" style="text-align: right">
						原帖主题
					</th>
					<th height="100%" class="r_one" valign="top" id="td_4900235"
						style="padding:5px 15px 0 15px; border:0;width:80%; overflow:hidden">
						${ thread.title }
					</th>
				</tr>
				<tr class="tr1 r_one">
					<th style="width:20%" class="r_two" style="text-align: right">
						回复内容
					</th>
					<th style="vertical-align:bottom;padding-left:15px;border:0">
						<html:textarea property="reply.content"
							style="width: 500px; height: 200px; "></html:textarea>
						<br />
						<br />
						<html:submit value="提交" styleClass="btn"></html:submit>
					</th>
				</tr>
			</table>
		</div>
	</html:form>
</div>

<jsp:include flush="true" page="../footer.jsp" />
