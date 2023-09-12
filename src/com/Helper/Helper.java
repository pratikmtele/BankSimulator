package com.Helper;

public class Helper {

    // validate first name
    public static boolean firstName(String firstName) {
        return firstName.matches("[A-Z][a-z]*");
    }

    // validate last name
    public static boolean lastName(String lastName) {
        return lastName.matches("[A-Z][a-z]*");
    }

    //Validate mobile number
    public static boolean isvalidmobileno(String mobileno) {
        boolean f = false;
        String[] strnumber = {mobileno};
        String strPattern = "^[0-9]{10}$";
        for (String number : strnumber) {
            if (!number.matches(strPattern)) {
                f = false;
                break;
            } else {
                f = true;
            }
        }
        return f;
    }
    //validate Email Address
      public static boolean isValidEmail(String email)
    {
        String regex = "^(.+)@(.+)$";
        boolean f = false;
        String []emails = {email};
        for(String emailss:emails){
            if(!emailss.matches(regex))
                f = false;
            else
                f = true;
        }
        return f;
    }
}
