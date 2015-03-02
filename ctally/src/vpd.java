import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.TableModel;




public class vpd extends JFrame{

	JPanel p1=new JPanel();
	JLabel l1=new JLabel("Name");
	JScrollPane scrollPane;
	//JLabel l0=new JLabel();
	JComboBox t1;
	String[] ar=new String[20];
	JLabel l2=new JLabel();
	//ArrayList<String> ar = new ArrayList<String>();
	Connection d;
	Statement stm=null;
	String s1;
	JTable table1;
	gcon k=new gcon();
	JButton b1=new JButton("Ok");
	JButton b2=new JButton("Back");
	JButton b3=new JButton("Delete Selected Patient Details");
	JButton b4=new JButton("Print");
	JButton b5=new JButton("Update");
	ImageIcon image;
	JLabel imageLabel = new JLabel(); 
	ImageIcon printImage;
	public vpd(String user) {
		// TODO Auto-generated constructor stub
		super("Patient Details");
		p1.setLayout(null);
		d=k.getDBConnection();
		s1=user;
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
		imageLabel.setBounds(10, 170, 1000, 420);
		imageLabel.setVisible(false);
		try
		{
			String sql="Select cid,name from pdet";
			stm=d.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				String eid= rs.getString("cid");
				String name = rs.getString("name");
				ar[i]=eid+" .)"+name;
				i++;
			}
		 
		}
		catch(SQLException fe)
		{
			fe.printStackTrace();
		}
		p1.setLayout(null);
		t1=new JComboBox(ar);
		l2.setText( "Welcome "+s1);
		l2.setBounds(1100, 20, 120, 30);
		l1.setBounds(300, 60, 300, 40);
		t1.setBounds(700, 60, 300, 40);
		b1.setBounds(300,120,200,30);
		b2.setBounds(600,120,200,30);
		b3.setBounds(900,120,250,30);
		b4.setBounds(1100,240,250,30);
		b5.setBounds(1100,360,250,30);
		ButtonHandler l =new ButtonHandler();
		b1.addActionListener(l);
		b2.addActionListener(l);
		b3.addActionListener(l);
		b4.addActionListener(l);
		b5.addActionListener(l);
		b4.setVisible(false);b5.setVisible(false);
		p1.add(b3);p1.add(b4);p1.add(b5);
		p1.add(l2);
		p1.add(l1);
		p1.add(t1);
		p1.add(b1);
		p1.add(b2);
		p1.add(imageLabel);
		getContentPane().add(p1);
	}
	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			if(e.getSource()==b1)
			{
				int co=0;	
				String s4=((String)t1.getSelectedItem()).substring(0, 2);
				
				String imagep=null;
				try
				{
					String sql="Select prescri from pdet where cid ="+s4;
					stm=d.createStatement();
					ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						imagep = rs.getString("prescri");
						
						
					}
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
				//image=Toolkit.getDefaultToolkit().getImage(imagep);;
				image = new ImageIcon(imagep);
				//ImageIcon imageIcon = new ImageIcon("./img/imageName.png"); // load the image to a imageIcon
				Image image1 = image.getImage(); // transform it 
				Image newimg = image1.getScaledInstance(1000, 420,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				image = new ImageIcon(newimg); 
				imageLabel.setIcon( image);
				imageLabel.repaint();
				imageLabel.setVisible(true);
				b4.setVisible(true);
				b5.setVisible(true);
				//getContentPane().add(p1);
				
			}
			
			if(e.getSource()==b2)
				{
				try {
					d.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				pdet pw = new pdet(s1); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
				}
			if(e.getSource()==b3)
			{
				
				String k1=((String)t1.getSelectedItem()).substring(0, 2);
				//System.out.println(k1);
				d=k.getDBConnection();
				try
				{
					String sql="delete from pdet where cid="+k1;
					stm=d.createStatement();
					stm.executeUpdate(sql);
					
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
				//p1.remove(scrollPane);
				
				/*workeropt pw = new workeropt(s1); // create ButtonFrame
			 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			 pw.setSize( 400, 200 ); // set frame size
			 pw.setVisible(true);
			setVisible(false);
			*/
				try {
					d.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 pdet pw = new pdet(s1); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			}
			if(e.getSource()==b4)
			{
				//PrintService service = PrintServiceLookup.lookupDefaultPrintService();
				
			    String image=null;
			    d=k.getDBConnection(); 
			    String s4=((String)t1.getSelectedItem()).substring(0, 2);
				
				//String imagep=null;
				try
				{
					String sql="Select prescri from pdet where cid ="+s4;
					stm=d.createStatement();
					ResultSet rs=stm.executeQuery(sql);
					while(rs.next())
					{
						image = rs.getString("prescri");
						
						
					}
				}
				catch(SQLException fe)
				{
					fe.printStackTrace();
				}
			    printImage = new javax.swing.ImageIcon(image);
			    PrinterJob printJob = PrinterJob.getPrinterJob();
			    //System.out.println(t1+t2+t3+t4+t5+t6);
			    //--- Create a new book to add pages to
			    Book book = new Book();

			    //--- Add the cover page using the default page format for this print
			    // job
			    book.append(new MyPrintable(), printJob.defaultPage());

			    //--- Add the document page using a landscape page format
			    PageFormat documentPageFormat = new PageFormat();
			    documentPageFormat.setOrientation(PageFormat.LANDSCAPE);
			   // book.append(new Document(), documentPageFormat);

			    //--- Tell the printJob to use the book as the pageable object
			    printJob.setPageable(book);

			    //--- Show the print dialog box. If the user click the
			    //--- print button we then proceed to print else we cancel
			    //--- the process.
			    if (printJob.printDialog()) {
			      try {
			        printJob.print();
			      } catch (Exception PrintException) {
			        PrintException.printStackTrace();
			      }
			    }
			}
			if(e.getSource()==b5)
			{
				 String s4=((String)t1.getSelectedItem()).substring(0, 2);
				 try {
					d.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 dpd pw = new dpd(s1,s4); // create ButtonFrame
				 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				 Toolkit tk=Toolkit.getDefaultToolkit();
				 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
				 pw.setVisible(true);
				setVisible(false);
			}
		}
		
	}
	class MyPrintable implements Printable {
		  //ImageIcon printImage = new javax.swing.ImageIcon("a.gif");

		  public int print(Graphics g, PageFormat pf, int pageIndex) {
		    Graphics2D g2d = (Graphics2D) g;
		    g.translate((int) (pf.getImageableX()), (int) (pf.getImageableY()));
		    if (pageIndex == 0) {
		      double pageWidth = pf.getImageableWidth();
		      double pageHeight = pf.getImageableHeight();
		      double imageWidth = printImage.getIconWidth();
		      double imageHeight = printImage.getIconHeight();
		      double scaleX = pageWidth / imageWidth;
		      double scaleY = pageHeight / imageHeight;
		      double scaleFactor = Math.min(scaleX, scaleY);
		      g2d.scale(scaleFactor, scaleFactor);
		      g.drawImage(printImage.getImage(), 0, 0, null);
		      return Printable.PAGE_EXISTS;
		    }
		    return Printable.NO_SUCH_PAGE;
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
	pdet pw = new pdet(s1); // create ButtonFrame
	 pw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	 Toolkit tk=Toolkit.getDefaultToolkit();
	 pw.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight()); // set frame size
	 pw.setVisible(true);
	setVisible(false);

}
public void yes()
{
	int co=0;	
	String s4=((String)t1.getSelectedItem()).substring(0, 2);
	
	String imagep=null;
	try
	{
		String sql="Select prescri from pdet where cid ="+s4;
		stm=d.createStatement();
		ResultSet rs=stm.executeQuery(sql);
		while(rs.next())
		{
			imagep = rs.getString("prescri");
			
			
		}
	}
	catch(SQLException fe)
	{
		fe.printStackTrace();
	}
	//image=Toolkit.getDefaultToolkit().getImage(imagep);;
	image = new ImageIcon(imagep);
	imageLabel.setIcon( image);
	imageLabel.setVisible(true);
	b4.setVisible(true);
	b5.setVisible(true);
	//getContentPane().add(p1);

}

private Image getScaledImage(Image srcImg, int w, int h){
    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = resizedImg.createGraphics();
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(srcImg, 0, 0, w, h, null);
    g2.dispose();
    return resizedImg;
}

}
