package day1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class add_doc extends JFrame {

	private JPanel contentPane;
	private JTextField doc_id;
	private JTextField doc_name;
	private JTextField doc_age;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_doc frame = new add_doc();
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
	public add_doc() {
		setTitle("HMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(153, 204, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER DOCTOR DETAILS");
		lblNewLabel.setFont(new Font("Noteworthy", Font.BOLD, 24));
		lblNewLabel.setBounds(136, 38, 312, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DOC ID");
		lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(87, 112, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("DOC NAME");
		lblNewLabel_1_1.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(87, 150, 95, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("DOC AGE");
		lblNewLabel_1_2.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(87, 190, 95, 16);
		contentPane.add(lblNewLabel_1_2);
		
		doc_id = new JTextField();
		doc_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		doc_id.setBounds(353, 108, 130, 26);
		contentPane.add(doc_id);
		doc_id.setColumns(10);
		
		doc_name = new JTextField();
		doc_name.setBounds(353, 146, 130, 26);
		contentPane.add(doc_name);
		doc_name.setColumns(10);
		
		doc_age = new JTextField();
		doc_age.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		doc_age.setBounds(353, 186, 130, 26);
		contentPane.add(doc_age);
		doc_age.setColumns(10);	
		String[] doc_type_string = {"Pediatricians","Geriatric","Dermatologists","Ophthalmologists","Cardiologists"};
		JComboBox cb = new JComboBox(doc_type_string);
		cb.setBounds(316, 224, 201, 26);
		contentPane.add(cb);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = doc_id.getText().toString();
				String name = doc_name.getText().toString();
				String age = doc_age.getText().toString();
				String type = (String)cb.getSelectedItem();
			
				if(!ID.equals("") && !name.equals("") && !age.equals("") && !type.equals("")) {
				try {
					if(text_main.insert_dr(ID, "Dr. "+name, age, type)) {
					dispose();
					doc_panel dp = new doc_panel();
					dp.setVisible(true);
					}else {
						JOptionPane.showMessageDialog( btnNewButton, "Doctor of ID : "+ID+" already exists", "", getDefaultCloseOperation());
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
		btnNewButton.setBounds(87, 278, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("DOC TYPE");
		lblNewLabel_1_2_1.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(87, 228, 95, 16);
		contentPane.add(lblNewLabel_1_2_1);
		
		doc_id.setText("");
		doc_name.setText("");
		doc_age.setText("");
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				doc_panel dp = new doc_panel();
				dp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(366, 278, 117, 29);
		contentPane.add(btnNewButton_1);
		

	}
}
