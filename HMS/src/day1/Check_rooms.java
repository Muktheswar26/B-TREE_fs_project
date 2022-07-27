package day1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Check_rooms extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Check_rooms frame = new Check_rooms();
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
	public Check_rooms() {
		setTitle("HMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 415);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Room Details");
		lblNewLabel.setBounds(114, 20, 143, 46);
		lblNewLabel.setFont(new Font("Noteworthy", Font.BOLD, 24));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("VIP");
		lblNewLabel_1.setBounds(68, 119, 61, 16);
		lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ICU");
		lblNewLabel_2.setBounds(68, 158, 61, 16);
		lblNewLabel_2.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("GENERAL");
		lblNewLabel_3.setBounds(68, 197, 97, 16);
		lblNewLabel_3.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_3);
		
		JLabel vip_room = new JLabel("");
		vip_room.setBounds(243, 120, 61, 16);
		vip_room.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		contentPane.add(vip_room);
		
		JLabel icu_room = new JLabel("");
		icu_room.setBounds(243, 159, 61, 16);
		icu_room.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		contentPane.add(icu_room);
		
		JLabel general_room = new JLabel("");
		general_room.setBounds(243, 198, 61, 16);
		general_room.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		contentPane.add(general_room);
		
		JLabel lblNewLabel_7 = new JLabel(":");
		lblNewLabel_7.setBounds(185, 120, 11, 16);
		lblNewLabel_7.setFont(new Font("American Typewriter", Font.BOLD, 13));
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(":");
		lblNewLabel_8.setBounds(185, 160, 11, 15);
		lblNewLabel_8.setFont(new Font("American Typewriter", Font.BOLD, 13));
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(":");
		lblNewLabel_9.setBounds(185, 198, 11, 16);
		lblNewLabel_9.setFont(new Font("American Typewriter", Font.BOLD, 13));
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Show");
		btnNewButton.setBounds(243, 79, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String[] rooms = text_main.check_avl().split("\\|");
					vip_room.setText(rooms[0]+"/20");
					icu_room.setText(rooms[1]+"/30");
					general_room.setText(rooms[2]+"/50");
					
					}catch(Exception ea) {
						
					}
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("VIP ROOM COST 20,000/-  ");
		lblNewLabel_4.setFont(new Font("American Typewriter", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_4.setBounds(68, 251, 280, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("ICU ROOM COST 10,000/-  ");
		lblNewLabel_4_1.setFont(new Font("American Typewriter", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_4_1.setBounds(68, 283, 280, 16);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("GENERAL ROOM COST 500/-  ");
		lblNewLabel_4_2.setFont(new Font("American Typewriter", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_4_2.setBounds(68, 311, 280, 16);
		contentPane.add(lblNewLabel_4_2);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				try {
					admin_view admin_view = new admin_view();
					admin_view.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(243, 347, 117, 29);
		contentPane.add(btnNewButton_1);
		
		
	}
}
