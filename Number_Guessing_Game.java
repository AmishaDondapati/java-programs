package java_tasks;
import java.util.Scanner;
import java.util.Random;
public class Number_Guessing_Game
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();
		int randnum=rand.nextInt(100)+1;
		int userguess=0;
		int attempts=0;
		
		System.out.println("WELCOME TO NUMBER GUESSING GAME...");
		System.out.println("Guess a number between 1 to 100");
		
		do
		{
			try
			{
				System.out.print("Enter your guess number : ");
				userguess=sc.nextInt();
				if(userguess>100)
					throw new InvalidInputException();
				attempts++;
				
				if(userguess < randnum)
					System.out.println("Lower Number.");
				else if(userguess > randnum)
					System.out.println("Higher Number.");
				else if(userguess == randnum)
				{
					System.out.println("congratulations...! You guessed the number");
					System.out.println("Total attempts :"+attempts);
					sc.close();
				}

			}
			catch(Exception e)
			{
					System.out.println("Invalid type of Input");
					break;
			}
		}while(userguess!=randnum);	
	}
}

class InvalidInputException extends RuntimeException
{
	InvalidInputException()
	{
		super();
	}
}
