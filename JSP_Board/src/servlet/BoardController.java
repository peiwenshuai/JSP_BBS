package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

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
	private final int PER_PAGE_DISPLAY_CONTENT = 10;
	private HttpSession session = null;
	private RequestDispatcher dis = null;
	private String requestSevletName = null;
	private PrintWriter pw = null;

	public BoardController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		requestSevletName = UrlSplitHelper.getDoUrl(request.getRequestURL().toString());
		session = request.getSession();
		int pageIndex = 1;
		BoardModel boardModel = new BoardModel();
		UserInfoBean userInfoBean = (UserInfoBean) session.getAttribute("userInfoBean");

		switch (requestSevletName) {
		case "board_main.do":
			// Read(List)
			if (request.getParameter("pageIndex") != null) {
				pageIndex = Integer.valueOf(request.getParameter("pageIndex"));
			}
			int boardContentCnt = boardModel.getBoardCount();
			List<BoardInfoBean> boardInfoBeanList = boardModel.getBoardContent(pageIndex, boardContentCnt);
			int paginationLinkCnt = 0;
			if (boardContentCnt % PER_PAGE_DISPLAY_CONTENT == 0) {
				paginationLinkCnt = (boardContentCnt / PER_PAGE_DISPLAY_CONTENT);
			} else {
				paginationLinkCnt = (boardContentCnt / PER_PAGE_DISPLAY_CONTENT) + 1;
			}
			request.setAttribute("boardInfoBeanList", boardInfoBeanList);
			request.setAttribute("linkPage", paginationLinkCnt);
			request.setAttribute("pageIndex", pageIndex);
			request.setAttribute("nextPageIndex", pageIndex == paginationLinkCnt ? pageIndex : pageIndex + 1);
			request.setAttribute("prevPageIndex", pageIndex == 1 ? pageIndex : pageIndex - 1);
			RequestDispatcher dis = request.getRequestDispatcher("/bbs/bbs_main.jsp");
			dis.forward(request, response);
			break;

		case "board_write.do":
			// Create
			int isSQL = boardModel.saveBoardContent(userInfoBean, request.getParameter("title"),	request.getParameter("content"));
			if (isSQL != 0) {
				response.sendRedirect("../boardController/board_main.do");
			}
			break;
			
		case "board_content_read.do" : 
			int boardIdx = Integer.valueOf(request.getParameter("boardIdx"));
			JSONObject jsonObject = boardModel.getBoardContent(boardIdx);
			response.setContentType("application/json");
			pw = response.getWriter();
			pw.print(jsonObject);
			break;
			
		case "board_content_delete.do":
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
