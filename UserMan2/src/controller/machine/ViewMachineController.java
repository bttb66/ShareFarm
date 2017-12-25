package controller.machine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.RegisterUserController;
import model.Machine;
import model.User;
import model.service.UserManager;
import model.service.ApplyManager;
import model.service.MachineManager;

public class ViewMachineController implements Controller{

     private static final Logger log = LoggerFactory.getLogger(ViewMachineController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int machineId = Integer.parseInt(request.getParameter("machineId"));
		MachineManager manager = MachineManager.getInstance();
         log.debug("machineId : ", machineId);
		
         Machine machine = manager.findDetailMachine(machineId);
        ApplyManager applyManager = ApplyManager.getInstance();
        int isComplete = applyManager.isAppliedMachine(machineId);
        request.setAttribute("isComplete", isComplete);
        
        UserManager userManager = UserManager.getInstance();
        User user = userManager.findUser(machine.getUserId());
        request.setAttribute("machine", machine);
        request.setAttribute("host", user);
		return "/rental/detail.jsp";
	}

}
