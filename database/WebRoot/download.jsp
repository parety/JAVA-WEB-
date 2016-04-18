<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<jsp:directive.page import="com.helloweenvsfei.util.DbManager"/>
<jsp:directive.page import="java.sql.ResultSet"/>
<jsp:directive.page import="java.sql.Connection"/>
<jsp:directive.page import="java.sql.PreparedStatement"/>
<jsp:directive.page import="java.io.OutputStream"/>
<jsp:directive.page import="java.io.InputStream"/>
<%
	out.clear();

	int id = Integer.parseInt(request.getParameter("id"));
	
	Connection conn = null;
	PreparedStatement preStmt = null;
	ResultSet rs = null;
	
	try{
		conn = DbManager.getConnection();
		preStmt = conn.prepareStatement("select * from tb_attachment where id = ? ");
		preStmt.setInt(1, id);
		rs = preStmt.executeQuery();
		
		if(rs.next()){
			response.reset();
			response.setContentType(rs.getString("filetype"));
			response.setContentLength(rs.getInt("size"));
			
			InputStream ins = null;
			OutputStream ous = null;
			
			try{
				ins = rs.getBinaryStream("content");
				ous = response.getOutputStream();
				
				byte[] b = new byte[1024];
				int len = 0;
				
				while((len = ins.read(b)) != -1){
					ous.write(b, 0, len);
				}
				
			}finally{
				if(ous != null)	ous.close();
				if(ins != null)	ins.close();
			}
			
		}
		else{
			out.println("没有找到附件：" + id);
		}
		
		
	}finally{
		if(rs != null)	rs.close();
		if(preStmt != null)	preStmt.close();
		if(conn != null)	conn.close();
	}
	
%>