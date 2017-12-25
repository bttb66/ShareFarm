package controller.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.service.CommunityManager;

public class DeletePostController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		String curUserId = UserSessionUtils.getUserFromSession(request.getSession());
		
		if (curUserId != null && curUserId.equals(userId) == false) {
			// 삭제하려는 id와 login id가 다를 경우 사용자 보기 화면으로 오류 메세지를 전달
		    request.setAttribute("deleteFailed", true);
			request.setAttribute("exception", 
					new IllegalStateException("다른 사용자의 게시글을 삭제할 수 없습니다."));            
			return "/community/list";		// 사용자 보기 화면으로 이동 (forwarding)
	    }
		
		CommunityManager manager = CommunityManager.getInstance();
		int postId = Integer.parseInt(request.getParameter("postId"));
		manager.remove(postId);
		request.setAttribute("currentPage", request.getParameter("currentPage"));
		return "/community/list";
	}

}
