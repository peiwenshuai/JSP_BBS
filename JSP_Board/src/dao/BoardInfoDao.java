package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bean.BoardInfoBean;
import bean.UserInfoBean;
import db.DBConnection;

public class BoardInfoDao {

	private PreparedStatement pstm = null;
	private Connection connection = null;
	private ResultSet rs = null;

	public int saveBoardContent(BoardInfoBean boardInfoBean, String title, String content) {
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

	public List<BoardInfoBean> getBoardContent(int pageIndex) {
		int startRow = (pageIndex * 10) - 10;
		
		final String SQL = "SELECT * FROM bbs_info ORDER BY board_idx DESC LIMIT " + startRow + ", 10";
		List<BoardInfoBean> boardInfoBeanList = new ArrayList<>();
		try {
			connection = DBConnection.getDbConnection();
			pstm = connection.prepareStatement(SQL);
			rs = pstm.executeQuery(SQL);

			while (rs.next()) {
				BoardInfoBean boardInfoBean = new BoardInfoBean();
				boardInfoBean.setBoardIdx(rs.getInt(1));
				boardInfoBean.setUserIdx(rs.getInt(2));
				boardInfoBean.setUserId(rs.getString(3));
				boardInfoBean.setBoardRegiDate(rs.getDate(4).toLocalDate());
				boardInfoBean.setBoardTitle(rs.getString(5));
				boardInfoBean.setBoardContent(rs.getString(6));
				boardInfoBean.setViewCnt(rs.getInt(7));
				boardInfoBeanList.add(boardInfoBean);
			}

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return boardInfoBeanList;

	}

	public int getBoardContentCount() {
		final String SQL = "SELECT COUNT(board_idx) FROM bbs_info";
		int boardCountNum = 0;
		try {
			connection = DBConnection.getDbConnection();
			pstm = connection.prepareStatement(SQL);
			rs = pstm.executeQuery();
			connection.close();
			if (rs.next()) {
				boardCountNum = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return boardCountNum;

	}

}
