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

/**
 * Servlet implementation class Controller
 */
@WebServlet("/loginController/*")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Call loginContoroller..");
		request.setCharacterEncoding("UTF-8");
		String servletName = UrlSplitHelper.getDoUrl(request.getRequestURL().toString());
		session = request.getSession();
		PrintWriter pw = response.getWriter();
		LoginModel loginModel = new LoginModel();
		UserInfoBean userInfoBean = new UserInfoBean();

		if (session.getAttribute("userId") != null) {
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
			if (loginModel.processLogin(request.getParameter("userId"), request.getParameter("userPwd"))) {
				session.setAttribute("userId", request.getParameter("userId"));
				response.sendRedirect("../boardController/board_main.do");
			} else {
				response.sendRedirect("../login_fail.jsp");
			}
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
