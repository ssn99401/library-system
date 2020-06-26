package jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classOfDAO.AccountDAO;
import classOfDAO.BookDAO;
import classOfDAO.RentalDAO;
import classOfVO.BookVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class ReturnBook extends JFrame {

	private JPanel contentPane;
	private JTextField tfLentInfo01;
	private JTextField tfLentInfo02;
	private ArrayList<BookVO> arrBook;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
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
	public ReturnBook() throws SQLException, ClassNotFoundException {
		setTitle("\uB3C4\uC11C \uBC18\uB0A9");
		BookDAO bdao = new BookDAO();
		RentalDAO rdao = new RentalDAO();
		AccountDAO adao = new AccountDAO();
		String id = adao.getLoginValue();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 68, 115));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblInfo01 = new JLabel(
				"");
		lblInfo01.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo01.setForeground(Color.WHITE);
		if(id!=null) {
			lblInfo01.setText(id + " È¸¿ø´ÔÀÇ µµ¼­ ´ë¿© ¸ñ·ÏÀÔ´Ï´Ù.");
		}
		lblInfo01.setFont(new Font("±¼¸²", Font.BOLD, 19));
		lblInfo01.setBounds(177, 127, 529, 41);
		contentPane.add(lblInfo01);

		// ¹Ý³³µÇ´Â Ã¥ ¼±ÅÃ
		tfLentInfo01 = new JTextField();
		tfLentInfo01.setBounds(263, 194, 358, 23);
		tfLentInfo01.setColumns(10);

		JCheckBox checkBox01 = new JCheckBox("");
		checkBox01.setBounds(629, 194, 34, 23);
		checkBox01.setBackground(new Color(40, 68, 115));

		tfLentInfo02 = new JTextField();
		tfLentInfo02.setColumns(10);
		tfLentInfo02.setBounds(263, 234, 358, 23);

		JCheckBox checkBox02 = new JCheckBox("");
		checkBox02.setBackground(new Color(40, 68, 115));
		checkBox02.setBounds(629, 234, 34, 23);

		arrBook = bdao.searchBookOfAccount(id);

		if (arrBook.size() == 0) {

		}

		else if (arrBook.size() > 0) {

			tfLentInfo01.setText(arrBook.get(0).getBookName() + "( " + arrBook.get(0).getBookWriter() +" )");
			contentPane.add(tfLentInfo01);
			contentPane.add(checkBox01);
		}
		
		if (arrBook.size() == 2) {
			tfLentInfo02.setText(arrBook.get(1).getBookName() + "( " + arrBook.get(1).getBookWriter() +" )");
			contentPane.add(tfLentInfo02);
			contentPane.add(checkBox02);
			

		}
		
		JLabel lblInfo02 = new JLabel("\uBC18\uB0A9\uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
		lblInfo02.setForeground(Color.WHITE);
		lblInfo02.setFont(new Font("³ª´®°íµñ", Font.BOLD, 13));
		lblInfo02.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo02.setBounds(387, 330, 144, 23);
		contentPane.add(lblInfo02);

		RoundedButton2 button = new RoundedButton2("\uBC18\uB0A9");
		button.setFont(new Font("³ª´®°íµñ", Font.BOLD, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arrBook.size() == 0) {
					JOptionPane.showMessageDialog(null, "¹Ý³³ÇÒ Ã¥ÀÌ ¾ø½À´Ï´Ù.");
					return;
				}

				else if (arrBook.size() > 0) {
					if (checkBox01.isSelected()) {
						try {
							System.out.println(rdao.returnBook(id,arrBook.get(0).getBookId()));	
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

				if (arrBook.size() == 2) {
					if (checkBox02.isSelected()) {
						try {
							System.out.println(rdao.returnBook(id,arrBook.get(1).getBookId()));	
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
				JOptionPane.showMessageDialog(null, "¹Ý³³µÇ¾ú½À´Ï´Ù.");
				
				try {
					new ReturnBook().setVisible(true);
					dispose();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			
		});
		button.setBounds(247, 369, 425, 58);
		contentPane.add(button);
		
		RoundedButton btnNewButton = new RoundedButton("< Prev");
		btnNewButton.setFont(new Font("³ª´®°íµñ", Font.BOLD, 12));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					dispose();
					setVisible(false);
					new Main().setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(42, 38, 79, 30);
		contentPane.add(btnNewButton);
	}
}
