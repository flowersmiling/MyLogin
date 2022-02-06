/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Administrator
 */
public class AccountService 
{

    public AccountService() {
    }
    
    public User login(String name,String password)
    {
        User usr;
        
        if(name.equals("abe") && password.equals("password")){
            usr = new User(name,password);
        }else if(name.equals("barb") && password.equals("password")){
            usr = new User(name,password);
        }else{
            usr = null;
        }
       
        return usr;
    }
}
