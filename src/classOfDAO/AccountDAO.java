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

//////�ٵ� �̰� �ʿ��־�???????????????? ������......
   // �α��� �� ���� ȭ�鿡 ���� ���� ��� �޼ҵ�(��ü ����,Bookcnt)
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
               // �̰� ���ڿ��� ����� �� ����
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

   // ȸ������(id, pw, �̸�, ��ȭ��ȣ)
   public boolean signup(String id, String pw, String name, String tel) throws SQLException { // --------------- �������� ��
      // �޼��� �˾� �߰Բ� ����

      // ��й�ȣ�� �˸°� �����ߴ��� Ȯ���ϴ� if�� (Ư������, ����, ���ڷ� �������ϸ� 8~20�� ���̿����Ѵ�.)
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

   // ȸ������(id, pw, �̸�, ��ȭ��ȣ, �̸���)
   public boolean signup(String id, String pw, String name, String tel, String email) { // --------------- �������� �� �޼���
      // �˾� �߰Բ� ����

      // ��й�ȣ�� �˸°� �����ߴ��� Ȯ���ϴ� if�� (Ư������, ����, ���ڷ� �������ϸ� 8~20�� ���̿����Ѵ�.)
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

   // �α���(id, pw)
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

         // ���̵� ��й�ȣ�� �߸��Ǽ̽��ϴ�. ----------�̺κ��� �гη� ������ �гο��� ó���ϵ��� ���� ����غ���
         // JOptionPane.showMessageDialog(null, "���̵� ��й�ȣ�� �߸��Ǽ̽��ϴ�.", "WRONG",
         // JOptionPane.ERROR_MESSAGE);

         return null;
         /////////////////////////////////////////////////

      } catch (SQLException e) {
         return null;
      }
   }

   // �α��� ���̵� ��������
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

   // �α׾ƿ�()
   public void logout() throws SQLException {
      // �׳� ���ο� �ִ� id�� null�� ����� ���� ������?
      // setLoginValue,getLoginValue�� ���� �ش� db�� �ε����� ����
      String sql = "delete from getid";
      ps = conn.prepareStatement(sql);
      ps.executeUpdate();
   }

   // ȸ�� Ż��(id)
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

   // ������
   // ���� ��ȸ(id)
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

// ���� ��ȸ(name)
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
   // ���� ��ȸ(tel)
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
   //��ü ��ȸ
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
   
   
   // ȸ������ �� ���̵� ��ȸ���
   // ���࿡ ���̵� ����? ������ �ɷ������� ���
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