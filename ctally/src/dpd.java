import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class dpd extends JFrame{

	JPanel p1=new JPanel();
	JLabel l0=new JLabel();
	JLabel l1=new JLabel("CID");
	JLabel l2=new JLabel("Name");
	JLabel l3=new JLabel("Address");
	JLabel l4=new JLabel("Prescription");
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	JButton b1=new JButton("Back");
	JButton b2=new JButton("Save changes");
	JButton b3=new JButton("Edit Path");
	String user=null;
	Connection d;
	Statement stm=null;
	gcon k=new gcon();
	
	public dpd(String s1, String s4) {
		// TODO Auto-generated constructor stub
	p1.setLayout(null);
	user=s1;
	l0.setText("Welcome "+s1);
	t1.setText(s4);
	t1.setEditable(false);
	String g2=null,g3=null,g4=null;
	d=k.getDBConnection();
	try
	{
		String sql="Select name,addr,prescri from pdet where cid ="+s4;
		stm=d.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		int i=0;
		while(rs.next())
		{
			g2 = rs.getString("name");
			g3 = rs.getString("addr");
			g4 = rs.getString("prescri");
			//tab[i][3] = rs.getString("transid");
			
		}
	}
	catch(SQLException fe)
	{
		fe.printStackTrace();
	}
	t2.setText(g2);
	t3.setText(g3);t4.setText(g4);
	l0.setBounds(1100,20,130,30);
	l1.setBounds(400,60,200,40);
	t1.setBounds(700,60,200,40);
	l2.setBounds(400,120,200,40);
	t2.setBounds(700,120,200,40);
	l3.setBounds(400,180,200,40);
	t3.setBounds(700,180,200,40);
	l4.setBounds(400,240,200,40);
	t4.setBounds(700,240,200,40);
	b1.setBounds(400, 340, 120, 30);
	b2.setBounds(700, 340, 120, 30);
	b3.setBounds(1000, 250, 120, 30);
	ButtonHandler l=new ButtonHandler();
	b1.addActionListener(l);b2.addActionListener(l);b3.addActionListener(l);
	p1.add(l0);p1.add(l1);p1.add(l2);p1.add(l3);p1.add(l4);p1.add(t1);p1.add(t2);p1.add(t3);p1.add(t4);p1.add(b1);p1.add(b2);p1.add(b3);
	getContentPane().add(p1);
	}

	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==b1)
			{
				try {
					d.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				vpd pw = new vpd(user); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			}
			if(e.getSource()==b2)
			{
				String h1=null,h2=null,h3=null,h4=null;
				h1=t1.getText();h2=t2.getText();h3=t3.getText();h4=t4.getText();
				d=k.getDBConnection();
				try
				{
					String sql="Update pdet set name='"+h2+"',addr='"+h3+"',prescri='"+h4+"' where cid ="+h1;
					stm=d.createStatement();
					stm.executeUpdate(sql);
					d.close();
					vpd pw = new vpd(user); // create ButtonFrame
					pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					Toolkit tk=Toolkit.getDefaultToolkit();
					pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
					pw.setVisible(true);
					setVisible(false);
				}
				catch(SQLException fe)
				{
					JOptionPane.showMessageDialog(null,"Fill remaining Fields With null");
					//fe.printStackTrace();
					
				}
				
			}
			if(e.getSource()==b3)
			{
				String filePath="null"; 
				JFileChooser fileChooser = new JFileChooser();
			        int returnValue = fileChooser.showOpenDialog(null);
			        if (returnValue == JFileChooser.APPROVE_OPTION) {
			        	filePath = fileChooser.getSelectedFile().getAbsolutePath();
			        	//File selectedFile = fileChooser.getSelectedFile();
			          //System.out.println(filePath);
			        }
			        t4.setText(filePath);
			}
		}
		
	}
}
