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


public class ml extends JFrame{

	JPanel p1=new JPanel();
	JButton b1=new JButton("<html><p><b><u>M</b></u>ake Payment Entry</p></html>");
	JButton b2=new JButton("<html><p><b><u>V</b></u>iew Ledger</p></html>");
	JButton b4=new JButton("<html><p><b><u>S</b></u>undry Creditors</p></html>");
	JButton b3=new JButton("<html><p><b><u>B</b></u>ack</p></html>");
	String s1;
	JLabel l1=new JLabel();
	public ml(String s2) {
		// TODO Auto-generated constructor stub
		super("Purchase ");
		p1.setLayout(null);
		ButtonHandler l=new ButtonHandler();
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
			            KeyStroke.getKeyStroke(KeyEvent.VK_M, 0), "b11"); //$NON-NLS-1$
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
								b13();
								}
					        });
		b1.addActionListener(l);
		b2.addActionListener(l);
		b3.addActionListener(l);
		s1=s2;
		l1.setText("Welcome "+s1);
		l1.setBounds(1100, 20, 120, 20);
		b3.setBounds(100, 20, 100, 30);
		b1.setBounds(500,60,300,40);
		b2.setBounds(500,120,300,40);
		b4.setBounds(500,180,300,40);
		p1.add(l1);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);p1.add(b4);
		b4.addActionListener(l);
		getContentPane().add(p1);
		
	}
private class ButtonHandler implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			 mpe pw = new mpe(s1); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 Toolkit tk=Toolkit.getDefaultToolkit();
			 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
			 pw.setVisible(true);
			 setVisible(false);
		}
		if(e.getSource()==b2)
		{
			 vl pw = new vl(s1); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 Toolkit tk=Toolkit.getDefaultToolkit();
			 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
			 pw.setVisible(true);
			 setVisible(false);
		}
		if(e.getSource()==b3)
		{
			doit pw = new doit(s1); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 Toolkit tk=Toolkit.getDefaultToolkit();
			 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
			 pw.setVisible(true);
			 setVisible(false);
		}
		if(e.getSource()==b4)
		{
			 scred pw = new scred(s1); // create ButtonFrame
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
	doit pw = new doit(s1); // create ButtonFrame
	 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	 Toolkit tk=Toolkit.getDefaultToolkit();
	 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
	 pw.setVisible(true);
	 setVisible(false);

}
public void b11()
{
	 mpe pw = new mpe(s1); // create ButtonFrame
	 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	 Toolkit tk=Toolkit.getDefaultToolkit();
	 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
	 pw.setVisible(true);
	 setVisible(false);

}
public void b12()
{
	 vl pw = new vl(s1); // create ButtonFrame
	 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	 Toolkit tk=Toolkit.getDefaultToolkit();
	 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
	 pw.setVisible(true);
	 setVisible(false);

}
public void b13()
{
	 scred pw = new scred(s1); // create ButtonFrame
	 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	 Toolkit tk=Toolkit.getDefaultToolkit();
	 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
	 pw.setVisible(true);
	 setVisible(false);

}
}
