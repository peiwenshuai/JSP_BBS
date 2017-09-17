package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserInfoBean;
import model.LoginModel;
import util.UrlSplitHelper;

@WebServlet("/loginController/*")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session = null;
	private RequestDispatcher dis = null;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String servletName = UrlSplitHelper.getDoUrl(request.getRequestURL().toString());
		session = request.getSession();
		PrintWriter pw = response.getWriter();
		LoginModel loginModel = new LoginModel();
		UserInfoBean userInfoBean = new UserInfoBean();

		if (session.getAttribute("userInfoBean") != null) {
			response.sendRedirect("../boardController/board_main.do");
			return;
		}

		switch (servletName) {

		case "login_view.do":
			response.sendRedirect("../login.jsp");
			break;

		case "user_id_check.do":
			userInfoBean.setUserId(request.getParameter("userId"));
			if (loginModel.processCheckId(userInfoBean)) {
				pw.print(true);
			}
			break;

		case "user_register.do":
			userInfoBean.setUserId(request.getParameter("userId"));
			userInfoBean.setUserPwd(request.getParameter("userPwd"));
			userInfoBean.setUserName(request.getParameter("userName"));
			userInfoBean.setUserAge(Integer.valueOf(request.getParameter("userAge")));
			userInfoBean.setUserGender(request.getParameter("userGender"));
			loginModel.processUserRegi(userInfoBean);
			break;

		case "login.do":
			UserInfoBean loginUserInfoBean = loginModel.processLogin(request.getParameter("userId"), request.getParameter("userPwd"));
			if (loginUserInfoBean != null) {
				session.setAttribute("userInfoBean", loginUserInfoBean);
				response.sendRedirect("../boardController/board_main.do");
			} else {
				response.sendRedirect("../login_fail.jsp");
			}
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
