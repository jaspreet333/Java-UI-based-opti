import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;



public class printingtemplatebill {

	String head="CITY OPTICALS";
	String t1=null;
	String t2=null;
	String t3=null;
	String t4=null;
	String t5=null;
	String t6=null;
	String t7=null;
	String t8=null;
	String t9=null;
	String t10=null;
	String t11=null;
	String t12=null;
	String t13=null;
	String t14=null;
	String t15=null;
	//String t9=null;
	
	public printingtemplatebill(String date, String billno, String name, String p1,
			String a1, String p2, String a2, String p3, String a3,
			String p4, String a4, String p5, String a5, String adv, String amt) {
		// TODO Auto-generated constructor stub
	    t1=date;
	    t2=billno;
	    t3=name;
	    t4=p1;
	    t5=a1;
	    t6=p2;
		t7=a2;
		t8=p3;
		t9=a3;
		t10=p4;
		t11=a4;
		t12=p5;
		t13=a5;
		t14=adv;
		t15=amt;
		//System.out.println(t14+" "+t15);
		//--- Create a new PrinterJob object
	    PrinterJob printJob = PrinterJob.getPrinterJob();
	    //System.out.println(t1+t2+t3+t4+t5+t6);
	    //--- Create a new book to add pages to
	    Book book = new Book();

	    //--- Add the cover page using the default page format for this print
	    // job
	    book.append(new IntroPage(), printJob.defaultPage());

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
	private class IntroPage implements Printable {

	    /**
	     * Method: print
	     * <p>
	     * 
	     * @param g
	     *            a value of type Graphics
	     * @param pageFormat
	     *            a value of type PageFormat
	     * @param page
	     *            a value of type int
	     * @return a value of type int
	     */
	    public int print(Graphics g, PageFormat pageFormat, int page) {

	      //--- Create the Graphics2D object
	      Graphics2D g2d = (Graphics2D) g;
	      //String s1=t1;
	      //--- Translate the origin to 0,0 for the top left corner
	      g2d.translate(pageFormat.getImageableX(), pageFormat
	          .getImageableY());

	      //--- Set the default drawing color to black
	      g2d.setPaint(Color.black);

	      //--- Draw a border arround the page
	      Rectangle2D.Double border = new Rectangle2D.Double(0, 180, pageFormat
	          .getImageableWidth()-10, pageFormat.getImageableHeight()-180);
	      g2d.draw(border);

	      //--- Print the title
	     // String titleText = "Printing in Java Part 2";
	      Font titleFont = new Font("helvetica", Font.BOLD, 36);
	      g2d.setFont(titleFont);
	      FontMetrics fontMetrics = g2d.getFontMetrics();
	      double titleX1 = (pageFormat.getImageableWidth() / 2)
		          - (fontMetrics.stringWidth(head) / 2);
	      
	      //--- Compute the horizontal center of the page
	      
	      
	      double titleY1 = 50;
	      g2d.drawString(head, (int) titleX1, (int) titleY1);
	      titleFont = new Font("helvetica", Font.BOLD, 22);
	      g2d.setFont(titleFont);fontMetrics = g2d.getFontMetrics();
	      String addr1="Shop No. 7, Vikas Rekha Complex ";
	      titleX1 = (pageFormat.getImageableWidth() / 2)
		          - (fontMetrics.stringWidth(addr1) / 2);
	      titleY1 = 95;
	      g2d.drawString(addr1, (int) titleX1, (int) titleY1);
	      String addr2=" Khatiwala Tank, INDORE";
	      titleX1 = (pageFormat.getImageableWidth() / 2)
		          - (fontMetrics.stringWidth(addr2) / 2);
	      titleY1 = 115;
	      g2d.drawString(addr2, (int) titleX1, (int) titleY1);
	      titleFont = new Font("helvetica", Font.BOLD, 16);
	      g2d.setFont(titleFont);fontMetrics = g2d.getFontMetrics();
	      String addr3="EmailID: quersh.panbihar@gmail.com"; 
	      String addr4="Mob No:+91 94066 82786  Shop No:0731-2368043 ";
	      titleX1 = (pageFormat.getImageableWidth() / 2)
		          - (fontMetrics.stringWidth(addr3) / 2);
	      titleY1 = 135;
	      g2d.drawString(addr3, (int) titleX1, (int) titleY1);
	      String addr45="Mob No:+91 94066 82786  Shop:0731-2368043 ";
	      titleX1 = (pageFormat.getImageableWidth() / 2)
		          - (fontMetrics.stringWidth(addr45) / 2);
	      titleY1 = 155;
	      g2d.drawString(addr45, (int) titleX1, (int) titleY1);
	      
	      titleFont = new Font("helvetica", Font.BOLD, 12);
	      g2d.setFont(titleFont);
	      fontMetrics = g2d.getFontMetrics();
	      titleX1 = (pageFormat.getImageableWidth() / 2)
		          - (fontMetrics.stringWidth("Order & Estimates") / 2);
	      g2d.drawString("Order & Estimates", (int) titleX1, 10);
	      titleFont = new Font("helvetica", Font.BOLD, 8);
	      g2d.setFont(titleFont);
	      for(int i=0;i<pageFormat.getImageableWidth()-10;i+=5)
	      g2d.drawLine(i, 260, i+5, 260);
	      g2d.drawLine((int)pageFormat.getImageableWidth()-160, 220, (int)pageFormat.getImageableWidth()-10, 220);
	      g2d.drawLine((int)pageFormat.getImageableWidth()-160, 180, (int)pageFormat.getImageableWidth()-160, 260);
	      //System.out.println("Widht :"+pageFormat.getImageableWidth()+" Height:"+pageFormat.getImageableHeight());
	      g2d.drawString("Date",  (int)pageFormat.getImageableWidth()-150, 230);
	      
	      g2d.drawString("Bill No",  (int)pageFormat.getImageableWidth()-150, 195);
	      
	      g2d.drawString("Buyer's Name",  20, 195);
	      
	      for(int i=0;i<pageFormat.getImageableWidth()-10;i+=5)
		      g2d.drawLine(i, 285, i+5, 285);
	      g2d.drawString("Description of Goods",  110, 270);
	      g2d.drawString("Price",(int) pageFormat.getImageableWidth()-100  , 270);
	      //g2d.drawString("Cost", , 175);
	      
	      g2d.drawLine((int) pageFormat.getImageableWidth()-160, 260, (int) pageFormat.getImageableWidth()-160, 500);
	      g2d.drawLine(0, 480, (int) pageFormat.getImageableWidth()-10, 480);
	      g2d.drawLine(0, 500, (int) pageFormat.getImageableWidth()-10, 500);
	      g2d.drawString("Less Advance", (int) pageFormat.getImageableWidth()-200 , 520);
	      g2d.drawString("Net Balance", (int) pageFormat.getImageableWidth()-200 , 535);
	      
	      
	      
	      //System.out.println("Im m here "+Integer.toString((int)((double)Integer.parseInt(t15)-Double.parseDouble(t14))));
	      g2d.drawString("Total", (int) pageFormat.getImageableWidth()-200 , 492);
	      
	      //g2d.drawString("Lens Price",  200, 210);
	      //g2d.drawString(t6,  (int) pageFormat.getImageableWidth()-80, 220);
	      //g2d.drawString("Frame ",  20, 260);
	      //g2d.drawString(t7, 200, 260);
	      //g2d.drawString("Frame Price",  200, 240);
	      //g2d.drawString(t8,  (int) pageFormat.getImageableWidth()-80, 260);
	      //g2d.drawString("Bill Amount",   (int) pageFormat.getImageableWidth()-160, 350);
	      //g2d.drawString(t9,  (int) pageFormat.getImageableWidth()-60, 350);
	      g2d.drawLine((int) pageFormat.getImageableWidth()-170, (int) pageFormat.getImageableHeight()-50, (int) pageFormat.getImageableWidth()-10, (int) pageFormat.getImageableHeight()-50);
	      g2d.drawLine((int) pageFormat.getImageableWidth()-170, (int) pageFormat.getImageableHeight()-50, (int) pageFormat.getImageableWidth()-170, (int) pageFormat.getImageableHeight());
	      //g2d.drawString("Detail", (int)pageFormat.getImageableWidth()-120 ,(int) pageFormat.getImageableHeight()-80);
	      //g2d.drawString(t6, (int)pageFormat.getImageableWidth()-120 ,(int) pageFormat.getImageableHeight()-60);
	      g2d.drawString("Authorised Signatory",  (int) pageFormat.getImageableWidth()-100, (int) pageFormat.getImageableHeight()-10);
	      g2d.drawString("for CITY OPTICALS",  (int) pageFormat.getImageableWidth()-130, (int) pageFormat.getImageableHeight()-40);
	      titleFont = new Font("helvetica", Font.BOLD, 7);
	      g2d.setFont(titleFont);
	      fontMetrics = g2d.getFontMetrics();
	      g2d.drawString("Declaration",  2, (int) pageFormat.getImageableHeight()-40);
	      g2d.drawString("We declare that this invoice shows the actual price of the goods",  2, (int) pageFormat.getImageableHeight()-30);
	      g2d.drawString("described and that all particulars are true and correct.",  2, (int) pageFormat.getImageableHeight()-20);
	      g2d.drawString("*Goods once sold won't be returned",  10, (int) pageFormat.getImageableHeight()-55);
	      titleFont = new Font("helvetica", Font.ITALIC, 7);
	      g2d.setFont(titleFont);
	      fontMetrics = g2d.getFontMetrics();
	    //  g2d.drawString("E. & O.E", (int) pageFormat.getImageableWidth()-100, 507);
	      titleFont = new Font("helvetica", Font.BOLD, 12);
	      g2d.setFont(titleFont);
	      fontMetrics = g2d.getFontMetrics();
	      g2d.drawString("*SUBJECT TO INDORE JURISDICTION",  10, (int) pageFormat.getImageableHeight()-70);
	      titleFont = new Font("helvetica", Font.BOLD, 15);
	      g2d.setFont(titleFont);
	      fontMetrics = g2d.getFontMetrics();
	      g2d.drawString(t1, (int)pageFormat.getImageableWidth()-150, 248);
	      g2d.drawString(t2, (int)pageFormat.getImageableWidth()-150, 210);
	      g2d.drawString(t3, 20, 220);
	      if(!t4.equals("null"))
	      {
	    	  g2d.drawString(t4,  20, 300);
	    	  g2d.drawString(t5, (int) pageFormat.getImageableWidth()-100, 300);
	      }
	      if(!t6.equals("null"))
	      {
	    	  g2d.drawString(t6,  20, 320);
	    	  g2d.drawString(t7, (int) pageFormat.getImageableWidth()-100, 320);
	      }
	      if(!t8.equals("null"))
	      {
	    	  g2d.drawString(t8,  20, 340);
	    	  g2d.drawString(t9, (int) pageFormat.getImageableWidth()-100, 340);
	      }
	      if(!t10.equals("null"))
	      {
	    	  g2d.drawString(t10,  20, 360);
	    	  g2d.drawString(t11, (int) pageFormat.getImageableWidth()-100, 360);
	      }
	      if(!t12.equals("null"))
	      {
	    	  g2d.drawString(t12,  20, 380);
	    	  g2d.drawString(t13, (int) pageFormat.getImageableWidth()-100, 380);
	      }

	      g2d.drawString(Integer.toString((Integer.parseInt(t15)-Integer.parseInt(t14))), (int) pageFormat.getImageableWidth()-100 , 535);
	      titleX1 = (pageFormat.getImageableWidth() -100)
		          + (fontMetrics.stringWidth(Integer.toString((Integer.parseInt(t15)-Integer.parseInt(t14))))-fontMetrics.stringWidth(Integer.toString(Integer.parseInt(t14))));
	      g2d.drawLine((int) pageFormat.getImageableWidth()-125, 520 , (int) pageFormat.getImageableWidth()-50, 520);
	      g2d.drawLine((int) pageFormat.getImageableWidth()-125, 538, (int) pageFormat.getImageableWidth()-50, 538);
	      
	      g2d.drawString(Integer.toString(Integer.parseInt(t14)), (int) titleX1, 520);
	      g2d.drawString(t15, (int) pageFormat.getImageableWidth()-100, 495);
	      
	      
	      return (PAGE_EXISTS);
	    }
	  }	

}
