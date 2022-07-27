package day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.io.*;
import javax.imageio.ImageIO;

public class text_main {
	public static BTree dr = new BTree(3);
	public static BTree pt = new BTree(3);
	static int VIP_ROOM=20,GENERAL=50,ICU=30;
	static int flag_v=0,flag_i=0,flag_g=0;
	static int Pediatricians=0,Geriatric=0,Dermatologists=0,Ophthalmologists=0,Cardiologists=0;
	static Scanner scan = new Scanner(System.in);
	static int rec_nums =0;
	static int pt_nums=0;
	public static void create_BTREE() throws IOException {
	
		RandomAccessFile file = new RandomAccessFile("doctor_details.txt", "rw");
		
		String b ;
		int ID;
		long pos = file.getFilePointer();
		while((b = file.readLine())!=null)
		{
			String[] result = b.split("\\|");
			if (!result[0].startsWith("*")) {
			ID =Integer.parseInt(result[0]);
			dr.Insert(ID,pos);
			pos = file.getFilePointer();
			}
		}
		System.out.println("doc tree");
		dr.Show();
		file.close();
		
		RandomAccessFile file_p = new RandomAccessFile("patient_details.txt", "rw");
		String b_p ;
		int ID_p;
		long pos_p = file_p.getFilePointer();
		while((b_p = file_p.readLine())!=null)
		{
			String[] result = b_p.split("\\|");
			if (!result[0].startsWith("*")) {
				ID_p =Integer.parseInt(result[0]);
				switch(result[3].toUpperCase()) {
					case "VIP" : VIP_ROOM--;break;
					case "GENERAL" : GENERAL--;break;
					case "ICU" : ICU--;break;
				}
				switch(result[4].toLowerCase()) {
				case "pediatricians" : Pediatricians++;break;
				case "geriatric" : Geriatric++;break;
				case "dermatologists" : Dermatologists++;break;
				case "ophthalmologists" : Ophthalmologists++;break;
				case "cardiologists" : Cardiologists++;break;
				}
				pt.Insert(ID_p,pos_p);
				pos_p = file_p.getFilePointer();
			}
			
		}
		System.out.println("pt tree");
		pt.Show();
		System.out.println("\n");
		if(VIP_ROOM<=0) {
			flag_v=1;
		}
		if(ICU<=0) {
			flag_i=1;
		}
		if(GENERAL<=0) {
			flag_g=1;
		}
		file_p.close();
		update_rooms(VIP_ROOM,GENERAL,ICU);
		update_dept();
	}
	
