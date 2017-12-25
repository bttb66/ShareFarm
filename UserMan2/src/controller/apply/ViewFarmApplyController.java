package controller.apply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.farm.ViewFarmController;
import controller.user.UserSessionUtils;
import model.Apply;
import model.service.ApplyManager;

public class ViewFarmApplyController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(ViewFarmApplyController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if (!UserSessionUtils.isLogined(request.getSession())) {
            return "redirect:/user/login/form";		// login form 요청으로 redirect
        }
		String userId = UserSessionUtils.getUserFromSession(request.getSession());
		ApplyManager manager = ApplyManager.getInstance();
		List<Apply> appliedList = manager.findFarmAppliedList(userId);
		log.debug("appliedList {} : " , appliedList);
		
		List<Apply> myApplyList = manager.findMyFarmApplyList(userId);
		log.debug("myApplyList {} : " , myApplyList);
		List<Apply> completeList = manager.findCompleteFarmAppliedList(userId);
		request.setAttribute("appliedList", appliedList);
		request.setAttribute("myApplyList", myApplyList);
		request.setAttribute("completeList", completeList);
		return "/farmApplyList.jsp";
	}

}
