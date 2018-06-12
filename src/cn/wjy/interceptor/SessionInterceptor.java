package cn.wjy.interceptor;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.wjy.utils.HibernateUtils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SessionInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			// ����Session
			Session session = HibernateUtils.getSession();
			// ��������
			Transaction tx = session.beginTransaction(); 
			// ִ��action
			String result = invocation.invoke();
			// �ύ����
			tx.commit();
			// ���ؽ����ͼ
			return result;
		    }
		catch (Exception e) 
		{
			
			throw new RuntimeException(e);
			
			
		}
	}

}
