package service;

import model.Account;
import util.DBConnection;
import java.sql.*;

public class WithdrawService extends BankService {
    public Object execute(Account acc) throws Exception {
        Connection con = DBConnection.connect();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE accounts SET balance = balance - ? WHERE id = ?"
        );
        ps.setDouble(1, acc.getBalance());
        ps.setInt(2, acc.getId());
        ps.executeUpdate();
        con.close();
        return null;
    }
}
