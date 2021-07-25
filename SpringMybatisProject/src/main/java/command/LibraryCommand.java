package command;

import org.springframework.web.multipart.MultipartFile;

public class LibraryCommand {
	
	String noticeNo;
	String noticeSub;
	String noticeCon;
	String noticeDate;
	String noticeKind;
	String noticeCount;
	String employeeId;
	MultipartFile [] noticeFile;
	
	
	
	public MultipartFile[] getNoticeFile() {
		return noticeFile;
	}
	public void setNoticeFile(MultipartFile[] noticeFile) {
		this.noticeFile = noticeFile;
	}
	public String getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeSub() {
		return noticeSub;
	}
	public void setNoticeSub(String noticeSub) {
		this.noticeSub = noticeSub;
	}
	public String getNoticeCon() {
		return noticeCon;
	}
	public void setNoticeCon(String noticeCon) {
		this.noticeCon = noticeCon;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getNoticeKind() {
		return noticeKind;
	}
	public void setNoticeKind(String noticeKind) {
		this.noticeKind = noticeKind;
	}
	public String getNoticeCount() {
		return noticeCount;
	}
	public void setNoticeCount(String noticeCount) {
		this.noticeCount = noticeCount;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

}
