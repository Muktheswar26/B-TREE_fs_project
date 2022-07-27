package day1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Landing_page extends JFrame {
	static LoginPage lg = new LoginPage();


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Landing_page frame = new Landing_page();
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
	public Landing_page() {
		setTitle("HMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 390);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("File Structures Mini Project");
		lblNewLabel_1.setBounds(226, 6, 314, 33);
		lblNewLabel_1.setFont(new Font("Noteworthy", Font.BOLD, 24));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("B-Tree Implementation");
		lblNewLabel_2.setBounds(278, 46, 224, 33);
		lblNewLabel_2.setFont(new Font("American Typewriter", Font.BOLD, 15));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Built by Abhay M Pamadi (1BY19IS004), B R Muktheswar (1BY19IS035)");
		lblNewLabel_3.setBounds(52, 303, 468, 44);
		lblNewLabel_3.setFont(new Font("American Typewriter", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("HOSPITAL");
		lblNewLabel_4.setBounds(288, 91, 153, 62);
		lblNewLabel_4.setFont(new Font("American Typewriter", Font.BOLD, 24));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel(" MANAGEMENT");
		lblNewLabel_4_1.setBounds(316, 127, 224, 56);
		lblNewLabel_4_1.setFont(new Font("American Typewriter", Font.BOLD, 24));
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("SYSTEM");
		lblNewLabel_4_2.setBounds(423, 165, 117, 33);
		lblNewLabel_4_2.setFont(new Font("American Typewriter", Font.BOLD, 24));
		contentPane.add(lblNewLabel_4_2);
		
		JButton btnNewButton = new JButton("Get Started");
		btnNewButton.setBounds(344, 228, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				lg.setVisible(true);
			
			}
		});
		btnNewButton.setBackground(new Color(51, 51, 255));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img.png").getImage().getScaledInstance(270, 250, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(imageIcon);
		lblNewLabel.setBounds(6, 6, 418, 304);

		contentPane.add(lblNewLabel);
		

	}
}
