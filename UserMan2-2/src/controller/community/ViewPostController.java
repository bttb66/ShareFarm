package controller.community;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Comment;
import model.Community;
import model.service.CommunityManager;

public class ViewPostController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		CommunityManager manager = CommunityManager.getInstance();
		
		int postId = Integer.parseInt(request.getParameter("postId"));
		Community comm = manager.findPost(postId);
		request.setAttribute("post", comm);
		manager.viewPost(postId);
		
		List<Comment> comments = manager.findComments(postId);
		request.setAttribute("comments", comments);
		
		return "/community/detail.jsp";
	}

}
