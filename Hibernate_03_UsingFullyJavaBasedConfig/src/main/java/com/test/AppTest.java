package com.test;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Product;
import com.entity.Student;
//import com.entity.Student;
import com.utils.HibernateUtil;
public class AppTest {
    public static void main(String[] args) {
       
    	// transient state
    	Student student = new Student("vaishnavi", "kadam", "vk@gmail.com");
        Student student1 = new Student("ram", "kale", "ramram@gmail.com");
        Product product = new Product("coke", 50 , 7000 );
        Product product1 = new Product("choclates", 75 , 9000);
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            
            // persistent state 
            // save the student objects
            student.setFirstName("rani");
            session.saveOrUpdate(student);
           // session.update(student1);
            //session.update(product);
          //  session.update(product1);
                   
            //--------------------------------------------
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


            students.forEach(s->System.out.println("FirstName >>> "+ s.getFirstName() +   " LastName>>> "  + s.getLastName() +  " Email>>> " + s.getEmail()));
            products.forEach(s->System.out.println("Productname>>> "+ s.getproductname() + " Productprize>>> "  + s.getproductprize() +  " Productquantity>>> " + s.getproductquqntity()));

            
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
