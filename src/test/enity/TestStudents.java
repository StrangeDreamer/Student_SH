package test.enity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import cn.wjy.enity.Students;

@SuppressWarnings("deprecation")
//��ʾ��ȥ���������Ƿ�����
public class TestStudents {
	private static SessionFactory sf;
	static {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	public void testSchemaExport() {
		// ���������ļ��������
		Configuration config = new Configuration();
		// �����������ļ�
		config.configure();
		// �������������
		SchemaExport export = new SchemaExport(config);
		// ����
		// ��һ�������� �Ƿ��ڿ���̨��ӡ�������
		// �ڶ��������� �Ƿ�ִ�нű�
		export.create(true, true);

	}

	@Test
	public void testSaveStudens() {
		Session session = sf.openSession();
		session.beginTransaction();
		Students s1 = new Students("S000001", "������", "��", new Date(), "�䵱ɽ");
		Students s2 = new Students("S000002", "������", "��", new Date(), "�䵱ɽ");
		Students s3 = new Students("S000003", "����", "Ů", new Date(), "�һ���");
		Students s4 = new Students("S000004", "����", "��", new Date(), "��ɽ");
		Students s5 = new Students("S000005", "�ŷ�", "��", new Date(), "�䵱");
		Students s6 = new Students("S000006", "�߽���", "��", new Date(), "���س�");
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
