package day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8 {
	public static void main(String args[]) {
		File input = new File("C:\\Users\\pande\\OneDrive\\Desktop\\advent of code\\Advent of code\\src\\day8\\Input");
		try {
			Scanner reader = new Scanner(input);
			
			/* PART 1
			int acc=0;
			int lineno=0;
			String arr[] = new String[624];
			boolean visited[] = new boolean[624];
			
				while (reader.hasNextLine()) {
					String line = reader.nextLine();
					//System.out.println(line);
					arr[lineno]= line;
					lineno++;
				}
				
				lineno=0;
				
				do {
					System.out.println(arr[lineno]);
					if (visited[lineno])
						break;
					visited[lineno] = true;
					String s[]= arr[lineno].split(" ");
					if (arr[lineno].contains("acc")) {
						acc = acc + Integer.parseInt(s[1]);
						lineno++;
					} else if (arr[lineno].contains("jmp")) {
						lineno += Integer.parseInt(s[1]);
					} else {
						lineno++;
					}
				} while(lineno!=0);
				
			System.out.println(acc);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("done");
		*/
			
			//part 2
			
			int acc=0;
			int lineno=0;
			String arr[] = new String[624];
			boolean visited[] = new boolean[624];
			int indexLastNopOrJmp = -1;
			
				while (reader.hasNextLine()) {
					String line = reader.nextLine();
					//System.out.println(line);
					arr[lineno]= line;
					lineno++;
				}
				
				lineno=0;
				
				do {
					System.out.println(arr[lineno]);
					if (visited[lineno]) {
						/*lineno = indexLastNopOrJmp;
						if (arr[lineno].contains("jmp"))
							arr[lineno] = arr[lineno].replace("jmp", "nop");
						else
							arr[lineno] = arr[lineno].replace("nop", "jmp");
						System.out.println(arr[lineno]);*/
						break;
					}
					visited[lineno] = true;
					String s[]= arr[lineno].split(" ");
					if (arr[lineno].contains("acc")) {
						//acc = acc + Integer.parseInt(s[1]);
						lineno++;
					} else if (arr[lineno].contains("jmp")) {
						if (Integer.parseInt(s[1])<0)
							indexLastNopOrJmp = lineno;
						lineno += Integer.parseInt(s[1]);
					} else {
						indexLastNopOrJmp = lineno;
						lineno++;
					}
				} while(lineno!=0);
				
				for (int i=0;i<arr.length;i++) {
					if (visited[i] && (arr[i].contains("jmp") || arr[i].contains("nop"))) {
						if (arr[i].contains("jmp"))
							arr[i] = arr[i].replace("jmp", "nop");
						else
							arr[i] = arr[i].replace("nop", "jmp");
						int f=0;
						lineno=0;
						acc=0;
						boolean visited2[] = new boolean[624];
						do {
							System.out.println(arr[lineno]);
							if (visited2[lineno]) {
								/*lineno = indexLastNopOrJmp;
								if (arr[lineno].contains("jmp"))
									arr[lineno] = arr[lineno].replace("jmp", "nop");
								else
									arr[lineno] = arr[lineno].replace("nop", "jmp");
								System.out.println(arr[lineno]);*/
								f=1;
								break;
							}
							visited2[lineno] = true;
							String s[]= arr[lineno].split(" ");
							if (arr[lineno].contains("acc")) {
								acc = acc + Integer.parseInt(s[1]);
								lineno++;
							} else if (arr[lineno].contains("jmp")) {
								if (Integer.parseInt(s[1])<0)
									indexLastNopOrJmp = lineno;
								lineno += Integer.parseInt(s[1]);
							} else {
								indexLastNopOrJmp = lineno;
								lineno++;
							}
						} while(lineno<624);
						
						if (f==1) {
							if (arr[i].contains("jmp"))
								arr[i] = arr[i].replace("jmp", "nop");
							else
								arr[i] = arr[i].replace("nop", "jmp");
							//System.out.println(arr[lineno]);
						} else {
							System.out.println(arr[i]);
							break;
						}
					}
				}
			System.out.println(acc);
			
			/*lineno=0;
			visited = new boolean[624];
			
			do {
				//System.out.println(arr[lineno]);
				/*if (visited[lineno]) {
					break;
				}
				visited[lineno] = true;
				String s[]= arr[lineno].split(" ");
				if (arr[lineno].contains("acc")) {
					acc = acc + Integer.parseInt(s[1]);
					lineno++;
				} else if (arr[lineno].contains("jmp")) {
					lineno += Integer.parseInt(s[1]);
				} else {
					lineno++;
				}
			} while(lineno!=0);
			
		System.out.println(acc);*/
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("done");
		
	}
}
