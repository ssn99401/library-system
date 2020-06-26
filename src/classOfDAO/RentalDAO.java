package classOfDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import dbConn.DBConn;

public class RentalDAO {
   private Connection conn;
   private PreparedStatement ps;
   private ResultSet rs;

   public RentalDAO() throws ClassNotFoundException, SQLException {
      conn = new DBConn().getConnection();
   }

   // ���� �뿩�� ����
   /*
    * 1. å�� �뿩 �������� Ȯ�� -- �뿩 ��ο��� å ���ִ��� Ȯ��
    * 
    * 2. ȸ���� ��ü�Ǿ����� Ȯ�� -- ��ü ��¥�� Ȯ�� �ϱ� ��ü�ÿ��� �ݳ��� ���� �ʾ� overdue�� ä���� �ִ�. �� �� ä�����ִ�
    * ��¥���� �Ⱓ�� ������ ��, ��ü�Ȱ����� ���� �Ѵ�
    * 
    * 2-* å�� 1�Ǹ� ������ ��
    * 
    * 3. ȸ���� �뿩�Ǽ� Ȯ���ϱ� -- 2���̸� �뿩 �Ұ�
    * 
    * ���� �뿩�� �� ����
    * 
    * 1. ȸ���� �뿩�Ǽ� �ø���
    * 
    * 
    * �� 4���� ���� ���� -1; // å�� �̹� �뿩���Դϴ�. -2; // ����å�� 2���� �Դϴ�. -3; //���� å���� �ݳ��ϼ���! -4;
    * // ��ü�ϼ̽��ϴ�.
    */

   // ���� �뿩 (���� id, ���� id) ---- ȸ���� ��ü��(overdueȮ��) �뿩 �Ұ�
   public int rentBook(String accountId, int bookId) {
      int cnt = 0;

      try {
         // å�� �뿩�������� Ȯ�� -- ���� Ȯ���ϱ�
         String sql = "select * from RENTALS where BOOK_ID=" + bookId;
         ps = conn.prepareStatement(sql);

         rs = ps.executeQuery();

         if (rs.next())// �뿩��ο� ������ ���� å�� ������ �뿩 �Ұ���
            return -1;

         ps = null;
         rs = null;
         // ȸ���� �뿩�Ǽ��� 2���̰ų� ��ü�� �뿩�Ұ�
         sql = "select OVERDUE, BOOKCNT from ACCOUNTS where ACCOUNT_ID='" + accountId + "'";
         ps = conn.prepareStatement(sql);
         rs = ps.executeQuery();

         while (rs.next()) { // ȸ���� overdue, bookcntȮ�� Ȯ��

            cnt = rs.getInt(2);

            if (cnt == 2)
               return -2; // ����å�� 2���� �Դϴ�.

            if (rs.getDate(1) == null) { // null�̸� �뿩����

               // �뿩���� �� overdue�� �����ؼ� �ȵȴ� -- ��� (�뿩�Ǽ��� 2���̶� 2���� ���� å�� �ش�ȴ��� �˼� X)
               // ���� �ȵ� �� �ִ� �κ�! ----- but �̰� ���Ǹ� ������ 1å�� ��ü�ϰ� ��Ӻ������ִ�.
               if (cnt == 1) { // �ٵ� ��å�� �� �ݳ��Ͽ� ��ü��¥�����µ� ������ å�� ��ü�޴�!
                  sql = "select RENT_DATE from RENTALS where ACCOUNT_ID='" + accountId + "'";
                  ps = conn.prepareStatement(sql);
                  ResultSet trs = ps.executeQuery();

                  if (trs.next()) {
                     Date rentDate = new Date(trs.getDate(1).getTime());
                     long rentNum = rentDate.getTime() + (8 * 24 * 60 * 60 * 1000);
                     rentDate = new Date(rentNum);
                     Date today = new Date();
                     if (today.compareTo(rentDate) > 0)
                        return -3; // ���� å���� �ݳ��ϼ���!
                  }
               }

               continue;

            } else {// ��ü�ߴ��� ���ó�¥�� ���ϴ� Ȯ�ι�
               Date dd = new Date(rs.getDate(1).getTime());
               Date today = new Date();
               if (today.compareTo(dd) > 0) { // ���� > �������� ��
                  // ȸ���� overdue ���� --> null (update)
                  sql = "update ACCOUNTS set OVERDUE=null where ACCOUNT_ID='" + accountId + "'";
                  ps = conn.prepareStatement(sql);
                  ps.executeUpdate();

               } else { // ȸ���� ���� �������ϴ�.
                  return -4; // ��ü�ϼ̽��ϴ�.
               }
            }
         }

         sql = "insert into rentals(ACCOUNT_ID,BOOK_ID) values(?,?)";
         ps = conn.prepareStatement(sql);
         ps.setString(1, accountId);
         ps.setInt(2, bookId);
         int i = ps.executeUpdate();

         sql = "update ACCOUNTS set BOOKCNT = " + (cnt + 1) + "where ACCOUNT_ID='" + accountId + "'";
         ps = conn.prepareStatement(sql);
         ps.executeUpdate();

         return i;

      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         return 0;
      }

   }

