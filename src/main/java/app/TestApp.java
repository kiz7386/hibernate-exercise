//package app;
//
//import java.util.List;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//
//import core.util.HibernateUtil;
//import web.dept.entity.Dept;
//import web.emp.entity.Emp;
//import web.member.entity.Member;
//
//public class TestApp {
//
//	public static void main(String[] args) {
////		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
////		Session session = sessionFactory.openSession();
////		Member member = session.get(Member.class, 1);
////		System.out.println(member.getUsername());
////		
////		HibernateUtil.shutdown();
////		Member member = new Member();
////		member.setUsername("使用者名稱");
////		member.setPassword("密碼");
////		member.setNickname("暱稱");
////		
////		Member member = new Member();
////		member.setId(1);
////		member.setRoleId(2);
////		member.setPass(false);
//		
//		TestApp app = new TestApp();
////		System.out.println(app.insert(member));
////		System.out.println(app.deleteById(3));
////		System.out.println(app.updateById(member));
////		System.out.println(app.selectById(1).getNickname());
////		app.selectAll().stream().forEach(member -> System.out.println(member.getNickname()));
////		app.selectOneParam().stream().forEach(member -> System.out.println(member.getUsername()));
//		
//		
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session session = factory.openSession();
//		
//		// Criteria 語句
//		
//		// select USERNAME, NICKNAME
//		// from MEMBER
//		// where USERNAME = ? and PASSWORD = ?
//		// ＳＱＬ 七個查詢順序 from -> where -> group by -> having -> select -> order by -> limit
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<Member> criteriaQuery =  builder.createQuery(Member.class);
//		Root<Member> root = criteriaQuery.from(Member.class);
//		// where USERNAE =? and PASSWORD = ?
//		criteriaQuery.where(builder.and(
//				builder.equal(root.get("username"), "admin"),
//				builder.equal(root.get("password"), "P@ssw0rd")));
//		
//		// select USERNAME, NICKNAME
//		criteriaQuery.multiselect(root.get("username"), root.get("nickname"));
//		
//		// order by ID asc(升冪)
//		criteriaQuery.orderBy(builder.asc(root.get("id")));
//		
//		Member member = session.createQuery(criteriaQuery).uniqueResult();
////		System.out.println(member.getNickname());
//		
//		// @OneToMany join測試
////		Dept dept = session.get(Dept.class, 30);
////		var emps = dept.getEmps();
////		emps.forEach(emp -> System.out.println(emp.getEname()));
//		
//		// @ManyToOne join 測試
////		Emp emp = session.get(Emp.class, 7369);
////		System.out.println(emp.getEname());
//		
//		// 雙向關聯
//		Emp emp = session.get(Emp.class, 7369);
//		Dept dept = emp.getDept();
//		dept.getEmps().forEach(emp1 -> System.out.println(emp1.getEname()));
//		
//	}
//	
//	public Integer insert(Member member) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		try {
//			Transaction transaction = session.beginTransaction();
//			session.persist(member);
//			transaction.commit();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		
//		HibernateUtil.shutdown();
//		return member.getId();
//		
//		
//	}
//	
//	public Integer deleteById(int id) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		try {
//			Transaction transaction = session.beginTransaction();
//			Member member = session.get(Member.class, id);
//			session.remove(member);
//			transaction.commit();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return -1;
//		}
//		
//		HibernateUtil.shutdown();
//		return 1;
//		
//	}
//	public Integer updateById(Member newMember) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		try {
//			Transaction transaction = session.beginTransaction();
//			Member olidMember = session.get(Member.class, newMember.getId());
//			if(newMember.getPass() != null) {
//				olidMember.setPass(newMember.getPass());
//			}
//			if(newMember.getRoleId() != null) {
//				olidMember.setRoleId(newMember.getRoleId());
//			}
////			session.saveOrUpdate(olidMember);
//			transaction.commit();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return -1;
//		}
//		
//		HibernateUtil.shutdown();
//		return 1;
//		
//	}
//	
//
//	public Member selectById(Integer id) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		try {
//			Member member = session.get(Member.class, id);
//			return member;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return null;
//		}
//		
//	}
//	
//
//	public List<Member> selectAll() {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		try {
//			Transaction transaction = session.beginTransaction();
//			Query<Member> query = session.createQuery("FROM Member");
//			List<Member> list = query.getResultList();
//			transaction.commit();
//			return list;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return null;
//		}
//	}
//	
//	public List<Member> selectOneParam() {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		try {
//			Transaction transaction = session.beginTransaction();
//			Query<Member> query = session.createQuery(
//					"SELECT new web.member.pojo.Member(username, nickname) FROM Member", Member.class);
//			List<Member> list = query.getResultList();
//			transaction.commit();
//			return list;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return null;
//		}
//	}
//	
//}
