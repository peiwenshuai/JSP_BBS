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
		final String SQL = "SELECT * FROM user_info WHERE user_id=?, user_pwd=?";

		try {
			connection = DBConnection.getDbConnection();
			pstm = connection.prepareStatement(SQL);
			pstm.setString(1, userId);
			pstm.setString(2, userPwd);
			rs = pstm.executeQuery();

			if (rs.next()) {
				isLoginSuccess = true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return isLoginSuccess;

	}

}
