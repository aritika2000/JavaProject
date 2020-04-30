package com.ncu.processor;
import com.ncu.exception.*;
import com.ncu.validators.*;
import java.util.*;
import java.io.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;                // import loger properties 
public class Loginpage 
{
    
    public String[] checkLogin()
    {
        String[] userData=new String[100];                        //String array for username data 
        String[] b=new String[3];
        Scanner k=new Scanner(System.in);
        System.out.println("Enter username");                     //asks username from user
        String usernam= k.nextLine();
        System.out.println("Enter password");                     //asks password from user
        String passwor= k.nextLine();
        String fileName = "C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\configs\\constant\\username.csv";
        File file = new File(fileName);
        int i=0,t=0;
        Properties prop = new Properties();
        FileInputStream input=null; 
        Logger logger = Logger.getLogger(Loginpage.class);
        PropertyConfigurator.configure("C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\configs\\logger\\logger.properties");   // We need to provide file path as the parameter
        try
        {
            input = new FileInputStream("C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\configs\\constant\\exceptions.properties");
            prop.load(input);
            String user[]= new String[100];
            String pass[]= new String[100];
            Filereader fin = new Filereader(file);                            // Filereader reads text files in the default encoding
            BufferedReader bin= new BufferedReader(fin);                    // Always wrap Filereader in BufferedReader
            String data;

            while((data=bin.readLine())!=null)
            {
                userData = data.split(",");                       // , will split username and password into two different strings 
                user[i]=userData[0];
                pass[i]=userData[1];
                i++;
            }
            for(int j=0;j<i;j++)
            {
                if(usernam.equals(user[j]) && pass[j].equals(passwor))                      // checks whether the username and password match 
                {
                    Fileread n1=new Fileread();                                              //importing Fileread class
                    n1.read(usernam);
                    t++;
                    b[0]=usernam;
                    b[1]=passwor;
                }
            }
            if(t==0)
            {
                System.out.println("username and password didnt match");                            //Displays an error message if username and password does not match 
                b[2]="r";
            }      
            else
                b[2]="e";
            
        } 
        catch(IOException e)
        {
       logger.error("\n \n"+e+prop.getProperty("incorrect")+"\n");
        System.out.print(e);
        }      //Exception Handling
        return b;
    }
}
