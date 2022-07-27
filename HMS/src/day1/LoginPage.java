package day1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Label;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.JSlider;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JPasswordField passwordField;
	static admin_view av = new admin_view();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setTitle("HMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN LOGIN");
		lblNewLabel.setBounds(199, 42, 246, 33);
		lblNewLabel.setFont(new Font("Noteworthy", Font.BOLD, 22));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EMAIL");
		lblNewLabel_1.setBounds(106, 135, 61, 16);
		lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setBounds(94, 204, 118, 21);
		lblNewLabel_2.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_2);
		
		email = new JTextField();
		email.setBounds(355, 131, 130, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.setBounds(211, 277, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email_ID = email.getText().toString();
				String password_ID = passwordField.getText().toString();
				if(email_ID.equals("Admin") && password_ID.equals("Admin")){
				dispose();
				try {
					text_main.create_BTREE();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
				av.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(lblNewLabel_2, "INVALID INPUT!!!", "LogIn Unsuccessful", getDefaultCloseOperation());
				}
			}
		});
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(355, 202, 130, 21);
		contentPane.add(passwordField);
		contentPane.add(lblNewLabel);
		
	
	}
}
