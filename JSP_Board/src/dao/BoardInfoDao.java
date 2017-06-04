package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.BoardInfoBean;
import bean.UserInfoBean;
import db.DBConnection;

public class BoardInfoDao {
	
	private PreparedStatement pstm = null;
	private Connection connection = null;
	private ResultSet rs = null;
	
	public int saveBoardContent(BoardInfoBean boardInfoBean, String title, String content){
		final String SQL = "INSERT INTO bbs_info(user_idx, user_id, board_regi_date, board_title, board_content, view_cnt) VALUES(?,?,now(),?,?,?)";
		int isSQL = 0;
		try {
		connection = DBConnection.getDbConnection();
		pstm = connection.prepareStatement(SQL);
		pstm.setInt(1, boardInfoBean.getUserIdx());
		pstm.setString(2, boardInfoBean.getUserId());
		pstm.setString(3, boardInfoBean.getBoardTitle());
		pstm.setString(4, boardInfoBean.getBoardContent());
		pstm.setInt(5, boardInfoBean.getViewCnt());
		isSQL = pstm.executeUpdate();
		
		connection.close();
	} catch (Exception e) {
		e.printStackTrace();
		return 0;
	}
	return isSQL;
		
	}
}
