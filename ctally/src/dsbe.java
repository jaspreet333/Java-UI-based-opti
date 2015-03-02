import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
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


public class dsbe extends JFrame{

	
	Statement stm=null;
	gcon k=new gcon();
	Connection d=k.getDBConnection();
	//Connection d;
	JPanel p1=new JPanel();
	JLabel l0=new JLabel();
	JLabel l1=new JLabel("Date");
	JLabel l2=new JLabel("Bill NO");
	JLabel l3=new JLabel("Name");
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
	JComboBox t4;
	JComboBox t5;
	JComboBox t6;
	JComboBox t7;
	JComboBox t8;
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
	//JButton b1=new JButton("Save Updates");
	JButton b2=new JButton("Print");
	JButton b3=new JButton("Go Back");
	//JButton b4=new JButton("Update");
	//JButton b5=new JButton("Update");
	//JButton b6=new JButton("Update");
	//JButton b7=new JButton("Update");
	//JButton b8=new JButton("Update");
	//JButton b9=new JButton("Generate Total");
	JButton b10=new JButton("Delete This Entry");
	//String user=null;
	String ar[]={"Frame + Lens","Sunglasses","Contact Lens","Lens Solution"};
	String cbillno1=null;
	String cname1=null;
	Date d2=null;String user1=null;
	int c41=0,c51=0,c61=0,c71=0,c81=0;
	String ct41,ct51,ct61,ct71,ct81,tot,vat;
	String id1,id2,id3,id4,id5,pn1,pn2,pn3,pn4,pn5,mobno,advance,out;
	public dsbe(String user,String s1) {
		// TODO Auto-generated constructor stub
		/*try {
			d.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		cbillno1=s1;
		user1=user;
		try
		{
		 //d=k.getDBConnection();
		 String sql="Select * from billentry where billno="+s1;
		 stm=d.createStatement();
		 ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				tot=rs.getString("total");vat=rs.getString("vat");	d2=rs.getDate("dob");pn1=rs.getString("p1name");pn2=rs.getString("p2name");pn3=rs.getString("p3name");pn4=rs.getString("p4name");pn5=rs.getString("p5name");
				cname1=rs.getString("name");id1=rs.getString("a1");id2=rs.getString("a2");id3=rs.getString("a3");id4=rs.getString("a4");id5=rs.getString("a5");
				mobno=rs.getString("mobno");advance=rs.getString("advance");out=rs.getString("outstanding");
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		//System.out.println(id1);
		l14.setText(vat);
		l15.setText(tot);
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "back"); //$NON-NLS-1$
	        getRootPane().getActionMap().put("back", new AbstractAction(){ //$NON-NLS-1$
				@Override
				public void actionPerformed(ActionEvent arg0) {
				back();
				}
	        });
		if(!id1.equals("null"))
		{
			if(pn1.equals("Frame + Lens"))
				c41=0;
			if(pn1.equals("Sunglasses"))
				c41=1;
			if(pn1.equals("Contact Lens"))
				c41=2;
			if(pn1.equals("Lens Solution"))
				c41=3;
			String temp=null;
			if(c41==0)
			{
				
				try
				{
				 //d=k.getDBConnection();
				 String sql="Select tp from sentry2 where sid="+id1;
				 stm=d.createStatement();
				 ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						temp=rs.getString("tp");
					}
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
			}
			else
			{
				
				try
				{
				 //d=k.getDBConnection();
				 String sql="Select sp from sentry1 where sid="+id1;
				 stm=d.createStatement();
				 ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						temp=rs.getString("sp");
					}
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
			}
			t41.setText(temp);
		}
		else
		{
			t41.setText("null");
		}
		//System.out.println(id2);
		if(!id2.equals("null"))
		{
			if(pn2.equals("Frame + Lens"))
				c51=0;
			if(pn2.equals("Sunglasses"))
				c51=1;
			if(pn2.equals("Contact Lens"))
				c51=2;
			if(pn2.equals("Lens Solution"))
				c51=3;
			String temp=null;
			if(c51==0)
			{
				
				try
				{
				 //d=k.getDBConnection();
				 String sql="Select tp from sentry2 where sid="+id2;
				 stm=d.createStatement();
				 ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						temp=rs.getString("tp");
					}
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
			}
			else
			{
				
				try
				{
				 //d=k.getDBConnection();
				 String sql="Select sp from sentry1 where sid="+id2;
				 stm=d.createStatement();
				 ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						temp=rs.getString("sp");
					}
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
			}
			t51.setText(temp);
		}
		else
		{
			t51.setText("null");
		}
		if(!id3.equals("null"))
		{
			if(pn3.equals("Frame + Lens"))
				c61=0;
			if(pn3.equals("Sunglasses"))
				c61=1;
			if(pn3.equals("Contact Lens"))
				c61=2;
			if(pn3.equals("Lens Solution"))
				c61=3;
			String temp=null;
			if(c61==0)
			{
				
				try
				{
				 //d=k.getDBConnection();
				 String sql="Select tp from sentry2 where sid="+id3;
				 stm=d.createStatement();
				 ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						temp=rs.getString("tp");
					}
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
			}
			else
			{
				
				try
				{
				 //d=k.getDBConnection();
				 String sql="Select sp from sentry1 where sid="+id3;
				 stm=d.createStatement();
				 ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						temp=rs.getString("sp");
					}
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
			}
			t61.setText(temp);
		}
		else
		{
			t61.setText("null");
		}
		if(!id4.equals("null"))
		{
			if(pn4.equals("Frame + Lens"))
				c71=0;
			if(pn4.equals("Sunglasses"))
				c71=1;
			if(pn4.equals("Contact Lens"))
				c71=2;
			if(pn4.equals("Lens Solution"))
				c71=3;
			String temp=null;
			if(c71==0)
			{
				
				try
				{
				 //d=k.getDBConnection();
				 String sql="Select tp from sentry2 where sid="+id4;
				 stm=d.createStatement();
				 ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						temp=rs.getString("tp");
					}
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
			}
			else
			{
				
				try
				{
				 //d=k.getDBConnection();
				 String sql="Select sp from sentry1 where sid="+id4;
				 stm=d.createStatement();
				 ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						temp=rs.getString("sp");
					}
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
			}
			t71.setText(temp);
		}
		else
		{
			t71.setText("null");
		}
		if(!id5.equals("null"))
		{
			if(pn5.equals("Frame + Lens"))
				c81=0;
			if(pn5.equals("Sunglasses"))
				c81=1;
			if(pn5.equals("Contact Lens"))
				c81=2;
			if(pn5.equals("Lens Solution"))
				c81=3;
			String temp=null;
			if(c81==0)
			{
				
				try
				{
				 //d=k.getDBConnection();
				 String sql="Select tp from sentry2 where sid="+id5;
				 stm=d.createStatement();
				 ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						temp=rs.getString("tp");
					}
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
			}
			else
			{
				
				try
				{
				 //d=k.getDBConnection();
				 String sql="Select sp from sentry1 where sid="+id5;
				 stm=d.createStatement();
				 ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						temp=rs.getString("sp");
					}
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
			}
			t81.setText(temp);
		}
		else
		{
			t81.setText("null");
		}
		/*if(ct4.equals("null")&&ct5.equals("null")&&ct6.equals("null")&&ct7.equals("null")&&ct8.equals("null"))
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
				fe.printStackTrace();
			}
		}*/
		t1.setDate(d2);
		t2.setText(cbillno1);
		t3.setText(cname1);
		p1.setLayout(null);
	
	/*	if(cbillno1.equals("null"))
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
		}*/
		//else 
		//t2.setText(cbillno1);
		//t3.setText(cname1);
		t4=new JComboBox(ar);
		t5=new JComboBox(ar);
		t6=new JComboBox(ar);
		t7=new JComboBox(ar);
		t8=new JComboBox(ar);
		t4.setSelectedIndex(c41);t5.setSelectedIndex(c51);t6.setSelectedIndex(c61);t7.setSelectedIndex(c71);t8.setSelectedIndex(c81);
		q41.setText(id1);
		q51.setText(id2);
		q61.setText(id3);
		q71.setText(id4);
		q81.setText(id5);
		FocusListener fo= new FocusAdapter() {
			  public void focusGained(FocusEvent fEvt) {
				    JTextField tField = (JTextField)fEvt.getSource();
				    tField.selectAll();
				  }
				};
		t2.addFocusListener(fo);
		t3.addFocusListener(fo);
		//t2.setFocusable(isFocusable());
		//tf3=new JComboBox(ar);
		l0.setText("Welcome "+user);
		
		t1.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));
		l0.setBounds(1100, 20, 120, 30);
		l1.setBounds(100,60,150,40);
		t1.setBounds(300,60,150,40);
		l2.setBounds(900,60,150,40);
		t2.setBounds(1100,60,150,40);
		l3.setBounds(100,120,150,40);
		t3.setBounds(300,120,300,40);
		l9.setBounds(50, 170, 50, 30);
		l10.setBounds(200, 170, 150, 30);
		//b4.setBounds(450, 170, 100, 30);
		l11.setBounds(650, 170, 150, 30);
		l4.setBounds(50, 220, 50, 30);
		t4.setBounds(200, 220, 150, 30);
		//b4.setBounds(450, 220, 100, 30);
		t41.setBounds(650, 220, 150, 30);
		q41.setBounds(850, 220, 150, 30);
		l5.setBounds(50, 270, 50, 30);
		t5.setBounds(200, 270, 150, 30);
		//b5.setBounds(450, 270, 100, 30);
		t51.setBounds(650, 270, 150, 30);
		q51.setBounds(850, 270, 150, 30);
		l6.setBounds(50, 320, 50, 30);
		t6.setBounds(200, 320, 150, 30);
		//b6.setBounds(450, 320, 100, 30);
		t61.setBounds(650, 320, 150, 30);
		q61.setBounds(850, 320, 150, 30);
		l7.setBounds(50, 370, 50, 30);
		t7.setBounds(200, 370, 150, 30);
		//b7.setBounds(450, 370, 100, 30);
		t71.setBounds(650, 370, 150, 30);
		q71.setBounds(850, 370, 150, 30);
		l8.setBounds(50, 420, 50, 30);
		t8.setBounds(200, 420, 150, 30);
		//b8.setBounds(450, 420, 100, 30);
		t81.setBounds(650, 420, 150, 30);
		q81.setBounds(850, 420, 150, 30);
		l12.setBounds(500, 480, 100, 30);
		l14.setBounds(700, 480, 100, 30);
		l13.setBounds(500, 530, 100, 30);
		l15.setBounds(700, 530, 100, 30);
		//b9.setBounds(950, 490, 150, 30);
		//b1.setBounds(100, 620, 200, 30);
		b2.setBounds(350, 620, 200, 30);
		b3.setBounds(600, 620, 200, 30);b10.setBounds(850, 620, 280, 30);
		q41.setEditable(false);q51.setEditable(false);q61.setEditable(false);q71.setEditable(false);q81.setEditable(false);
		ButtonHandler l=new ButtonHandler();
		//b4.addActionListener(l);
		b10.addActionListener(l);
		//b5.addActionListener(l);
		//b6.addActionListener(l);
		//b7.addActionListener(l);
		//b8.addActionListener(l);
		//b9.addActionListener(l);
		b3.addActionListener(l);
		b2.addActionListener(l);
		//b1.addActionListener(l);
		p1.add(b10);p1.add(l12);p1.add(l13);p1.add(l14);p1.add(l15);p1.add(q41);p1.add(q51);p1.add(q61);p1.add(q71);p1.add(q81);
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
		//p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		//p1.add(b4);
		//p1.add(b5);
		//p1.add(b6);
		//p1.add(b7);
		//p1.add(b8);
		getContentPane().add(p1);
		}
	private class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	if(e.getSource()==b3)
	{
		try {
			d.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		vbe pw = new vbe(user1); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
		 pw.setVisible(true);
		setVisible(false);
	}
	if(e.getSource()==b10)
	{
		String dbno=t2.getText();
		String sql=null;
		try
		{
		 //d=k.getDBConnection();
		if(c41==0&&!id1.equals("null"))
		{
			try{
				sql="Delete from sentry2 where sid="+id1;
				 stm=d.createStatement();
				 stm.executeUpdate(sql);
			}
			catch(SQLException foo){
				foo.printStackTrace();	
			}
		}
		if((c41==1||c41==2||c41==3)&&!id1.equals("null"))
		{
			try{
				sql="Delete from sentry1 where sid="+id1;
				 stm=d.createStatement();
				 stm.executeUpdate(sql);
			}
			catch(SQLException foo){
				foo.printStackTrace();	
			}
		}
		if(c51==0&&!id2.equals("null"))
		{
			try{
				sql="Delete from sentry2 where sid="+id2;
				 stm=d.createStatement();
				 stm.executeUpdate(sql);
			}
			catch(SQLException foo){
				foo.printStackTrace();	
			}
		}
		if((c51==1||c51==2||c51==3)&&!id2.equals("null"))
		{
			try{
				sql="Delete from sentry1 where sid="+id2;
				 stm=d.createStatement();
				 stm.executeUpdate(sql);
			}
			catch(SQLException foo){
				foo.printStackTrace();	
			}
		}
		if(c61==0&&!id3.equals("null"))
		{
			try{
				sql="Delete from sentry2 where sid="+id3;
				 stm=d.createStatement();
				 stm.executeUpdate(sql);
			}
			catch(SQLException foo){
				foo.printStackTrace();	
			}
		}
		if((c61==1||c61==2||c61==3)&&!id3.equals("null"))
		{
			try{
				sql="Delete from sentry1 where sid="+id3;
				 stm=d.createStatement();
				 stm.executeUpdate(sql);
			}
			catch(SQLException foo){
				foo.printStackTrace();	
			}
		}
		if(c71==0&&!id4.equals("null"))
		{
			try{
				sql="Delete from sentry2 where sid="+id4;
				 stm=d.createStatement();
				 stm.executeUpdate(sql);
			}
			catch(SQLException foo){
				foo.printStackTrace();	
			}
		}
		if((c71==1||c71==2||c71==3)&&!id4.equals("null"))
		{
			try{
				sql="Delete from sentry1 where sid="+id4;
				 stm=d.createStatement();
				 stm.executeUpdate(sql);
			}
			catch(SQLException foo){
				foo.printStackTrace();	
			}
		}
		if(c81==0&&!id5.equals("null"))
		{
			try{
				sql="Delete from sentry2 where sid="+id5;
				 stm=d.createStatement();
				 stm.executeUpdate(sql);
			}
			catch(SQLException foo){
				foo.printStackTrace();	
			}
		}
		if((c81==1||c81==2||c81==3)&&!id5.equals("null"))
		{
			try{
				sql="Delete from sentry1 where sid="+id5;
				 stm=d.createStatement();
				 stm.executeUpdate(sql);
			}
			catch(SQLException foo){
				foo.printStackTrace();	
			}
		}
		String cbal=null;
		sql="select stat,balance from pdet where addr='"+mobno+"'";
		 stm=d.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		String stat=null;
		while(rs.next())
		{
			stat=rs.getString("stat");
			cbal=rs.getString("balance");
		}
		//System.out.println(stat +" "+ cbal);
		if(Integer.parseInt(advance)>0)
		{
			sql="delete from transrec where mobno='"+mobno+"' and desci='Advance bill no "+cbillno1+"'" ;
			stm=d.createStatement();
			 stm.executeUpdate(sql);
			 
		}
		sql="delete from transrec where mobno='"+mobno+"' and desci='bill entry no "+cbillno1+"'" ;
		stm=d.createStatement();
		 stm.executeUpdate(sql);
		//System.out.println(mobno);
		//System.out.println("bal before"+cbal); 
		cbal=Integer.toString(Integer.parseInt(cbal)-Integer.parseInt(out));
		 //System.out.println("bal after"+cbal);
		 if(stat.equals("j"))
		{
			String x1=null,x2=null,x3=null,x4=null,x5=null;	
			 sql="select * from jointacc where (mob1='"+mobno+"' or mob2='"+mobno+"' or mob3='"+mobno+"' or mob4='"+mobno+"' or mob5='"+mobno+"')";
			 stm=d.createStatement();
			rs=stm.executeQuery(sql);
				//String stat=null;
				while(rs.next())
				{
					x1=rs.getString("mob1");
					x2=rs.getString("mob2");
					x3=rs.getString("mob3");
					x4=rs.getString("mob4");
					x5=rs.getString("mob5");
				} 
				if(x1!=null)
				{
					sql="update pdet set balance="+cbal+" where addr='"+x1+"'";
					stm=d.createStatement();
					 stm.executeUpdate(sql);
				
				}
				if(x2!=null)
				{
					sql="update pdet set balance="+cbal+" where addr='"+x2+"'";
					stm=d.createStatement();
					 stm.executeUpdate(sql);
				
				}
				if(x3!=null)
				{
					sql="update pdet set balance="+cbal+" where addr='"+x3+"'";
					stm=d.createStatement();
					 stm.executeUpdate(sql);
				
				}
				if(x4!=null)
				{
					sql="update pdet set balance="+cbal+" where addr='"+x4+"'";
					stm=d.createStatement();
					 stm.executeUpdate(sql);
				
				}
				if(x5!=null)
				{
					sql="update pdet set balance="+cbal+" where addr='"+x5+"'";
					stm=d.createStatement();
					 stm.executeUpdate(sql);
				
				}
		}
		else
		{
			sql="update pdet set balance="+cbal+" where addr='"+mobno+"'";
			stm=d.createStatement();
			 stm.executeUpdate(sql);
			 //System.out.println("in nnnnn "+sql);
		}
		sql="Delete from billentry where billno="+dbno;
		 stm=d.createStatement();
		 stm.executeUpdate(sql);
		 
		 d.close();
		 vbe pw = new vbe(user1); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
		 pw.setVisible(true);
		setVisible(false);
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		
	}
	if(e.getSource()==b2)
	{
		Date s1=t1.getDate();
		if(s1==null)
			s1=Calendar.getInstance().getTime();
		//System.out.println(s1);
		//System.out.println(s1);
		SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
		String b8=sdf.format(s1);
		String s2=t2.getText();
		String s3=t3.getText();
		String s41=t41.getText();
		String s51=t51.getText();
		String s61=t61.getText();
		String s71=t71.getText();
		String s81=t81.getText();
		String s9=l14.getText();
		String s10=l15.getText();
		String s4=(String)t4.getSelectedItem();
		String s5=(String)t5.getSelectedItem();
		String s6=(String)t6.getSelectedItem();
		String s7=(String)t7.getSelectedItem();
		String s8=(String)t8.getSelectedItem();
		
		if(s41.equals("null"))
			{s4="null";
			}
		if(s51.equals("null"))
			{s5="null";}
		if(s61.equals("null"))
			{s6="null";}
		if(s71.equals("null"))
			{s7="null";}
		if(s81.equals("null"))
			{s8="null";}
		printingtemplatebill example2 = new printingtemplatebill(b8,s2,s3,s4,s41,s5,s51,s6,s61,s7,s71,s8,s81,s9,s10);
		try {
			d.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		vbe pw = new vbe(user1);
			pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			Toolkit tk=Toolkit.getDefaultToolkit();
			pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
			pw.setVisible(true);
			setVisible(false);
					
			
		}
	}	
	}
	
	void settf4(String to1)
	{
		t41.setText(to1);
	}
	
	public void back()
	{
		try {
			d.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		vbe pw = new vbe(user1); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
		 pw.setVisible(true);
		setVisible(false);
	
	}
	
}
