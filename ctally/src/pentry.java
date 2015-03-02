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

public class pentry extends JFrame{
	JButton b1=new JButton("<html><p><b><u>F</b></u>rame</p></html>");
	JButton b2=new JButton("<html><p><b><u>L</b></u>ens</p></html>");
	JButton b3=new JButton("<html><p><b><u>S</b></u>unGlasses</p></html>");
	JButton b6=new JButton("<html><p><b><u>C</b></u>ontact Lens</p></html>");
	JButton b7=new JButton("<html><p>L<b><u>E</b></u>ns Solution</p></html>");
	JButton b4=new JButton("<html><p><b><u>V</b></u>iew Purchase</p></html>");
	JButton b5=new JButton("<html><p><b><u>B</b></u>ack</p></html>");
	JLabel l1=new JLabel();
	JPanel p1=new JPanel();
	String s1; 
	public pentry(String s2) {
		// TODO Auto-generated constructor stub
	super("Purchase");
		s1=s2;
	p1.setLayout(null);
	getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
            KeyStroke.getKeyStroke(KeyEvent.VK_V, 0), "view"); //$NON-NLS-1$
        getRootPane().getActionMap().put("view", new AbstractAction(){ //$NON-NLS-1$
			@Override
			public void actionPerformed(ActionEvent arg0) {
			view();
			}
        });
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	            KeyStroke.getKeyStroke(KeyEvent.VK_B, 0), "back"); //$NON-NLS-1$
	        getRootPane().getActionMap().put("back", new AbstractAction(){ //$NON-NLS-1$
				@Override
				public void actionPerformed(ActionEvent arg0) {
				back();
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
		            KeyStroke.getKeyStroke(KeyEvent.VK_F, 0), "frame"); //$NON-NLS-1$
		        getRootPane().getActionMap().put("frame", new AbstractAction(){ //$NON-NLS-1$
					@Override
					public void actionPerformed(ActionEvent arg0) {
					pur("frame");
					}
		        });
		        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
			            KeyStroke.getKeyStroke(KeyEvent.VK_L, 0), "lens"); //$NON-NLS-1$
			        getRootPane().getActionMap().put("lens", new AbstractAction(){ //$NON-NLS-1$
						@Override
						public void actionPerformed(ActionEvent arg0) {
						pur("lens");
						}
			        });
			        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				            KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "sun"); //$NON-NLS-1$
				        getRootPane().getActionMap().put("sun", new AbstractAction(){ //$NON-NLS-1$
							@Override
							public void actionPerformed(ActionEvent arg0) {
							pur("sunglasses");
							}
				        });
				        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
					            KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "con"); //$NON-NLS-1$
					        getRootPane().getActionMap().put("con", new AbstractAction(){ //$NON-NLS-1$
								@Override
								public void actionPerformed(ActionEvent arg0) {
								pur("contact lens");
								}
					        });
					        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
						            KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), "sol"); //$NON-NLS-1$
						        getRootPane().getActionMap().put("sol", new AbstractAction(){ //$NON-NLS-1$
									@Override
									public void actionPerformed(ActionEvent arg0) {
									pur("solution");
									}
						        });
						        
	        
	        l1.setText("Welcome "+s2);
	l1.setBounds(1100, 20, 100, 30);
	b1.setBounds(500, 60, 300, 40);
	b2.setBounds(500, 120, 300, 40);
	b3.setBounds(500, 180, 300, 40);
	b6.setBounds(500, 240, 300, 40);
	b7.setBounds(500, 300, 300, 40);
	b4.setBounds(500, 360, 300, 40);
	b5.setBounds(100, 20, 100, 30);
	ButtonHandler l=new ButtonHandler();
	b1.addActionListener(l);
	b2.addActionListener(l);
	b3.addActionListener(l);
	b4.addActionListener(l);
	b5.addActionListener(l);
	b6.addActionListener(l);
	b7.addActionListener(l);
	p1.add(l1);
	p1.add(b1);
	p1.add(b2);
	p1.add(b3);
	p1.add(b4);
	p1.add(b5);
	p1.add(b6);
	p1.add(b7);
	getContentPane().add(p1);
	}
private class ButtonHandler implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	if(e.getSource()==b1||e.getSource()==b2||e.getSource()==b3||e.getSource()==b6||e.getSource()==b7)
	{
		String op = null;
		if(e.getSource()==b1)
		{
			op="frame"; 
		
		}
		if(e.getSource()==b2)
		{
			op="lens"; 
			
		}
		if(e.getSource()==b3)
		{
			op="sunglasses"; 
		}
		if(e.getSource()==b6)
		{
			op="contact lens"; 
		}
		if(e.getSource()==b7)
		{
			op="solution"; 
		}
		 pframe pw = new pframe(s1,op); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		 setVisible(false);
	}
		if(e.getSource()==b4)
		{
			 vpur pw = new vpur(s1); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 Toolkit tk=Toolkit.getDefaultToolkit();
			 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
			 pw.setVisible(true);
			setVisible(false);
		}
		if(e.getSource()==b5)
		{
			doit pw = new doit(s1); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 Toolkit tk=Toolkit.getDefaultToolkit();
			 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
			 pw.setVisible(true);
			 setVisible(false);
		}
		
	}
	
}
public void view()
{
	 vpur pw = new vpur(s1); // create ButtonFrame
	 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	 Toolkit tk=Toolkit.getDefaultToolkit();
	 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
	 pw.setVisible(true);
	setVisible(false);

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
public void pur(String op2)
{

	 pframe pw = new pframe(s1,op2); // create ButtonFrame
	 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	 Toolkit tk=Toolkit.getDefaultToolkit();
	 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
	 pw.setVisible(true);
	 setVisible(false);
}

}
