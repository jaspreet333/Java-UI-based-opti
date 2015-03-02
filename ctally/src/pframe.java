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

public class pframe extends JFrame{
	JPanel p1=new JPanel();
	JLabel user=new JLabel();
	JLabel l1=new JLabel("Date");
	//JLabel l2=new JLabel("PID");
	JLabel l3=new JLabel("Company Name");
	JLabel l4=new JLabel("Product");
	JLabel l5=new JLabel("Cost Price inclusive of VAT");
	JLabel l6=new JLabel("Brand Name");
	JButton b1=new JButton("Ok");
	JLabel l7=new JLabel("Quantity");
	JLabel l8=new JLabel("Total Amount");
	JLabel l9=new JLabel("Voucher No");
	JLabel l10=new JLabel("Vat Amt @5%");
	JComboBox<?> tf3;
	JButton b2=new JButton("Create Company");
	JButton b3=new JButton("Back");JButton b4=new JButton("Generate Total and Vat Amt");
	//JTextField tf1=new JTextField();
	JXDatePicker tf1=new JXDatePicker();
	
	
	//JTextField tf2=new JTextField();
	//JTextField tf3=new JTextField();
	JTextField tf4=new JTextField();
	JTextField tf5=new JTextField();
	JTextField tf6=new JTextField();
	JTextField tf7=new JTextField();
	JTextField tf8=new JTextField();
	JTextField tf9=new JTextField();
	JTextField tf10=new JTextField();
	
	//ArrayList<String> ar = new ArrayList<String>();
	Connection d;
	Statement stm=null;
	String s2;
	
