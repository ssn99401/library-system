package mainPackage;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import classOfDAO.RentalDAO;
import classOfDAO.SeatDAO;
import classOfVO.SeatVO;

public class mainC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Date date = new Date();
		
		
		/*RentalDAO dat = new RentalDAO();
		int i = dat.rentBook("admin", 6013, date);
		System.out.println(i+"권 빌리셨습니다.");*/
		/*
		int j = dat.returnBook("과학 6-1");
		System.out.println(j+"권 반납하셨습니다.");
		*/
		SeatDAO seats = new SeatDAO();
		//seats.rentSeat(20, "admin");
		ArrayList<SeatVO> list1=seats.selectSeat();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		for(SeatVO s : list1) {
			System.out.println(s.getSeatId() + "번 좌석" + s.getAccountId() +"님이" + sdf.format(s.getRentTime()) + "부터 사용중입니다.");
		}
		
	}

}
