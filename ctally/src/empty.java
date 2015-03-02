import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class empty extends JFrame{

	String user=null;
	JTextField t1=new JTextField();
	JButton b1=new JButton("Ok");
	JButton b2=new JButton("Back");
	JPanel p1=new JPanel();
	JLabel l0=new JLabel();
	Connection d;
	Statement stm=null;
	gcon k=new gcon();
	
	public empty(String s2) {
		// TODO Auto-generated constructor stub
		user=s2;
		l0.setText("Welcome "+user);
		p1.setLayout(null);
		ButtonHandler l=new ButtonHandler();
		b1.addActionListener(l);b2.addActionListener(l);
		t1.setBounds(500, 60, 300, 40);l0.setBounds(1100, 20, 200, 30);
		b1.setBounds(400, 120, 100, 40);
		b2.setBounds(600, 120, 100, 40);
		p1.add(l0);p1.add(t1);p1.add(b1);p1.add(b2);
		getContentPane().add(p1);
	}
	
	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==b1)
			{
				if(t1.getText().equals("anmol"))
				{
				d=k.getDBConnection();
				String sql="delete from billentry";
				try {
					stm=d.createStatement();
					stm.executeUpdate(sql);
					sql="delete from pentry";
					stm=d.createStatement();
					stm.executeUpdate(sql);
					sql="delete from sentry1";
					stm=d.createStatement();
					stm.executeUpdate(sql);
					sql="delete from sentry2";
					stm=d.createStatement();
					stm.executeUpdate(sql);
					sql="delete from transrec";
					stm=d.createStatement();
					stm.executeUpdate(sql);
					sql="update pdet set balance=0";
					stm=d.createStatement();
					stm.executeUpdate(sql);
					sql="delete from companylist";
					stm=d.createStatement();
					stm.executeUpdate(sql);
					
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
				else
				{
					JOptionPane.showMessageDialog(null, "Wrong Password.Try Again");
				}
				
			}
			if(e.getSource()==b2)
			{
				 doit pw = new doit(user); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
				 pw.setVisible(true);
				setVisible(false);
			}
		}
		
	}
	
}
