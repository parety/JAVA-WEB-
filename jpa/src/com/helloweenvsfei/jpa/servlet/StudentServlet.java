package com.helloweenvsfei.jpa.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.helloweenvsfei.jpa.bean.Student;

public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1003261962068713770L;

	// @PersistenceUnit(unitName="student")
	private EntityManagerFactory emFactory;

	@Override
	public void init() throws ServletException {
		if (emFactory == null) {
			emFactory = Persistence.createEntityManagerFactory("jpa");
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if ("add".equals(action)) {
			add(request, response);
		} else if ("list".equals(action)) {
			list(request, response);
		} else {
			list(request, response);
		}

	}

	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManager em = emFactory.createEntityManager();

		Student student = new Student();
		student.setName("Student " + new Random().nextInt(10));
		student.setAge(15 + new Random().nextInt(10));

		em.getTransaction().begin();
		em.persist(student);
		em.getTransaction().commit();
		em.close();

		this.list(request, response);
	}

	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManager em = emFactory.createEntityManager();

		List studentList = em.createQuery(
				" select s from Student s order by s.id desc ").setMaxResults(
				100).getResultList();

		Long count = (Long) em.createQuery(" select count(s) from Student ")
				.getSingleResult();

		int rows = em
				.createQuery(
						" Update Student s set s.name = :newName where s.name = :oldName ")
				.setParameter("oldName", "¾ÉÃû³Æ").setParameter("newName", "ÐÂÃû³Æ")
				.executeUpdate();

		em.close();

		request.setAttribute("studentList", studentList);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}

	public void destroy() {
		emFactory.close();
	}
}
