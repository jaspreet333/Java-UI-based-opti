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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class vetd extends JFrame{

	JPanel p1=new JPanel();
	Statement stm=null;
	String user;
	gcon k=new gcon();
	Connection d;
	JTable table1;
	JButton b1=new JButton("Back");
	String x1=null;
	String x2=null;
	public vetd(String s1, String s4) {
		// TODO Auto-generated constructor stub
		d=k.getDBConnection();
		user=s1;
		x1=s1;
		x2=s4;
		ButtonHandler l=new ButtonHandler();
		p1.setLayout(null);
		b1.setBounds(100, 10, 80, 20);
		p1.add(b1);
		b1.addActionListener(l);
		int co=0;
		try
		{
			String sql="Select count(*) as count from paytrans where eid="+s4;
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				co=rs.getInt("count");
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		String tab[][]=new String[co][3];
		try
		{
			String sql="Select dot,payment,desci from paytrans where eid ="+s4;
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			int i=0;
			while(rs.next())
			{
				tab[i][0] = rs.getString("dot");
				tab[i][2] = rs.getString("payment");
				tab[i][1] = rs.getString("desci");
				//tab[i][3] = rs.getString("totalamt");
				i++;
			}
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		String colnames[]={"Date","Details","Amount"};
		table1=new JTable(tab,colnames);
		JScrollPane scrollPane = new JScrollPane(table1);
		table1.setFillsViewportHeight(true);
		KeyHandler m=new KeyHandler();
		table1.addKeyListener(m);
		//createKeybindings(table1);
		scrollPane.setBounds(0,40,380,120);
		p1.add(scrollPane);
		getContentPane().add(p1);
		
	}
	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			// TODO Auto-generated method stub
			try {
				d.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			workeropt pw = new workeropt(user); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 pw.setSize( 400, 200 ); // set frame size
			 pw.setVisible(true);
			 setVisible(false);
		}
	}
	private class KeyHandler implements KeyListener
	{
		public void keyPressed(KeyEvent f)
		{
			if(f.getKeyCode()==KeyEvent.VK_DELETE)
			{
				System.out.println("Want to delete the entry");
				int selectedRowIndex = table1.getSelectedRow();
				//int selectedColumnIndex = table1.getSelectedColumn();
				//Object selectedObject = (Object) table1.getModel().getValueAt(selectedRowIndex, selectedColumnIndex);
				String a1=(String) table1.getModel().getValueAt(selectedRowIndex, 0);
				String a2=(String) table1.getModel().getValueAt(selectedRowIndex, 1);
				String a3=(String) table1.getModel().getValueAt(selectedRowIndex, 2);
				d=k.getDBConnection();
				System.out.println(a1+" "+a2+" "+a3);
				try
				{
					String sql="delete from paytrans where dot="+"'"+a1+"'and desci='"+a2+"' and payment="+a3;
					stm=d.createStatement();
					stm.executeUpdate(sql);
					
				
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
				vetd pw = new vetd(x1,x2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 pw.setSize( 400, 200 ); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			}
		}
		@Override
		public void keyReleased(KeyEvent f) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent f) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
