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
			// �����Ϸ��� id�� login id�� �ٸ� ��� ����� ���� ȭ������ ���� �޼����� ����
		    request.setAttribute("deleteFailed", true);
			request.setAttribute("exception", 
					new IllegalStateException("�ٸ� ������� �Խñ��� ������ �� �����ϴ�."));            
			return "/community/list";		// ����� ���� ȭ������ �̵� (forwarding)
	    }
		
		CommunityManager manager = CommunityManager.getInstance();
		int postId = Integer.parseInt(request.getParameter("postId"));
		manager.remove(postId);
		request.setAttribute("currentPage", request.getParameter("currentPage"));
		return "/community/list";
	}

}
