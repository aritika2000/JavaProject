package com.ncu.processor;
import com.ncu.exception.*;
import com.ncu.validators.*;
import java.io.*;
import java.io.*;
import java.util.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;     // import loger properties 

public class Fileread
{
	public void read(String username) 
	{
		
		File f=null;
		Properties prop = new Properties();
		FileInputStream input=null; 
		Logger logger = Logger.getLogger(Fileread.class);
		PropertyConfigurator.configure("C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\configs\\logger\\logger.properties");
		try 
		{
			input = new FileInputStream("C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\configs\\constant\\exceptions.properties");
      prop.load(input);
	        String todo;
			todo="C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\todo"+username+".txt";      // We need to provide file path as the parameter
			f = new File(todo);
		    Filereader fin = new Filereader(f);              // Filereader reads text files in the default encoding.
		    BufferedReader bin = new BufferedReader(fin);          // Always wrap Filereader in BufferedReader
			String a;                                           
	        while((a=bin.readLine()) !=null)                   // the line is not a null line 
	            System.out.println(a);                           //printing the todo list
		}
	    catch(IOException e)
	    {logger.error("\n \n"+e+prop.getProperty("incorrect")+"\n");
	    	System.out.println(e);
	    }           // Exception Handling
    }
}