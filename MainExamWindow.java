import java.sql.ResultSet;

// import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
// import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import javax.swing.plaf.metal.MetalTabbedPaneUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

class MainExamWindow extends JFrame {
    private JTextField regField;
    private JButton feedMarskButton;
    private JButton updateMarksButton;
    private JButton deleteRecordButton;

    public MainExamWindow() {
        super("Administration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        feedMarskButton = new JButton("Feed Marks");
        updateMarksButton = new JButton("Update ");
        deleteRecordButton = new JButton("Delete Student");

        feedMarskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the add student window
                FeedMarksWindow feedMarksWindow = new FeedMarksWindow();
                feedMarksWindow.setVisible(true);
            }
        });

        updateMarksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the update student window
                UpdateStudentWindow updateStudentWindow = new UpdateStudentWindow();
                updateStudentWindow.setVisible(true);
            }
        });

        deleteRecordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the delete student window
                DeleteStudentWindow deleteStudentWindow = new DeleteStudentWindow();
                deleteStudentWindow.setVisible(true);
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
        JLabel nameLabel = new JLabel("Enter Registration Number: ");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPanel.add(nameLabel);
        regField = new JTextField();
        regField.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPanel.add(regField);
        buttonPanel.add(feedMarskButton);
        buttonPanel.add(updateMarksButton);
        buttonPanel.add(deleteRecordButton);

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}

// class FeedMarksWindow extends JFrame {

// private JTextField cNameField;
// private JTextField cCodeField;
// private JTextField CA1Field;
// private JTextField CA2Field;
// private JTextField CA3Field;
// private JTextField MTEField;
// private JTextField ETEField;

// private JButton addButton;

// public FeedMarksWindow() {
// super("Add Student");
// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
// setSize(400, 300);

// JPanel panel = new JPanel(new GridLayout(9, 2));
// // row one
// panel.add(new JLabel("Name: "));
// panel.add(new JLabel("Reg_no: "));
// // row two
// panel.add(new JLabel("Roll_no: "));
// panel.add(new JLabel("Section: "));
// // row three
// panel.add(new JLabel("Dept: "));
// // panel.add(new JLabel("Section: "));

// // row four
// panel.add(new JLabel("Course Code"));
// panel.add(new JLabel("Course Name"));
// // row five
// cCodeField = new JTextField();
// panel.add(cCodeField);
// cNameField = new JTextField();
// panel.add(cNameField);

// // row six
// panel.add(new JLabel("CA1"));
// panel.add(new JLabel("CA2"));
// panel.add(new JLabel("CA3"));
// // row seven
// CA1Field = new JTextField();
// panel.add(CA1Field);
// CA2Field = new JTextField();
// panel.add(CA2Field);
// CA3Field = new JTextField();
// panel.add(CA3Field);

// // row eight
// panel.add(new JLabel("MTE"));
// panel.add(new JLabel("ETE"));
// // row nine
// MTEField = new JTextField();
// panel.add(MTEField);
// ETEField = new JTextField();
// panel.add(ETEField);

// // row ten
// addButton = new JButton("Feed Marks");
// addButton.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
// // Get the values from the text fields
// String cCode = cCodeField.getText();
// String cName = cNameField.getText();
// String CA1 = CA1Field.getText();
// String CA2 = CA2Field.getText();
// String CA3 = CA3Field.getText();
// String MTE = MTEField.getText();
// String ETE = ETEField.getText();

// // Add the student to the database or file

// // Database db = new Database();
// // if (db.InsertStudentData(name, department, regNumber, rollNumber, section,
// // fatherName, address,
// // mobNumber) > 0)
// // dispose();

// // Close the window
// }
// });
// panel.add(addButton);
// add(panel, BorderLayout.CENTER);

// setVisible(true);
// }
// }

class FeedMarksWindow extends JFrame {

    private JTextField cNameField;
    private JTextField cCodeField;
    private JTextField CA1Field;
    private JTextField CA2Field;
    private JTextField CA3Field;
    private JTextField MTEField;
    private JTextField ETEField;
    private JTextField nameField;
    private JTextField regField;
    private JTextField rollField;
    private JTextField deptField;
    private JTextField sectionField;

    private JButton addButton;

