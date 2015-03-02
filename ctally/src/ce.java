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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class ce extends JFrame{
	
	JPanel p1=new JPanel();
	JLabel l0=new JLabel();
	JLabel l1=new JLabel("Ename");
	JLabel l2=new JLabel("Address");
	JLabel l3=new JLabel("Salary");
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JButton b1=new JButton("Ok");
	JButton b2=new JButton("Back");
	String s1=null;
	Connection d;
	Statement stm=null;
	gcon k=new gcon();
	public ce(String s2) {
		// TODO Auto-generated constructor stub
		//JLabel l1=new JLabel("EID");
		super("Create Employee");
		s1=s2;
		l0.setText("Welcome "+s1);
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
	
		l0.setBounds(1100, 20, 120, 30);
		l1.setBounds(300, 60, 300, 40);
		t1.setBounds(700, 60, 300, 40);
		l2.setBounds(300, 120, 300, 40);
		t2.setBounds(700, 120, 300, 40);
		l3.setBounds(300, 180, 300, 40);
		t3.setBounds(700, 180, 300, 40);
		b1.setBounds(500, 240, 120, 30);
		b2.setBounds(700, 240, 120, 30);
		ButtonHandler l=new ButtonHandler();
		b1.addActionListener(l);
		b2.addActionListener(l);
		p1.setLayout(null);
		p1.add(b1);
		p1.add(b2);
		p1.add(l0);
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		getContentPane().add(p1);
	}
private class ButtonHandler implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
		d=k.getDBConnection();
		int ne = 0;
		try
		{
			String sql="Select count(*) as count from emplist";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
			   ne = Integer.parseInt(rs.getString("count"));
			}
			
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		ne++;
		try
		{
			String s11=t1.getText();
			String s12=t2.getText();
			String s13=t3.getText();
			String sql="insert into emplist values("+Integer.toString(ne)+",'"+s11+"','"+s12+"',"+s13+")";
			stm=d.createStatement();
			stm.executeUpdate(sql);
			d.close();
			workeropt pw = new workeropt(s1); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 Toolkit tk=Toolkit.getDefaultToolkit();
			 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
			 pw.setVisible(true);
			 setVisible(false);
			
		}
		catch(SQLException fe)
		{
			JOptionPane.showMessageDialog(null,"Fill All Fields and Try Again");
			//fe.printStackTrace();
		}
	}
		if(e.getSource()==b2)
		{ 
		 workeropt pw = new workeropt(s1); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		 setVisible(false);
		}
	}
 }
public void back()
{
	 workeropt pw = new workeropt(s1); // create ButtonFrame
	 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	 Toolkit tk=Toolkit.getDefaultToolkit();
	 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
	 pw.setVisible(true);
	 setVisible(false);
	
}
public void yes()
{
	d=k.getDBConnection();
	int ne = 0;
	try
	{
		String sql="Select count(*) as count from emplist";
		stm=d.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		
		while(rs.next())
		{
		   ne = Integer.parseInt(rs.getString("count"));
		}
		
	}
	catch(SQLException fe)
	{
		fe.printStackTrace();
	}
	ne++;
	try
	{
		String s11=t1.getText();
		String s12=t2.getText();
		String s13=t3.getText();
		String sql="insert into emplist values("+Integer.toString(ne)+",'"+s11+"','"+s12+"',"+s13+")";
		stm=d.createStatement();
		stm.executeUpdate(sql);
		d.close();
		workeropt pw = new workeropt(s1); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		 setVisible(false);
		
	}
	catch(SQLException fe)
	{
		JOptionPane.showMessageDialog(null,"Fill All Fields and Try Again");
		//fe.printStackTrace();
	}
}
}
