import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class login extends JFrame {
	private JLabel l1=new JLabel("Username");
	private JLabel l2=new JLabel("Password");
	private JTextField tf1=new JTextField();
	private JTextField tf2=new JTextField();
	private JButton b1=new JButton("Ok");
	private JButton b2=new JButton("Back");
	private JLabel l3=new JLabel("");
	JPanel p1=new JPanel();
	gcon k=new gcon();
	Connection d=k.getDBConnection();
	Statement stm=null;
	String s1,s2;

	
	public login()
	{
		
		super("Enter Login Credentials");
		p1.setLayout(null);
		l1.setBounds(20, 15, 100, 30);
		l2.setBounds(20, 50, 100, 30);
		tf1.setBounds(200, 15, 100, 30);
		tf2.setBounds(200, 50, 100, 30);
		b1.setBounds(100, 90, 60, 30);
		b2.setBounds(200, 90, 100, 30);
		l3.setAlignmentX(CENTER_ALIGNMENT);
		l3.setBounds(50, 130,300 , 30);
		p1.add(b1);
		p1.add(b2);
		p1.add(tf1);
		p1.add(tf2);
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		//this.addKeyListener(this);
		ButtonHandler l=new ButtonHandler();
		b1.addActionListener(l);
		b2.addActionListener(l);
		getContentPane().add(p1);
		
	}


	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==b1){
			s1=tf1.getText();
			s2=tf2.getText();
			String sql="Select username,password from logincred";
			try {
				stm = d.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				int i=0;
				while (rs.next())
				{
					String us = rs.getString("username");
					String pa = rs.getString("password");
					if(s1.equals(us)&&s2.equals(pa))
					{
						i=1;
					}
					if(i==1)
						break;
				}
				if(i==1)
				{
					 doit pw = new doit(s1); // create ButtonFrame
					 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					 pw.setSize( 400, 200 ); // set frame size
					 pw.setVisible(true);
					 setVisible(false);
				}
				else
				{
					l3.setText("Username or Password is Incorrect");
				}
			} 
			catch (SQLException ef) {
				// TODO Auto-generated catch block
				
				//System.out.println("lelllo erroresss    ");
				ef.printStackTrace();
				
			}
		}
			if(e.getSource()==b2)
			{
				mainp boxLayoutFrame = new mainp();
				 boxLayoutFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 boxLayoutFrame.setSize( 400, 200 ); // set frame size
				 boxLayoutFrame.setVisible( true ); // display frame
			}
		}
	}


	
}
