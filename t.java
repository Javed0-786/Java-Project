public class t {
    public static void main(String str[]) {
        String Name = "ABC";
        String Department = "ABC";
        String Roll_no = "ABC";
        String Section = "ABC";
        String Fathers_name = "ABC";
        String Address = "ABC";
        String Mobile = "ABC";
        String Reg_no = "ABC";
        String sql = "UPDATE Student SET Name = '" + Name + "', Department = '" + Department
                + "', Roll_no = '" + Roll_no + "', Section = '" + Section + "', Fathers_name = '" + Fathers_name
                + "', '" + Address + "', Mobile = '" + Mobile + "' WHERE Reg_no = '" + Reg_no + "'";
        System.out.println(sql);
    }
}
