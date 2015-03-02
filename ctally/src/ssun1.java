import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import org.jdesktop.swingx.*;
import java.util.*;
import java.text.*;

public class ssun1 extends JFrame{
	JLabel l0=new JLabel("Date");
	JLabel l1=new JLabel("");
	JLabel l2=new JLabel("Voucher NO");
	JLabel l3=new JLabel("Brand Name");
	JLabel l4=new JLabel("Product");
	JLabel l5=new JLabel("Name");
	JLabel l6=new JLabel("SellPrice");
	JXDatePicker t0=new JXDatePicker();
	//JTextField t0=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	JTextField t5=new JTextField();
	JTextField t6=new JTextField();
	//JTextField t6=new JTextField();
	JButton b1=new JButton("Save");
	//JButton b4=new JButton("Print & Save");
	//JButton b2=new JButton("Create Company");
	JButton b3=new JButton("Back");
	JPanel p1=new JPanel();
	String[] ar=new String[20];
	//ArrayList<String> ar = new ArrayList<String>();
	Connection d;
	Statement stm=null;
	String user;
	int ne=0;
	gcon k=new gcon();
	Date d1=null;
	String cbillno2,cname2,ct42,ct52,ct62,ct72,ct82,btnno2;
	int c42,c52,c62,c72,c82;
	String id11,id12,id13,id14,id15;
	String uniq1=null,uniq2=null;
	int wq1,wq2;
	public ssun1(String s1,Date d2, String cbillno1, String cname1, int c41, int c51, int c61, int c71, int c81, String ct41, String ct51, String ct61, String ct71, String ct81, String btnno, String op,String id1, String id2, String id3, String id4, String id5, Connection f, String cmobno, String cpres, int castei, int joini) {
		// TODO Auto-generated constructor stub
		super("Sale of Sunglass");
		user=s1;
		d=f;
		uniq1=cmobno;
		uniq2=cpres;
		wq1=castei;wq2=joini;
		ne=0;
		p1.setLayout(null);
		d1=d2;
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "back"); //$NON-NLS-1$
	        getRootPane().getActionMap().put("back", new AbstractAction(){ //$NON-NLS-1$
				@Override
				public void actionPerformed(ActionEvent arg0) {
				back();
				}
	        });
	        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		            KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "yes"); //$NON-NLS-1$
		        getRootPane().getActionMap().put("yes", new AbstractAction(){ //$NON-NLS-1$
					@Override
					public void actionPerformed(ActionEvent arg0) {
					yes();
					}
		        });
		        getRootPane().setFocusable(true);
		cbillno2=cbillno1;cname2=cname1;c42=c41;c52=c51;c62=c61;c72=c71;c82=c81;ct42=ct41;ct52=ct51;ct62=ct61;ct72=ct71;ct82=ct81;
		btnno2=btnno;
		id11=id1;id12=id2;id13=id3;id14=id4;id15=id5;
		int i=0;
		try
		{
			String sql="Select max(sid) as count from sentry1";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				if(rs.getString("count") != null)
				ne = Integer.parseInt(rs.getString("count"));
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		ne++;
		ButtonHandler l=new ButtonHandler();
		//t3=new JComboBox(ar);
		t0.setDate(d2);
		t5.setText(cname1);
		t0.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));
		t4.setText(op);
		t2.setText(String.valueOf(ne));
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
		b1.setBounds(500, 420, 150, 30);
		//b4.setBounds(700, 420, 150, 30);
		b1.addActionListener(l);
		//b4.addActionListener(l);
		//b2.addActionListener(l);
		b3.addActionListener(l);
		p1.add(l0);
		//p1.add(b4);
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
				//d=k.getDBConnection();
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
					String sql="insert into sentry1 values('"+s1+"',"+String.valueOf(ne)+",'"+s3+"','"+s4+"','"+s5+"',"+s6+","+s2+",'"+uniq1+"')";
					stm=d.createStatement();
					stm.executeUpdate(sql);
					/*if(g.getSource()==b4)
					{
						String dos=s1;
						String sid=String.valueOf(ne);
						String companyname=s3;
						String name=s5;
						String sp=s6;
						String voucherno=s2;
						printingtemplatesales2 example2 = new printingtemplatesales2(dos,sid,voucherno,name,companyname,sp);
					}*/
					if(btnno2=="4")
					{		billing pw = new billing(user,d1,cbillno2,cname2,c42,c52,c62,c72,c82,s6,ct52,ct62,ct72,ct82,String.valueOf(ne),id12,id13,id14,id15,d,uniq1,uniq2,wq1,wq2); // create ButtonFrame
						pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						 Toolkit tk=Toolkit.getDefaultToolkit();
						 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
						 pw.setVisible(true);
				}
					if(btnno2=="5")
					{		billing pw = new billing(user,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,s6,ct62,ct72,ct82,id11,String.valueOf(ne),id13,id14,id15,d,uniq1,uniq2,wq1,wq2); // create ButtonFrame
						pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						 Toolkit tk=Toolkit.getDefaultToolkit();
						 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
						 pw.setVisible(true);
				}
					if(btnno2=="6")
					{		billing pw = new billing(user,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,ct52,s6,ct72,ct82,id11,id12,String.valueOf(ne),id14,id15,d,uniq1,uniq2,wq1,wq2); // create ButtonFrame
						pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						 Toolkit tk=Toolkit.getDefaultToolkit();
						 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
						 pw.setVisible(true);
				}
					if(btnno2=="7")
					{		billing pw = new billing(user,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,ct52,ct62,s6,ct82,id11,id12,id13,String.valueOf(ne),id15,d,uniq1,uniq2,wq1,wq2); // create ButtonFrame
						pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						 Toolkit tk=Toolkit.getDefaultToolkit();
						 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
						 pw.setVisible(true);
				}
					if(btnno2=="8")
					{		billing pw = new billing(user,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,ct52,ct62,ct72,s6,id11,id12,id13,id14,String.valueOf(ne),d,uniq1,uniq2,wq1,wq2); // create ButtonFrame
						pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						 Toolkit tk=Toolkit.getDefaultToolkit();
						 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
						 pw.setVisible(true);
				}
					setVisible(false);
				}
				catch(SQLException fe)
				{
					JOptionPane.showMessageDialog(null, "Fill All The Fields And Try Again");
					//fe.printStackTrace();
				}
			
				
			}
			/*if(g.getSource()==b2)
			{
				 ccomp pw = new ccomp(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 pw.setSize( 400, 200 ); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			}*/
			if(g.getSource()==b3)
			{
				billing pw = new billing(user,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,ct52,ct62,ct72,ct82,id11,id12,id13,id14,id15,d,uniq1,uniq2,wq1,wq2);
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				 setVisible(false);
			}
		}
		
	}
	public void back()
	{
		billing pw = new billing(user,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,ct52,ct62,ct72,ct82,id11,id12,id13,id14,id15,d,uniq1,uniq2,wq1,wq2);
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		 setVisible(false);

	}
	
	public void yes()
	{
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
			String sql="insert into sentry1 values('"+s1+"',"+String.valueOf(ne)+",'"+s3+"','"+s4+"','"+s5+"',"+s6+","+s2+",'"+uniq1+"')";
			stm=d.createStatement();
			stm.executeUpdate(sql);
			/*if(g.getSource()==b4)
			{
				String dos=s1;
				String sid=String.valueOf(ne);
				String companyname=s3;
				String name=s5;
				String sp=s6;
				String voucherno=s2;
				printingtemplatesales2 example2 = new printingtemplatesales2(dos,sid,voucherno,name,companyname,sp);
			}*/
			if(btnno2=="4")
			{		billing pw = new billing(user,d1,cbillno2,cname2,c42,c52,c62,c72,c82,s6,ct52,ct62,ct72,ct82,String.valueOf(ne),id12,id13,id14,id15,d,uniq1,uniq2,wq1,wq2); // create ButtonFrame
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				 pw.setVisible(true);
		}
			if(btnno2=="5")
			{		billing pw = new billing(user,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,s6,ct62,ct72,ct82,id11,String.valueOf(ne),id13,id14,id15,d,uniq1,uniq2,wq1,wq2); // create ButtonFrame
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				 pw.setVisible(true);
		}
			if(btnno2=="6")
			{		billing pw = new billing(user,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,ct52,s6,ct72,ct82,id11,id12,String.valueOf(ne),id14,id15,d,uniq1,uniq2,wq1,wq2); // create ButtonFrame
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				 pw.setVisible(true);
		}
			if(btnno2=="7")
			{		billing pw = new billing(user,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,ct52,ct62,s6,ct82,id11,id12,id13,String.valueOf(ne),id15,d,uniq1,uniq2,wq1,wq2); // create ButtonFrame
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				 pw.setVisible(true);
		}
			if(btnno2=="8")
			{		billing pw = new billing(user,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,ct52,ct62,ct72,s6,id11,id12,id13,id14,String.valueOf(ne),d,uniq1,uniq2,wq1,wq2); // create ButtonFrame
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				 pw.setVisible(true);
		}
			setVisible(false);
		}
		catch(SQLException fe)
		{
			JOptionPane.showMessageDialog(null, "Fill All The Fields And Try Again");
			//fe.printStackTrace();
		}
	
	}
}
