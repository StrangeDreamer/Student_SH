package service;

import java.util.List;

import cn.wjy.enity.Students;

public interface IStudentsService {
	// 查询所有学生信息
	public List<Students> queryAllStudents();

	// 通过学生编号查询学生信息
	public Students queryStudentsById(String sid);

	// 添加学生资料
	public boolean addStudents(Students s);

	// 删除学生

	public boolean deleteStudents(String sid);

	// 修改学生
	public boolean updateStudents(Students s);
}
