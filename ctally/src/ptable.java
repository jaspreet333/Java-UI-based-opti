import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.logging.Level;

import javax.swing.JTable;


public class ptable {
    MessageFormat header = new MessageFormat("CITY OPTICALS");
    MessageFormat footer = new MessageFormat("Page{0,number,integer}");
    public ptable(JTable table_employee){
    try {
    table_employee.print(JTable.PrintMode.FIT_WIDTH, header, footer);
} catch (java.awt.print.PrinterAbortException e) {
} catch (PrinterException ex) {
    //Logger.getLogger(employee_info.class.getName()).log(Level.SEVERE, null, ex);
}
}
}
