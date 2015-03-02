import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
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
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import org.jdesktop.swingx.JXDatePicker;


public class cp extends JFrame{

	JPanel p1=new JPanel();
	JLabel l0=new JLabel();
	JLabel l1=new JLabel("CID");
	JLabel l2=new JLabel("Name");JLabel l5=new JLabel("Joint Acoount with");
	JLabel l3=new JLabel("Mobile No");JLabel l6=new JLabel("Date");JLabel l7=new JLabel("Caste");
	JLabel l4=new JLabel("Prescription");
	JLabel l8=new JLabel("Balance");
	JTextField t1=new JTextField();
	JTextField t2=new JTextField();
	JTextField t3=new JTextField();
	JTextField t4=new JTextField();JTextField t8=new JTextField();
	JComboBox t5;JComboBox t7;
	JXDatePicker t6=new JXDatePicker();
	JButton b1=new JButton("Back");
	JButton b2=new JButton("Add Presciption Browse");
	JButton b3=new JButton("OK");
	String user1;
	String cst[]={"Bohra","Muslim","Sikh","Hindu","Christian"};
	Statement stm=null;
	gcon k=new gcon();
	Connection d=k.getDBConnection();
	//JFileChooser fileChooser;
	
	public cp(String user) {
		// TODO Auto-generated constructor stub
		super("Create patient");
		l0.setText("Welcome "+user);
		int ne=0;
		user1=user;
		p1.setLayout(null);
		int size=0;
		t7=new JComboBox(cst);
		t8.setText("0");
		
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
		try
		{
			String sql="Select count(*) as count from pdet";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				if(rs.getString("count") != null)
					size = Integer.parseInt(rs.getString("count"));
				size++;
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		
		final String[] dr=new String[size];String[] ar=new String[size];String[] br=new String[size];final String[] cr=new String[size];
		cr[0]="null";
		//dr[size]=null;
		int i=1;
		try
		{
			String sql="Select addr,name from pdet order by name asc";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				String us = rs.getString("addr");
				ar[i]=us;
				br[i]=rs.getString("name");
				cr[i]=ar[i]+" "+br[i];
				i++;
			}
			
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		
		t5=new JComboBox(cr);
		t5.setSelectedIndex(0);
		final int cz=size;
		t5.setEditable(true);
		
		t5.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

		    @Override
		    public void keyReleased(KeyEvent event) {
		        int key=event.getKeyCode();
		        char newi;
		        newi=event.getKeyChar();
		       // System.out.println(key+" "+newi);
		        
		        	String cval=t5.getEditor().getItem().toString();
		        //	System.out.println("print it man "+cval);
		        	//String okk=cval;
		         
		        
		    }
		});
		try
		{
			
			String sql="Select max(cid) as count from pdet";
		 stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
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
		t4.setText("null");
		t6.setDate(Calendar.getInstance().getTime());
		t6.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));
		t1.setText(Integer.toString(ne));
		t1.setEditable(false);
		l0.setBounds(1000, 20, 150, 30);
		b1.setBounds(100, 20, 150, 30);
		l6.setBounds(400, 60, 200, 40);
		t6.setBounds(700, 60, 200, 40);
		l1.setBounds(400, 110, 200, 40);
		t1.setBounds(700, 110, 200, 40);
		l2.setBounds(400, 160, 200, 40);
		t2.setBounds(700, 160, 200, 40);
		l3.setBounds(400, 220, 200, 40);
		t3.setBounds(700, 220, 200, 40);
		l5.setBounds(400, 290, 200, 40);
		t5.setBounds(700, 290, 200, 40);
		l4.setBounds(400, 360, 200, 40);
		t4.setBounds(700, 360, 200, 40);
		l7.setBounds(400, 420, 200, 40);
		t7.setBounds(700, 420, 200, 40);
		l8.setBounds(400, 470, 200, 40);
		t8.setBounds(700, 470, 200, 40);
		b2.setBounds(1000, 365, 250, 30);
		b3.setBounds(650, 530, 150, 40);
		ButtonHandler l= new ButtonHandler();
		b1.addActionListener(l);
		b2.addActionListener(l);p1.add(l8);p1.add(t8);
		b3.addActionListener(l);p1.add(l5);p1.add(t5);p1.add(l6);p1.add(t6);p1.add(l7);p1.add(t7);
		p1.add(l0);p1.add(l1);p1.add(l2);p1.add(l3);p1.add(l4);p1.add(t1);p1.add(t2);p1.add(t3);p1.add(t4);p1.add(b1);p1.add(b2);p1.add(b3);
		/*fileChooser = new JFileChooser();
		fileChooser.setControlButtonsAreShown(false);
	    getContentPane().add(fileChooser, BorderLayout.CENTER);
		fileChooser.setDialogTitle("Choose a file");
	    *///getContentPane().add(fileChooser);
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
			pdet pw = new pdet(user1); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 Toolkit tk=Toolkit.getDefaultToolkit();
			 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
			 pw.setVisible(true);
			 setVisible(false);
		}
		if(e.getSource()==b2)
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
		if(e.getSource()==b3)
		{
			//Date s1=tf1.getDate();
			//System.out.println(s1);
			//SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
			//String b8=sdf.format(s1);
			//System.out.println(b8);
			String s1=t1.getText();
			//String s2=(String)t.getSelectedItem();
			String s2=t2.getText();
			String s3=t3.getText();
			String s4=t4.getText();
			String s5=(String) t5.getSelectedItem();
			Date s9=t6.getDate();
			//System.out.println(s1);
			SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
			String s6=sdf.format(s9);
			String s7=(String) t7.getSelectedItem();
			String s8=t8.getText();
			String jh="n";
			if(s3.length()==10)
			{
			if(!(s5.equals("null")))
			{
				jh="j";
				int flagg=1;String jointid=null;
				try
				{
					
					String sql="Select balance from pdet where addr='"+s5+"'";
				    stm=d.createStatement();
					ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						if(rs.getString("balance") != null)
						s8 = rs.getString("balance");
					}
					
					sql="update pdet set stat='j' where addr='"+s5+"'";
					stm=d.createStatement();
					stm.executeUpdate(sql);
					sql="select * from jointacc";
					stm=d.createStatement();
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						if(!rs.getString("mob1").equals("null"))
							{
							if(s5.equals(rs.getString("mob1")))
									{
										flagg=0;
									}
							}
						if(!rs.getString("mob2").equals("null"))
						{
						if(s5.equals(rs.getString("mob2")))
								{
									flagg=0;
								}
						}if(rs.getString("mob3")!=null)
						{
						if(s5.equals(rs.getString("mob3")))
								{
									flagg=0;
								}
						}if(rs.getString("mob4")!=null)
						{
						if(s5.equals(rs.getString("mob4")))
								{
									flagg=0;
								}
						}if(rs.getString("mob5")!=null)
						{
						if(s5.equals(rs.getString("mob5")))
								{
									flagg=0;
								}
						}
						if(flagg==0)
						{
							jointid=rs.getString("jacid");
							break;
						}
							}
					if(flagg==1)//nahi mila
					{
						String maxid="null";
						sql="select max(jacid) as mak from jointacc";
						stm=d.createStatement();
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							if(rs.getString("mak")!=null)
							{
								maxid=rs.getString("mak");
								maxid=Integer.toString(Integer.parseInt(maxid)+1);
							}
							else
								maxid="1";
						}
						
						
						sql="insert into jointacc values('"+s5+"','"+s3+"',null,null,null,"+maxid+")";
						stm=d.createStatement();
						stm.executeUpdate(sql);
					}
					else//mil gaya
					{
						sql="select * from jointacc where jacid="+jointid;
						stm=d.createStatement();
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							if(rs.getString("mob3")==null)
							{
								sql="update jointacc set mob3='"+s3+"' where jacid="+jointid;
							}else if(rs.getString("mob4")==null)
							{
								sql="update jointacc set mob4='"+s3+"' where jacid="+jointid;
							}else if(rs.getString("mob5")==null)
							{
								sql="update jointacc set mob5='"+s3+"' where jacid="+jointid;
							}
						
								}
						stm=d.createStatement();
						stm.executeUpdate(sql);
					}
					
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
				
			}
			//String s7=tf7.getText();
			//String s8=tf8.getText();
			//int pid=Integer.parseInt(s2);
			//int cp=Integer.parseInt(s5);
			try
			{
				String sql="insert into pdet values("+s1+",'"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s6+"','"+s7+"',"+s8+",'"+jh+"')";
				//System.out.println(sql);
				stm=d.createStatement();
				stm.executeUpdate(sql);
				d.close();
				pdet pw = new pdet(user1); // create ButtonFrame
				pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				Toolkit tk=Toolkit.getDefaultToolkit();
				pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				pw.setVisible(true);
				setVisible(false);
			}
			catch(SQLException fe)
			{
				JOptionPane.showMessageDialog(null,"Fill All Fields/Patient with this mobile No Already exist and Try Again");
				//fe.printStackTrace();
			}
		}
			else
			{
				JOptionPane.showMessageDialog(null,"Enter Valid 10 Digit Mobile No");
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
	pdet pw = new pdet(user1); // create ButtonFrame
	 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	 Toolkit tk=Toolkit.getDefaultToolkit();
	 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
	 pw.setVisible(true);
	 setVisible(false);

}
public void yes()
{
	//Date s1=tf1.getDate();
	//System.out.println(s1);
	//SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
	//String b8=sdf.format(s1);
	//System.out.println(b8);
	String s1=t1.getText();
	//String s2=(String)t.getSelectedItem();
	String s2=t2.getText();
	String s3=t3.getText();
	String s4=t4.getText();
	String s5=(String) t5.getSelectedItem();
	Date s9=t6.getDate();
	//System.out.println(s1);
	SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
	String s6=sdf.format(s9);
	String s7=(String) t7.getSelectedItem();
	String s8=t8.getText();
	String jh="n";
	if(s3.length()==10)
	{
	if(!(s5.equals("null")))
	{
		jh="j";
		int flagg=1;String jointid=null;
		try
		{
			
			String sql="Select balance from pdet where addr='"+s5+"'";
		    stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
			{
				if(rs.getString("balance") != null)
				s8 = rs.getString("balance");
			}
			
			sql="update pdet set stat='j' where addr='"+s5+"'";
			stm=d.createStatement();
			stm.executeUpdate(sql);
			sql="select * from jointacc";
			stm=d.createStatement();
			rs=stm.executeQuery(sql);
			while(rs.next())
			{
				if(!rs.getString("mob1").equals("null"))
					{
					if(s5.equals(rs.getString("mob1")))
							{
								flagg=0;
							}
					}
				if(!rs.getString("mob2").equals("null"))
				{
				if(s5.equals(rs.getString("mob2")))
						{
							flagg=0;
						}
				}if(rs.getString("mob3")!=null)
				{
				if(s5.equals(rs.getString("mob3")))
						{
							flagg=0;
						}
				}if(rs.getString("mob4")!=null)
				{
				if(s5.equals(rs.getString("mob4")))
						{
							flagg=0;
						}
				}if(rs.getString("mob5")!=null)
				{
				if(s5.equals(rs.getString("mob5")))
						{
							flagg=0;
						}
				}
				if(flagg==0)
				{
					jointid=rs.getString("jacid");
					break;
				}
					}
			if(flagg==1)//nahi mila
			{
				String maxid="null";
				sql="select max(jacid) as mak from jointacc";
				stm=d.createStatement();
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					if(rs.getString("mak")!=null)
					{
						maxid=rs.getString("mak");
						maxid=Integer.toString(Integer.parseInt(maxid)+1);
					}
					else
						maxid="1";
				}
				
				
				sql="insert into jointacc values('"+s5+"','"+s3+"',null,null,null,"+maxid+")";
				stm=d.createStatement();
				stm.executeUpdate(sql);
			}
			else//mil gaya
			{
				sql="select * from jointacc where jacid="+jointid;
				stm=d.createStatement();
				rs=stm.executeQuery(sql);
				while(rs.next())
				{
					if(rs.getString("mob3")==null)
					{
						sql="update jointacc set mob3='"+s3+"' where jacid="+jointid;
					}else if(rs.getString("mob4")==null)
					{
						sql="update jointacc set mob4='"+s3+"' where jacid="+jointid;
					}else if(rs.getString("mob5")==null)
					{
						sql="update jointacc set mob5='"+s3+"' where jacid="+jointid;
					}
				
						}
				stm=d.createStatement();
				stm.executeUpdate(sql);
			}
			
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		
	}
	//String s7=tf7.getText();
	//String s8=tf8.getText();
	//int pid=Integer.parseInt(s2);
	//int cp=Integer.parseInt(s5);
	try
	{
		String sql="insert into pdet values("+s1+",'"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s6+"','"+s7+"',"+s8+",'"+jh+"')";
		//System.out.println(sql);
		stm=d.createStatement();
		stm.executeUpdate(sql);
		d.close();
		pdet pw = new pdet(user1); // create ButtonFrame
		pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Toolkit tk=Toolkit.getDefaultToolkit();
		pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		pw.setVisible(true);
		setVisible(false);
	}
	catch(SQLException fe)
	{
		JOptionPane.showMessageDialog(null,"Fill All Fields/Patient with this mobile No Already exist and Try Again");
		//fe.printStackTrace();
	}
}
	else
	{
		JOptionPane.showMessageDialog(null,"Enter Valid 10 Digit Mobile No");
	}
}
}

