package com.helloweenvsfei.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class PreparedBatchTest {

	public static void main(String[] args) throws SQLException {

		new Driver();

		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/databaseWeb?characterEncoding=UTF-8",
							"root", "admin");

			preStmt = conn.prepareStatement("insert into tb_person "
					+ " ( name, english_name, age, "
					+ " sex, birthday, description) "
					+ " values (?, ?, ?, ?, ?) ");

			for (int i = 0; i < 5; i++) {

				int index = 1;

				preStmt.setString(index++, "Name " + i);
				preStmt.setString(index++, "English Name" + i);
				preStmt.setInt(index++, 25);
				preStmt.setString(index++, "男");
				preStmt.setDate(index++, new java.sql.Date(System
						.currentTimeMillis()));
				preStmt.setString(index++, "");

				// 添加同一条带参数的SQL语句
				preStmt.addBatch();
			}

			// 批量执行 将每句SQL执行的结果组织成 int[] 数组
			int[] result = preStmt.executeBatch();

			// 输出
			System.out.print("影响的行数分别为：");
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + ", ");
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
}
