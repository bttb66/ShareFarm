package controller.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.farm.ApplyFarmController;
import controller.user.UserSessionUtils;
import model.Community;
import model.service.CommunityManager;

public class UpdatePostController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(ApplyFarmController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		CommunityManager manager = CommunityManager.getInstance();
		int postId = Integer.parseInt(request.getParameter("postId"));
		
		if(request.getMethod().equals("GET")){
			String userId = request.getParameter("userId");
			String curUserId = UserSessionUtils.getUserFromSession(request.getSession());
			Community comm = manager.findPost(postId);
			if (curUserId != null && curUserId.equals(comm.getUserId()) == false) {
				// 삭제하려는 id와 login id가 다를 경우 사용자 보기 화면으로 오류 메세지를 전달
			    request.setAttribute("updateFailed", true);
				request.setAttribute("exception", 
						new IllegalStateException("다른 사용자의 게시글을 수정할 수 없습니다."));            
				return "/community/list";		// 사용자 보기 화면으로 이동 (forwarding)
		    }
			
			request.setAttribute("post", comm);
			request.setAttribute("currentPage", request.getParameter("currentpage"));
			return "/community/update.jsp";
		}
		
		Community community = new Community(
				postId,
				request.getParameter("content"),
				request.getParameter("userId"),
				request.getParameter("title"));
		
		manager.update(community);
		request.setAttribute("postId", postId);
		request.setAttribute("currentPage", request.getParameter("currentpage"));
		return "/community/detail";
	}
	
}
