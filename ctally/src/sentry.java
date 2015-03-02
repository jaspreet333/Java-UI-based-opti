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

public class sentry extends JFrame{
	//JButton b1=new JButton("Frame + Lens");
	//JButton b2=new JButton("Lens");
	//JButton b2=new JButton("SunGlasses");
	//JButton b6=new JButton("Contact Lens");
	//JButton b7=new JButton("Lens Solution");
	JButton b5=new JButton("<html><p><b><u>B</b></u>ack</p></html>");
	JButton b3=new JButton("<html><p><b><u>V</b></u>iew Sales of Frame + Lens</p></html>");
	JButton b4=new JButton("<html><p>V<b><u>I</b></u>ew Sales of SunGlasses,Contact Lens, Lens Solution</p></html>");
	JLabel l1=new JLabel();
	JPanel p1=new JPanel();
	String s1;
	public sentry(String s2) {
		// TODO Auto-generated constructor stub
		super("View Sales");
		s1=s2;
		p1.setLayout(null);
		l1.setText("Welcome "+s2);

		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	            KeyStroke.getKeyStroke(KeyEvent.VK_V, 0), "view"); //$NON-NLS-1$
	        getRootPane().getActionMap().put("view", new AbstractAction(){ //$NON-NLS-1$
				@Override
				public void actionPerformed(ActionEvent arg0) {
				view();
				}
	        });

	    	getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	                KeyStroke.getKeyStroke(KeyEvent.VK_I, 0), "view2"); //$NON-NLS-1$
	            getRootPane().getActionMap().put("view2", new AbstractAction(){ //$NON-NLS-1$
	    			@Override
	    			public void actionPerformed(ActionEvent arg0) {
	    			view2();
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
		l1.setBounds(1100, 20, 120, 30);
		b5.setBounds(100, 20, 100, 30);
		//b1.setBounds(500, 60, 300, 40);
		//b2.setBounds(500, 120, 300, 40);
		//b6.setBounds(500, 180, 300, 40);
		//b7.setBounds(500, 240, 300, 40);
		b3.setBounds(450, 100, 400, 40);
		b4.setBounds(450, 200, 400, 40);
		ButtonHandler l=new ButtonHandler();
		//b1.addActionListener(l);
		//b2.addActionListener(l);
		b3.addActionListener(l);
		b4.addActionListener(l);
		b5.addActionListener(l);
		//b6.addActionListener(l);
		//b7.addActionListener(l);
		p1.add(l1);
		//p1.add(b1);
		//p1.add(b2);
		p1.add(b5);
		p1.add(b3);
		p1.add(b4);
		//p1.add(b6);
		//p1.add(b7);
		getContentPane().add(p1);
	}
	
	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			/*if(e.getSource()==b1)
			{
				 sframe pw = new sframe(s1); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			}
			if(e.getSource()==b2||e.getSource()==b6||e.getSource()==b7)
			{
				String op=null;
				if(e.getSource()==b2)
					op="sunglasses";
				if(e.getSource()==b6)
					op="contact lens";
				if(e.getSource()==b7)
					op="solution";
				ssun pw = new ssun(s1,op); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
				
			}
			*/
			if(e.getSource()==b3)
			{
				 vsalfl pw = new vsalfl(s1); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
				
			}
			if(e.getSource()==b4)
			{
				 vsalsun pw = new vsalsun(s1); // create ButtonFrame
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
		 vsalfl pw = new vsalfl(s1); // create ButtonFrame
		 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 Toolkit tk=Toolkit.getDefaultToolkit();
		 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
		 pw.setVisible(true);
		setVisible(false);
	
	}
	public void view2()
	{
		 vsalsun pw = new vsalsun(s1); // create ButtonFrame
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
}
