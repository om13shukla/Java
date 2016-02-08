import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AllArrayProg {
	
	
	int [] arr2=new int[5];
	int [] arr3= new int[5];
	
	int i,j,k,x;
	
	
	
	
	void FindMissing(int[] arr1, int n){
		 for(i=0;i<arr1.length-1;i++){
			x+=arr1[i];			
		 }
		 Integer s=(n*(n-1))/2;
		 System.out.println(s.toString());
		 
		 if(x==s)
		 { System.out.println("No extra or duplicate lement");}
		 else if(x<s)
			 {int l=s-x; System.out.println("duplicate elements :"+l );} 
		 else if(x>s)
			 {int m=x-s; System.out.println(" extra or duplicate lement: "+m);}
		 
		 
	 }
	
	int SecondLargest(int [] arr1){
		int l=0,i,j,k=0;
			
		for(i=0;i<arr1.length;i++){
				if(l<arr1[i])
				{ l=arr1[i];	}
			
			}
		System.out.println("Largest element is: "+l);
		for(i=0;i<arr1.length;i++){
			if(l==arr1[i])
				arr1[i]=0;	
		}
		
		 
		for(i=0;i<arr1.length;i++){
			if(l<arr1[i])
			{ l=arr1[i];	}
		
		}
		return l;
		
	}
	
	void daigonalDiff(){
		System.out.println("Enter length  of an array 'n' ie: n X n ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("Array will be of size: "+n+"X"+n );
        int a[][] = new int[n][n];
        int d1=0,d2=0,r=0;
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
            	System.out.print(a[a_i][a_j]+" ");
            }
            System.out.println(" ");
        }
            for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                if(a_i==a_j){d1+=a[a_i][a_j];}
                if(a_i+a_j==n-1){d2+=a[a_i][a_j];}
                
            }
            
            }
                r=Math.abs(d2-d1);
                System.out.println("Diagonal diff = "+r);
        
    
	
}

		
	
}
