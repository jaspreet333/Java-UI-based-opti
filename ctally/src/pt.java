import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import org.jdesktop.swingx.JXDatePicker;


public class pt extends JFrame{
	
	JPanel p1=new JPanel();
	JLabel l0=new JLabel();
	JLabel l1=new JLabel("Date");
	JLabel l2=new JLabel("Employee");
	JLabel l3=new JLabel("Payment");
	JLabel l4=new JLabel("Description");
	JXDatePicker t1=new JXDatePicker();
	//JTextField t1=new JTextField();
	JComboBox t2;
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	JButton b1=new JButton("OK");
	JButton b2=new JButton("Back");
	String[] ar=new String[20];
	//ArrayList<String> ar = new ArrayList<String>();
	Connection d;
	Statement stm=null;
	String s1;
	gcon k=new gcon();
	int ne=0;
	public pt(String s2) {
		// TODO Auto-generated constructor stub
		super("Employee Payment Entry");
		d=k.getDBConnection();
		s1=s2;
		int i=0;
		
		try
		{
			String sql="Select eid,name from emplist";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				String eid= rs.getString("eid");
				String name = rs.getString("name");
				ar[i]=eid+" .)"+name;
				i++;
			}
		 
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		p1.setLayout(null);
		l0.setText("Welcome "+s1);
		t1.setDate(Calendar.getInstance().getTime());
		t1.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));
	
		t2=new JComboBox(ar);
	
		
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
		        getRootPane().setFocusable(true);
		l0.setBounds(1100, 20, 120, 30);
		l1.setBounds(300, 60, 300, 40);
		t1.setBounds(700,60,300,40);
		l2.setBounds(300, 120, 300, 40);
		t2.setBounds(700,120,300,40);
		l3.setBounds(300, 180, 300, 40);
		t3.setBounds(700,180,300,40);
		l4.setBounds(300, 240, 300, 40);
		t4.setBounds(700,240,300,40);
		b1.setBounds(500, 300, 150, 30);
		b2.setBounds(800, 300, 150, 30);
		ButtonHandler l=new ButtonHandler();
		b1.addActionListener(l);
		b2.addActionListener(l);
		p1.add(b2);
		p1.add(l0);
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(b1);
		getContentPane().add(p1);
	}
	private class ButtonHandler implements ActionListener
	{
		

			public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getSource()==b1)
				{
					yes();
				}	
			if(arg0.getSource()==b2){
			back();}
		}
		
	}
	public void yes()
	{
		d=k.getDBConnection();
		//System.out.println("in enter");
		Date s12=t1.getDate();
		//System.out.println(s12);
		SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
		String s11=sdf.format(s12);
		//String s1=t1.getText();
	String s3=t3.getText();
	String s4=t4.getText();
	String s5=(String) t2.getSelectedItem();
	String s6=(String) s5.subSequence(0, 2);
	int transid=0;
	try
	{
		String sql="Select count(*) as count  from paytrans";
		stm=d.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		
		while(rs.next())
		{
			transid= Integer.parseInt(rs.getString("count"));
		}
	 
	}
	catch(SQLException fe)
	{
		fe.printStackTrace();
	}
	transid++;
	try
	{
		String sql="insert into paytrans values('"+s11+"',"+s6+","+s3+",'" +s4+ "',"+Integer.toString(transid)+")";
		//System.out.println(sql);
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
	public void back()
	{
		//System.out.println("in escape");
		try {
			d.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		workeropt pw = new workeropt(s1); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		 setVisible(false);
		
	}
}
