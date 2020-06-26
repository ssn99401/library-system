package classOfVO;

import java.util.Date;

public class SeatVO {
	private int seatId;
	private String accountId;
	private Date rentTime;
	
	public SeatVO(int seatId, String accountId, Date rentTime) {
		this.seatId = seatId;
		this.accountId = accountId;
		this.rentTime = rentTime;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Date getRentTime() {
		return rentTime;
	}
	public void setRentTime(Date rentTime) {
		this.rentTime = rentTime;
	}

	
}
