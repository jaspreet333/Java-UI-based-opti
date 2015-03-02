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
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;



public class sundeb extends JFrame{

	JPanel p1=new JPanel();
	JButton b1=new JButton("Back");
	JButton b2=new JButton("Print");
	String user1=null;
	gcon k=new gcon();
	Connection d;
	JTable table1;
	Statement stm=null;

	
	public sundeb(String user) {
		// TODO Auto-generated constructor stub
		super("Sundry Debtor");
		d=k.getDBConnection();
		
		user1=user;
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "back"); //$NON-NLS-1$
	        getRootPane().getActionMap().put("back", new AbstractAction(){ //$NON-NLS-1$
				@Override
				public void actionPerformed(ActionEvent arg0) {
				back();
				}
	        });
	        
		ButtonHandler l=new ButtonHandler();
		p1.setLayout(null);
		b1.setBounds(100, 20, 150, 30);
		p1.add(b1);
		b2.setBounds(300, 20, 150, 30);
		p1.add(b2);
		//b3.setBounds(500, 20, 150, 30);
		//p1.add(b3);
		
		b1.addActionListener(l);
		b2.addActionListener(l);
		int co=0,co1=0,co2=0;
		try
		{
			String sql="Select count(*) as count from pdet where stat ='n' and balance>0";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				co1=rs.getInt("count");
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		
		try
		{
			String sql="select count(*) as count from pdet where addr in (select mob1 from jointacc) and balance>0";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
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
		String dat []=new String[co2];
		String ent []=new String[co2];
		int j=0;
		try
		{
			String sql="select mob1,mob2,mob3,mob4,mob5 from jointacc,pdet where mob1=addr and balance>0";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
		
			while(rs.next())
			{
				ent[j]=dat[j]=rs.getString("mob1");
				ent[j]=ent[j]+" "+rs.getString("mob2");
				if(rs.getString("mob3")!=null)
				ent[j]=ent[j]+" "+rs.getString("mob3");
				if(rs.getString("mob4")!=null)
				ent[j]=ent[j]+" "+rs.getString("mob4");
				if(rs.getString("mob5")!=null)
				ent[j]=ent[j]+" "+rs.getString("mob5");
				j++;
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		String tab[][]=new String[co][2];
		try
		{
			String sql="Select addr,balance from pdet where stat='n' and balance>0";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			int i=0;
			while(rs.next())
			{
				tab[i][0] = rs.getString("addr");
				tab[i][1] = rs.getString("balance");
				
				i++;
			}
			//int j=0;
			for(int k=0;k<j;k++)
			{	
			sql="select balance from pdet where addr='"+dat[k]+"'";
			stm=d.createStatement();
			rs=stm.executeQuery(sql);
			//int i=0;
			while(rs.next())
			{
				tab[i][0] = ent[k];
				tab[i][1] = rs.getString("balance");
				
				i++;
			}
		}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		
		String colnames[]={"Name","Balance"};
		table1=new JTable(tab,colnames);
		//table1.addKeyListener(this);
		JScrollPane scrollPane = new JScrollPane(table1);
		table1.setFillsViewportHeight(true);
		//createKeybindings(table1);
		scrollPane.setBounds(25,80,1300,600);
		p1.add(scrollPane);
		getContentPane().add(p1);
	}
	
	private class ButtonHandler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			 pdet pw = new pdet(user1); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 Toolkit tk=Toolkit.getDefaultToolkit();
			 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
			 pw.setVisible(true);
			 setVisible(false);
			 try {
				d.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==b2)
		{
			 ptable pw = new ptable(table1);
		}
		
			
		}
		
	}

	public void back()
	{
		 pdet pw = new pdet(user1); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
		 pw.setVisible(true);
		 setVisible(false);
		 try {
			d.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
}
