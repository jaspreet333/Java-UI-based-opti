import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

import org.jdesktop.swingx.JXDatePicker;


public class mpeb extends JFrame {

	JLabel l0=new JLabel();JLabel l10=new JLabel("Balance");JLabel l11=new JLabel();
	JLabel l1=new JLabel("Choose Name and Mob No");
	JComboBox t1;
	JLabel l2=new JLabel("Amount");
	JLabel l3=new JLabel("Description");
	JLabel l4=new JLabel("Discount");JLabel l5=new JLabel("Date");
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();JTextField t4=new JTextField();JXDatePicker t5=new JXDatePicker();
	JPanel p1;
	JButton b1=new JButton("Back");
	JButton b2=new JButton("Save");JButton b3=new JButton("Show balance of this member");
	Statement stm=null;
	gcon k=new gcon();
	Connection d=k.getDBConnection();
	String user=null;
	
	public mpeb(String s2) {
		// TODO Auto-generated constructor stub
		super("Sales Payment Entry");
		user=s2;
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
		l0.setText("Welcome "+user);
		p1=new JPanel();
		p1.setLayout(null);
		int size=0;
		try
		{
			String sql="Select count(*) as count from pdet";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				if(rs.getString("count") != null)
					size = Integer.parseInt(rs.getString("count"));
				//size++;
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		String ar[]=new String [size];
		int i=0;
		t5.setDate(Calendar.getInstance().getTime());
		t5.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));
		
