package day1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

public class doc_panel extends JFrame {

	private JPanel contentPane;
	private JTextField doc_serch_id;
	private JTextField doc_delete_id;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doc_panel frame = new doc_panel();
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
	public doc_panel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 382);
	
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Doctor Panel");
		lblNewLabel.setFont(new Font("Noteworthy", Font.BOLD, 24));
		lblNewLabel.setBounds(211, 36, 180, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add New Doctor");
		btnNewButton.setBounds(74, 102, 138, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				add_doc ad = new add_doc();
				ad.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View All Doctor");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				View_all_doc vd = new View_all_doc();
				vd.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(334, 102, 138, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("🔍");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = doc_serch_id.getText().toString();
				if(!ID.equals("")) {
					try {
						int id = Integer.parseInt(ID);
						String b=text_main.search_dr(id);
						if(!b.equals("NOT FOUND")) {
							String[] result = b.split("\\|");
							String data = "Doc ID  : "+result[0]+"\nDoc Name :" +result[1]+"\nDoc age : "+result[2]+"\nDoc Type : "+result[3];
							doc_delete_id.setText("");
							doc_serch_id.setText("");
							JOptionPane.showMessageDialog( btnNewButton_3,data, "", getDefaultCloseOperation());
						}else {
							JOptionPane.showMessageDialog( btnNewButton_3, "Doctor Doesn't Exists", "", getDefaultCloseOperation());
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
		
		doc_serch_id = new JTextField();
		doc_serch_id.setBounds(298, 181, 130, 26);
		contentPane.add(doc_serch_id);
		doc_serch_id.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter The ID To Delete");
		lblNewLabel_1_1.setFont(new Font("American Typewriter", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(74, 218, 234, 19);
		contentPane.add(lblNewLabel_1_1);
		
		doc_delete_id = new JTextField();
		doc_delete_id.setBounds(298, 215, 130, 26);
		contentPane.add(doc_delete_id);
		doc_delete_id.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("❌");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = doc_delete_id.getText().toString();
				if(!ID.equals("")) {
					try {
						int id = Integer.parseInt(ID);
						String b=text_main.delete_dr(id);
						if(!b.equals("NOT FOUND")) {
							String data = "Record Deleted!!!";
							doc_delete_id.setText("");
							doc_serch_id.setText("");
							JOptionPane.showMessageDialog( btnNewButton_3,data, "", getDefaultCloseOperation());
						}else {
							JOptionPane.showMessageDialog( btnNewButton_3, "Doctor Doesn't Exists", "", getDefaultCloseOperation());
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
		
		
	}
	

}
