	import java.awt.BasicStroke;
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

public class printingtemplatesales {


		private final static int POINTS_PER_INCH = 72;
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


	

	
	public printingtemplatesales(String dop, String sid, String voucherno,
			String name, String clens, String plens, String cframe,
			String pframe, String tp) {
		// TODO Auto-generated constructor stub
	    t1=dop;
	    t2=sid;
	    t3=voucherno;
	    t4=name;
	    t5=clens;
	    t6=plens;
		t7=cframe;
		t8=pframe;
		t9=tp;
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
	      Rectangle2D.Double border = new Rectangle2D.Double(0, 0, pageFormat
	          .getImageableWidth(), pageFormat.getImageableHeight());
	      g2d.draw(border);

	      //--- Print the title
	     // String titleText = "Printing in Java Part 2";
	      Font titleFont = new Font("helvetica", Font.BOLD, 36);
	      g2d.setFont(titleFont);

	      //--- Compute the horizontal center of the page
	      FontMetrics fontMetrics = g2d.getFontMetrics();
	      double titleX1 = (pageFormat.getImageableWidth() / 2)
	          - (fontMetrics.stringWidth(head) / 2);
	      double titleY1 = 30;
	      g2d.drawString(head, (int) titleX1, (int) titleY1);
	      titleFont = new Font("helvetica", Font.BOLD, 12);
	      g2d.setFont(titleFont);
	      for(int i=0;i<pageFormat.getImageableWidth();i+=5)
	      g2d.drawLine(i, 70, i+5, 70);
	      g2d.drawString("Date",  (int)pageFormat.getImageableWidth()-120, 90);
	      g2d.drawString(t1, (int)pageFormat.getImageableWidth()-75, 90);
	      g2d.drawString("SID",  20, 55);
	      g2d.drawString(t2, 80, 55);
	      g2d.drawString("Voucher NO",  20, 90);
	      g2d.drawString(t3, 100, 90);
	      for(int i=0;i<pageFormat.getImageableWidth();i+=5)
		      g2d.drawLine(i, 110, i+5, 110);
	      g2d.drawString("Name",  20, 130);
	      g2d.drawString(t4, 120, 130);
	      g2d.drawLine(0, 160, (int) pageFormat.getImageableWidth(), 160);
	      g2d.drawLine(0, 190, (int) pageFormat.getImageableWidth(), 190);
	      g2d.drawString("Product",  20, 175);
	      g2d.drawString("Brand",  200, 175);
	      g2d.drawString("Cost", (int) pageFormat.getImageableWidth()-80, 175);
	      g2d.drawString("Lens",  20, 220);
	      g2d.drawString(t5, 200, 220);
	      //g2d.drawString("Lens Price",  200, 210);
	      g2d.drawString(t6,  (int) pageFormat.getImageableWidth()-80, 220);
	      g2d.drawString("Frame ",  20, 260);
	      g2d.drawString(t7, 200, 260);
	      //g2d.drawString("Frame Price",  200, 240);
	      g2d.drawString(t8,  (int) pageFormat.getImageableWidth()-80, 260);
	      g2d.drawString("Bill Amount",   (int) pageFormat.getImageableWidth()-160, 350);
	      g2d.drawString(t9,  (int) pageFormat.getImageableWidth()-60, 350);
	      g2d.drawLine((int) pageFormat.getImageableWidth()-80, 330, (int) pageFormat.getImageableWidth(), 330);
	      g2d.drawLine((int) pageFormat.getImageableWidth()-80, 360, (int) pageFormat.getImageableWidth(), 360);
	      //g2d.drawString("Detail", (int)pageFormat.getImageableWidth()-120 ,(int) pageFormat.getImageableHeight()-80);
	      //g2d.drawString(t6, (int)pageFormat.getImageableWidth()-120 ,(int) pageFormat.getImageableHeight()-60);
	      g2d.drawString("Authorized Signatury",  (int) pageFormat.getImageableWidth()-150, 450);
	      g2d.drawString("for CITY OPTICALS",  (int) pageFormat.getImageableWidth()-150, 520);
	      return (PAGE_EXISTS);
	    }
	  }	
}