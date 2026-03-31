package java_tasks;
import java.util.Scanner;
public class Temperature_converter 
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		String choice;
		System.out.println("====TEMPERATURE CONVERSION====");
		do
		{
			System.out.println();
			System.out.println("1.Fahrenheit"+"\t"+"  2.Celsius");
			System.out.print("Enter your scale : ");
			int scale=sc.nextInt();
			System.out.print("Enter temperature value : ");
			double value=sc.nextDouble();
			
			if(scale==1)
			{
				double output=Temperature_converter.celsius(value);
				System.out.println("FAHRENHEIT TO CELSIUS : "+value+" -> "+output);
			}
			else if(scale==2)
			{
				double output=Temperature_converter.fahrenheit(value);
				System.out.println("CELSIUS TO FAHRENHEIT: "+value+" -> "+output);
			}
			else
				System.out.println("Invalid input type");
			
			System.out.println("Do you want to continue : yes  no");
			choice=sc.next();
			if(choice.equals("no"))
			{
				sc.close();
				System.exit(0);
			}
		}
		while(choice.equals("yes"));
	}


	public static double celsius(double fah)
	{
		double c=(fah-32)*5/9;
		return c;
	}
	public static double fahrenheit(double ces)
	{
		double f=(ces*9/5)+32;
		return f;
	}
}
