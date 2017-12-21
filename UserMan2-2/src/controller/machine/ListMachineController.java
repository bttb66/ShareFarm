package controller.machine;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Machine;
import model.service.MachineManager;

public class ListMachineController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		MachineManager manager = MachineManager.getInstance();
		List<Machine> list = manager.findTotalMachineList();
		request.setAttribute("machineList", list);
		return "/rental/list.jsp";
	}
}
