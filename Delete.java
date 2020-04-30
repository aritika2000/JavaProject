package com.ncu.processor;
import com.ncu.exception.*;
import com.ncu.validators.*;
import java.util.*;
import java.io.*;   
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;               //imports loger properties

public class Delete 
{ 
    public void Deletelist(String username)
    { 
      Scanner sc = new Scanner(System.in);
      int done ;
      System.out.println("TO DO LIST");
      fileread n1 = new fileread();                     // Imports fileread class
      n1.read(username);
      System.out.println("Enter the value of the task to be Deleted");                   //Asks the Serial no of the task to be Deleted
      done = sc.nextInt();
      Properties prop = new Properties();
    FileInputStream input=null; 
    Logger logger = Logger.getLogger(Delete.class);
    PropertyConfigurator.configure("C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\configs\\logger\\logger.properties");    // We need to provide file path as the parameter
        try
        {
          input = new FileInputStream("C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\configs\\constant\\exceptions.properties");
      prop.load(input);

        File file = new File("C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\todo\\"+username+".txt");         // We need to provide file path as the parameter
        File temp= new File("C:\\Users\\tusha_000\\Desktop\\ultimate\\Unguided Project\\todo\\temp.txt");                 // We need to provide file path as the parameter
        FileReader fin = new FileReader(file);                        // FileReader reads text files in the default encoding.
        BufferedReader bin = new BufferedReader(fin);              // Always wrap FileReader in BufferedReader
        FileWriter fout = new FileWriter(temp);
        BufferedWriter bout= new BufferedWriter(fout);
        String a,tempa;
        int i=1;
          while((a=bin.readLine()) !=null)                
            {
              if(i>done)
              {
                String k=Integer.toString(i);             //converts integer to java string
                int t=i-1;
                String b=Integer.toString(t);              //converts integer to java string
                tempa=a.replaceFirst(k,b);
                bout.write(tempa);
                bout.write("\n");
              }
            else if(i==done);
            else{
              bout.write(a);
              bout.write("\n");
            }
            i++;
            }
            bout.close();            //Close the input stream 
        bin.close();                       //Close the input stream
         fin = new FileReader(temp);
        bin = new BufferedReader(fin);
        fout = new FileWriter(file);
        bout= new BufferedWriter(fout);
        while((a=bin.readLine()) !=null)                // the line is not a null line 
        {
          bout.write(a);
          bout.write("\n");
        }
        bout.close();                     //Close the input stream
        bin.close();                    //Close the input stream
        temp.Delete();
        System.out.println("TO DO LIST");
        n1.read(username);
      }
      catch(IOException e)
      {

      logger.error("\n \n"+e+prop.getProperty("incorrect")+"\n");
          System.out.println(e);
      }        //Exception Handling 
    } 
} 