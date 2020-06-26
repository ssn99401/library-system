package jframe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import classOfDAO.AccountDAO;
import classOfDAO.SeatDAO;
import classOfVO.AccountVO;
import classOfVO.LoginIdVO;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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

	public Main() throws ClassNotFoundException, SQLException {
		setTitle("OO\uB3D9\uB124 \uB3C4\uC11C\uAD00");
		AccountDAO account = new AccountDAO();
		AccountVO av = new AccountVO();
		String id = account.getLoginValue();
		SeatDAO seat = new SeatDAO();

		Login lgin = new Login();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 68, 115));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		// JLabel - È¯¿µÇÕ´Ï´Ù
		JLabel lbllogininfo01 = new JLabel("");
		if (id != null) {
			lbllogininfo01.setText(id + "´Ô È¯¿µÇÕ´Ï´Ù.");
		}
		lbllogininfo01.setForeground(Color.white);
		lbllogininfo01.setFont(new Font("³ª´®°íµñ", Font.BOLD, 13));
		lbllogininfo01.setBounds(124, 33, 172, 38);
		contentPane.add(lbllogininfo01);

		// JLabel - OOµ¿³× µµ¼­°ü
		JLabel lblInfo01 = new JLabel("OO\uB3D9\uB124 \uB3C4\uC11C\uAD00");
		lblInfo01.setForeground(Color.WHITE);
		lblInfo01.setFont(new Font("³ª´®°íµñ", Font.BOLD, 22));
		lblInfo01.setBounds(124, 144, 154, 59);
		contentPane.add(lblInfo01);

		// JButton - ·Î±×¾Æ¿ô
		RoundedButton btnLogout01 = new RoundedButton("Logout");
		btnLogout01.setText("\uB85C\uADF8\uC544\uC6C3");
		btnLogout01.setFont(new Font("³ª´®°íµñ", Font.BOLD, 12));
		if (id == null) {
			btnLogout01.setText("Login");
		}
		btnLogout01.setBackground(Color.WHITE);
		btnLogout01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource().equals(btnLogout01) && btnLogout01.getText().equals("Login")) {
					try {
						new Login().setVisible(true);
						dispose();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (e.getSource().equals(btnLogout01) && !btnLogout01.getText().equals("Login")) {
					try {
						int result1 = JOptionPane.showConfirmDialog(null, "·Î±×¾Æ¿ô ÇÏ½Ã°Ú½À´Ï±î?", "·Î±×¾Æ¿ô",
								JOptionPane.YES_NO_OPTION);
						if (result1 == JOptionPane.YES_OPTION) {
							account.logout();
							dispose();
							setVisible(false);
							try {
								new Main().setVisible(true);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnLogout01.setBounds(617, 33, 84, 29);
		contentPane.add(btnLogout01);

		// JButton - ¿­¶÷½Ç´ë¿©
		JButton btnSrLent01 = new JButton("¿­¶÷½Ç´ë¿©");
		btnSrLent01.setVerticalAlignment(SwingConstants.TOP);
		btnSrLent01.setFont(new Font("³ª´®¹Ù¸¥°íµñ", Font.BOLD, 22));
		btnSrLent01.setText("");
		btnSrLent01.setForeground(new Color(0, 0, 128));
		btnSrLent01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				setVisible(false);
				try {
					if (id == null) {
						new Login().setVisible(true);

					} else {
						new Seats().setVisible(true);
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnSrLent01.setIcon(new ImageIcon(Main.class.getResource("/image/main01.PNG")));
		btnSrLent01.setBackground(Color.WHITE);
		btnSrLent01.setBounds(124, 249, 276, 215);
		contentPane.add(btnSrLent01);

		// JButton - µµ¼­ Á¶È¸/´ë¿©/¹Ý³³
		JButton btnBkSLR01 = new JButton("");
		btnBkSLR01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
				try {
					if (id == null) {
						new Login().setVisible(true);

					} else {
						new BookMain().setVisible(true);
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnBkSLR01.setIcon(new ImageIcon(Main.class.getResource("/image/main02.PNG")));
		btnBkSLR01.setBackground(Color.WHITE);
		btnBkSLR01.setBounds(520, 249, 276, 215);
		contentPane.add(btnBkSLR01);

		// JButton - È¸¿øÅ»Åð
		RoundedButton btnCntDel01 = new RoundedButton("\uD68C\uC6D0\uD0C8\uD1F4");
		btnCntDel01.setFont(new Font("³ª´®°íµñ", Font.BOLD, 12));
		btnCntDel01.setBackground(Color.WHITE);
		btnCntDel01.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					int result = JOptionPane.showConfirmDialog(null, "Á¤¸» È¸¿ø Å»Åð¸¦ ÇÏ½Ã°Ú½À´Ï±î?", "È¸¿ø Å»Åð",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.CLOSED_OPTION) {
					} else if (result == JOptionPane.YES_OPTION) {
						
						//AccountDAO ÅëÇØ¼­ delete±â´É Ãß°¡
						//deleteÈÄ ·Î±×¾Æ¿ôÇÑÃ¤ ·Î±×ÀÎ ÆûÀ¸·Î ÀÌµ¿
						System.out.println(id);
						account.signout(id);
						dispose();
						setVisible(false);
						new Login().setVisible(true);
						
					} else {
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnCntDel01.setBounds(712, 33, 84, 29);
		contentPane.add(btnCntDel01);
	}
}