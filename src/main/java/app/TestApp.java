package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import core.util.HibernateUtil;
import web.member.pojo.Member;

public class TestApp {

	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		Member member = session.get(Member.class, 1);
//		System.out.println(member.getUsername());
//		
//		HibernateUtil.shutdown();
//		Member member = new Member();
//		member.setUsername("使用者名稱");
//		member.setPassword("密碼");
//		member.setNickname("暱稱");
//		
//		Member member = new Member();
//		member.setId(1);
//		member.setRoleId(2);
//		member.setPass(false);
		
		TestApp app = new TestApp();
//		System.out.println(app.insert(member));
//		System.out.println(app.deleteById(3));
//		System.out.println(app.updateById(member));
		System.out.println(app.selectById(1).getNickname());
		
	}
	
	public Integer insert(Member member) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.persist(member);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		HibernateUtil.shutdown();
		return member.getId();
		
		
	}
	
	public Integer deleteById(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Member member = session.get(Member.class, id);
			session.remove(member);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return -1;
		}
		
		HibernateUtil.shutdown();
		return 1;
		
	}
	public Integer updateById(Member newMember) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Member olidMember = session.get(Member.class, newMember.getId());
			if(newMember.getPass() != null) {
				olidMember.setPass(newMember.getPass());
			}
			if(newMember.getRoleId() != null) {
				olidMember.setRoleId(newMember.getRoleId());
			}
//			session.saveOrUpdate(olidMember);
			transaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return -1;
		}
		
		HibernateUtil.shutdown();
		return 1;
		
	}
	

	public Member selectById(Integer id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Member member = session.get(Member.class, id);
			return member;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
		
	}
}
