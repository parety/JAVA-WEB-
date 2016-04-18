<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>

<tiles:insert page="/template2.jsp" flush="true">

	<tiles:put name="title" value="读书频道 - 红楼梦"></tiles:put>
	
	<tiles:put name="header">
		<a href="login.do">登录</a> | <a href="register.do">注册</a> | <a href="about.do">关于</a> | <a href="contact.do">联系我们</a>
	</tiles:put>
	
	<tiles:putList name="menus">
		<tiles:add><div id="selected"><a href="">新闻</a></div></tiles:add>
		<tiles:add><div><a href="">资源</a></div></tiles:add>
		<tiles:add><div><a href="">常见问题</a></div></tiles:add>
		<tiles:add><div><a href="">下载</a></div></tiles:add>
		<tiles:add><div><a href="">反馈</a></div></tiles:add>
	</tiles:putList>
	
	<tiles:put name="main">
		连载 > 小说总馆 > 古典小说 > 红楼梦 <br/><br/>
		&nbsp;&nbsp;&nbsp;&nbsp;《红楼梦》，又称《石头记》，被认为是中国最具文学成就的古典小说，是中国长篇小说创作的巅峰之作。本书第一章中说这个故事真正作者已不可考，而由曹雪芹传抄、批阅及增删数次而成，但经过学者的索隐考证后，认为曹雪芹就是本书真正的作者。　
	</tiles:put>
	
	<tiles:put name="copyright" value="/WEB-INF/classes/copyright.txt"></tiles:put>
	
</tiles:insert>

