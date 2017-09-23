package model;

import java.util.List;

import org.json.simple.JSONObject;

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

	public List<BoardInfoBean> getBoardContent(int pageIndex, int boardContentCnt) {
		return boardInfoDao.getBoardContent(pageIndex, boardContentCnt);
	}
	
	public JSONObject getBoardContent(int boardIdx){
		BoardInfoBean boardInfoBean = boardInfoDao.getBoardContent(boardIdx);
		JSONObject boardJsonObj = null;
		if(boardInfoBean != null){		
			boardJsonObj = new JSONObject();
			boardJsonObj.put("boardIdx", boardInfoBean.getBoardIdx());
			boardJsonObj.put("boardContent", boardInfoBean.getBoardContent());
			boardJsonObj.put("boardRegiDate", boardInfoBean.getBoardRegiDate().toString());
			boardJsonObj.put("boardTitle", boardInfoBean.getBoardTitle());
			boardJsonObj.put("userId", boardInfoBean.getUserId());
			boardJsonObj.put("userIdx", boardInfoBean.getUserIdx());
			boardJsonObj.put("viewCnt", boardInfoBean.getViewCnt());
			incrementBoardViewCount(boardIdx, boardInfoBean.getViewCnt());
		}
				
		return boardJsonObj;
	}
	
	public int getBoardCount(){
		return boardInfoDao.getBoardContentCount();
	}
	
	private void incrementBoardViewCount(int boardIdx, int viewCnt){
		boardInfoDao.incrementBoardContentViewCount(boardIdx, viewCnt);		
	}

}
