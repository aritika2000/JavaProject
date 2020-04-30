package com.ncu.processor;
import com.ncu.exception.*;
import com.ncu.validators.*;
import java.util.*;
public class Menu 
{
    public void menushow(String username) 
    {
    Scanner sc= new Scanner(System.in);
    int num;
    System.out.println("Enter 1. To add something to do list\nEnter 2. To update to do list\nEnter 3. To Delete something from to do list\n");   //presents menu to user
      num = sc.nextInt();
       switch(num)            //using switch case 
        {
            case 1 : 
            {
            	    Add a=new Add();                // imports add class
                    a.addlist(username);
                    break;                         // exit the loop
            }
            case 2 :
            {
                    Update a =new Update();           // imports update class
                    a.updatelist(username);
           }
            case 3 :
            {
                    Delete a=new Delete();
                    a.Deletelist(username);
                    break;              // exit the loop
            }
            default:
                System.out.println("You have entered wrong choice");            // Displays message for entering wrong choice 
                 
        }
    }
}    
