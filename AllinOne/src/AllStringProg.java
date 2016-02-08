import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AllStringProg {

	String s1,s2,temp;
	int i=0,j=0,k=0,l;
	char c1,c2;
	char[] ch1;
	private Scanner scn;
	
	public void CheckPalindrome(){
		System.out.println("Enter a string:");
		
		Scanner scn = new Scanner(System.in);
		s1=scn.next();
		
		ch1=s1.toCharArray();
		j=ch1.length-1;
		temp= new StringBuffer(s1).reverse().toString();
		
		while(i<ch1.length-1){
			c1=ch1[i];
			ch1[i]=ch1[j];
			ch1[j]=c1;
			j--;
			i++;
		}
		
		for(i=0;i<ch1.length-1;i++){System.out.println(ch1[i]+"");}
		
		if(s1.equals(temp))
		System.out.println("Yes it is a palindrome : "+ s1 +" -->"+ temp);
		else
		System.out.println("NOt a palindrome"+ s1 +" -->"+ temp);
		scn.close();
		
		
	}
	
		void RemoveChar(){
		System.out.println("Enter String");
		scn = new Scanner(System.in);
		s1=scn.next();
		System.out.println("ENter a charter to remove");
		temp=scn.next();
		c1=temp.charAt(0);
		s2= new StringBuffer(s1).toString();
		
		if(s2.contains(temp)){
		s1=s2.replace(c1,c2);
		System.out.println(s1);
			}
		scn.close();
		}
		
		
		public static Set<String> generatePerm(String input)
		{
		    Set<String> set = new HashSet<String>();
		    if (input == "")
		        return set;

		    Character a = input.charAt(0);

		    if (input.length() > 1)
		    {
		        input = input.substring(1);

		        Set<String> permSet = generatePerm(input);

		        for (String x : permSet)
		        {
		            for (int i = 0; i <= x.length(); i++)
		            {
		                set.add(x.substring(0, i) + a + x.substring(i));
		            }
		        }
		    }
		    else
		    {
		        set.add(a + "");
		    }
		    return set;
		}
		
		static String findMostFrequentChar(String inputString) {
	        String smax="";
	       Character s1;
	        
	        int c=0,max=0;
	        for(int i=0;i<inputString.length();i++){
	            
	            s1=inputString.charAt(i); 
	            
	            for(int k=0;k<inputString.length();k++){
	                
	                
	                if(s1==inputString.charAt(k)){
	                    c++;
	                 }
	                if(c > max){smax=""; smax=new StringBuilder().append(s1).toString();System.out.println(s1); max=c;}
	            }                        
	            System.out.print(s1);
	            System.out.print(c);
	            
	            
	           
	            c=0;
	            //{smax="as ";}
	        }
	    return smax;
	    }
		
		
		
		

}
