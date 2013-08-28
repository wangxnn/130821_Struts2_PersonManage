package cn.wxn.domain;

import java.io.File;
import java.util.Date;

public class PersonAdd {
	private String userID;

	private String userName;
	private String loginName;
	private String loginPwd;
	private String sex;
	private Date birthday;
	private String education;
	private String telephone;
	private String interest;
	private String remark;

	private File uploadfile;
	private String uploadfileContentType;
	private String uploadfileFileName;
	
	
	public File getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getUploadfileContentType() {
		return uploadfileContentType;
	}
	public void setUploadfileContentType(String uploadfileContentType) {
		this.uploadfileContentType = uploadfileContentType;
	}
	public String getUploadfileFileName() {
		return uploadfileFileName;
	}
	public void setUploadfileFileName(String uploadfileFileName) {
		this.uploadfileFileName = uploadfileFileName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	@Override
	public String toString() {
		return "PersonAdd [userName=" + userName + ", loginName=" + loginName
				+ ", loginPwd=" + loginPwd + ", sex=" + sex + ", birthday="
				+ birthday + ", education=" + education + ", telephone="
				+ telephone + ", interest=" + interest + ", remark=" + remark
				+ ", uploadfile=" + uploadfile + ", uploadfileContentType="
				+ uploadfileContentType + ", uploadfileFileName="
				+ uploadfileFileName + "]";
	}
	
	
	
}
