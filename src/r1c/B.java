package r1c;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class B {

	public static String inFile = "res/B-sample.in";
	
	public static void main(String[] args) throws Exception
	{
		HashMap<Character, Integer> chars;
		
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File(inFile));
		int T = scanner.nextInt();
		
		
		for (int t = 1; t <= T; t++)
		{
			chars = new HashMap<Character, Integer>();
			
			int K = scanner.nextInt();
			int L = scanner.nextInt();
			int S = scanner.nextInt();
			
			String tmp = scanner.nextLine();
			String allChars = scanner.nextLine();
			for (int i=0; i < K; i++)
			{
				char c = allChars.charAt(i);
				if (chars.containsKey(c))
					chars.put(c, chars.get(c) + 1);
				else
					chars.put(c, 1);
			}
			
			String word = scanner.nextLine();
			double out = solve(chars, word, K, S);
			System.out.println("Case #" + t + ": " + out);
		}
		
		scanner.close();
	}

	
	private static double solve(HashMap<Character, Integer> chars, String word, int K, int S)
	{
		if (S < word.length())
			return 0;
		
		for (int i=0; i < word.length(); i++)
		{
			if (!chars.containsKey(word.charAt(i)))
				return 0;
		}

		long totalCombinations = (long) Math.pow(K, S);
		long totalDistinctCombinations = (long) Math.pow(chars.size(), S);
		
		System.out.println("Total combinations = " + totalCombinations);
		System.out.println("Total distinct combinations = " + totalDistinctCombinations);
		
		
		double prob = 1;
		for (int i=0; i < word.length(); i++)
		{
			prob *= chars.get(word.charAt(i)) / (double) K;
		}
		
		double hi = totalDistinctCombinations * prob;
		System.out.println("Prob = " + hi);
		prob *= (S - word.length() + 1);
				
		return (S - word.length() + 1) - ( (S - word.length() + 1) * prob);
		//System.out.println("Correct combinations = " + correctCombinations);
		//return correctCombinations - ((double) correctCombinations / (double) totalDistinctCombinations);
	}
}
