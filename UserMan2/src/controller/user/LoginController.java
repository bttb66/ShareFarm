package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.DispatcherServlet;
import model.service.UserManager;
import model.dao.UserDAO;

public class LoginController implements Controller {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		
		try {
			// 모델에 로그인 처리를 위임
			UserManager manager = UserManager.getInstance();
			boolean a = manager.login(userId, passwd);

			logger.info("a:{}", a);
	        logger.info("success userId:{}, passwd:{}", userId, passwd);
	
			// 세션에 사용자 이이디 저장
			HttpSession session = request.getSession();
            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, userId);
            
            return "redirect:/user/list";			
		} catch (Exception e) {
			/* UserNotFoundException이나 PasswordMismatchException 발생 시
			 * 다시 login form을 사용자에게 전송하고 오류 메세지도 출력
			 */
	        logger.info("userId:{}, passwd:{}", userId, passwd);
	        logger.info("fail login:{}", e);
            request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
            return "/member/loginForm.jsp";			
		}	
		
        /*UserDAO userDao = new UserDAO();
        User user = userDao.findByUserId(userId);
        if (user == null) {
            req.setAttribute("loginFailed", true);
            return "/user/login.jsp";
        }
        if (user.matchPassword(password)) {
            HttpSession session = req.getSession();
            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, user);
            return "redirect:/";
        } else {
            req.setAttribute("loginFailed", true);
            return "/user/login.jsp";
        }*/
    }
}
