package classOfDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import classOfVO.BookVO;
import dbConn.DBConn;

public class BookDAO {
   private Connection conn;
   private PreparedStatement ps=null;
   private ResultSet rs = null;

   public BookDAO() throws ClassNotFoundException, SQLException {
      conn = new DBConn().getConnection();
      System.out.println("���ӿϷ�");
   }

   // ���� ��ȸ()
   public ArrayList<BookVO> searchBook() throws SQLException {
      ArrayList<BookVO> bkArray = new ArrayList<BookVO>();
      String sql = "SELECT * from BOOKS ORDER BY BOOK_ID";
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();

      try {
         while (rs.next()) {
            int bookId = rs.getInt("BOOK_ID");
            String bookName = rs.getString("BOOK_NAME");
            String bookWriter = rs.getString("BOOK_WRITER");

            BookVO bvo = new BookVO(bookId, bookName, bookWriter);
            bkArray.add(bvo);

         }
      } catch (Exception e) {
         System.out.println("���ӿ���");
      }

      return bkArray;
   }

   // ���� �̸����� ��ȸ (ã�� ����)
   public ArrayList<BookVO> searchBookByName(String searchbookName) throws SQLException {
      ArrayList<BookVO> bkSearchArray = new ArrayList<BookVO>();

      String sql = "Select * FROM BOOKS WHERE BOOK_NAME Like ? ";
      ps = conn.prepareStatement(sql);
      ps.setString(1, "%" + searchbookName + "%");

      rs = ps.executeQuery();

      while (rs.next()) {
         int bookId = rs.getInt("BOOK_ID");
         String bookName = rs.getString("BOOK_NAME");
         String bookWriter = rs.getString("BOOK_WRITER");

         BookVO bvo = new BookVO(bookId, bookName, bookWriter);
         bkSearchArray.add(bvo);

      }

      return bkSearchArray;
   }

   // ���� �����̷� ��ȸ
   public ArrayList<BookVO> searchBookW(String searchbookWriter) throws SQLException {
      ArrayList<BookVO> searchWriterArray = new ArrayList<BookVO>();
      String sql = "Select * FROM BOOKS WHERE BOOK_WRITER LIKE ?";
      ps = conn.prepareStatement(sql);
      ps.setString(1, "%" + searchbookWriter + "%");
      rs = ps.executeQuery();

      while (rs.next()) {
         int bookId = rs.getInt("BOOK_ID");
         String bookName = rs.getString("BOOK_NAME");
         String bookWriter = rs.getString("BOOK_WRITER");

         BookVO bvo = new BookVO(bookId, bookName, bookWriter);
         searchWriterArray.add(bvo);

      }

      return searchWriterArray;
   }
 //���� ��ȸ �̸�,����2����
   public ArrayList<BookVO> searchBookandW(String searchbookName1,String searchbookNW) throws SQLException {
      ArrayList<BookVO> bknWSearchArray = new ArrayList<BookVO>();

      String sql = "Select * FROM BOOKS WHERE BOOK_NAME Like ? AND BOOK_WRITER Like ?";
      ps = conn.prepareStatement(sql);
      ps.setString(1, "%" + searchbookName1 + "%");
      ps.setString(2, "%" + searchbookNW + "%");

      rs = ps.executeQuery();

      while (rs.next()) {
         int bookId = rs.getInt("BOOK_ID");
         String bookName = rs.getString("BOOK_NAME");
         String bookWriter = rs.getString("BOOK_WRITER");

         BookVO bvo = new BookVO(bookId, bookName, bookWriter);
         bknWSearchArray.add(bvo);

      }

      return bknWSearchArray;
   }

