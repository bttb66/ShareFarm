package controller.machine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Machine;
import model.service.ExistingUserException;
import model.service.MachineManager;

public class RegistMachineController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(RegistMachineController.class);
	
	// '/machine/regist'
	
	@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getMethod().equals("GET")){
            if (!UserSessionUtils.isLogined(request.getSession())) {
                return "redirect:/user/login/form";      // login form √∏?∞‚àö¬™¬ø?àè?àë≈í redirect
            }
            return "/rental/register.jsp";
        }
        
        String curUserId = UserSessionUtils.getUserFromSession(request.getSession());
        Machine machine = new Machine(
                                      1,
			request.getParameter("name"),
            request.getParameter("location"),
            Integer.parseInt(request.getParameter("price")),
            Integer.parseInt(request.getParameter("rentCount")),
            curUserId,
            request.getParameter("detail"));
            //?ó∞?ùΩÏ≤?, ?ÉÅ?Ñ∏?Ñ§Î™?
		
        log.debug("Regist Machine : {}", machine);

		try {
			MachineManager manager = MachineManager.getInstance();
			manager.registMachine(machine);
	        return "redirect:/machine/list";
	        
		} catch (ExistingUserException e) {		
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("machine", machine);
			return "/rental/registerForm.jsp";
		}
    }
}
