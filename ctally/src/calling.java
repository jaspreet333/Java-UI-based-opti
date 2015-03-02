import javax.swing.JFrame;
import java.awt.Toolkit; 

public class calling {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mainp boxLayoutFrame = new mainp();
		Toolkit tk=Toolkit.getDefaultToolkit();
		boxLayoutFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 boxLayoutFrame.setSize( (int) tk.getScreenSize().getWidth(),(int) tk.getScreenSize().getHeight());
		 //System.out.println((int) tk.getScreenSize().getWidth()+"  "+(int) tk.getScreenSize().getHeight());
		 // set frame size
		 boxLayoutFrame.setVisible( true ); // display frame
	}

}
