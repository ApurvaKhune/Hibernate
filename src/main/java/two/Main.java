package two;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) throws HibernateException, SQLException {
		Session session = new Configuration().configure("2.cfg.xml").buildSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		Employee emp = new Employee();
		emp.setFirstName("mateen");
		emp.setLastName("khan");
		session.persist(emp);// persisting the object

		t.commit();// transaction is commited
		session.close();

		System.out.println("successfully saved");

	}

}
