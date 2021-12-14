package probset2;

import java.util.Scanner;

public class NumberThree {
	
	public char getCharAtK (String str, int k) {
		
		return str.charAt(k);
	}
	
	public String laughterMaker(String str1, String str2, int i) {
		String strCombined = str1 + str2;
		
		if(i == 0)
			strCombined = str1;
		else if(i == 1) 
			strCombined = str2;
		else
			strCombined = laughterMaker(str2, strCombined, i - 1);
		
		return strCombined;
	}
	
	public static void main(String[] args) {
	
		Scanner scFromUser = new Scanner(System.in);
		
		String scanned = scFromUser.nextLine();
		Scanner scToParse = new Scanner(scanned);
		
		NumberThree n3 = new NumberThree();
		
		int i, k;
		
		i = scToParse.nextInt();
		k = scToParse.nextInt();
		
		scFromUser.close();
		scToParse.close();
		
		System.out.println(n3.laughterMaker("H", "A", i));
		System.out.println(n3.getCharAtK(n3.laughterMaker("H", "A", i), k));
	}
}