   // ������
   // ���� �Է�(���� �̸�, ���� ����)
   public boolean adminBookAdd(int addbookID,String addbookName, String addbookWriter) throws SQLException {
      ArrayList<BookVO> bookaddArray = new ArrayList<BookVO>();
      String sql = "Insert into BOOKS values (?,?,?)";
      try {
      ps = conn.prepareStatement(sql);
      ps.setInt(1, addbookID);
      ps.setString(2, addbookName);
      ps.setString(3, addbookWriter);
      ps.executeUpdate();
      }catch(Exception e)
      {
         System.out.println("Insert error");
         return false;
      }
      return true;

   }
   

   
   //������ȣ �ڵ����� �ż���
   public int findBookNum() throws SQLException {

         String sql = "SELECT BOOK_ID from BOOKS WHERE rownum = 1 order by book_id desc";
         ps = conn.prepareStatement(sql);
         rs = ps.executeQuery();
         
         int cnt = 0;
         if(rs.next())
            cnt = rs.getInt(1);
         
         return (cnt + 1);
      }

   
   
   // ������
   // ���� ����(���� �̸�)
   public boolean deleteBook(String delbookName) {
      String sql = "delete FROM BOOKS WHERE BOOK_NAME = ? ";
      try {
         ps = conn.prepareStatement(sql);
         ps.setString(1, delbookName);
         ps.executeUpdate();

      } catch (Exception e) {
         System.out.println("delete error");
         return false;
      }

      return true;

   }

  
   
   
   // ������

   // 1.���� ����(�ٲ� �̸�, �ٲ� ����,���� �̸�,��������)
   public boolean updateBook1(String updatebookName,String updatebookWriter, String upsearchbookName, String upsearchbookWriter) {
      String sql = "update BOOKS set BOOK_NAME = ?,BOOK_WRITER = ? WHERE BOOK_NAME = ? and BOOK_WRITER = ? ";
      try {
         ps = conn.prepareStatement(sql);
         
         ps.setString(1, updatebookName);
         ps.setString(2, updatebookWriter);
         ps.setString(3, upsearchbookName);
         ps.setString(4, upsearchbookWriter);
         ps.executeUpdate();

      } catch (Exception e) {
         System.out.println("update error");
         return false;
      }

      return true;

   }

//2.���� ����(���� �̸�, �ٲ� ����)
   public boolean updateBook2(String upsearchbookName, String updatebookWriter) {
      String sql = "update BOOKS set BOOK_WRITER = ? WHERE BOOK_NAME = ? ";
      try {
         ps = conn.prepareStatement(sql);
         ps.setString(1, updatebookWriter);
         ps.setString(2, upsearchbookName);
         ps.executeUpdate();

      } catch (Exception e) {
         System.out.println("update error");
         return false;
      }

      return true;
   }

//3.���� ����(���� �̸�, �ٲ� �̸�) --
   public boolean updateBook3(String upsearchbookName, String updatebookName) {
      String sql = "update BOOKS set BOOK_NAME = ? WHERE BOOK_NAME = ? ";
      try {
         ps = conn.prepareStatement(sql);
         ps.setString(1, updatebookName);
         ps.setString(2, upsearchbookName);
         ps.executeUpdate();

      } catch (Exception e) {
         System.out.println("update error");
         return false;
      }

      return true;
   }
   
	// ȸ���� ���� å ã�� //ȸ���� ����å // å������ �ʿ��ϴ� �ٵ� �ƴ� �� ȸ����ȣ
   public ArrayList<BookVO> searchBookOfAccount(String id) throws SQLException {

      ArrayList<BookVO> bkArray = new ArrayList<BookVO>();

      // å�� ���� ���� book���� �̸��� �����´�.

      String sql = "SELECT BOOK_ID from RENTALS where ACCOUNT_ID='" + id + "'";
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();

      try {
         while (rs.next()) {
            
            sql = "select * from BOOKS where BOOK_ID=" + rs.getString(1);
            ps = conn.prepareStatement(sql);
            ResultSet trs = ps.executeQuery();
            while (trs.next()) {
               int bookId = trs.getInt("BOOK_ID");
               String bookName = trs.getString("BOOK_NAME");
               String bookWriter = trs.getString("BOOK_WRITER");
               System.out.println(bookId);

               BookVO bvo = new BookVO(bookId, bookName, bookWriter);
               bkArray.add(bvo);
            }

         }
      } catch (Exception e) {
         System.out.println("���ӿ���");
      }

      return bkArray;
   }
}