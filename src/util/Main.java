package util;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DBConnection conn = new DBConnection();
        conn.connect();
        new ui.LoginFrame().setVisible(true);
    }
}
