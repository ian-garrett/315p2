package cis315project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Recursive {

	public static List<String> foundWords = new ArrayList<String>();
	
	public static Boolean splitW(String phrase, int i){
		if (phrase.length()==0){
			return true;
		}
		
		int n = phrase.length();
		for (int j=i; j<=n; j++){
			if (Main.dictionary.contains(phrase.substring(0,j))){
				if (splitW(phrase.substring(j),1)){
					foundWords.add(phrase.substring(0,j));
					return true;
				}
			}
		}
	
	return false;
	}
	

}
