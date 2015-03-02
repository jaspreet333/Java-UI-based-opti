import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;


public class bsms extends JFrame{

	String user=null;
	 private List<String> cookies;
	  private HttpURLConnection conn;
	  Statement stm=null;
		gcon k=new gcon();
		Connection d=k.getDBConnection();
	 
	  private final String USER_AGENT = "Mozilla/5.0";
	JPanel p1;
	JLabel l0=new JLabel(); 
	JLabel l1=new JLabel("Select category to send sms");
	JLabel l2=new JLabel("Message");
	String cst[]={"All","Bohra","Muslim","Sikh","Hindu","Christian"};
	JComboBox t1;
	JTextArea t2=new JTextArea();
	JButton b1=new JButton("Send");
	JButton b2=new JButton("Back");
	
	public bsms(String s2) {
		// TODO Auto-generated constructor stub
		super("Send Bulk SMS");
		user=s2;
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "back"); //$NON-NLS-1$
	        getRootPane().getActionMap().put("back", new AbstractAction(){ //$NON-NLS-1$
				@Override
				public void actionPerformed(ActionEvent arg0) {
				back();
				}
	        });
	        
		p1=new JPanel();
		p1.setLayout(null);
		t1=new JComboBox(cst);
		l0.setText("Welcome "+user);
		ButtonHandler l=new ButtonHandler();
		t2.setSize(300,120);
		t2.setLineWrap(true);
		t2.setWrapStyleWord(true);
		l0.setBounds(1050, 20, 150, 30);
		l1.setBounds(300, 80, 150, 40);
		t1.setBounds(600, 80, 250, 40);
		l2.setBounds(300, 140, 150, 40);
		t2.setBounds(600, 140, 300, 120);
		b1.setBounds(500, 300, 150, 40);
		b2.setBounds(750, 300, 150, 40);
		b1.addActionListener(l);b2.addActionListener(l);
		p1.add(l0);p1.add(l1);p1.add(t1);p1.add(l2);p1.add(t2);p1.add(b1);p1.add(b2);
		getContentPane().add(p1);
		
	}

	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==b1)
			{
				boolean internet=isInternetReachable();
				String v2=t2.getText();
				int lenk=v2.length();
				//System.out.println(v2);
				v2=v2.replaceAll(" ", "%20");
				v2=v2.replaceAll("\n", "%OA");
				//System.out.println(v2);
				if(internet==true)
				{
					
					String v1=(String) t1.getSelectedItem();
					String sql=null;
					int count=0;
					if(lenk<=160)
					{		
					
						if(v1.equals("All"))
						{
							sql="select count(*) as count from pdet";
						}
						if(v1.equals("Bohra"))
						{
							sql="select count(*) as count from pdet where caste='Bohra'";
						}
						if(v1.equals("Muslim"))
						{
							sql="select count(*) as count from pdet where caste='Muslim'";
						}
						if(v1.equals("Sikh"))
						{
							sql="select count(*) as count from pdet where caste='Sikh'";
						}
						if(v1.equals("Hindu"))
						{
							sql="select count(*) as count from pdet where caste='Hindu'";
						}
						if(v1.equals("Christian"))
						{
							sql="select count(*) as count from pdet where caste='Christian'";
						}
						try {
							stm=d.createStatement();
							ResultSet rs=stm.executeQuery(sql);
							while(rs.next())
							{
								count=rs.getInt("count");
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						String url="http://login.smsgatewayhub.com/smsapi/CheckBalance.aspx?user=9406682786&password=888496&gwid=0";
						CookieHandler.setDefault(new CookieManager());
						 
						// 1. Send a "GET" request, so that you can extract the form's data.
						String page = GetPageContent(url);
						int len=page.length();
						page=page.substring(8,len);
						//System.out.println(page);
						if(Integer.parseInt(page)>=count){
							
							String mob[]=new String[count];
							if(v1.equals("All"))
							{
								sql="select addr from pdet";
							}
							if(v1.equals("Bohra"))
							{
								sql="select addr from pdet where caste='Bohra'";
							}
							if(v1.equals("Muslim"))
							{
								sql="select addr from pdet where caste='Muslim'";
							}
							if(v1.equals("Sikh"))
							{
								sql="select addr from pdet where caste='Sikh'";
							}
							if(v1.equals("Hindu"))
							{
								sql="select addr from pdet where caste='Hindu'";
							}
							if(v1.equals("Christian"))
							{
								sql="select addr from pdet where caste='Christian'";
							}
							try {
								stm=d.createStatement();
								int i=0;
								ResultSet rs=stm.executeQuery(sql);
								while(rs.next())
								{
									mob[i++]=rs.getString("addr");
								}
								int j=0;
								for(j=0;j<count;j++)
								{
									url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=9406682786&pwd=888496&to="+mob[j]+"&sid=WEBSMS&msg="+v2+"&fl=0";
									page = GetPageContent(url);
								}
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else
						{
							int dialogButton = JOptionPane.YES_NO_OPTION;
							int dialogResult = JOptionPane.showConfirmDialog (null, "Your balance is not sufficient to send sms to all members.\nDo you want to send to some of them ?","Warning",dialogButton);
							if(dialogResult == JOptionPane.YES_OPTION){
								String mob[]=new String[Integer.parseInt(page)];
								if(v1.equals("All"))
								{
									sql="select addr from pdet where rownum<="+page;
								}
								if(v1.equals("Bohra"))
								{
									sql="select addr from pdet where caste='Bohra' and rownum<="+page;
								}
								if(v1.equals("Muslim"))
								{
									sql="select addr from pdet where caste='Muslim' and rownum<="+page;
								}
								if(v1.equals("Sikh"))
								{
									sql="select addr from pdet where caste='Sikh' and rownum<="+page;
								}
								if(v1.equals("Hindu"))
								{
									sql="select addr from pdet where caste='Hindu' and rownum<="+page;
								}
								if(v1.equals("Christian"))
								{
									sql="select addr from pdet where caste='Christian' and rownum<="+page;
								}
								try {
									stm=d.createStatement();
									int i=0;
									ResultSet rs=stm.executeQuery(sql);
									while(rs.next())
									{
										mob[i++]=rs.getString("addr");
									}
									int j=0;
									int maci=Integer.parseInt(page);
									for(j=0;j<maci;j++)
									{
										url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=9406682786&pwd=888496&to="+mob[j]+"&sid=WEBSMS&msg="+v2+"&fl=0";
										page = GetPageContent(url);
									}
									
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					 //url = "http://bhashsms.com/api/sendmsg.php?user=success&pass=123456&sender=BSHSMS&phone=9981864779&text=hey%20how%20are%20u%20from%20java&priority=dnd&stype=normal";
				//String gmail = "http://site25.way2sms.com/main.action?section=s&Token=353966D11A7A66DB53BD1FB7FF858647.w805&vfType=register_verify";
			 
				//HttpUrlConnectionExample http = new HttpUrlConnectionExample();
			 
				// make sure cookies is turn on
			
				//System.out.println(page);
				}
					else
					{
						 int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog (null, "Message lenght is more than 160 credits. It will cost more than 1 sms credit.\nDo u want to send sms ?","Warning",dialogButton);
						if(dialogResult == JOptionPane.YES_OPTION){
							if(v1.equals("All"))
							{
								sql="select count(*) as count from pdet";
							}
							if(v1.equals("Bohra"))
							{
								sql="select count(*) as count from pdet where caste='Bohra'";
							}
							if(v1.equals("Muslim"))
							{
								sql="select count(*) as count from pdet where caste='Muslim'";
							}
							if(v1.equals("Sikh"))
							{
								sql="select count(*) as count from pdet where caste='Sikh'";
							}
							if(v1.equals("Hindu"))
							{
								sql="select count(*) as count from pdet where caste='Hindu'";
							}
							if(v1.equals("Christian"))
							{
								sql="select count(*) as count from pdet where caste='Christian'";
							}
							try {
								stm=d.createStatement();
								ResultSet rs=stm.executeQuery(sql);
								while(rs.next())
								{
									count=rs.getInt("count");
								}
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							String url="http://login.smsgatewayhub.com/smsapi/CheckBalance.aspx?user=9406682786&password=888496&gwid=0";
							CookieHandler.setDefault(new CookieManager());
							 
							// 1. Send a "GET" request, so that you can extract the form's data.
							String page = GetPageContent(url);
							int len=page.length();
							page=page.substring(8,len );
							//System.out.println(page);
							if(Integer.parseInt(page)>=2*count){
								
								String mob[]=new String[count];
								if(v1.equals("All"))
								{
									sql="select addr from pdet";
								}
								if(v1.equals("Bohra"))
								{
									sql="select addr from pdet where caste='Bohra'";
								}
								if(v1.equals("Muslim"))
								{
									sql="select addr from pdet where caste='Muslim'";
								}
								if(v1.equals("Sikh"))
								{
									sql="select addr from pdet where caste='Sikh'";
								}
								if(v1.equals("Hindu"))
								{
									sql="select addr from pdet where caste='Hindu'";
								}
								if(v1.equals("Christian"))
								{
									sql="select addr from pdet where caste='Christian'";
								}
								try {
									stm=d.createStatement();
									int i=0;
									ResultSet rs=stm.executeQuery(sql);
									while(rs.next())
									{
										mob[i++]=rs.getString("addr");
									}
									int j=0;
									for(j=0;j<count;j++)
									{
										url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=9406682786&pwd=888496&to="+mob[j]+"&sid=WEBSMS&msg="+v2+"&fl=0";
										page = GetPageContent(url);
									}
									
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							else
							{
								int dialogButton1 = JOptionPane.YES_NO_OPTION;
								int dialogResult1 = JOptionPane.showConfirmDialog (null, "Your balance is not sufficient to send sms to all members.\nDo you want to send to some of them ?","Warning",dialogButton1);
								if(dialogResult == JOptionPane.YES_OPTION){
									
									page=Integer.toString(Integer.parseInt(page)/2);
									String mob[]=new String[Integer.parseInt(page)];
									if(v1.equals("All"))
									{
										sql="select addr from pdet where rownum<="+page;
									}
									if(v1.equals("Bohra"))
									{
										sql="select addr from pdet where caste='Bohra' and rownum<="+page;
									}
									if(v1.equals("Muslim"))
									{
										sql="select addr from pdet where caste='Muslim' and rownum<="+page;
									}
									if(v1.equals("Sikh"))
									{
										sql="select addr from pdet where caste='Sikh' and rownum<="+page;
									}
									if(v1.equals("Hindu"))
									{
										sql="select addr from pdet where caste='Hindu' and rownum<="+page;
									}
									if(v1.equals("Christian"))
									{
										sql="select addr from pdet where caste='Christian' and rownum<="+page;
									}
									try {
										stm=d.createStatement();
										int i=0;
										ResultSet rs=stm.executeQuery(sql);
										while(rs.next())
										{
											mob[i++]=rs.getString("addr");
										}
										int j=0;
										int maci=Integer.parseInt(page);
										for(j=0;j<maci;j++)
										{
											url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=9406682786&pwd=888496&to="+mob[j]+"&sid=WEBSMS&msg="+v2+"&fl=0";
											page = GetPageContent(url);
										}
										
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
							}
						}
						}
					}
				else
				{
					JOptionPane.showMessageDialog(null,"No Internet Connectivity. Try Again Later");
					
				}
				doit pw = new doit(user); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			}
			
			if(e.getSource()==b2)
			{
				 doit pw = new doit(user); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			}
		}
		
	}
	
	public String GetPageContent(String url)  {
		 
		URL obj=null;;
		try {
			obj = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = (HttpURLConnection) obj.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		// default is GET
		try {
			conn.setRequestMethod("GET");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		conn.setUseCaches(false);
	 
		// act like a browser
		conn.setRequestProperty("User-Agent", USER_AGENT);
		conn.setRequestProperty("Accept",
			"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		if (cookies != null) {
			for (String cookie : this.cookies) {
				conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
			}
		}
		int responseCode=0;
		String inputLine;
		StringBuffer response = new StringBuffer();
		BufferedReader in=null;
		try {
			responseCode = conn.getResponseCode();
			//System.out.println("\nSending 'GET' request to URL : " + url);
			//System.out.println("Response Code : " + responseCode);
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((inputLine = in.readLine()) != null) 
				response.append(inputLine);
				
				in.close();
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"No Internet Connection");
		}
		
		
		
	 
		// Get the response cookies
		setCookies(conn.getHeaderFields().get("Set-Cookie"));
	 
		return response.toString();
	 
	  }

	  public List<String> getCookies() {
			return cookies;
		  }
		 
		  public void setCookies(List<String> cookies) {
			this.cookies = cookies;
		  }
		 
	
	public boolean isInternetReachable()
	{
		try {
	        //make a URL to a known source
	        URL url = new URL("http://www.google.com");

	        //open a connection to that source
	        HttpURLConnection urlConnect = (HttpURLConnection)url.openConnection();

	        //trying to retrieve data from the source. If there
	        //is no connection, this line will fail
	        Object objData = urlConnect.getContent();
	        //System.out.println("SUCCESSFUL INTERNET CONNECTION");

	    } catch (UnknownHostException e) {
	        // TODO Auto-generated catch block

	        //System.out.println("CONNECTION FAILED");
	        //e.printStackTrace();
	        return false;
	    }
	    catch (IOException e) {
	        // TODO Auto-generated catch block
	        //System.out.println("CONNECTION FAILED");
	        //e.printStackTrace();
	        return false;
	    }
	    return true;
	}
	public void back()
	{
		 doit pw = new doit(user); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		setVisible(false);

	}
}
