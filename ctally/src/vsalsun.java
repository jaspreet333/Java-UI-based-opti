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
import javax.swing.table.TableModel;

public class vsalsun extends JFrame{
	JPanel p1=new JPanel();
	Statement stm=null;
	String s2;
	gcon k=new gcon();
	Connection d;
	JButton b1=new JButton("Back");
	JButton b2=new JButton("Print");
	//JButton b3=new JButton("Delete All Entries");
	JTable table1;
	public vsalsun(String s1) {
		// TODO Auto-generated constructor stub
		super("Sales of Sunglasses,Contact Lens And Lens Solution");
		d=k.getDBConnection();
		s2=s1;
		p1.setLayout(null);
		int co=0;
		try
		{
			String sql="Select count(*) as count from sentry1";
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
		String tab[][]=new String[co][5];
		try
		{
			String sql="Select dos,name,sp,sid,product from sentry1";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			int i=0;
			while(rs.next())
			{
				tab[i][0] = rs.getString("dos");
				tab[i][1] = rs.getString("product");
				tab[i][2] = rs.getString("name");
				tab[i][3] = rs.getString("sp");
				tab[i][4] = rs.getString("sid");
				i++;
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		String colnames[]={"Date","Product","Name","Bill Amount","SID"};

		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "back"); //$NON-NLS-1$
	        getRootPane().getActionMap().put("back", new AbstractAction(){ //$NON-NLS-1$
				@Override
				public void actionPerformed(ActionEvent arg0) {
				back();
				}
	        });
	    table1=new JTable(tab,colnames);
		JScrollPane scrollPane = new JScrollPane(table1);
		table1.setFillsViewportHeight(true);
		b1.setBounds(300, 20, 150, 30);
		b2.setBounds(600, 20, 150, 30);
		//b3.setBounds(900, 20, 150, 30);
		scrollPane.setBounds(25, 60, 1300, 620);
		ButtonHandler l=new ButtonHandler();
		createKeybindings(table1);
		b1.addActionListener(l);
		b2.addActionListener(l);
		//b3.addActionListener(l);
		p1.add(scrollPane);
		p1.add(b1);
		//p1.add(b3);
		p1.add(b2);
		//p1.add(scrollPane);
		getContentPane().add(p1);
	}
	private void createKeybindings(JTable table3) {
		table3.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
		    table3.getActionMap().put("Enter", new AbstractAction() {
		    	TableModel tm=table1.getModel();
		    	public void actionPerformed(ActionEvent ae) {
		            //do something on JTable enter pressed
		        	
		        	int row=table1.getSelectedRow();
					String s12=tm.getValueAt(row, 4).toString();
					 //System.out.println(s1);
					 dssalsun pw = new dssalsun(s2,s12); // create ButtonFrame
					 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					 Toolkit tk=Toolkit.getDefaultToolkit();
					 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					 pw.setVisible(true);
					setVisible(false);
		        }
		    });
		}

	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==b2)
			{
				ptable pw= new ptable(table1);
			}
			/*if(e.getSource()==b3)
			{
				d=k.getDBConnection();
				try
				{
					String sql="delete from sentry1";
					stm=d.createStatement();
					stm.executeUpdate(sql);
					
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
			}
			*/	 
			try {
				d.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
				sentry pw = new sentry(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				 setVisible(false);
			
		}
		
	}

	public void back()
	{
		sentry pw = new sentry(s2); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		 setVisible(false);
	
	}
}
