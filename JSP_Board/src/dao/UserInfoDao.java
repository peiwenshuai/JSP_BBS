package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import bean.UserInfoBean;
import db.DBConnection;

public class UserInfoDao {

	private PreparedStatement pstm = null;
	private Connection connection = null;
	private ResultSet rs = null;

	public UserInfoBean processUserLogin(String userId, String userPwd) {
		final String SQL = "SELECT * FROM user_info WHERE user_id=? AND user_pwd=?";
		UserInfoBean userInfoBean = null;
		try {
			connection = DBConnection.getDbConnection();
			pstm = connection.prepareStatement(SQL);
			pstm.setString(1, userId);
			pstm.setString(2, userPwd);
			rs = pstm.executeQuery();

			while (rs.next()) {
				userInfoBean = new UserInfoBean();
				userInfoBean.setUserIdx(rs.getInt(1));
				userInfoBean.setUserId(rs.getString(2));
				userInfoBean.setUserPwd(rs.getString(3));
				userInfoBean.setUserName(rs.getString(4));
				userInfoBean.setUserAge(rs.getInt(5));
				userInfoBean.setUserGender(rs.getString(6));
				userInfoBean.setUserRegiDate(rs.getDate(7).toLocalDate());
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return userInfoBean;
	}

	public void processUserReg(UserInfoBean userInfoBean) {
		final String SQL = "INSERT INTO user_info(user_id, user_pwd, user_name, user_age, user_gender, user_regi_date) VALUES (?, ?, ?, ?, ?, now())";
		try {
			connection = DBConnection.getDbConnection();
			pstm = connection.prepareStatement(SQL);
			pstm.setString(1, userInfoBean.getUserId());
			pstm.setString(2, userInfoBean.getUserPwd());
			pstm.setString(3, userInfoBean.getUserName());
			pstm.setInt(4, userInfoBean.getUserAge());
			pstm.setString(5, userInfoBean.getUserGender());
			pstm.executeQuery();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean processUserCheckId(UserInfoBean userInfoBean) {
		final String SQL = "SELECT * FROM user_info WHERE user_id=?";
		try {
			connection = DBConnection.getDbConnection();
			pstm = connection.prepareStatement(SQL);
			pstm.setString(1, userInfoBean.getUserId());
			rs = pstm.executeQuery();
			connection.close();
			if (rs != null && rs.next()) {
				return true; // Id가 존재시, true
			}
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}

		return false;
	}

}
