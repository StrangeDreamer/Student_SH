package cn.wjy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.wjy.dao.IUsersDao;
import cn.wjy.enity.Users;
import cn.wjy.utils.HibernateUtils;

public class UsersDao implements IUsersDao {

	@Override
	public boolean usersLogin(Users u) {
		/*
		 * Transaction tx = null; String hql = ""; try { Session session =
		 * HibernateUtils.getSession(); hql =
		 * "from Users u where username=? and password=?"; tx =
		 * session.beginTransaction(); Query query = session.createQuery(hql);
		 * query.setParameter(0, u.getUsername()); query.setParameter(1,
		 * u.getPassword()); List list = query.list(); tx.commit(); if
		 * (list.size() > 0) { return true; } else { return false; } } catch
		 * (Exception e) { e.printStackTrace(); return false; }
		 */

		try {
			String hql = "from Users u where username=? and password=?";
			Query query = HibernateUtils.getSession().createQuery(hql)
					.setParameter(0, u.getUsername())
					.setParameter(1, u.getPassword());
			List list = query.list();
			if (list.size() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
