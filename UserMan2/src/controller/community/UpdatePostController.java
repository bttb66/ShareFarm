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
				// �����Ϸ��� id�� login id�� �ٸ� ��� ����� ���� ȭ������ ���� �޼����� ����
			    request.setAttribute("updateFailed", true);
				request.setAttribute("exception", 
						new IllegalStateException("�ٸ� ������� �Խñ��� ������ �� �����ϴ�."));            
				return "/community/list";		// ����� ���� ȭ������ �̵� (forwarding)
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
