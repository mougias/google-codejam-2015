package qual;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class QualB
{
	//private static final String fileName = "res/B-sample.in";
	//private static final String fileName = "res/B-small-attempt0.in";
	//private static final String fileName = "res/B-small-attempt1.in";
	//private static final String fileName = "res/B-small-attempt2.in";
	//private static final String fileName = "res/B-small-attempt3.in";
	//private static final String fileName = "res/B-small-attempt4.in";
	//private static final String fileName = "res/B-small-attempt5.in";
	//private static final String fileName = "res/B-small-attempt6.in";
	//private static final String fileName = "res/B-small-attempt7.in";
	//private static final String fileName = "res/B-small-attempt8.in";
	//private static final String fileName = "res/B-small-attempt9.in";
	//private static final String fileName = "res/B-small-attempt10.in";
	//private static final String fileName = "res/B-small-attempt11.in";
	//private static final String fileName = "res/B-small-attempt12.in";
	private static final String fileName = "res/B-small-attempt13.in";
	
	private static BufferedReader br;
	
	public static void main(String[] args) throws Exception
	{
		
		br = new BufferedReader(new FileReader(fileName));

		// number of test-cases
		int T = Integer.valueOf(br.readLine());
		
		// process each case
		for (int t=0; t < T; t++)
		{
			int D = Integer.valueOf(br.readLine());
			String in = br.readLine();
			ArrayList<Integer> P = new ArrayList<Integer>();
			
			String inSplit[] = in.split(" ");
			for (int i = 0; i < D; i++)
			{
				int v = Integer.valueOf(inSplit[i]); 
				P.add(v);
				//System.out.print("" + v + " ");
			}
			//System.out.println();
			
			processCase(t+1, D, P);
		}
		
		br.close();
	}
	
	
	public static void processCase(int t, int D, ArrayList<Integer> P) throws Exception
	{
		int mins = 0;
		while (true)
		{
			while (P.contains(0))
			{
				P.remove(new Integer(0));
			}

			int max = 0;
			int maxIndex = -1;
			int secondMax = -1;
			int count = 0;
			for (int i = 0; i < P.size(); i++)
			{
				int v = P.get(i);
				if (v > max)
				{
					secondMax = max;
					maxIndex = i;
					max = v;
					count = 1;
				}
				else if (v == max)
				{
					count++;
				}
				else if (v > secondMax)
				{
					secondMax = v;
				}
			}

			if (max == 0)
				break;
			
			mins++;

			// decision time
			// if first max is 2 or more higher then she will delay us by more than 1 minute, so split
			// otherwise om nom nom time
			if (max % 2 == 0 && max >= Math.pow(2, count) && max / 2 > secondMax)
			{
				//System.out.println("Minute " + mins + ". Split " + max + " at position " + maxIndex);
				P.set(maxIndex, max / 2);
				P.add(max / 2);
			}
			else
			{
				//System.out.println("Minute " + mins + " Do nothing. ");
				for (int i = 0; i < P.size(); i++)
				{
					if (P.get(i) > 0)
					{
						P.set(i, P.get(i) - 1);
					}
				}
			}
		}
		
		System.out.println("Case #" + t + ": " + mins);
	}

}
