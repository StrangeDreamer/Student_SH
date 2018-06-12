package service;

import java.util.List;

import cn.wjy.enity.Students;

public interface IStudentsService {
	// ��ѯ����ѧ����Ϣ
	public List<Students> queryAllStudents();

	// ͨ��ѧ����Ų�ѯѧ����Ϣ
	public Students queryStudentsById(String sid);

	// ���ѧ������
	public boolean addStudents(Students s);

	// ɾ��ѧ��

	public boolean deleteStudents(String sid);

	// �޸�ѧ��
	public boolean updateStudents(Students s);
}
