package classOfVO;

import java.util.Date;

public class RentalVO {
	private String accountId;
	private String bookId;
	private Date rentDate;
	
	public RentalVO(String accountId, String bookId, Date rentDate) {
		super();
		this.accountId = accountId;
		this.bookId = bookId;
		this.rentDate = rentDate;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}
	
	
}
