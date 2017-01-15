	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		AllStringProg sp=new AllStringProg();
		AllArrayProg ar= new AllArrayProg();
		HackerRankProblems hc= new HackerRankProblems();
		int opt=1;
		Scanner scn = new Scanner(System.in);
			
				
				
		{	
				System.out.println("Enter Option 0 to exit ");
				System.out.println("1: Generate Permutations");
				System.out.println("2: Check Palindrome");
				System.out.println("3: Remove Char from String");
				System.out.println("4: Find Missing element in Array");
				System.out.println("5: Daigonal Diff of Given Array");
				System.out.println("6: Reversed SUM of two Reversed integers");
				System.out.println("7: Most Frequent CHar: ");
				opt=scn.nextInt();
				
				switch (opt) {
				case 1:												//1:Palindrome
					
					System.out.println("Enter String \n");
					scn = new Scanner(System.in);
					String s1=scn.next();
					Set<String> set1 = sp.generatePerm(s1);
					System.out.println(set1.toString());
					break;
					
				case 2: 
					sp.CheckPalindrome();
					break;
						
				case 3: 
					sp.RemoveChar();
					break;	
					
				case 4: 
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					 System.out.println("Enter length of an array ");
				        int n= Integer.parseInt(br.readLine());
				        int [] arr1= new int[n];
				        
				        System.out.println("enter array elements");
				        for (int j = 0; j < n ; j++) {
			                int k = Integer.parseInt(br.readLine());
			                arr1[j] = k;
			                }	
				        
				 
					ar.FindMissing(arr1,n);
					System.out.println(ar.SecondLargest(arr1));
					break;	
				case 5:
					ar.daigonalDiff();
					break;
				case 6:
					hc.reverseSumIntegers();
					break;
				case 7:
					sp.findMostFrequentChar();
					break;	
				default:
					System.out.println("Enter Options.");
					break;
				}
				
				
			}	
		
			
		

			
	}

	

}
