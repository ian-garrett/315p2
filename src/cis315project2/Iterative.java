package cis315project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Iterative {
	
	public List<String> words = new ArrayList<String>();
	public static List<Pair> foundWordsRec = new ArrayList<Pair>();

	static boolean iterative(String x) {
		int i = 0;
		for(int j = 1; j<x.length();j++)
		{
			if(Main.dictionary.contains(x.substring(i, j)))
			{
				foundWordsRec.add(new Pair(i, x.substring(i, j)));
//				System.out.print(x.substring(i, j)+" ");
				i = j;
			}
		}
		while(i!=x.length())
		{
			if(foundWordsRec.isEmpty())
				return false;
			Pair temp = foundWordsRec.remove(foundWordsRec.size()-1);
//			System.out.println(foundWordsRec.get(foundWordsRec.size()-1).word);
			i = temp.loc;
			int k = temp.word.length()+i+1;
			for(;k<=x.length();k++)
			{
				if(Main.dictionary.contains(x.substring(i, k)))
				{
					foundWordsRec.add(new Pair(i, x.substring(i, k)));
//					System.out.println(x.substring(i, k)+" ");
					i = k;
				}
			}
		}
		return true;
	}
	public static void displayWords() {
		/*Collections.reverse(words)`;
		for(String w: words)
			System.out.print(w+" ");
		System.out.println();*/
		int length = foundWordsRec.size();
//		for(Pair p: foundWordsRec){
		for(int i=0; i<length/2;i++){
			System.out.print(foundWordsRec.get(i).word+" ");
		}
		System.out.println();
		
//		for(Pair p: foundWordsRec)
//		{
//			System.out.print(p.word+" ");
//		}
//		System.out.println();
	}
}