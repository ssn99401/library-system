package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classOfDAO.AccountDAO;
import classOfDAO.BookDAO;
import classOfVO.BookVO;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Book;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.border.LineBorder;

public class BookMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookMain frame = new BookMain();
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
	public BookMain() throws ClassNotFoundException, SQLException {
		setTitle("\uB3C4\uC11C \uC870\uD68C/\uB300\uC5EC");
		ArrayList<BookVO> arrBook;
		String id = new AccountDAO().getLoginValue();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 68, 115));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblLogin = new JLabel("");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		if(id !=null) {
			lblLogin.setText(id + "¥‘¿« µµº≠ ¥Îø©∏Ò∑œ¿‘¥œ¥Ÿ");
		}
		
		lblLogin.setFont(new Font("≥™¥Æ∞ÌµÒ ExtraBold", Font.BOLD, 21));
		lblLogin.setBounds(210, 72, 501, 59);
		contentPane.add(lblLogin);
		
		JLabel lblLog2 = new JLabel("");
		lblLog2.setFont(new Font("≥™¥Æ∞ÌµÒ", Font.BOLD, 14));
		lblLog2.setForeground(Color.WHITE);
		
		lblLog2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLog2.setBounds(308, 124, 305, 15);
		contentPane.add(lblLog2);
		
		JLabel tfLentInfo01 = new JLabel("");
		tfLentInfo01.setFont(new Font("≥™¥Æ∞ÌµÒ", Font.BOLD, 12));
		tfLentInfo01.setForeground(Color.WHITE);
		tfLentInfo01.setHorizontalAlignment(SwingConstants.CENTER);
		tfLentInfo01.setBounds(196, 200, 528, 15);
		
		contentPane.add(tfLentInfo01);
		JLabel tfLentInfo02 = new JLabel("");
		tfLentInfo02.setFont(new Font("≥™¥Æ∞ÌµÒ", Font.BOLD, 12));
		tfLentInfo02.setForeground(Color.WHITE);
		tfLentInfo02.setHorizontalAlignment(SwingConstants.CENTER);
		tfLentInfo02.setBounds(196, 224, 528, 15);
		
		contentPane.add(tfLentInfo02);
		arrBook = new BookDAO().searchBookOfAccount(id);
		if (arrBook.size() == 0) {

		}

		else if (arrBook.size() > 0) {

			tfLentInfo01.setText( arrBook.get(0).getBookName() );
			
			
		}

		if (arrBook.size() == 2) {
			tfLentInfo02.setText(arrBook.get(1).getBookName() );
			
			

		}
		lblLog2.setText("( "+id+"¥‘¿∫ √— "+arrBook.size() + "±« ¥Îø©¡ﬂ¿‘¥œ¥Ÿ. )");
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				try {
					new Books().setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(BookMain.class.getResource("/image/select.png")));
		btnNewButton.setBounds(166, 283, 252, 195);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
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
		btnNewButton_1.setIcon(new ImageIcon(BookMain.class.getResource("/image/return.png")));
		btnNewButton_1.setBounds(498, 283, 252, 195);
		contentPane.add(btnNewButton_1);
		
		RoundedButton btnNewButton_2 = new RoundedButton("<  Prev");
		btnNewButton_2.setFont(new Font("≥™¥Æ∞ÌµÒ", Font.BOLD, 12));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
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
		btnNewButton_2.setBounds(42, 38, 79, 30);
		contentPane.add(btnNewButton_2);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(Color.WHITE, 2));
		horizontalBox.setForeground(Color.WHITE);
		horizontalBox.setBackground(Color.WHITE);
		horizontalBox.setBounds(165, 164, 585, 1);
		contentPane.add(horizontalBox);

	}
}
