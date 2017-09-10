package model;

import java.util.List;

import bean.BoardInfoBean;
import bean.UserInfoBean;
import dao.BoardInfoDao;

public class BoardModel {

	private BoardInfoDao boardInfoDao = new BoardInfoDao();

	public int saveBoardContent(UserInfoBean userInfoBean, String title, String content) {

		BoardInfoBean boardInfoBean = new BoardInfoBean();
		boardInfoBean.setUserIdx(userInfoBean.getUserIdx());
		boardInfoBean.setUserId(userInfoBean.getUserId());
		boardInfoBean.setBoardTitle(title);
		boardInfoBean.setBoardContent(content);
		boardInfoBean.setViewCnt(0);

		return boardInfoDao.saveBoardContent(boardInfoBean, title, content);
	}

	public List<BoardInfoBean> getBoardContent(int pageIndex) {

		return boardInfoDao.getBoardContent(pageIndex);
	}
	
	public int getBoardCount(){
		return boardInfoDao.getBoardContentCount();
	}

}