	public static boolean insert_dr(String ID,String name,String age,String type) throws Exception {
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("doctor_details.txt"),true));
		RandomAccessFile file = new RandomAccessFile("doctor_details.txt", "rw");
		
		long po=dr.Contain(Integer.parseInt(ID));
		if(po!=-1234) {
			return false;
		}
		
		String s =ID+"|"+name+"|"+age+"|"+type+"|";

		pw.println(s);
		pw.close();
		long pos = file.getFilePointer();
		long poso=pos;
		while((file.readLine())!=null)
		{
			poso=pos;
			pos = file.getFilePointer();
			
		}
		dr.Insert(Integer.parseInt(ID),poso);
		dr.Show();
		file.close();
		return true;
	}
	
	public static boolean insert_pe(String ID,String name,String age,String type,String dept) throws Exception {
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("patient_details.txt"),true));
		
		long po = pt.Contain(Integer.parseInt(ID));
		if(po!=-1234) {
			return false;
		}

		switch(type.toUpperCase()) {
			case "VIP" : if(VIP_ROOM==0) {
				System.out.println("vip roooms are empty");
				return true;
			}break;
			case "GENERAL" :if(ICU ==0) {
				System.out.println("general roooms are empty");
				return true;
			}break;
			case "ICU" : if(GENERAL==0) {
				System.out.println("icu roooms are empty");
				return true;
			}break;
		
		}
		String s =ID+"|"+name+"|"+age+"|"+type+"|"+dept+"|";
		switch(type.toUpperCase()) {
		case "VIP" : VIP_ROOM--;break;
		case "GENERAL" : GENERAL--;break;
		case "ICU" : ICU--;break;
		}
		if(VIP_ROOM<=0) {
			flag_v=1;
		}
		if(ICU<=0) {
			flag_i=1;
		}
		if(GENERAL<=0) {
			flag_g=1;
		}

		update_rooms(VIP_ROOM,GENERAL,ICU);
		switch(dept.toLowerCase()) {
		case "pediatricians" : Pediatricians++;break;
		case "geriatric" : Geriatric++;break;
		case "dermatologists" : Dermatologists++;break;
		case "ophthalmologists" : Ophthalmologists++;break;
		case "cardiologists" : Cardiologists++;break;
		}
		update_dept();
		RandomAccessFile file = new RandomAccessFile("patient_details.txt", "rw");
		long pos = file.getFilePointer();
	
		while((file.readLine())!=null)
		{
	
			pos = file.getFilePointer();
			
		}
		System.out.println(" "+ID+" "+pos);
		pt.Insert(Integer.parseInt(ID),pos);
		pw.println(s);
		pw.flush();
		pw.close();
		pt.Show();
		file.close();
		return true;
		
	}
	
	public static String[][] view_all_dr() throws IOException {
		FileReader fr=new FileReader("doctor_details.txt");
        BufferedReader br= new BufferedReader(fr);
        String line;
        String[][] data = new String[100][100];
        int i=0;
  
        while((line=br.readLine())!=null){
            String[] result = line.split("\\|");
            if (!result[0].startsWith("*")) {
            	data[i][0]=result[0];
            	data[i][1]=result[1];
            	data[i][2]=result[2];
            	data[i][3]=result[3];
            	i++;
            }
        }
        br.close();
        fr.close();
        rec_nums=i;
        return data;
	}
	
	public static String[][] view_all_pt() throws IOException {
		FileReader fr=new FileReader("patient_details.txt");
        BufferedReader br= new BufferedReader(fr);
        String line;
        String[][] data = new String[100][100];
        int i=0;
        while((line=br.readLine())!=null){
            String[] result = line.split("\\|");
            if (!result[0].startsWith("*")) {
            	data[i][0]=result[0];
            	data[i][1]=result[1];
            	data[i][2]=result[2];
            	data[i][3]=result[3];
            	data[i][4]=result[4];
            	i++;
            
            }
        }
        br.close();
        fr.close();
        pt_nums=i;
        return data;
	}
	
	public static String search_dr(int id) throws IOException {
		long pos=dr.Contain(id);
		
		if(pos!=-1234) {
			RandomAccessFile file = new RandomAccessFile("doctor_details.txt", "rw");
			file.seek(pos);
			String b = file.readLine();
			file.close();
			return b;
			
		}else {
			 String b = "NOT FOUND";
			 return b;
		}
	}
	
	public static String search_pt(int ID) throws Exception {
		
		long pos=pt.Contain(ID);
		if(pos!=-1234) {
			RandomAccessFile file = new RandomAccessFile("patient_details.txt", "rw");
			file.seek(pos);
			String b = file.readLine();
			file.close();
			return b;
		}else {
			String b = "NOT FOUND";
			 return b;
		}
	}
	
	public static String delete_dr(int ID) throws IOException {
		long pos = dr.Contain(ID);
		if(pos!=-1234) {
			dr.Remove(dr.root, ID, pos);
			dr.Show();
			RandomAccessFile file = new RandomAccessFile("doctor_details.txt", "rw");
			file.seek(pos);
			file.writeBytes("*");
			file.close();
			return "deleted";
			
		
		}else {
			return "NOT FOUND";
		}
		
	}
	
	public static String delete_pt(int ID) throws IOException {
		long pos = pt.Contain(ID);
		if(pos!=-1234) {
			pt.Remove(pt.root, ID, pos);
			pt.Show();
			RandomAccessFile file = new RandomAccessFile("patient_details.txt", "rw");
			file.seek(pos);
			file.writeBytes("*");
			String b = file.readLine();
			String[] result = b.split("\\|");
			switch(result[3].toUpperCase()) {
			case "VIP" : VIP_ROOM++;break;
			case "GENERAL" : GENERAL++;break;
			case "ICU" : ICU++;break;
			}
			if(VIP_ROOM==1) {
				flag_v=0;
			}
			if(ICU==1) {
				flag_i=0;
			}
			if(GENERAL==1) {
				flag_g=0;
			}
			switch(result[4].toLowerCase()) {
			case "pediatricians" : Pediatricians--;break;
			case "geriatric" : Geriatric--;break;
			case "dermatologists" : Dermatologists--;break;
			case "ophthalmologists" : Ophthalmologists--;break;
			case "cardiologists" : Cardiologists--;break;
			}
			update_rooms(VIP_ROOM,GENERAL,ICU);
			file.close();
			update_dept();
			return b;
		
		}else {
			update_dept();
			return "NOT FOUND";
		}
		
	}
	
	public static void update_rooms(int VIP_R,int GENERAL_R,int ICU_R) throws FileNotFoundException {
		PrintWriter pwr = new PrintWriter(new FileOutputStream(new File("availability_of_rooms.txt"),true));
		String rooms = String.valueOf(VIP_R)+"|"+String.valueOf(ICU_R)+"|"+String.valueOf(GENERAL_R)+"|";
		pwr.println(rooms);
		pwr.close();
	}
	
	public static String check_avl() throws IOException {
		BufferedReader br = new BufferedReader (new FileReader("availability_of_rooms.txt"));
		String b,s="";
		while((b=br.readLine())!=null) {
			s=b;
		}
		br.close();
		return s;

	}
	
	public static void update_dept() throws FileNotFoundException {
		PrintWriter pwrd = new PrintWriter(new FileOutputStream(new File("dept_info.txt"),true));
		String dept = String.valueOf(Pediatricians)+"|"+String.valueOf(Geriatric)+"|"+String.valueOf(Dermatologists)+"|"+String.valueOf(Ophthalmologists)+"|"+String.valueOf(Cardiologists)+"|";
		pwrd.println(dept);
		pwrd.close();
	}
	
	public static String show_dept_list() throws IOException {
		BufferedReader br = new BufferedReader (new FileReader("dept_info.txt"));
		String b,s="";
		while((b=br.readLine())!=null) {
			s=b;
		}
		br.close();
		return s;
		
	}
	
	public static void main(String[] args) throws Exception {	
		text_main obj = new text_main();
//		obj.create_BTREE();
		
//		obj.check_avl();
//		obj.delete_pt();
//		obj.insert_pe();
//		obj.insert_pe();
//		obj.insert_pe();
//		obj.insert_pe();
//		obj.insert_dr();
//		obj.insert_dr();
//		obj.insert_dr();
//		obj.insert_dr();
//		obj.insert_dr();
//		obj.insert_dr();
//		obj.view_all_dr();
//		obj.view_all_pt();
//		obj.search_dr();
//		obj.search_pt();
//		obj.delete_dr();
//		System.out.print("hii");
//		obj.view_all_dr();
//		System.out.print(data);
//		obj.delete_pt();
//		obj.view_all_pt();
//		obj.show_dept_list();
//		obj.check_avl();
	}


	

}
