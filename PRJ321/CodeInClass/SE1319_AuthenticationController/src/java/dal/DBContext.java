/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import model.Account;

/**
 *
 * @author sonnt
 */
public class DBContext {
    public Account getAccountByUsernameAndPassword(String username,String password)
    {   Account account = new Account();
        if(username.equals("sonnt") && password.equals("123"))
        {
            account.setUsername(username);
            account.setPassword(password);
            account.setDisplayName("Ngo Tung Son");
            return account;
        } 
        return null;
    }
}
