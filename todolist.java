package com.ncu.processor;
import com.ncu.exception.*;
import com.ncu.validators.*;
import java.io.*;
import java.util.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class todolist
{
	public void enterlist(String username)
  	{
  		String todo ="C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\todo\\"+username+".txt";
  		File f=null;
  		Properties prop = new Properties();       
		FileInputStream input=null; 
		Logger logger = Logger.getLogger(todolist.class);
		PropertyConfigurator.configure("C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\configs\\logger\\logger.properties");
                                                                                                                                      // We need to provide file path as the parameter
		try
		{
			input = new FileInputStream("C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\configs\\constant\\exceptions.properties");
                                                                                                                                     // We need to provide file path as the parameter
			prop.load(input);
			f = new File(todo);
			int length ;
			Scanner input2 = new Scanner(System.in);
			System.out.println("How many tasks you want to add?");
			length = input2.nextInt();
		    String[] names = new String[length] ;
			for(int count = 0 ; count < length ; count++)
			{
				System.out.println("Enter the task" +(count+1));             //new task entry
				names[count] = input2.next() ;
			}
			FileWriter fout = new FileWriter(f);
			BufferedWriter bout= new BufferedWriter(fout);  
			for(int i=0;i<length;i++)
			{
				bout.write((i+1)+" Pending -> "+names[i]);
				bout.newLine();
			}
			bout.close();                  //close input stream
		}
		catch(IOException e)
		{logger.error("\n \n"+e+prop.getProperty("incorrect")+"\n");
			System.out.println(e);
		}                                                  //Exception Handling 
	}
}