   // ���� �ݳ� (�ݳ� ����id)
   // �̰Ŵ� ���Ŀ� ������ �ؾ��ҰŰ��ƿ�

   //

   public int returnBook(String accountId, int bookId) throws SQLException {
      // �ϴ� ����� ���� BookID�� �����;���
//      String sql1 = "select book_id, book_name from books where book_name = ? ";
//      PreparedStatement ps1 = conn.prepareStatement(sql1);
//      ps1.setString(1, bookName);
//      rs = ps1.executeQuery();
//      HashMap<String, Integer> hash = new HashMap<String, Integer>();
//
//      while (rs.next()) {
//         int bookId = rs.getInt(1);
//         String bookN = rs.getString(2);
//         hash.put(bookN, bookId);
//
//      }
      String sql = "select OVERDUE, BOOKCNT from ACCOUNTS where ACCOUNT_ID='" + accountId + "'";
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();

      int cnt = 0;
      Date date = null;
      if (rs.next()) {
         if (rs.getDate(1) != null)
            date = new Date(rs.getDate(1).getTime());
         cnt = rs.getInt(2);
      }

      // 7���� ������ overdue�� ��ü�� �ȵǵ��� ��ϳ����
      sql = "select RENT_DATE from RENTALS where ACCOUNT_ID='" + accountId + "'";
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      if (rs.next()) {
         Date rentDate = new Date(rs.getDate(1).getTime());
         if (rentDate != null) {
            Date today = new Date();
            // ������¥���� ������ ���ϱ�(�ݳ��ؾ��ϴ� ��)
            long rentNum = rentDate.getTime() + (8 * 24 * 60 * 60 * 1000);
            System.out.println(rentNum);
            rentDate = new Date(rentNum);

            // ��ü�Ǿ�����
            if (date != null) { //���� ���� overdue�� �� ��ü�Ǿ��� �� Ȯ��
               if (today.compareTo(rentDate) > 0 && rentDate.compareTo(date) > 0) {
                  sql = "update ACCOUNTS set OVERDUE=? where ACCOUNT_ID=?";
                  ps = conn.prepareStatement(sql);

                  // ���� ��¥�κ��� ��ü�ȳ�¥�� ���� ����ŭ �������� ������ ��� ���ص� overdue������Ʈ
                  long todayLong = today.getTime();
                  java.sql.Date d = new java.sql.Date(todayLong * 2 - rentNum);
                  System.out.println(d);
                  ps.setDate(1, d);
                  ps.setString(2, accountId);
                  ps.executeUpdate();
               }
            }else {
               if (today.compareTo(rentDate) > 0) {
                  sql = "update ACCOUNTS set OVERDUE=? where ACCOUNT_ID=?";
                  ps = conn.prepareStatement(sql);

                  // ���� ��¥�κ��� ��ü�ȳ�¥�� ���� ����ŭ �������� ������ ��� ���ص� overdue������Ʈ
                  long todayLong = today.getTime();
                  java.sql.Date d = new java.sql.Date(todayLong * 2 - rentNum);
                  System.out.println(d);
                  ps.setDate(1, d);
                  ps.setString(2, accountId);
                  ps.executeUpdate();
               }
            }
         }

      }

      // ��Ż�ȿ� �ִ� �� �����
      sql = "delete from rentals where Book_id = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, bookId);
      int i = ps.executeUpdate();

      // ������ å���� ���� ���̱�
      sql = "update ACCOUNTS set BOOKCNT=? where ACCOUNT_ID=?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, cnt - 1);
      ps.setString(2, accountId);
      System.out.println(ps.executeUpdate());

      return i;
   }
}