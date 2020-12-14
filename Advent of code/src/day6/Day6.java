package day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day6 {
	public static void main(String args[]) {
	File input = new File("C:\\Users\\pande\\OneDrive\\Desktop\\advent of code\\Advent of code\\src\\day6\\Input");
	try {
		Scanner reader = new Scanner(input);
		int sumOfCounts=0;
		
		String groupAnswers ="";
		
		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			System.out.println(line);
			
			if (line.length()==0) {
				//System.out.println(groupAnswers);
				int num = findNumOfYes2(groupAnswers);
				sumOfCounts = sumOfCounts+num; 
					
				groupAnswers="";
			} else {
				//groupAnswers= groupAnswers + line;
				groupAnswers = groupAnswers+" "+line;
			}
		}
		
		System.out.println(sumOfCounts);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("done");
}

	private static int findNumOfYes2(String groupAnswers) {
		boolean arr[] = new boolean[26];
		
		//System.out.println(groupAnswers);
		
		String str[]= groupAnswers.split(" ");
		
		for (int i=0;i<str.length;i++)
			System.out.println(str[i]);
		
		for (int i=0;i<arr.length;i++)
			arr[i]=false;
		
		for(int i=0;i<str[1].length();i++) {
			char ch = str[1].charAt(i);
			
			/*if (ch==' ')
				break;*/
			
			System.out.print(i+": "+(ch-'a')+" ");
			if (arr[ch-'a']==false){
				int flag=0;
				for (int j=1;j<str.length;j++) {
					if (!str[j].contains(ch+"")) {
						flag=1;
					}
				}
				if (flag==0)
					arr[ch-'a']=true;
			}
		}
		
		int num=0;
		
		for (int i=0;i<arr.length;i++) {
			if (arr[i]) {
				System.out.print(i+" ");
				num++;
			}
		}
		
		System.out.println(num);
		
		return num;
	}

	private static int findNumOfYes(String groupAnswers) {
		boolean arr[] = new boolean[26];
		
		System.out.println(groupAnswers);
		
		for (int i=0;i<arr.length;i++)
			arr[i]=false;
		
		for(int i=0;i<groupAnswers.length();i++) {
			char ch = groupAnswers.charAt(i);
			
			System.out.print((ch-'a')+" ");
			if (arr[ch-'a']==false)
				arr[ch-'a']= true;
		}
		
		int num=0;
		
		for (int i=0;i<arr.length;i++) {
			if (arr[i]) {
				System.out.print(i+" ");
				num++;
			}
		}
		
		System.out.println(num);
		
		return num;
	}
}
