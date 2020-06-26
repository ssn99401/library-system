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
		System.out.println(i+"�� �����̽��ϴ�.");*/
		/*
		int j = dat.returnBook("���� 6-1");
		System.out.println(j+"�� �ݳ��ϼ̽��ϴ�.");
		*/
		SeatDAO seats = new SeatDAO();
		//seats.rentSeat(20, "admin");
		ArrayList<SeatVO> list1=seats.selectSeat();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		for(SeatVO s : list1) {
			System.out.println(s.getSeatId() + "�� �¼�" + s.getAccountId() +"����" + sdf.format(s.getRentTime()) + "���� ������Դϴ�.");
		}
		
	}

}
