package service.impl;

import java.util.List;

import service.IStudentsService;
import cn.wjy.dao.IStudentsDao;
import cn.wjy.dao.impl.StudentsDao;
import cn.wjy.enity.Students;

public class StudentsService implements IStudentsService {

	private IStudentsDao studentsDao = new StudentsDao();

	@Override
	public List<Students> queryAllStudents() {

		return studentsDao.queryAllStudents();
	}

	@Override
	public Students queryStudentsById(String sid) {
		// TODO Auto-generated method stub
		return studentsDao.queryStudentsById(sid);
	}

	@Override
	public boolean addStudents(Students s) {
		return studentsDao.addStudents(s);
	}

	@Override
	public boolean updateStudents(Students s) {
		// TODO Auto-generated method stub
		return studentsDao.updateStudents(s);
	}

	@Override
	public boolean deleteStudents(String sid) {
		// TODO Auto-generated method stub
		return studentsDao.deleteStudents(sid);
	}

}
