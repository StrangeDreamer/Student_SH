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
			// 创建Session
			Session session = HibernateUtils.getSession();
			// 开启事务
			Transaction tx = session.beginTransaction(); 
			// 执行action
			String result = invocation.invoke();
			// 提交事务
			tx.commit();
			// 返回结果视图
			return result;
		    }
		catch (Exception e) 
		{
			
			throw new RuntimeException(e);
			
			
		}
	}

}
