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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;




public class vptran extends JFrame{

	JPanel p1=new JPanel();
	JLabel l1=new JLabel("Select Mob No And Name");
	JScrollPane scrollPane;
	//JLabel l0=new JLabel();
	JComboBox t1;
	
	JLabel l2=new JLabel();
	//ArrayList<String> ar = new ArrayList<String>();
	Connection d;
	Statement stm=null;
	
	String user1;
	JTable table1;
	gcon k=new gcon();
	JButton b1=new JButton("Ok");
	JButton b2=new JButton("Back");
	JLabel l10=new JLabel("Balance");
	JLabel l11=new JLabel();
	//JButton b3=new JButton("Delete Selected Entry");
	
	public vptran(String user) {
		// TODO Auto-generated constructor stub
		
		super("View Patient Account");
		p1.setLayout(null);
		d=k.getDBConnection();
		
		//p1.add(scrollPane);
		user1=user;
		int count=0;
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
		int i=0;
		l10.setVisible(false);
		try
		{
			String sql="Select count(*) as count from pdet";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				if(rs.getString("count")!=null)
				count=rs.getInt("count");
			
			}
		 
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		String[] ar=new String[count];
		try
		{
			String sql="Select addr,name from pdet";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			String eid=null,name=null;
			while(rs.next())
			{
				 eid= rs.getString("addr");
				 name = rs.getString("name");
				ar[i]=eid+"  "+name;
				i++;
			}
		 
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		p1.setLayout(null);
		t1=new JComboBox(ar);
		l2.setText( "Welcome "+user1);
		l2.setBounds(1100, 20, 120, 30);
		l1.setBounds(300, 60, 300, 40);
		t1.setBounds(700, 60, 300, 40);
		b1.setBounds(300,120,200,30);
		b2.setBounds(600,120,200,30);
		l10.setBounds(900,650,150,40);
		l11.setBounds(1100,650,150,40);
		//b3.setBounds(900,120,250,30);
		ButtonHandler l =new ButtonHandler();
		b1.addActionListener(l);
		b2.addActionListener(l);
		//b3.addActionListener(l);
		//p1.add(b3);
		p1.add(l2);
		p1.add(l1);
		p1.add(t1);
		p1.add(b1);
		p1.add(b2);p1.add(l10);p1.add(l11);
		getContentPane().add(p1);

	}

	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==b1)
			{
				if(scrollPane!=null)
				p1.remove(scrollPane);
				adta();
				l10.setVisible(true);
			}
			if(e.getSource()==b2)
			{
				 pdet pw = new pdet(user1); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				 setVisible(false);
			}
		}
		
	}
	public void adta()
	{
		//System.out.println("Called adta");
			
		String s4=((String)t1.getSelectedItem()).substring(0, 10);
		String stat=null;
		String bali=null;
		try
		{
			String sql="Select balance from pdet where addr='"+s4+"'";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				bali=rs.getString("balance");
			}
		}
		catch(SQLException fe)
		{
			JOptionPane.showMessageDialog(null,"Mobile  no is not 10 digits");
		}
		l11.setText(bali);
		try
		{
			String sql="Select stat from pdet where addr='"+s4+"'";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				stat=rs.getString("stat");
			}
		}
		catch(SQLException fe)
		{
			JOptionPane.showMessageDialog(null,"Mobile  no is not 10 digits");
		}
		if(stat!=null){
		if(stat.equals("j"))
		{
			String mob1=null,mob2=null,mob3=null,mob4=null,mob5=null;
			try
			{
				String sql="select * from jointacc where (mob1='"+s4+"' or mob2='"+s4+"' or mob3='"+s4+"' or mob4='"+s4+"' or mob5='"+s4+"')";
				stm=d.createStatement();
				ResultSet rs=stm.executeQuery(sql);
				
				while(rs.next())
				{
					mob1=rs.getString("mob1");mob2=rs.getString("mob2");mob3=rs.getString("mob3");mob4=rs.getString("mob4");mob5=rs.getString("mob5");
				}
				
				sql="select count(*) as count from transrec where mobno='"+mob1+"' or mobno='"+mob2+"'";
				if(mob3!=null)
					sql=sql+" or mobno='"+mob3+"'";
				if(mob4!=null)
					sql=sql+" or mobno='"+mob4+"'";
				if(mob5!=null)
					sql=sql+" or mobno='"+mob5+"'";
				sql=sql+" order by dot asc";
				stm=d.createStatement();
				rs=stm.executeQuery(sql);
				int co=0;
				while(rs.next())
				{
					if(rs.getString("count")!=null)
						co=rs.getInt("count");
				}
				
				String tab[][]=new String[co][5];
				
				sql="select mobno,amount,dot,desci,name from transrec,pdet where ((mobno='"+mob1+"' or mobno='"+mob2+"'";
						if(mob3!=null)
							sql=sql+" or mobno='"+mob3+"'";
						if(mob4!=null)
							sql=sql+" or mobno='"+mob4+"'";
						if(mob5!=null)
							sql=sql+" or mobno='"+mob5+"'";
						sql=sql+" ) and addr=mobno)order by dot asc";
						stm=d.createStatement();
						rs=stm.executeQuery(sql);
						int i=0;
						while(rs.next())
						{
							tab[i][0] = rs.getString("dot");
							tab[i][2] = rs.getString("mobno");
							tab[i][1] = rs.getString("name");
							tab[i][3] = rs.getString("desci");
							tab[i][4] = rs.getString("amount");
							i++;
						}
						String colnames[]={"Date","Mob No","Name","Description","Amount"};
						table1=new JTable(tab,colnames);
			}
			catch(SQLException fe)
			{
				fe.printStackTrace();
			}
			
		}
		else
		{
			try{
			String sql="select count(*) as count from transrec where mobno='"+s4+"'";
			
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			int co=0;
			while(rs.next())
			{
				if(rs.getString("count")!=null)
					co=rs.getInt("count");
			}
			
			String tab[][]=new String[co][5];
			
			sql="select mobno,amount,dot,desci,name from transrec,pdet where ((mobno='"+s4+"') and addr=mobno) order by dot asc";
					stm=d.createStatement();
					rs=stm.executeQuery(sql);
					int i=0;
					while(rs.next())
					{
						tab[i][0] = rs.getString("dot");
						tab[i][2] = rs.getString("mobno");
						tab[i][1] = rs.getString("name");
						tab[i][3] = rs.getString("desci");
						tab[i][4] = rs.getString("amount");
						i++;
					}
					String colnames[]={"Date","Mob No","Name","Description","Amount"};
					table1=new JTable(tab,colnames);
			}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}

		}
		
	
		
		scrollPane = new JScrollPane(table1);
		table1.setFillsViewportHeight(true);
		//KeyHandler m=new KeyHandler();
		//table1.addKeyListener(m);
		//createKeybindings(table1);
		scrollPane.setBounds(0,170,1300,460);
		p1.add(scrollPane);
		getContentPane().add(p1);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Mobile  no is not 10 digits");
		}
	}
	
	public void back()
	{
		
			 pdet pw = new pdet(user1); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 Toolkit tk=Toolkit.getDefaultToolkit();
			 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
			 pw.setVisible(true);
			 setVisible(false);
	
	}
	public void yes()
	{
		if(scrollPane!=null)
			p1.remove(scrollPane);
			adta();
			l10.setVisible(true);

	}
}
