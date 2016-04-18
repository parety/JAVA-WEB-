package com.helloweenvsfei.hibernate.test;

import java.util.List;

import org.hibernate.Session;

import com.helloweenvsfei.hibernate.bean.Address;
import com.helloweenvsfei.hibernate.bean.Customer;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class TestAnnotationedCustomerAddress {

	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {

		Customer customer = new Customer();
		customer.setName("Helloween");

		Address address = new Address();
		address.setAddress("�����к������йش�");
		address.setTelephone("010-77883210");
		address.setZip("100001");

		// address.setCustomer(customer);

		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();

		// ���� customer�����ݿ��Ϊ customer �Զ����� ID
		session.persist(customer);

		// Ҫ�ֹ����� address �� ID ��֤����IDһ��
		address.setId(customer.getId());

		// ���� address
		session.persist(address);

		session.flush();

		List<Customer> list = session.createQuery(
				" select c from Customer c where c.name = :name ")
				.setParameter("name", "Helloween").list();

		for (Customer c : list) {
			session.refresh(c);
			System.out.println("�ͻ�������" + c.getName());
			System.out.println("\t�绰��" + c.getAddress().getTelephone());
			System.out.println("\t�ʱࣺ" + c.getAddress().getZip());
			System.out.println("\t��ַ��" + c.getAddress().getAddress());
		}

		session.getTransaction().commit();
		session.close();
	}
}
