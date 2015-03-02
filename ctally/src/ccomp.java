import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
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


public class ccomp extends JFrame{
	
	JLabel l1=new JLabel("Company Name");
	JLabel l2=new JLabel();
	JTextField t1=new JTextField();
	JLabel l3=new JLabel("Address");
	JTextField t3=new JTextField();
	JLabel l4=new JLabel("Balance");
	JTextField t4=new JTextField("0");
	JButton b1=new JButton("Ok");
	JButton b2=new JButton("Back");
	JPanel p1=new JPanel();
	String s1=null;
	Statement stm=null;
	gcon ka= new gcon();
	Connection d=ka.getDBConnection();
	public ccomp(String s2) {
		// TODO Auto-generated constructor stub
	ButtonHandler l=new ButtonHandler();
	p1.setLayout(null);
	l2.setText(s2);
	s1=s2;
	l2.setBounds(250, 10, 100, 30);
	l1.setBounds(20, 50, 100, 30);
	t1.setBounds(200, 50, 100, 30);
	l3.setBounds(20, 100, 100, 30);
	t3.setBounds(200, 100, 100, 30);
	l4.setBounds(20, 150, 100, 30);
	t4.setBounds(200, 150, 100, 30);
	b1.setBounds(10, 200, 60, 30);
	b2.setBounds(100, 200, 60, 30);
	b1.addActionListener(l);
	b2.addActionListener(l);
	p1.add(b1);p1.add(b2);
	p1.add(l1);
	p1.add(l2);
	p1.add(t1);
	p1.add(l3);
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
	p1.add(l4);
	p1.add(t3);
	p1.add(t4);
	getContentPane().add(p1);
	}
	private class ButtonHandler implements ActionListener
	{

	String s;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==b1){
			s=t1.getText();
			String s2=t3.getText();
			String s3=t4.getText();
			try
			{
				stm=d.createStatement();
				String sql="insert into companylist values('"+s+"','"+s2+"',"+s3+")";
				stm.executeUpdate(sql);
				d.close();
				doit pw = new doit(s1); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				 setVisible(false);
			}
			catch(SQLException fe)
			{
				JOptionPane.showMessageDialog(null,"Fill All Fields and Try Again");
				//e.printStackTrace();
			}
		}
			if(e.getSource()==b2)
			{
				try {
					d.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				doit pw = new doit(s1); // create ButtonFrame
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
		try {
			d.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		doit pw = new doit(s1); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		 setVisible(false);
	
	}
	public void yes()
	{
		String s=t1.getText();
		String s2=t3.getText();
		String s3=t4.getText();
		try
		{
			stm=d.createStatement();
			String sql="insert into companylist values('"+s+"','"+s2+"',"+s3+")";
			stm.executeUpdate(sql);
			d.close();
			doit pw = new doit(s1); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 Toolkit tk=Toolkit.getDefaultToolkit();
			 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
			 pw.setVisible(true);
			 setVisible(false);
		}
		catch(SQLException fe)
		{
			JOptionPane.showMessageDialog(null,"Fill All Fields and Try Again");
			//e.printStackTrace();
		}
	}
}
