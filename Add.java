package com.ncu.processor;
import com.ncu.exception.*;
import com.ncu.validators.*;
import java.io.*;
import java.util.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;        //importing loger properties
public class Add
{
	public void addlist(String username)
  	{
  		String todo ="C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\todo"+username+".txt";         //path of file
  		File f=null;
  		Properties prop = new Properties();
		FileInputStream input=null; 
		Logger logger = Logger.getLogger(Add.class);
		PropertyConfigurator.configure("C:\\Users\\tusha_000\\Desktop\\Unguided Project\\configs\\logger\\logger.properties");
		try
		{
			input = new FileInputStream("C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\configs\\constant\\exceptions.properties");
			prop.load(input);
			f = new File(todo);
			int length;              
			Scanner input1 = new Scanner(System.in);
		    String names;
			System.out.println("Enter the task");             //asking the user to enter the task to add
			names=input1.nextLine();
			FileWriter fout = new FileWriter(f,true);                 //the true will append the new data
			BufferedWriter bout= new BufferedWriter(fout);
			BufferedReader reader = new BufferedReader(new Filereader(f));
			int lines = 0;
			while (reader.readLine() != null) {
		    lines++;
			}
			reader.close();
			bout.append((lines+1)+" Pending -> "+names);
			bout.append("\n");            //appends the string to the file
			bout.close();          // end of writeToFile()
		}
		catch(IOException e)
		{
			logger.error("\n \n"+e+prop.getProperty("incorrect")+"\n");
			System.out.println(e);
		}               //exception handling 
	}
}