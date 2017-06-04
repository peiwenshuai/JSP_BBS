package model;

import java.time.LocalDate;

import bean.BoardInfoBean;
import bean.UserInfoBean;
import dao.BoardInfoDao;

public class BoardModel {
	
	private BoardInfoDao boardInfoDao = new BoardInfoDao();
	
	public int saveBoardContent(UserInfoBean userInfoBean, String title, String content){
		
		BoardInfoBean boardInfoBean = new BoardInfoBean();
		boardInfoBean.setUserIdx(userInfoBean.getUserIdx());
		boardInfoBean.setUserId(userInfoBean.getUserId());
		boardInfoBean.setBoardTitle(title);
		boardInfoBean.setBoardContent(content);
		boardInfoBean.setViewCnt(0);
		
		return boardInfoDao.saveBoardContent(boardInfoBean, title, content);
	}

}
