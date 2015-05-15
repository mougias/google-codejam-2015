package r1a;

import java.io.File;
import java.util.Scanner;

public class B
{

	//public static String fileName = "res/r1a-B-sample.in";
	//public static String fileName = "res/r1a-B-small-attempt0.in";
	public static String fileName = "res/r1a-B-large-practice.in";
	
	
	
	private static int gcd(int a, int b)
	{
	    while (b > 0)
	    {
	        int temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}
	
	private static int lcm(int a, int b)
	{
	    return a * (b / gcd(a, b));
	}

	private static int lcm(int[] input)
	{
	    int result = input[0];
	    for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
	    return result;
	}	
	
	
	
	public static void main(String[] args) throws Exception
	{
		Scanner scanner = new Scanner(new File(fileName));
		
		int T = scanner.nextInt();
		for (int i = 0; i < T; i++)
		{
			int B = scanner.nextInt();
			int N = scanner.nextInt();
			
			int[] in = new int[B];
			int[] start = new int[B];
			int max = 0;
			for (int j = 0; j < B; j++)
			{
				in[j] = scanner.nextInt();
				start[j] = -in[j];
			}

			
			int least = lcm(in);
			int divisor = 0;
			for (int b=0; b < B; b++)
			{
				divisor += least / in[b];
			}
			
			
			//System.out.println(divisor);
			N = N % divisor;
			if (N == 0) N = divisor;
			
			int min = 0;
			int barber = 0;
			int n = 0;
			while (n < N)
			{
				for (int b=0; b<B; b++)
				{
					if (start[b] + in[b] <= min)
					{
						start[b] = min;
						n++;
						barber = b + 1;
						min--;
						break;
					}
				}
				min++;
			}
			
			System.out.println("Case #" + (i+1) + ": " + barber);
		}
		
		scanner.close();
	}

}
