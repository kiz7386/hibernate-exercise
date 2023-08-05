package core.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static core.util.HibernateUtil.getSessionFactory;

public interface CoreService {
	
	private static Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

	default Transaction beginTransation() {
		return getSessionFactory().getCurrentSession().beginTransaction();
	}

	default void commit() {
		getSession().getTransaction().commit();
	}

	default void rollback() {
		getSession().getTransaction().rollback();
	}
}
