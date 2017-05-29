package model;

import bean.UserInfoBean;
import dao.UserInfoDao;

public class LoginModel {
	
	private UserInfoDao userInfoDao = new UserInfoDao();
	
	public boolean processLogin(String userId, String userPwd){
		return userInfoDao.processUserLogin(userId, userPwd);
	}
	
	public void processUserRegi(UserInfoBean userInfoBean){
		userInfoDao.processUserReg(userInfoBean);
	}
	
	public boolean processCheckId(UserInfoBean userInfoBean){
		return userInfoDao.processUserCheckId(userInfoBean);
	}

}
