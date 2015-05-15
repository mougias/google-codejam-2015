package qual;

import java.io.BufferedReader;
import java.io.FileReader;

public class QualA
{

	private static final String fileName = "res/A-large.in";
	private static BufferedReader br;
	
	public static void main(String[] args) throws Exception
	{
		br = new BufferedReader(new FileReader(fileName));

		// number of test-cases
		int T = Integer.valueOf(br.readLine());
		
		// process each case
		for (int i=0; i < T; i++)
		{
			String in = br.readLine();
			processCase(i+1, in);
		}
		
		br.close();
	}
	
	
	public static void processCase(int t, String in) throws Exception
	{
		int Smax = Integer.valueOf(in.substring(0, in.indexOf(' ')));
		String Sin = in.substring(in.indexOf(' ') + 1);
		int S[] = new int[Smax + 1];
		int N[] = new int[Smax + 1];
		long total = 0;
		long needed = 0;
		// read and process input
		for (int i = 0; i <= Smax; i++)
		{
			S[i] = Integer.valueOf(Sin.substring(i, i+1));
			if (total < i)
			{
				N[i] =  (int) (i - total);
				needed += N[i];
				total += N[i];
			}
			
			total += S[i];
		}
		
		System.out.println("Case #" + t + ": " + needed);
	}

}
