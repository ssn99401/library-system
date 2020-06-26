package jframe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classOfDAO.AccountDAO;
import classOfDAO.BookDAO;
import classOfDAO.RentalDAO;
import classOfVO.BookVO;
import jframe.RoundedButton5;

public class Books extends JFrame {

	private JPanel contentPane;
	private JTextField textField01;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JButton btnNewButton_1;
	private JButton btnNewButton_3;
	ArrayList<BookVO> searchlist;
	int cv1;
	String search01 = null;
	private JButton btnPrev;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Books frame = new Books();
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
	public Books() throws ClassNotFoundException, SQLException {
		setTitle("\uB3C4\uC11C \uC870\uD68C/\uB300\uC5EC");
		
		AccountDAO adao =  new AccountDAO();
		String id=adao.getLoginValue();
		BookDAO bdao = new BookDAO();
		RentalDAO rdao = new RentalDAO();
		
		ArrayList<BookVO> allbooklist = bdao.searchBook();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 68, 115));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		textField01 = new JTextField();
		textField01.setFont(new Font("�������", Font.PLAIN, 12));
		textField01.setBounds(270, 119, 391, 30);
		contentPane.add(textField01);
		textField01.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(144, 167, 517, 266);
		contentPane.add(scrollPane);

		String[] field = { "������ȣ", "��������", "��������" };
		Object row[] = new Object[3];
		DefaultTableModel demotable = new DefaultTableModel(field, 0) {
			public boolean isCellEditable(int rowindex, int mCollindex) {
				return false;
			}
		};
		table = new JTable(demotable);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);

		table = new JTable(demotable);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		////�뿩 ��ư
		btnNewButton_1 = new RoundedButton2("\uB300\uC5EC");
		btnNewButton_1.setFont(new Font("�������", Font.BOLD, 15));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(null, "å�� �����ϼ���");
					return;
				}
				int result = JOptionPane.showConfirmDialog(null, "�뿩�Ͻðڽ��ϱ�?","�뿩 Ȯ�� â",JOptionPane.YES_NO_OPTION);
				int rentResult;
				try {
					if (result == JOptionPane.YES_OPTION)
						rentResult = rdao.rentBook(id, (int)table.getValueAt(row, 0));
					else {
						return;					
					}
					
					/*
					 * �� 4���� ���� ����
					 * -1; // 
					 * -2; // ����å�� 2���� �Դϴ�.
					 * -3; //���� å���� �ݳ��ϼ���!
					 * -4; // ��ü�ϼ̽��ϴ�.
					 */
					
					
					switch (rentResult) {
					case -1:
						JOptionPane.showMessageDialog(null, "�̹� �뿩���� å�Դϴ�.");
						break;
					case -2:
						JOptionPane.showMessageDialog(null, "����å�� 2���� �Դϴ�.");
						break;
					case -3:
						JOptionPane.showMessageDialog(null, "���� å���� �ݳ��ϼ���!");
						break;
					case -4:
						JOptionPane.showMessageDialog(null, "��ü�ϼ̽��ϴ�.");
						break;

					case 1:
						JOptionPane.showMessageDialog(null, "�뿩�Ǿ����ϴ�.");
						dispose();
						setVisible(false);
						new Main().setVisible(true);
						
						break;
					default : 
						System.out.println(rentResult);
						break;
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				

			}
		});
		
		btnNewButton_1.setBounds(144, 452, 646, 46);
		contentPane.add(btnNewButton_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("�������", Font.PLAIN, 12));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBox = (JComboBox) e.getSource();
				cv1 = comboBox.getSelectedIndex();// 0 = �������� // 1=��������

				/*
				 * JComboBox cb = (JComboBox) e.getSource(); // �޺��ڽ� �˾Ƴ���
				 * 
				 * int index = cb.getSelectedIndex();// ���õ� �������� �ε���
				 * 
				 */
			}
		});
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "\uB3C4\uC11C\uC81C\uBAA9", "\uB3C4\uC11C\uC800\uC790" }));
		comboBox.setBounds(144, 119, 114, 30);
		contentPane.add(comboBox);

		Object searchRow[] = new Object[3];
		RoundedButton5 btnNewButton_2 = new RoundedButton5("\uAC80\uC0C9");
		btnNewButton_2.setFont(new Font("�������", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				search01 = textField01.getText();
				if (search01.length() == 0)// �˻�� �ֳ�?
				{
					JOptionPane.showMessageDialog(null, "�˻�� �Է��ϼ���");// ���� �޼��� ��� }

				} else {
					if (cv1 == 0) {
						if (e.getSource() == btnNewButton_2)// �˻���ư ������ ��
						{

							try {

								searchlist = bdao.searchBookByName(search01);
							} catch (SQLException e1) {

								e1.printStackTrace();
							} // try-catch--end
							demotable.setNumRows(0);

							for (int j = 0; j < searchlist.size(); j++) {
								BookVO bvo1 = searchlist.get(j);
								searchRow[0] = bvo1.getBookId();
								searchRow[1] = bvo1.getBookName();
								searchRow[2] = bvo1.getBookWriter();
								demotable.addRow(searchRow);

							} // for---end
							textField01.setText("");

						} // event--end
					} else {
						if (e.getSource() == btnNewButton_2) {
							search01 = textField01.getText();
							try {
								ArrayList<BookVO> searchWlist = bdao.searchBookW(search01);
								demotable.setNumRows(0);

								for (int j = 0; j < searchWlist.size(); j++) {
									BookVO bvo2 = searchWlist.get(j);
									searchRow[0] = bvo2.getBookId();
									searchRow[1] = bvo2.getBookName();
									searchRow[2] = bvo2.getBookWriter();
									demotable.addRow(searchRow);

								} // for--end
								textField01.setText("");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} // try-catch---end
						} // event2--end
					} // cv1 if--end
				} // search if --end
			}
		});

		btnNewButton_2.setBounds(676, 119, 114, 30);
		contentPane.add(btnNewButton_2);

		btnNewButton_3 = new RoundedButton3("\uC804\uCCB4\r\n\uB3C4\uC11C\r\n\uC870\uD68C");
		btnNewButton_3.setFont(new Font("�������", Font.PLAIN, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookVO bvo = new BookVO();
				demotable.setNumRows(0);

				for (int j = 0; j < allbooklist.size(); j++) {// ��ü�˻�
					bvo = allbooklist.get(j);
					row[0] = bvo.getBookId();
					row[1] = bvo.getBookName();
					row[2] = bvo.getBookWriter();
					demotable.addRow(row);
				}
			}
		});
		btnNewButton_3.setBounds(676, 168, 114, 65);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		if(id!=null) {
			lblNewLabel.setText(id+"�� ȯ���մϴ�.");
		}
		lblNewLabel.setBounds(140, 53, 142, 15);
		contentPane.add(lblNewLabel);
		
		btnPrev = new RoundedButton("< prev");
		btnPrev.setFont(new Font("�������", Font.BOLD, 12));
		btnPrev.setText("<  Prev");
		btnPrev.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				try {
					new Main().setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnPrev.setBounds(42, 38, 79, 30);
		contentPane.add(btnPrev);
		
		btnNewButton = new RoundedButton5("\uB3C4\uC11C\uBC18\uB0A9");
		btnNewButton.setText("\uB3C4\uC11C \uBC18\uB0A9");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				try {
					new ReturnBook().setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("�������", Font.BOLD, 13));
		btnNewButton.setBounds(676, 340, 114, 93);
		contentPane.add(btnNewButton);

	
	}
}