    public FeedMarksWindow() {
        super("Add Student");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel(new GridLayout(12, 2));
        // row one
        panel.add(new JLabel("Reg_no: "));
        regField = new JTextField();
        panel.add(regField);
        panel.add(new JLabel("Name: "));
        nameField = new JTextField();
        panel.add(nameField);
        panel.add(new JLabel("Dept: "));
        deptField = new JTextField();
        panel.add(deptField);
        panel.add(new JLabel("Roll_no: "));
        rollField = new JTextField();
        panel.add(rollField);
        panel.add(new JLabel("Section: "));
        sectionField = new JTextField();
        panel.add(sectionField);

        panel.add(new JLabel("------------------------------------------------------------"));
        panel.add(new JLabel("------------------------------------------------------------"));

        // row five
        panel.add(new JLabel("Course Name"));
        panel.add(new JLabel("Course Code"));
        // row six
        cNameField = new JTextField();
        panel.add(cNameField);
        cCodeField = new JTextField();
        panel.add(cCodeField);

        // row seven
        panel.add(new JLabel("MTE Marks"));
        panel.add(new JLabel("ETE Marks"));
        // row eight
        MTEField = new JTextField();
        panel.add(MTEField);
        ETEField = new JTextField();
        panel.add(ETEField);

        // row nine
        panel.add(new JLabel("CA1 Marks"));
        panel.add(new JLabel("CA2 Marks"));
        panel.add(new JLabel("CA3 Marks"));
        // row ten
        CA1Field = new JTextField();
        panel.add(CA1Field);
        CA2Field = new JTextField();
        panel.add(CA2Field);
        CA3Field = new JTextField();
        panel.add(CA3Field);

        panel.add(new JLabel(""));
        addButton = new JButton("Feed Marks");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the values from the text fields
                String cCode = cCodeField.getText();
                String cName = cNameField.getText();
                String CA1 = CA1Field.getText();
                String CA2 = CA2Field.getText();
                String CA3 = CA3Field.getText();
                String MTE = MTEField.getText();
                String ETE = ETEField.getText();

                // Perform the operations of your choice

                dispose();

                // Close the window
            }
        });
        panel.add(addButton);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }
}

class UpdateStudentWindow extends JFrame {
    private JTextField regField;
    private JButton findButton;

    public UpdateStudentWindow() {
        super("Update Student");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(new JLabel("Reg Number: "));
        regField = new JTextField();
        panel.add(regField);
        findButton = new JButton("Find");
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the values from the text fields
                String regNumber = regField.getText();
                System.out.println(regNumber);

                // Update the records to the database or file
                // ...

                try {
                    ShowDetailsToUpdate sdtu = new ShowDetailsToUpdate(regNumber);
                    sdtu.setVisible(true);

                } catch (Exception er) {
                    System.out.println(e);
                    System.out.println("Not going well");
                }

                // Close the window
                dispose();
            }
        });
        panel.add(findButton);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
}

class DeleteStudentWindow extends JFrame {
    private JTextField regField;
    private JButton deleteButton;

    public DeleteStudentWindow() {
        super("Delete Student");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(new JLabel("Reg Number: "));
        regField = new JTextField();
        panel.add(regField);
        deleteButton = new JButton("Delete Record");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the values from the text fields
                String regNumber = regField.getText();

                // Update the records to the database or file
                // ...

                Database db = new Database();
                if (db.DeleteStudentRecord(regNumber) > 0)
                    // Close the window
                    dispose();
                else
                    System.out.println("No Record Found");
            }
        });
        panel.add(deleteButton);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
}

class ShowDetailsToUpdate extends JFrame {
    private JTextField nameField;
    private JTextField rollNumberField;
    private JTextField departmentField;
    private JTextField fNameField;
    private JTextField addField;
    private JTextField mobNumberField;
    private JTextField sectionField;
    private JButton updateButton;

    public ShowDetailsToUpdate(String Reg_no) throws SQLException {
        super("Update Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        Database db = new Database();
        ResultSet rs = db.RetrieveRecord(Reg_no);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        // row one
        nameField = new JTextField(rs.getString("name"));
        panel.add(nameField);
        departmentField = new JTextField(rs.getString("Department"));
        panel.add(departmentField);
        // row two
        rollNumberField = new JTextField(rs.getString("Roll_no"));
        panel.add(rollNumberField);
        fNameField = new JTextField(rs.getString("Fathers_name"));
        panel.add(fNameField);
        // row three
        addField = new JTextField(rs.getString("Address"));
        panel.add(addField);
        mobNumberField = new JTextField(rs.getString("Mobile"));
        panel.add(mobNumberField);
        // row four
        sectionField = new JTextField(rs.getString("Section"));
        panel.add(sectionField);
        updateButton = new JButton("Update");
        System.out.println("Hello World");
        updateButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // Get the values from the text fields
                String name = nameField.getText();
                String department = departmentField.getText();
                String rollNumber = rollNumberField.getText();
                String fatherName = fNameField.getText();
                String address = addField.getText();
                String mobNumber = mobNumberField.getText();
                String section = sectionField.getText();

                // Update the student details to the database

                Database db = new Database();
                if (db.UpdateStudentData(Reg_no, name, department, rollNumber, section, fatherName, address,
                        mobNumber) > 0)
                    dispose();

                // Close the window
            }
        });
        panel.add(updateButton);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }
}
