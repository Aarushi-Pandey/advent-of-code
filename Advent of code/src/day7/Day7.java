package day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day7 {
	public static void main(String args[]) {
		File input = new File("C:\\Users\\pande\\OneDrive\\Desktop\\advent of code\\Advent of code\\src\\day7\\Input");
		try {
			Scanner reader = new Scanner(input);
			
			ArrayList arr = new ArrayList<String>();
			arr.add("shiny gold bag");
			
			int num=0;
			int c=0;
			
			//for (int i=0;i<2;i++) {
			do {
				int l= arr.size();
				while (reader.hasNextLine()) {
					String line = reader.nextLine();
					//System.out.println(line);
			
					int f= containsShinyGoldBag(arr, line, l);
					//System.out.println(f);
					num=num+f;
				}
				c= arr.size()-l;
				
				for (int j=0;j<arr.size();j++) {
					System.out.println(arr.get(j));
				}
				
				for (int j=0;j<l;j++) {
					System.out.println("in for loop");
					arr.remove(0);
				}
				reader = new Scanner(input);
			} while (c!=0);
			
			//idk y my answer is wrong- too high apparently
			
			System.out.println(num);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("done");
	}

	private static int containsShinyGoldBag(ArrayList arr, String line, int l) {
		String str[]= line.split("contain ");
		
		//System.out.println(str[0]);
		str[0]= str[0].substring(0,str[0].length()-2);
		//System.out.println(str[0]);
		
		int f=0;
		/*for(int i=0;i<str.length;i++)
			System.out.println(str[i]);*/
		
		String s[]= str[1].split(", ");
		s[s.length-1]= s[s.length-1].substring(0,s[s.length-1].length()-1);
		
		//System.out.println(s[s.length-1]);
		for(int i=0;i<s.length;i++){
			//System.out.println(s[i]);
			//System.out.println(s[i].contains("shiny gold bag"));
				for (int j=0;j<l;j++) {
					if (s[i].contains((String)arr.get(j))) {
						System.out.println("str[0]="+str[0]);
						arr.add(str[0]);
						f=1;
						break;
					}
				}
			if (f==1)
				break;
		}
		
		return f;
		
	}
}
