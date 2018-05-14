package four;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {

		Txn1 txn = buildDemoTransaction();

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			// Get Session
			sessionFactory = HibernateAnnotationUtil.getSessionFactory();
			session = sessionFactory.openSession();
			System.out.println("Session created using annotations configuration");
			// start transaction
			tx = session.beginTransaction();
			// Save the Model object
			session.save(txn);
			// Commit transaction
			tx.commit();
			System.out.println("Annotation Example. Transaction ID=" + txn.getId());
			Txn1 txn2 = (Txn1) session.get(Txn1.class, txn.getId());
			System.out.println("Annotation Example. Transaction Details=\n" + txn2);
		} catch (Exception e) {
			System.out.println("Exception occured. " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (sessionFactory != null && !sessionFactory.isClosed()) {
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}


	private static Txn1 buildDemoTransaction() {
		Txn1 txn = new Txn1();
		txn.setDate(new Date());
		txn.setTotal(100);

		Customer1 cust = new Customer1();
		cust.setAddress("aaaaa, USA");
		cust.setEmail("ssssssj@yahoo.com");
		cust.setName("aaaaaa Kr");

		txn.setCustomer(cust);

		cust.setTxn(txn);
		return txn;
	}

}
