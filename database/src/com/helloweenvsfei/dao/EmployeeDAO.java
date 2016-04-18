package com.helloweenvsfei.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.helloweenvsfei.bean.Employee;
import com.helloweenvsfei.util.DbManager;

public class EmployeeDAO {

	/**
	 * 插入一条记录
	 * 
	 * @param employee
	 * @return
	 * @throws Exception
	 */
	public static int insert(Employee employee) throws Exception {

		String sql = " INSERT INTO tb_employee "
				+ " (department_id, name, sex, employed_date) "
				+ " VALUES (?,?,?,?) ";

		return DbManager.executeUpdate(sql, employee.getDepartment().getId(),
				employee.getName(), employee.getSex(), employee
						.getEmployedDate());
	}

	/**
	 * 保存一条记录
	 * 
	 * @param employee
	 * @return
	 * @throws Exception
	 */
	public static int save(Employee employee) throws Exception {

		String sql = " UPDATE tb_employee "
				+ " set department_id = ?, name = ?, sex = ?, employed_date = ? "
				+ " where id = ? ";

		return DbManager.executeUpdate(sql, employee.getDepartment().getId(),
				employee.getName(), employee.getSex(), employee
						.getEmployedDate(), employee.getId());
	}

	/**
	 * 查找一条记录
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static Employee find(Integer id) throws Exception {

		String sql = "SELECT * FROM tb_employee WHERE id = ? ";

		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;

		try {
			conn = DbManager.getConnection();
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, id);

			rs = preStmt.executeQuery();

			if (rs.next()) {

				Employee employee = new Employee();
				employee.setId(id);
				employee.setName(rs.getString("name"));
				employee.setEmployedDate(rs.getDate("employed_date"));
				employee.setSex(rs.getString("sex"));

				employee.setDepartment(DepartmentDAO.find(rs
						.getInt("department_id")));

				return employee;
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
	 * 列出所有的员工
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<Employee> listAllEmployees() throws Exception {
		List<Employee> list = new ArrayList<Employee>();

		String sql = "SELECT * FROM tb_employee ORDER BY id DESC ";

		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;

		try {
			conn = DbManager.getConnection();
			preStmt = conn.prepareStatement(sql);

			rs = preStmt.executeQuery();

			while (rs.next()) {

				Employee employee = new Employee();

				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setEmployedDate(rs.getDate("employed_date"));
				employee.setSex(rs.getString("sex"));

				employee.setDepartment(DepartmentDAO.find(rs
						.getInt("department_id")));

				list.add(employee);

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
