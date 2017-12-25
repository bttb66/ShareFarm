package controller.apply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ApplyManager;

public class CancelApplyController implements Controller{

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
      int applyId = Integer.parseInt(request.getParameter("applyId"));
      ApplyManager manager = ApplyManager.getInstance();
      manager.acceptApply(applyId, false);

      if(request.getParameter("kind").equals("farm"))
    	  return "/apply/farmList";
      
      return "/apply/machineList";
   }
   
}