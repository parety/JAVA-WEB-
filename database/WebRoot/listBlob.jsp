<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<jsp:directive.page import="com.helloweenvsfei.util.DbManager"/>
<jsp:directive.page import="java.sql.Statement"/>
<jsp:directive.page import="java.sql.ResultSet"/>
<jsp:directive.page import="java.sql.Connection"/>
<jsp:directive.page import="org.apache.commons.fileupload.DiskFileUpload"/>
<jsp:directive.page import="java.util.List"/>
<jsp:directive.page import="org.apache.commons.fileupload.FileItem"/>
<jsp:directive.page import="java.sql.PreparedStatement"/>
<jsp:directive.page import="java.sql.Timestamp"/>
<%!
	public void init() {
		try{
			DbManager.executeUpdate("CREATE TABLE IF NOT EXISTS tb_attachment ( id int auto_increment, filename varchar(255), filetype varchar(255), size int, content blob, ip varchar(255), date timestamp, primary key (id) );"); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>
<%
	if("POST".equalsIgnoreCase(request.getMethod())){
		// 使用 DiskFileUpload 上传文件
		DiskFileUpload diskFileUpload = new DiskFileUpload();
		diskFileUpload.setHeaderEncoding("UTF-8");
		List<FileItem> list = diskFileUpload.parseRequest(request);
		for(FileItem fileItem : list){
			
			if(!fileItem.isFormField()){
				// 获取文件名
				String filename = fileItem.getName().replace("\\", "/");
				filename = filename.substring(filename.lastIndexOf("/") + 1);
				
				Connection conn = null;
				PreparedStatement preStmt = null;
				
				try{
					conn = DbManager.getConnection();
					
					preStmt = conn.prepareStatement("INSERT INTO tb_attachment "
								+ " ( filename, filetype, size, content, ip, date )  "
								+ " values ( ?, ?, ?, ?, ?, ? ) ");
					// 文件名称
					preStmt.setString(1, filename);
					// 文件类型
					preStmt.setString(2, fileItem.getContentType());
					// 文件长度
					preStmt.setInt(3, (int)fileItem.getSize());
					// 文件内容，通过流输入到数据库
					preStmt.setBinaryStream(4, fileItem.getInputStream(), (int)fileItem.getSize());
					// 上传者IP地址
					preStmt.setString(5, request.getRemoteAddr());
					// 上传时间
					preStmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
					
					preStmt.executeUpdate();
					
				}finally{
					if(preStmt != null)	preStmt.close();
					if(conn != null)	conn.close();
				}
			}
		}
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'listPerson.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">
			body, td, th, input {font-size:12px; }
			table {border-collapse: collapse; border: 1px solid #000000}
			th, td {border: 1px solid #000000; padding: 2px; text-align: center; }
			input {height: 25px; }
		</style>
	</head>
	<body>
	
	<a href="javascript:location=location;">刷新附件列表</a>
	
	<%
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DbManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM tb_attachment ORDER BY id DESC");
			
			out.println("<table>");
			out.println("	<tr>");
			out.println("		<th>ID</th>");
			out.println("		<th>File Name</th>");
			out.println("		<th>File Type</th>");
			out.println("		<th>Size</th>");
			out.println("		<th>IP</th>");
			out.println("		<th>Date</th>");
			out.println("		<th>Operation</th>");
			out.println("	<tr>");
			
			while(rs.next()){
				out.println("	<tr>");
				out.println("		<td>" + rs.getInt("id") + "</td>");
				out.println("		<td>" + rs.getString("filename") + "</td>");
				out.println("		<td>" + rs.getString("filetype") + "</td>");
				out.println("		<td>" + rs.getInt("size") + "</td>");
				out.println("		<td>" + rs.getString("ip") + "</td>");
				out.println("		<td>" + rs.getTimestamp("date") + "</td>");
				out.println("		<td><a href='download.jsp?id=" + rs.getInt("id") + "'>下载</a></td>");
				out.println("	</tr>");
			}
			out.println("</table>");
			
		}finally{
			if(rs != null)	rs.close();
			if(stmt != null)	stmt.close();
			if(conn != null)	conn.close();
		}
		
	%>
	
	<form action="${ pageContext.request.requestURI }" method="post" enctype="multipart/form-data">
		<input name="file" type="file" style="width: 300px; " /><input type="submit" value=" 开始上传 ">
	</form>
	
	</body>
</html>
