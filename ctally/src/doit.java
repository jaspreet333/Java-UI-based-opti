import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.AttributedString;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import java.awt.font.TextAttribute;
//import java.text.AttributedString;
//import javax.swing.JTextField;


public class doit extends JFrame{

	JPanel p1=new JPanel();
	Font plainFont = new Font("Times New Roman", Font.PLAIN, 24); 
	JButton b1=new JButton("<html><p><b><u>P</b></u>urchase</p></html>");
	JButton b2=new JButton("<html><p><b><u>S</b></u>ales</p></html>");
	JButton b3=new JButton("<html><p><b><u>E</b></u>mployees</p></html>");
	JButton b4=new JButton("<html><p>P<b><u>U</b></u>rchase Payment Entry</p></html>");
	JButton b5=new JButton("<html><p><b><u>L</b></u>ogout</p></html>");
	JButton b6=new JButton("<html><p><b><u>M</b></u>ake Bill and Sales Entry</p></html>");
	JButton b7=new JButton("<html><p>P<b><u>A</b></u>tient And Their Ledger</p></html>");
	JButton b8=new JButton("<html><p><b><u>V</b></u>iew Bill Entries</p></html>");
	JButton b9=new JButton("<html><p><b><u>C</b></u>ash Received/Sales Payment Entry</p></html>");
	JButton b10=new JButton("<html><p><b><u>B</b></u>ulk sms</p></html>");
	JButton b11=new JButton("Master Control");
	JLabel l1;
	String s2;
	public doit(String s1) {
		// TODO Auto-generated constructor stub
		super("Main Screen");
		//System.out.println(message.length());
		s2=s1;
		ButtonHandler l=new ButtonHandler();
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	            KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "purchase"); //$NON-NLS-1$
	        getRootPane().getActionMap().put("purchase", new AbstractAction(){ //$NON-NLS-1$
				@Override
				public void actionPerformed(ActionEvent arg0) {
				purchase();
				}
	        });
	        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		            KeyStroke.getKeyStroke(KeyEvent.VK_L, 0), "lout"); //$NON-NLS-1$
		        getRootPane().getActionMap().put("lout", new AbstractAction(){ //$NON-NLS-1$
					@Override
					public void actionPerformed(ActionEvent arg0) {
					lout();
					}
		        });
	        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		            KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "sales"); //$NON-NLS-1$
		        getRootPane().getActionMap().put("sales", new AbstractAction(){ //$NON-NLS-1$
					@Override
					public void actionPerformed(ActionEvent arg0) {
					sales();
					}
		        });
		        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			            KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), "employee"); //$NON-NLS-1$
			        getRootPane().getActionMap().put("employee", new AbstractAction(){ //$NON-NLS-1$
						@Override
						public void actionPerformed(ActionEvent arg0) {
						emp();
						}
			        });
			        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				            KeyStroke.getKeyStroke(KeyEvent.VK_U, 0), "pay"); //$NON-NLS-1$
				        getRootPane().getActionMap().put("pay", new AbstractAction(){ //$NON-NLS-1$
							@Override
							public void actionPerformed(ActionEvent arg0) {
							pay();
							}
				        });
				        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
					            KeyStroke.getKeyStroke(KeyEvent.VK_M, 0), "make"); //$NON-NLS-1$
					        getRootPane().getActionMap().put("make", new AbstractAction(){ //$NON-NLS-1$
								@Override
								public void actionPerformed(ActionEvent arg0) {
								make();
								}
					        });
					        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
						            KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "pat"); //$NON-NLS-1$
						        getRootPane().getActionMap().put("pat", new AbstractAction(){ //$NON-NLS-1$
									@Override
									public void actionPerformed(ActionEvent arg0) {
									pat();
									}
						        });
						        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
							            KeyStroke.getKeyStroke(KeyEvent.VK_V, 0), "view"); //$NON-NLS-1$
							        getRootPane().getActionMap().put("view", new AbstractAction(){ //$NON-NLS-1$
										@Override
										public void actionPerformed(ActionEvent arg0) {
										view();
										}
							        });
							        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
								            KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "cash"); //$NON-NLS-1$
								        getRootPane().getActionMap().put("cash", new AbstractAction(){ //$NON-NLS-1$
											@Override
											public void actionPerformed(ActionEvent arg0) {
											cash();
											}
								        });
								        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
									            KeyStroke.getKeyStroke(KeyEvent.VK_B, 0), "bulk"); //$NON-NLS-1$
									        getRootPane().getActionMap().put("bulk", new AbstractAction(){ //$NON-NLS-1$
												@Override
												public void actionPerformed(ActionEvent arg0) {
												bulk();
												}
									        });
		 RunnableDemo R1 = new RunnableDemo();
	      R1.start();
		p1.setLayout(null);
		l1=new JLabel("Welcome "+s1);
		l1.setBounds(1100, 20, 100, 30);
		b1.setBounds(500, 70, 300, 40);
		b2.setBounds(500, 130, 300, 40);
		b3.setBounds(500, 190, 300, 40);
		b4.setBounds(500, 250, 300, 40);
		b5.setBounds(1100, 60, 100, 30);
		b6.setBounds(500, 310, 300, 40);
		b7.setBounds(500, 370, 300, 40);
		b1.addActionListener(l);
		b8.setBounds(500, 430, 300, 40);
		b9.setBounds(500, 490, 300, 40);
		b10.setBounds(500, 550, 300, 40);b11.setBounds(1050, 300, 250, 40);
		b2.addActionListener(l);b10.addActionListener(l);b11.addActionListener(l);
		b8.addActionListener(l);
		b3.addActionListener(l);
		b4.addActionListener(l);
		b5.addActionListener(l);
		b6.addActionListener(l);
		b7.addActionListener(l);b9.addActionListener(l);
		p1.add(b6);p1.add(b7);p1.add(b8);p1.add(b9);
		p1.add(b1);
		p1.add(b2);p1.add(b11);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);p1.add(b10);
		p1.add(l1);
		getContentPane().add(p1);
	}
	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==b1)
			{
				purchase(); 
				
			}
			if(e.getSource()==b2)
			{
				sales(); 
				
			}
			if(e.getSource()==b3)
			{
				emp();
				
			}
			if(e.getSource()==b4)
			{
				pay(); 
				
			}
			if(e.getSource()==b5)
			{
				lout(); 
			}
			if(e.getSource()==b6)
			{
				make();
					
				 
			}
			if(e.getSource()==b7)
			{
				pat(); 
				
				
			}
			if(e.getSource()==b8)
			{
				view(); 
				
				
			}
			if(e.getSource()==b9)
			{
				 cash();
					
			}
			if(e.getSource()==b10)
			{
				bulk(); 
				
			}
			if(e.getSource()==b11)
			{
				 empty pw = new empty(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			
			}
		}
		
	}
	public void purchase()
	{
		pentry pw = new pentry(s2); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		setVisible(false);
	}
	public void lout()
	{
		mainp pw = new mainp(); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
		 pw.setVisible(true);
		setVisible(false);
	
	}
	public void sales()
	{
		sentry pw = new sentry(s2); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		 setVisible(false);
	}
	public void emp()
	{
		workeropt pw = new workeropt(s2); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
		 pw.setVisible(true);
		setVisible(false);
	}
	public void pay()
	{
		 ml pw = new ml(s2); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
		 pw.setVisible(true);
		setVisible(false);
	}
	public void make()
	{
		Statement stm=null;
		gcon k=new gcon();
		Connection d=k.getDBConnection();
		try
		{
			d.setAutoCommit(false);
			String sql="savepoint beforebill";
			stm=d.createStatement();
			stm.executeUpdate(sql);
			//System.out.println("Savepoint is to be created");
			Date d1=null; 
			billing pw = new billing(s2,d1, "null", "null", 0, 0, 0, 0, 0, "null","null", "null","null", "null","null","null","null","null","null",d,"null","null",0,0); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 Toolkit tk=Toolkit.getDefaultToolkit();
			 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
			 pw.setVisible(true);
			 setVisible(false);
		}
		catch(SQLException fe)
		{
			JOptionPane.showMessageDialog(null, "Savepoint not created");
			//System.out.println("Savepoint not created");
		}
		}
	public void pat()
	{
		 pdet pw = new pdet(s2); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
		 pw.setVisible(true);
		setVisible(false);
	}
	public void view()
	{
		 vbe pw = new vbe(s2); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
		 pw.setVisible(true);
		setVisible(false);
	}
	public void cash()
	{
		 mpeb pw = new mpeb(s2); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
		 pw.setVisible(true);
		setVisible(false);
	}
	public void bulk()
	{
		 bsms pw = new bsms(s2); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
		 pw.setVisible(true);
		setVisible(false);
	}
}
