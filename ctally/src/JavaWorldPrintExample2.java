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

public class JavaWorldPrintExample2 {
	private final static int POINTS_PER_INCH = 72;
	String head="CITY OPTICALS";
	String t1=null;
	String t2=null;
	String t3=null;
	String t4=null;
	String t5=null;
	String t6=null;
	//String t7;
	//String t8;
	
	public JavaWorldPrintExample2(String a1, String a2, String a3, String a4, String a5, String a6) {

	    t1=a1;
	    t2=a2;
	    t3=a3;
	    t4=a4;
	    t5=a5;
	    t6=a6;
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
	      titleFont = new Font("helvetica", Font.BOLD, 20);
	      g2d.setFont(titleFont);
	      for(int i=0;i<pageFormat.getImageableWidth();i+=5)
	      g2d.drawLine(i, 70, i+5, 70);
	      g2d.drawString("Dop",  140, 90);
	      g2d.drawString(t1, 200, 90);
	      g2d.drawString("PID",  20, 90);
	      g2d.drawString(t2, 80, 90);
	      for(int i=0;i<pageFormat.getImageableWidth();i+=5)
		      g2d.drawLine(i, 120, i+5, 120);
	      g2d.drawString("Company",  20, 140);
	      g2d.drawString(t3, 120, 140);
	      g2d.drawString("Product",  20, 200);
	      g2d.drawString(t4, 120, 200);
	      g2d.drawString("CP",  20, 240);
	      g2d.drawString(t5, 120, 240);
	      g2d.drawString("Details", (int)pageFormat.getImageableWidth()-120 ,(int) pageFormat.getImageableHeight()-80);
	      g2d.drawString(t6, (int)pageFormat.getImageableWidth()-120 ,(int) pageFormat.getImageableHeight()-60);
	      
	      return (PAGE_EXISTS);
	    }
	  }
}
