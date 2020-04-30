package com.ncu.processor;
import com.ncu.exception.*;
import com.ncu.validators.*;
import java.util.*;
import java.io.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;        //imports properties file

public class Signuppage
{
	public void signup()
	{
		String name,username,pass;          //users name ,username and password
		boolean b;
		Scanner take = new Scanner(System.in);
		System.out.println("Enter your name");
		name=take.nextLine();
		System.out.println("Enter your username");
		username =take.nextLine();
		System.out.println("Enter password");
		pass=take.nextLine();
		userNamevalidator d= new userNamevalidator(username,pass);
		b=d.usernameValidator();
		Properties prop = new Properties();           //imports properties class
		FileInputStream input=null; 
		Logger logger = Logger.getLogger(Signuppage.class);
		PropertyConfigurator.configure("C:\\Users\\tusha_000\\Desktop\\Unguided Project\\configs\\logger\\logger.properties");     // We need to provide file path as the parameter
		if(b==true)
		{
			String todo;
			todo="C:\\Users\\tush_000\\Desktop\\Push\\todo\\"+username+".txt";            // We need to provide file path as the parameter
			File f=null;
			File fc=null;
			try
			{
				input = new FileInputStream("C:\\Users\\tusha_000\\Desktop\\Unguided Project\\configs\\constant\\exceptions.properties");   
                                                                                                                                     // We need to provide file path as the parameter
			prop.load(input);
				fc = new File(todo);                   //new todolist file
				f= new File("data.csv");                //adds username in csv file
				FileWriter fout = new FileWriter(f);
	            BufferedWriter writer = new BufferedWriter(fout);
				String[] data1 = {username,",",pass}; 
		        writer.write(data1[0]);                    //writes to do list serial wise
		        writer.write(data1[1]);
		        writer.write(data1[2]);
		    }
		    catch(Exception e)
		    {
		    	logger.error("\n \n"+e+prop.getProperty("incorrect")+"\n");
		    	System.out.println(e);
		    }                                                                      //exception handling
		}
	}
}