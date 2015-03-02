import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.border.*;
import javax.swing.table.TableModel;
import org.jdesktop.swingx.JXDatePicker;
import java.awt.Toolkit;
import java.awt.geom.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class vbe extends JFrame{

	JPanel p1=new JPanel();
	JButton b1=new JButton("Back");
	JButton b2=new JButton("Print");
	JLabel b3=new JLabel("Sort By Date");
	JButton b4=new JButton("Go");
	//JButton b5=new JButton("Delete all Entries");
	JLabel l1=new JLabel("From");
	JLabel l2=new JLabel("To");
	JLabel l10=new JLabel("Total Sales");JLabel l11=new JLabel();
	JXDatePicker tf1=new JXDatePicker();
	JXDatePicker tf2=new JXDatePicker();
	String user=null;
	Statement stm=null;
	gcon k=new gcon();
	Connection d;
	JScrollPane scrollPane;
	JTable table1;
	String colnames[]={"Date","Bill No","Name","Total Amt"};
	public vbe(String s2) {
		// TODO Auto-generated constructor stub
	super("Bill Entries");
	p1.setLayout(null);
	user=s2;
	d=k.getDBConnection();
	tf1.setDate(null);
	
	tf1.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));tf2.setDate(null);
	tf2.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));
	ButtonHandler l=new ButtonHandler();
	b1.setBounds(50,20,120,30);
	//b5.setBounds(1050,20,120,30);
	b2.setBounds(200,20,120,30);
	b3.setBounds(400,20,120,30);
	b4.setBounds(900,20,50,30);
	tf1.setBounds(600,10,180,30);tf2.setBounds(600,50,180,30);
	b1.addActionListener(l);b2.addActionListener(l);b4.addActionListener(l);
	l10.setBounds(900,650,120,40);l11.setBounds(1100,650,120,40);
	//b5.addActionListener(l);
	p1.add(b1);p1.add(b2);p1.add(b3);
	p1.add(l10);p1.add(l11);
	p1.add(b4);p1.add(tf1);p1.add(tf2);
	//p1.add(b5);
	int co=0;
	try
	{
		String sql="Select count(*) as count from billentry";
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
	int tot=0;
	try
	{
		String sql="Select dob,billno,name,total from billentry";
		stm=d.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		int i=0;
		while(rs.next())
		{
			tab[i][0] = rs.getString("dob");
			tab[i][1] = rs.getString("billno");
			tab[i][2] = rs.getString("name");
			tab[i][3] = rs.getString("total");
			tot=tot+rs.getInt("total");
			//tab[i][4] = rs.getString("pid");
			i++;
		}
	}
	catch(SQLException fe)
	{
		fe.printStackTrace();
	}
	l11.setText(Integer.toString(tot));
	getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "back"); //$NON-NLS-1$
        getRootPane().getActionMap().put("back", new AbstractAction(){ //$NON-NLS-1$
			@Override
			public void actionPerformed(ActionEvent arg0) {
			back();
			}
        });
        getRootPane().setFocusable(true);
	table1=new JTable(tab,colnames);
	//table1.addKeyListener(this);
	 scrollPane = new JScrollPane(table1);
	table1.setFillsViewportHeight(true);
	createKeybindings(table1);
	scrollPane.setBounds(25,100,1300,530);
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
					String s1=tm.getValueAt(row, 1).toString();
					 //System.out.println(s1);
					 dsbe pw = new dsbe(user,s1); // create ButtonFrame
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
		if(e.getSource()==b1||e.getSource()==b2)
		{
			if(e.getSource()==b2)
			{
					 ptable pw = new ptable(table1); // create ButtonFrame
			}
			try {
				d.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			doit pw = new doit(user); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 Toolkit tk=Toolkit.getDefaultToolkit();
			 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
			 pw.setVisible(true);
			setVisible(false);
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
			int co=0;
			try
			{
				String sql="Select count(*) as count from billentry where dob >= '"+z1+"' and dob <= '"+z2+"'";
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
			int tot=0;
			try
			{
				String sql="Select dob,billno,name,total from billentry where dob >= '"+z1+"' and dob <= '"+z2+"'";
				stm=d.createStatement();
				ResultSet rs=stm.executeQuery(sql);
				int i=0;
				while(rs.next())
				{
					tab[i][0] = rs.getString("dob");
					tab[i][1] = rs.getString("billno");
					tab[i][2] = rs.getString("name");
					tab[i][3] = rs.getString("total");
					tot=tot+rs.getInt("total");
					//tab[i][4] = rs.getString("pid");
					i++;
				}
			}
			catch(SQLException fe)
			{
				fe.printStackTrace();
			}
			l11.setText(Integer.toString(tot));
			p1.remove(scrollPane);
			table1=new JTable(tab,colnames);
			//table1.addKeyListener(this);
			scrollPane = new JScrollPane(table1);
			table1.setFillsViewportHeight(true);
			//createKeybindings(table1);
			scrollPane.setBounds(25,100,1300,530);
			p1.add(scrollPane);
		}
		
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
	doit pw = new doit(user); // create ButtonFrame
	 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	 Toolkit tk=Toolkit.getDefaultToolkit();
	 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
	 pw.setVisible(true);
	setVisible(false);

}

}
