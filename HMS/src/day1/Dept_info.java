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
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Dept_info extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dept_info frame = new Dept_info();
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
	public Dept_info() {
		setTitle("HMS");
		setTitle("HMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 382);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Department Info.");
		lblNewLabel.setFont(new Font("Noteworthy", Font.BOLD, 24));
		lblNewLabel.setBounds(184, 39, 204, 39);
		contentPane.add(lblNewLabel);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Number of Patient in Pediatricians");
		lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(40, 142, 280, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Number of Patient in Geriatric");
		lblNewLabel_1_1.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(40, 178, 280, 19);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Number of Patient in Dermatologists");
		lblNewLabel_1_2.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(40, 209, 280, 19);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Number of Patient in Ophthalmologists");
		lblNewLabel_1_3.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(40, 240, 311, 19);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Number of Patient in Cardiologists");
		lblNewLabel_1_4.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(40, 271, 280, 19);
		contentPane.add(lblNewLabel_1_4);
		
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
		btnNewButton_1.setBounds(398, 307, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_5 = new JLabel(":");
		lblNewLabel_1_5.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(349, 144, 17, 19);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_5_1 = new JLabel(":");
		lblNewLabel_1_5_1.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_5_1.setBounds(349, 180, 17, 19);
		contentPane.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_5_2 = new JLabel(":");
		lblNewLabel_1_5_2.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_5_2.setBounds(349, 211, 17, 19);
		contentPane.add(lblNewLabel_1_5_2);
		
		JLabel lblNewLabel_1_5_3 = new JLabel(":");
		lblNewLabel_1_5_3.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_5_3.setBounds(349, 242, 17, 19);
		contentPane.add(lblNewLabel_1_5_3);
		
		JLabel lblNewLabel_1_5_4 = new JLabel(":");
		lblNewLabel_1_5_4.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_5_4.setBounds(349, 271, 17, 19);
		contentPane.add(lblNewLabel_1_5_4);
		
		JLabel p_num = new JLabel("");
		p_num.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		p_num.setBounds(439, 144, 45, 19);
		contentPane.add(p_num);
		
		JLabel g_num = new JLabel("");
		g_num.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		g_num.setBounds(439, 182, 45, 19);
		contentPane.add(g_num);
		
		JLabel d_num = new JLabel("");
		d_num.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		d_num.setBounds(439, 211, 45, 19);
		contentPane.add(d_num);
		
		JLabel o_num = new JLabel("");
		o_num.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		o_num.setBounds(439, 242, 45, 19);
		contentPane.add(o_num);
		
		JLabel c_num = new JLabel("");
		c_num.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		c_num.setBounds(439, 273, 45, 19);
		contentPane.add(c_num);
		
		JButton btnNewButton = new JButton("Show");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String[] dept = text_main.show_dept_list().split("\\|");
					p_num.setText(dept[0]);
					g_num.setText(dept[1]);
					d_num.setText(dept[2]);
					o_num.setText(dept[3]);
					c_num.setText(dept[4]);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(398, 83, 117, 29);
		contentPane.add(btnNewButton);
		
	}

}
