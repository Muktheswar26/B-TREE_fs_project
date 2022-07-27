package day1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class patient_add extends JFrame {

	private JPanel contentPane;
	private JTextField pt_id;
	private JTextField pt_name;
	private JTextField pt_age;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patient_add frame = new patient_add();
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
	public patient_add() {
		setTitle("HMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(153, 204, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER PATIENT DETAILS");
		lblNewLabel.setFont(new Font("Noteworthy", Font.BOLD, 24));
		lblNewLabel.setBounds(136, 38, 312, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PATIENT ID");
		lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(87, 112, 130, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PATIENT NAME");
		lblNewLabel_1_1.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(87, 140, 130, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("PATIENT AGE");
		lblNewLabel_1_2.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(87, 168, 130, 16);
		contentPane.add(lblNewLabel_1_2);
		
		pt_id = new JTextField();
		pt_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		pt_id.setBounds(353, 108, 130, 26);
		contentPane.add(pt_id);
		pt_id.setColumns(10);
		
		pt_name = new JTextField();
		pt_name.setBounds(353, 136, 130, 26);
		contentPane.add(pt_name);
		pt_name.setColumns(10);
		
		pt_age = new JTextField();
		pt_age.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		pt_age.setBounds(353, 164, 130, 26);
		contentPane.add(pt_age);
		pt_age.setColumns(10);
		
		String[] doc_type_string = {"Pediatricians","Geriatric","Dermatologists","Ophthalmologists","Cardiologists"};
		String[] rooms = {"VIP","ICU","GENERAL"};
		
		JComboBox cb = new JComboBox(doc_type_string);
		cb.setBounds(316, 248, 201, 26);
		contentPane.add(cb);
		
		JComboBox comboBox = new JComboBox(rooms);
		comboBox.setBounds(374, 210, 87, 26);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = pt_id.getText().toString();
				String name = pt_name.getText().toString();
				String age = pt_age.getText().toString();
				String type = (String)comboBox.getSelectedItem();
				String dept = (String)cb.getSelectedItem();
				String s =ID+"|"+name+"|"+age+"|"+type+"|";
				if(!ID.equals("") && !name.equals("") && !age.equals("")) {
				try {
					if(text_main.insert_pe(ID, name, age, type, dept)) {
					dispose();
					pat_panel pp = new pat_panel();
					pp.setVisible(true);
					}else {
						JOptionPane.showMessageDialog( btnNewButton, "Patient of Id : "+ID+" already exists", "", getDefaultCloseOperation());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch blocke1.printStackTrace();
				}
				}
				else {
					JOptionPane.showMessageDialog( btnNewButton, "Enter All The Fields", "", getDefaultCloseOperation());
				}
			}
		});
		btnNewButton.setBounds(87, 299, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("PATIENT VIST Dept.");
		lblNewLabel_1_2_1.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(87, 258, 201, 16);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("PATIENT TYPE");
		lblNewLabel_1_2_2.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_2_2.setBounds(87, 218, 130, 16);
		contentPane.add(lblNewLabel_1_2_2);
		
		
		
		JLabel lblNewLabel_1_2_3 = new JLabel("PATIENT AGE");
		lblNewLabel_1_2_3.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_2_3.setBounds(87, 168, 130, 16);
		contentPane.add(lblNewLabel_1_2_3);
		
		pt_id.setText("");
		pt_name.setText("");
		pt_age.setText("");
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				pat_panel pp = new pat_panel();
				pp.setVisible(true);
			}
			
		});
		btnNewButton_1.setBounds(374, 299, 117, 29);
		contentPane.add(btnNewButton_1);
		
	}
}
