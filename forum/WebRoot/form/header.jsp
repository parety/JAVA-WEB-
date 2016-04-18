<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>
	
<%
	Enumeration enumeration = request.getAttributeNames();
	
	while(enumeration.hasMoreElements()){
		String name = (String) enumeration.nextElement();
		Object obj = request.getAttribute(name);
		System.out.println("request[\"" + name + "\"]: " + obj);
	}
	
%>	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
		<title>${ requestScope[requestScope['org.apache.struts.action.mapping.instance'].attribute].title }</title>
		<style type="text/css">
body{font-family:Tahoma;font-size:12px;background:#e1d5aa url(images/yellow/bg1.jpg) top center repeat-y; margin:auto;}
h1,h2,h3,h4,h5,h6,form,body{padding:0;margin:0}
td,th,div{word-break:break-all;word-wrap:break-word}
table{empty-cells:show;}
img{border:0}
h1{font-size:16px;margin:.5em 1em 1em 0}
h3,h2{display:inline;font-size:1.0em;}
h3{font-weight:normal}
h2 a,h3 a{color:#000}
h4{margin:20px 0 10px;font-size:1.1em}
textarea,input,select{font:12px Arial;padding:1px 3px 0 3px;vertical-align:middle;margin-bottom:1px}
.c{clear:both;height:0;font:0/0 Arial;}
.b{font-weight:bold}
.tal{text-align:left}
.tac{text-align:center}
.tar{text-align:right}
.fr{float:right}
.fl{float:left}
/*a link 基本连接颜色*/
a{text-decoration:none;color:#96465d}
a:hover{text-decoration:underline;}
.abtn{cursor:pointer;border:1px solid #c7b985;color:#96465d;padding:2px 8px;margin-left:2px;height:30px}
/*字体大小*/
.f9{font-size:11px;}
.f10{font-size:11px;}
.f12{font-size:12px}
.f14{font-size:14px}
.fn,.fn a{font-weight:normal}
/*span color 数值自定义*/
.s1{color:#008000;}
.s2{color:#984B98;}
.s3{color:#FA891B;}
.s4{color:#0033FF;}
.s5{color:#659B28}
.gray{color:#818a89} /*次要文字颜色-可定义*/
/*main color 数值自定义*/
.f_one,.t_one,.r_one{background:#ffffff;}
.f_two,.t_two,.r_two{background:#fbf8e9;}
/*form*/
textarea,input,select{font:12px Arial;padding:1px 3px 0 3px;vertical-align:middle;margin-bottom:1px}
select{border:solid 1px #e1d5aa;}
.btn{background:#c7b985 url(images/yellow/bg.png) 0 -200px repeat-x;color:#000000;border-width:1px;padding-left:15px;padding-right:15px;vertical-align:middle}
.input{border:solid 1px #c7b985;padding:2px 0px 2px 1px;font-size:1.0em;vertical-align:middle}
form{display:inline;}
textarea{border:solid 1px #c7b985;}
/*header*/
#header{width:940px;margin:auto; background:url(images/yellow/headerbg.png) 0 0 repeat-x;}
/*toolbar*/
.toptool{background:url(images/yellow/bg.png) 0 0 repeat-x;color:#ffffff; padding-top:5px;}
.toptool span{padding:1px 5px;line-height:150%;}
.toptool span a{color:#ffffff;}
/*index info*/
#infobox{ border:#c7b985 1px solid; margin-top:-.8em;background:#c7b985 url(images/yellow/bg.png) 0 bottom repeat-x; }
#notice{ margin:0 -.3em; height:20px}
#notice a{ color:#fff; padding-left:1em; background:url(images/yellow/dotB.png) no-repeat 0 .1em; margin-left:1.5em}
/*banner*/
.banner img{vertical-align:middle;}
/*guide*/
.guide{background:#F3F8EF url(images/yellow/bg.png) 0 -100px repeat-x; padding:.5em;color:#ccc}
.guide a{color:#ccc;}
/*table*/
.t{border:1px solid #c7b985;margin:0px auto 8px;}
.t table{border:1px solid #fff;margin:0 auto;width:99.98%;}
.t2{border-top:#c7b985 1px solid;margin:0px auto 5px;}
.t3{margin:auto}
.t4{padding:1px 0 1px 1px}
/*table head*/
.h{border-bottom:1px solid #f9c100;background:#E0F0F9 url(images/yellow/bg.png) 0 -200px repeat-x;text-align:left;color:#000000;padding:.3em .4em}
.h span{font-weight:normal;}
.h h2{font-weight:bold}
.h a{font-family:Arial;color:#000000}
.h span a,.h span{color:#5495A0;}
.h a.a2{margin-left:12px;}
/*table tr1*/
.tr1 th{padding:5px 10px;text-align:left;vertical-align:top;font-weight:normal;}
.tr1 td.td1{border:1px solid #e1d5aa;}
/*table tr2*/
.tr2{background:#F3F8EF url(images/yellow/bg.png) 0 -300px repeat-x;color:#dc565e;}
.tr2 td,.tr2 th{line-height:18px;border-bottom:1px solid #c7b985;padding:2px 6px 0px;/*border-top:1px solid #c7b985;*/}
.tr2 a{color:#dc565e;margin:2px 2px 0}
/*table tr3*/
.tr3 td,.tr3 th{border-bottom:1px solid #e1d5aa;padding:.3em .6em}
.tr3 th{text-align:left;font-weight:normal;}
.tr4{background:#E0F0F9 url(images/yellow/bg.png) 0 -200px repeat-x;color:#000000;}
.tr4 td{padding:4px 10px;}
.tr td,.tr th{padding:2px}
/*topic content tips*/
.tpc_content{font-size:14px;font-family:Arial;padding:0 2% 0 0.5%;margin:0 0 2%}
.tips{background:#fbf8e9;border:#e1d5aa 1px solid;padding:5px;margin:0 1% 1% 0;float:left;text-align:center;}
.tiptop{border-bottom:1px solid #e1d5aa;padding:0 0 5px 0;vertical-align:middle;}
.tipad{border-top:1px solid #e1d5aa;margin:10px 0 0;padding:5px 0 0;}
.quote{width:80%;font-size:70%;color:#000000;margin:8px 2px 2px;padding:0}
blockquote{width:80%;font-size:85%;color:#81888c;border:1px solid #e1d5aa;border-left-width:3px;padding:5px;margin:0 0 1%}
/*menu*/
.menu{position:absolute;background:#fff;border:1px solid #c7b985;}
.menu td, .menu li,.menu ul{background:#fff;padding:0; margin:0}
.menu li{list-style:none;}
.menu a{display:block;padding:3px 15px 3px 15px;background:#fff;}
.menu a:hover{background:#96465d;text-decoration:none;color:#fff;}
.menu ul.ul1 li a{display:inline;padding:0}
/*pages*/
.pages{margin:3px 0;font:11px/12px Tahoma}
.pages *{vertical-align:middle;}
.pages a{padding:1px 4px 1px;border:1px solid #c7b985;margin:0 1px 0 0;text-align:center;text-decoration:none;font:normal 12px/14px verdana;}
.pages a:hover{border:#dc565e 1px solid;background:#F3F8EF;text-decoration:none;color:#000000}
.pages input{margin-bottom:0px;border:1px solid #dc565e;height:15px;font:bold 12px/15px Verdana;padding-bottom:1px;padding-left:1px;margin-right:1px;color:#dc565e;}
/*footer*/
#footer{width:940px;text-align:right;border-top:2px solid #f9c100;margin:auto;padding:5px 0; background:#ffffff}
#main{width:940px;margin: auto; padding:.8em 0 0; background:#ffffff}
.button {font-size: 12px; }
 /*自定义css*/
</style>
		<!--css-->

		<style type="text/css">/*竖线风格输出*/
.tr3 td,.tr3 th{border-right:1px solid #e1d5aa;}
.y-style{text-align:center;}
.t table{border:0;width:100%;}
.tr1 th{border-right:1px solid #e1d5aa;}
.tr1 td.td1{border-left:0}
.t{padding:1px}
</style>
	</head>
	<body>
		<div id="wrapA">
			<div id="header">
				<div class="toptool tar">
					<span><a href="<html:rewrite page="" />">Home首页</a> | <a
						href="<html:rewrite page="" />">论坛首页</a> </span>
				</div>
				<table cellspacing="0" cellpadding="0" align="center" width="100%">
					<tr>
						<td class="banner">
							<a href="./"><img src="images/yellow/logo.png" /> </a>
						</td>
						<td class="banner" id="banner" align="right">
							<img src="images/yellow/banner.gif">
						</td>
					</tr>
					<tr>
						<td align="center" height="1" colspan="2"></td>
					</tr>
				</table>
				<div id="h_guide" class="guide" colspan="2">
					<span class="s3">&raquo;</span>

					<c:choose>
						<c:when test="${ personInfo == null }">
							您尚未&nbsp;
							<a href="<html:rewrite action="/person?action=initLogin" />">登录</a> |
							<a href="<html:rewrite action="/person?action=initAdd" />">注册</a>
						</c:when>
						<c:otherwise>
							欢迎您, <a
								href="<html:rewrite action="/person?action=view" />&person.id=${ personInfo.id }">${
								personInfo.account }</a> | <a
								href="<html:rewrite action="/person?action=logout" />">注销</a>
						</c:otherwise>
					</c:choose>

				</div>
			</div>
			<div id="main">
				<div style="margin-top:7px;"></div>
				<div id="content">