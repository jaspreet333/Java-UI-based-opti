import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdesktop.swingx.*;

import java.util.*;
import java.text.*;


public class dsp extends JFrame {
	JPanel p1=new JPanel();
	JLabel l1=new JLabel("Date");
	JLabel l2=new JLabel("PID");
	JLabel l3=new JLabel("Company Name");
	JLabel l4=new JLabel("Product");
	JLabel l5=new JLabel("Amount");
	JLabel l6=new JLabel("Description");
	JXDatePicker t1=new JXDatePicker();
	//JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JComboBox t3;
	JTextField t4=new JTextField();
	JTextField t5=new JTextField();
	JTextField t6=new JTextField();
	String[] ar=new String[20];
	//ArrayList<String> ar = new ArrayList<String>();
	Connection d;
	Statement stm=null;
	gcon k=new gcon();
	JButton b1=new JButton("Save changes");
	JButton b2=new JButton("Print");
	JButton b3=new JButton("Go Back");
	JButton b4=new JButton("Delete");
	String dop =null;
	String companyname = null;
	String product=null;
	String cp=null;
	String details=null;
	String bla=null;
	String s2;
	public dsp(String user,String s1) {
		// TODO Auto-generated constructor stub
		super("Bill Details");
		p1.setLayout(null);
		s2=user;
		bla=s1;
		d=k.getDBConnection();
		int i=0;
		try
		{
			String sql="Select name from companylist";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				String us = rs.getString("name");
				ar[i]=us;
				i++;
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		Date d1=null;
		try
		{
			String sql="Select * from pentry where pid="+s1;
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				d1=rs.getDate("dop"); 
				//dop = rs.getString("dop");
				companyname = rs.getString("companyname");
				 product = rs.getString("product");
				 cp = rs.getString("totalamt");
				 details = rs.getString("details");
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		t3=new JComboBox(ar);
		t3.setSelectedItem(companyname);
		t1.setDate(d1);
		t1.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));
		t2.setText(s1);
		t2.setEditable(false);
		t4.setText(product);
		t5.setText(cp);
		t6.setText(details);
		l1.setBounds(300, 30, 300, 40);
		t1.setBounds(700, 30, 300, 40);
		l2.setBounds(300,80,300,40);
		t2.setBounds(700, 80, 300, 40);
		l3.setBounds(300, 130, 100, 40);
		t3.setBounds(700, 130, 100, 40);
		l4.setBounds(300, 180, 100, 40);
		t4.setBounds(700, 180, 100, 40);
		l5.setBounds(300, 230, 100, 40);
		t5.setBounds(700, 230, 100, 40);
		l6.setBounds(300, 280, 100, 40);
		t6.setBounds(700, 280, 100, 40);
		b1.setBounds(100,350 , 150, 40);
		b2.setBounds(400,350 , 150, 40);
		b3.setBounds(700,350 , 150, 40);
		b4.setBounds(1000,350 , 150, 40);
		ButtonHandler l=new ButtonHandler();
		b1.addActionListener(l);
		b2.addActionListener(l);
		b3.addActionListener(l);
		b4.addActionListener(l);
		p1.add(b4);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);
		p1.add(l6);
		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(t5);
		p1.add(t6);
		getContentPane().add(p1);
	}
	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==b1)
			{
				d=k.getDBConnection();
				Date s1=t1.getDate();
				//System.out.println(s1);
				SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
				String b8=sdf.format(s1);
				//System.out.println(b8);
				
				try
				{
					
					
					String sql="UPDATE pentry SET dop='"+b8+"',companyname='"+(String)t3.getSelectedItem()+"',product='"+t4.getText()+"',totalamt="+t5.getText()+",details='"+t6.getText()+"' WHERE pid="+t2.getText();
					stm=d.createStatement();
					stm.executeUpdate(sql);
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
			}
			if(e.getSource()==b2)
			{
				Date s1=t1.getDate();
				//System.out.println(s1);
				SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
				String dop=sdf.format(s1);
				//String dop =t1.getText();
				String companyname = (String)t3.getSelectedItem();
				String product=t4.getText();
				String cp=t5.getText();
				String details=t6.getText(); 
				JavaWorldPrintExample2 example2 = new JavaWorldPrintExample2(dop,s2,companyname,product,cp,details);
			}
			if(e.getSource()==b4)
			{
				d=k.getDBConnection();
				try
				{
					String sql="delete from pentry where pid="+bla;
					stm=d.createStatement();
					stm.executeUpdate(sql);
					
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
			}
			//if(e.getSource()==b3)
			//{
			try {
				d.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			pentry pw = new pentry(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			//}
		}
		
	}
}
