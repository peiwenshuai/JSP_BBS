package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BoardInfoBean;
import bean.UserInfoBean;
import model.BoardModel;
import util.UrlSplitHelper;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/boardController/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session = null;
	private final int perPage = 10;
	private final int VIEW_PAGE_COUNT = 10;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Call boardContoroller..");
		request.setCharacterEncoding("UTF-8");
		String servletName = UrlSplitHelper.getDoUrl(request.getRequestURL().toString());
		session = request.getSession();
		int pageIndex = 1;

		BoardModel boardModel = new BoardModel();

		switch (servletName) {
		case "board_main.do":
			// Read(Board List)
			if (request.getParameter("pageIndex") != null) {
				pageIndex = Integer.valueOf(request.getParameter("pageIndex"));
			}
			List<BoardInfoBean> boardInfoBeanList = boardModel.getBoardContent(pageIndex);
			int allPageCnt = boardModel.getBoardCount();
			int linkPage = 0;
			if (allPageCnt % perPage == 0) {
				linkPage = (allPageCnt / perPage);
			} else {
				linkPage = (allPageCnt / perPage) + 1;
			}
			request.setAttribute("linkPage", linkPage);
			request.setAttribute("boardInfoBeanList", boardInfoBeanList);
			request.setAttribute("pageIndex", pageIndex);
			request.setAttribute("nextPageIndex", pageIndex == linkPage ? pageIndex:pageIndex+1);
			request.setAttribute("prevPageIndex", pageIndex == 1 ? pageIndex:pageIndex-1);
			RequestDispatcher dis = request.getRequestDispatcher("/bbs/bbs_main.jsp");
			dis.forward(request, response);
			break;
		case "board_write.do":
			// Create
			UserInfoBean userInfoBean = (UserInfoBean) session.getAttribute("userInfoBean");
			int isSQL = boardModel.saveBoardContent(userInfoBean, request.getParameter("title"),
					request.getParameter("content"));
			System.out.println(isSQL);
			if (isSQL != 0) {
				response.sendRedirect("../boardController/board_main.do");
			}
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
