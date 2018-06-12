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

	// 查询所有学生资料
	public String query() {
		List<Students> list = studentService.queryAllStudents();
		if (list != null && list.size() > 0) {
			session.setAttribute("students_list", list);
		} else {
			session.setAttribute("students_list", null);
		}
		return "query_success";

	}

	// 修改学生
	public String modify() {
		String sid = request.getParameter("sid");
		Students s = studentService.queryStudentsById(sid);
		session.setAttribute("modify_students", s);
		return "modify_success";
	}

	// 删除学生
	public String delete() {
		String sid = request.getParameter("sid");
		if (studentService.deleteStudents(sid)) {
			return "delete_success";
		} else {
			return "query_success";
		}

	}

	// 保存修改后的学生
	public String save() {
		studentService.updateStudents(students);
		return "save_success";
	}

	// 添加学生
	public String add() {
		studentService.addStudents(students);
		return "add_success";

	}

	@Override
	public Students getModel() {

		return this.students;
	}

}
