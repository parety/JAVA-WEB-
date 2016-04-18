package com.helloweenvsfei.struts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.helloweenvsfei.struts.bean.Person;

public class PersonDAO {

	public void addPerson(Connection conn, Person person) throws SQLException {

		String personSQL = " insert into tb_person "
				+ " ( account, name, birthday, secret, create_date ) "
				+ " values ( ?, ?, ?, ?, ?) ";

		String hobbySQL = " insert into tb_hobby "
				+ " (person_id, hobby) values (?, ?) ";

		PreparedStatement preStmt = null;
		ResultSet rs = null;

		try {
			conn.setAutoCommit(false);

			// ������Ա��Ϣ
			preStmt = conn.prepareStatement(personSQL);

			int index = 1;

			preStmt.setString(index++, person.getAccount());
			preStmt.setString(index++, person.getName());
			preStmt.setDate(index++, person.getBirthday());
			preStmt.setBoolean(index++, person.isSecret());
			preStmt.setTimestamp(index++, person.getCreateDate());

			preStmt.executeUpdate();

			// ��ȡ�Զ������ id ֵ
			rs = preStmt.getGeneratedKeys();
			rs.next();
			int personId = rs.getInt(1);

			// �������밮����Ϣ
			preStmt = conn.prepareStatement(hobbySQL);

			for (Iterator<String> it = person.getHobby().iterator(); it
					.hasNext();) {

				preStmt.setInt(1, personId);
				preStmt.setString(2, it.next());

				preStmt.addBatch();
			}

			preStmt.executeBatch();

			conn.commit();

		} finally {
			if (rs != null)
				rs.close();
			if (preStmt != null)
				preStmt.close();
			if (conn != null)
				conn.close();
		}
	}

	public List<Person> listPersons(Connection conn) throws SQLException {

		List<Person> list = new ArrayList<Person>();

		Statement stmt = null;
		ResultSet rs = null;

		try {
			// ���Ҹ�����Ϣ
			stmt = conn.createStatement();

			rs = stmt.executeQuery(" select * from tb_person ");

			while (rs.next()) {

				Person person = new Person();

				person.setId(rs.getInt("id"));
				person.setAccount(rs.getString("account"));
				person.setName(rs.getString("name"));
				person.setBirthday(rs.getDate("birthday"));
				person.setCreateDate(rs.getTimestamp("create_date"));
				person.setSecret(rs.getBoolean("secret"));

				list.add(person);
			}

			for (Iterator<Person> it = list.iterator(); it.hasNext();) {

				Person person = it.next();

				// ��ѯ���еİ���
				rs = stmt
						.executeQuery(" select * from tb_hobby where person_id = "
								+ person.getId());

				while (rs.next()) {
					person.getHobby().add(rs.getString("hobby"));
				}
			}
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}

		return list;

	}

}
