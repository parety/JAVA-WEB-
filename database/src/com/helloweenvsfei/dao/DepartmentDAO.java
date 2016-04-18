package com.helloweenvsfei.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.helloweenvsfei.bean.Department;
import com.helloweenvsfei.util.DbManager;

public class DepartmentDAO {

	/**
	 * 插入一条 Department 记录
	 * 
	 * @param department
	 * @throws Exception
	 */
	public static int insert(Department department) throws Exception {

		String sql = "INSERT INTO tb_department (name) VALUES ( ? ) ";

		return DbManager.executeUpdate(sql, department.getName());
	}

	/**
	 * 保存 Department
	 * 
	 * @param department
	 * @throws Exception
	 */
	public static int save(Department department) throws Exception {

		String sql = "UPDATE tb_department SET name = ? WHERE id = ? ";

		return DbManager.executeUpdate(sql, department.getName(), department
				.getId());
	}

	/**
	 * 删除 Department
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static int delete(Integer id) throws Exception {

		String sql = "DELETE FROM tb_department WHERE id = ? ";

		return DbManager.executeUpdate(sql, id);

	}

	/**
	 * 查找一条 Department 记录
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static Department find(Integer id) throws Exception {

		String sql = "SELECT * FROM tb_department WHERE id = ? ";

		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;

		try {
			conn = DbManager.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, id);

			rs = preStmt.executeQuery();

			if (rs.next()) {
				Department department = new Department();
				department.setId(id);
				department.setName(rs.getString("name"));
				return department;
			} else {
				return null;
			}

		} finally {
			if (rs != null)
				rs.close();
			if (preStmt != null)
				preStmt.close();
			if (conn != null)
				conn.close();
		}
	}

	/**
	 * 列出所有的 Department
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<Department> listDepartments() throws Exception {

		List<Department> list = new ArrayList<Department>();

		String sql = "SELECT * FROM tb_department ORDER BY id DESC ";

		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;

		try {
			conn = DbManager.getConnection();
			preStmt = conn.prepareStatement(sql);

			rs = preStmt.executeQuery();

			while (rs.next()) {
				Department department = new Department();
				department.setId(rs.getInt("id"));
				department.setName(rs.getString("name"));

				list.add(department);
			}

		} finally {
			if (rs != null)
				rs.close();
			if (preStmt != null)
				preStmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}

}
