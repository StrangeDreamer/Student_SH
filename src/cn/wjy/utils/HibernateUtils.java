package cn.wjy.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
//获得session工厂对象，要求一个类有且仅有一个对象

public class HibernateUtils {

	private static SessionFactory sf;
	private static ServiceRegistry serviceRegistry;
	private static Configuration config;
    //构造方法私有化，保证单例模式
	private HibernateUtils() {

	}
    //静态代码块，初始化静态变量
	static {
		//sf = new Configuration().configure().buildSessionFactory();已经弃用
		config=new Configuration().configure();
	    serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();      
		sf=config.buildSessionFactory(serviceRegistry);
	}
    //公有的静态方法，获得会话工厂实例对象
	public static Session getSession() {
		return sf.getCurrentSession();
	}
}
