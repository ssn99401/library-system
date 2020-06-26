package jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classOfDAO.AccountDAO;
import classOfVO.AccountVO;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AdminAccountS extends JFrame {

   private JPanel contentPane;
   private JTextField textField;
   private JTable table;

   ArrayList<AccountVO> accountList;
   int cv1 = 0;
   String search = null;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               AdminAccountS frame = new AdminAccountS();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    * 
    * @throws SQLException
    * @throws ClassNotFoundException
    */
   public AdminAccountS() throws ClassNotFoundException, SQLException {
   	setTitle("\uD68C\uC6D0 \uC870\uD68C");
      AccountDAO adao = new AccountDAO();
      String id = adao.getLoginValue();

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 950, 600);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      setLocationRelativeTo(null);

      JComboBox comboBox = new JComboBox();
      comboBox.setFont(new Font("나눔고딕", Font.PLAIN, 12));
      comboBox.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            JComboBox comboBox = (JComboBox) arg0.getSource();
            cv1 = comboBox.getSelectedIndex();

         }
      });
      comboBox.setModel(new DefaultComboBoxModel(
            new String[] { "\uC544\uC774\uB514", "\uC774\uB984", "\uC804\uD654\uBC88\uD638" }));
      comboBox.setBounds(138, 130, 106, 25);
      contentPane.add(comboBox);

      textField = new JTextField();
      textField.setBounds(256, 130, 415, 25);
      contentPane.add(textField);
      textField.setColumns(10);

      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(138, 182, 533, 277);
      contentPane.add(scrollPane);

      String[] field = { "아이디", "이름", "전화번호", "이메일", "연체정보", "빌린 책수" };
      Object[] tableRow = new Object[6];
      DefaultTableModel tableModel = new DefaultTableModel(field, 0);
      table = new JTable(tableModel);
      scrollPane.setViewportView(table);

      RoundedButton3 button = new RoundedButton3("\uC870\uD68C");
      button.setFont(new Font("나눔고딕", Font.PLAIN, 12));
      button.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent e) {
            search = textField.getText();
            if (search.length() == 0)// 검색어가 있냐?
            {
               JOptionPane.showMessageDialog(null, "검색어를 입력하세요");// 오류 메세지 출력

            } else {
               if (cv1 == 0) {
                  if (e.getSource() == button) {
                     accountList = adao.searchId(search);

                     tableModel.setNumRows(0);

                     for (AccountVO i : accountList) {
                        tableRow[0] = i.getAccountId();
                        tableRow[1] = i.getAccountName();
                        tableRow[2] = i.getTel();
                        tableRow[3] = i.getEmail();
                        tableRow[4] = i.getOverdue();
                        tableRow[5] = i.getBookCnt();
                        tableModel.addRow(tableRow);
                     }
                  }
               } else if (cv1 == 1) {
                  if (e.getSource() == button) {
                     accountList = adao.searchName(search);

                     tableModel.setNumRows(0);

                     for (AccountVO i : accountList) {
                        tableRow[0] = i.getAccountId();
                        tableRow[1] = i.getAccountName();
                        tableRow[2] = i.getTel();
                        tableRow[3] = i.getEmail();
                        tableRow[4] = i.getOverdue();
                        tableRow[5] = i.getBookCnt();
                        tableModel.addRow(tableRow);
                     }
                  }
               } // end else if (cv1 == 1)
               else {
                  if (e.getSource() == button) {
                     accountList = adao.searchTel(search);

                     tableModel.setNumRows(0);

                     for (AccountVO i : accountList) {
                        tableRow[0] = i.getAccountId();
                        tableRow[1] = i.getAccountName();
                        tableRow[2] = i.getTel();
                        tableRow[3] = i.getEmail();
                        tableRow[4] = i.getOverdue();
                        tableRow[5] = i.getBookCnt();
                        tableModel.addRow(tableRow);
                     }
                  }
               }
            }
         }
      });
      button.setBounds(683, 130, 97, 26);
      contentPane.add(button);

      JLabel lblNewLabel = new JLabel("\uD68C\uC6D0 \uC870\uD68C");
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
      lblNewLabel.setBounds(345, 39, 195, 34);
      contentPane.add(lblNewLabel);

      RoundedButton3 btnNewButton = new RoundedButton3("\uC804\uCCB4\uC870\uD68C");
      btnNewButton.setFont(new Font("나눔고딕", Font.PLAIN, 12));
      btnNewButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (e.getSource() == btnNewButton) {

               accountList = adao.searchAll();

               tableModel.setNumRows(0);

               for (AccountVO i : accountList) {
                  tableRow[0] = i.getAccountId();
                  tableRow[1] = i.getAccountName();
                  tableRow[2] = i.getTel();
                  tableRow[3] = i.getEmail();
                  tableRow[4] = i.getOverdue();
                  tableRow[5] = i.getBookCnt();
                  tableModel.addRow(tableRow);
               }

            }

         }
      });
      btnNewButton.setBounds(683, 182, 97, 45);
      contentPane.add(btnNewButton);

      RoundedButton5 btnNewButton_1 = new RoundedButton5("\uC0AD\uC81C");
      btnNewButton_1.setFont(new Font("나눔고딕", Font.BOLD, 12));
      btnNewButton_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (e.getSource() == btnNewButton_1) {

               int row = table.getSelectedRow();
               if (row == -1) {
                  JOptionPane.showMessageDialog(null, "계정을 선택하세요");
                  return;
               }
               String id = (String) table.getValueAt(row, 0);

               int result = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?", "계정 삭제 창",
                     JOptionPane.YES_NO_OPTION);

               if (result == JOptionPane.YES_OPTION) {
                  if ((int) table.getValueAt(row, 5) > 0)
                     result = JOptionPane.showConfirmDialog(null, "빌린 책이 있습니다.\n 정말 삭제하시겠습니까?", "계정 삭제 창",
                           JOptionPane.YES_NO_OPTION);

                  if (result != JOptionPane.YES_OPTION)
                     return;

                  if (adao.signout(id))
                     JOptionPane.showMessageDialog(null, "삭제 되었습니다.");
               } else
                  return;

            }
         }
      });
      btnNewButton_1.setBounds(683, 371, 97, 84);
      contentPane.add(btnNewButton_1);
      
      RoundedButton6 btnNewButton_2 = new RoundedButton6("< Prev");
      btnNewButton_2.setBackground(Color.GRAY);
      btnNewButton_2.setFont(new Font("나눔고딕", Font.BOLD, 12));
      btnNewButton_2.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		dispose();
      		setVisible(false);
      		try {
				new Search().setVisible(true);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
      	}
      });
      btnNewButton_2.setBounds(42, 38, 79, 30);
      contentPane.add(btnNewButton_2);

   }
}