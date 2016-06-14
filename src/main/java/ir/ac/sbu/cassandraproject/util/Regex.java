/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.sbu.redisproject.util;

/**
 *
 * @author Shirin
 */
public class Regex {

    //http://www.mkyong.com/regular-expressions/how-to-validate-username-with-regular-expression/
    public static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";

    //http://www.mkyong.com/regular-expressions/how-to-validate-password-with-regular-expression/
    public static final String PASSWORD_PATTERN
            = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    //http://www.mkyong.com/regular-expressions/how-to-validate-email-address-with-regular-expression/
    public static String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            //= "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";
}
