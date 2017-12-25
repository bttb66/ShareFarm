package controller.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Comment;
import model.service.CommunityManager;

public class WriteCommentController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		if (!UserSessionUtils.isLogined(request.getSession())) {
            return "redirect:/user/login/form";		// login form 요청으로 redirect
        }
		int postId = Integer.parseInt(request.getParameter("postId"));
		String userId = UserSessionUtils.getUserFromSession(request.getSession());
		CommunityManager manager = CommunityManager.getInstance();
		Comment comment = new Comment(
				1,
				request.getParameter("content"),
				userId,
				postId);
		manager.createComment(comment);
		
		request.setAttribute("postId", postId);
		request.setAttribute("currentPage", request.getParameter("currentPage"));
		return "/community/detail";
	}
}
