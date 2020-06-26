package classOfDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import classOfVO.SeatVO;
import dbConn.DBConn;

public class SeatDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public SeatDAO() throws ClassNotFoundException, SQLException {
		conn = new DBConn().getConnection();
	}
	// ��ü �¼�����
	public ArrayList<SeatVO> selectSeat() throws SQLException{
		String sql = "select * from seats";
		Statement st = conn.createStatement();
		st.execute(sql);
		rs = st.getResultSet();
		ArrayList<SeatVO> list1 = new ArrayList<SeatVO>();
		while(rs.next()) {
			int seat=rs.getInt(1);
			String id=rs.getString(2);
			Date date = rs.getTimestamp(3);
			list1.add(new SeatVO(seat, id, date));
		}
		return list1;
		
	}
	// �¼� �ϳ�����(�¼���ȣ)
	public SeatVO selectOneSeat(int i) throws SQLException{
		String sql = "select * from seats where seat_id =?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, i);
		rs = ps.executeQuery();
		SeatVO VO = null;
		while(rs.next()) {
			int seat=rs.getInt(1);
			String id=rs.getString(2);
			Date date = rs.getTimestamp(3);
			VO =new SeatVO(seat, id, date);
		}
		return VO;
		
	}
	// �¼� �뿩 (�¼� ��ȣ, id)
	public void rentSeat(int seat, String id) throws SQLException {
		String sql = "insert into seats values(?,?,?)";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, seat);
		ps.setString(2, id);
		Date date = new Date();
		java.sql.Date date1= new java.sql.Date(date.getTime());
		ps.setTimestamp(3, new java.sql.Timestamp(date1.getTime()));
		
		ps.executeUpdate();
		
	}
	//�¼�����(id)
	public void changeSeat(int seat,String id) throws SQLException {
		String sql = "update seats set seat_id =? where account_id =?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, seat);
		ps.setString(2, id);
		
		ps.executeUpdate();
		
	}
	
	// �¼� �ݳ�(�¼���ȣ, id)
	public void returnSeat(int seat) throws SQLException {
		String sql = "delete from seats where seat_id = ?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, seat);
		ps.executeUpdate();
	}

}
