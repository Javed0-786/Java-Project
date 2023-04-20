import java.sql.*;

public class Database {
    static final String DB_URL = "jdbc:mysql://localhost:3306/University";
    static final String USER = "root";
    static final String PASS = "root";

    int InsertStudentData(String Name, String Department, String Reg_no, String Roll_no, String Section,
            String Fathers_name, String Address, String Mobile) {
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String sql = "Insert Into Student (Name, Department, Reg_no, Roll_no, Section, Fathers_name, Address, Mobile) VALUES ( '"
                    + Name + "', '" + Department + "', '" + Reg_no + "', '" + Roll_no + "', '" + Section + "', '"
                    + Fathers_name + "', '" + Address + "', '" + Mobile + "')";

            i = stmt.executeUpdate(sql);

            System.out.println("Created table in given databaase...");
        } catch (Exception e) {
            System.out.println(e);
        }
        return i;
    }

    ResultSet RetrieveRecord(String Reg_no) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "SELECT * FROM Student WHERE Reg_no = '" + Reg_no + "'";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                return resultSet;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    int UpdateStudentData(String Reg_no, String Name, String Department, String Roll_no, String Section,
            String Fathers_name, String Address, String Mobile) {
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String sql = "UPDATE Student SET Name = '" + Name + "', Department = '" + Department
                    + "', Roll_no = '" + Roll_no + "', Section = '" + Section + "', Fathers_name = '" + Fathers_name
                    + "', Address = '" + Address + "', Mobile = '" + Mobile + "' WHERE Reg_no = '" + Reg_no + "'";

            i = stmt.executeUpdate(sql);

            System.out.println("Updated the details in the table...");
        } catch (Exception e) {
            System.out.println(e);
        }
        return i;
    }

    int DeleteStudentRecord(String Reg_no) {
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM Student WHERE Reg_no = '" + Reg_no + "' ";

            i = stmt.executeUpdate(sql);
            if (i > 0)
                System.out.println("Deleted Record in from databaase...");
        } catch (Exception e) {
            System.out.println(e);
        }

        return i;
    }

    public static void main(String str[]) throws SQLException {
        Database db = new Database();

        // ResultSet rs = db.RetrieveRecord("12108088");
        // System.out.println(rs.getString("Name"));

        // db.UpdateStudentData("12108088", "Aftab", "MEC", "20", "RJ", "Razzak Ali",
        // "Pratappur", "9984526525");

        db.DeleteStudentRecord("12105585");
    }
}
