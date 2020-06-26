package classOfDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import classOfVO.AccountVO;
import dbConn.DBConn;

public class AccountDAO {

   private Connection conn;
   private PreparedStatement ps;
   private ResultSet rs;

   public AccountDAO() throws ClassNotFoundException, SQLException {
      conn = new DBConn().getConnection();
   }

//////근데 이게 필요있어???????????????? 없을듯......
   // 로그인 후 메인 화면에 나올 정보 출력 메소드(연체 정보,Bookcnt)
   public AccountVO loginInfo(String id) {
      AccountVO vo = null;
      Date dd = null;

      String sql = "select OVERDUE, BOOKCNT from ACCOUNTS where ACCOUNT_ID=?";
      try {
         ps = conn.prepareStatement(sql);
         ps.setString(1, id);
         rs = ps.executeQuery();

         if (rs.next()) {
            java.sql.Date d = rs.getDate(1);

            if (d != null) {
               // 이건 문자열로 출력할 때 유용
               // SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
               dd = new Date(d.getTime());
            }
         }
         return new AccountVO(id, null, null, null, null, dd, rs.getInt(2));

      } catch (SQLException e) {
         return null;
      }
   }

   ///////////////////////////

   // 회원가입(id, pw, 이름, 전화번호)
   public boolean signup(String id, String pw, String name, String tel) throws SQLException { // --------------- 실패했을 때
      // 메세지 팝업 뜨게끔 하자

      // 비밀번호를 알맞게 기입했는지 확인하는 if문 (특수문자, 영어, 숫자로 만들어야하며 8~20의 길이여야한다.)
      if (pw.length() < 7 || pw.length() > 20) {
         return false;
      }
      for (int i = 0; i < pw.length(); i++) {
         if (pw.charAt(i) < 33 || pw.charAt(i) > 126)
            return false;
      }

      String sql = "Insert into ACCOUNTS(ACCOUNT_ID,PW,ACCOUNT_NAME,TEL) values (?,?,?,?)";
      try {
         ps = conn.prepareStatement(sql);
         ps.setString(1, id);
         ps.setString(2, pw);
         ps.setString(3, name);
         ps.setString(4, tel);
         ps.executeUpdate();
         return true;

      } catch (SQLException e) {
         return false;
      }
   }

   // 회원가입(id, pw, 이름, 전화번호, 이메일)
   public boolean signup(String id, String pw, String name, String tel, String email) { // --------------- 실패했을 때 메세지
      // 팝업 뜨게끔 하자

      // 비밀번호를 알맞게 기입했는지 확인하는 if문 (특수문자, 영어, 숫자로 만들어야하며 8~20의 길이여야한다.)
      if (pw.length() < 7 || pw.length() > 20) {
         return false;
      }
      for (int i = 0; i < pw.length(); i++) {
         if (pw.charAt(i) < 33 || pw.charAt(i) > 126)
            return false;
      }

      String sql = "Insert into ACCOUNTS(ACCOUNT_ID,PW,ACCOUNT_NAME,TEL,EMAIL) values (?,?,?,?,?)";
      try {
         ps = conn.prepareStatement(sql);
         ps.setString(1, id);
         ps.setString(2, pw);
         ps.setString(3, name);
         ps.setString(4, tel);
         ps.setString(5, email);
         ps.executeUpdate();
         return true;

      } catch (SQLException e) {
         return false;
      }
   }

   // 로그인(id, pw)
   public String login(String id, String pw) {
      String sql = "select ACCOUNT_ID, PW from ACCOUNTS";
      try {
         ps = conn.prepareStatement(sql);
         rs = ps.executeQuery();

         while (rs.next()) {
            if (id.equals(rs.getString("ACCOUNT_ID")))
               if (pw.equals(rs.getString("PW")))
                  return rs.getString("ACCOUNT_ID");

         }

         // 아이디나 비밀번호가 잘못되셨습니다. ----------이부분을 패널로 보내서 패널에서 처리하도록 할지 고민해보자
         // JOptionPane.showMessageDialog(null, "아이디나 비밀번호가 잘못되셨습니다.", "WRONG",
         // JOptionPane.ERROR_MESSAGE);

         return null;
         /////////////////////////////////////////////////

      } catch (SQLException e) {
         return null;
      }
   }

   // 로그인 아이디 가져오기
   public void setLoginValue(String id) throws SQLException {
      String sql = "insert into getid values(?)";
      ps = conn.prepareStatement(sql);
      ps.setString(1, id);
      ps.executeUpdate();

   }

   public String getLoginValue() throws SQLException {
      String sql = "select * from getid";
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      String id1 = null;
      while (rs.next()) {
         id1 = rs.getString("id");
      }
      return id1;

   }

   // 로그아웃()
   public void logout() throws SQLException {
      // 그냥 메인에 있는 id를 null로 만들면 되지 않을까?
      // setLoginValue,getLoginValue를 위해 해당 db에 인덱스값 제거
      String sql = "delete from getid";
      ps = conn.prepareStatement(sql);
      ps.executeUpdate();
   }

   // 회원 탈퇴(id)
   public boolean signout(String id) {
      String sql = "delete from ACCOUNTS where ACCOUNT_ID= ?";
      try {
         ps = conn.prepareStatement(sql);
         ps.setString(1, id);
         ps.executeUpdate();
         return true;

      } catch (SQLException e) {
         return false;
      }
   }

