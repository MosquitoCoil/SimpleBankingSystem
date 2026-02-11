package util;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import util.DBConnection;

public class DisplayTable {

    public static void accountTable(JTable accounts, JFrame frame) {
        try {
            
            Connection conn = DBConnection.connect();
            if (conn == null) {
                JOptionPane.showMessageDialog(frame, "Failed to connect to database");
                return;
            }

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM accounts");
            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) accounts.getModel();

            model.setRowCount(0);

            if (model.getColumnCount() == 0) {
                model.addColumn("ID");
                model.addColumn("Name");
                model.addColumn("Balance");
            }

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double balance = rs.getDouble("balance");
                model.addRow(new Object[]{id, name, balance});
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
        }
    }
}
