package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classOfDAO.BookDAO;
import classOfVO.BookVO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JToolBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class ManageBooks extends JFrame {

   private JPanel contentPane;
   private JTextField textField;
   private JTextField textField_1;
   private JTable table;
   BookDAO bdao = new BookDAO();
   BookVO bvo = new BookVO();
   ArrayList<BookVO> searchBkname;
   ArrayList<BookVO> searchBkwriter;
   ArrayList<BookVO> searchAllbk;
   ArrayList<BookVO> searchBKnW;
   private JTextField textField_2;
   private JTextField textField_3;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               ManageBooks frame = new ManageBooks();
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
   public ManageBooks() throws ClassNotFoundException, SQLException {
   	setTitle("\uB3C4\uC11C \uAD00\uB9AC");
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 950, 600);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
	setLocationRelativeTo(null);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(383, 187, 453, 277);
      contentPane.add(scrollPane);
      
      String [] field = {"������ȣ","��������","��������"};
      Object row[]= new Object[3];
      DefaultTableModel detable = new DefaultTableModel(field,0){
         public boolean isCellEditable(int rowindex,int mCollindex) {
            return false;
         }
         };
      table = new JTable(detable);
      table.setBorder(new LineBorder(Color.WHITE));
      table.setFont(new Font("����", Font.PLAIN, 12));
      table.setBackground(Color.WHITE);
      scrollPane.setViewportView(table);
      
      JLabel lblE = new JLabel("\uB3C4\uC11C \uAD00\uB9AC");
      lblE.setHorizontalAlignment(SwingConstants.CENTER);
      lblE.setFont(new Font("�������", Font.BOLD, 20));
      lblE.setBounds(345, 40, 195, 34);
      contentPane.add(lblE);
      
      JPanel panel_2 = new JPanel();
      panel_2.setBounds(69, 104, 300, 428);
      contentPane.add(panel_2);
      panel_2.setLayout(null);
      
      textField = new JTextField();
      textField.setBounds(96, 61, 187, 25);
      panel_2.add(textField);
      textField.setColumns(10);
      
      textField_1 = new JTextField();
      textField_1.setBounds(96, 96, 187, 25);
      panel_2.add(textField_1);
      textField_1.setColumns(10);
      
      JLabel lblNewLabel = new JLabel("\uB3C4\uC11C \uC81C\uBAA9");
      lblNewLabel.setFont(new Font("�������", Font.PLAIN, 12));
      lblNewLabel.setBounds(27, 67, 57, 15);
      panel_2.add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("\uB3C4\uC11C \uC800\uC790");
      lblNewLabel_1.setFont(new Font("�������", Font.PLAIN, 12));
      lblNewLabel_1.setBounds(27, 104, 57, 15);
      panel_2.add(lblNewLabel_1);
      
      JLabel label_4 = new JLabel("< \uB3C4\uC11C \uC870\uD68C >");
      label_4.setHorizontalAlignment(SwingConstants.CENTER);
      label_4.setFont(new Font("�������", Font.BOLD, 14));
      label_4.setBounds(95, 14, 127, 34);
      panel_2.add(label_4);
      
      RoundedButton3 btnNewDel = new RoundedButton3("\uC120\uD0DD\uD55C \uD589 \uC0AD\uC81C");
      btnNewDel.setFont(new Font("�������", Font.BOLD, 12));
      btnNewDel.setBounds(27, 335, 256, 28);
      panel_2.add(btnNewDel);
      
      
      RoundedButton3 btnNewSearch = new RoundedButton3("\uAC80\uC0C9");
      btnNewSearch.setFont(new Font("�������", Font.BOLD, 12));
      btnNewSearch.setBounds(27, 133, 256, 28);
      panel_2.add(btnNewSearch);
      
      
      RoundedButton5 btnNewUpdate = new RoundedButton5("\uC218\uC815");
      btnNewUpdate.setFont(new Font("�������", Font.BOLD, 12));
      btnNewUpdate.setBounds(27, 296, 127, 28);
      panel_2.add(btnNewUpdate);
      
      RoundedButton5 btnNewIns = new RoundedButton5("\uCD94\uAC00");
      btnNewIns.setFont(new Font("�������", Font.BOLD, 12));
      btnNewIns.setBounds(166, 296, 118, 28);
      panel_2.add(btnNewIns);
      
      JLabel label = new JLabel("\uB3C4\uC11C \uC81C\uBAA9");
      label.setFont(new Font("�������", Font.PLAIN, 12));
      label.setBounds(29, 228, 72, 15);
      panel_2.add(label);
      
      textField_2 = new JTextField();
      textField_2.setColumns(10);
      textField_2.setBounds(96, 223, 187, 25);
      panel_2.add(textField_2);
      
      JLabel label_1 = new JLabel("\uB3C4\uC11C \uC800\uC790");
      label_1.setFont(new Font("�������", Font.PLAIN, 12));
      label_1.setBounds(29, 263, 72, 15);
      panel_2.add(label_1);
      
      textField_3 = new JTextField();
      textField_3.setColumns(10);
      textField_3.setBounds(96, 258, 187, 25);
      panel_2.add(textField_3);
      
      JLabel label_2 = new JLabel("< \uB3C4\uC11C \uCD94\uAC00 / \uC218\uC815 / \uC0AD\uC81C >");
      label_2.setHorizontalAlignment(SwingConstants.CENTER);
      label_2.setFont(new Font("�������", Font.BOLD, 14));
      label_2.setBounds(61, 179, 195, 34);
      panel_2.add(label_2);
      btnNewIns.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnNewIns){
               try {
                  int insBnum=bdao.findBookNum();
               
               String insBname=textField_2.getText().trim();
                  String insBwriter = textField_3.getText().trim();

                  if (insBname.length() != 0 && insBwriter.length() != 0) {// �Ѵ� ������
                     int yesno = JOptionPane.showConfirmDialog(null,
                           "���� �̸� : " + insBname + "\n ���� ���� : " + insBwriter + "��(��) �߰� �Ͻðڽ��ϱ�?", "�߰�",
                           JOptionPane.YES_NO_OPTION);
                     if (yesno == 0) {

                        bdao.adminBookAdd(insBnum, insBname, insBwriter);
                        JOptionPane.showMessageDialog(null, "�߰� �Ǿ����ϴ�.\n������ȣ�� "+insBnum+"�� �Դϴ�.");
                     } // if--end

                  } else if (insBname.length() == 0) {
                     JOptionPane.showMessageDialog(null, "���������� �Է��ϼ���.");
                  } else if (insBwriter.length() == 0) {
                     JOptionPane.showMessageDialog(null, "�������ڸ� �Է��ϼ���.");
                  } // if2--end
               } catch (SQLException e1) {

                  e1.printStackTrace();
               } // try catch--end

            } // btn--end
            textField_2.setText("");
            textField_3.setText("");
         }//event--end
      });
      btnNewUpdate.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            if(e.getSource()==btnNewUpdate)
            {
               int row=table.getSelectedRow();
                  if(row!=-1) {
                  String upBname=textField_2.getText().trim();
                  String upBwriter=textField_3.getText().trim();   
                  int column=table.getSelectedColumn();
                  String outBkname = (String) table.getValueAt(row, 1);//������ ���� å�̸�
                  String outBkWname = (String) table.getValueAt(row, 2);//�����̸�
                     if(upBname.length()!=0 && upBwriter.length()!=0) {//��ĭ�� ������ ������
                        
                        
                        int yesno=JOptionPane.showConfirmDialog(null, outBkname+"��(��)"+upBname+"����\n"+outBkWname+"��(��)"+upBwriter+"���� �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
                        if(yesno==0) {
                           boolean b1=bdao.updateBook1(upBname, upBwriter, outBkname, outBkWname);//����,�̸� ���ùٲٱ�
                           JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.");
                        }
                        
                     }else if(upBname.length()==0 && upBwriter.length()!=0) {//�������ڸ� ������ ��
                        
                        int yesno=JOptionPane.showConfirmDialog(null, outBkWname+"��(��)"+upBwriter+"���� �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
                        if(yesno==0) {
                           bdao.updateBook2(outBkname,upBwriter);//���ڸ� �ٲٱ�
                           JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.");
                        }
                     
                     }else if(upBname.length()!=0 && upBwriter.length()==0) {//�����̸��� ������ ��
                        
                        int yesno=JOptionPane.showConfirmDialog(null, outBkname+"��(��)"+upBname+"���� �����Ͻðڽ��ϱ�?", "����", JOptionPane.YES_NO_OPTION);
                        if(yesno==0) {
                           bdao.updateBook3(outBkname,upBname);//�̸����ٲٱ�
                           JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.");
                        }
                     }else if(upBname.length()==0 && upBwriter.length()==0) {//�ƹ��͵����� ����
                        JOptionPane.showMessageDialog(null, "�����͸� �Է��ϼ���.");
                     }
                  textField_2.setText("");
                  textField_3.setText("");
               }else if(row==-1){
                  JOptionPane.showMessageDialog(null, "������ ���� �������ּ���.");
               }
               /*
                * if(index!=Integer.parseInt(num)){
           if(numCheck(num)){
              // ������
              showMessage("�̹� �ִ� ��ȣ�Դϴ�.");
                fnum.setText(getNum(index));

              return;
           }
        }
[��ó] [java] JTable Project(�߰�,����,�˻�,����)|�ۼ��� iCaan


                */
            }
         }
      });
      btnNewSearch.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String bkname = textField.getText().trim();
            String bkwriter = textField_1.getText().trim();
            Object [] row2 = new Object [3];
            Object [] row3 = new Object [3];
            try {
               if(e.getSource()==btnNewSearch)
                  {
                  
                  searchBkname = bdao.searchBookByName(bkname);
                  searchBkwriter = bdao.searchBookW(bkwriter);
                  searchAllbk = bdao.searchBook();
                  searchBKnW = bdao.searchBookandW(bkname, bkwriter);
                  detable.setNumRows(0);
                  if (bkname.length()==0 && bkwriter.length()==0){//�̸�����, �����Է½�
                     JOptionPane.showMessageDialog(null, "�˻�� �Է��ϼ���");
                     }
                  
                  else if(bkname.length() ==0 && bkwriter.length()!=0){
                        
                        for (int j = 0; j < searchBkwriter.size(); j++) {
                           
                           BookVO bvo1 = searchBkwriter.get(j);      
                           row2[0]= bvo1.getBookId();
                           row2[1]= bvo1.getBookName();
                           row2[2]= bvo1.getBookWriter();
                           detable.addRow(row2);
                        }
                  
                        
                     }else if(bkname.length() !=0 && bkwriter.length()==0) {//���ڰ���,�̸��Է½�
                        
                        for (int i = 0; i < searchBkname.size(); i++) {
                           bvo= searchBkname.get(i);
                           row[0]=bvo.getBookId();
                           row[1]=bvo.getBookName();
                           row[2]=bvo.getBookWriter();
                           detable.addRow(row);
                     } 
                     }else if(bkname.length() !=0 && bkwriter.length()!=0){//�Ѵ� �Է½�
                        
                        
                           for (int i = 0; i < searchBKnW.size(); i++) {
                              
                           BookVO bvo2 =  searchBKnW.get(i);
                           row3[0]=bvo2.getBookId();
                           row3[1]=bvo2.getBookName();
                           row3[2]=bvo2.getBookWriter();
                           detable.addRow(row3);
               
                           }
                           
                           
                        }
                     
                     }//if tflength--end
               textField.setText("");
               textField_1.setText("");
                  }//btn event -- end
               
               
               
               
             catch (SQLException e1) {
               e1.printStackTrace();
            }
            
            
         }
      });
      btnNewDel.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnNewDel)
            {
               int row=0;
               
               row= table.getSelectedRow();
               if(row!=-1)
               {
               
               int column = table.getSelectedColumn();
               String value = (String) table.getValueAt(row, 1);
               System.out.println(value);
                 if(row < 0){
                     JOptionPane.showMessageDialog(null, "������ ���� ������ �ּ���.");
                 }else{
                    int result =JOptionPane.showConfirmDialog(null, table.getValueAt(row, column) + "��(��) ���� �����Ͻðڽ��ϱ�?", "���",JOptionPane.YES_NO_OPTION);
                    
                     if(result==0)
                     {
                    detable.removeRow(row);
                  boolean del = bdao.deleteBook(value);
                     
                  if(del)
                  {
                     JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.");
                  }else
                  JOptionPane.showMessageDialog(null, "������ �����Ͽ����ϴ�.");
                     }
                 }
               }else if(row==-1){
                  JOptionPane.showMessageDialog(null, "������ ���� �����ϼ���.");
               }//row if --end
            
         
         
      

            }
         }
      });
      
      RoundedButton3 btnNewButton = new RoundedButton3("\uC804\uCCB4 \uB3C4\uC11C \uC870\uD68C");
      btnNewButton.setFont(new Font("�������", Font.BOLD, 12));
      btnNewButton.setBounds(383, 123, 453, 48);
      contentPane.add(btnNewButton);
      
      RoundedButton6 btnNewButton_1 = new RoundedButton6("< Prev");
      btnNewButton_1.setBackground(Color.GRAY);
      btnNewButton_1.setFont(new Font("�������", Font.BOLD, 12));
      btnNewButton_1.addMouseListener(new MouseAdapter() {
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
      btnNewButton_1.setBounds(42, 38, 79, 30);
      contentPane.add(btnNewButton_1);
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btnNewButton)
            {
               detable.setNumRows(0);
               try {
                  searchAllbk = bdao.searchBook();
                  for(int j = 0; j < searchAllbk.size(); j++) {
                     BookVO bvo1 = searchAllbk.get(j);
                     row[0] = bvo1.getBookId();
                     row[1] = bvo1.getBookName();
                     row[2] = bvo1.getBookWriter();
                     detable.addRow(row);

                  }//for---end
                  
               } catch (SQLException e1) {
                  // TODO Auto-generated catch block
                  e1.printStackTrace();
               }
            }
         }
      });
   }
}