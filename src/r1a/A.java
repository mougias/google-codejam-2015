package r1a;

import java.io.File;
import java.util.Scanner;

public class A
{

	//public static String fileName = "res/r1a-A-sample.in";
	//public static String fileName = "res/r1a-A-small-attempt0.in";
	//public static String fileName = "res/r1a-A-small-attempt1.in";
	public static String fileName = "res/r1a-A-large.in";
			
	
	public static long solveFirst(int[] m)
	{
		long out = 0;
		int start = 0;		
		for (int i = 0; i < m.length; i++)
		{
			if (m[i] > start)
			{
				start = m[i];
			}
			else
			{
				out += (start - m[i]);
				start = m[i];
			}
		}
		return out;
	}
	
	
	public static long solveSecond(int[] m)
	{
		// max difference is at least 1 rate
		int maxDiff = 0;
		long out = 0;
		for (int i = 0; i < m.length - 1; i++)
		{
			if ( (m[i] - m[i+1] > maxDiff))
			{
				maxDiff = (m[i] - m[i+1]);
			}
		}
		
		long rate = maxDiff;
		for (int i = 0; i < m.length - 1; i ++)
		{
			out += Math.min(rate, m[i]);
		}
		
		return out;
	}
	
	public static void main(String[] args) throws Exception
	{
		Scanner scanner = new Scanner(new File(fileName));
		
		int T = scanner.nextInt();
		for (int i = 0; i < T; i++)
		{
			int N = scanner.nextInt();
			int[] in = new int[N];
			for (int j = 0; j < N; j++)
			{
				in[j] = scanner.nextInt();
			}
			
			long y = solveFirst(in);
			long z = solveSecond(in);
			
			System.out.println("Case #" + (i+1) + ": " + y + " " + z);
		}
		
		scanner.close();
	}

}
