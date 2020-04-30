package com.ncu.main;
import com.ncu.exception.*;
import com.ncu.validators.*;
import com.ncu.processor.*;
import java.io.*;
import java.util.*;
public class mainclass
{
	public static void main(String[] args) 
	{
		Scanner io=new Scanner(System.in);
		String[] c;
		int check=0,work=0,t;
		first o1=new first();
		c=o1.firstpage();
		if(c[2].equals("r"))
		{
			work++;
		}
		else if(!c[2].equals("e"))
		{
			Loginpage l=new Loginpage();
			c=l.checkLogin();
			check++;
		}
		if(work==0)
		{
			if(check!=0)
			{
				todolist o3=new todolist();
				o3.enterlist(c[0]);
				Fileread o2=new Fileread();
				o2.read(c[0]);
			}
		do
		{
			Menu o4=new Menu();
			o4.menushow(c[0]);
			System.out.println("Enter 1 to choose again");
			t=io.nextInt();
		}
		while(t==1);
		}
	}
}