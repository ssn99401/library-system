package jframe;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classOfDAO.AccountDAO;
import classOfDAO.SeatDAO;
import classOfVO.AccountVO;
import classOfVO.LoginIdVO;
import classOfVO.SeatVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Seats extends JFrame {

	private JPanel contentPane;
	private static Color cg1 = new Color(230, 83, 105);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seats frame = new Seats();
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

	public Seats() throws ClassNotFoundException, SQLException {
		setTitle("\uC5F4\uB78C\uC2E4");

		AccountDAO account = new AccountDAO();
		String id = account.getLoginValue();
		AccountVO av = new AccountVO();

		SeatDAO seat = new SeatDAO();
		ArrayList<SeatVO> listSeat = seat.selectSeat();
		JLabel lblNewLabel;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 68, 115));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JLabel lblSeatsMain = new JLabel("\uC5F4\uB78C\uC2E4 \uC88C\uC11D \uD604\uD669");
		lblSeatsMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeatsMain.setForeground(Color.WHITE);
		lblSeatsMain.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 24));
		lblSeatsMain.setBounds(346, 74, 221, 55);
		contentPane.add(lblSeatsMain);
		// 갯수라벨 지정
		lblNewLabel = new JLabel("\uB0A8\uC740\uC88C\uC11D : \uAC1C");
		lblNewLabel.setFont(new Font("나눔고딕", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(374, 132, 164, 15);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText("( \uB0A8\uC740\uC88C\uC11D : 1\uAC1C  )");

		RoundedButton7 btnNewButton = new RoundedButton7("1"), btnNewButton_1 = new RoundedButton7("2"), btnNewButton_2 = new RoundedButton7("3"),
				btnNewButton_3 = new RoundedButton7("4"), btnNewButton_4 = new RoundedButton7("5"), btnNewButton_5 = new RoundedButton7("6"),
				btnNewButton_6 = new RoundedButton7("7"), btnNewButton_7 = new RoundedButton7("8"), btnNewButton_8 = new RoundedButton7("9"),
				btnNewButton_9 = new RoundedButton7("10"), btnNewButton_10 = new RoundedButton7("11"),
				btnNewButton_11 = new RoundedButton7("12"), btnNewButton_12 = new RoundedButton7("13"),
				btnNewButton_13 = new RoundedButton7("14"), btnNewButton_14 = new RoundedButton7("15"),
				btnNewButton_15 = new RoundedButton7("16"), btnNewButton_16 = new RoundedButton7("17"),
				btnNewButton_17 = new RoundedButton7("18"), btnNewButton_18 = new RoundedButton7("19"),
				btnNewButton_19 = new RoundedButton7("20"), btnNewButton_20 = new RoundedButton7("21"),
				btnNewButton_21 = new RoundedButton7("22"), btnNewButton_22 = new RoundedButton7("23"),
				btnNewButton_23 = new RoundedButton7("24"), btnNewButton_24 = new RoundedButton7("25"),
				btnNewButton_25 = new RoundedButton7("26"), btnNewButton_26 = new RoundedButton7("27"),
				btnNewButton_27 = new RoundedButton7("28"), btnNewButton_28 = new RoundedButton7("29"),
				btnNewButton_29 = new RoundedButton7("30"), btnNewButton_30 = new RoundedButton7("31"),
				btnNewButton_31 = new RoundedButton7("32"), btnNewButton_32 = new RoundedButton7("33"),
				btnNewButton_33 = new RoundedButton7("34"), btnNewButton_34 = new RoundedButton7("35"),
				btnNewButton_35 = new RoundedButton7("36"), btnNewButton_36 = new RoundedButton7("37"),
				btnNewButton_37 = new RoundedButton7("38"), btnNewButton_38 = new RoundedButton7("39"),
				btnNewButton_39 = new RoundedButton7("40"), btnNewButton_40 = new RoundedButton7("41"),
				btnNewButton_41 = new RoundedButton7("42"), btnNewButton_42 = new RoundedButton7("43"),
				btnNewButton_43 = new RoundedButton7("44"), btnNewButton_44 = new RoundedButton7("45"),
				btnNewButton_45 = new RoundedButton7("46"), btnNewButton_46 = new RoundedButton7("47"),
				btnNewButton_47 = new RoundedButton7("48"), btnNewButton_48 = new RoundedButton7("49"),
				btnNewButton_49 = new RoundedButton7("50");
		btnNewButton_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_14.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_13.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_12.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_11.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_10.setHorizontalAlignment(SwingConstants.LEADING);
																				
		ArrayList<JButton> arrayButton = new ArrayList<JButton>();
		arrayButton.add(btnNewButton);
		arrayButton.add(btnNewButton_1);
		arrayButton.add(btnNewButton_2);
		arrayButton.add(btnNewButton_3);
		arrayButton.add(btnNewButton_4);
		arrayButton.add(btnNewButton_5);
		arrayButton.add(btnNewButton_6);
		arrayButton.add(btnNewButton_7);
		arrayButton.add(btnNewButton_8);
		arrayButton.add(btnNewButton_9);
		arrayButton.add(btnNewButton_10);
		arrayButton.add(btnNewButton_11);
		arrayButton.add(btnNewButton_12);
		arrayButton.add(btnNewButton_13);
		arrayButton.add(btnNewButton_14);
		arrayButton.add(btnNewButton_15);
		arrayButton.add(btnNewButton_16);
		arrayButton.add(btnNewButton_17);
		arrayButton.add(btnNewButton_18);
		arrayButton.add(btnNewButton_19);
		arrayButton.add(btnNewButton_20);
		arrayButton.add(btnNewButton_21);
		arrayButton.add(btnNewButton_22);
		arrayButton.add(btnNewButton_23);
		arrayButton.add(btnNewButton_24);
		arrayButton.add(btnNewButton_25);
		arrayButton.add(btnNewButton_26);
		arrayButton.add(btnNewButton_27);
		arrayButton.add(btnNewButton_28);
		arrayButton.add(btnNewButton_29);
		arrayButton.add(btnNewButton_30);
		arrayButton.add(btnNewButton_31);
		arrayButton.add(btnNewButton_32);
		arrayButton.add(btnNewButton_33);
		arrayButton.add(btnNewButton_34);
		arrayButton.add(btnNewButton_35);
		arrayButton.add(btnNewButton_36);
		arrayButton.add(btnNewButton_37);
		arrayButton.add(btnNewButton_38);
		arrayButton.add(btnNewButton_39);
		arrayButton.add(btnNewButton_40);
		arrayButton.add(btnNewButton_41);
		arrayButton.add(btnNewButton_42);
		arrayButton.add(btnNewButton_43);
		arrayButton.add(btnNewButton_44);
		arrayButton.add(btnNewButton_45);
		arrayButton.add(btnNewButton_46);
		arrayButton.add(btnNewButton_47);
		arrayButton.add(btnNewButton_48);
		arrayButton.add(btnNewButton_49);


		for (int i = 0; i < listSeat.size(); i++) {
			if (listSeat.get(i).getSeatId() == 
					Integer.parseInt(arrayButton.get(listSeat.get(i).getSeatId() - 1).getText())) {
				Color cg = cg1;
				arrayButton.get(listSeat.get(i).getSeatId() - 1).setBackground(cg);

				if (((new Date().getTime() - listSeat.get(i).getRentTime().getTime()) / 60.0 / 1000.0 / 60.0) >= 23.0
						/ 12.0) {

					if (((new Date().getTime() - listSeat.get(i).getRentTime().getTime()) / 60.0 / 1000.0
							/ 60.0) >= 2.0) {
						arrayButton.get(listSeat.get(i).getSeatId() - 1).setBackground(new JButton().getBackground());
						seat.returnSeat(listSeat.get(i).getSeatId());

					} else {
						
						arrayButton.get(listSeat.get(i).getSeatId() - 1).setBackground(new Color(87, 198, 225));
					}
				}
				System.out.println(
						(new Date().getTime() - listSeat.get(i).getRentTime().getTime()) / 60.0 / 1000.0 / 60.0);
				lblNewLabel.setText("남은좌석 : " + (50-seat.selectSeat().size()) + "개 ");
			}
		}
		
		btnNewButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 0, lblNewLabel, id);
			}
		});
		btnNewButton.setBounds(244, 179, 30, 30);
		contentPane.add(btnNewButton);


		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				seatLogic(arrayButton, seat, 1, lblNewLabel, id);
			}
		});
		btnNewButton_1.setBounds(281, 179, 30, 30);
		contentPane.add(btnNewButton_1);

		for (int i = 0; i < listSeat.size(); i++) {
			if (listSeat.get(i).getSeatId() == Integer.parseInt(btnNewButton_2.getText())) {
				Color cg = Color.red;
				btnNewButton_2.setBackground(cg);
			}
		}
		btnNewButton_2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				seatLogic(arrayButton, seat, 2, lblNewLabel, id);
			}
		});
		btnNewButton_2.setBounds(244, 215, 30, 30);
		contentPane.add(btnNewButton_2);


		
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 3, lblNewLabel, id);
			}
		});
		btnNewButton_3.setBounds(281, 215, 30, 30);
		contentPane.add(btnNewButton_3);

		
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 4, lblNewLabel, id);
			}
		});
		btnNewButton_4.setBounds(244, 251, 30, 30);
		contentPane.add(btnNewButton_4);
		
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 5, lblNewLabel, id);
			}
		});
		btnNewButton_5.setBounds(281, 251, 30, 30);
		contentPane.add(btnNewButton_5);

		
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 6, lblNewLabel, id);
			}
		});
		btnNewButton_6.setBounds(244, 287, 30, 30);
		contentPane.add(btnNewButton_6);

		
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 7, lblNewLabel, id);
			}
		});
		btnNewButton_7.setBounds(281, 287, 30, 30);
		contentPane.add(btnNewButton_7);

		
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 8, lblNewLabel, id);
			}
		});
		btnNewButton_8.setBounds(244, 324, 30, 30);
		contentPane.add(btnNewButton_8);

		
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 9, lblNewLabel, id);
			}
		});
		btnNewButton_9.setBounds(281, 324, 30, 30);
		contentPane.add(btnNewButton_9);

		
		btnNewButton_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 10, lblNewLabel, id);
			}
		});
		btnNewButton_10.setBounds(244, 400, 30, 30);
		contentPane.add(btnNewButton_10);

		
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 11, lblNewLabel, id);
			}
		});
		btnNewButton_11.setBounds(281, 400, 30, 30);
		contentPane.add(btnNewButton_11);

		
		btnNewButton_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 12, lblNewLabel, id);
			}
		});
		btnNewButton_12.setBounds(318, 400, 30, 30);
		contentPane.add(btnNewButton_12);

		
		btnNewButton_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 13, lblNewLabel, id);
			}
		});
		btnNewButton_13.setBounds(354, 400, 30, 30);
		contentPane.add(btnNewButton_13);

		
		btnNewButton_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 14, lblNewLabel, id);
			}
		});
		btnNewButton_14.setBounds(390, 400, 30, 30);
		contentPane.add(btnNewButton_14);

		
		btnNewButton_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 15, lblNewLabel, id);
			}
		});
		btnNewButton_15.setBounds(427, 400, 30, 30);
		contentPane.add(btnNewButton_15);

		
		btnNewButton_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 16, lblNewLabel, id);
			}
		});
		btnNewButton_16.setBounds(244, 437, 30, 30);
		contentPane.add(btnNewButton_16);

		
		btnNewButton_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 17, lblNewLabel, id);
			}
		});
		btnNewButton_17.setBounds(281, 437, 30, 30);
		contentPane.add(btnNewButton_17);

		
		btnNewButton_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 18, lblNewLabel, id);
			}
		});
		btnNewButton_18.setBounds(318, 437, 30, 30);
		contentPane.add(btnNewButton_18);

		
		btnNewButton_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 19, lblNewLabel, id);
			}
		});
		btnNewButton_19.setBounds(354, 437, 30, 30);
		contentPane.add(btnNewButton_19);

		
		btnNewButton_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 20, lblNewLabel, id);
			}
		});
		btnNewButton_20.setBounds(390, 437, 30, 30);
		contentPane.add(btnNewButton_20);

		
		btnNewButton_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 21, lblNewLabel, id);
			}
		});
		btnNewButton_21.setBounds(427, 437, 30, 30);
		contentPane.add(btnNewButton_21);

		
		btnNewButton_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 22, lblNewLabel, id);
			}
		});
		btnNewButton_22.setBounds(519, 179, 30, 30);
		contentPane.add(btnNewButton_22);

		
		btnNewButton_23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 23, lblNewLabel, id);
			}
		});
		btnNewButton_23.setBounds(556, 179, 30, 30);
		contentPane.add(btnNewButton_23);

		for (int i = 0; i < listSeat.size(); i++) {
			if (listSeat.get(i).getSeatId() == Integer.parseInt(btnNewButton_24.getText())) {
				Color cg = Color.red;
				btnNewButton_24.setBackground(cg);
			}
		}
		btnNewButton_24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 24, lblNewLabel, id);
			}
		});
		btnNewButton_24.setBounds(519, 215, 30, 30);
		contentPane.add(btnNewButton_24);

		RoundedButton btnPrev = new RoundedButton("Prev");
		btnPrev.setFont(new Font("나눔고딕", Font.BOLD, 13));
		btnPrev.setText("< Prev");
		btnPrev.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);

				try {
					new Main().setVisible(true);
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

		JLabel lblId = new JLabel("");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("나눔고딕", Font.BOLD, 13));
		if (id != null) {
			lblId.setText(id + "님 환영합니다!!!");
		}
		lblId.setBounds(138, 53, 173, 15);
		contentPane.add(lblId);
		
		btnNewButton_25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 25, lblNewLabel, id);
			}
		});
		btnNewButton_25.setBounds(556, 215, 30, 30);
		contentPane.add(btnNewButton_25);
		btnNewButton_26.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 26, lblNewLabel, id);
			}
		});
		btnNewButton_26.setBounds(518, 291, 30, 30);
		contentPane.add(btnNewButton_26);
		
		btnNewButton_27.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 27, lblNewLabel, id);
			}
		});
		btnNewButton_27.setBounds(555, 291, 30, 30);
		contentPane.add(btnNewButton_27);
		
		btnNewButton_28.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 28, lblNewLabel, id);
			}
		});
		btnNewButton_28.setBounds(518, 327, 30, 30);
		contentPane.add(btnNewButton_28);
		
		btnNewButton_29.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 29, lblNewLabel, id);
			}
		});
		btnNewButton_29.setBounds(555, 327, 30, 30);
		contentPane.add(btnNewButton_29);
		
		btnNewButton_30.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 30, lblNewLabel, id);
			}
		});
		btnNewButton_30.setBounds(518, 364, 30, 30);
		contentPane.add(btnNewButton_30);
		
		btnNewButton_31.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 31, lblNewLabel, id);
			}
		});
		btnNewButton_31.setBounds(555, 364, 30, 30);
		contentPane.add(btnNewButton_31);
		
		btnNewButton_32.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 32, lblNewLabel, id);
			}
		});
		btnNewButton_32.setBounds(518, 402, 30, 30);
		contentPane.add(btnNewButton_32);
		
		btnNewButton_33.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 33, lblNewLabel, id);
			}
		});
		btnNewButton_33.setBounds(555, 402, 30, 30);
		contentPane.add(btnNewButton_33);
		
		btnNewButton_34.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 34, lblNewLabel, id);
			}
		});
		btnNewButton_34.setBounds(518, 437, 30, 30);
		contentPane.add(btnNewButton_34);
		
		btnNewButton_35.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 35, lblNewLabel, id);
			}
		});
		btnNewButton_35.setBounds(555, 437, 30, 30);
		contentPane.add(btnNewButton_35);
		
		btnNewButton_36.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 36, lblNewLabel, id);
			}
		});
		btnNewButton_36.setBounds(608, 179, 30, 30);
		contentPane.add(btnNewButton_36);
		
		btnNewButton_37.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 37, lblNewLabel, id);
			}
		});
		btnNewButton_37.setBounds(643, 179, 30, 30);
		contentPane.add(btnNewButton_37);
		btnNewButton_38.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 38, lblNewLabel, id);
			}
		});
		btnNewButton_38.setBounds(608, 214, 30, 30);
		contentPane.add(btnNewButton_38);
		btnNewButton_39.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 39, lblNewLabel, id);
			}
		});
		btnNewButton_39.setBounds(643, 214, 30, 30);
		contentPane.add(btnNewButton_39);
		btnNewButton_40.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 40, lblNewLabel, id);
			}
		});
		btnNewButton_40.setBounds(608, 291, 30, 30);
		contentPane.add(btnNewButton_40);
		btnNewButton_41.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 41, lblNewLabel, id);
			}
		});
		btnNewButton_41.setBounds(643, 291, 30, 30);
		contentPane.add(btnNewButton_41);
		btnNewButton_42.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 42, lblNewLabel, id);
			}
		});
		btnNewButton_42.setBounds(608, 327, 30, 30);
		contentPane.add(btnNewButton_42);
		btnNewButton_43.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat,43, lblNewLabel, id);
			}
		});
		btnNewButton_43.setBounds(643, 327, 30, 30);
		contentPane.add(btnNewButton_43);
		btnNewButton_44.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 44, lblNewLabel, id);
			}
		});
		btnNewButton_44.setBounds(608, 364, 30, 30);
		contentPane.add(btnNewButton_44);
		btnNewButton_45.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 45, lblNewLabel, id);
			}
		});
		btnNewButton_45.setBounds(643, 364, 30, 30);
		contentPane.add(btnNewButton_45);
		btnNewButton_46.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 46, lblNewLabel, id);
			}
		});
		btnNewButton_46.setBounds(608, 402, 30, 30);
		contentPane.add(btnNewButton_46);
		btnNewButton_47.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 47, lblNewLabel, id);
			}
		});
		btnNewButton_47.setBounds(643, 402, 30, 30);
		contentPane.add(btnNewButton_47);
		btnNewButton_48.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 48, lblNewLabel, id);
			}
		});
		btnNewButton_48.setBounds(608, 437, 30, 30);
		contentPane.add(btnNewButton_48);
		btnNewButton_49.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seatLogic(arrayButton, seat, 49, lblNewLabel, id);
			}
		});
		btnNewButton_49.setBounds(643, 437, 30, 30);
		contentPane.add(btnNewButton_49);

	}

	private static void seatLogic(ArrayList<JButton> arrayButton, SeatDAO seat, int in, JLabel lblNewLabel, String id) {
		
		try {
			ArrayList<SeatVO> listSeat1 = seat.selectSeat();

			int result = JOptionPane.showConfirmDialog(null, "이곳으로 하시겠습니까?", arrayButton.get(in).getText() + "번 좌석 대여",
					JOptionPane.YES_NO_OPTION);
			if (listSeat1.size() == 0) {
				try {
					seat.rentSeat(Integer.parseInt(arrayButton.get(in).getText()), id);
					JOptionPane.showMessageDialog(null, "대여완료하였습니다.");

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "이미 있는 좌석입니다.");
				}

				arrayButton.get(in).setBackground(cg1);
			}
			for (int i = 0; i < listSeat1.size(); i++) {
				if (id.equals(seat.selectSeat().get(i).getAccountId())
						&& arrayButton.get(in).getBackground() == new JButton().getBackground()) {
					int res = JOptionPane.showConfirmDialog(null, "이미 좌석을 대여하셨습니다. 좌석 변경이 필요합니까?", "좌석변경",
							JOptionPane.YES_NO_OPTION);
					if (res == JOptionPane.YES_OPTION) {
						System.out.println(listSeat1.get(i).getSeatId());
						System.out.println(i);

						seat.returnSeat(listSeat1.get(i).getSeatId());
						arrayButton.get(listSeat1.get(i).getSeatId() - 1).setBackground(new JButton().getBackground());
						break;
					}
				}
			}
			for (int i = 0; i < listSeat1.size(); i++) {
				System.out.println("안접근");
				if (result == JOptionPane.YES_OPTION
						&& arrayButton.get(in).getBackground() == new JButton().getBackground()) {
					try {

						seat.rentSeat(Integer.parseInt(arrayButton.get(in).getText()), id);
						JOptionPane.showMessageDialog(null, "대여완료하였습니다.");
						
						

					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "이미 있는 좌석입니다.");
						break;
					}
					arrayButton.get(in).setBackground(cg1);

					break;
				} else if (result == JOptionPane.YES_OPTION && arrayButton.get(in).getBackground() == cg1) {
					System.out.println("접근2");
					if (!id.equals(seat.selectOneSeat(in+1).getAccountId())) {
						JOptionPane.showMessageDialog(null, "이미 있는 좌석입니다.");

					} else {
						int result1 = JOptionPane.showConfirmDialog(null, "반납하시겠습니까?",
								arrayButton.get(in).getText() + "번 좌석 반납", JOptionPane.YES_NO_OPTION);
						if (result1 == JOptionPane.YES_OPTION) {
							try {

								seat.returnSeat(Integer.parseInt(arrayButton.get(in).getText()));
								JOptionPane.showMessageDialog(null, "자리를 깨끗히 해주세요. 감사합니당.");
								arrayButton.get(in).setBackground(new JButton().getBackground());
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					}

					break;
				}
			}
			lblNewLabel.setText("남은좌석 : " + (50-seat.selectSeat().size()) + "개 ");
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

}
