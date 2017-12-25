package controller.community;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.farm.ApplyFarmController;
import controller.user.UserSessionUtils;
import model.Comment;
import model.Community;
import model.service.CommunityManager;

public class ViewPostController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(ApplyFarmController.class);
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		CommunityManager manager = CommunityManager.getInstance();
		
		int postId = Integer.parseInt(request.getParameter("postId"));
		Community comm = manager.findPost(postId);
		request.setAttribute("post", comm);
		manager.viewPost(postId);
		
		String curUserId = null;
		curUserId = UserSessionUtils.getUserFromSession(request.getSession());
		
		if(curUserId == null) curUserId = "";
		
		request.setAttribute("curUserId", curUserId);
		log.debug("curUser {}: ", curUserId);
		log.debug("writer {}: ", comm.getUserId());
		log.debug("equeal {}: ", curUserId.equals(comm.getUserId()));
		List<Comment> comments = manager.findComments(postId);
		request.setAttribute("comments", comments);
		request.setAttribute("currentPage", request.getParameter("currentPage"));
		return "/community/detail.jsp";
	}

}
