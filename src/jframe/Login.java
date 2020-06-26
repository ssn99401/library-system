package jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import classOfDAO.AccountDAO;
import classOfVO.AccountVO;
import classOfVO.LoginIdVO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Login extends JFrame {

   private JPanel contentPane;
   private JTextField textField;
   private JPasswordField textField_1;
   
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Login frame = new Login();
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
   public Login() throws ClassNotFoundException, SQLException {
   	setTitle("\uB85C\uADF8\uC778");
	  LoginIdVO logId = new LoginIdVO();
	  
      AccountDAO adao= new AccountDAO();
      AccountVO avo= new AccountVO();
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 68, 115));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
      
      textField = new JTextField();
      textField.setBounds(271, 200, 276, 40);
      contentPane.add(textField);
      textField.setColumns(10);
      
      textField_1 = new JPasswordField();
      textField_1.setEchoChar('*');
      textField_1.setColumns(10);
      textField_1.setBounds(271, 263, 276, 40);
      contentPane.add(textField_1);
      
      RoundedButton2 btnNewButton = new RoundedButton2("\uB85C\uADF8\uC778");
      btnNewButton.setFont(new Font("나눔고딕", Font.BOLD, 14));
      
      btnNewButton.addActionListener(new ActionListener() {
         int trylg = 0;
         public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnNewButton)//로그인 버튼을 누르면
            {
               
                  
                  String id = textField.getText();
                  String pw = textField_1.getText();

                  id = adao.login(id, pw);
               if (id != null) {
                  JOptionPane.showMessageDialog(null, "로그인을 성공하였습니다");
                  
                  try {
                	  AccountDAO adao = new AccountDAO();
                	  adao.logout();
                      adao.setLoginValue(id);
                      dispose();
                      setVisible(false);
                      if(id.equals("admin")) {
                    	  new Search().setVisible(true);
                      }else { 
                    	  new Main().setVisible(true);
                      }
                    
                  } catch (ClassNotFoundException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                  } catch (SQLException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                  }
               } else {
                  
                     trylg++;
                  JOptionPane.showMessageDialog(null, "아이디나 비밀번호가 잘못되셨습니다.\n("+trylg+"회 시도)", "WRONG", JOptionPane.ERROR_MESSAGE);
                  if (trylg >= 5) {
                     JOptionPane.showMessageDialog(null,
                           "id,비밀번호를 5회이상 틀리셨습니다. \n기타 문의사항은 관리자 번호(010-xxxx-xxxx)로 연락주세요");
                     dispose();
                      new Gaip().setVisible(true);
                  }

               } // if --end
               
            } // event if -- end
         }// event--end
      });
      btnNewButton.setBounds(564, 200, 103, 103);
      contentPane.add(btnNewButton);

      JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uC774 \uC544\uB2C8\uC2E0\uAC00\uC694?");
      lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 12));
      lblNewLabel.setForeground(Color.WHITE);
      lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
      lblNewLabel.setBounds(271, 333, 276, 21);
      contentPane.add(lblNewLabel);
      
      RoundedButton3 btnSign = new RoundedButton3("\uD68C\uC6D0\uAC00\uC785");
      btnSign.setFont(new Font("나눔고딕", Font.BOLD, 13));
      btnSign.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose();
            setVisible(false);
            new Gaip().setVisible(true);
         }
      });
      btnSign.setBounds(271, 364, 394, 40);
      contentPane.add(btnSign);
      
      JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514");
      lblNewLabel_1.setFont(new Font("나눔고딕", Font.BOLD, 13));
      lblNewLabel_1.setForeground(Color.WHITE);
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
      lblNewLabel_1.setBounds(198, 212, 57, 15);
      contentPane.add(lblNewLabel_1);
      
      JLabel lblNewLabel_2 = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
      lblNewLabel_2.setForeground(Color.WHITE);
      lblNewLabel_2.setFont(new Font("나눔고딕", Font.BOLD, 13));
      lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
      lblNewLabel_2.setBounds(170, 275, 85, 15);
      contentPane.add(lblNewLabel_2);
      
      JLabel lblNewLabel_3 = new JLabel("\uB85C \uADF8 \uC778");
      lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_3.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
      lblNewLabel_3.setForeground(Color.WHITE);
      lblNewLabel_3.setBounds(406, 126, 110, 40);
      contentPane.add(lblNewLabel_3);
      
      
      
      
   }
}