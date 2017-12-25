package controller.farm;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Apply;
import model.Farm;
import model.User;
import model.service.ApplyManager;
import model.service.FarmManager;
import model.service.UserManager;

public class ApplyFarmController implements Controller{
   private static final Logger log = LoggerFactory.getLogger(ApplyFarmController.class);
   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
      if(request.getMethod().equals("GET")){
         if (!UserSessionUtils.isLogined(request.getSession())) {
               return "redirect:/user/login/form";      // login form 요청으로 redirect
           }
         String curUserId = UserSessionUtils.getUserFromSession(request.getSession());
         int farmId = Integer.parseInt(request.getParameter("farmId"));
         
         if(curUserId.equals(request.getParameter("host"))){
	        	request.setAttribute("msg", "fail");
	    		request.setAttribute("machineId", farmId);
	    		return "/machine/detail";
	        }
         
         FarmManager manager = FarmManager.getInstance();
         log.debug("farmId {}: ", farmId);
         Farm farm = manager.findDetailFarmList(farmId);
         
         UserManager userManager = UserManager.getInstance();
         User user = userManager.findUser(farm.getUserId());
         request.setAttribute("farm", farm);
         request.setAttribute("host", user);
         return "/farm/apply.jsp";
      }
         
      ApplyManager manager = ApplyManager.getInstance();
      String userId = UserSessionUtils.getUserFromSession(request.getSession());
      int farmId = Integer.parseInt(request.getParameter("farmId"));
      String farmName = request.getParameter("farmName");
      Apply apply = new Apply(
            1,
            1,
            farmId,
            userId,
            0,
            Date.valueOf(request.getParameter("startDate")),
            Date.valueOf(request.getParameter("endDate")),
            farmName
            );
      manager.applyFarm(apply);
      
      request.setAttribute("msg", "success");
      request.setAttribute("farmId", farmId);
      return "/farm/detail";
   }
   
}