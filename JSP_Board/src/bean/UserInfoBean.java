package bean;

import java.time.LocalDate;

public class UserInfoBean {

	private int userIdx;
	private String userId;
	private String userPwd;
	private String userName;
	private int userAge;
	private String userGender;
	private LocalDate userRegiDate;

	public int getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public LocalDate getUserRegiDate() {
		return userRegiDate;
	}

	public void setUserRegiDate(LocalDate userRegiDate) {
		this.userRegiDate = userRegiDate;
	}
	
	@Override
	public String toString() {
		return "UserBean [userIdx=" + userIdx + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", userAge=" + userAge + ", userGender=" + userGender + ", userRegiDate=" + userRegiDate + "]";
	}

}
