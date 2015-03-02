import java.awt.Font;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;


public class mainp extends JFrame{
	JButton b1=new JButton("Log In");
	JLabel l1=new JLabel("CITY OPTICALS");
	JLabel l4=new JLabel();
	private JLabel l2=new JLabel("Username");
	private JLabel l3=new JLabel("Password");
	private JTextField tf1=new JTextField();
	private JPasswordField tf2=new JPasswordField();
	//private JTextField tf2=new JTextField();
	gcon k=new gcon();
	Connection d=k.getDBConnection();
	Statement stm=null;
	JPanel p1;
	public mainp()
	{
		super("CITY OPTICALS");
		p1=new JPanel();
		p1.setLayout(null);
		l1.setFont(new Font("Serif", Font.ITALIC, 50));
		l1.setAlignmentX(CENTER_ALIGNMENT);
		//System.out.println(this.getWidth());
		l1.setBounds(400,300 , 600, 75);
		//l1.setAlignmentX(CENTER_ALIGNMENT);
		l2.setBounds(900, 40, 120, 40);
		tf1.setBounds(1100, 40, 120, 40);
		l3.setBounds(900, 110, 120, 40);
		tf2.setBounds(1100, 110, 120, 40);
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	            KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Login"); //$NON-NLS-1$
	        getRootPane().getActionMap().put("Login", new AbstractAction(){ //$NON-NLS-1$
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
				//	visibility();
					String s1=tf1.getText();
					String s2=tf2.getText();
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
							d.close(); 
							doit pw = new doit(s1); // create ButtonFrame
							 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
							 Toolkit tk=Toolkit.getDefaultToolkit();
							 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
							 pw.setVisible(true);
							 setVisible(false);
						}
						else
						{
							l4.setText("Username or Password is Incorrect");
							l4.setVisible(true);
						}
					} 
					catch (SQLException ef) {
						// TODO Auto-generated catch block
						
						//System.out.println("lelllo erroresss    ");
						//ef.printStackTrace();
						
					}
				}

				

				
	        });
		b1.setBounds(1000, 170, 100, 40);
		l4.setBounds(900, 230, 300, 40);
	
		l4.setAlignmentX(CENTER_ALIGNMENT);
		l4.setVisible(false);
		p1.add(b1);
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(tf1);
		p1.add(tf2);
		getContentPane().add(p1);
		ButtonHandler l=new ButtonHandler();
		b1.addActionListener(l);
	}
	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			/*login pw = new login(); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 pw.setSize( 400, 200 ); // set frame size
			 pw.setVisible(true);
			 setVisible(false);
			 */
			String s1=tf1.getText();
			String s2=tf2.getText();
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
					d.close(); 
					doit pw = new doit(s1); // create ButtonFrame
					 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					 Toolkit tk=Toolkit.getDefaultToolkit();
					 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					 pw.setVisible(true);
					 setVisible(false);
				}
				else
				{
					l4.setText("Username or Password is Incorrect");
					l4.setVisible(true);
				}
			} 
			catch (SQLException ef) {
				// TODO Auto-generated catch block
				
				//System.out.println("lelllo erroresss    ");
				//ef.printStackTrace();
				
			}
		}

		
	}
}
