package com.ncu.processor;
import com.ncu.exception.*;
import com.ncu.validators.*;
import java.util.*;
public class first
{
    public String[] firstpage() 
    {
    Scanner sc= new Scanner(System.in);
    int num;
    System.out.println("Enter 1. to Signup\nEnter 2. to Login");                          //presents menu to user
      num = sc.nextInt();
      String te[]=new String[3];
       switch(num)                    //using switch case 
        {
            case 1 : 
            {
            	    Signuppage s=new Signuppage();         // imports Signuppage class 
                    te=s.signup();
                    break;                     // exit the loop
            }
            case 2 :
            {
                    Loginpage s=new Loginpage();     //imports Loginpage class
                    te=s.checkLogin();
                    break;                  // exit the loop
            }
            default:
                System.out.println("You have entered wrong choice");                 // Displays message for entering wrong choice 
        } 
        return te;
    }
}    