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

   // 도서 대여시 조건
   /*
    * 1. 책이 대여 가능한지 확인 -- 대여 장부에서 책 이있는지 확인
    * 
    * 2. 회원이 연체되었는지 확인 -- 연체 날짜를 확인 하기 연체시에는 반납을 하지 않아 overdue가 채워져 있다. 이 때 채워져있는
    * 날짜보다 기간이 지났을 시, 연체된것으로 간주 한다
    * 
    * 2-* 책을 1권만 빌렸을 때
    * 
    * 3. 회원의 대여권수 확인하기 -- 2권이면 대여 불가
    * 
    * 도서 대여한 후 조건
    * 
    * 1. 회원의 대여권수 늘리기
    * 
    * 
    * 총 4가지 에러 보유 -1; // 책이 이미 대여중입니다. -2; // 빌린책이 2권이 입니다. -3; //빌린 책부터 반납하세요! -4;
    * // 연체하셨습니다.
    */

   // 도서 대여 (도서 id, 계정 id) ---- 회원이 연체시(overdue확인) 대여 불가
   public int rentBook(String accountId, int bookId) {
      int cnt = 0;

      try {
         // 책이 대여가능한지 확인 -- 먼저 확인하기
         String sql = "select * from RENTALS where BOOK_ID=" + bookId;
         ps = conn.prepareStatement(sql);

         rs = ps.executeQuery();

         if (rs.next())// 대여장부에 빌리고 싶은 책이 있으면 대여 불가능
            return -1;

         ps = null;
         rs = null;
         // 회원이 대여권수가 2권이거나 연체시 대여불가
         sql = "select OVERDUE, BOOKCNT from ACCOUNTS where ACCOUNT_ID='" + accountId + "'";
         ps = conn.prepareStatement(sql);
         rs = ps.executeQuery();

         while (rs.next()) { // 회원의 overdue, bookcnt확인 확인

            cnt = rs.getInt(2);

            if (cnt == 2)
               return -2; // 빌린책이 2권이 입니다.

            if (rs.getDate(1) == null) { // null이면 대여가능

               // 대여했을 때 overdue를 수정해선 안된다 -- 요류 (대여권수가 2권이라 2권중 무슨 책에 해당된는지 알수 X)
               // 구현 안될 수 있는 부분! ----- but 이게 허용되면 나머지 1책을 연체하고도 계속빌릴수있다.
               if (cnt == 1) { // 근데 한책은 잘 반납하여 연체날짜가없는데 나머지 책을 연체햇다!
                  sql = "select RENT_DATE from RENTALS where ACCOUNT_ID='" + accountId + "'";
                  ps = conn.prepareStatement(sql);
                  ResultSet trs = ps.executeQuery();

                  if (trs.next()) {
                     Date rentDate = new Date(trs.getDate(1).getTime());
                     long rentNum = rentDate.getTime() + (8 * 24 * 60 * 60 * 1000);
                     rentDate = new Date(rentNum);
                     Date today = new Date();
                     if (today.compareTo(rentDate) > 0)
                        return -3; // 빌린 책부터 반납하세요!
                  }
               }

               continue;

            } else {// 연체했는지 오늘날짜와 비교하는 확인문
               Date dd = new Date(rs.getDate(1).getTime());
               Date today = new Date();
               if (today.compareTo(dd) > 0) { // 오늘 > 못빌리는 날
                  // 회원의 overdue 변경 --> null (update)
                  sql = "update ACCOUNTS set OVERDUE=null where ACCOUNT_ID='" + accountId + "'";
                  ps = conn.prepareStatement(sql);
                  ps.executeUpdate();

               } else { // 회원은 아직 못빌립니다.
                  return -4; // 연체하셨습니다.
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

   // 도서 반납 (반납 도서id)
   // 이거는 추후에 변경을 해야할거같아요

   //

   public int returnBook(String accountId, int bookId) throws SQLException {
      // 일단 지우기 전에 BookID를 가져와야함
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

      // 7일이 지나면 overdue에 연체가 안되도록 기록남기기
      sql = "select RENT_DATE from RENTALS where ACCOUNT_ID='" + accountId + "'";
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      if (rs.next()) {
         Date rentDate = new Date(rs.getDate(1).getTime());
         if (rentDate != null) {
            Date today = new Date();
            // 빌린날짜에서 일주일 더하기(반납해야하는 일)
            long rentNum = rentDate.getTime() + (8 * 24 * 60 * 60 * 1000);
            System.out.println(rentNum);
            rentDate = new Date(rentNum);

            // 연체되었는지
            if (date != null) { //만약 기존 overdue가 더 연체되엇을 때 확인
               if (today.compareTo(rentDate) > 0 && rentDate.compareTo(date) > 0) {
                  sql = "update ACCOUNTS set OVERDUE=? where ACCOUNT_ID=?";
                  ps = conn.prepareStatement(sql);

                  // 오늘 날짜로부터 연체된날짜를 더한 값만큼 못빌리기 때문에 계산 해준뒤 overdue업데이트
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

                  // 오늘 날짜로부터 연체된날짜를 더한 값만큼 못빌리기 때문에 계산 해준뒤 overdue업데이트
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

      // 렌탈안에 있는 값 지우기
      sql = "delete from rentals where Book_id = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, bookId);
      int i = ps.executeUpdate();

      // 계정에 책빌린 개수 줄이기
      sql = "update ACCOUNTS set BOOKCNT=? where ACCOUNT_ID=?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, cnt - 1);
      ps.setString(2, accountId);
      System.out.println(ps.executeUpdate());

      return i;
   }
}