   // 관리자
   // 계정 조회(id)
   public ArrayList<AccountVO> searchId(String searchId) {

      ArrayList<AccountVO> idArray = new ArrayList<AccountVO>();

      try {
         String sql = "SELECT ACCOUNT_ID,ACCOUNT_NAME,TEL,EMAIL,OVERDUE,BOOKCNT FROM ACCOUNTS WHERE ACCOUNT_ID=? and ACCOUNT_ID != 'admin'";

         ps = conn.prepareStatement(sql);
         ps.setString(1, searchId);
         rs = ps.executeQuery();

         while (rs.next()) {
            String accountId = rs.getString("ACCOUNT_ID");
            String accountName = rs.getString("ACCOUNT_NAME");
            String tel = rs.getString("TEL");
            String email = rs.getString("EMAIL");

            java.sql.Date d = rs.getDate("OVERDUE");
            Date overdue = null;
            if (d != null) {
               overdue = new Date(d.getTime());
            }
            int bookCnt = rs.getInt("BOOKCNT");

            AccountVO avo = new AccountVO(accountId, null, accountName, tel, email, overdue, bookCnt);

            idArray.add(avo);
         }

         return idArray;

      } catch (SQLException e) {
         return null;
      }

   }

// 계정 조회(name)
   public ArrayList<AccountVO> searchName(String search) {

      ArrayList<AccountVO> idArray = new ArrayList<AccountVO>();

      try {
         String sql = "SELECT ACCOUNT_ID,ACCOUNT_NAME,TEL,EMAIL,OVERDUE,BOOKCNT FROM ACCOUNTS WHERE ACCOUNT_NAME like ? and ACCOUNT_ID != 'admin'";

         ps = conn.prepareStatement(sql);
         ps.setString(1, "%" +search + "%");
         rs = ps.executeQuery();

         while (rs.next()) {
            String accountId = rs.getString("ACCOUNT_ID");
            String accountName = rs.getString("ACCOUNT_NAME");
            String tel = rs.getString("TEL");
            String email = rs.getString("EMAIL");

            java.sql.Date d = rs.getDate("OVERDUE");
            Date overdue = null;
            if (d != null) {
               overdue = new Date(d.getTime());
            }
            int bookCnt = rs.getInt("BOOKCNT");

            AccountVO avo = new AccountVO(accountId, null, accountName, tel, email, overdue, bookCnt);

            idArray.add(avo);
         }

         return idArray;

      } catch (SQLException e) {
         return null;
      }

   }
   // 계정 조회(tel)
   public ArrayList<AccountVO> searchTel(String searchTel) {

      ArrayList<AccountVO> idArray = new ArrayList<AccountVO>();

      try {
         String sql = "SELECT ACCOUNT_ID,ACCOUNT_NAME,TEL,EMAIL,OVERDUE,BOOKCNT FROM ACCOUNTS WHERE TEL like ? and ACCOUNT_ID != 'admin'";

         ps = conn.prepareStatement(sql);
         ps.setString(1, "%" + searchTel + "%");
         rs = ps.executeQuery();

         while (rs.next()) {
            String accountId = rs.getString("ACCOUNT_ID");
            String accountName = rs.getString("ACCOUNT_NAME");
            String tel = rs.getString("TEL");
            String email = rs.getString("EMAIL");

            java.sql.Date d = rs.getDate("OVERDUE");
            Date overdue = null;
            if (d != null) {
               overdue = new Date(d.getTime());
            }
            int bookCnt = rs.getInt("BOOKCNT");

            AccountVO avo = new AccountVO(accountId, null, accountName, tel, email, overdue, bookCnt);

            idArray.add(avo);
         }

         return idArray;

      } catch (SQLException e) {
         return null;
      }

   }
   //전체 조회
   public ArrayList<AccountVO> searchAll() {

      ArrayList<AccountVO> idArray = new ArrayList<AccountVO>();

      try {
         String sql = "SELECT ACCOUNT_ID,ACCOUNT_NAME,TEL,EMAIL,OVERDUE,BOOKCNT FROM ACCOUNTS where ACCOUNT_ID != 'admin'";

         ps = conn.prepareStatement(sql);
         rs = ps.executeQuery();

         while (rs.next()) {
            String accountId = rs.getString("ACCOUNT_ID");
            String accountName = rs.getString("ACCOUNT_NAME");
            String tel = rs.getString("TEL");
            String email = rs.getString("EMAIL");

            java.sql.Date d = rs.getDate("OVERDUE");
            Date overdue = null;
            if (d != null) {
               overdue = new Date(d.getTime());
            }
            int bookCnt = rs.getInt("BOOKCNT");

            AccountVO avo = new AccountVO(accountId, null, accountName, tel, email, overdue, bookCnt);

            idArray.add(avo);
         }

         return idArray;

      } catch (SQLException e) {
         return null;
      }

   }
   
   
   // 회원가입 시 아이디 조회기능
   // 만약에 아이디가 같다? 싶으면 걸러버리는 기능
   public ArrayList<String> searchForId() {

      ArrayList<String> idArray = new ArrayList<String>();

      try {
         String sql = "SELECT ACCOUNT_ID FROM ACCOUNTS ";

         Statement stmt = conn.createStatement();

         rs = stmt.executeQuery(sql);

         while (rs.next()) {
            String accountId = rs.getString("ACCOUNT_ID");

            idArray.add(accountId);
         }

         return idArray;

      } catch (SQLException e) {
         return null;
      }

   }
}