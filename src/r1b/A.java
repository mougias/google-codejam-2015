package r1b;

import java.io.File;
import java.util.Scanner;

public class A {

	public static String inFile = "res/A.sample";
	//public static String inFile = "res/A-small-attempt2.in";


	public static int reverse (int n)
	{
		int out = 0;
		while (n / 10 > 0)
		{
			out = out * 10 + n % 10;
			n = n / 10;
		}
		out = out * 10 + n;
		return out;
	}
	
	
	private static int solve2(int n)
	{
		int out = 0 ;
		int a = 0;
		while (a < n)
		{
			out++;
			a++;
			if (n - a > n - reverse(a))
			{
				a = reverse(a);
			}
		}
		
		return out;
	}
	
	private static int solve(int n)
	{
		if (n < 20)
		{
			return n;
		}
		else if (n < 100)
		{
			return (n / 10 + 10 + n % 10);
		}
		else
		{
			int out = 28;
			int a = n;
			int b = 1;
			while (a > 1000)
			{
				a = a / 10;
				b++;
				out += Math.pow(10, b) + 8;
			}

			int first = n / (int) Math.pow(10, b+1);
			int second = reverse(n / (int) Math.pow(10, b+1));

			if (n % 10 != 0)
			{
				out += Math.min(first, second);
			}
			else
			{
				out += first;
			}
			out += n % Math.pow(10, b+1) - 1;
			return out;			
		}
		
	}

	public static void run() throws Exception
	{
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File(inFile));
		int T = scanner.nextInt();
		
		for (int t = 1; t <= T; t++)
		{
			int in = scanner.nextInt();
			int out = solve2(in);
			System.out.println("Case #" + t + ": " + out);
		}
		
		scanner.close();
	
		
		
	}
	public static void main(String[] args) throws Exception
	{
		//System.out.println(solve(435));
		 run();
	}

}
