package three;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	public static void main(String[] args) throws HibernateException, SQLException {
		Session session = new AnnotationConfiguration().configure("3.cfg.xml").buildSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		Employee emp = new Employee();
		emp.setFirstName("ahmed");
		emp.setLastName("khan");
		session.persist(emp);// persisting the object

		t.commit();// transaction is commited
		session.close();

		System.out.println("successfully saved");

	}

}
