package controller.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Community;
import model.service.CommunityManager;

public class WritePostController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		if (request.getMethod().equals("GET")) {
			//login 여부 확인
			if (!UserSessionUtils.isLogined(request.getSession())) {
	            return "redirect:/user/login/form";		// login form 요청으로 redirect
	        }
			return "/community/write.jsp";
		}
		
		CommunityManager manager = CommunityManager.getInstance();
		String userId = UserSessionUtils.getUserFromSession(request.getSession());
		Community community = new Community(
				1,
				request.getParameter("content"),
				userId,
				request.getParameter("title"));
		manager.create(community);
		return "";
	}

}
