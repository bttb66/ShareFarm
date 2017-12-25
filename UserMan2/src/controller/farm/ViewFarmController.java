package controller.farm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.user.RegisterUserController;
import model.Farm;
import model.User;
import model.service.ApplyManager;
import model.service.FarmManager;
import model.service.UserManager;

public class ViewFarmController implements Controller{
   private static final Logger log = LoggerFactory.getLogger(ViewFarmController.class);
   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
      int farmId = Integer.parseInt(request.getParameter("farmId"));
      
      FarmManager manager = FarmManager.getInstance();
      log.debug("farmId : ", farmId);
      Farm farm = manager.findDetailFarmList(farmId);
      
      ApplyManager applyManager = ApplyManager.getInstance();
      int isComplete = applyManager.isAppliedFarm(farmId);
      request.setAttribute("isComplete", isComplete);
      log.debug("complete : {}", isComplete);
      
      UserManager userManager = UserManager.getInstance();
      User user = userManager.findUser(farm.getUserId());
      request.setAttribute("farm", farm);
      request.setAttribute("host", user);
      return "/farm/detail.jsp";
   }

}