package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Product;
import com.entity.Student;
import com.entity.Student;
import com.utils.HibernateUtil;

public class AppTest {
	public static void main(String[] args) {

		// transient state
		Student s1 = new Student(1,"update", "change", "asf@gmail.com");
		Product p1 = new Product(2, "UpdateTest", 500, 400);
		Product p2 = new Product(3, "choclate",50,12000);
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// persistent state
			session.saveOrUpdate(p1);
			session.saveOrUpdate(p2);
			session.saveOrUpdate(s1);

			// --------------------------------------------
			// commit transaction
			transaction.commit();

			// detached state
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<Student> students = session.createQuery("from Student", Student.class).list();
			List<Product> products = session.createQuery("from Product", Product.class).list();

			students.forEach(s -> System.out.println("FirstName >>> " + s.getFirstName() + " LastName>>> "
					+ s.getLastName() + " Email>>> " + s.getEmail()));
			products.forEach(s -> System.out.println("Productname>>> " + s.getproductname() + " Productprize>>> "
					+ s.getproductprize() + " Productquantity>>> " + s.getproductquqntity()));

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
