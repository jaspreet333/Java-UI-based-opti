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



public class scred extends JFrame{

	JPanel p1=new JPanel();
	JButton b1=new JButton("Back");
	JButton b2=new JButton("Print");
	String user=null;
	gcon k=new gcon();
	Connection d;
	JTable table1;
	Statement stm=null;
	
	public scred(String s1) {
		// TODO Auto-generated constructor stub
	super("Sundry Creditor");
	d=k.getDBConnection();
	user=s1;
	ButtonHandler l=new ButtonHandler();
	getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "back"); //$NON-NLS-1$
        getRootPane().getActionMap().put("back", new AbstractAction(){ //$NON-NLS-1$
			@Override
			public void actionPerformed(ActionEvent arg0) {
			back();
			}
        });
        
	p1.setLayout(null);
	b1.setBounds(100, 20, 150, 30);
	p1.add(b1);
	b2.setBounds(300, 20, 150, 30);
	p1.add(b2);
	//b3.setBounds(500, 20, 150, 30);
	//p1.add(b3);
	
	b1.addActionListener(l);
	b2.addActionListener(l);
	//b3.addActionListener(l);
	int co=0;
	try
	{
		String sql="Select count(*) as count from companylist";
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
	String tab[][]=new String[co][2];
	
	try
	{
		String sql="Select name,balance from companylist";
		stm=d.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		int i=0;
		while(rs.next())
		{
			tab[i][0] = rs.getString("name");
			tab[i][1] = rs.getString("balance");
			
			i++;
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
			 ml pw = new ml(user); // create ButtonFrame
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
		 ml pw = new ml(user); // create ButtonFrame
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
