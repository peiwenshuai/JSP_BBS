package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginModel;
import util.UrlSplitHelper;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/loginController/*")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		String servletName = UrlSplitHelper.getDoUrl(request.getRequestURL().toString());

		switch (servletName) {
		case "login.do":
			LoginModel loginModel = new LoginModel();
			if(loginModel.processLogin(request.getParameter("userId"), request.getParameter("userPwd"))){
				
			}else{
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
