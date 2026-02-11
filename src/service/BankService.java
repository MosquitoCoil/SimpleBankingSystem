/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Account;

/**
 *
 * @author ROCO
 */
public abstract class BankService {
    public abstract Object execute(Account acc) throws Exception;
}
