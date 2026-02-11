package service;

import model.Account;
import util.DBConnection;
import java.sql.*;

public class BalanceService extends BankService {

    @Override
    public Object execute(Account acc) throws Exception {
        Connection con = DBConnection.connect();
        PreparedStatement ps = con.prepareStatement(
            "SELECT balance FROM accounts WHERE id = ?"
        );
        ps.setInt(1, acc.getId());
        ResultSet rs = ps.executeQuery();

        double balance = 0.0;
        if (rs.next()) {
            balance = rs.getDouble("balance");
        } else {
            con.close();
            throw new Exception("Account not found");
        }

        con.close();
        return balance; 
    }

    public double getBalance(int accountId) throws Exception {
        Account acc = new Account(accountId, 0); 
        return (double) execute(acc);
    }
}
