import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.TableModel;

import org.jdesktop.swingx.JXDatePicker;


public class vpur extends JFrame{

	JPanel p1=new JPanel();
	Statement stm=null;
	String user;
	gcon k=new gcon();
	Connection d;
	JTable table1;
	JButton b1=new JButton("Back");
	JButton b2=new JButton("Print");
	JButton b3=new JButton("Delete All Entries");
	
	public vpur(String s1) {
		// TODO Auto-generated constructor stub
	super("Purchase Details");
	d=k.getDBConnection();
	user=s1;
	ButtonHandler l=new ButtonHandler();
	
	p1.setLayout(null);
	b1.setBounds(100, 20, 150, 30);
	p1.add(b1);
	b2.setBounds(300, 20, 150, 30);
	p1.add(b2);
	getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "back"); //$NON-NLS-1$
        getRootPane().getActionMap().put("back", new AbstractAction(){ //$NON-NLS-1$
			@Override
			public void actionPerformed(ActionEvent arg0) {
			back();
			}
        });
	b3.setBounds(500, 20, 150, 30);
	p1.add(b3);
	
	b1.addActionListener(l);
	b2.addActionListener(l);
	b3.addActionListener(l);
	int co=0;
	try
	{
		String sql="Select count(*) as count from pentry";
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
		String sql="Select dop,voucherno,pid,companyname,totalamt from pentry";
		stm=d.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		int i=0;
		while(rs.next())
		{
			tab[i][0] = rs.getString("dop");
			tab[i][1] = rs.getString("voucherno");
			tab[i][2] = rs.getString("companyname");
			tab[i][3] = rs.getString("totalamt");
			tab[i][4] = rs.getString("pid");
			i++;
		}
	}
	catch(SQLException fe)
	{
		fe.printStackTrace();
	}
	String colnames[]={"Date","Vouche No","Company Name","Total Amt","PID"};
	table1=new JTable(tab,colnames);
	//table1.addKeyListener(this);
	JScrollPane scrollPane = new JScrollPane(table1);
	table1.setFillsViewportHeight(true);
	createKeybindings(table1);
	scrollPane.setBounds(25,80,1300,600);
	p1.add(scrollPane);
	getContentPane().add(p1);
	
	
	}
	private void createKeybindings(JTable table3) {
		table3.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
		    table3.getActionMap().put("Enter", new AbstractAction() {
		    	TableModel tm=table1.getModel();
		    	public void actionPerformed(ActionEvent ae) {
		            //do something on JTable enter pressed
		        	
		        	int row=table1.getSelectedRow();
					String s1=tm.getValueAt(row, 4).toString();
					 //System.out.println(s1);
					 dsp pw = new dsp(user,s1); // create ButtonFrame
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
				 ptable pw = new ptable(table1); // create ButtonFrame
			}
			if(e.getSource()==b3)
			{
				d=k.getDBConnection();
				try
				{
					String sql="delete from pentry";
					stm=d.createStatement();
					stm.executeUpdate(sql);
					
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
			}
			try {
				d.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			pentry pw = new pentry(user); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			
		}
		
	}
public void back()
	{
		try {
			d.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		pentry pw = new pentry(user); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 Toolkit tk=Toolkit.getDefaultToolkit();
			 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
			 pw.setVisible(true);
			setVisible(false);
		
	}
}
