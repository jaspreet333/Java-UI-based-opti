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
import javax.swing.KeyStroke;


public class pdet extends JFrame{

	JPanel p1=new JPanel();
	JButton b1=new JButton("<html><p><b><u>C</u></b>reate New Patient</p></html>");
	JButton b2=new JButton("<html><p><b><u>V</b></u>iew Patient Details</p></html>");
	JButton b4=new JButton("<html><p><b><u>S</b></u>undry Debtors</p></html>");JButton b5=new JButton("<html><p><b><u>L</b></u>edger of Patient</p></html>");
	JButton b3=new JButton("<html><p><b><u>B</b></u>ack</p></html>");
	JLabel l1=new JLabel();
	String user;
	public pdet(String s2) {
		// TODO Auto-generated constructor stub
	super("Patient Details");
	p1.setLayout(null);
	user=s2;
	l1.setText("Welcome "+s2);
	getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "back"); //$NON-NLS-1$
        getRootPane().getActionMap().put("back", new AbstractAction(){ //$NON-NLS-1$
			@Override
			public void actionPerformed(ActionEvent arg0) {
			back();
			}
        });
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	            KeyStroke.getKeyStroke(KeyEvent.VK_B, 0), "back2"); //$NON-NLS-1$
	        getRootPane().getActionMap().put("back2", new AbstractAction(){ //$NON-NLS-1$
				@Override
				public void actionPerformed(ActionEvent arg0) {
				back();
				}
	        });
	        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
		            KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "b11"); //$NON-NLS-1$
		        getRootPane().getActionMap().put("b11", new AbstractAction(){ //$NON-NLS-1$
					@Override
					public void actionPerformed(ActionEvent arg0) {
					b11();
					}
		        });
		        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			            KeyStroke.getKeyStroke(KeyEvent.VK_V, 0), "b12"); //$NON-NLS-1$
			        getRootPane().getActionMap().put("b12", new AbstractAction(){ //$NON-NLS-1$
						@Override
						public void actionPerformed(ActionEvent arg0) {
						b12();
						}
			        });
			        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				            KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "b13"); //$NON-NLS-1$
				        getRootPane().getActionMap().put("b13", new AbstractAction(){ //$NON-NLS-1$
							@Override
							public void actionPerformed(ActionEvent arg0) {
							b14();
							}
				        });
				        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
					            KeyStroke.getKeyStroke(KeyEvent.VK_L, 0), "b14"); //$NON-NLS-1$
					        getRootPane().getActionMap().put("b14", new AbstractAction(){ //$NON-NLS-1$
								@Override
								public void actionPerformed(ActionEvent arg0) {
								b15();
								}
					        });
	ButtonHandler l=new ButtonHandler();
	b1.setBounds(500, 60, 300, 40);
	b2.setBounds(500, 140, 300, 40);
	b5.setBounds(500, 220, 300, 40);b4.setBounds(500, 300, 300, 40);
	b3.setBounds(100, 20, 100, 30);
	l1.setBounds(1000,20,150,30);
	b1.addActionListener(l);
	b2.addActionListener(l);
	b3.addActionListener(l);
	b4.addActionListener(l);b5.addActionListener(l);
	p1.add(l1);
	p1.add(b1);
	p1.add(b2);
	p1.add(b3);p1.add(b4);p1.add(b5);
	getContentPane().add(p1);
	}

	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==b1)
			{
				 cp pw = new cp(user); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				 setVisible(false);
			}
			if(e.getSource()==b5)
			{
				 vptran pw = new vptran(user); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				 setVisible(false);
			}
			if(e.getSource()==b2)
			{
				 vpd pw = new vpd(user); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				 setVisible(false);
			}
			if(e.getSource()==b3)
			{
				 doit pw = new doit(user); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				 setVisible(false);
			}
			if(e.getSource()==b4)
			{
				 sundeb pw = new sundeb(user); // create ButtonFrame
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
		 doit pw = new doit(user); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		 setVisible(false);

	}
	public void b11()
	{
		 cp pw = new cp(user); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		 setVisible(false);

	}
	public void b12()
	{
		 vpd pw = new vpd(user); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		 setVisible(false);

	}
	public void b14()
	{
		 sundeb pw = new sundeb(user); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		 setVisible(false);
	
	}
	public void b15()
	{
		 vptran pw = new vptran(user); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		 setVisible(false);

	}
}
