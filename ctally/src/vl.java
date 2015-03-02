import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.TableModel;

import org.jdesktop.swingx.JXDatePicker;


public class vl extends JFrame{
	JLabel l0=new JLabel();
	JScrollPane scrollPane;
	JLabel l1=new JLabel("Company Name");
	JLabel l2=new JLabel ("Balance");
	JButton b1=new JButton("OK");
	JButton b2=new JButton("Back");
	JButton b3=new JButton("Delete Entry");
	JButton b4=new JButton("Go");
	JLabel l5=new JLabel("Sort By Date");
	JLabel l6=new JLabel("From");
	JLabel l7=new JLabel("To");
	JXDatePicker tf1=new JXDatePicker();
	JXDatePicker tf2=new JXDatePicker();
	JComboBox t1;
	JTextField t2=new JTextField();
	JPanel p1=new JPanel();
	String s2=null;
	String[] ar=new String[20];
	JTable table1;
	//ArrayList<String> ar = new ArrayList<String>();
	Connection d;
	Statement stm=null;
	gcon k=new gcon();
	public vl(String s1) {
		// TODO Auto-generated constructor stub
		super("Ledger");
		s2=s1;
		l0.setText("Welcome "+s2);
		d=k.getDBConnection();
		int i=0;
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
		t1=new JComboBox(ar);
		p1.setLayout(null);
		tf1.setDate(null);
		tf1.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));tf2.setDate(null);
		tf2.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));
		l0.setBounds(1100, 20, 120, 30);
		l1.setBounds(200, 60, 200, 40);
		t1.setBounds(500,60,250,40);
		b1.setBounds(800, 65, 150, 30);
		b2.setBounds(100, 120, 150, 30);
		b3.setBounds(300, 120, 150, 30);
		l5.setBounds(500, 140, 100, 30);
		l6.setBounds(620, 120, 70, 30);l7.setBounds(620, 160, 70, 30);b4.setBounds(950, 140, 50, 30);
		tf1.setBounds(720, 120, 150, 30);tf2.setBounds(720, 160, 150, 30);
		l2.setBounds(1000,650,100,30);
		l2.setVisible(false);
		p1.add(b4);p1.add(l5);p1.add(l6);p1.add(l7);
		p1.add(l2);
		p1.add(tf1);p1.add(tf2);
		p1.add(l0);
		p1.add(l1);
		p1.add(t1);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		ButtonHandler l=new ButtonHandler();
		b1.addActionListener(l);b4.addActionListener(l);
		b2.addActionListener(l);
		b3.addActionListener(l);
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
				adddta();
				
				/*String cn=(String) t1.getSelectedItem();
				int co=0;
				try
				{
					String sql="Select count(*) as count from mpe where cname='"+cn+"'";
					stm=d.createStatement();
					ResultSet rs=stm.executeQuery(sql);
					
					while(rs.next())
					{
						co=rs.getInt("count");
					}
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
				String tab[][]=new String[co][4];
				
				try
				{
					String sql="Select dot,amt,details,tid from mpe where cname='"+cn+"'";
					stm=d.createStatement();
					ResultSet rs=stm.executeQuery(sql);
					int i=0;
					while(rs.next())
					{
						tab[i][0] = rs.getString("dot");
						tab[i][1] = rs.getString("details");
						tab[i][2] = rs.getString("amt");
						tab[i][3] = rs.getString("tid");
						i++;
					}
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
				String colnames[]={"Date","Details","Total Amt","TID"};
				table1=new JTable(tab,colnames);
				JScrollPane scrollPane = new JScrollPane(table1);
				table1.setFillsViewportHeight(true);
				//createKeybindings(table1);
				scrollPane.setBounds(0,120,380,200);
				p1.add(scrollPane);
				try
				{
					String sql="Select balance from companylist where name='"+cn+"'";
					stm=d.createStatement();
					ResultSet rs=stm.executeQuery(sql);
					
					while(rs.next())
					{
						co=rs.getInt("balance");
					}
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
				t2.setText(Integer.toString(co));
				t2.setEditable(false);
				//l2.setText("Balance");
				l2.setVisible(true);
				t2.setBounds(260,320,90,30);
				
				p1.add(t2);
				
				getContentPane().add(p1);
				*/
			}
			if(e.getSource()==b2)
			{
				try {
					d.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 ml pw = new ml(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			}
			if(e.getSource()==b3)
			{
				int row=table1.getSelectedRow();
				TableModel tm=table1.getModel();
				String k1=tm.getValueAt(row, 4).toString();
				String k2=tm.getValueAt(row, 1).toString();
				System.out.println(k1);
				d=k.getDBConnection();
				if(k2.equals("Receipt/Payment")){
				try
				{
					String sql="delete from mpe where tid="+k1;
					stm=d.createStatement();
					stm.executeUpdate(sql);
					
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
						String sql="delete from pentry where pid="+k1;
						stm=d.createStatement();
						stm.executeUpdate(sql);
						
					}
					catch(SQLException fe)
					{
						fe.printStackTrace();
					}
				}
				p1.remove(scrollPane);
				adddta();
			}
			if(e.getSource()==b4)
			{
				Date s1=tf1.getDate();
				//System.out.println(s1);
				SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
				String z1=sdf.format(s1);
				s1=tf2.getDate();
				//System.out.println(s1);
				String z2=sdf.format(s1);
				
				String cn=(String) t1.getSelectedItem();
				int co=0,co1=0,co2=0;
				
				try
				{
					String sql="Select count(*) as count from mpe where cname='"+cn+"' and (dot>='"+z1+"' and dot <='"+z2+"')";
					stm=d.createStatement();
					ResultSet rs=stm.executeQuery(sql);
					
					while(rs.next())
					{
						co1=rs.getInt("count");
					}
					 sql="Select count(*) as count from pentry where companyname='"+cn+"' and ( dop>='"+z1+"' and dop <='"+z2+"')";
					stm=d.createStatement();
					 rs=stm.executeQuery(sql);
					
					while(rs.next())
					{
						co2=rs.getInt("count");
					}
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
				co=co1+co2;
				String tab[][]=new String[co][5];
				
				try
				{
					String sql="Select dot,amt,details,tid from mpe where cname='"+cn+"' and (dot >='"+z1+"' and dot <='"+z2+"')";
					stm=d.createStatement();
					ResultSet rs=stm.executeQuery(sql);
					int i=0;
					while(rs.next())
					{
						tab[i][0] = rs.getString("dot");
						tab[i][1] = "Receipt/Payment";
						tab[i][2] = rs.getString("details");
						tab[i][3] = rs.getString("amt");
						tab[i][4] = rs.getString("tid");
						i++;
					}
					 sql="Select dop,totalamt,details,pid from pentry where companyname='"+cn+"' and (dop>='"+z1+"' and dop <='"+z2+"')";
					stm=d.createStatement();
					 rs=stm.executeQuery(sql);
					while(rs.next())
					{
						tab[i][0] = rs.getString("dop");
						tab[i][1] = "Purchase";
						tab[i][2] = rs.getString("details");
						tab[i][3] = rs.getString("totalamt");
						tab[i][4] = rs.getString("pid");
						i++;
					}
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
				String colnames[]={"Date","Type Of Transaction ","Details","Total Amt","TID"};
				p1.remove(scrollPane);
				table1=new JTable(tab,colnames);
				scrollPane = new JScrollPane(table1);
				table1.setFillsViewportHeight(true);
				//createKeybindings(table1);
				scrollPane.setBounds(0,200,1300,450);
				p1.add(scrollPane);
				/*try
				{
					String sql="Select balance from companylist where name='"+cn+"'";
					stm=d.createStatement();
					ResultSet rs=stm.executeQuery(sql);
					
					while(rs.next())
					{
						co=rs.getInt("balance");
					}
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}*/
				//t2.setText(Integer.toString(co));
				//t2.setEditable(false);
				//l2.setText("Balance");
				//l2.setVisible(true);
				//t2.setBounds(1100,650,100,30);
				//t2.setVisible(true);
				//p1.add(t2);
				
				getContentPane().add(p1);
			}
		}
		
	}
	public void adddta()
	{
		String cn=(String) t1.getSelectedItem();
		int co=0,co1=0,co2=0;
		
		try
		{
			String sql="Select count(*) as count from mpe where cname='"+cn+"'";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				co1=rs.getInt("count");
			}
			 sql="Select count(*) as count from pentry where companyname='"+cn+"'";
			stm=d.createStatement();
			 rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				co2=rs.getInt("count");
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		co=co1+co2;
		String tab[][]=new String[co][5];
		
		try
		{
			String sql="Select dot,amt,details,tid from mpe where cname='"+cn+"'";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			int i=0;
			while(rs.next())
			{
				tab[i][0] = rs.getString("dot");
				tab[i][1] = "Receipt/Payment";
				tab[i][2] = rs.getString("details");
				tab[i][3] = rs.getString("amt");
				tab[i][4] = rs.getString("tid");
				i++;
			}
			 sql="Select dop,totalamt,details,pid from pentry where companyname='"+cn+"'";
			stm=d.createStatement();
			 rs=stm.executeQuery(sql);
			while(rs.next())
			{
				tab[i][0] = rs.getString("dop");
				tab[i][1] = "Purchase";
				tab[i][2] = rs.getString("details");
				tab[i][3] = rs.getString("totalamt");
				tab[i][4] = rs.getString("pid");
				i++;
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		String colnames[]={"Date","Type Of Transaction ","Details","Total Amt","TID"};
		table1=new JTable(tab,colnames);
		scrollPane = new JScrollPane(table1);
		table1.setFillsViewportHeight(true);
		//createKeybindings(table1);
		scrollPane.setBounds(0,200,1300,450);
		p1.add(scrollPane);
		try
		{
			String sql="Select balance from companylist where name='"+cn+"'";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				co=rs.getInt("balance");
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		t2.setText(Integer.toString(co));
		t2.setEditable(false);
		//l2.setText("Balance");
		l2.setVisible(true);
		t2.setBounds(1100,650,100,30);
		t2.setVisible(true);
		p1.add(t2);
		
		getContentPane().add(p1);
	}
	public void back()
	{
		try {
			d.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 ml pw = new ml(s2); // create ButtonFrame
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
		adddta();

	}
}
