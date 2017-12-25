package controller.community;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.user.UserSessionUtils;
import model.Community;
import model.service.CommunityManager;

public class ListPostController implements Controller{
	private static final int countPerPage = 20;	// 한 화면에 출력할 사용자 수
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		String currentPageStr = req.getParameter("currentPage");	
		int currentPage = 1;
		if (currentPageStr != null && !currentPageStr.equals("")) {
			currentPage = Integer.parseInt(currentPageStr);
		}
		/*String content = req.getAttribute("content").toString().trim();
		String title = req.getAttribute("title").toString().trim();
		
		if(content.length() == 0 && title)*/
		CommunityManager manager = CommunityManager.getInstance();
		List<Community> list = manager.findPosts(currentPage, countPerPage);
		int totalPage = (int)Math.ceil(list.size()/countPerPage);
		req.setAttribute("list", list);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("currentPage", currentPage);
//		req.setAttribute("curUserId", 
//				UserSessionUtils.getUserFromSession(req.getSession()));	
		return "/community/list.jsp";
	}
	
}
