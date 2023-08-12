package web.member.dao.impl;

//import static core.util.CommonUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import web.member.dao.MemberDao;
import web.member.entity.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	
	@PersistenceContext
	private Session session;
	
	
	@Override
	public int insert(Member member) {
		session.persist(member);
		return 1;
	}

	@Override
	public int deleteById(Integer id) {
		Member member = session.get(Member.class, id);
		session.remove(member);
		return 1;
	}

	@Override
	public int update(Member member) {
		final StringBuilder hql = new StringBuilder()
			.append("UPDATE Member SET ");
		int offset = 0;
		final String password = member.getPassword();
		if (password != null && !password.isEmpty()) {
			hql.append("password = :password,");
			offset = 1;
		}
		hql.append("nickname = :nickname,")
			.append("pass = :pass,")
			.append("roleId = :roleId,")
			.append("updater = :updater,")
			.append("lastUpdatedDate = NOW() ")
			.append("WHERE username = :username");
		Query<?> query = session.createQuery(hql.toString()); // ? unknow type , 已經存在的型別，但是不知道
		if (password != null && !password.isEmpty()) {
			query.setParameter("password", password);
		}
		query.setParameter("nickname", member.getNickname())
			.setParameter("pass", member.getPass())
			.setParameter("roleId", member.getRoleId())
			.setParameter("updater", member.getUpdater())
			.setParameter("username", member.getUsername());
		return query.executeUpdate();
	}

	@Override
	public Member selectById(Integer id) {
		return session.get(Member.class, id);
	}

	@Override
	public List<Member> selectAll() {
		final String hql ="FROM Member order by ID";
		List<Member> queryList = session.createQuery(hql, Member.class).getResultList();
		return queryList;
	}

	@Override
	public Member selectByUsername(String username) {
//		Session session = session;
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Member> criteriaQuery = criteriaBuilder.createQuery(Member.class);
		Root<Member> root = criteriaQuery.from(Member.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("username"), username));
		
		return session.createQuery(criteriaQuery).uniqueResult();
	}

	@Override
	public Member selectForLogin(String username, String password) {
		final String sql = "select * from MEMBER where USERNAME = :username and PASSWORD = :password";
		return session.createNativeQuery(sql, Member.class)
				.setParameter("username", username)
				.setParameter("password", password)
				.uniqueResult();
		
	}
}
