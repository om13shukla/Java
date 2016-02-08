import java.util.Scanner;

public class HackerRankProblems {
	
	 /*1> Reverse the integer and then calculate the sum and then reverse the ans
	  * eg; 544,785 ->445+587=1032=2301 */
	 
	public static int reverse(int a){
        int temp=0;
        while(a!=0){
        temp= temp*10+a%10;
        a/=10;
        }
        return temp;
        }

   public void reverseSumIntegers() {
    	System.out.println("Enter two Itegers: ");
		Scanner scn = new Scanner(System.in);
		
    	int input1,input2;
    	
    	input1=scn.nextInt();
    	input2=scn.nextInt();
    	
    	input1=reverse(input1);
    	System.out.println("Reverse 1:= "+input1);
        input2=reverse(input2);
        System.out.println("Reverse 2:= "+input2);
        int sum=input1+input2;
        sum=reverse(sum);
       System.out.println("Reversed SUM of two Reversed integers is= "+sum);     

    }
    
    ///*	2
    
    
   
}
