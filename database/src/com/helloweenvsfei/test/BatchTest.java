package com.helloweenvsfei.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class BatchTest {

	public static void main(String[] args) throws SQLException {

		new Driver();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/databaseWeb?characterEncoding=UTF-8",
							"root", "admin");

			stmt = conn.createStatement();

			for (int i = 0; i < 5; i++) {

				// 完整的 SQL 语句
				String sql = "insert into tb_person "
						+ " ( name, english_name, age, "
						+ " sex, birthday, description) " + " values ('Name "
						+ i + "', 'English Name " + i + "', "
						+ " '17', '男', current_date(), '') ";

				// 批量添加
				stmt.addBatch(sql);
			}

			// 批量执行 将每句SQL执行的结果组织成 int[] 数组
			int[] result = stmt.executeBatch();

			// 输出
			System.out.print("影响的行数分别为：");
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + ", ");
			}

		} finally {
			if (rs != null)
				rs.close();

			if (stmt != null)
				stmt.close();

			if (conn != null)
				conn.close();
		}
	}
}
