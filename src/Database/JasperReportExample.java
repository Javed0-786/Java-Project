import java.util.HashMap;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JasperReportExample {
    public static void main(String[] args) {
        try {
            // Load the Jasper report
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile("Report.jrxml");

            // Create a data source from the array
            String[] name = { "John Doe", "Jane Smith", "Bob Johnson" };
            String[] department = { "IT", "HR", "Sales" };
            String[] section = { "A", "B", "C" };
            Integer[] reg_no = { 101, 102, 103 };
            // Add more arrays for other fields as needed

            Object[][] data = { name, department, section, reg_no };
            JRDataSource dataSource = new JRBeanArrayDataSource(data);

            // Fill the report with data
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource);

            // Show the report in a viewer
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
