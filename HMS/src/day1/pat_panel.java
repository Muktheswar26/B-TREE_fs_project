package day1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class pat_panel extends JFrame {

	private JPanel contentPane;
	private JTextField pt_serch_id;
	private JTextField pt_delete_id;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pat_panel frame = new pat_panel();
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
	public pat_panel() {
		setTitle("HMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 382);
	
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient Panel");
		lblNewLabel.setFont(new Font("Noteworthy", Font.BOLD, 24));
		lblNewLabel.setBounds(211, 36, 180, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add New Patient");
		btnNewButton.setBounds(74, 102, 138, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				patient_add ap = new patient_add();
				ap.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View All Patient");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				View_all_pt vp = new View_all_pt();
				vp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(334, 102, 138, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("🔍");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ID = pt_serch_id.getText().toString();
				if(!ID.equals("")) {
					try {
						int id = Integer.parseInt(ID);
						String b=text_main.search_pt(id);
						
						if(!b.equals("NOT FOUND")) {
							String[] result = b.split("\\|");
							pt_delete_id.setText("");
							pt_serch_id.setText("");
							String data = "Patient ID  : "+result[0]+"\nPatient Name :" +result[1]+"\nPatient age : "+result[2]+"\nPatient Type : "+result[3]+"\nPatient Dept. : "+result[4];
							JOptionPane.showMessageDialog( btnNewButton_3,data, "", getDefaultCloseOperation());
						}else {
							JOptionPane.showMessageDialog( btnNewButton_3, "Patient Doesn't Exists", "", getDefaultCloseOperation());
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog( btnNewButton_3, "INVALID INPUT!", "", getDefaultCloseOperation());
				}
			}
		});
		btnNewButton_3.setBounds(428, 185, 44, 21);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Enter The ID To Search");
		lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(74, 184, 234, 19);
		contentPane.add(lblNewLabel_1);
		
		pt_serch_id = new JTextField();
		pt_serch_id.setBounds(298, 181, 130, 26);
		contentPane.add(pt_serch_id);
		pt_serch_id.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter The ID To Delete");
		lblNewLabel_1_1.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(74, 218, 234, 19);
		contentPane.add(lblNewLabel_1_1);
		
		pt_delete_id = new JTextField();
		pt_delete_id.setBounds(298, 215, 130, 26);
		contentPane.add(pt_delete_id);
		pt_delete_id.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("❌");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = pt_delete_id.getText().toString();
				if(!ID.equals("")) {
					try {
						int id = Integer.parseInt(ID);
						String b=text_main.delete_pt(id);
						String amt="";
						if(!b.equals("NOT FOUND")) {
							String id_id = ID+b;
							String[] result = id_id.split("\\|");
							switch(result[3].toUpperCase()) {
							case "VIP" :  amt="20,000";break;
							case "GENERAL" : amt="500";break;
							case "ICU" :  amt="10,000";break;
							}
							result[0]=ID;
							String data  = "Patient ID  : "+result[0]+"\nPatient Name :" +result[1]+"\nPatient age : "+result[2]+"\nPatient Type : "+result[3]+"\nPatient Dept. : "+result[4]+"\nAmount for Doctor Counceltancy is : 500/-\nBed Charges for "+result[3]+" is "+amt+"/-";
							pt_delete_id.setText("");
							pt_serch_id.setText("");
							JOptionPane.showMessageDialog( btnNewButton_3,data, "REPORT", getDefaultCloseOperation());
						}else {
							JOptionPane.showMessageDialog( btnNewButton_3, "Patient Doesn't Exists", "", getDefaultCloseOperation());
						}
					} catch (Exception e1) {
	
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog( btnNewButton_3, "INVALID INPUT!", "", getDefaultCloseOperation());
				}
				
			}
		});
		btnNewButton_2.setBounds(428, 218, 44, 22);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
					try {
						admin_view admin_view = new admin_view();
						admin_view.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnNewButton_4.setBounds(428, 306, 117, 29);
		contentPane.add(btnNewButton_4);
		
		pt_delete_id.setText("");
		pt_serch_id.setText("");
	}

}
