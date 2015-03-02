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
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import org.jdesktop.swingx.*;

import java.util.*;
import java.text.*;

public class mpe extends JFrame{

	JPanel p1=new JPanel();
	JLabel l0=new JLabel();
	JLabel l1=new JLabel("Date");
	JLabel l2=new JLabel("Company Name");
	JLabel l3=new JLabel("Amount");
	JLabel l4=new JLabel("Details");
	JLabel l5=new JLabel("Balance");
	JLabel l6=new JLabel();
	JXDatePicker t1=new JXDatePicker();
	//JTextField t1=new JTextField();
	JComboBox t2;
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();
	String s2=null;
	JButton b1=new JButton("Ok");
	JButton b2=new JButton("Back");
	JButton b3=new JButton("SHOW BALANCE");
	String[] ar=new String[20];
	//ArrayList<String> ar = new ArrayList<String>();
	Connection d;
	Statement stm=null;
	gcon k=new gcon();
	public mpe(String s1) {
		// TODO Auto-generated constructor stub
		super("Purchase Payment Entry");
		p1.setLayout(null);
		s2=s1;
		l0.setText("Welcome "+s2);
        d=k.getDBConnection();
		l5.setVisible(false);
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
	
		int i=0;
		try
		{
			String sql="Select name from companylist";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				String us = rs.getString("name");
				ar[i]=us;
				i++;
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		t2=new JComboBox(ar);
		t1.setDate(Calendar.getInstance().getTime());
		t1.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));
		getRootPane().setFocusable(true);
		l0.setBounds(1100, 20, 120, 30);
		l1.setBounds(300, 60, 300, 40);
		t1.setBounds(700, 60, 300, 40);
		l2.setBounds(300, 120, 300, 40);
		t2.setBounds(700, 120, 300, 40);
		b3.setBounds(1050, 120, 300, 40);
		l5.setBounds(1050, 180, 300, 40);
		l6.setBounds(1200, 180, 300, 40);
		l3.setBounds(300, 180, 300, 40);
		t3.setBounds(700, 180, 300, 40);
		l4.setBounds(300, 240, 300, 40);
		t4.setBounds(700, 240, 300, 40);
		b1.setBounds(500, 300, 120, 30);
		b2.setBounds(700, 300, 120, 30);
		ButtonHandler l=new ButtonHandler();
		b1.addActionListener(l);
		b2.addActionListener(l);
		b3.addActionListener(l);
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
		p1.add(b2);
		p1.add(b3);
		p1.add(l5);
		p1.add(l6);
		getContentPane().add(p1);
	}
	String g1=null;
	String g2=null;
	String g3=null;
	String g4=null;
	
	private class ButtonHandler implements ActionListener
	{
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==b1){
			d=k.getDBConnection();
			int i=0;
			try
			{
				String sql="Select count(*) as count from mpe";
				stm=d.createStatement();
				ResultSet rs=stm.executeQuery(sql);
				String us = null;
				while(rs.next())
				{
					 us = rs.getString("count");
				}
				i=Integer.parseInt(us);
			}
			catch(SQLException fe)
			{
				fe.printStackTrace();
			}
			Date s12=t1.getDate();
			//System.out.println(s12);
			SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
			String g1=sdf.format(s12); 
			//g1=t1.getText();
			 g2=(String)t2.getSelectedItem();
			 g3=t3.getText();
			 g4=t4.getText();
			i++;
			try
			{
				String sql="insert into mpe values('"+g1+"',"+Integer.toString(i)+",'"+g2+"',"+g3+",'"+g4+"')";
				stm=d.createStatement();
				stm.executeUpdate(sql);
				d.close();
				ml pw = new ml(s2); // create ButtonFrame
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
			if(e.getSource()==b2){
			 
				try {
					d.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ml pw = new ml(s2); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 Toolkit tk=Toolkit.getDefaultToolkit();
			 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
			 pw.setVisible(true);
			setVisible(false);
			}
			if(e.getSource()==b3)
			{
				g2=(String)t2.getSelectedItem();
				try {
					String bal=null;
					String sql="Select balance from companylist where name='"+g2+"'";
					stm=d.createStatement();
					ResultSet rs=stm.executeQuery(sql);
					String us = null;
					while(rs.next())
					{
						 bal = rs.getString("balance");
					}
					l5.setVisible(true);
					l6.setText(bal);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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

		ml pw = new ml(s2); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		setVisible(false);
	
	}
	public void yes()
	{
		d=k.getDBConnection();
		int i=0;
		try
		{
			String sql="Select count(*) as count from mpe";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			String us = null;
			while(rs.next())
			{
				 us = rs.getString("count");
			}
			i=Integer.parseInt(us);
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		Date s12=t1.getDate();
		//System.out.println(s12);
		SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
		String g1=sdf.format(s12); 
		//g1=t1.getText();
		 g2=(String)t2.getSelectedItem();
		 g3=t3.getText();
		 g4=t4.getText();
		i++;
		try
		{
			String sql="insert into mpe values('"+g1+"',"+Integer.toString(i)+",'"+g2+"',"+g3+",'"+g4+"')";
			stm=d.createStatement();
			stm.executeUpdate(sql);
			d.close();
			ml pw = new ml(s2); // create ButtonFrame
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
