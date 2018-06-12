package cn.wjy.dao;

import java.util.List;

import cn.wjy.enity.Students;

public interface IStudentsDao {
	// ��ѯ����ѧ����Ϣ
	public List<Students> queryAllStudents();
	// ͨ��ѧ����Ų�ѯѧ����Ϣ
	public Students queryStudentsById(String sid);
	// ���ѧ������
	public boolean addStudents(Students s);
	// �޸�ѧ��
	public boolean updateStudents(Students s);
	//ɾ��ѧ��
	public boolean deleteStudents(String sid);
}
