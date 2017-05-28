package model;

import dao.UserInfoDao;

public class LoginModel {
	
	private UserInfoDao userInfoDao = new UserInfoDao();
	
	public boolean processLogin(String userId, String userPwd){
		
		boolean isLoginResult = userInfoDao.processUserLogin(userId, userPwd);
		return isLoginResult;
	}

}
