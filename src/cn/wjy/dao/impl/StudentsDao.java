package cn.wjy.dao.impl;

import java.util.List;

import org.hibernate.Query;

import cn.wjy.dao.IStudentsDao;
import cn.wjy.enity.Students;
import cn.wjy.utils.HibernateUtils;

public class StudentsDao implements IStudentsDao {

	@Override
	public List<Students> queryAllStudents() {

		/*
		 * List<Students> list = null; String hql = ""; Session session =
		 * HibernateUtils.getSession(); try { session.beginTransaction(); hql =
		 * "from Students"; Query query = session.createQuery(hql); list =
		 * query.list(); session.getTransaction().commit(); return list; } catch
		 * (Exception e) { session.getTransaction().commit(); throw new
		 * RuntimeException(e); }
		 */
		try {
			List<Students> list = null;
			String hql = "from Students";
			Query query = HibernateUtils.getSession().createQuery(hql);
			list = query.list();
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public Students queryStudentsById(String sid) {

		/*
		 * Session session = HibernateUtils.getSession(); Students s = new
		 * Students(); try { session.beginTransaction(); s = (Students)
		 * session.get(Students.class, sid); session.getTransaction().commit();
		 * return s;
		 * 
		 * } catch (Exception e) { session.getTransaction().commit(); throw new
		 * RuntimeException(e);
		 * 
		 * }
		 */
		try {
			Students s = new Students();
			s = (Students) HibernateUtils.getSession().get(Students.class, sid);
			return s;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 自动生成学生编号
	private String getNewSid() {
		/*
		 * Session session = HibernateUtils.getSession(); String hql = null;
		 * String sid = null; try { session.beginTransaction(); hql =
		 * "select max(sid) from Students"; Query query =
		 * session.createQuery(hql); sid = (String) query.uniqueResult(); if
		 * (sid == null || "".equals(sid)) { sid = "S000001"; } else { String
		 * temp = sid.substring(1); int i = Integer.parseInt(temp); i++; temp =
		 * String.valueOf(i); int len = temp.length(); for (int j = 0; j < 6 -
		 * len; j++) { temp = "0" + temp; } sid = "S" + temp; }
		 * session.getTransaction().commit(); return sid; } catch (Exception e)
		 * { e.printStackTrace(); throw new RuntimeException(e); }
		 */

		try {
			String hql = "select max(sid) from Students";
			Query query = HibernateUtils.getSession().createQuery(hql);
			String sid = (String) query.uniqueResult();
			if (sid == null || "".equals(sid)) {
				sid = "S000001";
			} else {
				String temp = sid.substring(1);
				int i = Integer.parseInt(temp);
				i++;
				temp = String.valueOf(i);
				int len = temp.length();
				for (int j = 0; j < 6 - len; j++) {
					temp = "0" + temp;
				}
				sid = "S" + temp;
			}
			return sid;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public boolean addStudents(Students s) {

		/*
		 * s.setSid(getNewSid()); Session session = HibernateUtils.getSession();
		 * try { session.beginTransaction(); session.save(s);
		 * session.getTransaction().commit(); return true; } catch (Exception e)
		 * { session.getTransaction().commit(); throw new RuntimeException(e);
		 * 
		 * }
		 */
		try {
			s.setSid(getNewSid());
			HibernateUtils.getSession().save(s);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateStudents(Students s) {
		/*
		 * Session session = HibernateUtils.getSession(); try {
		 * session.beginTransaction(); session.update(s);
		 * session.getTransaction().commit(); return true; } catch (Exception e)
		 * { e.printStackTrace(); return false; }
		 */
		
		try {
			HibernateUtils.getSession().update(s);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean deleteStudents(String sid) {
		/*
		 * Session session = HibernateUtils.getSession(); try {
		 * session.beginTransaction(); Students s = (Students)
		 * session.get(Students.class, sid); session.delete(s);
		 * session.getTransaction().commit(); return true; } catch (Exception e)
		 * { e.printStackTrace(); return false; }
		 */

		try {
			Students s = (Students) HibernateUtils.getSession().get(
					Students.class, sid);
			HibernateUtils.getSession().delete(s);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
