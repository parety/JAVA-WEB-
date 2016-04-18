package com.helloweenvsfei.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class GetGeneratedKeysTest {

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

			// 执行 INSERT 语句
			stmt.executeUpdate("insert into tb_person "
					+ " ( name, english_name, age, "
					+ " sex, birthday, description) "
					+ " values ('Name', 'English Name', "
					+ " '17', '男', current_date(), '') ");

			// 获取自动生成的键值
			rs = stmt.getGeneratedKeys();

			rs.next();
			System.out.println("id: " + rs.getInt(1));

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
