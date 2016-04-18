<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Java Web 源代码</title>
		<style type="text/css">
			body, td, div, a {font-size: 12px; }
			body {margin: 0px; }
			a {
				padding-left: 10px; 
				width: 100%; 
				line-height: 22px; 
			}
			a:link {
				padding-left: 10px; 
				width: 100%; 
			}
			a:hover {
				background: yellow; 
			}
			a:active {
				background: yellow; 
			}
			ul {
				padding-left: 0px; 
				margin: 0px; 
			}
			li {
			}
			.title {
				font-weight: bold; 
				font-size: 14px; 
				text-align: center; 
				line-height: 25px; 
			}
			.header {
				font-weight: bold; 
				font-size: 12px; 
				text-align: center; 
				padding-top: 3px; 
				padding-bottom: 3px; 
				background: #E98F9D; 
				margin-top: 20px; 
				list-style: none; 
			}
			#table {
				width: 100%; 
				overflow: hidden; 
			}
			#leftTD {
				width: 200px; 
				background: #FFFFFF;
			}
			#leftDIV {
				width: 100%; 
				height: 100%; 
				overflow: scroll; 
			}
			.tool-tip {
				color: #fff;
				width: 300px;
				z-index: 13000;
			}
			
			.forTomcat {
			}
			.forJBoss {
				display: none; 
			}
			
		</style>

		<link rel="stylesheet" type="text/css" href="style.css" />

		<script type="text/javascript" src="mootools.svn.js"></script>

		<script type="text/javascript">
		function init(){
			var left = document.getElementById('table');
			left.style.height = (document.body.clientHeight) + 'px'; 
			// left.style.height = '500px'; 
		}
		window.addEvent('domready', function(){
			var imageTips = new Tips($$('.tips'), {
				showDelay: 100,
				hideDelay: 100
				// fixed: true, 
				// offsets: {'x': 16, 'y': 16}
			});
			
			new Tips($$('.header1'), {
				showDelay: 100,
				hideDelay: 100,
				fixed: true
			});
		}); 
	
		</script>

		<base target="mainFrame">
	</head>
	<body onload="init(); ">

		<table id="table" border="1" width="100%">
			<tr>
				<td id="leftTD">
					<div id="leftDIV">

						<div class="title">
							运行源代码
						</div>

						<ul class="forTomcat">
							<li class="header" title="">
								第二章 第一个Web应用
							</li>
							<li>
								<a class="tips" href="/firstWeb/servlet/HelloServlet"
									title="第一个web应用  :: 输入名字提交表单，Servlet会获取用户输入的名字，并在浏览器中显示出来">第一个web应用</a>
							</li>

							<li class="header" title="">
								第三章 Servlet
							</li>
							<li>
								<a class="tips" href="/servlet/servlet/FirstServlet"
									title="第一个Servlet :: 分别以GET、POST方式提交参数值，注意GET、POST方式提交数据的URL格式">第一个Servlet</a>

							</li>
							<li>
								<a class="tips" href="/servlet/servlet/RequestServlet"
									title="从 request 中获取参数:: 本程序将获取Request中的各种参数，包括IP地址等等。点击页面中的刷新，reffer参数将发生变化。">从
									request 中获取参数</a>
							</li>
							<li>
								<a class="tips" href="/servlet/imageServlet.jsp"
									title="监控 response :: 实现防盗链的功能。当站内页面访问图片时，正常显示。如果直接输入图片网址访问，则显示错误图片。">监控
									response</a>
							</li>
							<li>
								<a class="tips" href="/servlet/identity.html"
									title="生成图片验证码 :: 使用 Servlet 输出图片验证码。验证码为随机字符串，并散布随机数量、随机颜色的噪点。">生成图片验证码</a>
							</li>
							<li>
								<a class="tips" href="/servlet/servlet/InitParamServlet"
									title="初始化参数 :: 输入用户名、密码后可以查看保密的协议。用户名、密码以初始化参数的形式配置在 Servlet 初始化参数中">初始化参数</a>
							</li>
							<li>
								<a class="tips" href="/servlet/servlet/ContextParamServlet"
									title="上下文参数 :: 上传文件夹、允许上传的文件类型保存在 Context 上下文参数中。本例将获取参数并显示。">上下文参数</a>
							</li>
							<li>
								<a class="tips" href="/servlet/servlet/InjectionServlet"
									title="资源注射 :: 字符串、数字、数组都可以通过注射到 Servlet 中。本例用 Servlet 显示被注射的资源。">资源注射</a>
							</li>
							<li>
								<a class="tips" href="/servlet/search.html"
									title="Yahoo搜索 :: 本例实现了一个 Yahoo 搜索引擎，利用GET方式提交查询内容，通过 Yahoo 提供的 WebService 实现对互联网的内容的搜索。可以搜索新闻、网页、图片、视频等。<div><br/>注意：使用该功能时必须保证电脑能上网。</div>">Yahoo
									搜索</a>
							</li>
							<li>
								<a class="tips" href="/servlet/postPersonalInformation.html"
									title="POST方式提交数据 :: 用 POST 方式提交数据，然后在Servlet中获取数据。">POST方式提交数据</a>
							</li>
							<li>
								<a class="tips" href="/servlet/upload.html"
									title="上传文件 :: 使用 Apache commons-upload 处理文件上传。<br />请选择两个文件，然后点上传。">上传文件</a>
							</li>
							<li>
								<a class="tips"
									title="进度条上传文件 :: 用 AJAX 技术实时显示上传进度。AJAX 会从服务器获取保存在 Session 中的上传进度，然后以进度条的形式显示出来，并在页面上打印进度数据。"
									href="/servlet/progressUpload.jsp">进度条上传文件</a>
							</li>
							<li>
								<a class="tips"
									title="生命周期: 计算个人所得税 :: 本例使用 Servlet 计算个人所得税。本例在 Servlet 生命周期开始的时候也就是 init() 方法加载个税起征点。"
									href="/servlet/servlet/LifeCycleServlet">生命周期: 计算个人所得税</a>
							</li>
							<li>
								<a class="tips"
									title="跳转 Forward :: 本例演示 Forward 功能，包括 Forward 到另一个 Servlet、跳转到任意的文件（本例为web.xml）、跳转到JSP。跳转前可以在 request 中存储 Java 对象，跳转后再从 request 中取出来。"
									href="/servlet/servlet/ForwardServlet?destination=jsp">跳转
									Forward</a>
							</li>
							<li>
								<a class="tips"
									title="重定向 Redirect :: 本例演示 Redirect 功能。Redirect 时，Servlet 只是向浏览器发送重定向的命令，实际是在浏览器端实现的。本例在重定向前统计文件的下载次数。"
									href="/servlet/servlet/RedirectServlet">重定向 Redirect</a>
							</li>



							<li class="header">
								第四章 JSP
							</li>
							<li>
								<a class="tips" title="第一个 JSP :: JSP 中根据时间的不同，显示不同的提示信息。"
									href="/jsp/greeting.jsp">第一个JSP</a>
							</li>
							<li>
								<a class="tips"
									title="Scriptlet 脚本 :: 在 JSP 中使用 Scriptlet 脚本，也就是普通的 Java 代码计算 10! 的阶乘，并输出计算过程。"
									href="/jsp/scriptlet.jsp">Scriptlet脚本</a>
							</li>
							<li>
								<a class="tips"
									title="JSP Method :: 本例在 JSP 中定义了几个方法，查询 IP 地址对应的物理地址。查询时用到了 QQ 等的 IP 数据库。"
									href="/jsp/method.jsp">JSP Method查询IP</a>
							</li>
							<li>
								<a class="tips"
									title="if 条件语句 :: JSP 中使用 if 对参数做判断。当地址栏参数 param 为1、2、3时，分别显示不同的诗词。"
									href="/jsp/if.jsp">if 条件语句</a>
							</li>
							<li>
								<a class="tips"
									title="for 循环 :: JSP 中使用 for 循环对 List 对象进行遍历，模拟输出多个邮件信息。"
									href="/jsp/for.jsp">for 循环</a>
							</li>
							<li>
								<a class="tips" title="while 循环 :: 用 while 循环输出 List 里的四句诗词。"
									href="/jsp/while.jsp">while 循环</a>
							</li>
							<li>
								<a class="tips"
									title="return 返回 :: 当地址栏参数 param 值为 return 时，JSP 中会执行 return，提前结束运行。"
									href="/jsp/return.jsp">return 返回</a>
							</li>
							<li>
								<a class="tips" title="break 跳出 :: 演示循环中的 break"
									href="/jsp/break.jsp">break 跳出</a>
							</li>
							<li>
								<a class="tips"
									title="include 包含 :: 用 include 命令在 JSP 中包含另两个 JSP 文件：头文件 与 尾文件"
									href="/jsp/include.jsp">include 包含</a>
							</li>
							<li>
								<a class="tips"
									title="UseBean 行为 :: 用 UseBean 命令操作 Java Bean，包括定义一个 Bean、读写 Bean 的属性。"
									href="/jsp/useBean.html">UseBean 行为</a>
							</li>
							<li>
								<a class="tips"
									title="作用域 :: 共有 4 种作用域，利用作用域的不同实现意义不同的计数器。本例演示 session 与 application 作用域，session 里的计数器统计个人的访问次数，application 里的计数器统计所有人的访问次数。"
									href="/jsp/counter.jsp">作用域</a>
							</li>
							<li>
								<a class="tips"
									title="plugin 行为 :: 利用 plugin 行为可方便的嵌入 Java Applet 等。本例嵌入了 Java JDK 中的一个演示 Applet。"
									href="/jsp/plugin.jsp">plugin 行为</a>
							</li>
							<!-- 
							<li>
								<a class="tips" title=" :: " href="/jsp/exception.jsp">error
									page</a>
							</li>
							<li>
								<a class="tips" title=" :: " href="/jsp/configuration">JSP
									配置</a>
							</li>
 -->


							<li class="header">
								第五章 会话追踪
							</li>
							<li>
								<a class="tips"
									title="Cookie :: 以任意用户名、密码登录，用户名以及访问次数会被记录到 Cookie 中。"
									href="/session/cookie.jsp">Cookie</a>
							</li>
							<li>
								<a class="tips"
									title="Cookie 编码 :: Cookie 中不能直接存储中文，要存储中文，需要对中文进行编码。"
									href="/session/encoding.jsp">Cookie 编码</a>
							</li>
							<li>
								<a class="tips"
									title="Base64 编码 :: 利用 Base64 编码对二进制数据编码后存储到 Cookie 中，在解码后取出来。页面上显示的小图标就是从 Cookie 中解码的。"
									href="/session/base64.jsp">Base64 编码</a>
							</li>
							<li>
								<a class="tips"
									title="设置 Cookie :: 设置 Cookie 的各种值。如果设置同名的 Cookie，提交后就修改 Cookie 值。如果设置 Cookie maxAge 为 0，则删除该 Cookie。"
									href="/session/setCookie.jsp">设置 Cookie</a>
							</li>
							<li>
								<a class="tips"
									title="JavaScript 读写 Cookie :: 本例演示用 JavaScript 读写 Cookie。效果与服务器端操作是一样的，而且 JavaScript 操作 Cookie 时不需要刷新页面。"
									href="/session/javascript.jsp">JavaScript 读写 Cookie</a>
							</li>
							<li>
								<a class="tips"
									title="Cookie 永久登录 :: 通过设置 maxAge 属性控制 Cookie 的有效期，实现永久登录。使用任意用户名、密码登录。"
									href="/session/loginCookie.jsp">Cookie 永久登录</a>
							</li>
							<li>
								<a class="tips"
									title="Session 实现的用户登录 :: 利用 session 实现登录，登陆信息保存在 session 中。如果 session 中没有登录信息，则认为没有登录。<br/><br/>用户名密码：Hello Kitty、hellokitty。"
									href="/session/welcome.jsp">Session 实现的用户登陆</a>
							</li>


							<li class="header">
								第六章 Filter
							</li>
							<li>
								<a class="tips"
									title="防盗链 Filter :: 如果图像是本站内页面引用，正常显示，否则显示错误图片。"
									href="/filter/image.jsp">防盗链 Filter</a>
							</li>
							<li>
								<a class="tips"
									title="字符编码 Filter :: 在 Filter 中对所有的 request、response 进行 UTF-8 编码，使之能够处理汉字信息。"
									href="/filter/characterEncoding.jsp">字符编码 Filter</a>
							</li>
							<li>
								<a class="tips"
									title="异常捕捉 Filter :: 用 Filter 捕捉异常，不同的异常跳转到不同的错误处理页面。本页演示抛出三种异常：业务异常、未登录异常、数据格式异常。"
									href="/filter/exceptionHandler.jsp">异常捕捉 Filter</a>
							</li>
							<li>
								<a class="tips"
									title="内容替换 Filter :: 对输出内容进行内容替换，例如将非法的内容替换成 **，将明显错误的 BIADU 自动更正为正确的 BAIDU。"
									href="/filter/replace.jsp">内容替换 Filter</a>
							</li>
							<li>
								<a class="tips"
									title="GZip 压缩 Filter :: 对输出的内容进行 GZip 压缩，以减小网络流量。本例测试了不同数据类型压缩前后的流量比例，并测试了Google、Baidu等网站的压缩比。"
									href="/filter/gzip.jsp">GZip 压缩 Filter</a>
							</li>
							<li>
								<a class="tips"
									title="水印 Filter :: 对输出的图像数据进行处理，打上网站的 LOGO 标志。该过程是动态完成的，不会损失原来的图片。"
									href="/filter/sunset.jpg">水印 Filter</a>
							</li>
							<li>
								<a class="tips"
									title="缓存 Filter :: 对网站内容进行缓存，以提高访问速度。缓存时只能使用 javascript 结合 cookie 进行权限判断。<br/><br/>本例演示了普通用户、管理员的登录，登陆后缓存的内容（即源代码）都是一样的，但是显示的操作菜单不同，原因是利用javascript在浏览器端做了处理。"
									href="/filter/cache.jsp">缓存 Filter</a>
							</li>
							<li>
								<a class="tips"
									title="XSLT 转化 Filter :: 本例使用 Filter 将 xml 格式的 MSN 聊天记录转化为了 HTML 文件。请查看生成的html源文件。"
									href="/filter/msn/demo.xml">XSLT 转化 Filter</a>
							</li>
							<li>
								<a class="tips"
									title="文件上传 Filter :: 对 request 进行处理，封装对上传文件的处理细节。如果有文件上传，则把文件保存到服务器中，然后放到 request 中，Servlet 直接从 request 引用即可。"
									href="/filter/upload.jsp">文件上传 Filter</a>
							</li>

							<li class="header">
								第七章 Listener
							</li>
							<li>
								<a class="tips"
									title="单态登录 :: 使用 Listener 实现单态登录，用任意帐号登录。请用两个新开的浏览器窗口测试。当同帐号在一侧登陆后，另一侧会自动掉线。<br/><br/>注意：两个浏览器窗口必须是新开的，而不能用'在新窗口打开'之类 "
									href="/listener/singleton.jsp">单态登录</a>
							</li>
							<li>
								<a class="tips"
									title="在线统计 :: 实现在线人数统计、记录服务器启动时间、最高访问人次、累计访问人次、最高在线人次等信息。<br/><br/>请结合上面的单态登录使用，模拟用户登录。"
									href="/listener/online.jsp">在线统计</a>
							</li>

							<li class="header">
								第八章 JSTL
							</li>
							<li>
								<a class="tips"
									title=" :: JSTL 获取地址栏参数，并输出。<br/><br/>本例的URL为：/jstl/out.jsp?action=这是JSTL输出的action参数"
									href="/jstl/out.jsp?action=这是JSTL输出的action参数">&lt;c:out
									/&gt;</a>
							</li>
							<li>
								<a class="tips"
									title=" :: 用 JSTL 的 if 判断 action 参数，如果为 add，则显示添加页面。<br/><br/>本例的URL为：/jstl/if.jsp?action=add"
									href="/jstl/if.jsp?action=add">&lt;c:if /&gt;</a>
							</li>
							<li>
								<a class="tips"
									title=" :: 用 JSTL 的 choose、when、otherwise 判断 action 参数，如果为字符串true，则输出when标签的内容。"
									href="/jstl/choose.jsp?action=true">&lt;c:choose /&gt;</a>
							</li>
							<li>
								<a class="tips"
									title=" :: 用 forEach 标签遍历 1-100 之间的所有偶数，并遍历 request 中的所有 header 信息。"
									href="/jstl/forEach.jsp">&lt;c:forEach /&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: forEach 遍历 list 对象，以表格的形式输出数据。"
									href="/jstl/forEachWithList.jsp">&lt;c:forEach /&gt;遍历List</a>
							</li>
							<li>
								<a class="tips"
									title=" :: forEach 遍历 Map 对象，这里遍历 request 中的所有 header 信息。"
									href="/jstl/forEach.jsp">&lt;c:forEach /&gt;遍历Map</a>
							</li>
							<li>
								<a class="tips"
									title=" :: 将字符串'Jane,Tomi,Andy,Hedrix,McCartney,Lenno,Court,Ben'以逗号作为分割符分成多个Token，并输出。这里只输出第奇数个Token。"
									href="/jstl/forTokens.jsp">&lt;c:forTokens /&gt;</a>
							</li>
							<li>
								<a class="tips"
									title=" :: 使用 set 标签设置 对象，并设置属性值。这里设置了作用域为session、application的两个计数器"
									href="/jstl/set.jsp">&lt;c:set /&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: 使用 remove 标签移除对象。"
									href="/jstl/remove.jsp">&lt;c:remove /&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: catch 标签捕捉异常。" href="/jstl/catch.jsp">&lt;c:catch
									/&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: import 标签导入网络上的资源。"
									href="/jstl/import.jsp">&lt;c:import /&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: url 标签对 URL 进行重写。"
									href="/jstl/url.jsp">&lt;c:url /&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: 重定向" href="/jstl/redirect.jsp">&lt;c:redirect
									/&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: 设置URL的参数，例如使用baidu查询某关键词"
									target="_blank" href="/jstl/param.jsp">&lt;c:param /&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: 对 request 进行编码"
									href="/jstl/requestEncoding.jsp">&lt;fmt:requestEncoding
									/&gt;</a>
							</li>
							<li>
								<a class="tips"
									title=" :: 设置用户所在地区。本例输出了所有时区的名称、使用语言、各种数据格式、货币符号等。"
									href="/jstl/setLocale.jsp">&lt;fmt:setLocale /&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: 设置用户所在时区。本例输出了所有时区的名称、此时此刻的时间等。"
									href="/jstl/timeZone.jsp">&lt;fmt:timeZone /&gt;</a>
							</li>
							<li>
								<a class="tips"
									title=" :: bundle 标签实现资源国际化，引用 properties 里的资源文件。"
									href="/jstl/bundle.jsp">&lt;fmt:bundle /&gt;</a>
							</li>
							<li>
								<a class="tips"
									title=" :: formatNumber 根据用户所在的地区文化习惯处理数字。本例列出了所有地区的数据格式。点击不同的时区，查看它们的数据格式。"
									href="/jstl/formatNumber.jsp">&lt;fmt:formatNumber /&gt;</a>
							</li>
							<li>
								<a class="tips"
									title=" :: 对于相同的数字字符串'1,000', 在中国地区调用 parseNumber 结果是1000，在欧洲地区调用 parseNumber 结果是1。"
									href="/jstl/parseNumber.jsp">&lt;fmt:parseNumber /&gt;</a>
							</li>
							<li>
								<a class="tips"
									title=" :: 列出了所有地区的时间格式。例如中国习惯的日期格式为yyyy-MM-dd，但美国人习惯的日期格式为dd/MM/yyyy。"
									href="/jstl/formatDate.jsp">&lt;fmt:formatDate /&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: 解析日期字符串，然后输出日期信息。"
									href="/jstl/parseDate.jsp">&lt;fmt:parseDate /&gt;</a>
							</li>
							<li>
								<a class="tips"
									title=" :: contains 方法，相当于 String 的 contains(). "
									href="/jstl/contains.jsp">&lt;fn:contains /&gt;</a>
							</li>
							<li>
								<a class="tips"
									title=" :: containsIgnoreCase 方法，相当于 String 的 containsIgnoreCase() "
									href="/jstl/containsIgnoreCase.jsp">&lt;fn:containsIgnoreCase
									/&gt;</a>
							</li>
							<li>
								<a class="tips"
									title=" :: contains 方法，相当于 String 的 contains(). "
									href="/jstl/endsWith.jsp">&lt;fn:endsWith /&gt;</a>
							</li>
							<li>
								<a class="tips"
									title=" :: escapeXml 方法，对一些字符例如 '&lt;' '&gt;' 进行 HTML 编码. "
									href="/jstl/escapeXml.jsp">&lt;fn:escapeXml /&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: indexOf 方法，相当于 String 的 indexOf(). "
									href="/jstl/indexOf.jsp">&lt;fn:indexOf /&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: 相当于 String 的 split() 方法"
									href="/jstl/split.jsp">&lt;fn:split /&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: 设置JDBC数据源"
									href="/jstl/setDataSource.jsp">&lt;sql:setDataSource /&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: 使用 SQL 查询数据库，并显示查询结果。"
									href="/jstl/query.jsp">&lt;sql:query /&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: 分页显示数据。"
									href="/jstl/queryPagination.jsp">&lt;sql:query /&gt; 分页显示</a>
							</li>
							<li>
								<a class="tips" title=" :: 动态的显示查询结果（列名、列数未知）"
									href="/jstl/queryReflect.jsp?sql=show+tables">&lt;sql:query
									/&gt; 列头</a>
							</li>
							<li>
								<a class="tips" title=" :: 执行 SQL DML，例如更新、删除、修改等等。"
									href="/jstl/update.jsp">&lt;sql:update /&gt;</a>
							</li>
							<li>
								<a class="tips"
									title=" :: 设置参数，相当于 PreparedStatement 的 setParameter() 方法"
									href="/jstl/dateParam.jsp">&lt;sql:dateParam /&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: 事务管理 " href="/jstl/transaction.jsp">&lt;sql:transaction
									/&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: 解析 xml 内容。" href="/jstl/parse.jsp">&lt;x:parse
									/&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: 输出 xml 某节点的内容" href="/jstl/x_out.jsp">&lt;x:out
									/&gt;</a>
							</li>
							<li>
								<a class="tips"
									title="x:forEach :: 输出多个节点内容。本例解析 sina 网的 rss 频道新闻信息，输出为标准的 HTML 格式。"
									href="/jstl/x_forEach.jsp">&lt;x:forEach /&gt;</a>
							</li>
							<li>
								<a class="tips" title=" :: 将 xml 文件转化为 html 格式并输出。"
									href="/jstl/x_transform.jsp">&lt;x:transform /&gt;</a>
							</li>

							<li class="header">
								第九章 自定义标签
							</li>
							<li>
								<a class="tips" title="版权标签 :: 输出版权信息，没有任何参数"
									href="/taglib/copyright.jsp">版权标签</a>
							</li>
							<li>
								<a class="tips" title="带参数的标签 :: 带参数的标签"
									href="/taglib/hello.jsp">带参数的标签</a>
							</li>
							<li>
								<a class="tips"
									title="带标签体的标签 :: 包含标签体，并能对标签体进行处理。本例将标签体内的字母都转化为小写。"
									href="/taglib/toLowerCase.jsp">带标签体的标签</a>
							</li>
							<li>
								<a class="tips" title="循环的标签 :: 循环输出阶梯型字符串。"
									href="/taglib/loop.jsp">循环的标签</a>
							</li>
							<li>
								<a class="tips"
									title="动态属性标签 :: 动态属性，数量、名称都是任意的。本例输出多只股票的价格，股票名称即属性名称。"
									href="/taglib/dynamic.jsp">动态属性标签</a>
							</li>
							<li>
								<a class="tips"
									title="嵌套的标签：Table标签 :: 这是一个稍微复杂的标签，实现了表格的功能。该表格支持表头排序、列宽度调整、列宽度记忆（通过cookie记录）、字符串过长则隐藏等功能。"
									href="/taglib/table.jsp">嵌套的标签：Table标签</a>
							</li>
							<li>
								<a class="tips"
									title="带标签体的2.x标签 :: 2.x 标签实现的带标签体的标签。本例将标签体内容变成了大写。"
									href="/taglib/toUpperCase.jsp">带标签体的2.x标签</a>
							</li>
							<li>
								<a class="tips"
									title="多个标签体的2.x标签 :: 带多个标签体时，可以任意的操作任意标签体。本例将标签体1输出5次，标签体2输出3次。"
									href="/taglib/multiAttribute.jsp">多个标签体的2.x标签</a>
							</li>
							<li>
								<a class="tips"
									title="自定义方法 :: 本例实现字符串的两个功能：计算字节数（而非字符数）、截取指定字节数的字符串。"
									href="/taglib/function.jsp">自定义方法</a>
							</li>

							<li class="header">
								第十章 资源国际化
							</li>
							<li>
								<a class="tips"
									title="所有的Locale :: 输出所有的 Locale，以及 Locale 的各个属性。"
									href="/i18n/locales.jsp">所有的Locale</a>
							</li>
							<li>
								<a class="tips"
									title="使用多个资源文件 :: 当前环境为中文时，系统会先到 *_cn_ZH.properties 文件取资源，如果没有，则到默认的 *.properties文件中取资源。"
									href="/i18n/resource.jsp">使用多个资源文件</a>
							</li>
							<li>
								<a class="tips" title="带参数的资源 :: 资源可以携带参数，用 {0}, {1} 等表示。"
									href="/i18n/param.jsp">带参数的资源</a>
							</li>
							<li>
								<a class="tips" title="所有Locale的数据格式 :: 输出了所有地区的数据格式"
									href="/i18n/setLocale.jsp">所有Locale的数据格式</a>
							</li>
							<li>
								<a class="tips" title="所有时区的时间 :: 输出了所有时区的时间"
									href="/i18n/timeZone.jsp">所有时区的时间</a>
							</li>

							<li class="header">
								第十一章 数据库
							</li>
							<li>
								<a class="tips" title="Derby 使用实例 :: 一个嵌入式的 derby web 程序。"
									href="/database/derby.jsp">Derby 使用实例</a>
							</li>

							<li class="header">
								第十二章 JDBC详解
							</li>
							<li>
								<a class="tips"
									title="人员列表 :: 基于 MySQL 与 JDBC 的人员信息 CRUD(Create/Read/Update/Delete) 操作。delete时可以同时删除多条信息"
									href="/database/listPerson.jsp">人员列表</a>
							</li>
							<li>
								<a class="tips" title="分页显示人员列表 :: 分页显示数据"
									href="/database/listPagedPerson.jsp">分页显示人员列表</a>
							</li>
							<li>
								<a class="tips" title="查询人员 :: 带复杂条件的查询，参数数量可以是任意的。"
									href="/database/searchPerson.jsp">查询人员</a>
							</li>
							<li>
								<a class="tips"
									title="获取 ResultSet 列头 :: 动态的获取 ResultSet 的列头。通过 MetaData 遍历未知列名、未知列数的 ResultSet 里的信息。 "
									href="/database/searchConsole.jsp?sql=show+variables">获取ResultSet列头</a>
							</li>
							<li>
								<a class="tips"
									title="部门、雇员列表 :: 带从属关系的例子。雇员中有一个部门属性，表现为数据库有外键关系，即雇员表中的 department_id 列对应部门表的主键。"
									href="/database/listEmployee.jsp">部门、雇员列表</a>
							</li>
							<li>
								<a class="tips"
									title="事务编程 :: 本例模拟银行转帐业务。一个业务分为两个动作：从A帐号扣款、往B帐号打款。只有当两个操作都成功时，才执行commit操作完成事务，否则执行rollback回滚，撤销所有操作，即使有的操作已经完成了。回滚后所有对数据库的修改操作均没有生效。"
									href="/database/listCurrency.jsp">事务编程</a>
							</li>
							<li>
								<a class="tips"
									title="存取二进制数据 :: 上传文件时，将文件以二进制数据流的形式存储到数据库中；下载文件时，再将文件从数据库中以流的形式读出来，返回给浏览器端。"
									href="/database/listBlob.jsp">存取二进制数据</a>
							</li>

							<li class="header">
								第十四章 Struts 1.x概述
							</li>
							<li>
								<a class="tips"
									title="第一个 Struts 程序 :: 提交用户信息、获取用户信息并显示。提交的数据由 Struts 自动获取并赋值。"
									href="/struts/hello.do">第一个 Struts 程序</a>
							</li>
							<li>
								<a class="tips" title="添加人员信息 :: 提交数据到数据库中。"
									href="/struts/person.do">添加人员信息</a>
							</li>
							<li>
								<a class="tips" title="人员信息列表 :: 列出提交的所有的人员信息。"
									href="/struts/person.do?action=list">人员信息列表</a>
							</li>

							<li class="header">
								第十五章 Struts 1.x高级应用
							</li>
							<li>
								<a class="tips" title="标签库 :: 常用的 Struts 标签库"
									href="/struts/tag.do">标签库</a>
							</li>
							<li>
								<a class="tips"
									title="Nested 标签库 :: 用 Nested 标签库直接把数据赋给 Java POJO 对象。填写上面的表单，提交后数据会自动填充到 person 属性中，下面的表单显示 person 属性值，也就是刚刚提交的数据。Struts 中没有做任何工作，所有任务都由 Tiles、Struts 自动完成。"
									href="/struts/tile.do?person.birthday=1992-12-12">Nested
									标签库</a>
							</li>
							<li>
								<a class="tips" title="Tiles 模板 :: Tiles 标签库提供 模板功能。"
									href="/struts/case1.jsp">Tiles 模板</a>
							</li>
							<li>
								<a class="tips" title="上传文件 :: 使用 Struts 提供的 FormFile 实现文件上传"
									href="/struts/upload.do">上传文件</a>
							</li>
							<li>
								<a class="tips"
									title="数据校验 :: 配置 Struts 的校验器，实现浏览器端的 Javascript 数据校验"
									href="/struts/validatorTest.do">数据校验</a>
							</li>
							<li>
								<a class="tips" title="动态属性 :: 继承的动态属性 Action"
									href="/struts/dynaTest.do?birthday=1990-12-12">动态属性</a>
							</li>

							<li class="header">
								第十六章 Struts 2.x概述
							</li>
							<li>
								<a class="tips"
									title="第一个Struts 2.x实例 :: Struts 2 实现的用户登录。帐号 helloween，密码 1234"
									href="/struts2/loginPerson.action?account=helloween&password=">第一个Struts
									2.x实例</a>
							</li>
							<li>
								<a class="tips"
									title="使用 POJO :: Struts 2 能把提交的数据自动封装为 POJO 对象。使用 struts 2 实现的图书管理系统。"
									href="/struts2/listBook.action">使用POJO</a>
							</li>

							<li class="header">
								第十七章 Struts 2.x高级应用
							</li>
							<li>
								<a class="tips"
									title="数据转换器 :: 自定义数据转换器，转化日期类型。使 struts 2 兼容常用的日期类型，例如yyyy-mm-dd, yyyy/mm/dd 等"
									href="/struts2/convertor.action?sqlDate=1992-12-12&sqlTime=12:00&utilDate=2008/08/08">数据转换器</a>
							</li>
							<li>
								<a class="tips" title="数据验证 :: 配置 Struts 2 的数据验证。"
									href="/struts2/addBook.action">数据验证</a>
							</li>

							<li class="header">
								第十八章 Struts 2.x标签
							</li>
							<li>
								<a class="tips"
									title="OGNL 脚本 :: 用 OGNL 操作各种对象，包括字符串、数字、POJO、类、类方法、集合等"
									href="/struts2/ognl.action?id=1&id=2&id=3">OGNL 脚本</a>
							</li>
							<li>
								<a class="tips" title="表单标签 :: Struts 2 的表单标签"
									href="/struts2/inputTag.jsp">表单标签</a>
							</li>
							<li>
								<a class="tips" title="Combo 标签 :: Struts 2 集成的 DOJO 的下拉框"
									href="/struts2/autocompleteTag.jsp">Combo 标签</a>
							</li>
							<li>
								<a class="tips"
									title="Combo 标签动态加载数据 :: 下拉框，数据使用 ajax 技术动态的从服务器读取"
									href="/struts2/autocompleteAjaxTag.jsp">Combo 标签动态加载数据</a>
							</li>
							<li>
								<a class="tips" title="组合框标签 :: 数据可以选择，也可以填写。"
									href="/struts2/comboboxTag.jsp">组合框标签</a>
							</li>
							<li>
								<a class="tips" title="日期选择器 :: 日期选择器"
									href="/struts2/datetimepickerTag.jsp">日期选择器</a>
							</li>
							<li>
								<a class="tips"
									title="联动选择框 ::  联动下拉框，第二个下拉框显示的内容由第一个下拉框的选择内容决定。只有北京、山东的演示数据。"
									href="/struts2/doubleselectTag.jsp">联动选择框</a>
							</li>
							<li>
								<a class="tips" title="选择域 :: 两个多选菜单，左右互动"
									href="/struts2/optiontransferselectTag.jsp">选择域</a>
							</li>
							<li>
								<a class="tips" title="选项组 :: 下拉框中对选项组进行分组"
									href="/struts2/optiongroupTag.jsp">选项组</a>
							</li>
							<li>
								<a class="tips" title="debug 标签 :: debug 标签，用于方便开发"
									href="/struts2/debugTag.jsp">debug 标签</a>
							</li>
							<li>
								<a class="tips" title="错误标签 :: 三种类型的错误显示标签"
									href="/struts2_annotated/error.action">错误标签</a>
							</li>
							<li>
								<a class="tips"
									title="div 标签 :: AJAX DIV 标签，每 1 秒钟刷新一次数据，输入“中国”用 AJAX 方式显示包含中国的新闻。"
									href="/struts2/div.jsp">div 标签</a>
							</li>
							<li>
								<a class="tips"
									title="DIV 标签执行JavaScript :: 用 AJAX 技术动态获取javascript脚本，并执行。<br/><br/>本例实现的是无页面刷新登录、注销功能。用户名 helloween，密码 1234"
									href="/struts2/divLogin.jsp">div 标签执行JavaScript</a>
							</li>
							<li>
								<a class="tips" title="标签页 :: 标签页功能。支持 AJAX 技术动态获取内容。"
									href="/struts2/tabbedPanelTag.jsp">标签页</a>
							</li>
							<li>
								<a class="tips" title="Tree 标签 ::Struts 2 的树标签。节点是硬编码的、固定的。"
									href="/struts2/treeTag.jsp">Tree 标签</a>
							</li>
							<li>
								<a class="tips" title="显示文件结构 :: 显示文件结构。节点是由目录结构决定的。"
									href="/struts2/treeFile.jsp">Tree 标签显示文件结构</a>
							</li>
							<li>
								<a class="tips" target="_blank"
									title="获取动态数据 :: 用 AJAX 技术动态获取数据，展开某节点时才获取子节点内容。获取数据时，图片会变成时钟状。适用于文件比较多的情况。"
									href="/struts2/treeFileAjax.jsp">Tree 标签获取动态数据</a>
							</li>

							<li class="header">
								第十九章 Struts 2.x拦截器与上传文件
							</li>
							<li>
								<a class="tips"
									title="token 拦截器 :: 防止重复提交数据。提交数据后右键->刷新，选择重复提交数据，该拦截器会阻止本次重复的提交。"
									href="/struts2/tokenInput.jsp">token 拦截器</a>
							</li>
							<li>
								<a class="tips"
									title="wait 拦截器 :: 业务繁忙时，显示等待页面。本例 Action 会耗时 10 秒钟，在此期间显示页面忙，10 秒钟后结束。"
									href="/struts2/wait.action">wait 拦截器</a>
							</li>
							<li>
								<a class="tips" title="上传文件 :: Struts 2 集成的文件上传功能。"
									href="/struts2/upload.jsp">上传文件</a>
							</li>

							<li class="header">
								第二十章 Hibernate概述
							</li>
							<li>
								<a class="tips"
									title="第一个Hibernate程序 :: 用 Hibernate 实现的 Cat 资料管理系统。本章其他实例都是以 java application 的形式运行的。"
									href="/hibernate/catServlet">第一个Hibernate程序</a>
							</li>

							<li class="header">
								第三十章 Spring的Web模块
							</li>
							<li>
								<a class="tips"
									title="继承方式整合 Struts 1.x :: Cat 管理系统，整合了 Spring、Struts1、Hibernate"
									href="/spring/cat.do">继承方式整合 Struts 1.x</a>
							</li>
							<li>
								<a class="tips"
									title="代理方式整合 Struts 1.x :: Cat 管理系统，整合了 Spring、Struts1、Hibernate"
									href="/spring/cat2.do">代理方式整合 Struts 1.x</a>
							</li>
							<li>
								<a class="tips"
									title="整合 Struts 2.x :: Cat 管理系统，整合了 Spring、Struts2、Hibernate"
									href="/spring/list_cat.action">整合 Struts 2.x</a>
							</li>

							<li class="header">
								第三十一章 Spring的MVC模块
							</li>
							<li>
								<a class="tips" title="继承AbstractController :: Spring 的 Action"
									href="/spring/cat.mvc">继承AbstractController</a>
							</li>
							<li>
								<a class="tips"
									title="继承MultiActionController :: 使用 action 参数自动执行同名的方法"
									href="/spring/catMulti.mvc">继承MultiActionController</a>
							</li>

							<li class="header">
								第三十七章 报表引擎 JFreeChart
							</li>
							<li>
								<a class="tips" title="饼状图 :: 用 Servlet 生成的饼状图"
									href="/chart/pie">饼状图</a>
							</li>
							<li>
								<a class="tips" title="折线图 :: 用 Servlet 生成的折线图"
									href="/chart/line">折线图</a>
							</li>
							<li>
								<a class="tips" title="3D柱状图 :: 用 Servlet 生成的3D柱状图"
									href="/chart/bar">3D柱状图</a>
							</li>
							<li>
								<a class="tips" title="柱形图 :: 用 Servlet 生成的柱形图"
									href="/chart/bar2">柱形图</a>
							</li>
							<li>
								<a class="tips" title="区域图 :: 用 Servlet 生成的区域图"
									href="/chart/area">区域图</a>
							</li>
							<li>
								<a class="tips" title="时序图 :: 用 Servlet 生成的时序图"
									href="/chart/time">时序图</a>
							</li>
							<li>
								<a class="tips" title="组合图表 :: 用 Servlet 生成的组合图表"
									href="/chart/comb">组合图表</a>
							</li>

							<li class="header">
								第三十八章 PDF组件 iText
							</li>
							<li>
								<a class="tips" title="生成PDF :: 用 Servlet 生成的 PDF"
									href="/chart/pdf.jsp">生成PDF</a>
							</li>

							<li class="header">
								第三十九章 论坛系统(Struts+Hibernate+Spring)
							</li>
							<li>
								<a class="tips"
									title="论坛系统 :: Spring/Struts/Hibernate搭建的论坛系统，皮肤使用phpWind"
									href="/forum/forum.jsp">论坛系统</a>
							</li>

						</ul>



						<ul class="forJBoss">

							<li class="header">
								第四十章 博客系统(Spring+JPA+Struts2)
							</li>
							<li>
								<a class="tips" title="博客系统 :: 使用 Spring/JPA/Struts2 搭建的博客系统"
									href="/blog" target="_blank">博客系统</a>
							</li>


							<li class="header">
								第四十一章 宠物商店系统(EJB3+JPA+Struts2)
							</li>
							<li>
								<a class="tips" title="宠物商店系统 :: 使用 EJB3/JPA/Struts2 搭建的宠物商店系统"
									href="/blog" target="_blank">博客系统</a>
							</li>


						</ul>

						<br />
						<br />
						<br />
						<br />
						<br />
						<br />
						<br />

					</div>
				</td>
				<td>
					<iframe FRAMEBORDER=0 width="100%" height="100%" SCROLLING=auto
						name="mainFrame" id="mainFrame"></IFRAME>

				</td>
			</tr>
		</table>
	</body>
</html>
