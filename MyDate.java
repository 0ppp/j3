
import java.io.*;

class Invalid_Date_Exception extends Exception
{
	public Invalid_Date_Exception(String s1)
  	{
    		System.out.println(s1);
  	}
}

class Invalid_Month_Exception extends Exception
{
	public Invalid_Month_Exception(String s2)
  	{
		System.out.println(s2);
  	}
}
class MyDate
{
	int d,m,y;
	public MyDate()
  	{
		d=0;
    		m=0;
    		y=0;
  	}
	public MyDate(int d,int m,int y)
  	{
    		this.d=d;
    		this.m=m;
    		this.y=y;
  	}
	public void check()
  	{
    		try
    		{
      			if(d<1 || d>31)
			throw new Invalid_Date_Exception("Date is invalid");
    		}
    		catch(Invalid_Date_Exception ide)
    		{
      			System.out.println(ide);
    		}
    		try
    		{
      			if(m<1 || m>12)
        		throw new Invalid_Month_Exception("Month is invalid");
    		}  
    		catch(Invalid_Month_Exception ime)
    		{
      			System.out.println(ime);
    		}	
	}
	public void valid()
	{
		if(d>=1 && d<=31 && m>=1 && m<=12)
    		System.out.println("Date is valid");
    		else
    		System.out.println("Date is Invalid");
  	}
	public static void main(String args[])
  	{
    		int d=Integer.parseInt(args[0]);
    		int m=Integer.parseInt(args[1]);
    		int y=Integer.parseInt(args[2]);
    		MyDate md=new MyDate(d,m,y);
    		md.check();
    		md.valid();
  	}
}
