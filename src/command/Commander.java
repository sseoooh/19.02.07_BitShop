package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Action;

public class Commander {
	
	public static Command order(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(":::(3)커맨더진입:::");
		Command cmd = null;		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		
		case MOVE:
			System.out.println("커맨더안에 move를 탐");
			cmd = new Command(request, response);
			break;
			
		case REGISTER :			
			System.out.println("커맨더안에 REGISTER를 탐");
			cmd = new CreateCommand(request, response);
			break;
		case ACCESS :			
			System.out.println("커맨더안에 ACCESS를 탐");
			cmd = new ExistCommand(request, response);
			break;
			
		case SIGNUP :			
			System.out.println("커맨더안에 SIGNUP을 탐");
			cmd = new CreateCommand(request, response);
			break;
			
		
			
		default: System.out.println("디폴트찍힘");
			break;
		}
		System.out.println("커맨더 내: "+Receiver.cmd.getView());
		return cmd;
	}
}
