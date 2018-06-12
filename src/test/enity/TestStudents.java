package test.enity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import cn.wjy.enity.Students;

@SuppressWarnings("deprecation")
//表示不去检测这个类是否被弃用
public class TestStudents {
	private static SessionFactory sf;
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	public void testSchemaExport() {
		// 创建配置文件管理对象
		Configuration config = new Configuration();
		// 加载主配置文件
		config.configure();
		// 创建工具类对象
		SchemaExport export = new SchemaExport(config);
		// 建表
		// 第一个参数： 是否在控制台打印建表语句
		// 第二个参数： 是否执行脚本
		export.create(true, true);

	}

	@Test
	public void testSaveStudens() {
		Session session = sf.openSession();
		session.beginTransaction();
		Students s1 = new Students("S000001", "张三丰", "男", new Date(), "武当山");
		Students s2 = new Students("S000002", "张三丰", "男", new Date(), "武当山");
		Students s3 = new Students("S000003", "黄蓉", "女", new Date(), "桃花岛");
		Students s4 = new Students("S000004", "张三", "男", new Date(), "武山");
		Students s5 = new Students("S000005", "张丰", "男", new Date(), "武当");
		Students s6 = new Students("S000006", "高渐离", "男", new Date(), "机关城");
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		session.save(s5);
		session.save(s6);

		session.getTransaction().commit();
		session.close();
	}
}
