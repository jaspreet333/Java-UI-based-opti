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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.TableModel;



public class ved extends JFrame{

	JPanel p1=new JPanel();
	JLabel l1=new JLabel("Name");
	JScrollPane scrollPane;
	//JLabel l0=new JLabel();
	JComboBox t1;
	String[] ar=new String[20];
	JLabel l2=new JLabel();
	//ArrayList<String> ar = new ArrayList<String>();
	Connection d;
	Statement stm=null;
	String s1;
	JTable table1;
	gcon k=new gcon();
	JButton b1=new JButton("Ok");
	JButton b2=new JButton("Back");
	JButton b3=new JButton("Delete Selected Entry");
	public ved(String s2) {
		// TODO Auto-generated constructor stub
		super("View Employee Details");
		p1.setLayout(null);
		d=k.getDBConnection();
		s1=s2;
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
			String sql="Select eid,name from emplist";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				String eid= rs.getString("eid");
				String name = rs.getString("name");
				ar[i]=eid+" .)"+name;
				i++;
			}
		 
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		p1.setLayout(null);
		t1=new JComboBox(ar);
		l2.setText( "Welcome "+s1);
		l2.setBounds(1100, 20, 120, 30);
		l1.setBounds(300, 60, 300, 40);
		t1.setBounds(700, 60, 300, 40);
		b1.setBounds(300,120,200,30);
		b2.setBounds(600,120,200,30);
		b3.setBounds(900,120,250,30);
		ButtonHandler l =new ButtonHandler();
		b1.addActionListener(l);
		b2.addActionListener(l);
		b3.addActionListener(l);
		p1.add(b3);
		p1.add(l2);
		p1.add(l1);
		p1.add(t1);
		p1.add(b1);
		p1.add(b2);
		getContentPane().add(p1);
	}
private class ButtonHandler implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			if(scrollPane!=null)
				p1.remove(scrollPane);
			adta();
			/*int co=0;	
			d=k.getDBConnection();
			String s4=((String)t1.getSelectedItem()).substring(0, 2);
			//label:
				//int co=0;	
			//String s4=((String)t1.getSelectedItem()).substring(0, 2);
		   
		    	
			try
			{
				String sql="Select count(*) as count from paytrans where eid="+s4;
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
				String sql="Select dot,payment,desci,transid from paytrans where eid ="+s4;
				stm=d.createStatement();
				ResultSet rs=stm.executeQuery(sql);
				int i=0;
				while(rs.next())
				{
					tab[i][0] = rs.getString("dot");
					tab[i][2] = rs.getString("payment");
					tab[i][1] = rs.getString("desci");
					tab[i][3] = rs.getString("transid");
					i++;
				}
			}
			catch(SQLException fe)
			{
				fe.printStackTrace();
			}
			String colnames[]={"Date","Details","Amount","Transid"};
			table1=new JTable(tab,colnames);
			JScrollPane scrollPane = new JScrollPane(table1);
			table1.setFillsViewportHeight(true);
			//KeyHandler m=new KeyHandler();
			//table1.addKeyListener(m);
			//createKeybindings(table1);
			scrollPane.setBounds(0,160,380,200);
			p1.add(scrollPane);
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
			workeropt pw = new workeropt(s1); // create ButtonFrame
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
			String k1=tm.getValueAt(row, 3).toString();
			System.out.println(k1);
			d=k.getDBConnection();
			try
			{
				String sql="delete from paytrans where transid="+k1;
				stm=d.createStatement();
				stm.executeUpdate(sql);
				
			}
			catch(SQLException fe)
			{
				fe.printStackTrace();
			}
			p1.remove(scrollPane);
			adta();
			/*workeropt pw = new workeropt(s1); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 pw.setSize( 400, 200 ); // set frame size
		 pw.setVisible(true);
		setVisible(false);
		*/
		
		}
	}
	
}
public void adta()
{
	//System.out.println("Called adta");
	int co=0;	
	String s4=((String)t1.getSelectedItem()).substring(0, 2);
	
	try
	{
		String sql="Select count(*) as count from paytrans where eid="+s4;
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
		String sql="Select dot,payment,desci,transid from paytrans where eid ="+s4;
		stm=d.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		int i=0;
		while(rs.next())
		{
			tab[i][0] = rs.getString("dot");
			tab[i][2] = rs.getString("payment");
			tab[i][1] = rs.getString("desci");
			tab[i][3] = rs.getString("transid");
			i++;
		}
	}
	catch(SQLException fe)
	{
		fe.printStackTrace();
	}
	String colnames[]={"Date","Details","Amount","Transid"};
	table1=new JTable(tab,colnames);
	scrollPane = new JScrollPane(table1);
	table1.setFillsViewportHeight(true);
	//KeyHandler m=new KeyHandler();
	//table1.addKeyListener(m);
	//createKeybindings(table1);
	scrollPane.setBounds(0,170,1300,460);
	p1.add(scrollPane);
	getContentPane().add(p1);
}
public void yes()
{
	if(scrollPane!=null)
		p1.remove(scrollPane);
	adta();
}
public void back()
{
	try {
		d.close();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	workeropt pw = new workeropt(s1); // create ButtonFrame
	 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	 Toolkit tk=Toolkit.getDefaultToolkit();
	 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
	 pw.setVisible(true);
	setVisible(false);
	
}
}
