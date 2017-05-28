package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.UserInfoBean;
import db.DBConnection;

public class UserInfoDao {

	private PreparedStatement pstm = null;
	private Connection connection = null;
	private ResultSet rs = null;
	private boolean isLoginSuccess = false;

	public boolean processUserLogin(String userId, String userPwd) {
		final String SQL = "SELECT * FROM user_info WHERE user_id=? AND user_pwd=?";
		try {
			connection = DBConnection.getDbConnection();
			pstm = connection.prepareStatement(SQL);
			pstm.setString(1, userId);
			pstm.setString(2, userPwd);
			rs = pstm.executeQuery();

			if (rs.next()) {
				isLoginSuccess = true;
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}
		return isLoginSuccess;
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

}
