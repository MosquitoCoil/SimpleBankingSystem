package service;

import model.Account;
import util.DBConnection;
import java.sql.*;

public class CreateAccountService extends BankService {
    public Object execute(Account acc) throws Exception {
        Connection conn = DBConnection.connect();
        PreparedStatement ps = conn.prepareStatement(
            "INSERT INTO accounts(name, balance) VALUES (?, ?)"
        );
        ps.setString(1, acc.getName());
        ps.setDouble(2, acc.getBalance());
        ps.executeUpdate();
        conn.close();
        return null;
    }
}
