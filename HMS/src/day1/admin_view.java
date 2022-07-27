package day1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class admin_view extends JFrame {

	private JPanel contentPane;
	static doc_panel dp = new doc_panel();
	static pat_panel pp = new pat_panel();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_view frame = new admin_view();
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
	public admin_view() {
		setTitle("HMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 382);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin View");
		lblNewLabel.setFont(new Font("Noteworthy", Font.BOLD, 24));
		lblNewLabel.setBounds(216, 47, 194, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Doctor Panel");
		btnNewButton.setBounds(59, 115, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				doc_panel dp = new doc_panel();
				dp.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Patient Panel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				pat_panel pp = new pat_panel();
				pp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(59, 232, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Check Rooms");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Check_rooms cr = new Check_rooms();
				cr.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(365, 115, 139, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Department Info.");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Dept_info di = new Dept_info();
				di.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(365, 232, 139, 29);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("LogOut");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginPage loginPage = new LoginPage();
				loginPage.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(212, 297, 117, 29);
		contentPane.add(btnNewButton_4);
	}

}
