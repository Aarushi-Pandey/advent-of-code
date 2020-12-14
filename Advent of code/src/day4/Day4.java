package day4;

import java.util.*;
import java.io.*;

public class Day4 {
	public static void main(String args[]) {
		File input = new File("C:\\Users\\pande\\OneDrive\\Desktop\\advent of code\\Advent of code\\src\\day4\\Input");
		try {
			Scanner reader = new Scanner(input);
			int numOfValidPasswords=0;
			
			String passport ="";
			
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				//System.out.println(line);
				
				if (line.length()==0) {
					int valid = isValidPassport2(passport);
					numOfValidPasswords = numOfValidPasswords+valid; 
						
					passport="";
				} else {
					passport= passport + " "+ line;
				}
			}
			
			System.out.println(numOfValidPasswords);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("done");
	}

	private static int isValidPassport(String passport) {
		if (passport.contains("byr") && passport.contains("iyr") && passport.contains("eyr") && passport.contains("hgt") && passport.contains("hcl") && passport.contains("ecl") && passport.contains("pid"))
			return 1;
			return 0;
	}
	
	private static int isValidPassport2(String passport) {
		if (passport.contains("byr") && passport.contains("iyr") && passport.contains("eyr") && passport.contains("hgt") && passport.contains("hcl") && passport.contains("ecl") && passport.contains("pid")) {
			String arr[] = passport.split("[ :]");
			/*for (int i=0;i<arr.length;i++) {
				System.out.println(arr[i]);
			}*/
			
			int valid = 1; 
			System.out.println("valid=1 init");
			for (int i =1;i<arr.length;i=i+2) {
				System.out.println(arr[i]);
				if (arr[i].equals("byr")) {
					if (arr[i+1].length()==4) {
						int byr = Integer.parseInt(arr[i+1]);
						if (byr >=1920 && byr <=2002)
							valid=1;
						else {
							valid =0;
							break;
						}
						System.out.println("valid:"+valid);
					}
				} else if (arr[i].equals("iyr")) {
					if (arr[i+1].length()==4) {
						int byr = Integer.parseInt(arr[i+1]);
						if (byr >=2010 && byr <=2020)
							valid=1;
						else {
							valid =0;
							break;
						}
						System.out.println("valid:"+valid);
					}
				} else if (arr[i].equals("eyr")) {
					if (arr[i+1].length()==4) {
						int byr = Integer.parseInt(arr[i+1]);
						if (byr >=2020 && byr <=2030)
							valid=1;
						else {
							valid =0;
							break;
						}
						System.out.println("valid:"+valid);
					}
				} else if (arr[i].equals("hgt")) {
					System.out.println(!arr[i+1].contains("cm") && !arr[i+1].contains("in"));
					if (!arr[i+1].contains("cm") && !arr[i+1].contains("in")) {
						valid=0;
						break;
					}
					int num = Integer.parseInt(arr[i+1].substring(0, arr[i+1].length()-2));
					//String unit = arr[i+1].substring(arr[i+1].length()-3);
					
					System.out.println(num);
					if (arr[i+1].contains("cm") && num >=150 && num <=193) {
						valid=1;
					} else if (arr[i+1].contains("in") && num >=59 && num <=76) {
						valid=1;
					} else {
						valid =0;
						break;
					}
					System.out.println("valid:"+valid);
					
				} else if (arr[i].equals("hcl")) {
					String num = arr[i+1].substring(1);
					
					if (arr[i+1].charAt(0)=='#' && arr[i+1].length()==7) {
						for (int j=0;j<num.length();j++) {
							char c= num.charAt(j);
							if ((c>='0' && c<='9') || (c>='a' && c<='f'))
								valid=1;
							else {
								valid=0;
								break;
							}
						}
						valid=1;
					} else {
						valid =0;
						break;
					}
					System.out.println("valid:"+valid);
					
				} else if (arr[i].equals("ecl")) {
					String eyecolor=arr[i+1];
					
					if (eyecolor.equals("amb") || eyecolor.equals("blu") || eyecolor.equals("brn") || eyecolor.equals("gry") || eyecolor.equals("grn") || eyecolor.equals("hzl") || eyecolor.equals("oth")) {
						valid=1;
					} else {
						valid=0;
						break;
					}
					
					System.out.println("valid:"+valid);
					
				} else if (arr[i].equals("pid")) {
					if (arr[i+1].length()==9) {
						for (int j=0;j<9;j++) {
							if (arr[i+1].charAt(j) >='0' && arr[i+1].charAt(j) <='9')
								valid=1;
							else {
								valid=0;
								break;
							}
						}
					} else {
						valid=0;
						break;
					}
					
					System.out.println("valid:"+valid);
				}
			}
			
			return valid;
		}
			return 0;
	}
}
