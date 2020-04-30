package com.ncu.processor;
import com.ncu.exception.*;
import com.ncu.validators.*;
import java.util.*;
import java.io.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;      //imports loger properties
public class Update
{
	void updatelist(String username)
	{
		Scanner sc=new Scanner(System.in);
		int done;
		System.out.println("TO DO LIST");
		Fileread n1=new Fileread();                                           // Imports Fileread class
		n1.read(username);
		System.out.println("Enter the value of done task");                       //Asks the Serial no of the task completed
		done=sc.nextInt();
		String list,temp;
		list="C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\todo\\"+username+".txt";
		temp= "C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\todo\\temp.txt";
		File f=null,t=null;
			Properties prop = new Properties();
		FileInputStream input=null; 
		Logger logger = Logger.getLogger(Update.class);
		PropertyConfigurator.configure("C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\configs\\logger\\logger.properties");
		try
		{
			input = new FileInputStream("C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\configs\\constant\\exceptions.properties");
			prop.load(input);
			f=new File(list);
			t=new File(temp);
			Filereader fin=new Filereader(f);                      //Reading all the lines of input text file into oldContent
			BufferedReader bin= new BufferedReader(fin);
			FileWriter fout = new FileWriter(t);
        	BufferedWriter bout= new BufferedWriter(fout);
			String a;
			int i=1,h=0;
			while((a=bin.readLine())!=null)
			{
				if(i==done)
				{
					String tempa=a.replaceFirst("Pending","Done");                // Will change Pending to done 
							bout.write(tempa);
							bout.write("\n");
							h++;
				}
				else
				{
					bout.write(a);
					bout.write("\n");
				}
				i++;          //increment i
			}
			bin.close();                      //Close the input stream
			bout.close();                     //Close the input stream
			fin = new Filereader(t);
	        bin = new BufferedReader(fin);
	        fout = new FileWriter(list);
	        bout= new BufferedWriter(fout);
	        while((a=bin.readLine()) !=null)
	        {
	          bout.write(a);                 
	          bout.write("\n");
	        }
	        bout.close();                        //Close the input stream
	        bin.close();                             //Close the input stream
	        t.Delete();
			if(h==0)
			{
				System.out.println("Wrong input");            //prints error message for wrong input
			}
			else
			{
				System.out.println("TO DO LIST"); 
			    n1.read(username);
			}
		}
		catch(IOException e)
		{
			logger.error("\n \n"+e+prop.getProperty("incorrect")+"\n");
			System.out.println(e);
		}      //Exception Handling      
	}
}