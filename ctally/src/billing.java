import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
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
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 


public class billing extends JFrame{

	
	Statement stm=null;
	gcon k=new gcon();
	//Connection d=k.getDBConnection();
	Connection d;
	JPanel p1=new JPanel();
	ImageIcon printImage;
	JLabel l0=new JLabel();
	JLabel l1=new JLabel("Date");
	JLabel l2=new JLabel("Bill NO");
	JLabel l3=new JLabel("Name");
	//Object objData=null;
	
	JXDatePicker t1=new JXDatePicker();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JLabel l4=new JLabel("1");
	JLabel l5=new JLabel("2");
	JLabel l6=new JLabel("3");
	JLabel l7=new JLabel("4");
	JLabel l8=new JLabel("5");
	JLabel l9=new JLabel("S.NO");
	JLabel l10=new JLabel("Product");
	JLabel l11=new JLabel("Price Inclusive of VAT");
	JLabel l12=new JLabel("VAT ");
	JLabel l13=new JLabel("TOTAl");
	JLabel l14=new JLabel();
	JLabel l15=new JLabel();
	JLabel l16=new JLabel("Mobile No");JLabel l17=new JLabel("Join With");JLabel l18=new JLabel("Caste");JLabel l19=new JLabel("Advance");
	JComboBox t4;
	JComboBox t5;
	JComboBox t6;
	JComboBox t7;
	JComboBox t8;JComboBox t18;
	JComboBox t17;JTextField t16=new JTextField();JTextField t19=new JTextField();
	JTextField t41=new JTextField();
	JTextField t51=new JTextField();
	JTextField t61=new JTextField();
	JTextField t71=new JTextField();
	JTextField t81=new JTextField();
	JTextField q41=new JTextField();
	JTextField q51=new JTextField();
	JTextField q61=new JTextField();
	JTextField q71=new JTextField();
	JTextField q81=new JTextField();
	JButton b1=new JButton("Save");
	JButton b2=new JButton("Save & Print");
	JButton b3=new JButton("Discard And Go Back");
	JButton b4=new JButton("Add");
	JButton b5=new JButton("Add");
	JButton b6=new JButton("Add");
	JButton b7=new JButton("Add");
	JButton b8=new JButton("Add");
	JButton b9=new JButton("Generate Total");
	URL url=null;
	String user=null;
	String ar[]={"Frame + Lens","Sunglasses","Contact Lens","Lens Solution"};
	private final String USER_AGENT = "Mozilla/5.0";
	String cbillno1=null;
	private List<String> cookies;
    private HttpURLConnection conn;
	String cname1=null;
	Date d2=null;
	int c41,c51,c61,c71,c81;
	String ct41,ct51,ct61,ct71,ct81;String cst[]={"Unassigned","Bohra","Muslim","Sikh","Hindu","Christian"};
	String id1,id2,id3,id4,id5;
	String prec2=null;
	public billing(String s2,Date d1,String bllno,String bname,int c4,int c5,int c6,int c7,int c8,String ct4,String ct5,String ct6,String ct7,String ct8,String ct9,String ct10,String ct11,String ct12,String ct13,Connection f,String mbno,String Prescription,int casteindex,int joinwithindex) {
		// TODO Auto-generated constructor stub
		/*try {
			d.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		super("Bill Entry");
		d=f;
		prec2=Prescription;
		t18=new JComboBox(cst);
		int size=0;
		//t7=new JComboBox(cst);
		try
		{
			String sql="Select count(*) as count from pdet";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				if(rs.getString("count") != null)
					size = Integer.parseInt(rs.getString("count"));
				size++;
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		
		String[] arb=new String[size];
		
		arb[0]="null";
		t19.setText("0");
		int i=1;
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
		        //this.getRootPane().addComponentListener()
		        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			            KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "yes1"); //$NON-NLS-1$
			        getRootPane().getActionMap().put("yes1", new AbstractAction(){ //$NON-NLS-1$
						@Override
						public void actionPerformed(ActionEvent arg0) {
						yes1();
						}
			        });
			        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				            KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "yes2"); //$NON-NLS-1$
				        getRootPane().getActionMap().put("yes2", new AbstractAction(){ //$NON-NLS-1$
							@Override
							public void actionPerformed(ActionEvent arg0) {
							yes2();
							}
				        });
				        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
					            KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "yes3"); //$NON-NLS-1$
					        getRootPane().getActionMap().put("yes3", new AbstractAction(){ //$NON-NLS-1$
								@Override
								public void actionPerformed(ActionEvent arg0) {
								yes3();
								}
					        });
					        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
						            KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), "yes4"); //$NON-NLS-1$
						        getRootPane().getActionMap().put("yes4", new AbstractAction(){ //$NON-NLS-1$
									@Override
									public void actionPerformed(ActionEvent arg0) {
									yes4();
									}
						        });
						        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
							            KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "yes5"); //$NON-NLS-1$
							        getRootPane().getActionMap().put("yes5", new AbstractAction(){ //$NON-NLS-1$
										@Override
										public void actionPerformed(ActionEvent arg0) {
										yes5();
										}
							        });
			        
		        
		try
		{
			String sql="Select addr,name from pdet order by name asc";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				String us = rs.getString("addr");
				arb[i]=us;
				arb[i]=arb[i]+" "+rs.getString("name");
				i++;
			}
			
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		
		t17=new JComboBox(arb);
		//t17.setSelectedIndex(0);
		if(ct4.equals("null")&&ct5.equals("null")&&ct6.equals("null")&&ct7.equals("null")&&ct8.equals("null"))
		{
			try
			{
				String sql="SAVEPOINT beforebill";
				//System.out.println(sql);
				stm=d.createStatement();
				stm.executeUpdate(sql);
				//System.out.println("sql");
				
			}
			catch(SQLException fe)
			{
				JOptionPane.showMessageDialog(null,"Savepoint Failed");
				//fe.printStackTrace();
			}
		}
		t16.setText(mbno);
		t17.setSelectedIndex(joinwithindex);t18.setSelectedIndex(casteindex);
		c41=c4;
		c51=c5;
		c61=c6;
		c71=c7;
		c81=c8;
		ct41=ct4;
		ct51=ct5;
		ct61=ct6;
		ct71=ct7;
		ct81=ct8;
		id1=ct9;
		id2=ct10;
		id3=ct11;
		id4=ct12;
		id5=ct13;
		
		cbillno1=bllno;
		cname1=bname;
		d2=d1;
		p1.setLayout(null);
		user=s2;
		if(cbillno1.equals("null"))
		{
			int ne=0;
			try
			{
				 
				//d=k.getDBConnection();
				
				String sql="Select max(BILLNO) as count from billentry";
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
			t2.setText(Integer.toString(ne));
		}
		else 
		t2.setText(cbillno1);
		t3.setText(cname1);
		t4=new JComboBox(ar);
		t5=new JComboBox(ar);
		t6=new JComboBox(ar);
		t7=new JComboBox(ar);
		t8=new JComboBox(ar);
		t41.setText(ct4);q41.setText(id1);
		t51.setText(ct5);q51.setText(id2);
		t61.setText(ct6);q61.setText(id3);
		t71.setText(ct7);q71.setText(id4);
		t81.setText(ct8);q81.setText(id5);
		FocusListener fo= new FocusAdapter() {
			  public void focusGained(FocusEvent fEvt) {
				    JTextField tField = (JTextField)fEvt.getSource();
				    tField.selectAll();
				  }
				};
		t2.addFocusListener(fo);
		t3.addFocusListener(fo);
		t19.addFocusListener(fo);
		
		t16.addFocusListener(fo);
		
		//t2.setFocusable(isFocusable());
		//tf3=new JComboBox(ar);
		l0.setText("Welcome "+s2);
		if(d1==null)
		{
			t1.setDate(Calendar.getInstance().getTime());
			t1.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));
		}
		else
		t1.setDate(d1);
		
		t4.setSelectedIndex(c4);
		t5.setSelectedIndex(c5);
		t6.setSelectedIndex(c6);
		t7.setSelectedIndex(c7);
		t8.setSelectedIndex(c8);
		t1.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));
		l0.setBounds(1100, 20, 120, 30);
		this.addWindowListener( new WindowAdapter() {
		    public void windowOpened( WindowEvent e ){
		       // in.requestFocus();
		    	if(cname1.equals("null")){
			        getRootPane().setFocusable(true);
			        getRootPane().requestFocus();
		    	}
			        else if(ct51.equals("null"))
			        {
			        	//t5.setFocusable(true);
			        	//System.out.println("in 555");
			        	//t5.setFocusCycleRoot(true);
			        	t5.requestFocus();
			        }
			        else if(ct61.equals("null"))
			        {
			        	t6.requestFocus();
			        	//System.out.println("in 666");
			        }
			        else if(ct71.equals("null"))
			        {
			        	t7.requestFocus();
			        }
			        else if(ct81.equals("null"))
			        {
			        	t8.requestFocus();
			        }
			        else if(t19.equals("0"))
			        {
			        	t19.requestFocus();
			        }
		    }
		});
		{
		
		}
		l1.setBounds(20,60,150,40);
		t1.setBounds(200,60,150,40);
		l2.setBounds(900,60,150,40);
		t2.setBounds(1100,60,150,40);
		l3.setBounds(400,60,150,40);
		t3.setBounds(600,60,250,40);
		l18.setBounds(20, 120, 100, 30);t18.setBounds(150, 120, 120, 30);
		l16.setBounds(300, 120, 100, 30);t16.setBounds(450, 120, 120, 30);
		l17.setBounds(600, 120, 100, 30);t17.setBounds(750, 120, 250, 30);
		l9.setBounds(50, 170, 50, 30);p1.add(l18);p1.add(l16);p1.add(l17);p1.add(t16);p1.add(t17);p1.add(t18);
		l10.setBounds(200, 170, 150, 30);
		//b4.setBounds(450, 170, 100, 30);
		l11.setBounds(650, 170, 150, 30);
		l4.setBounds(50, 220, 50, 30);
		t4.setBounds(200, 220, 150, 30);
		b4.setBounds(450, 220, 100, 30);
		t41.setBounds(650, 220, 150, 30);
		q41.setBounds(850, 220, 150, 30);
		l5.setBounds(50, 270, 50, 30);
		t5.setBounds(200, 270, 150, 30);
		b5.setBounds(450, 270, 100, 30);
		t51.setBounds(650, 270, 150, 30);
		q51.setBounds(850, 270, 150, 30);
		l6.setBounds(50, 320, 50, 30);
		t6.setBounds(200, 320, 150, 30);
		b6.setBounds(450, 320, 100, 30);
		t61.setBounds(650, 320, 150, 30);
		q61.setBounds(850, 320, 150, 30);
		l7.setBounds(50, 370, 50, 30);
		t7.setBounds(200, 370, 150, 30);
		b7.setBounds(450, 370, 100, 30);
		t71.setBounds(650, 370, 150, 30);
		q71.setBounds(850, 370, 150, 30);
		l8.setBounds(50, 420, 50, 30);
		t8.setBounds(200, 420, 150, 30);
		b8.setBounds(450, 420, 100, 30);
		t81.setBounds(650, 420, 150, 30);
		q81.setBounds(850, 420, 150, 30);
		l19.setBounds(100, 480, 100, 30);
		t19.setBounds(250, 480, 100, 30);
		l12.setBounds(500, 480, 100, 30);
		l14.setBounds(700, 480, 100, 30);
		l13.setBounds(500, 530, 100, 30);
		l15.setBounds(700, 530, 100, 30);
		b9.setBounds(950, 490, 150, 30);
		b1.setBounds(300, 620, 200, 30);
		b2.setBounds(600, 620, 200, 30);
		b3.setBounds(900, 620, 200, 30);p1.add(l19);p1.add(t19);
		q41.setEditable(false);q51.setEditable(false);q61.setEditable(false);q71.setEditable(false);q81.setEditable(false);
		ButtonHandler l=new ButtonHandler();
		b4.addActionListener(l);
		b5.addActionListener(l);
		b6.addActionListener(l);
		b7.addActionListener(l);
		b8.addActionListener(l);
		b9.addActionListener(l);b3.addActionListener(l);b2.addActionListener(l);b1.addActionListener(l);
		p1.add(b9);p1.add(l12);p1.add(l13);p1.add(l14);p1.add(l15);p1.add(q41);p1.add(q51);p1.add(q61);p1.add(q71);p1.add(q81);
		//b4.addActionListener(l);
		//t41.setText(t411);
		//t51.setText(t511);
		//t61.setText(t611);
		//t71.setText(t711);
		//t81.setText(t811);
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
		p1.add(l10);
		p1.add(l11);
		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(t5);
		p1.add(t6);
		p1.add(t7);
		p1.add(t8);
		p1.add(t41);
		p1.add(t51);
		p1.add(t61);
		p1.add(t71);
		p1.add(t81);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		p1.add(b7);
		p1.add(b8);
		getContentPane().add(p1);
		}

	
	public void yes1()
	{
		String btnno=null;
		d2=t1.getDate();
		cname1=t3.getText();
		cbillno1=t2.getText();
		c41=t4.getSelectedIndex();
		c51=t5.getSelectedIndex();
		c61=t6.getSelectedIndex();
		c71=t7.getSelectedIndex();
		c81=t8.getSelectedIndex();
		ct41=t41.getText();
		ct51=t51.getText();
		ct61=t61.getText();
		ct71=t71.getText();
		ct81=t81.getText();
		id1=q41.getText();id2=q51.getText();id3=q61.getText();id4=q71.getText();id5=q81.getText();
		String cmobno=t16.getText();String cpres=prec2;int castei=t18.getSelectedIndex();int joini=t17.getSelectedIndex();
		//String op=null;
		
			if(cmobno.length()==10)
			{
		
			btnno="4";
			if(c41==0)
			{
				pfl pw = new pfl(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				Toolkit tk=Toolkit.getDefaultToolkit();
				pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				pw.setVisible(true);
				setVisible(false);
			}
			if(c41==1||c41==3||c41==2)
			{
				String op=null;
				if(c41==1)
					op="sunglasses";
				if(c41==2)
					op="contact lens";
				if(c41==3)
					op="solution";
				ssun1 pw = new ssun1(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,op,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				Toolkit tk=Toolkit.getDefaultToolkit();
				pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				pw.setVisible(true);
				setVisible(false);
			}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Enter valid 10 digit Mob No");
			}
	}
	
	public void yes2()
	{
		String btnno=null;
		d2=t1.getDate();
		cname1=t3.getText();
		cbillno1=t2.getText();
		c41=t4.getSelectedIndex();
		c51=t5.getSelectedIndex();
		c61=t6.getSelectedIndex();
		c71=t7.getSelectedIndex();
		c81=t8.getSelectedIndex();
		ct41=t41.getText();
		ct51=t51.getText();
		ct61=t61.getText();
		ct71=t71.getText();
		ct81=t81.getText();
		id1=q41.getText();id2=q51.getText();id3=q61.getText();id4=q71.getText();id5=q81.getText();
		String cmobno=t16.getText();String cpres=prec2;int castei=t18.getSelectedIndex();int joini=t17.getSelectedIndex();
		//String op=null;
		
			if(cmobno.length()==10)
			{
		
				btnno="5";
				if(c51==0)
				{
					pfl pw = new pfl(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
				if(c51==1||c51==3||c51==2)
				{
					String op=null;
					if(c51==1)
						op="sunglasses";
					if(c51==2)
						op="contact lens";
					if(c51==3)
						op="solution";
					ssun1 pw = new ssun1(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,op,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
				}
			else
			{
				JOptionPane.showMessageDialog(null,"Enter valid 10 digit Mob No");
			}
	}
	
	public void yes3()
	{
		String btnno=null;
		d2=t1.getDate();
		cname1=t3.getText();
		cbillno1=t2.getText();
		c41=t4.getSelectedIndex();
		c51=t5.getSelectedIndex();
		c61=t6.getSelectedIndex();
		c71=t7.getSelectedIndex();
		c81=t8.getSelectedIndex();
		ct41=t41.getText();
		ct51=t51.getText();
		ct61=t61.getText();
		ct71=t71.getText();
		ct81=t81.getText();
		id1=q41.getText();id2=q51.getText();id3=q61.getText();id4=q71.getText();id5=q81.getText();
		String cmobno=t16.getText();String cpres=prec2;int castei=t18.getSelectedIndex();int joini=t17.getSelectedIndex();
		//String op=null;
		
			if(cmobno.length()==10)
			{
		
				btnno="6";
				if(c61==0)
				{
					pfl pw = new pfl(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
				if(c61==1||c61==3||c61==2)
				{
					String op=null;
					if(c61==1)
						op="sunglasses";
					if(c61==2)
						op="contact lens";
					if(c61==3)
						op="solution";
					ssun1 pw = new ssun1(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,op,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Enter valid 10 digit Mob No");
			}
	}
	
	public void yes4()
	{
		String btnno=null;
		d2=t1.getDate();
		cname1=t3.getText();
		cbillno1=t2.getText();
		c41=t4.getSelectedIndex();
		c51=t5.getSelectedIndex();
		c61=t6.getSelectedIndex();
		c71=t7.getSelectedIndex();
		c81=t8.getSelectedIndex();
		ct41=t41.getText();
		ct51=t51.getText();
		ct61=t61.getText();
		ct71=t71.getText();
		ct81=t81.getText();
		id1=q41.getText();id2=q51.getText();id3=q61.getText();id4=q71.getText();id5=q81.getText();
		String cmobno=t16.getText();String cpres=prec2;int castei=t18.getSelectedIndex();int joini=t17.getSelectedIndex();
		//String op=null;
		
			if(cmobno.length()==10)
			{
		
				btnno="7";
				if(c71==0)
				{
					pfl pw = new pfl(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
				if(c71==1||c71==3||c71==2)
				{
					String op=null;
					if(c71==1)
						op="sunglasses";
					if(c71==2)
						op="contact lens";
					if(c71==3)
						op="solution";
					ssun1 pw = new ssun1(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,op,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}

			}
			else
			{
				JOptionPane.showMessageDialog(null,"Enter valid 10 digit Mob No");
			}
	}
	
	public void yes5()
	{
		String btnno=null;
		d2=t1.getDate();
		cname1=t3.getText();
		cbillno1=t2.getText();
		c41=t4.getSelectedIndex();
		c51=t5.getSelectedIndex();
		c61=t6.getSelectedIndex();
		c71=t7.getSelectedIndex();
		c81=t8.getSelectedIndex();
		ct41=t41.getText();
		ct51=t51.getText();
		ct61=t61.getText();
		ct71=t71.getText();
		ct81=t81.getText();
		id1=q41.getText();id2=q51.getText();id3=q61.getText();id4=q71.getText();id5=q81.getText();
		String cmobno=t16.getText();String cpres=prec2;int castei=t18.getSelectedIndex();int joini=t17.getSelectedIndex();
		//String op=null;
		
			if(cmobno.length()==10)
			{
		
				btnno="8";
				if(c81==0)
				{
					pfl pw = new pfl(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
				if(c81==1||c81==3||c81==2)
				{
					String op=null;
					if(c81==1)
						op="sunglasses";
					if(c81==2)
						op="contact lens";
					if(c81==3)
						op="solution";
					ssun1 pw = new ssun1(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,op,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(null,"Enter valid 10 digit Mob No");
			}
	}
	
	private class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			/*Date d1=null;
			String name=null;
			
			String btnno=null;
			*/
			String btnno=null;
			d2=t1.getDate();
			cname1=t3.getText();
			cbillno1=t2.getText();
			c41=t4.getSelectedIndex();
			c51=t5.getSelectedIndex();
			c61=t6.getSelectedIndex();
			c71=t7.getSelectedIndex();
			c81=t8.getSelectedIndex();
			ct41=t41.getText();
			ct51=t51.getText();
			ct61=t61.getText();
			ct71=t71.getText();
			ct81=t81.getText();
			id1=q41.getText();id2=q51.getText();id3=q61.getText();id4=q71.getText();id5=q81.getText();
			String cmobno=t16.getText();String cpres=prec2;int castei=t18.getSelectedIndex();int joini=t17.getSelectedIndex();
			//String op=null;
			if(e.getSource()==b4||e.getSource()==b5||e.getSource()==b6||e.getSource()==b7||e.getSource()==b8)
			{
				if(cmobno.length()==10)
				{
			if(e.getSource()==b4)
			{
				btnno="4";
				if(c41==0)
				{
					pfl pw = new pfl(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
				if(c41==1||c41==3||c41==2)
				{
					String op=null;
					if(c41==1)
						op="sunglasses";
					if(c41==2)
						op="contact lens";
					if(c41==3)
						op="solution";
					ssun1 pw = new ssun1(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,op,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
				
			}
			if(e.getSource()==b5)
			{
				btnno="5";
				if(c51==0)
				{
					pfl pw = new pfl(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
				if(c51==1||c51==3||c51==2)
				{
					String op=null;
					if(c51==1)
						op="sunglasses";
					if(c51==2)
						op="contact lens";
					if(c51==3)
						op="solution";
					ssun1 pw = new ssun1(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,op,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
			}
			if(e.getSource()==b6)
			{
				btnno="6";
				if(c61==0)
				{
					pfl pw = new pfl(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
				if(c61==1||c61==3||c61==2)
				{
					String op=null;
					if(c61==1)
						op="sunglasses";
					if(c61==2)
						op="contact lens";
					if(c61==3)
						op="solution";
					ssun1 pw = new ssun1(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,op,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
			}
			if(e.getSource()==b7)
			{
				btnno="7";
				if(c71==0)
				{
					pfl pw = new pfl(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
				if(c71==1||c71==3||c71==2)
				{
					String op=null;
					if(c71==1)
						op="sunglasses";
					if(c71==2)
						op="contact lens";
					if(c71==3)
						op="solution";
					ssun1 pw = new ssun1(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,op,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
			}
			if(e.getSource()==b8)
			{
				btnno="8";
				if(c81==0)
				{
					pfl pw = new pfl(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
				if(c81==1||c81==3||c81==2)
				{
					String op=null;
					if(c81==1)
						op="sunglasses";
					if(c81==2)
						op="contact lens";
					if(c81==3)
						op="solution";
					ssun1 pw = new ssun1(user,d2,cbillno1,cname1,c41,c51,c61,c71,c81,ct41,ct51,ct61,ct71,ct81,btnno,op,id1,id2,id3,id4,id5,d,cmobno,cpres,castei, joini);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
			}
			}
				else
				{
					JOptionPane.showMessageDialog(null,"Enter valid 10 digit Mob No");
				}
			/*if(op=="Frame + Lens")
			{
				pfl pw = new pfl(user);
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				Toolkit tk=Toolkit.getDefaultToolkit();
				pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				pw.setVisible(true);
			}
			*/
			//if(op=="Sunglasses")
			//if(op=="Contact Lens")
			
				//setVisible(false);
		}
			if(e.getSource()==b9)
			{
				String s1=t41.getText(),s2=t51.getText(),s3=t61.getText(),s4=t71.getText(),s5=t81.getText();
				int total=0;
				double vat=0;
				//System.out.println(s1+s2+s3+s4+s5);
				if(!s1.equals("null"))
					{
					//System.out.println(s1);
					total+=Integer.parseInt(s1);
					}
				if(!(s2.equals("null")))
					{
					//System.out.println(s2+"in s22222  22");
					total+=Integer.parseInt(s2);
					}
				if(!s3.equals("null"))
					total+=Integer.parseInt(s3);
				if(!s4.equals("null"))
					total+=Integer.parseInt(s4);
				if(!s5.equals("null"))
					total+=Integer.parseInt(s5);
				vat= (total*0.05);
				//String tt=String.valueOf(total)+" in the b9   "+String.valueOf(vat);
				//System.out.println(tt);
				l14.setText(String.valueOf(vat));
				l15.setText(String.valueOf(total));
			}
			if(e.getSource()==b1||e.getSource()==b2)
			{
				
				String r1=t41.getText(),r2=t51.getText(),r3=t61.getText(),r4=t71.getText(),r5=t81.getText();
				int total2=0;
				double vat2=0;
				//System.out.println(s1+s2+s3+s4+s5);
				if(!r1.equals("null"))
					{
					//System.out.println(s1);
					total2+=Integer.parseInt(r1);
					}
				if(!(r2.equals("null")))
					{
					//System.out.println(s2+"in s22222  22");
					total2+=Integer.parseInt(r2);
					}
				if(!r3.equals("null"))
					total2+=Integer.parseInt(r3);
				if(!r4.equals("null"))
					total2+=Integer.parseInt(r4);
				if(!r5.equals("null"))
					total2+=Integer.parseInt(r5);
				vat2= (total2*0.05);
				//String tt=String.valueOf(total2)+" in the b9   "+String.valueOf(vat);
				//System.out.println(tt);
				l14.setText(String.valueOf(vat2));
				l15.setText(String.valueOf(total2));
				//d=k.getDBConnection();
				Date s1=t1.getDate();
				if(s1==null)
					s1=Calendar.getInstance().getTime();
				//System.out.println(s1);
				//System.out.println(s1);
				SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
				String b8=sdf.format(s1);
				String s2=t2.getText();
				String s3=t3.getText();
				String s41=q41.getText();
				String s51=q51.getText();
				String s61=q61.getText();
				String s71=q71.getText();
				String s81=q81.getText();
				String s9=l14.getText();
				String s10=l15.getText();
				String s4=(String)t4.getSelectedItem();
				String s5=(String)t5.getSelectedItem();
				String s6=(String)t6.getSelectedItem();
				String s7=(String)t7.getSelectedItem();
				String s8=(String)t8.getSelectedItem();
				String j41=t41.getText();
				String j51=t51.getText();
				String j61=t61.getText();
				String j71=t71.getText();
				String j81=t81.getText();
				if(s41.equals("null"))
					{
					s4="null";
					}
				if(s51.equals("null"))
					{s5="null";}
				if(s61.equals("null"))
					{s6="null";}
				if(s71.equals("null"))
					{s7="null";}
				if(s81.equals("null"))
					{s8="null";}
				String billv1=t16.getText();
				String billv2=t19.getText();//advance
				int lenght=billv1.length();
				//System.out.println(lenght);
				String billv3=Integer.toString(Integer.parseInt(l15.getText())-Integer.parseInt(t19.getText()));
				//String join=(String) t17.getSelectedItem();
				if(lenght==10)
				{
				try
				{
					String sql="insert into billentry values('"+b8+"',"+s2+",'"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"',"+s9+","+s10+",'"+s41+"','"+s51+"','"+s61+"','"+s71+"','"+s81+"','"+billv1+"',"+billv2+","+billv3+")";
					//System.out.println(sql);
					stm=d.createStatement();
					stm.executeUpdate(sql);
					String hmak=null;
					sql="select max(tranid) as maji from transrec";
					stm=d.createStatement();
					ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						if(rs.getString("maji")!=null)
							{
							hmak=rs.getString("maji");
							hmak=Integer.toString(Integer.parseInt(hmak)+1);
							}
							
						else
							hmak="1";
					}
					sql="insert into transrec values('"+billv1+"',"+s10+","+hmak+",'bill entry no "+s2+"','"+b8+"')";
					//System.out.println(sql);
					stm=d.createStatement();
					stm.executeUpdate(sql);
					if(Integer.parseInt(billv2)>0)
					{	sql="select max(tranid) as maji from transrec";
					stm=d.createStatement();
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						if(rs.getString("maji")!=null)
							{
							hmak=rs.getString("maji");
							hmak=Integer.toString(Integer.parseInt(hmak)+1);
							}
							
						else
							hmak="1";
					}
					sql="insert into transrec values('"+billv1+"',"+billv2+","+hmak+",'Advance bill no "+s2+"','"+b8+"')";
					//System.out.println(sql);
					stm=d.createStatement();
					stm.executeUpdate(sql);
				}
					//System.out.println("sql");
					int flagii=0;
					sql="Select addr from pdet";
					stm=d.createStatement();
					 rs=stm.executeQuery(sql);
					while(rs.next())
					{
						if(rs.getString("addr") != null)
						{
							if(rs.getString("addr").equals(billv1))
							{
								flagii=1;
								break;
							}
						}
						
					}
					String jno=(String) t17.getSelectedItem();
					if(flagii==1)//mil gaya update entry
					{
						if(!prec2.equals("null"))
						{
							sql="update pdet set prescri='"+prec2+"',dou='"+b8+"',dateoflastsms='"+b8+"' where addr='"+billv1+"'";
						}
						/*else
						{
							sql="update pdet set dateoflastsms='"+b8+"' where addr='"+billv1+"'";
						}*/
						stm=d.createStatement();
						stm.executeUpdate(sql);
						
						if(!jno.equals("null"))
						{
							sql="update pdet set stat='j' where addr='"+billv1+"'";
							stm=d.createStatement();
							stm.executeUpdate(sql);
							sql="update pdet set stat='j' where addr='"+jno+"'";
							stm=d.createStatement();
							stm.executeUpdate(sql);
							
							int glam1=0,glam2=0;
							sql="select * from jointacc where (mob1='"+billv1+"' or mob2='"+billv1+"' or mob3='"+billv1+"' or mob4='"+billv1+"' or mob5='"+billv1+"')";
							String jointac1=null,jointac2=null;
							stm=d.createStatement();
							rs=stm.executeQuery(sql);
							
							while(rs.next())
							{
								if(rs.getString("mob1") != null)
								{
									glam1=1;
									if(glam1==1)
									{
										jointac1=rs.getString("jacid");
										break;
									}
								}
								
							}
							
							sql="select * from jointacc where (mob1='"+jno+"' or mob2='"+jno+"' or mob3='"+jno+"' or mob4='"+jno+"' or mob5='"+jno+"')";
							stm=d.createStatement();
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								if(rs.getString("mob1") != null)
								{
									glam2=1;
									if(glam2==1)
									{
										jointac2=rs.getString("jacid");
										break;
									}
								}
								
							}
							if(glam1+glam2==2)
							{
								if(jointac1.equals(jointac2))
								{
									String baj=null;
									sql="select balance from pdet where addr='"+billv1+"'";
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										baj=rs.getString("balance");
									}
									baj=Integer.toString(Integer.parseInt(baj)+Integer.parseInt(billv3));
									sql="select * from jointacc where jacid="+jointac1;
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									String h1=null,h2=null,h3=null,h4=null,h5=null;
									
									while(rs.next())
									{
										h1=rs.getString("mob1");
										h2=rs.getString("mob2");
										h3=rs.getString("mob3");
										h4=rs.getString("mob4");
										h5=rs.getString("mob5");
									}
									if(h1!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h1+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h2!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h2+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h3!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h3+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h4!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h4+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h5!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h5+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
								}
								else
								{
									String balone=null,baj=null;
									sql="select balance from pdet where addr='"+billv1+"'";
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										baj=rs.getString("balance");
									}
									sql="select balance from pdet where addr='"+jno+"'";
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										balone=rs.getString("balance");
									}
									baj=Integer.toString(Integer.parseInt(baj)+Integer.parseInt(balone)+Integer.parseInt(billv3));
									String ari[]={null,null,null,null,null};
									String h1=null,h2=null,h3=null,h4=null,h5=null;
									sql="select * from jointacc where jacid="+jointac1;
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										h1=rs.getString("mob1");
										h2=rs.getString("mob2");
										h3=rs.getString("mob3");
										h4=rs.getString("mob4");
										h5=rs.getString("mob5");
									}
									int i=0;
									if(h1!=null)
									{
										ari[i++]=h1;
										sql="update pdet set balance="+baj+" where addr='"+h1+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h2!=null)
									{
										ari[i++]=h2;
										sql="update pdet set balance="+baj+" where addr='"+h2+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h3!=null)
									{
										ari[i++]=h3;
										sql="update pdet set balance="+baj+" where addr='"+h3+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h4!=null)
									{
										ari[i++]=h4;
										sql="update pdet set balance="+baj+" where addr='"+h4+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h5!=null)
									{
										ari[i++]=h5;
										sql="update pdet set balance="+baj+" where addr='"+h5+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									sql="select * from jointacc where jacid="+jointac2;
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										h1=rs.getString("mob1");
										h2=rs.getString("mob2");
										h3=rs.getString("mob3");
										h4=rs.getString("mob4");
										h5=rs.getString("mob5");
									}
									//int i=0;
									if(h1!=null)
									{
										ari[i++]=h1;
										sql="update pdet set balance="+baj+" where addr='"+h1+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h2!=null)
									{
										ari[i++]=h2;
										sql="update pdet set balance="+baj+" where addr='"+h2+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h3!=null)
									{
										ari[i++]=h3;
										sql="update pdet set balance="+baj+" where addr='"+h3+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h4!=null)
									{
										ari[i++]=h4;
										sql="update pdet set balance="+baj+" where addr='"+h4+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h5!=null)
									{
										ari[i++]=h5;
										sql="update pdet set balance="+baj+" where addr='"+h5+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									String maki=null;
									sql="select max(jacid) as maji from jointacc";
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										if(rs.getString("maji")!=null)
											{
											maki=rs.getString("maji");
											maki=Integer.toString(Integer.parseInt(maki)+1);
											}
											
										else
											maki="1";
									}
									//System.out.println("im getting ");
									//System.out.println(ari[0]+ari[1]+ari[2]+ari[3]+ari[4]+maki);
									sql="insert into jointacc values(";
									if(ari[0]!=null)
									sql=sql+"'"+ari[0]+"',";
									else
										sql=sql+"null,";
									if(ari[1]!=null)
										sql=sql+"'"+ari[1]+"',";
										else
											sql=sql+"null,";
									if(ari[2]!=null)
										sql=sql+"'"+ari[2]+"',";
										else
											sql=sql+"null,";
									if(ari[3]!=null)
										sql=sql+"'"+ari[3]+"',";
										else
											sql=sql+"null,";
									if(ari[4]!=null)
										sql=sql+"'"+ari[4]+"',";
										else
											sql=sql+"null,";
									sql=sql+maki+")";
									//+ari[1]+"','"+ari[2]+"','"+ari[3]+"','"+ari[4]+"',"+maki+")";
									stm=d.createStatement();
									stm.executeUpdate(sql);
									sql="delete from jointacc where jacid="+jointac1;
									stm=d.createStatement();
									stm.executeUpdate(sql);
									sql="delete from jointacc where jacid="+jointac2;
									stm=d.createStatement();
									stm.executeUpdate(sql);
									
								}
							}
							else if(glam1+glam2==1)
							{
								if(glam1==1)
								{
									String balone=null,baj=null;
									sql="select balance from pdet where addr='"+billv1+"'";
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										baj=rs.getString("balance");
									}
									sql="select balance from pdet where addr='"+jno+"'";
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										balone=rs.getString("balance");
									}
									baj=Integer.toString(Integer.parseInt(baj)+Integer.parseInt(balone)+Integer.parseInt(billv3));
									String h1=null,h2=null,h3=null,h4=null,h5=null;
									sql="select * from jointacc where jacid="+jointac1;
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										h1=rs.getString("mob1");
										h2=rs.getString("mob2");
										h3=rs.getString("mob3");
										h4=rs.getString("mob4");
										h5=rs.getString("mob5");
									}
									if(h3==null)
									{
										sql="update jointacc set mob3='"+jno+"' where jacid="+jointac1;
									}
									else if(h4==null)
									{
										sql="update jointacc set mob4='"+jno+"' where jacid="+jointac1;
									}
									else if(h5==null)
									{
										sql="update jointacc set mob5='"+jno+"' where jacid="+jointac1;
									}
									stm=d.createStatement();
									stm.executeUpdate(sql);
									sql="select * from jointacc where jacid="+jointac1;
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										h1=rs.getString("mob1");
										h2=rs.getString("mob2");
										h3=rs.getString("mob3");
										h4=rs.getString("mob4");
										h5=rs.getString("mob5");
									}
									if(h1!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h1+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h2!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h2+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h3!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h3+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h4!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h4+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h5!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h5+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
								}
								else
								{
									String balone=null,baj=null;
									sql="select balance from pdet where addr='"+billv1+"'";
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										baj=rs.getString("balance");
									}
									sql="select balance from pdet where addr='"+jno+"'";
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										balone=rs.getString("balance");
									}
									baj=Integer.toString(Integer.parseInt(baj)+Integer.parseInt(balone)+Integer.parseInt(billv3));
									String h1=null,h2=null,h3=null,h4=null,h5=null;
									sql="select * from jointacc where jacid="+jointac2;
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										h1=rs.getString("mob1");
										h2=rs.getString("mob2");
										h3=rs.getString("mob3");
										h4=rs.getString("mob4");
										h5=rs.getString("mob5");
									}
									if(h3==null)
									{
										sql="update jointacc set mob3='"+billv1+"' where jacid="+jointac2;
									}
									else if(h4==null)
									{
										sql="update jointacc set mob4='"+billv1+"' where jacid="+jointac2;
									}
									else if(h5==null)
									{
										sql="update jointacc set mob5='"+billv1+"' where jacid="+jointac2;
									}
									stm=d.createStatement();
									stm.executeUpdate(sql);
									sql="select * from jointacc where jacid="+jointac1;
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										h1=rs.getString("mob1");
										h2=rs.getString("mob2");
										h3=rs.getString("mob3");
										h4=rs.getString("mob4");
										h5=rs.getString("mob5");
									}
									if(h1!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h1+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h2!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h2+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h3!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h3+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h4!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h4+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h5!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h5+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
								}
							}
							else if(glam1+glam2==0)
							{
								String ba1=null,ba2=null;
								sql="select balance from pdet where addr='"+billv1+"'";
								stm=d.createStatement();
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									ba1=rs.getString("balance");
								}
								sql="select balance from pdet where addr='"+jno+"'";
								stm=d.createStatement();
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									ba2=rs.getString("balance");
								}
								ba1=Integer.toString(Integer.parseInt(ba1)+Integer.parseInt(ba2)+Integer.parseInt(billv3));
								String mid=null;
								sql="select max(jacid) as maji from jointacc";
								stm=d.createStatement();
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									if(rs.getString("maji")!=null)
										mid=rs.getString("maji");
									else
										mid="1";
								}
								sql="insert into jointacc values('"+billv1+"','"+jno+"',null,null,null,"+mid+")";
								stm=d.createStatement();
								stm.executeUpdate(sql);
								sql="update pdet set balance="+ba1+" where addr='"+billv1+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
								sql="update pdet set balance="+ba1+" where addr='"+jno+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
							}
							
							/*sql="select * from jointacc where (mob1='"+billv1+"' or mob2='"+billv1+"' or mob3='"+billv1+"' or mob4='"+billv1+"' or mob5='"+billv1+"')";
							stm=d.createStatement();
							rs=stm.executeQuery(sql);
							int clad=0;String clad1=null;
							while(rs.next())
							{
								if(rs.getString("mob1") != null)
								{
									clad=1;
									if(clad==1)
									{
										clad1=rs.getString("jacid");
										break;
									}
								}
								
							}
							if(clad==1){
							sql="select * from jointacc where jacid="+clad1;
							stm=d.createStatement();
							rs=stm.executeQuery(sql);
							String m1=null,m2=null,m3=null,m4=null,m5=null;
							while(rs.next())
							{
								m1=rs.getString("mob1");
								m2=rs.getString("mob2");
								m3=rs.getString("mob3");
								m4=rs.getString("mob4");
								m5=rs.getString("mob5");
							}
							if(m1.equals(jno)||m2.equals(jno)||m3.equals(jno)||m4.equals(jno)||m5.equals(jno))
							{
							sql="select balance from pdet where addr='"+billv1+"'";
							stm=d.createStatement();
							rs=stm.executeQuery(sql);
							String cbal=null;
							while(rs.next())
							{
								cbal=rs.getString("balance");
							}
							cbal=Integer.toString(Integer.parseInt(cbal)+Integer.parseInt(billv3));
							sql="Update pdet set balance="+cbal+" where addr='"+billv1+"'";
							stm=d.createStatement();
							stm.executeUpdate(sql);
							if(m1!=null)
							{
								sql="Update pdet set balance="+cbal+" where addr='"+m1+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
							}
							if(m2!=null)
							{
								sql="Update pdet set balance="+cbal+" where addr='"+m2+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
							}
							if(m3!=null)
							{
								sql="Update pdet set balance="+cbal+" where addr='"+m3+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
							}
							if(m4!=null)
							{
								sql="Update pdet set balance="+cbal+" where addr='"+m4+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
							}
							if(m5!=null)
							{
								sql="Update pdet set balance="+cbal+" where addr='"+m5+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
							}
							}
							else
							{
								
							}
						}
							else
							{
								sql="Select balance from pdet where addr='"+jno+"'";
								stm=d.createStatement();
								rs=stm.executeQuery(sql);
								String eea=null;
								while(rs.next())
								{
									eea=rs.getString("balance");
								}
								eea=Integer.toString(Integer.parseInt(eea)+Integer.parseInt(billv3));
								sql="Update pdet set balance="+eea+" where addr='"+jno+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
								String mee=null;
								sql="select max(jacid) as maji from jointacc";
								stm=d.createStatement();
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									if(rs.getString("maji")!=null)
										mee=rs.getString("maji");
									else
										mee="1";
								}
								sql="insert into jointacc values('"+billv1+"','"+jno+"',null,null,null,"+mee+")";
								stm=d.createStatement();
								stm.executeUpdate(sql);
								sql="update pdet set balance ="+eea+" where addr='"+billv1+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
							}*/
						}
						else
						{
							sql="select * from jointacc where (mob1='"+billv1+"' or mob2='"+billv1+"' or mob3='"+billv1+"' or mob4='"+billv1+"' or mob5='"+billv1+"')";
							stm=d.createStatement();
							rs=stm.executeQuery(sql);
							int clapp=0;String clapp1=null;
							while(rs.next())
							{
								if(rs.getString("mob1") != null)
								{
									clapp=1;
									if(clapp==1)
									{
										clapp1=rs.getString("jacid");
										break;
									}
								}
								
							}
							if(clapp==1)//milla jointacc add one more mobno to it
							{
								sql="select * from jointacc where jacid="+clapp1;
								stm=d.createStatement();
								rs=stm.executeQuery(sql);
								String kj1=null,kj2=null,kj3=null,kj4=null,kj5=null;
								while(rs.next())
								{
									kj1=rs.getString("mob1");
									kj2=rs.getString("mob2");
									kj3=rs.getString("mob3");
									kj4=rs.getString("mob4");
									kj5=rs.getString("mob5");
									   
								}
								String bvg=null;
								sql="select balance from pdet where addr='"+billv1+"'";
								stm=d.createStatement();
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									bvg=rs.getString("balance");
								}
								bvg=Integer.toString(Integer.parseInt(bvg)+Integer.parseInt(billv3));
								if(kj1!=null)
								{
									sql="Update pdet set balance="+bvg+" where addr='"+kj1+"'";
									stm=d.createStatement();
									stm.executeUpdate(sql);
								}
								if(kj2!=null)
								{
									sql="Update pdet set balance="+bvg+" where addr='"+kj2+"'";
									stm=d.createStatement();
									stm.executeUpdate(sql);
								}
								if(kj3!=null)
								{
									sql="Update pdet set balance="+bvg+" where addr='"+kj3+"'";
									stm=d.createStatement();
									stm.executeUpdate(sql);
								}
								if(kj4!=null)
								{
									sql="Update pdet set balance="+bvg+" where addr='"+kj4+"'";
									stm=d.createStatement();
									stm.executeUpdate(sql);
								}
								if(kj5!=null)
								{
									sql="Update pdet set balance="+bvg+" where addr='"+kj5+"'";
									stm=d.createStatement();
									stm.executeUpdate(sql);
								}
							}
							else
							{
								String bvg=null;
								sql="select balance from pdet where addr='"+billv1+"'";
								stm=d.createStatement();
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									bvg=rs.getString("balance");
								}
								bvg=Integer.toString(Integer.parseInt(bvg)+Integer.parseInt(billv3));
								
								sql="update pdet set balance="+bvg+" where addr='"+billv1+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
								
							}
						}
						
					}
					else//nahi mila make new entry
					{
						String mcid=null;
						String casti=(String) t18.getSelectedItem();
						sql="select max(cid) as maxi from pdet";
						stm=d.createStatement();
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							if(rs.getString("maxi") !=null)
							{
								mcid=rs.getString("maxi");
								mcid=Integer.toString(Integer.parseInt(mcid)+1);
							}
							else 
								mcid="1";
						}
						 
						if(!jno.equals("null"))
						{
							int flagg=1;String jointid=null;
							try
							{
								
								String existbal=null;
								sql="Select balance from pdet where addr='"+jno+"'";
							    stm=d.createStatement();
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									if(rs.getString("balance") != null)
									existbal = rs.getString("balance");
								}
								
								sql="select * from jointacc";
								stm=d.createStatement();
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									if(!rs.getString("mob1").equals("null"))
										{
										if(jno.equals(rs.getString("mob1")))
												{
													flagg=0;
												}
										}
									if(!rs.getString("mob2").equals("null"))
									{
									if(jno.equals(rs.getString("mob2")))
											{
												flagg=0;
											}
									}if(rs.getString("mob3")!=null)
									{
									if(jno.equals(rs.getString("mob3")))
											{
												flagg=0;
											}
									}if(rs.getString("mob4")!=null)
									{
									if(jno.equals(rs.getString("mob4")))
											{
												flagg=0;
											}
									}if(rs.getString("mob5")!=null)
									{
									if(jno.equals(rs.getString("mob5")))
											{
												flagg=0;
											}
									}
									if(flagg==0)
									{
										jointid=rs.getString("jacid");
										break;
									}
										}
								if(flagg==1)//nahi mila
								{
									//String maxid="null";
									//System.out.println("No Joint a/c");
									sql="select max(jacid) as mak from jointacc";
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										if(rs.getString("mak")!=null)
										{
											jointid=rs.getString("mak");
											jointid=Integer.toString(Integer.parseInt(jointid)+1);
										}
										else
											jointid="1";
									}
									
									sql="update pdet set stat='j' where addr='"+jno+"'";
									stm=d.createStatement();
									stm.executeUpdate(sql);
									sql="insert into jointacc values('"+jno+"','"+billv1+"',null,null,null,"+jointid+")";
									stm=d.createStatement();
									stm.executeUpdate(sql);
								}
								else//mil gaya
								{
									sql="select * from jointacc where jacid="+jointid;
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										if(rs.getString("mob3")==null)
										{
											sql="update jointacc set mob3='"+billv1+"' where jacid="+jointid;
										}else if(rs.getString("mob4")==null)
										{
											sql="update jointacc set mob4='"+billv1+"' where jacid="+jointid;
										}else if(rs.getString("mob5")==null)
										{
											sql="update jointacc set mob5='"+billv1+"' where jacid="+jointid;
										}
									
											}
									stm=d.createStatement();
									stm.executeUpdate(sql);
								}
							sql="select * from jointacc where jacid="+jointid;
							stm=d.createStatement();
							rs=stm.executeQuery(sql);
							String k1=null,k2=null,k3=null,k4=null,k5=null;
							while(rs.next())
							{
								k1=rs.getString("mob1");
								k2=rs.getString("mob2");
								k3=rs.getString("mob3");
								k4=rs.getString("mob4");
								k5=rs.getString("mob5");
							}
							
							billv3=Integer.toString(Integer.parseInt(existbal)+Integer.parseInt(billv3));
							sql="insert into pdet values("+mcid+",'"+s3+"','"+billv1+"','"+prec2+"','"+jno+"','"+b8+"','"+b8+"','"+casti+"',"+billv3+",'j')";
							 stm=d.createStatement();
							 stm.executeUpdate(sql);
							 if(k1!=null)
								{
									sql="Update pdet set balance ="+billv3+"where addr='"+k1+"'";
									stm=d.createStatement();
									stm.executeUpdate(sql);
								}
							 if(k2!=null)
								{
									sql="Update pdet set balance ="+billv3+"where addr='"+k2+"'";
									stm=d.createStatement();
									 stm.executeUpdate(sql);
								}
							 if(k3!=null)
								{
									sql="Update pdet set balance ="+billv3+"where addr='"+k3+"'";
									stm=d.createStatement();
									 stm.executeUpdate(sql);
								}
							 if(k4!=null)
								{
									sql="Update pdet set balance ="+billv3+"where addr='"+k4+"'";
									stm=d.createStatement();
									 stm.executeUpdate(sql);
								}
							 if(k5!=null)
								{
									sql="Update pdet set balance ="+billv3+"where addr='"+k5+"'";
									stm=d.createStatement();
									 stm.executeUpdate(sql);
								}
							}
							catch(SQLException fe)
							{
								fe.printStackTrace();
							}
							
							
						}
						 else
						 {
							//System.out.println("With no join");
							 sql="insert into pdet values("+mcid+",'"+s3+"','"+billv1+"','"+prec2+"','"+jno+"','"+b8+"','"+b8+"','"+casti+"',"+billv3+",'n'"+")";
							 stm=d.createStatement();
							 stm.executeUpdate(sql);
						 }
						 
					}
					sql="Commit";
					stm=d.createStatement();
					stm.executeUpdate(sql);
					//CookieHandler.setDefault(new CookieManager());
					 
					// 1. Send a "GET" request, so that you can extract the form's data.
					
					
					String message="Dear "+t3.getText()+",your bill no is "+t2.getText()+" Amount: "+s10+" Outstanding:"+billv3+" Advance :"+billv2+".Thanks for visiting City Opticals";
					//System.out.println(message.length());
					//message="Hello, this is a test message.";
					message=message.replaceAll(" ", "%20");
					//System.out.println(message);
					doit pw = new doit(user);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
					if(e.getSource()==b2)
					{
						printingtemplatebill example2 = new printingtemplatebill(b8,s2,s3,s4,j41,s5,j51,s6,j61,s7,j71,s8,j81,billv2,s10);	
						if(!prec2.equals("null")){
						
						printImage = new javax.swing.ImageIcon(prec2);
					    PrinterJob printJob = PrinterJob.getPrinterJob();
					    //System.out.println(t1+t2+t3+t4+t5+t6);
					    //--- Create a new book to add pages to
					    Book book = new Book();

					    //--- Add the cover page using the default page format for this print
					    // job
					    book.append(new MyPrintable(), printJob.defaultPage());

					    //--- Add the document page using a landscape page format
					    PageFormat documentPageFormat = new PageFormat();
					    documentPageFormat.setOrientation(PageFormat.LANDSCAPE);
					   // book.append(new Document(), documentPageFormat);

					    //--- Tell the printJob to use the book as the pageable object
					    printJob.setPageable(book);

					    //--- Show the print dialog box. If the user click the
					    //--- print button we then proceed to print else we cancel
					    //--- the process.
					    if (printJob.printDialog()) {
					      try {
					        printJob.print();
					      } catch (Exception PrintException) {
					        PrintException.printStackTrace();
					      }
					    }
					}
					}
					
					CookieHandler.setDefault(new CookieManager());
					boolean internet=isInternetReachable();
					String urlbal="http://login.smsgatewayhub.com/smsapi/CheckBalance.aspx?user=9406682786&password=888496&gwid=0";
					
					if(internet){
					
						String pagebal = GetPageContent(urlbal);
						int len=pagebal.length();
						pagebal=pagebal.substring(8,len );
						//System.out.println(pagebal);
						sql="Select stat from pdet where addr='"+billv1+"'";
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
						sql="select * from jointacc where (mob1='"+billv1+"' or mob2='"+billv1+"' or mob3='"+billv1+"' or mob4='"+billv1+"' or mob5='"+billv1+"')";
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
							page = GetPageContent(url);
						}
						if(w2!=null){
							url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=9406682786&pwd=888496&to="+w2+"&sid=WEBSMS&msg="+message+"&fl=0";
							page = GetPageContent(url);
						}
						if(w3!=null){
							url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=9406682786&pwd=888496&to="+w3+"&sid=WEBSMS&msg="+message+"&fl=0";
							page = GetPageContent(url);
						}
						if(w4!=null){
							url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=9406682786&pwd=888496&to="+w4+"&sid=WEBSMS&msg="+message+"&fl=0";
							page = GetPageContent(url);
						}
						if(w5!=null){
							url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=9406682786&pwd=888496&to="+w5+"&sid=WEBSMS&msg="+message+"&fl=0";
							page = GetPageContent(url);
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
						//message=message.replaceAll(" ", "%20");
						
						//System.out.println("In n type stat");
						if(Integer.parseInt(pagebal)>=1)
						{
							String url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=9406682786&pwd=888496&to="+billv1+"&sid=WEBSMS&msg="+message+"&fl=0";
						//HttpUrlConnectionExample http = new HttpUrlConnectionExample();
						
						String page = GetPageContent(url);
					}
						else
						{
							int dialogButton = JOptionPane.YES_NO_OPTION;
							int dialogResult = JOptionPane.showConfirmDialog (null, "Your balance is not sufficient to send sms .\nDo you want to store it to automatically send it afterwards ?","Warning",dialogButton);
							String mba="1";
							if(dialogResult == JOptionPane.YES_OPTION)
							{
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
								sql="insert into pendingsms values("+mba+",'"+billv1+"','"+message+"')";
								stm=d.createStatement();
								stm.executeUpdate(sql);
								
							}
						}
					
						
					}
					
					}
					else
					{
						int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog (null, "There is no internet connection at present,so cant send sms at this moment.\nDo you want to store sms details, to automatically send it afterwards when internet connectivity is available?","Warning",dialogButton);
						if(dialogResult == JOptionPane.YES_OPTION)
						{
							//System.out.println("In yes option");
							sql="Select stat from pdet where addr='"+billv1+"'";
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
								sql="select * from jointacc where (mob1='"+billv1+"' or mob2='"+billv1+"' or mob3='"+billv1+"' or mob4='"+billv1+"' or mob5='"+billv1+"')";
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
								sql="insert into pendingsms values("+mba+",'"+billv1+"','"+message+"')";
								stm=d.createStatement();
								stm.executeUpdate(sql);
							}
						}
					}
					sql="Commit";
					stm=d.createStatement();
					stm.executeUpdate(sql);
					

				}
			
				catch(SQLException fe)
				{
					JOptionPane.showMessageDialog(null,"Generate Total");
					//fe.printStackTrace();
				}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Enter a Valid Mobile No");
				}
				//System.out.println("DOneeeeeeeeeeee");
				/*try {
					d.commit();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			}
			
			if(e.getSource()==b3)
			{
				//d=k.getDBConnection();
				/*try
				{
					String sql="SAVEPOINT beforebill";
					//System.out.println(sql);
					stm=d.createStatement();
					stm.executeUpdate(sql);
					//System.out.println("sql");
					
				}
				catch(SQLException fe)
				{
					JOptionPane.showMessageDialog(null,"Savepoint Failed");
					fe.printStackTrace();
				}*/
				try
				{
					String sql="ROLLBACK TO beforebill";
					//System.out.println(sql);
					stm=d.createStatement();
					stm.executeUpdate(sql);
					d.close();
					//System.out.println("sql");
					doit pw = new doit(user);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
				catch(SQLException fe)
				{
					JOptionPane.showMessageDialog(null,"RollBack Failed");
					fe.printStackTrace();
				}
				
			}
		}
		
	}
	void settf4(String to1)
	{
		t41.setText(to1);
	}
	class MyPrintable implements Printable {
		  //ImageIcon printImage = new javax.swing.ImageIcon("a.gif");

		  public int print(Graphics g, PageFormat pf, int pageIndex) {
		    Graphics2D g2d = (Graphics2D) g;
		    g.translate((int) (pf.getImageableX()), (int) (pf.getImageableY()));
		    if (pageIndex == 0) {
		      double pageWidth = pf.getImageableWidth();
		      double pageHeight = pf.getImageableHeight();
		      double imageWidth = printImage.getIconWidth();
		      double imageHeight = printImage.getIconHeight();
		      double scaleX = pageWidth / imageWidth;
		      double scaleY = pageHeight / imageHeight;
		      double scaleFactor = Math.min(scaleX, scaleY);
		      g2d.scale(scaleFactor, scaleFactor);
		      g.drawImage(printImage.getImage(), 0, 0, null);
		      return Printable.PAGE_EXISTS;
		    }
		    return Printable.NO_SUCH_PAGE;
		  }
		}
	
	public String GetPageContent(String url1)  {
		 
		URL obj=null;
		try {
			obj = new URL(url1);
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
		 
	/*
	public boolean isInternetReachable()
	{
		URL obj=null;;
		try {
			obj = new URL("https://www.google.com");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			conn1.disconnect();
			return false;
			//e.printStackTrace();
		}
		try {
			conn1 = (HttpsURLConnection) obj.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			conn1.disconnect();
			return false;
			//e.printStackTrace();
		}
	 
		// default is GET
		try {
			conn1.setRequestMethod("GET");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			conn1.disconnect();
			return false;
			//e.printStackTrace();
		}
	 
		conn1.setUseCaches(false);
	 
		// act like a browser
		conn1.setRequestProperty("User-Agent", USER_AGENT);
		conn1.setRequestProperty("Accept",
		*///	"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		/*conn1.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		if (cookies != null) {
			for (String cookie : this.cookies) {
				conn1.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
			}
		}
		int responseCode=0;
		String inputLine;
		StringBuffer response = new StringBuffer();
		BufferedReader in=null;
		try {
			responseCode = conn1.getResponseCode();
			//System.out.println("\nSending 'GET' request to URL : " + url);
			//System.out.println("Response Code : " + responseCode);
			in = new BufferedReader(new InputStreamReader(conn1.getInputStream()));
			while ((inputLine = in.readLine()) != null) 
				response.append(inputLine);
				
				in.close();
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			conn1.disconnect();
			return false;
			//JOptionPane.showMessageDialog(null,"No Internet Connection");
		}
		
		
		
	 
		// Get the response cookies
		setCookies(conn1.getHeaderFields().get("Set-Cookie"));
		conn1.disconnect();
		return true;
		}
	*/

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
				try
				{
					String sql="ROLLBACK TO beforebill";
					//System.out.println(sql);
					stm=d.createStatement();
					stm.executeUpdate(sql);
					d.close();
					//System.out.println("sql");
					doit pw = new doit(user);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
				catch(SQLException fe)
				{
					JOptionPane.showMessageDialog(null,"RollBack Failed");
					fe.printStackTrace();
				}
				
			}
			
			public void yes()
			{
				String r1=t41.getText(),r2=t51.getText(),r3=t61.getText(),r4=t71.getText(),r5=t81.getText();
				int total2=0;
				double vat2=0;
				
				//System.out.println(s1+s2+s3+s4+s5);
				if(!r1.equals("null"))
					{
					//System.out.println(s1);
					total2+=Integer.parseInt(r1);
					}
				if(!(r2.equals("null")))
					{
					//System.out.println(s2+"in s22222  22");
					total2+=Integer.parseInt(r2);
					}
				if(!r3.equals("null"))
					total2+=Integer.parseInt(r3);
				if(!r4.equals("null"))
					total2+=Integer.parseInt(r4);
				if(!r5.equals("null"))
					total2+=Integer.parseInt(r5);
				vat2= (total2*0.05);
				//String tt=String.valueOf(total2)+" in the b9   "+String.valueOf(vat);
				//System.out.println(tt);
				l14.setText(String.valueOf(vat2));
				l15.setText(String.valueOf(total2));
				//d=k.getDBConnection();
				Date s1=t1.getDate();
				if(s1==null)
					s1=Calendar.getInstance().getTime();
				//System.out.println(s1);
				//System.out.println(s1);
				SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
				String b8=sdf.format(s1);
				String s2=t2.getText();
				String s3=t3.getText();
				String s41=q41.getText();
				String s51=q51.getText();
				String s61=q61.getText();
				String s71=q71.getText();
				String s81=q81.getText();
				String s9=l14.getText();
				String s10=l15.getText();
				String s4=(String)t4.getSelectedItem();
				String s5=(String)t5.getSelectedItem();
				String s6=(String)t6.getSelectedItem();
				String s7=(String)t7.getSelectedItem();
				String s8=(String)t8.getSelectedItem();
				String j41=t41.getText();
				String j51=t51.getText();
				String j61=t61.getText();
				String j71=t71.getText();
				String j81=t81.getText();
				if(s41.equals("null"))
					{
					s4="null";
					}
				if(s51.equals("null"))
					{s5="null";}
				if(s61.equals("null"))
					{s6="null";}
				if(s71.equals("null"))
					{s7="null";}
				if(s81.equals("null"))
					{s8="null";}
				String billv1=t16.getText();
				String billv2=t19.getText();//advance
				int lenght=billv1.length();
				//System.out.println(lenght);
				String billv3=Integer.toString(Integer.parseInt(l15.getText())-Integer.parseInt(t19.getText()));
				//String join=(String) t17.getSelectedItem();
				if(lenght==10)
				{
				try
				{
					String sql="insert into billentry values('"+b8+"',"+s2+",'"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"',"+s9+","+s10+",'"+s41+"','"+s51+"','"+s61+"','"+s71+"','"+s81+"','"+billv1+"',"+billv2+","+billv3+")";
					//System.out.println(sql);
					stm=d.createStatement();
					stm.executeUpdate(sql);
					String hmak=null;
					sql="select max(tranid) as maji from transrec";
					stm=d.createStatement();
					ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						if(rs.getString("maji")!=null)
							{
							hmak=rs.getString("maji");
							hmak=Integer.toString(Integer.parseInt(hmak)+1);
							}
							
						else
							hmak="1";
					}
					sql="insert into transrec values('"+billv1+"',"+s10+","+hmak+",'bill entry no "+s2+"','"+b8+"')";
					//System.out.println(sql);
					stm=d.createStatement();
					stm.executeUpdate(sql);
					if(Integer.parseInt(billv2)>0)
					{	sql="select max(tranid) as maji from transrec";
					stm=d.createStatement();
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						if(rs.getString("maji")!=null)
							{
							hmak=rs.getString("maji");
							hmak=Integer.toString(Integer.parseInt(hmak)+1);
							}
							
						else
							hmak="1";
					}
					sql="insert into transrec values('"+billv1+"',"+billv2+","+hmak+",'Advance bill no "+s2+"','"+b8+"')";
					//System.out.println(sql);
					stm=d.createStatement();
					stm.executeUpdate(sql);
				}
					//System.out.println("sql");
					int flagii=0;
					sql="Select addr from pdet";
					stm=d.createStatement();
					 rs=stm.executeQuery(sql);
					while(rs.next())
					{
						if(rs.getString("addr") != null)
						{
							if(rs.getString("addr").equals(billv1))
							{
								flagii=1;
								break;
							}
						}
						
					}
					String jno=(String) t17.getSelectedItem();
					if(flagii==1)//mil gaya update entry
					{
						if(!prec2.equals("null"))
						{
							sql="update pdet set prescri='"+prec2+"',dou='"+b8+"',dateoflastsms='"+b8+"' where addr='"+billv1+"'";
						}
						/*else
						{
							sql="update pdet set dateoflastsms='"+b8+"' where addr='"+billv1+"'";
						}*/
						stm=d.createStatement();
						stm.executeUpdate(sql);
						
						if(!jno.equals("null"))
						{
							sql="update pdet set stat='j' where addr='"+billv1+"'";
							stm=d.createStatement();
							stm.executeUpdate(sql);
							sql="update pdet set stat='j' where addr='"+jno+"'";
							stm=d.createStatement();
							stm.executeUpdate(sql);
							
							int glam1=0,glam2=0;
							sql="select * from jointacc where (mob1='"+billv1+"' or mob2='"+billv1+"' or mob3='"+billv1+"' or mob4='"+billv1+"' or mob5='"+billv1+"')";
							String jointac1=null,jointac2=null;
							stm=d.createStatement();
							rs=stm.executeQuery(sql);
							
							while(rs.next())
							{
								if(rs.getString("mob1") != null)
								{
									glam1=1;
									if(glam1==1)
									{
										jointac1=rs.getString("jacid");
										break;
									}
								}
								
							}
							
							sql="select * from jointacc where (mob1='"+jno+"' or mob2='"+jno+"' or mob3='"+jno+"' or mob4='"+jno+"' or mob5='"+jno+"')";
							stm=d.createStatement();
							rs=stm.executeQuery(sql);
							while(rs.next())
							{
								if(rs.getString("mob1") != null)
								{
									glam2=1;
									if(glam2==1)
									{
										jointac2=rs.getString("jacid");
										break;
									}
								}
								
							}
							if(glam1+glam2==2)
							{
								if(jointac1.equals(jointac2))
								{
									String baj=null;
									sql="select balance from pdet where addr='"+billv1+"'";
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										baj=rs.getString("balance");
									}
									baj=Integer.toString(Integer.parseInt(baj)+Integer.parseInt(billv3));
									sql="select * from jointacc where jacid="+jointac1;
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									String h1=null,h2=null,h3=null,h4=null,h5=null;
									
									while(rs.next())
									{
										h1=rs.getString("mob1");
										h2=rs.getString("mob2");
										h3=rs.getString("mob3");
										h4=rs.getString("mob4");
										h5=rs.getString("mob5");
									}
									if(h1!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h1+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h2!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h2+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h3!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h3+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h4!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h4+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h5!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h5+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
								}
								else
								{
									String balone=null,baj=null;
									sql="select balance from pdet where addr='"+billv1+"'";
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										baj=rs.getString("balance");
									}
									sql="select balance from pdet where addr='"+jno+"'";
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										balone=rs.getString("balance");
									}
									baj=Integer.toString(Integer.parseInt(baj)+Integer.parseInt(balone)+Integer.parseInt(billv3));
									String ari[]={null,null,null,null,null};
									String h1=null,h2=null,h3=null,h4=null,h5=null;
									sql="select * from jointacc where jacid="+jointac1;
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										h1=rs.getString("mob1");
										h2=rs.getString("mob2");
										h3=rs.getString("mob3");
										h4=rs.getString("mob4");
										h5=rs.getString("mob5");
									}
									int i=0;
									if(h1!=null)
									{
										ari[i++]=h1;
										sql="update pdet set balance="+baj+" where addr='"+h1+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h2!=null)
									{
										ari[i++]=h2;
										sql="update pdet set balance="+baj+" where addr='"+h2+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h3!=null)
									{
										ari[i++]=h3;
										sql="update pdet set balance="+baj+" where addr='"+h3+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h4!=null)
									{
										ari[i++]=h4;
										sql="update pdet set balance="+baj+" where addr='"+h4+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h5!=null)
									{
										ari[i++]=h5;
										sql="update pdet set balance="+baj+" where addr='"+h5+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									sql="select * from jointacc where jacid="+jointac2;
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										h1=rs.getString("mob1");
										h2=rs.getString("mob2");
										h3=rs.getString("mob3");
										h4=rs.getString("mob4");
										h5=rs.getString("mob5");
									}
									//int i=0;
									if(h1!=null)
									{
										ari[i++]=h1;
										sql="update pdet set balance="+baj+" where addr='"+h1+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h2!=null)
									{
										ari[i++]=h2;
										sql="update pdet set balance="+baj+" where addr='"+h2+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h3!=null)
									{
										ari[i++]=h3;
										sql="update pdet set balance="+baj+" where addr='"+h3+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h4!=null)
									{
										ari[i++]=h4;
										sql="update pdet set balance="+baj+" where addr='"+h4+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h5!=null)
									{
										ari[i++]=h5;
										sql="update pdet set balance="+baj+" where addr='"+h5+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									String maki=null;
									sql="select max(jacid) as maji from jointacc";
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										if(rs.getString("maji")!=null)
											{
											maki=rs.getString("maji");
											maki=Integer.toString(Integer.parseInt(maki)+1);
											}
											
										else
											maki="1";
									}
									//System.out.println("im getting ");
									//System.out.println(ari[0]+ari[1]+ari[2]+ari[3]+ari[4]+maki);
									sql="insert into jointacc values(";
									if(ari[0]!=null)
									sql=sql+"'"+ari[0]+"',";
									else
										sql=sql+"null,";
									if(ari[1]!=null)
										sql=sql+"'"+ari[1]+"',";
										else
											sql=sql+"null,";
									if(ari[2]!=null)
										sql=sql+"'"+ari[2]+"',";
										else
											sql=sql+"null,";
									if(ari[3]!=null)
										sql=sql+"'"+ari[3]+"',";
										else
											sql=sql+"null,";
									if(ari[4]!=null)
										sql=sql+"'"+ari[4]+"',";
										else
											sql=sql+"null,";
									sql=sql+maki+")";
									//+ari[1]+"','"+ari[2]+"','"+ari[3]+"','"+ari[4]+"',"+maki+")";
									stm=d.createStatement();
									stm.executeUpdate(sql);
									sql="delete from jointacc where jacid="+jointac1;
									stm=d.createStatement();
									stm.executeUpdate(sql);
									sql="delete from jointacc where jacid="+jointac2;
									stm=d.createStatement();
									stm.executeUpdate(sql);
									
								}
							}
							else if(glam1+glam2==1)
							{
								if(glam1==1)
								{
									String balone=null,baj=null;
									sql="select balance from pdet where addr='"+billv1+"'";
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										baj=rs.getString("balance");
									}
									sql="select balance from pdet where addr='"+jno+"'";
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										balone=rs.getString("balance");
									}
									baj=Integer.toString(Integer.parseInt(baj)+Integer.parseInt(balone)+Integer.parseInt(billv3));
									String h1=null,h2=null,h3=null,h4=null,h5=null;
									sql="select * from jointacc where jacid="+jointac1;
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										h1=rs.getString("mob1");
										h2=rs.getString("mob2");
										h3=rs.getString("mob3");
										h4=rs.getString("mob4");
										h5=rs.getString("mob5");
									}
									if(h3==null)
									{
										sql="update jointacc set mob3='"+jno+"' where jacid="+jointac1;
									}
									else if(h4==null)
									{
										sql="update jointacc set mob4='"+jno+"' where jacid="+jointac1;
									}
									else if(h5==null)
									{
										sql="update jointacc set mob5='"+jno+"' where jacid="+jointac1;
									}
									stm=d.createStatement();
									stm.executeUpdate(sql);
									sql="select * from jointacc where jacid="+jointac1;
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										h1=rs.getString("mob1");
										h2=rs.getString("mob2");
										h3=rs.getString("mob3");
										h4=rs.getString("mob4");
										h5=rs.getString("mob5");
									}
									if(h1!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h1+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h2!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h2+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h3!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h3+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h4!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h4+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h5!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h5+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
								}
								else
								{
									String balone=null,baj=null;
									sql="select balance from pdet where addr='"+billv1+"'";
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										baj=rs.getString("balance");
									}
									sql="select balance from pdet where addr='"+jno+"'";
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										balone=rs.getString("balance");
									}
									baj=Integer.toString(Integer.parseInt(baj)+Integer.parseInt(balone)+Integer.parseInt(billv3));
									String h1=null,h2=null,h3=null,h4=null,h5=null;
									sql="select * from jointacc where jacid="+jointac2;
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										h1=rs.getString("mob1");
										h2=rs.getString("mob2");
										h3=rs.getString("mob3");
										h4=rs.getString("mob4");
										h5=rs.getString("mob5");
									}
									if(h3==null)
									{
										sql="update jointacc set mob3='"+billv1+"' where jacid="+jointac2;
									}
									else if(h4==null)
									{
										sql="update jointacc set mob4='"+billv1+"' where jacid="+jointac2;
									}
									else if(h5==null)
									{
										sql="update jointacc set mob5='"+billv1+"' where jacid="+jointac2;
									}
									stm=d.createStatement();
									stm.executeUpdate(sql);
									sql="select * from jointacc where jacid="+jointac1;
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										h1=rs.getString("mob1");
										h2=rs.getString("mob2");
										h3=rs.getString("mob3");
										h4=rs.getString("mob4");
										h5=rs.getString("mob5");
									}
									if(h1!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h1+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h2!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h2+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h3!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h3+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h4!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h4+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
									if(h5!=null)
									{
										sql="update pdet set balance="+baj+" where addr='"+h5+"'";
										stm=d.createStatement();
										stm.executeUpdate(sql);
									}
								}
							}
							else if(glam1+glam2==0)
							{
								String ba1=null,ba2=null;
								sql="select balance from pdet where addr='"+billv1+"'";
								stm=d.createStatement();
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									ba1=rs.getString("balance");
								}
								sql="select balance from pdet where addr='"+jno+"'";
								stm=d.createStatement();
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									ba2=rs.getString("balance");
								}
								ba1=Integer.toString(Integer.parseInt(ba1)+Integer.parseInt(ba2)+Integer.parseInt(billv3));
								String mid=null;
								sql="select max(jacid) as maji from jointacc";
								stm=d.createStatement();
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									if(rs.getString("maji")!=null)
										mid=rs.getString("maji");
									else
										mid="1";
								}
								sql="insert into jointacc values('"+billv1+"','"+jno+"',null,null,null,"+mid+")";
								stm=d.createStatement();
								stm.executeUpdate(sql);
								sql="update pdet set balance="+ba1+" where addr='"+billv1+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
								sql="update pdet set balance="+ba1+" where addr='"+jno+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
							}
							
							/*sql="select * from jointacc where (mob1='"+billv1+"' or mob2='"+billv1+"' or mob3='"+billv1+"' or mob4='"+billv1+"' or mob5='"+billv1+"')";
							stm=d.createStatement();
							rs=stm.executeQuery(sql);
							int clad=0;String clad1=null;
							while(rs.next())
							{
								if(rs.getString("mob1") != null)
								{
									clad=1;
									if(clad==1)
									{
										clad1=rs.getString("jacid");
										break;
									}
								}
								
							}
							if(clad==1){
							sql="select * from jointacc where jacid="+clad1;
							stm=d.createStatement();
							rs=stm.executeQuery(sql);
							String m1=null,m2=null,m3=null,m4=null,m5=null;
							while(rs.next())
							{
								m1=rs.getString("mob1");
								m2=rs.getString("mob2");
								m3=rs.getString("mob3");
								m4=rs.getString("mob4");
								m5=rs.getString("mob5");
							}
							if(m1.equals(jno)||m2.equals(jno)||m3.equals(jno)||m4.equals(jno)||m5.equals(jno))
							{
							sql="select balance from pdet where addr='"+billv1+"'";
							stm=d.createStatement();
							rs=stm.executeQuery(sql);
							String cbal=null;
							while(rs.next())
							{
								cbal=rs.getString("balance");
							}
							cbal=Integer.toString(Integer.parseInt(cbal)+Integer.parseInt(billv3));
							sql="Update pdet set balance="+cbal+" where addr='"+billv1+"'";
							stm=d.createStatement();
							stm.executeUpdate(sql);
							if(m1!=null)
							{
								sql="Update pdet set balance="+cbal+" where addr='"+m1+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
							}
							if(m2!=null)
							{
								sql="Update pdet set balance="+cbal+" where addr='"+m2+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
							}
							if(m3!=null)
							{
								sql="Update pdet set balance="+cbal+" where addr='"+m3+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
							}
							if(m4!=null)
							{
								sql="Update pdet set balance="+cbal+" where addr='"+m4+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
							}
							if(m5!=null)
							{
								sql="Update pdet set balance="+cbal+" where addr='"+m5+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
							}
							}
							else
							{
								
							}
						}
							else
							{
								sql="Select balance from pdet where addr='"+jno+"'";
								stm=d.createStatement();
								rs=stm.executeQuery(sql);
								String eea=null;
								while(rs.next())
								{
									eea=rs.getString("balance");
								}
								eea=Integer.toString(Integer.parseInt(eea)+Integer.parseInt(billv3));
								sql="Update pdet set balance="+eea+" where addr='"+jno+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
								String mee=null;
								sql="select max(jacid) as maji from jointacc";
								stm=d.createStatement();
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									if(rs.getString("maji")!=null)
										mee=rs.getString("maji");
									else
										mee="1";
								}
								sql="insert into jointacc values('"+billv1+"','"+jno+"',null,null,null,"+mee+")";
								stm=d.createStatement();
								stm.executeUpdate(sql);
								sql="update pdet set balance ="+eea+" where addr='"+billv1+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
							}*/
						}
						else
						{
							sql="select * from jointacc where (mob1='"+billv1+"' or mob2='"+billv1+"' or mob3='"+billv1+"' or mob4='"+billv1+"' or mob5='"+billv1+"')";
							stm=d.createStatement();
							rs=stm.executeQuery(sql);
							int clapp=0;String clapp1=null;
							while(rs.next())
							{
								if(rs.getString("mob1") != null)
								{
									clapp=1;
									if(clapp==1)
									{
										clapp1=rs.getString("jacid");
										break;
									}
								}
								
							}
							if(clapp==1)//milla jointacc add one more mobno to it
							{
								sql="select * from jointacc where jacid="+clapp1;
								stm=d.createStatement();
								rs=stm.executeQuery(sql);
								String kj1=null,kj2=null,kj3=null,kj4=null,kj5=null;
								while(rs.next())
								{
									kj1=rs.getString("mob1");
									kj2=rs.getString("mob2");
									kj3=rs.getString("mob3");
									kj4=rs.getString("mob4");
									kj5=rs.getString("mob5");
									   
								}
								String bvg=null;
								sql="select balance from pdet where addr='"+billv1+"'";
								stm=d.createStatement();
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									bvg=rs.getString("balance");
								}
								bvg=Integer.toString(Integer.parseInt(bvg)+Integer.parseInt(billv3));
								if(kj1!=null)
								{
									sql="Update pdet set balance="+bvg+" where addr='"+kj1+"'";
									stm=d.createStatement();
									stm.executeUpdate(sql);
								}
								if(kj2!=null)
								{
									sql="Update pdet set balance="+bvg+" where addr='"+kj2+"'";
									stm=d.createStatement();
									stm.executeUpdate(sql);
								}
								if(kj3!=null)
								{
									sql="Update pdet set balance="+bvg+" where addr='"+kj3+"'";
									stm=d.createStatement();
									stm.executeUpdate(sql);
								}
								if(kj4!=null)
								{
									sql="Update pdet set balance="+bvg+" where addr='"+kj4+"'";
									stm=d.createStatement();
									stm.executeUpdate(sql);
								}
								if(kj5!=null)
								{
									sql="Update pdet set balance="+bvg+" where addr='"+kj5+"'";
									stm=d.createStatement();
									stm.executeUpdate(sql);
								}
							}
							else
							{
								String bvg=null;
								sql="select balance from pdet where addr='"+billv1+"'";
								stm=d.createStatement();
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									bvg=rs.getString("balance");
								}
								bvg=Integer.toString(Integer.parseInt(bvg)+Integer.parseInt(billv3));
								
								sql="update pdet set balance="+bvg+" where addr='"+billv1+"'";
								stm=d.createStatement();
								stm.executeUpdate(sql);
								
							}
						}
						
					}
					else//nahi mila make new entry
					{
						String mcid=null;
						String casti=(String) t18.getSelectedItem();
						sql="select max(cid) as maxi from pdet";
						stm=d.createStatement();
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							if(rs.getString("maxi") !=null)
							{
								mcid=rs.getString("maxi");
								mcid=Integer.toString(Integer.parseInt(mcid)+1);
							}
							else 
								mcid="1";
						}
						 
						if(!jno.equals("null"))
						{
							int flagg=1;String jointid=null;
							try
							{
								
								String existbal=null;
								sql="Select balance from pdet where addr='"+jno+"'";
							    stm=d.createStatement();
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									if(rs.getString("balance") != null)
									existbal = rs.getString("balance");
								}
								
								sql="select * from jointacc";
								stm=d.createStatement();
								rs=stm.executeQuery(sql);
								while(rs.next())
								{
									if(!rs.getString("mob1").equals("null"))
										{
										if(jno.equals(rs.getString("mob1")))
												{
													flagg=0;
												}
										}
									if(!rs.getString("mob2").equals("null"))
									{
									if(jno.equals(rs.getString("mob2")))
											{
												flagg=0;
											}
									}if(rs.getString("mob3")!=null)
									{
									if(jno.equals(rs.getString("mob3")))
											{
												flagg=0;
											}
									}if(rs.getString("mob4")!=null)
									{
									if(jno.equals(rs.getString("mob4")))
											{
												flagg=0;
											}
									}if(rs.getString("mob5")!=null)
									{
									if(jno.equals(rs.getString("mob5")))
											{
												flagg=0;
											}
									}
									if(flagg==0)
									{
										jointid=rs.getString("jacid");
										break;
									}
										}
								if(flagg==1)//nahi mila
								{
									//String maxid="null";
									System.out.println("No Joint a/c");
									sql="select max(jacid) as mak from jointacc";
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										if(rs.getString("mak")!=null)
										{
											jointid=rs.getString("mak");
											jointid=Integer.toString(Integer.parseInt(jointid)+1);
										}
										else
											jointid="1";
									}
									
									sql="update pdet set stat='j' where addr='"+jno+"'";
									stm=d.createStatement();
									stm.executeUpdate(sql);
									sql="insert into jointacc values('"+jno+"','"+billv1+"',null,null,null,"+jointid+")";
									stm=d.createStatement();
									stm.executeUpdate(sql);
								}
								else//mil gaya
								{
									sql="select * from jointacc where jacid="+jointid;
									stm=d.createStatement();
									rs=stm.executeQuery(sql);
									while(rs.next())
									{
										if(rs.getString("mob3")==null)
										{
											sql="update jointacc set mob3='"+billv1+"' where jacid="+jointid;
										}else if(rs.getString("mob4")==null)
										{
											sql="update jointacc set mob4='"+billv1+"' where jacid="+jointid;
										}else if(rs.getString("mob5")==null)
										{
											sql="update jointacc set mob5='"+billv1+"' where jacid="+jointid;
										}
									
											}
									stm=d.createStatement();
									stm.executeUpdate(sql);
								}
							sql="select * from jointacc where jacid="+jointid;
							stm=d.createStatement();
							rs=stm.executeQuery(sql);
							String k1=null,k2=null,k3=null,k4=null,k5=null;
							while(rs.next())
							{
								k1=rs.getString("mob1");
								k2=rs.getString("mob2");
								k3=rs.getString("mob3");
								k4=rs.getString("mob4");
								k5=rs.getString("mob5");
							}
							
							billv3=Integer.toString(Integer.parseInt(existbal)+Integer.parseInt(billv3));
							sql="insert into pdet values("+mcid+",'"+s3+"','"+billv1+"','"+prec2+"','"+jno+"','"+b8+"','"+b8+"','"+casti+"',"+billv3+",'j')";
							 stm=d.createStatement();
							 stm.executeUpdate(sql);
							 if(k1!=null)
								{
									sql="Update pdet set balance ="+billv3+"where addr='"+k1+"'";
									stm=d.createStatement();
									stm.executeUpdate(sql);
								}
							 if(k2!=null)
								{
									sql="Update pdet set balance ="+billv3+"where addr='"+k2+"'";
									stm=d.createStatement();
									 stm.executeUpdate(sql);
								}
							 if(k3!=null)
								{
									sql="Update pdet set balance ="+billv3+"where addr='"+k3+"'";
									stm=d.createStatement();
									 stm.executeUpdate(sql);
								}
							 if(k4!=null)
								{
									sql="Update pdet set balance ="+billv3+"where addr='"+k4+"'";
									stm=d.createStatement();
									 stm.executeUpdate(sql);
								}
							 if(k5!=null)
								{
									sql="Update pdet set balance ="+billv3+"where addr='"+k5+"'";
									stm=d.createStatement();
									 stm.executeUpdate(sql);
								}
							}
							catch(SQLException fe)
							{
								fe.printStackTrace();
							}
							
							
						}
						 else
						 {
							//System.out.println("With no join");
							 sql="insert into pdet values("+mcid+",'"+s3+"','"+billv1+"','"+prec2+"','"+jno+"','"+b8+"','"+b8+"','"+casti+"',"+billv3+",'n'"+")";
							 stm=d.createStatement();
							 stm.executeUpdate(sql);
						 }
						 
					}
					sql="Commit";
					stm=d.createStatement();
					stm.executeUpdate(sql);
					//CookieHandler.setDefault(new CookieManager());
					 
					// 1. Send a "GET" request, so that you can extract the form's data.
					
					
					String message="Dear "+t3.getText()+",your bill no is "+t2.getText()+" Amount: "+s10+" Outstanding:"+billv3+" Advance :"+billv2+".Thanks for visiting City Opticals";
					//System.out.println(message.length());
					//message="Hello, this is a test message.";
					message=message.replaceAll(" ", "%20");
					//System.out.println(message);
					doit pw = new doit(user);
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
					
						printingtemplatebill example2 = new printingtemplatebill(b8,s2,s3,s4,j41,s5,j51,s6,j61,s7,j71,s8,j81,billv2,s10);	
						if(!prec2.equals("null")){
						
						printImage = new javax.swing.ImageIcon(prec2);
					    PrinterJob printJob = PrinterJob.getPrinterJob();
					    //System.out.println(t1+t2+t3+t4+t5+t6);
					    //--- Create a new book to add pages to
					    Book book = new Book();

					    //--- Add the cover page using the default page format for this print
					    // job
					    book.append(new MyPrintable(), printJob.defaultPage());

					    //--- Add the document page using a landscape page format
					    PageFormat documentPageFormat = new PageFormat();
					    documentPageFormat.setOrientation(PageFormat.LANDSCAPE);
					   // book.append(new Document(), documentPageFormat);

					    //--- Tell the printJob to use the book as the pageable object
					    printJob.setPageable(book);

					    //--- Show the print dialog box. If the user click the
					    //--- print button we then proceed to print else we cancel
					    //--- the process.
					    if (printJob.printDialog()) {
					      try {
					        printJob.print();
					      } catch (Exception PrintException) {
					        PrintException.printStackTrace();
					      }
					    }
					}
					
						CookieHandler.setDefault(new CookieManager());
						boolean internet=isInternetReachable();
						String urlbal="http://login.smsgatewayhub.com/smsapi/CheckBalance.aspx?user=anmol333&password=671597&gwid=0";
					
					if(internet){
					
						String pagebal = GetPageContent(urlbal);
						int len=pagebal.length();
						pagebal=pagebal.substring(8,len );
						sql="Select stat from pdet where addr='"+billv1+"'";
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
						sql="select * from jointacc where (mob1='"+billv1+"' or mob2='"+billv1+"' or mob3='"+billv1+"' or mob4='"+billv1+"' or mob5='"+billv1+"')";
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
							url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=anmol333&pwd=671597&to="+w1+"&sid=WEBSMS&msg="+message+"&fl=0";
							page = GetPageContent(url);
						}
						if(w2!=null){
							url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=anmol333&pwd=671597&to="+w2+"&sid=WEBSMS&msg="+message+"&fl=0";
							page = GetPageContent(url);
						}
						if(w3!=null){
							url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=anmol333&pwd=671597&to="+w3+"&sid=WEBSMS&msg="+message+"&fl=0";
							page = GetPageContent(url);
						}
						if(w4!=null){
							url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=anmol333&pwd=671597&to="+w4+"&sid=WEBSMS&msg="+message+"&fl=0";
							page = GetPageContent(url);
						}
						if(w5!=null){
							url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=anmol333&pwd=671597&to="+w5+"&sid=WEBSMS&msg="+message+"&fl=0";
							page = GetPageContent(url);
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
						//message=message.replaceAll(" ", "%20");
						
						//System.out.println(message);
						if(Integer.parseInt(pagebal)>=1)
						{
							String url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=anmol333&pwd=671597&to="+billv1+"&sid=WEBSMS&msg="+message+"&fl=0";
						//HttpUrlConnectionExample http = new HttpUrlConnectionExample();
						
						String page = GetPageContent(url);
					}
						else
						{
							int dialogButton = JOptionPane.YES_NO_OPTION;
							int dialogResult = JOptionPane.showConfirmDialog (null, "Your balance is not sufficient to send sms .\nDo you want to store it to automatically send it afterwards ?","Warning",dialogButton);
							String mba="1";
							if(dialogResult == JOptionPane.YES_OPTION)
							{
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
								sql="insert into pendingsms values("+mba+",'"+billv1+"','"+message+"')";
								stm=d.createStatement();
								stm.executeUpdate(sql);
								
							}
						}
					
						
					}
					
					}
					else
					{
						int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog (null, "There is no internet connection at present,so cant send sms at this moment.\nDo you want to store sms details, to automatically send it afterwards when internet connectivity is available?","Warning",dialogButton);
						if(dialogResult == JOptionPane.YES_OPTION)
						{
							//System.out.println("In yes option");
							sql="Select stat from pdet where addr='"+billv1+"'";
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
								sql="select * from jointacc where (mob1='"+billv1+"' or mob2='"+billv1+"' or mob3='"+billv1+"' or mob4='"+billv1+"' or mob5='"+billv1+"')";
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
								sql="insert into pendingsms values("+mba+",'"+billv1+"','"+message+"')";
								stm=d.createStatement();
								stm.executeUpdate(sql);
							}
						}
					}
					sql="Commit";
					stm=d.createStatement();
					stm.executeUpdate(sql);
					

				}
			
				catch(SQLException fe)
				{
					JOptionPane.showMessageDialog(null,"Generate Total");
					//fe.printStackTrace();
				}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Enter a Valid Mobile No");
				}
			}
			
			
}