		try
		{
			String sql="select name,addr from pdet order by name asc";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				ar[i]=rs.getString("addr");
				ar[i]=ar[i]+" "+rs.getString("name");
				i++;
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		getRootPane().setFocusable(true);
		t1=new JComboBox(ar);
		l0.setBounds(1050,20,200,30);
		b1.setBounds(20,20,120,30);
		l5.setBounds(300, 80, 200, 40);
		t5.setBounds(600,80,300,40);
		l1.setBounds(300, 140, 200, 40);
		t1.setBounds(600,140,300,40);b3.setBounds(1000,140,250,40);l10.setBounds(1000,200,100,40);l11.setBounds(1150,200,100,40);
		l10.setVisible(false);
		l2.setBounds(300, 200, 200, 40);
		t2.setBounds(600,200,300,40);
		l3.setBounds(300, 260, 200, 40);
		t3.setBounds(600,260,300,40);
		l4.setBounds(300, 320, 200, 40);t4.setText("0");
		t4.setBounds(600,320,300,40);
		b2.setBounds(600,400,160,30);
		ButtonHandler l=new ButtonHandler();
		b3.addActionListener(l);b1.addActionListener(l);b2.addActionListener(l);p1.add(b3);p1.add(l10);p1.add(l11);p1.add(l5);p1.add(t5);
		p1.add(l4);p1.add(b1);p1.add(b2);p1.add(l0);p1.add(l1);p1.add(t1);p1.add(l2);p1.add(t2);p1.add(l3);p1.add(t3);p1.add(t4);
		getContentPane().add(p1);
	}
	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==b1)
			{
				 doit pw = new doit(user); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
				try {
					d.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
			if(e.getSource()==b3)
			{
				String s1=(String) t1.getSelectedItem();
				s1=(String) s1.subSequence(0, 10);
				String cbal=null;
				try {
					String sql="select balance from pdet where addr='"+s1+"'";
					stm=d.createStatement();
					ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						cbal=rs.getString("balance");
					}
					l10.setVisible(true);
					l11.setText(cbal);
					
				}
				catch(SQLException e1)
				{
					
				}
			}
			if(e.getSource()==b2)
			{
			yes();	
			}
			}
		
		}
	public void back()
	{
		 doit pw = new doit(user); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		setVisible(false);
		try {
			d.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}

	}
	public void yes()
	{
		String mak=null;
		String s1=(String) t1.getSelectedItem();
		s1=(String) s1.subSequence(0, 10);//mobile No
		//System.out.println(s1);
		String s2=t2.getText();String s3=t3.getText();
		String s4=t4.getText();
		Date s12=t5.getDate();
		//System.out.println(s12);
		SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
		String s11=sdf.format(s12);
		String s22=Integer.toString(Integer.parseInt(s2)+Integer.parseInt(s4));
		String sql="select max(tranid) as maji from transrec";
		try {
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				if(rs.getString("maji")!=null)
					{
					mak=rs.getString("maji");
					mak=Integer.toString(Integer.parseInt(mak)+1);
					}
					
				else
					mak="1";
			}
			sql="insert into transrec values ('"+s1+"',"+s22+","+mak+",'"+s3+"','"+s11+"')";
			stm=d.createStatement();
			stm.executeUpdate(sql);
			String stat=null;
			sql="select stat from pdet where addr='"+s1+"'";
			stm=d.createStatement();
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				stat=rs.getString("stat");
			}
			if(stat.equals("j"))
			{
				String bal=null;
				sql="select balance from pdet where addr='"+s1+"'";
				stm=d.createStatement();
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					bal=rs.getString("balance");
				}
				bal=Integer.toString(Integer.parseInt(bal)-Integer.parseInt(s2));
				
				sql="select * from jointacc where (mob1='"+s1+"' or mob2='"+s1+"' or mob3='"+s1+"' or mob4='"+s1+"' or mob5='"+s1+"')";
				stm=d.createStatement();
				rs=stm.executeQuery(sql);
				String k1=null,k2=null,k3=null,k4=null,k5=null;
				while(rs.next())
				{
					k1=rs.getString("mob1");k2=rs.getString("mob2");k3=rs.getString("mob3");k4=rs.getString("mob4");k5=rs.getString("mob5");
					
				}
				if(k1!=null)
				{
					sql="update pdet set balance="+bal+" where addr='"+k1+"'";
					stm=d.createStatement();
					stm.executeUpdate(sql);
				}
				if(k2!=null)
				{
					sql="update pdet set balance="+bal+" where addr='"+k2+"'";
					stm=d.createStatement();
					stm.executeUpdate(sql);
				}
				if(k3!=null)
				{
					sql="update pdet set balance="+bal+" where addr='"+k3+"'";
					stm=d.createStatement();
					stm.executeUpdate(sql);
				}
				if(k4!=null)
				{
					sql="update pdet set balance="+bal+" where addr='"+k4+"'";
					stm=d.createStatement();
					stm.executeUpdate(sql);
				}
				if(k5!=null)
				{
					sql="update pdet set balance="+bal+" where addr='"+k5+"'";
					stm=d.createStatement();
					stm.executeUpdate(sql);
				}
				
			}
			else
			{
				String bal=null;
				sql="select balance from pdet where addr='"+s1+"'";
				stm=d.createStatement();
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					bal=rs.getString("balance");
				}
				bal=Integer.toString(Integer.parseInt(bal)-Integer.parseInt(s22));
				sql="update pdet set balance="+bal+" where addr='"+s1+"'";
				stm=d.createStatement();
				rs=stm.executeQuery(sql);
			}
			
			
		
		HttpUrlConnectionExample http = new HttpUrlConnectionExample();
		CookieHandler.setDefault(new CookieManager());
		boolean internet=http.isInternetReachable();
		String urlbal="http://login.smsgatewayhub.com/smsapi/CheckBalance.aspx?user=9406682786&password=888496&gwid=0";
		//CookieHandler.setDefault(new CookieManager());
		 
		// 1. Send a "GET" request, so that you can extract the form's data.
		
		
		String message="Cash Received Rs "+s2 +" .Take Care of Your Eyes.Thanks for visiting City Opticals";
		//message="Hello, this is a test message.";
		message=message.replaceAll(" ", "%20");
		if(internet)
		{
			String pagebal = http.GetPageContent(urlbal);
			int len=pagebal.length();
			pagebal=pagebal.substring(8,len );
			sql="Select stat from pdet where addr='"+s1+"'";
		stm=d.createStatement();
		 rs=stm.executeQuery(sql);
		String smsj=null;
		while(rs.next())
		{
			smsj=rs.getString("stat");
		}
		
		
		
		if(smsj.equals("j"))
		{
			String w1=null,w2=null,w3=null,w4=null,w5=null;
			sql="select * from jointacc where (mob1='"+s1+"' or mob2='"+s1+"' or mob3='"+s1+"' or mob4='"+s1+"' or mob5='"+s1+"')";
			stm=d.createStatement();
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				w1=rs.getString("mob1");w2=rs.getString("mob2");w3=rs.getString("mob3");
				w4=rs.getString("mob4");w5=rs.getString("mob5");
			}
			String url=null,page=null;
			int holder=0;
			
			if(w1!=null)
				holder++;
			if(w2!=null)
				holder++;
			if(w3!=null)
				holder++;
			if(w4!=null)
				holder++;
			if(w5!=null)
				holder++;
			
			if(Integer.parseInt(pagebal)>=holder)
			{
			if(w1!=null){
				url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=9406682786&pwd=888496&to="+w1+"&sid=WEBSMS&msg="+message+"&fl=0";
				page = http.GetPageContent(url);
			}
			if(w2!=null){
				url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=9406682786&pwd=888496&to="+w2+"&sid=WEBSMS&msg="+message+"&fl=0";
				page = http.GetPageContent(url);
			}
			if(w3!=null){
				url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=9406682786&pwd=888496&to="+w3+"&sid=WEBSMS&msg="+message+"&fl=0";
				page = http.GetPageContent(url);
			}
			if(w4!=null){
				url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=9406682786&pwd=888496&to="+w4+"&sid=WEBSMS&msg="+message+"&fl=0";
				page = http.GetPageContent(url);
			}
			if(w5!=null){
				url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=9406682786&pwd=888496&to="+w5+"&sid=WEBSMS&msg="+message+"&fl=0";
				page = http.GetPageContent(url);
			}
		}
			else
			{

					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "Your balance is not sufficient to send sms .\nDo you want to store it to automatically send it afterwards ?","Warning",dialogButton);
					String mba="1";
					if(dialogResult == JOptionPane.YES_OPTION){
						sql="select max(pid) as maxi from pendingsms";
						stm=d.createStatement();
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							if(rs.getString("maxi")!=null)
								{
								mba=rs.getString("maxi");
								mba=Integer.toString(Integer.parseInt(mba)+1);
								}
						}
						if(w1!=null)
						{
							sql="insert into pendingsms values("+mba+",'"+w1+"','"+message+"')";
							stm=d.createStatement();
							stm.executeUpdate(sql);
						}
						if(w2!=null)
						{
							sql="insert into pendingsms values("+Integer.toString(Integer.parseInt(mba)+1)+",'"+w2+"','"+message+"')";
							stm=d.createStatement();
							stm.executeUpdate(sql);
						}
						if(w3!=null)
						{
							sql="insert into pendingsms values("+Integer.toString(Integer.parseInt(mba)+2)+",'"+w2+"','"+message+"')";
							stm=d.createStatement();
							stm.executeUpdate(sql);
						}
						if(w4!=null)
						{
							sql="insert into pendingsms values("+Integer.toString(Integer.parseInt(mba)+3)+",'"+w2+"','"+message+"')";
							stm=d.createStatement();
							stm.executeUpdate(sql);
						}
						if(w5!=null)
						{
							sql="insert into pendingsms values("+Integer.toString(Integer.parseInt(mba)+4)+",'"+w5+"','"+message+"')";
							stm=d.createStatement();
							stm.executeUpdate(sql);
						}
						
					}
				
			}

		}
		else
		{
			if(Integer.parseInt(pagebal)>=1)
			{
				String url=null,page=null;
				url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=9406682786&pwd=888496&to="+s1+"&sid=WEBSMS&msg="+message+"&fl=0";
				page = http.GetPageContent(url);
			}
			else
			{
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Your balance is not sufficient to send sms .\nDo you want to store it to automatically send it afterwards ?","Warning",dialogButton);
				String mba="1";
				if(dialogResult == JOptionPane.YES_OPTION){
					sql="select max(pid) as maxi from pendingsms";
					stm=d.createStatement();
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						if(rs.getString("maxi")!=null)
							{
							mba=rs.getString("maxi");
							mba=Integer.toString(Integer.parseInt(mba)+1);
							}
					}
					
					sql="insert into pendingsms values("+Integer.toString(Integer.parseInt(mba))+",'"+s1+"','"+message+"')";
					stm=d.createStatement();
					stm.executeUpdate(sql);
				
					
				}
			}
		}
		}
		else
		{
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog (null, "There is no internet connection at present,so cant send sms notification.\nDo you want to store transaction sms, to automatically send it afterwards ?","Warning",dialogButton);
			if(dialogResult == JOptionPane.YES_OPTION)
			{
				//System.out.println("In yes option");
				sql="Select stat from pdet where addr='"+s1+"'";
				stm=d.createStatement();
				rs=stm.executeQuery(sql);
				String smsj=null;
				while(rs.next())
				{
					smsj=rs.getString("stat");
				}
				
				if(smsj.equals("j"))
				{
					String w1=null,w2=null,w3=null,w4=null,w5=null;
					sql="select * from jointacc where (mob1='"+s1+"' or mob2='"+s1+"' or mob3='"+s1+"' or mob4='"+s1+"' or mob5='"+s1+"')";
					stm=d.createStatement();
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						w1=rs.getString("mob1");w2=rs.getString("mob2");w3=rs.getString("mob3");
						w4=rs.getString("mob4");w5=rs.getString("mob5");
					}
					String mba="1";
					sql="select max(pid) as maxi from pendingsms";
					stm=d.createStatement();
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						if(rs.getString("maxi")!=null)
							{
							mba=rs.getString("maxi");
							mba=Integer.toString(Integer.parseInt(mba)+1);
							}
					}
					if(w1!=null)
					{
						sql="insert into pendingsms values("+mba+",'"+w1+"','"+message+"')";
						stm=d.createStatement();
						stm.executeUpdate(sql);
					}
					if(w2!=null)
					{
						sql="insert into pendingsms values("+Integer.toString(Integer.parseInt(mba)+1)+",'"+w2+"','"+message+"')";
						stm=d.createStatement();
						stm.executeUpdate(sql);
					}
					if(w3!=null)
					{
						sql="insert into pendingsms values("+Integer.toString(Integer.parseInt(mba)+2)+",'"+w2+"','"+message+"')";
						stm=d.createStatement();
						stm.executeUpdate(sql);
					}
					if(w4!=null)
					{
						sql="insert into pendingsms values("+Integer.toString(Integer.parseInt(mba)+3)+",'"+w2+"','"+message+"')";
						stm=d.createStatement();
						stm.executeUpdate(sql);
					}
					if(w5!=null)
					{
						sql="insert into pendingsms values("+Integer.toString(Integer.parseInt(mba)+4)+",'"+w5+"','"+message+"')";
						stm=d.createStatement();
						stm.executeUpdate(sql);
					}
		
					
					
				}
				else
				{
					//System.out.println("In the else part");
					String mba="1";
					sql="select max(pid) as maxi from pendingsms";
					stm=d.createStatement();
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						if(rs.getString("maxi")!=null)
							{
							mba=rs.getString("maxi");
							mba=Integer.toString(Integer.parseInt(mba)+1);
							}
					}
					sql="insert into pendingsms values("+mba+",'"+s1+"','"+message+"')";
					stm=d.createStatement();
					stm.executeUpdate(sql);
				}
			}
		}
		d.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Fill All Fields");
			//e1.printStackTrace();
		}
		doit pw = new doit(user); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		 setVisible(false);
		

	}
	
	}

