package controller.farm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Farm;
import model.service.ExistingUserException;
import model.service.FarmManager;

public class RegistFarmController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegistFarmController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	if(request.getMethod().equals("GET")){
    		if (!UserSessionUtils.isLogined(request.getSession())) {
                return "redirect:/user/login/form";      // login form ��û���� redirect
            }
          return "/farm/register.jsp";
    	}

    	String curUserId = UserSessionUtils.getUserFromSession(request.getSession());
		Farm farm = new Farm(
				1,
				curUserId,
			request.getParameter("name"),
			request.getParameter("location"),
			request.getParameter("farming"),
			Integer.parseInt(request.getParameter("area")),
			request.getParameter("detail"),
			Integer.parseInt(request.getParameter("price")));
        	log.debug("Regist Farm : {}", farm);
		try {
			FarmManager manager = FarmManager.getInstance();
			manager.registFarm(farm);
	        return "redirect:/farm/list";		// ���� �� ����� ����Ʈ ȭ������ redirect
	        
		} catch (ExistingUserException e) {		// ���� �߻� �� ȸ������ form���� f

	        log.debug("Fail Regist Farm : {}", farm);
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("farm", farm);
			return "/farm/registerForm.jsp";
		}
    }
}
