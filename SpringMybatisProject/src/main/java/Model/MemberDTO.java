package Model;

import java.util.Date;

public class MemberDTO {
	String memId;
	String memPw;
	String memPwCon;
	String memName;
	String postNumber;
	String memAddress;
	String detailAdd;
	String memPhone;
	String memEmail;
	Date memBirth;
	String memGender;
	String memAccount;
	String memEmailCk;
	String ckok;

	
	StartEndPageDTO startEndPageDTO;
	public StartEndPageDTO getStartEndPageDTO() {
		return startEndPageDTO;
	}
	public void setStartEndPageDTO(StartEndPageDTO startEndPageDTO) {
		this.startEndPageDTO = startEndPageDTO;
	}
	
	
	
	public String getCkok() {
		return ckok;
	}
	public void setCkok(String ckok) {
		this.ckok = ckok;
	}
	public String getMemPwCon() {
		return memPwCon;
	}
	public void setMemPwCon(String memPwCon) {
		this.memPwCon = memPwCon;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(String postNumber) {
		this.postNumber = postNumber;
	}
	public String getMemAddress() {
		return memAddress;
	}
	public void setMemAddress(String memAddress) {
		this.memAddress = memAddress;
	}
	public String getDetailAdd() {
		return detailAdd;
	}
	public void setDetailAdd(String detailAdd) {
		this.detailAdd = detailAdd;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public Date getMemBirth() {
		return memBirth;
	}
	public void setMemBirth(Date memBirth) {
		this.memBirth = memBirth;
	}
	public String getMemGender() {
		return memGender;
	}
	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}
	public String getMemAccount() {
		return memAccount;
	}
	public void setMemAccount(String memAccount) {
		this.memAccount = memAccount;
	}
	public String getMemEmailCk() {
		return memEmailCk;
	}
	public void setMemEmailCk(String memEmailCk) {
		this.memEmailCk = memEmailCk;
	}
	
	
}
