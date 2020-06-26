package classOfVO;

import java.util.Date;

public class AccountVO {

	private String accountId;
	private String pw;
	private String accountName;
	private String tel;
	private String email;
	private Date overdue;
	private int bookCnt;

	public AccountVO() {
		// TODO Auto-generated constructor stub
	}

	public AccountVO(String accountId, String pw, String accountName, String tel, String email, Date overdue,
			int bookCnt) {
		this.accountId = accountId;
		this.pw = pw;
		this.accountName = accountName;
		this.tel = tel;
		this.email = email;
		this.overdue = overdue;
		this.bookCnt = bookCnt;
	}

	public Date getOverdue() {
		return overdue;
	}

	public void setOverdue(Date overdue) {
		this.overdue = overdue;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBookCnt() {
		return bookCnt;
	}

	public void setBookCnt(int bookCnt) {
		this.bookCnt = bookCnt;
	}
}
