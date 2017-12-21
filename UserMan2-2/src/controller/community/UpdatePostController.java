package controller.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Community;
import model.service.CommunityManager;

public class UpdatePostController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		CommunityManager manager = CommunityManager.getInstance();
		
		if(request.getMethod().equals("GET")){
			String userId = request.getParameter("userId");
			String curUserId = UserSessionUtils.getUserFromSession(request.getSession());

			if (curUserId != null && curUserId.equals(userId) == false) {
				// �����Ϸ��� id�� login id�� �ٸ� ��� ����� ���� ȭ������ ���� �޼����� ����
			    request.setAttribute("updateFailed", true);
				request.setAttribute("exception", 
						new IllegalStateException("�ٸ� ������� �Խñ��� ������ �� �����ϴ�."));            
				return "/community/list";		// ����� ���� ȭ������ �̵� (forwarding)
		    }
			
			
		}
		int postId = Integer.parseInt(request.getParameter("postId"));
		Community community = new Community(
				postId,
				request.getParameter("content"),
				request.getParameter("userId"),
				request.getParameter("title"));
		manager.update(community);
		request.setAttribute("postId", postId);
		
		return "/community/detail";
	}
	
}
