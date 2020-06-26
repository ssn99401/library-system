package jframe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import classOfDAO.AccountDAO;

public class Gaip extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gaip frame = new Gaip();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gaip() {
		setTitle("\uD68C\uC6D0\uAC00\uC785");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 68, 115));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblJoongbok;
		RoundedButton btnPrev = new RoundedButton("Prev");
		btnPrev.setText("<  Prev");
		btnPrev.setFont(new Font("나눔고딕", Font.BOLD, 13));
		btnPrev.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				try {
					new Login().setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrev.setBounds(42, 38, 79, 30);
		contentPane.add(btnPrev);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(40, 68, 115));
		desktopPane.setBounds(235, 130, 464, 309);
		contentPane.add(desktopPane);

		JLabel label = new JLabel("\uC544 \uC774 \uB514 ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("나눔고딕", Font.BOLD, 13));
		label.setBounds(16, 40, 57, 15);
		desktopPane.add(label);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(85, 37, 231, 23);
		desktopPane.add(textField);

		JLabel label_1 = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("나눔고딕", Font.BOLD, 13));
		label_1.setBounds(13, 103, 60, 15);
		desktopPane.add(label_1);

		JLabel label_2 = new JLabel("\uC774  \uB984");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("나눔고딕", Font.BOLD, 13));
		label_2.setBounds(16, 168, 57, 15);
		desktopPane.add(label_2);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(85, 165, 231, 23);
		desktopPane.add(textField_2);

		JLabel label_3 = new JLabel("\uC774 \uBA54 \uC77C");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("나눔고딕", Font.BOLD, 13));
		label_3.setBounds(16, 266, 57, 15);
		desktopPane.add(label_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(85, 263, 231, 23);
		desktopPane.add(textField_4);
		lblJoongbok = new JLabel(" ");
		lblJoongbok.setFont(new Font("나눔고딕", Font.BOLD, 10));
		lblJoongbok.setForeground(Color.ORANGE);
		lblJoongbok.setHorizontalAlignment(SwingConstants.LEFT);
		lblJoongbok.setBounds(85, 70, 275, 15);
		desktopPane.add(lblJoongbok);
		RoundedButton4 btnNewButton_1 = new RoundedButton4("\uC911\uBCF5\uD655\uC778");
		btnNewButton_1.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					AccountDAO dao = new AccountDAO();
					ArrayList<String> idList = dao.searchForId();
					System.out.println(textField.getText().indexOf(" "));
					for (int i = 0; i < idList.size(); i++) {
						if (!idList.get(i).equals(textField.getText())) {
							if (textField.getText().indexOf(" ") >= 0) {
								lblJoongbok.setText("아이디는 띄워쓸 수 없습니다.");
								break;
							} else {
								if (textField.getText().equals("")) {
									lblJoongbok.setText("아이디를 입력해주세요.");
								} else {
									lblJoongbok.setText("해당 아이디는 사용가능합니다.");
								}
							}

						} else if (idList.get(i).equals(textField.getText())) {

							lblJoongbok.setText("해당 아이디는 이미 존재합니다.");
							break;
						}

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
		btnNewButton_1.setBounds(336, 36, 77, 23);
		desktopPane.add(btnNewButton_1);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(85, 100, 231, 23);
		desktopPane.add(passwordField);

		JLabel label_4 = new JLabel("\uC804\uD654\uBC88\uD638");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("나눔고딕", Font.BOLD, 13));
		label_4.setBounds(12, 216, 62, 15);
		desktopPane.add(label_4);

		textField_3 = new JTextField();
		textField_3.setBounds(86, 213, 230, 23);
		desktopPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel label_5 = new JLabel(
				"\uBE44\uBC00\uBC88\uD638\uB294 8\uC790\uC774\uC0C1 ,\uD2B9\uC218\uBB38\uC790,\uC22B\uC790,\uC601\uBB38\uC758 \uC870\uD569");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(Color.ORANGE);
		label_5.setFont(new Font("나눔고딕", Font.BOLD, 10));
		label_5.setBounds(85, 133, 286, 15);
		desktopPane.add(label_5);

		RoundedButton2 btnGaipPlz = new RoundedButton2("\uD68C\uC6D0\uAC00\uC785");
		btnGaipPlz.setBounds(336, 164, 77, 72);
		desktopPane.add(btnGaipPlz);
		btnGaipPlz.setText("\uB4F1\uB85D");
		btnGaipPlz.setFont(new Font("나눔고딕", Font.BOLD, 13));

		RoundedButton3 btnGaipBack = new jframe.RoundedButton3("\uD68C\uC6D0\uAC00\uC785");
		btnGaipBack.setBounds(336, 253, 77, 31);
		desktopPane.add(btnGaipBack);
		btnGaipBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
				try {
					new Login().setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnGaipBack.setText("\uCDE8\uC18C");
		btnGaipBack.setFont(new Font("나눔고딕", Font.BOLD, 13));

		btnGaipPlz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					AccountDAO dao = new AccountDAO();
					if (lblJoongbok.getText().equals("해당 아이디는 사용가능합니다.")) {
						boolean b = dao.signup(textField.getText(), passwordField.getText(), textField_2.getText(),
								textField_3.getText(), textField_4.getText());
						if (b == true) {
						
							JOptionPane.showMessageDialog(null, "회원가입이 정상적으로 완료되었어요!!");
							dispose();
							setVisible(false);
							new Login().setVisible(true);
						}else if(passwordField.getText().length()<8){
							JOptionPane.showMessageDialog(null, "비밀번호는 8자이상으로 입력해주세요.");
						}
						
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

		JLabel lblNewLabel = new JLabel("\uD68C \uC6D0 \uAC00 \uC785");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 15));
		lblNewLabel.setBounds(324, 83, 242, 49);
		contentPane.add(lblNewLabel);

	}
}