	gcon k=new gcon();
	int ne=0;
	public pframe(String s1,String op) {
		// TODO Auto-generated constructor stub
		super("Purchase Entry");
		d=k.getDBConnection();
		
		tf1.setDate(Calendar.getInstance().getTime());
		tf1.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));
		int i=0;
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
		ne=0;
		int size=0;
		try
		{
			String sql="Select count(*) as count from companylist";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				if(rs.getString("count") != null)
					size = Integer.parseInt(rs.getString("count"));
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		
		String[] ar=new String[size];
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
		 sql="Select max(pid) as count from pentry";
		 stm=d.createStatement();
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				if(rs.getString("count") != null)
				ne = Integer.parseInt(rs.getString("count"));
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		ne++;
		s2=s1;
		ButtonHandler l=new ButtonHandler();
		tf3=new JComboBox(ar);
		p1.setLayout(null);
		user.setText("Welcome "+s1);
		tf4.setText(op);
		tf4.setEditable(false);
		tf9.setText(String.valueOf(ne));
		//tf2.setEditable(false);
		user.setBounds(1100, 20, 100, 30);
		b3.setBounds(100,20,100,30);
		l1.setBounds(300, 70, 300, 40);
		tf1.setBounds(700, 70, 300, 40);
		l9.setBounds(300, 120, 300, 40);
		tf9.setBounds(700, 120, 300, 40);
		l3.setBounds(300, 170, 300, 40);
		tf3.setBounds(700, 170, 300, 40);
		
		l4.setBounds(300, 220, 300, 40);
		tf4.setBounds(700, 220, 300, 40);
		l5.setBounds(300, 270, 300, 40);
		tf5.setBounds(700, 270, 300, 40);
		l6.setBounds(300, 320, 300, 40);
		tf6.setBounds(700, 320, 300, 40);
		l7.setBounds(300, 370, 300, 40);
		tf7.setBounds(700, 370, 300, 40);
		l10.setBounds(300, 420, 300, 40);
		tf10.setBounds(700, 420, 300, 40);
		l8.setBounds(300, 470, 300, 40);
		tf8.setBounds(700, 470, 300, 40);b4.setBounds(1050, 450, 250, 30);
		b2.setBounds(1100, 180, 250, 30);
		b1.setBounds(600, 520, 200, 40);
		b1.addActionListener(l);
		b2.addActionListener(l);b4.addActionListener(l);
		b3.addActionListener(l);
		p1.add(user);
		p1.add(l1);p1.add(b4);
		p1.add(l9);
		p1.add(l3);
		p1.add(l4);
		p1.add(l5);
		p1.add(l6);
		p1.add(tf1);
		p1.add(tf9);
		p1.add(tf3);
		p1.add(tf4);
		p1.add(tf5);
		p1.add(tf6);
		p1.add(b2);
		p1.add(b3);
		p1.add(l7);
		p1.add(l8);
		p1.add(tf7);
		p1.add(tf8);p1.add(tf10);p1.add(l10);
		//ButtonHandler l=new ButtonHandler();
		//b1.addActionListener(l);
		p1.add(b1);
		
		getContentPane().add(p1);
		
	}
	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==b4)
			{
				String f1=tf5.getText();
				String f2=tf7.getText();
				double d1=Double.parseDouble(f1);int d2=Integer.parseInt(f2);
				double tot=d1*d2;
				double vat=tot*.05;
				tf8.setText(Double.toString(tot));
				tf10.setText(Double.toString(vat));
				
			}
			if(e.getSource()==b1)
			{
				
				if(tf8.getText().equals(""))
				{
					String f1=tf5.getText();
					String f2=tf7.getText();
					double d1=Double.parseDouble(f1);int d2=Integer.parseInt(f2);
					double tot=d1*d2;
					double vat=tot*.05;
					tf8.setText(Double.toString(tot));
					tf10.setText(Double.toString(vat));
					
				}
				d=k.getDBConnection();
				Date s1=tf1.getDate();
				//System.out.println(s1);
				SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
				String b8=sdf.format(s1);
				//System.out.println(b8);
				String s9=tf9.getText();
				String s3=(String)tf3.getSelectedItem();
				String s4=tf4.getText();
				String s5=tf5.getText();
				String s6=tf6.getText();
				String s7=tf7.getText();
				String s8=tf8.getText();String s10=tf10.getText();
				//int pid=Integer.parseInt(s2);
				//int cp=Integer.parseInt(s5);
				try
				{
					String sql="insert into pentry values('"+b8+"',"+Integer.toString(ne)+",'"+s3+"','"+s4+"',"+s5+",'"+s6+"',"+s9+","+s7+","+s8+","+s10+")";
					//System.out.println(sql);
					stm=d.createStatement();
					stm.executeUpdate(sql);
					d.close();
					pentry pw = new pentry(s2); // create ButtonFrame
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
				 ccomp pw = new ccomp(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 pw.setSize( 400, 400 ); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			}
			if(e.getSource()==b3)
			{
				try {
					d.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				pentry pw = new pentry(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			}
		}
		
	}
	public void yes()
	{
		if(tf8.getText().equals(""))
		{
			String f1=tf5.getText();
			String f2=tf7.getText();
			int d1=Integer.parseInt(f1);int d2=Integer.parseInt(f2);
			int tot=d1*d2;
			double vat=tot*.05;
			tf8.setText(Integer.toString(tot));
			tf10.setText(Double.toString(vat));
		}
		d=k.getDBConnection();
		Date s1=tf1.getDate();
		//System.out.println(s1);
		SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
		String b8=sdf.format(s1);
		//System.out.println(b8);
		String s9=tf9.getText();
		String s3=(String)tf3.getSelectedItem();
		String s4=tf4.getText();
		String s5=tf5.getText();
		String s6=tf6.getText();
		String s7=tf7.getText();
		String s8=tf8.getText();String s10=tf10.getText();
		//int pid=Integer.parseInt(s2);
		//int cp=Integer.parseInt(s5);
		try
		{
			String sql="insert into pentry values('"+b8+"',"+Integer.toString(ne)+",'"+s3+"','"+s4+"',"+s5+",'"+s6+"',"+s9+","+s7+","+s8+","+s10+")";
			//System.out.println(sql);
			stm=d.createStatement();
			stm.executeUpdate(sql);
			d.close();
			pentry pw = new pentry(s2); // create ButtonFrame
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
		try {
			d.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		pentry pw = new pentry(s2); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		setVisible(false);
	
	}
}

