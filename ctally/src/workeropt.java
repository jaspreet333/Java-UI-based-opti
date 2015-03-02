import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class workeropt extends JFrame{
	
	JPanel p1=new JPanel();
	JLabel l=new JLabel();
	JButton b1=new JButton("<html><p><b><u>C</b></u>reate Employee</p></html>");
	JButton b2=new JButton("<html><p><b><u>P</b></u>ayment Transaction</p></html>");
	JButton b3=new JButton("<html><p><b><u>E</b></u>mployee Payment details</p></html>");
	JButton b4=new JButton("<html><p><b><u>B</b></u>ack</p></html>");
	String s2=null;
	public workeropt(String s1)
	{
		super("Employee");
		s2=s1;
		p1.setLayout(null);
		b1.setBounds(500,60,300,40);
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	            KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "create"); //$NON-NLS-1$
	        getRootPane().getActionMap().put("create", new AbstractAction(){ //$NON-NLS-1$
				@Override
				public void actionPerformed(ActionEvent arg0) {
				ce();
				}
	        });
	        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	                KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "pay"); //$NON-NLS-1$
	            getRootPane().getActionMap().put("pay", new AbstractAction(){ //$NON-NLS-1$
	    			@Override
	    			public void actionPerformed(ActionEvent arg0) {
	    			pay();
	    			}
	            });
	            getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	                    KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), "emp"); //$NON-NLS-1$
	                getRootPane().getActionMap().put("emp", new AbstractAction(){ //$NON-NLS-1$
	        			@Override
	        			public void actionPerformed(ActionEvent arg0) {
	        			emp();
	        			}
	                });
	                getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	                        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "back"); //$NON-NLS-1$
	                    getRootPane().getActionMap().put("back", new AbstractAction(){ //$NON-NLS-1$
	            			@Override
	            			public void actionPerformed(ActionEvent arg0) {
	            			back();
	            			}
	                    });
	                    getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	                            KeyStroke.getKeyStroke(KeyEvent.VK_B, 0), "view3"); //$NON-NLS-1$
	                        getRootPane().getActionMap().put("view3", new AbstractAction(){ //$NON-NLS-1$
	                			@Override
	                			public void actionPerformed(ActionEvent arg0) {
	                			back();
	                			}
	                        });
		b2.setBounds(500, 120, 300, 40);
		b3.setBounds(500, 180, 300, 40);
		b4.setBounds(100, 20, 100, 30);
		l.setText("Welcome "+s1);
		l.setBounds(1100,20,120,30);
		ButtonHandler l=new ButtonHandler();
		b1.addActionListener(l);
		b2.addActionListener(l);
		b3.addActionListener(l);
		b4.addActionListener(l);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		getContentPane().add(p1);
	}
	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==b1)
			{
				 ce pw = new ce(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			}
			if(e.getSource()==b2)
			{
				 pt pw = new pt(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			}
			if(e.getSource()==b3)
			{
				 ved pw = new ved(s2); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			}
			if(e.getSource()==b4)
			{
				 doit pw = new doit(s2); // create ButtonFrame
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
		doit pw = new doit(s2); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		 setVisible(false);

	}
	public void ce()
	{
		 ce pw = new ce(s2); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		setVisible(false);

	}
	public void pay()
	{
		 pt pw = new pt(s2); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		setVisible(false);
	
	}
	public void emp()
	{
		ved pw = new ved(s2); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		setVisible(false);
	}
}
