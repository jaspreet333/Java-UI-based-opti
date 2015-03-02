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

public class dssalsun extends JFrame{
	JLabel l0=new JLabel("Date");
	JLabel l1=new JLabel("");
	JLabel l2=new JLabel("Voucher NO");
	JLabel l3=new JLabel("Brand Name");
	JLabel l4=new JLabel("Product");
	JLabel l5=new JLabel("Name");
	JLabel l6=new JLabel("SellPrice");
	String dos=null;
	String companyname=null;
	String product=null;
	String name=null;
	String sp=null;
	String voucherno=null;
	
	JXDatePicker t0=new JXDatePicker();
	//JTextField t0=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	JTextField t5=new JTextField();
	JTextField t6=new JTextField();
	//JTextField t6=new JTextField();
	//JButton b5=new JButton("Delete This Record");
	JButton b1=new JButton("Save");
	//JButton b4=new JButton("Print & Save");
	String user=null;
	String sid=null;
	//JButton b2=new JButton("Create Company");
	JButton b3=new JButton("Back");
	JPanel p1=new JPanel();
	String[] ar=new String[20];
	//ArrayList<String> ar = new ArrayList<String>();
	Connection d;
	Statement stm=null;
	//String s2;
	int ne=0;
	gcon k=new gcon();
	public dssalsun(String s1,String s2) {
		// TODO Auto-generated constructor stub
		super("Sale of Sunglass");
		user=s1;
		sid=s2;
d=k.getDBConnection();
ne=0;
		p1.setLayout(null);
		int i=0;
		Date d1=null;
		try
		{
			String sql="Select * from sentry1 where sid="+sid;
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				d1=rs.getDate("dos");
				companyname= rs.getString("companyname");
				product=rs.getString("product");
				name=rs.getString("name");
				sp=rs.getString("sp");
				voucherno=rs.getString("voucherno");
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		ne++;
		ButtonHandler l=new ButtonHandler();
		//t3=new JComboBox(ar);
		t0.setDate(d1);
		t0.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));
		t3.setText(companyname);
		t5.setText(name);
		t6.setText(sp);
		t4.setText(product);
		t2.setText(voucherno);
		t4.setEditable(false);
		l1.setText("Welcome "+s1);
		b3.setBounds(100, 20, 100, 30);
		l1.setBounds(1100, 20, 150, 30);
		l0.setBounds(300, 60, 300, 40);
		t0.setBounds(700,60,300,40);
		//l2.setBounds(20, 50, 100, 30);
		//t2.setBounds(200,50,100,30);
		l2.setBounds(300, 120, 300, 40);
		t2.setBounds(700,120,300,40);
		l3.setBounds(300, 180, 300, 40);
		t3.setBounds(700,180,300,40);
		l4.setBounds(300, 240, 300, 40);
		t4.setBounds(700,240,300,40);
		l5.setBounds(300, 300, 300, 40);
		t5.setBounds(700,300,300,40);
		l6.setBounds(300, 360, 300, 40);
		t6.setBounds(700,360,300,40);
		//b2.setBounds(250,200,100,20);
		b1.setBounds(300, 420, 150, 30);
		//b4.setBounds(600, 420, 150, 30);
		//b5.setBounds(900, 420, 150, 30);
		//b5.addActionListener(l);
		b1.addActionListener(l);
		//b4.addActionListener(l);
		//b2.addActionListener(l);
		b3.addActionListener(l);
		//p1.add(b5);
		p1.add(l0);
		p1.add(b3);
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);
		p1.add(l6);
		p1.add(t0);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(t5);
		p1.add(t6);
		p1.add(b1);
		//p1.add(b2);
		getContentPane().add(p1);
	}
	private class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent g) {
			// TODO Auto-generated method stub
			if(g.getSource()==b1)
			{
				d=k.getDBConnection();
				Date s12=t0.getDate();
				//System.out.println(s12);
				SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
				String s1=sdf.format(s12);
				//String s1=t0.getText();
				String s2=t2.getText();
				String s3=t3.getText();
				String s4=t4.getText();
				String s5=t5.getText();
				String s6=t6.getText();
				try
				{
					String sql="update sentry1 set dos='"+s1+"',companyname='"+s3+"',name='"+s5+"',sp="+s6+",voucherno="+s2+" where sid="+sid;
					stm=d.createStatement();
					stm.executeUpdate(sql);
					
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
				/*if(g.getSource()==b4)
				{
					String dos=s1;
					//String sid=String.valueOf(ne);
					String companyname=s3;
					String name=s5;
					String sp=s6;
					String voucherno=s2;
					printingtemplatesales2 example2 = new printingtemplatesales2(dos,sid,voucherno,name,companyname,sp);
				}*/
			}
			/*if(g.getSource()==b5)
			{
				d=k.getDBConnection();
				try
				{
					String sql="delete from sentry1 where sid="+sid;
					stm=d.createStatement();
					stm.executeUpdate(sql);
					
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
			}*/
			/*if(g.getSource()==b2)
			{
				 ccomp pw = new ccomp(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 pw.setSize( 400, 200 ); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			}*/
			//if(g.getSource()==b3)
			//{
			try {
				d.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	 
			sentry pw = new sentry(user); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				 setVisible(false);
			//}
		}
		
	}
}
