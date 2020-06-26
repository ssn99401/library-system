package classOfVO;

public class BookVO {

   private int bookId;
   private String bookName;
   private String bookWriter;
   public BookVO() {
	// TODO Auto-generated constructor stub
   }
   public int getBookId() {
      return bookId;
   }
   public void setBookId(int bookId) {
      this.bookId = bookId;
   }
   public String getBookName() {
      return bookName;
   }
   public void setBookName(String bookName) {
      this.bookName = bookName;
   }
   public String getBookWriter() {
      return bookWriter;
   }
   public void setBookWriter(String bookWriter) {
      this.bookWriter = bookWriter;
   }
   public BookVO(int bookId, String bookName, String bookWriter) {
      super();
      this.bookId = bookId;
      this.bookName = bookName;
      this.bookWriter = bookWriter;
   }
   
   
   
}