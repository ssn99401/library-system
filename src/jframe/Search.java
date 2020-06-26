package jframe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classOfDAO.AccountDAO;
import classOfVO.AccountVO;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Search extends JFrame {

   private JPanel contentPane;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Search frame = new Search();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    * @throws SQLException 
    * @throws ClassNotFoundException 
    */
   public Search() throws ClassNotFoundException, SQLException {
   	setTitle("\uAD00\uB9AC\uC790\uBAA8\uB4DC");
      
      AccountDAO account = new AccountDAO();
      AccountVO av = new AccountVO();
      Main main = new Main();
      
      
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 950, 600);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(240, 240, 240));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      setLocationRelativeTo(null); //화면가운데오게
      
      //Prev 버튼
      RoundedButton6 btnBack07 = new RoundedButton6("Prev");
      btnBack07.setBackground(Color.GRAY);
      btnBack07.setFont(new Font("나눔고딕", Font.BOLD, 13));
      btnBack07.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            
        	
             try {
            	 dispose();
            	 account.logout();
                 setVisible(false);
                 
 				new Login().setVisible(true);
 			} catch (ClassNotFoundException | SQLException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
            
         }
      });
      btnBack07.setText("< Prev");
      btnBack07.setBounds(42, 38, 79, 30);
      contentPane.add(btnBack07);
      
      
      //도서 추가/수정
      JButton btnBookadd = new JButton("");
      btnBookadd.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      	}
      });
      btnBookadd.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            
            try {
            	dispose();
                setVisible(false);
                
				new AdminAccountS().setVisible(true);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            
         }
      });
      btnBookadd.setIcon(new ImageIcon(Search.class.getResource("/image/accountPlus.png")));
      btnBookadd.setForeground(new Color(0, 0, 128));
      btnBookadd.setFont(new Font("나눔바른고딕", Font.BOLD, 22));
      btnBookadd.setBackground(Color.WHITE);
      btnBookadd.setBounds(180, 239, 256, 204);
      contentPane.add(btnBookadd);
      
      
      //회원조회
      JButton btnSeCtn = new JButton("");
      btnSeCtn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
        	 dispose();
        	 setVisible(false);
        	 try {
				new ManageBooks().setVisible(true);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	 
            
         }
      });
      btnSeCtn.setIcon(new ImageIcon(Search.class.getResource("/image/bookPlus.png")));
      btnSeCtn.setForeground(new Color(0, 0, 128));
      btnSeCtn.setFont(new Font("나눔바른고딕", Font.BOLD, 22));
      btnSeCtn.setBackground(Color.WHITE);
      btnSeCtn.setBounds(482, 239, 256, 204);
      contentPane.add(btnSeCtn);
      
      
      
      
      //Exit
      JButton btnExit = new JButton("");
      btnExit.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {

			int result = JOptionPane.showConfirmDialog(null, "정말 프로그램을 종료하시겠습니까?", "프로그램종료",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.CLOSED_OPTION) {
			} else if (result == JOptionPane.YES_OPTION) {
					setVisible(false);
					System.exit(1);
			}
         }
				
      });
      
      
      btnExit.setIcon(new ImageIcon(Search.class.getResource("/image/poweroff.png")));
      btnExit.setBorderPainted(false);
      btnExit.setContentAreaFilled(false);
      btnExit.setFocusPainted(false);
      btnExit.setBounds(813, 22, 97, 67);
      contentPane.add(btnExit);
      
      
      //관리자모드 - JLabel
      JLabel label = new JLabel("\uAD00\uB9AC\uC790 \uBAA8\uB4DC");
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setForeground(Color.BLACK);
      label.setFont(new Font("나눔고딕", Font.BOLD, 20));
      label.setBounds(382, 92, 154, 59);
      contentPane.add(label);
         
            

   }
}
