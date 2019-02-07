package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.EmployeeDTO;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command{
	public ExistCommand(HttpServletRequest request,
			HttpServletResponse response) {
		super(request, response);
		EmployeeDTO emp = new EmployeeDTO();
		emp.setEmployeeID(request.getParameter("empno"));
		emp.setName(request.getParameter("name"));
		boolean exist = EmployeeServiceImpl.getInstance().existsEmployee(emp);
		if(exist) {
			System.out.println("접근 허용");
		}else {
			System.out.println("접근 불가");
			super.setDomain("home");
			super.setPage("main");
			super.execute();
		}
		System.out.println("ExistCommand 내부: "+super.getView());
	}
}




















































/*public ExistCommand(HttpServletRequest request,
		HttpServletResponse response) {
	super(request, response);
	EmployeeDTO emp = new EmployeeDTO();
	emp.setEmployeeID(request.getParameter("empno"));
	emp.setName(request.getParameter("name"));
	boolean exist = EmployeeServiceImpl.getInstance().existsEmployee(emp);
	if(exist) {
		System.out.println("접근허용");
	}else {
		System.out.println("접근불가");
	}
}*/