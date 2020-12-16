package day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day9 {
	public static void main(String args[]) {
		File input = new File("C:\\Users\\pande\\OneDrive\\Desktop\\advent of code\\Advent of code\\src\\day9\\Input");
		try {
			Scanner reader = new Scanner(input);
			ArrayList arr = new ArrayList<Double>();
			
				while (reader.hasNextLine()) {
					String line = reader.nextLine();
					//System.out.println(line);
					arr.add(Double.parseDouble(line));
				}
				
				//double notSum = findNotSum(arr);
				//System.out.println(notSum);
				System.out.println(findNotSum2(arr));

			
			//System.out.println(num);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("done");
	}

	private static double findNotSum(ArrayList arr) {
ArrayList sumOf = new ArrayList<Double>();
		
		for (int i=0;i<25;i++) {
			sumOf.add(arr.get(i));
		}
		
		for (int i=25;i<arr.size();i++) {
			double sum = (double) arr.get(i);
			int f=0;
			for (int j=0;j<25;j++) {
				for (int k=j+1;k<25;k++) {
					if ((double)sumOf.get(j)+ (double)sumOf.get(k) == sum) {
						sumOf.remove(0);
						sumOf.add(sum);
						f=1;
						break;
					}
				}
				if (f==1)
					break;
			}
			if (f==0)
				return sum;
		}
		
		return -1;
	}

	private static double findNotSum2(ArrayList arr) {
		ArrayList sumOf = new ArrayList<Double>();
		int index = -1;
		
		for (int i=0;i<25;i++) {
			sumOf.add(arr.get(i));
		}
		
		for (int i=25;i<arr.size();i++) {
			double sum = (double) arr.get(i);
			int f=0;
			
			for (int j=0;j<25;j++) {
				for (int k=j+1;k<25;k++) {
					if ((double)sumOf.get(j)+ (double)sumOf.get(k) == sum) {
						sumOf.remove(0);
						sumOf.add(sum);
						f=1;
						index=i;
						break;
					}
				}
				if (f==1)
					break;
			}
			if (f==0) {
				System.out.println("sum="+sum);
				
				
				for (int j1=0;j1<index;j1++) {
					ArrayList sumOf2 = new ArrayList<Double>();
					double sum2 = (double)arr.get(j1)+(double)arr.get(j1+1);
					sumOf2.add(arr.get(j1));
					sumOf2.add(arr.get(j1+1));
					for (int l=0;l<sumOf2.size();l++) {
						//System.out.println(sumOf2.get(l));
					}
					int k=j1+2;
					while (sum2<sum && k<index) {
						sum2 = sum2 + (double) arr.get(k);
						sumOf2.add(arr.get(k));
						k++;
					}
					if (sum2==sum) {
						for (int l=0;l<sumOf2.size();l++) {
							//System.out.println(sumOf2.get(l));
						}
						return (double)sumOf2.get(0) + (double)sumOf2.get(sumOf2.size()-1);
					}
				}
				return sum;
			}
			}
		
		return -1;
	}
	
	/*
	private static double findNotSum() {
		if (f==0) {
			System.out.println(sum);
			ArrayList sumOf2 = new ArrayList<Double>();
			
			for (int j1=0;j1<24;j1++) {
				double sum2 = (double)sumOf.get(j1)+(double)sumOf.get(j1+1);
				sumOf2.add(sumOf.get(j1));
				sumOf2.add(sumOf.get(j1+1));
				for (int l=0;l<sumOf2.size();l++) {
					//System.out.println(sumOf2.get(l));
				}
				int k=j1+2;
				while (sum2<sum && k<sumOf.size()) {
					sum2 = sum2 + (double) sumOf.get(k);
					sumOf2.add(sumOf.get(k));
					k++;
				}
				if (sum2==sum) {
					for (int l=0;l<sumOf2.size();l++) {
						System.out.println(sumOf2.get(l));
					}
					return (double)sumOf2.get(0) + (double)sumOf2.get(sumOf2.size()-1);
				}
			}
			return sum;
		}
		}
	}
	}*/
}
