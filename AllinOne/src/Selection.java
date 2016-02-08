import java.util.Scanner;
import java.util.Stack;

public class Selection {
	
	public static void main(String[] args) {
    	Scanner sc= new Scanner(System.in);
    	String s1= sc.nextLine();
        if(braceMatch(s1)){System.out.println("TRUE");}
        else {System.out.println("FALSE");}
     
    }

	public static boolean braceMatch(String str) {
	    if (str.charAt(0) == '{')
	        return false;

	    Stack <Character> stack = new Stack<Character>();

	    char c;
	    for(int i=0; i < str.length(); i++) {
	        c = str.charAt(i);
	        
	        switch(c)
	        { 	case '(':
	        	case '{':
	        	case '[': stack.push(c);
	        		break;
	        	case ')':								//for ()
	        		if(stack.empty())
		                return false;
		            else if(stack.peek() == '(')
		                stack.pop();
		            else
		                return false;
	        		break;
	        		
	        	case '}':									//for {}
	        		if(stack.empty())
		                return false;
		            else if(stack.peek() == '{')
		                stack.pop();
		            else
		                return false;
	        		break;	
	        		
	        	case ']':										//for []
	        		if(stack.empty())
		                return false;
		            else if(stack.peek() == '[')
		                stack.pop();
		            else
		                return false;
	        		break;
	        		
	        }
	        
	    }
	    return stack.empty();
	}
	
}
