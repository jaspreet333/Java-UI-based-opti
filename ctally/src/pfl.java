//import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
//import java.awt.TextField;
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
//import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import org.jdesktop.swingx.*;

//import java.util.*;
import java.text.*;




public class pfl extends JFrame{

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
	JLabel l10=new JLabel("Prescription");
	JXDatePicker t1=new JXDatePicker();
	//JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	JTextField t5=new JTextField();
	JTextField t6=new JTextField();
	JTextField t7=new JTextField();JTextField t10=new JTextField();
	//JTextField t8=new JTextField();
	JButton b10=new JButton("Add Prescription");
	//JButton b1=new JButton("Create Company");
	JButton b2=new JButton("Generate Total");
	JButton b3=new JButton("Save");
	//JButton b5=new JButton("Print & Save");
	JButton b4=new JButton("Back");
	//String[] ar=new String[20];
	//ArrayList<String> ar = new ArrayList<String>();
	
	Statement stm=null;
	String user1;
	gcon k=new gcon();
	Connection d;
	int ne=0;
	int ak=0;
	char[] amt57;
	String samt44=null;
	String cbillno2=null, cname2=null,btnno2=null;
	Date d1;
	int c42,c52,c62,c72,c82;
	String ct42,ct52,ct62,ct72,ct82;
	String id11,id12,id13,id14,id15;
	int casteinframe,joininframe;String mobnoinframe=null;
	public pfl(String user, Date d2, String cbillno1, String cname1, int c41, int c51, int c61, int c71, int c81, String ct41, String ct51, String ct61, String ct71, String ct81, String btnno,String id1, String id2, String id3, String id4, String id5, Connection f, String cmobno, String cpres, int castei, int joini)
	{
		// TODO Auto-generated constructor stub
		super("Sale of Frame And Lens");
		btnno2=btnno;
		casteinframe=castei;
		joininframe=joini;
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
		mobnoinframe=cmobno;
		t10.setText("null");
		// TODO Auto-generated constructor stub
		c42=c41;c52=c51;c62=c61;c72=c71;c82=c81;ct42=ct41;ct52=ct51;ct62=ct61;ct72=ct71;ct82=ct81;
		id11=id1;id12=id2;id13=id3;id14=id4;id15=id5;
		d1=d2;
		/*try {
			d.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		p1.setLayout(null);
		d=f;
		int i=0;
	    cbillno2 =cbillno1; 
		cname2=cname1;
		//amt57=amt56;
		//&amt1=&aki;
		ne=0;
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
			 String sql="Select max(sid) as count from sentry2";
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
		user1=user;
		ButtonHandler l=new ButtonHandler();
		//t4=new JComboBox(ar);
		//t5=new JComboBox(ar);
		t1.setDate(d2);
		//System.out.println(bfname);
		t3.setText(cname1);
		t1.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));
		p1.setLayout(null);
		l0.setText("Welcome "+user);
		t2.setText(String.valueOf(ne));
		l0.setBounds(1100, 20, 120, 30);
		b4.setBounds(100, 20, 100, 30);
		l1.setBounds(300, 60, 300, 40);
		t1.setBounds(700, 60, 300, 40);
		l2.setBounds(300, 110, 300, 40);
		t2.setBounds(700, 110, 300, 40);
		l3.setBounds(300, 160, 300, 40);
		t3.setBounds(700, 160, 300, 40);
		l4.setBounds(300, 210, 300, 40);
		t4.setBounds(700, 210, 300, 40);
		//b1.setBounds(250, 200, 125, 20);
		l5.setBounds(300, 260, 300, 40);
		t5.setBounds(700, 260, 300, 40);
		l6.setBounds(300, 310, 300, 40);
		t6.setBounds(700, 310, 300, 40);
		l7.setBounds(300, 360, 300, 40);
		t7.setBounds(700, 360, 300, 40);
		l10.setBounds(300, 410, 300, 40);
		t10.setBounds(700, 410, 300, 40);
		b10.setBounds(1050, 410, 200, 40);
		l8.setBounds(300, 460, 300, 40);
		//t8.setBounds(200, 350, 100, 30);
		l9.setBounds(700, 460, 300, 40);
		//l10.setBounds(200, 390, 100, 30);
		b2.setBounds(1050, 460, 200, 30);
		b3.setBounds(500, 510, 120, 30);
		//b5.setBounds(700, 510, 120, 30);
		//b1.addActionListener(l);
		b2.addActionListener(l);
		b3.addActionListener(l);b10.addActionListener(l);
	p1.add(l10);p1.add(t10);p1.add(b10);
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

		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(t5);
		p1.add(t6);
		p1.add(t7);
		//p1.add(b1);
		p1.add(b2);
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
			if(f.getSource()==b10)
			{
				String filePath="null";
				//System.out.println("in the add prescription");
				JFileChooser fileChooser = new JFileChooser();
			        int returnValue = fileChooser.showOpenDialog(null);
			        if (returnValue == JFileChooser.APPROVE_OPTION) {
			        	filePath = fileChooser.getSelectedFile().getAbsolutePath();
			        	//File selectedFile = fileChooser.getSelectedFile();
			          //System.out.println(filePath);
			        }
			        t10.setText(filePath);
			}
			
			if(f.getSource()==b2)
			{
				String s1=t6.getText();
				String s2=t7.getText();
				double l1,l2;
				l1=Double.parseDouble(s1);
				l2=Double.parseDouble(s2);
				String tp=Double.toString(l1+l2);
				l9.setText(tp);
				
				
			}
			if(f.getSource()==b3)
			{
				//d=k.getDBConnection();
				String o1=t6.getText();
				String o2=t7.getText();
				int p1,p2;
				p1=Integer.parseInt(o1);
				p2=Integer.parseInt(o2);
				String tpo=Integer.toString(p1+p2);
				l9.setText(tpo);
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
				String s9=t10.getText();
				//int l=s8.length();
				//System.out.println(s8);
				//amt57=s8.toCharArray();
				//System.out.println(amt57);
				//String s9=.getText();
				try
				{
					String sql="insert into sentry2 values('"+s1+"',"+String.valueOf(ne)+",'"+s3+"','"+s4+"','"+s5+"',"+s6+","+s7+","+s8+","+s2+",'"+mobnoinframe+"')";
					stm=d.createStatement();
					stm.executeUpdate(sql);
/*					if(f.getSource()==b5)
					{
						String dop=s1;
						String sid=String.valueOf(ne);
						String clens=s4;
						String cframe=s5;
						String name=s3;
						String plens=s6;
						String pframe=s7;
						String tp=s8;
						String voucherno=s2;
						printingtemplatesales example2 = new printingtemplatesales(dop,sid,voucherno,name,clens,plens,cframe,pframe,tp);
					}
*/					
					if(btnno2=="4")
					{		billing pw = new billing(user1,d1,cbillno2,cname2,c42,c52,c62,c72,c82,s8,ct52,ct62,ct72,ct82,String.valueOf(ne),id12,id13,id14,id15,d,mobnoinframe,s9,casteinframe,joininframe); // create ButtonFrame
						pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						 Toolkit tk=Toolkit.getDefaultToolkit();
						 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
						 pw.setVisible(true);
				}
					if(btnno2=="5")
					{		billing pw = new billing(user1,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,s8,ct62,ct72,ct82,id11,String.valueOf(ne),id13,id14,id15,d,mobnoinframe,s9,casteinframe,joininframe); // create ButtonFrame
						pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						 Toolkit tk=Toolkit.getDefaultToolkit();
						 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
						 pw.setVisible(true);
				}
					if(btnno2=="6")
					{		billing pw = new billing(user1,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,ct52,s8,ct72,ct82,id11,id12,String.valueOf(ne),id14,id15,d,mobnoinframe,s9,casteinframe,joininframe); // create ButtonFrame
						pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						 Toolkit tk=Toolkit.getDefaultToolkit();
						 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
						 pw.setVisible(true);
				}
					if(btnno2=="7")
					{		billing pw = new billing(user1,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,ct52,ct62,s8,ct82,id11,id12,id13,String.valueOf(ne),id15,d,mobnoinframe,s9,casteinframe,joininframe); // create ButtonFrame
						pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						 Toolkit tk=Toolkit.getDefaultToolkit();
						 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
						 pw.setVisible(true);
				}
					if(btnno2=="8")
					{		billing pw = new billing(user1,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,ct52,ct62,ct72,s8,id11,id12,id13,id14,String.valueOf(ne),d,mobnoinframe,s9,casteinframe,joininframe); // create ButtonFrame
						pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						 Toolkit tk=Toolkit.getDefaultToolkit();
						 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
						 pw.setVisible(true);
				}
					
					setVisible(false);
				}
				catch(SQLException fe)
				{
					//System.out.println("In the Error state");
					JOptionPane.showMessageDialog(null, "Fill All The Fields And Try Again");
					fe.printStackTrace();
				}
			
				 
			}
			if(f.getSource()==b4)
			{
				billing pw = new billing(user1,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,ct52,ct62,ct72,ct82,id11,id12,id13,id14,id15,d,mobnoinframe,"null",casteinframe,joininframe);
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
		billing pw = new billing(user1,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,ct52,ct62,ct72,ct82,id11,id12,id13,id14,id15,d,mobnoinframe,"null",casteinframe,joininframe);
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		 setVisible(false);
		 

	}
	public void yes()
	{
		String o1=t6.getText();
		String o2=t7.getText();
		int p1,p2;
		p1=Integer.parseInt(o1);
		p2=Integer.parseInt(o2);
		String tpo=Integer.toString(p1+p2);
		l9.setText(tpo);
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
		String s9=t10.getText();
		//int l=s8.length();
		//System.out.println(s8);
		//amt57=s8.toCharArray();
		//System.out.println(amt57);
		//String s9=.getText();
		try
		{
			String sql="insert into sentry2 values('"+s1+"',"+String.valueOf(ne)+",'"+s3+"','"+s4+"','"+s5+"',"+s6+","+s7+","+s8+","+s2+",'"+mobnoinframe+"')";
			stm=d.createStatement();
			stm.executeUpdate(sql);
/*					if(f.getSource()==b5)
			{
				String dop=s1;
				String sid=String.valueOf(ne);
				String clens=s4;
				String cframe=s5;
				String name=s3;
				String plens=s6;
				String pframe=s7;
				String tp=s8;
				String voucherno=s2;
				printingtemplatesales example2 = new printingtemplatesales(dop,sid,voucherno,name,clens,plens,cframe,pframe,tp);
			}
*/					
			if(btnno2=="4")
			{		billing pw = new billing(user1,d1,cbillno2,cname2,c42,c52,c62,c72,c82,s8,ct52,ct62,ct72,ct82,String.valueOf(ne),id12,id13,id14,id15,d,mobnoinframe,s9,casteinframe,joininframe); // create ButtonFrame
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				 pw.setVisible(true);
		}
			if(btnno2=="5")
			{		billing pw = new billing(user1,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,s8,ct62,ct72,ct82,id11,String.valueOf(ne),id13,id14,id15,d,mobnoinframe,s9,casteinframe,joininframe); // create ButtonFrame
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				 pw.setVisible(true);
		}
			if(btnno2=="6")
			{		billing pw = new billing(user1,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,ct52,s8,ct72,ct82,id11,id12,String.valueOf(ne),id14,id15,d,mobnoinframe,s9,casteinframe,joininframe); // create ButtonFrame
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				 pw.setVisible(true);
		}
			if(btnno2=="7")
			{		billing pw = new billing(user1,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,ct52,ct62,s8,ct82,id11,id12,id13,String.valueOf(ne),id15,d,mobnoinframe,s9,casteinframe,joininframe); // create ButtonFrame
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				 pw.setVisible(true);
		}
			if(btnno2=="8")
			{		billing pw = new billing(user1,d1,cbillno2,cname2,c42,c52,c62,c72,c82,ct42,ct52,ct62,ct72,s8,id11,id12,id13,id14,String.valueOf(ne),d,mobnoinframe,s9,casteinframe,joininframe); // create ButtonFrame
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				 pw.setVisible(true);
		}
			
			setVisible(false);
		}
		catch(SQLException fe)
		{
			//System.out.println("In the Error state");
			JOptionPane.showMessageDialog(null, "Fill All The Fields And Try Again");
			fe.printStackTrace();
		}
	
	}
	
	
}
