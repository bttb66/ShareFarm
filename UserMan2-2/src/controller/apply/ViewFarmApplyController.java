package controller.apply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Apply;
import model.service.ApplyManager;

public class ViewFarmApplyController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if (!UserSessionUtils.isLogined(request.getSession())) {
            return "redirect:/user/login/form";		// login form 요청으로 redirect
        }
		String userId = UserSessionUtils.getUserFromSession(request.getSession());
		ApplyManager manager = ApplyManager.getInstance();
		List<Apply> appliedList = manager.findFarmAppliedList(userId);
		List<Apply> myApplyList = manager.findMyFarmApplyList(userId);
		List<Apply> completeList = manager.findCompleteFarmAppliedList(userId);
		request.setAttribute("appliedList", appliedList);
		request.setAttribute("myApplyList", myApplyList);
		request.setAttribute("completeList", completeList);
		return "/farmApplyList.jsp";
	}

}
