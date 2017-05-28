package model;

import bean.UserInfoBean;
import dao.UserInfoDao;

public class LoginModel {
	
	private UserInfoDao userInfoDao = new UserInfoDao();
	
	public boolean processLogin(String userId, String userPwd){
		boolean isLoginResult = userInfoDao.processUserLogin(userId, userPwd);
		return isLoginResult;
	}
	
	public void processUserRegi(UserInfoBean userInfoBean){
		userInfoDao.processUserReg(userInfoBean);
	}

}
