package one;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Main {

	public static void main(String[] args) throws HibernateException, SQLException {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Stock stock = new Stock();
		
		stock.setStockCode("4715");
		stock.setStockName("GENM");
		System.out.println(session.connection().getMetaData().getDatabaseProductName());
		session.save(stock);
		session.getTransaction().commit();
	}

}
