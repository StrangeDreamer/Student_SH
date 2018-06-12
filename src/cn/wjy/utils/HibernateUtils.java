package cn.wjy.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
//���session��������Ҫ��һ�������ҽ���һ������

public class HibernateUtils {

	private static SessionFactory sf;
	private static ServiceRegistry serviceRegistry;
	private static Configuration config;
    //���췽��˽�л�����֤����ģʽ
	private HibernateUtils() {

	}
    //��̬����飬��ʼ����̬����
	static {
		//sf = new Configuration().configure().buildSessionFactory();�Ѿ�����
		config=new Configuration().configure();
	    serviceRegistry=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();      
		sf=config.buildSessionFactory(serviceRegistry);
	}
    //���еľ�̬��������ûỰ����ʵ������
	public static Session getSession() {
		return sf.getCurrentSession();
	}
}
