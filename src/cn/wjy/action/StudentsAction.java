package cn.wjy.action;

import java.util.List;

import service.IStudentsService;
import service.impl.StudentsService;
import cn.wjy.enity.Students;

import com.opensymphony.xwork2.ModelDriven;

public class StudentsAction extends SuperAction implements
		ModelDriven<Students> {

	private static final long serialVersionUID = 1L;

	private Students students = new Students();

	private static IStudentsService studentService;
	static {
		studentService = new StudentsService();
	}

	// ��ѯ����ѧ������
	public String query() {
		List<Students> list = studentService.queryAllStudents();
		if (list != null && list.size() > 0) {
			session.setAttribute("students_list", list);
		} else {
			session.setAttribute("students_list", null);
		}
		return "query_success";

	}

	// �޸�ѧ��
	public String modify() {
		String sid = request.getParameter("sid");
		Students s = studentService.queryStudentsById(sid);
		session.setAttribute("modify_students", s);
		return "modify_success";
	}

	// ɾ��ѧ��
	public String delete() {
		String sid = request.getParameter("sid");
		if (studentService.deleteStudents(sid)) {
			return "delete_success";
		} else {
			return "query_success";
		}

	}

	// �����޸ĺ��ѧ��
	public String save() {
		studentService.updateStudents(students);
		return "save_success";
	}

	// ���ѧ��
	public String add() {
		studentService.addStudents(students);
		return "add_success";

	}

	@Override
	public Students getModel() {

		return this.students;
	}

}
