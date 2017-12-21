package controller.machine;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Apply;
import model.Machine;
import model.User;
import model.service.MachineManager;
import model.service.UserManager;
import model.service.ApplyManager;

public class ApplyMachineController implements Controller{
    private static final Logger log = LoggerFactory.getLogger(ApplyMachineController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
    if(request.getMethod().equals("GET")){
        if (!UserSessionUtils.isLogined(request.getSession())) {
            return "redirect:/user/login/form";		// login form 요청으로 redirect
        }
        int machineId = Integer.parseInt(request.getParameter("machineId"));
        MachineManager manager = MachineManager.getInstance();
        log.debug("machineId {}: ", machineId);
        Machine machine = manager.findDetailMachine(machineId);
        
        UserManager userManager = UserManager.getInstance();
        User user = userManager.findUser(machine.getUserId());
        request.setAttribute("machine", machine);
        request.setAttribute("host", user);
        return "/rental/apply.jsp";
        
    }
		
		ApplyManager manager = ApplyManager.getInstance();
		String userId = UserSessionUtils.getUserFromSession(request.getSession());
		int machineId = Integer.parseInt(request.getParameter("machineId"));
		 String machineName = request.getParameter("machineName");
		Apply apply = new Apply(
				1,
				machineId,
				1,
				userId,
				0,
				(Date)request.getAttribute("startDate"),
				(Date)request.getAttribute("endDate"),
                machineName
                );
		manager.applyMachine(apply);   //applyfarm changename
		
		request.setAttribute("msg", "success");
		request.setAttribute("machineId", machineId);
		return "/machine/detail";
	}
	
}
