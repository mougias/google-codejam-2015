package qual;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QualC
{
	//private static final String fileName = "res/C-sample.in";
	//private static final String fileName = "res/C-small-attempt0.in";
	private static final String fileName = "res/C-large.in";
	
	private static BufferedReader br;
	
	private static HashMap<String, HashMap<String, String>> charsMap;
	
	public static void main(String[] args) throws Exception
	{
		
		createMap();
		
		br = new BufferedReader(new FileReader(fileName));

		// number of test-cases
		int T = Integer.valueOf(br.readLine());
		
		// process each case
		for (int t=0; t < T; t++)
		{
			long L, X;
			String LX[] = br.readLine().split(" ");
			L = Long.valueOf(LX[0]);
			X = Long.valueOf(LX[1]);
			
			String in = br.readLine();
			processCase(t+1, L, X, in);
		}
		
		br.close();
	}
	
	
	public static void processCase(int t, long L, long X, String in)
	{
		long endI = -1, endJ = - 1;
		
		while (true)
		{
			long cursor = 0;
			char i = '1';
			char j = '1';
			char k = '1';
			char working = 'i';
			boolean negative = false;
			for (int x = 0; x < X; x++)
			{
				for (int l = 0; l < L; l++)
				{
					if (working == 'i')
					{
						String tmp = multiply(i, in.charAt(l)); 
						i = tmp.charAt(tmp.length()-1);
						if (tmp.length() == 2)
						{
							negative = !negative;
						}
					}
					else if (working == 'j')
					{
						String tmp = multiply(j, in.charAt(l)); 
						j = tmp.charAt(tmp.length()-1);
						if (tmp.length() == 2)
						{
							negative = !negative;
						}
					}
					else if (working == 'k')
					{
						String tmp = multiply(k, in.charAt(l)); 
						k = tmp.charAt(tmp.length()-1);
						if (tmp.length() == 2)
						{
							negative = !negative;
						}
					}
					
					if (!negative)
					{
						if (working == 'i' && i == 'i' && cursor > endI)
						{
							working = 'j';
							endI = cursor;
							endJ = cursor;
						}
						else if (working == 'j' && j == 'j' && cursor > endJ)
						{
							working = 'k';
							endJ = cursor;
						}
					}
					
					cursor++;
				}
				
			}
			
			System.out.println(negative);
			System.out.println(working);
			if (!negative && k == 'k')
			{
				System.out.println("Case #" + t + ": YES");
				break;
			}
			else if (working == 'i')
			{
				System.out.println("Case #" + t + ": NO");
				break;
			}
			else if (working == 'j')
			{
				endI++;
			}
		}
		
	}
	
	private static void createMap()
	{
		charsMap = new HashMap<String, HashMap<String, String>>();
		HashMap<String, String> tmpMap;

		tmpMap = new HashMap<String, String>();
		tmpMap.put("1", "1");
		tmpMap.put("i", "i");
		tmpMap.put("j", "j");
		tmpMap.put("k", "k");
		charsMap.put("1", tmpMap);
		
		tmpMap = new HashMap<String, String>();
		tmpMap.put("1", "i");
		tmpMap.put("i", "-1");
		tmpMap.put("j", "k");
		tmpMap.put("k", "-j");
		charsMap.put("i", tmpMap);
		
		tmpMap = new HashMap<String, String>();
		tmpMap.put("1", "j");
		tmpMap.put("i", "-k");
		tmpMap.put("j", "-1");
		tmpMap.put("k", "i");
		charsMap.put("j", tmpMap);
		
		tmpMap = new HashMap<String, String>();
		tmpMap.put("1", "k");
		tmpMap.put("i", "j");
		tmpMap.put("j", "-i");
		tmpMap.put("k", "-1");
		charsMap.put("k", tmpMap);
	}
	
	private static String multiply(char a, char b)
	{
		String sa = "" + a;
		String sb = "" + b;
		return charsMap.get(sa).get(sb);
	}
	
}
