package cis315project2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {
	
	public static Set<String> dictionary = new HashSet<String>();
	
	public static void loadDictionary(String dictionaryFileName) {
		File inFile = new File(dictionaryFileName);
		try {
		Scanner scan = new Scanner(inFile); String line;
		while (scan.hasNext()) { line = scan.next();
		dictionary.add(line.trim()); }//while
		scan.close(); } //try block
		catch (FileNotFoundException e) { e.printStackTrace();
		}
		}//load dictionary
	
	
	public static void main(String[] args) throws IOException{
		
//		handle input
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

//        int C = Integer.parseInt(in.readLine());
//        System.out.println(in.readLine());
	   
		
		
		
		
		loadDictionary("diction10k.txt");
		
		
		String phrase = "themanandthefanareinabandandiamaniceguywholikestoeatfries";
		
		System.out.println("phrase number: (ADD)");
		System.out.println(phrase+"\n");
		
		//recursive attempt
		System.out.println("recursive attempt:");
		if (Recursive.splitW(phrase,1)){
			System.out.println("YES, can be split");
			
			Collections.reverse(Recursive.foundWords);
			for (String word: Recursive.foundWords){
				System.out.print(word+" ");
			}
			
		}
		else {
			System.out.println("NO, cannot be split");
		}
		
		//iterative attempt
		System.out.println("\n\niterative attempt:");
		if (Iterative.iterative(phrase)){
			System.out.println("YES, can be split");
			
			for (Pair word: Iterative.foundWordsRec){
				System.out.print(word.word+" ");
			}
			
		}
		else {
			System.out.println("NO, cannot be split");
		}
		
		
		
		
	}
	
}
