package com.helloweenvsfei.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.helloweenvsfei.hibernate.bean.Sailor;
import com.helloweenvsfei.hibernate.bean.Ship;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class TestAnnotationedShipSailor {

	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {

		Ship ship = new Ship();
		ship.setName("̩̹���");

		Sailor captain = new Sailor();
		captain.setName("ʷ��˹");
		captain.setShip(ship);

		Sailor sailor = new Sailor();
		sailor.setName("�ܿ�");
		sailor.setShip(ship);

		ship.setCaptain(captain);
		ship.getSailors().add(captain);
		ship.getSailors().add(sailor);

		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();

		session.persist(ship);

		List<Sailor> list = session.createQuery(
				" select s from Sailor s where s.ship.name = :name ")
				.setParameter("name", "̩̹���").list();

		for (Sailor s : list) {
			System.out.println("ˮ�֣�" + s.getName());
			System.out.println("������" + s.getShip().getName());
			System.out.println("������" + s.getShip().getCaptain().getName());
			System.out.println("-----------------");
		}

		session.getTransaction().commit();
		session.close();
	}

}
