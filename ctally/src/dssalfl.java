import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.*;

import java.util.*;
import java.text.*;


public class dssalfl extends JFrame{

	JPanel p1=new JPanel();
	JLabel l0=new JLabel();
	JLabel l1=new JLabel("Date");
	JLabel l2=new JLabel("Voucherno");
	JLabel l3=new JLabel("Buyer Name");
	//JLabel l4=new JLabel("Company Name");
	JLabel l4=new JLabel("Frame Brand");
	JLabel l5=new JLabel("Lens Brand");
	JLabel l6=new JLabel("Lens Price");
	JLabel l7=new JLabel("Frame Price");
	JLabel l8=new JLabel("Total Price");
	JLabel l9=new JLabel();
	JXDatePicker t1=new JXDatePicker();
	//JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	JTextField t5=new JTextField();
	JTextField t6=new JTextField();
	JTextField t7=new JTextField();
	//JTextField t8=new JTextField();
	
	//JButton b1=new JButton("Create Company");
	//JButton b2=new JButton("Delete");
	JButton b3=new JButton("Save");
	//JButton b5=new JButton("Print & Save");
	JButton b4=new JButton("Back");
	//String[] ar=new String[20];
	//ArrayList<String> ar = new ArrayList<String>();
	Connection d;
	Statement stm=null;
	String sn;
	gcon k=new gcon();
	int ne=0;
	String dop=null;
	String sid=null;
	String clens=null;
	String cframe=null;
	String name=null;
	String plens=null;
	String pframe=null;
	String tp=null;
	String voucherno=null;
	
	
	public dssalfl (String user,String s1) {
		
		//System.out.println(user+"    "+s1);
		super("Sale of Frame And Lens");
		// TODO Auto-generated constructor stub
      d=k.getDBConnection();
		sid=s1;
		p1.setLayout(null);
		int i=0;
		ne=0;
		Date d1=null;
		try
		{
			/*String sql="Select name from companylist";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				String us = rs.getString("name");
				ar[i]=us;
				i++;
			}*/
			 String sql="Select * from sentry2 where sid="+s1;
			stm=d.createStatement();
		    ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				//ne = Integer.parseInt(rs.getString("count"));
				 d1=rs.getDate("dop");
				 clens=rs.getString("clens");
				 cframe=rs.getString("cframe");
				 name=rs.getString("name");
				 plens=rs.getString("plens");
				 pframe=rs.getString("pframe");
				 tp=rs.getString("tp");
				 voucherno=rs.getString("voucherno");
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
	
		sn=user;
		ButtonHandler l=new ButtonHandler();
		//t4=new JComboBox(ar);
		//t5=new JComboBox(ar);
		t1.setDate(d1);
		t1.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));
		p1.setLayout(null);
		l0.setText("Welcome "+user);
		t2.setText(voucherno);
		t3.setText(name);
		t4.setText(cframe);
		t5.setText(clens);
		t6.setText(plens);
		t7.setText(pframe);
		l9.setText(tp);
		l0.setBounds(1100, 20, 150, 30);
		b4.setBounds(100, 20, 150, 30);
		l1.setBounds(300, 60, 300, 40);
		t1.setBounds(700, 60, 300, 40);
		l2.setBounds(300, 120, 300, 40);
		t2.setBounds(700, 120, 300, 40);
		l3.setBounds(300, 180, 300, 40);
		t3.setBounds(700, 180, 300, 40);
		l4.setBounds(300, 240, 300, 40);
		t4.setBounds(700, 240, 300, 40);
		//b1.setBounds(250, 200, 125, 20);
		l5.setBounds(300, 300, 300, 40);
		t5.setBounds(700, 300, 300, 40);
		l6.setBounds(300, 360, 300, 40);
		t6.setBounds(700, 360, 300, 40);
		l7.setBounds(300, 420, 300, 40);
		t7.setBounds(700, 420, 300, 40);
		l8.setBounds(300, 480, 300, 40);
		//t8.setBounds(200, 350, 100, 30);
		l9.setBounds(700, 480, 300, 40);
		//l10.setBounds(200, 390, 100, 30);
		//b2.setBounds(300, 540, 150, 30);
		b3.setBounds(600, 540, 150, 30);
		//b5.setBounds(900, 540, 150, 30);
		//b1.addActionListener(l);
		//b2.addActionListener(l);
		b3.addActionListener(l);
		b4.addActionListener(l);
		//b5.addActionListener(l);
		//p1.add(b5);
		p1.add(l0);
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);
		p1.add(l6);
		p1.add(l7);
		p1.add(l8);
		p1.add(l9);
		//p1.add(b2);
		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(t5);
		p1.add(t6);
		p1.add(t7);
		//p1.add(b1);
		//p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		getContentPane().add(p1);
	}
private class ButtonHandler implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent f) {
		// TODO Auto-generated method stub
		/*if(f.getSource()==b1)
		{
			ccomp pw = new ccomp(s2); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 pw.setSize( 400, 200 ); // set frame size
			 pw.setVisible(true);
			setVisible(false);
		}*/
		/*if(f.getSource()==b2)
		{
			
			d=k.getDBConnection();
			try
			{
				String sql="delete from sentry2 where sid="+sid;
				stm=d.createStatement();
				stm.executeUpdate(sql);
				
			}
			catch(SQLException fe)
			{
				fe.printStackTrace();
			}
		}*/
		if(f.getSource()==b3)
		{
			d=k.getDBConnection();
			Date s12=t1.getDate();
			//System.out.println(s12);
			SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
			String s1=sdf.format(s12);
			//String s1=t1.getText();
			String s2=t2.getText();
			String s3=t3.getText();
			String s4=t4.getText();
			String s5=t5.getText();
			String s6=t6.getText();
			String s7=t7.getText();
			String s8=l9.getText();
			//String s9=.getText();
			try
			{
				String sql="update sentry2 set dop='"+s1+"',name='"+s3+"',clens='"+s4+"',cframe='"+s5+"',plens="+s6+",pframe="+s7+",tp="+s8+",voucherno="+s2+" where sid="+sid;
				stm=d.createStatement();
				stm.executeUpdate(sql);
				
			}
			catch(SQLException fe)
			{
				fe.printStackTrace();
			}
			/*if(f.getSource()==b5)
			{
				String dop=s1;
				//tring sid1=sid;
				String clens=s4;
				String cframe=s5;
				String name=s3;
				String plens=s6;
				String pframe=s7;
				String tp=s8;
				String voucherno=s2;
				printingtemplatesales example2 = new printingtemplatesales(dop,sid,voucherno,name,clens,plens,cframe,pframe,tp);
			}*/
		
		}
		try {
			d.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 sentry pw = new sentry(sn); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 Toolkit tk=Toolkit.getDefaultToolkit();
			 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
			 pw.setVisible(true);
			 setVisible(false);
		
		
	}
	
}
}

